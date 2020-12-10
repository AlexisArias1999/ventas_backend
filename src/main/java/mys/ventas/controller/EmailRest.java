package mys.ventas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mys.ventas.models.entity.Email;
import mys.ventas.models.services.IEmailService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class EmailRest {

	@Autowired
	private IEmailService emailService;

	@PostMapping("/email/send")
	@ResponseBody
	public boolean SendEmail(@RequestBody Email email) {
		return emailService.sendEmail(email);
	}

}
