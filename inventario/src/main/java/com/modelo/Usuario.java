package com.modelo;

import static javax.persistence.GenerationType.SEQUENCE;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {
	
	@Id
	@Column(name="id")
	@SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ", initialValue = 1, allocationSize=100)
	@GeneratedValue(strategy = SEQUENCE, generator = "USER_SEQ")
	private Long id;
	
	@Column(name="cod_cia") // Hacer relación
	@NotNull
	private String cod_cia;
	
	@Column(name="usuario")
	@NotNull
	private String usuario;
	
	@Column(name="contrasena")
	@NotNull
	private String contrasena;
	
	@Column(name="nombres")
	@NotNull
	private String nombres;
	
	@Column(name="correo")
	@NotNull
	private String correo;
	
	@Column(name="estado") // Hacer relación
	@NotNull
	private String estado;
	
	@Column(name="fecha_nacimiento")
	@NotNull
	private LocalDate fecha_nacimiento;
	
	@Column(name="fecha_registro")
	private LocalDateTime fecha_registro;
	
	@Column(name="fecha_modificacion")
	private LocalDateTime fecha_modificacion;
	
	@Column(name="usuario_registro")
	private String usuario_registro;
	
	@Column(name="usuario_modifico")
	private String usuario_modifico;
	
	@Column(name="rol") // Cambiar luego por la clase ROL
	private String rol;
	
	@Column(name="imagen_url")
	private String imagen_url;
	
	private String token;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCod_cia() {
		return cod_cia;
	}

	public void setCod_cia(String cod_cia) {
		this.cod_cia = cod_cia;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public LocalDateTime getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(LocalDateTime fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public LocalDateTime getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(LocalDateTime fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

	public String getUsuario_registro() {
		return usuario_registro;
	}

	public void setUsuario_registro(String usuario_registro) {
		this.usuario_registro = usuario_registro;
	}

	public String getUsuario_modifico() {
		return usuario_modifico;
	}

	public void setUsuario_modifico(String usuario_modifico) {
		this.usuario_modifico = usuario_modifico;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getImagen_url() {
		return imagen_url;
	}

	public void setImagen_url(String imagen_url) {
		this.imagen_url = imagen_url;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}