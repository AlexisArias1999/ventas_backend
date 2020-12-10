package mys.ventas.models.implement;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import mys.ventas.models.entity.Email;
import mys.ventas.models.services.IEmailService;

@Service
public class EmailServiceImplements implements IEmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public boolean sendEmail(Email email) {
		return sendEmailTool(email.getContent(), email.getEmail(), email.getSubject());
	}

	private boolean sendEmailTool(String textMessage, String email, String subject) {
		boolean send = false;
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			Path rutaArchivo = null;
			rutaArchivo = Paths.get("src/main/resources/static/archivos").resolve("imagen.jpg").toAbsolutePath();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			//FileSystemResource res = new FileSystemResource(new File("c:/Users/xavie/Downloads/cabeza.jpg"));
			//FileSystemResource res = new FileSystemResource(new File("c:/Users/xavie/Downloads/hello.pdf"));
			//FileSystemResource res = new FileSystemResource(new File("c:/Users/xavie/Downloads/excel.xlsx"));
			FileSystemResource res = new FileSystemResource(new File(rutaArchivo.toString()));
			System.out.println(rutaArchivo.toString());
			helper.setTo(email);
			helper.setText(textMessage, true);
			helper.setSubject(subject);
			helper.setText("<html><body><img src='cid:imagen'></body></html>", true);
			//helper.setText("<html><body><iframe src='cid:word'></iframe></body></html>", true);
			//helper.addInline("hello", res);
			helper.addInline("imagen", res);
			javaMailSender.send(message);
			send = true;
			System.out.print("Email enviado.");
		} catch (MessagingException e) {
			System.out.print("Hubo problemas al enviar el correo. " + e);
		}
		return send;
	}

}
