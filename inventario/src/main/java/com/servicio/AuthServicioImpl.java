package com.servicio;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.exceptions.SpringRedditException;
import com.dto.RegisterRequest;
import com.modelo.NotificationEmail;
import com.modelo.Usuarios;
import com.modelo.VerificationToken;
import com.repositorio.UsuarioRepositorio;
import com.repositorio.VerificationTokenRepositorio;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.util.Constants;

@Service
@AllArgsConstructor
@Transactional
public class AuthServicioImpl implements AuthServicio {
	
	private final UsuarioRepositorio usuarioRepositorio;
	private final PasswordEncoder passwordEncoder;
	private final VerificationTokenRepositorio verificationTokenRepositorio;
	private final MailContentBuilder mailContentBuilder;
	private final MailService mailService;

	@Override
	public void signup(RegisterRequest registerRequest) {
		
		Usuarios usuario = new Usuarios();
		usuario.setUsuario(registerRequest.getUsuario());
		usuario.setCorreo(registerRequest.getCorreo());
		usuario.setContrasena(encodePassword(registerRequest.getContrasena()));
		usuario.setEstado(registerRequest.getEstado());
		usuario.setCod_cia(registerRequest.getCod_cia());
		usuario.setCreated(Instant.now());
		usuario.setEnabled(false);
		
		usuarioRepositorio.save(usuario);
		
		String token = generateVerificationToken(usuario);
		
		String message = mailContentBuilder.build("Thank you for signing up to Spring Reddit, please click on the below url to activate your account : "
                + Constants.ACTIVATION_EMAIL + "/" + token);
		
		mailService.sendMail(new NotificationEmail("Por favor activar tu cuenta", usuario.getCorreo(), message));
		
	}
	
	private String generateVerificationToken(Usuarios usuarios) {
		
		String token = UUID.randomUUID().toString();
		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setToken(token);
		verificationToken.setUsuarios(usuarios);
		verificationTokenRepositorio.save(verificationToken);
		
		return token;
		
	}
	
	private String encodePassword(String password) {
		return passwordEncoder.encode(password);
	}
	
	public void verifyAccount(String token) {
		Optional<VerificationToken> verificationTokenOptional = verificationTokenRepositorio.findByToken(token);
		verificationTokenOptional.orElseThrow(() -> new SpringRedditException("Invalid Token"));
		fetchUserAndEnable(verificationTokenOptional.get());
		}
	
	private void fetchUserAndEnable(VerificationToken verificationToken) {
		String username = verificationToken.getUsuarios().getUsuario();
		Usuarios usuarios = usuarioRepositorio.findByUsuario(username).orElseThrow(() -> new SpringRedditException("User Not Found with id - " + username));
		usuarios.setEnabled(true);
		usuarioRepositorio.save(usuarios);
		}
}