package mys.ventas.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import mys.ventas.models.entity.Cotizacion;
import mys.ventas.models.entity.Venta;

public class Email {

	public void EmailVenta(FileSystemResource fileSR, Venta venta, String mensaje, JavaMailSender javaMailSender) {
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(venta.getCliente().getCorreo());
			helper.setText("Venta: " + venta.getDocumento().getDescripcion() + " " + venta.getNro_documento(), true);
			helper.setSubject(venta.getDocumento().getDescripcion());
			helper.addAttachment(
					venta.getDocumento().getDescripcion().replace(" ", "") + "-" + venta.getNro_documento() + ".pdf",
					fileSR.getFile());
			javaMailSender.send(message);
		} catch (MessagingException e) {
			System.out.println(e);
		}
	}
	
	public void EmailCotizacion(FileSystemResource fileSR, Cotizacion cotizacion, String mensaje, JavaMailSender javaMailSender) {
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(cotizacion.getCliente().getCorreo());
			helper.setText("Venta: " + cotizacion.getDocumento().getDescripcion() + " " + cotizacion.getNro_documento(), true);
			helper.setSubject(cotizacion.getDocumento().getDescripcion());
			helper.addAttachment(
					cotizacion.getDocumento().getDescripcion().replace(" ", "") + "-" + cotizacion.getNro_documento() + ".pdf",
					fileSR.getFile());
			javaMailSender.send(message);
		} catch (MessagingException e) {
			System.out.println(e);
		}
	}

}
