package com.servicio;

import com.dto.RegisterRequest;

public interface AuthServicio {
	
	public void signup (RegisterRequest registerRequest);
	
	public void verifyAccount(String token);
	
}
