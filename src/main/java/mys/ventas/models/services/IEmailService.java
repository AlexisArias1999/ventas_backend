package mys.ventas.models.services;

import mys.ventas.models.entity.Email;

public interface IEmailService {
	
	public boolean sendEmail(Email email);
	
}
