package mys.ventas.models.implement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.ICotizacionDAO;
import mys.ventas.models.entity.Cotizacion;
import mys.ventas.models.services.ICotizacionService;
import mys.ventas.util.Email;
import mys.ventas.util.PDF;
import net.sf.jasperreports.engine.JRException;

@Service
public class CotizacionServiceImplements implements ICotizacionService {

	@Autowired
	private ICotizacionDAO CotizacionDAO;

	@Autowired
	private JavaMailSender javaMailSender;
	
	private Email UEmail = new Email();

	private PDF UPdf = new PDF();

	@Override
	@Transactional(readOnly = true)
	public List<Cotizacion> findAll() {
		return (List<Cotizacion>) CotizacionDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cotizacion findById(Long id_cotizacion) {
		return CotizacionDAO.findById(id_cotizacion).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public Cotizacion save(Cotizacion cotizacion, String pie_pagina, String mensaje_correo, Integer envio)
			throws FileNotFoundException, MalformedURLException, JRException, MessagingException {
		Cotizacion DCotizacion = CotizacionDAO.save(cotizacion);
		List<Map<String, Object>> ListMapCotizacion = CotizacionDAO
				.findCotizacionReporteIdCotizacion(DCotizacion.getId_cotizacion());
		FileSystemResource fileSR = UPdf.cotizacion_A4_PDF(DCotizacion, ListMapCotizacion);
		UEmail.EmailCotizacion(fileSR, DCotizacion, "Gracias.", javaMailSender);
		return DCotizacion;
	}

	@Override
	@Transactional(readOnly = true)
	public Cotizacion findCotizacionNroDocumento(String nro_documento) {
		return CotizacionDAO.findCotizacionNroDocumento(nro_documento);
	}

	@Override
	public Page<Map<String, Object>> PaginacionCotizacion(Pageable pageable) {
		return CotizacionDAO.PaginacionCotizacion(pageable);
	}

	@Override
	public ResponseEntity<Resource> FindCotizacionIdReporteDescargarA4(Long id_cotizacion)
			throws FileNotFoundException, JRException, MalformedURLException {
		Cotizacion cotizacion = CotizacionDAO.findById(id_cotizacion).orElse(null);
		String nombrePDF = cotizacion.getCliente().getId_cliente() + "-" + cotizacion.getNro_documento() + "-"
				+ cotizacion.getDocumento().getDescripcion() + ".pdf";
		Path rutaArchivo = Paths.get("src/main/resources/static/cotizacion/pdf/A4").resolve(nombrePDF).toAbsolutePath();
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + rutaArchivo + "\"");
		return new ResponseEntity<Resource>(new UrlResource(rutaArchivo.toUri()), headers, HttpStatus.OK);
	}

	@Override
	public void VisualizarPDFCotizacionA4(HttpServletResponse response, Long id_cotizacion) throws IOException {
		response.setContentType("application/pdf");
		Cotizacion cotizacion = CotizacionDAO.findById(id_cotizacion).orElse(null);
		String nombrePDF = cotizacion.getCliente().getId_cliente() + "-" + cotizacion.getNro_documento() + "-"
				+ cotizacion.getDocumento().getDescripcion() + ".pdf";
		Path rutaArchivo = Paths.get("src/main/resources/static/cotizacion/pdf/A4").resolve(nombrePDF).toAbsolutePath();
		InputStream inputStream = new FileInputStream(new File(rutaArchivo.toString()));
		int nRead;
		while ((nRead = inputStream.read()) != -1) {
			response.getWriter().write(nRead);
		}
	}

	@Override
	public ResponseEntity<Resource> FindCotizacionIdReporteDescargarA5(Long id_cotizacion)
			throws FileNotFoundException, JRException, MalformedURLException {
		Cotizacion cotizacion = CotizacionDAO.findById(id_cotizacion).orElse(null);
		String nombrePDF = cotizacion.getCliente().getId_cliente() + "-" + cotizacion.getNro_documento() + "-"
				+ cotizacion.getDocumento().getDescripcion() + ".pdf";
		Path rutaArchivo = Paths.get("src/main/resources/static/cotizacion/pdf/A5").resolve(nombrePDF).toAbsolutePath();
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + rutaArchivo + "\"");
		return new ResponseEntity<Resource>(new UrlResource(rutaArchivo.toUri()), headers, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Resource> FindCotizacionIdReporteDescargar80(Long id_cotizacion)
			throws FileNotFoundException, JRException, MalformedURLException {
		Cotizacion cotizacion = CotizacionDAO.findById(id_cotizacion).orElse(null);
		String nombrePDF = cotizacion.getCliente().getId_cliente() + "-" + cotizacion.getNro_documento() + "-"
				+ cotizacion.getDocumento().getDescripcion() + ".pdf";
		Path rutaArchivo = Paths.get("src/main/resources/static/cotizacion/pdf/80").resolve(nombrePDF).toAbsolutePath();
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + rutaArchivo + "\"");
		return new ResponseEntity<Resource>(new UrlResource(rutaArchivo.toUri()), headers, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Resource> FindCotizacionIdReporteDescargar50(Long id_cotizacion)
			throws FileNotFoundException, JRException, MalformedURLException {
		Cotizacion cotizacion = CotizacionDAO.findById(id_cotizacion).orElse(null);
		String nombrePDF = cotizacion.getCliente().getId_cliente() + "-" + cotizacion.getNro_documento() + "-"
				+ cotizacion.getDocumento().getDescripcion() + ".pdf";
		Path rutaArchivo = Paths.get("src/main/resources/static/cotizacion/pdf/50").resolve(nombrePDF).toAbsolutePath();
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + rutaArchivo + "\"");
		return new ResponseEntity<Resource>(new UrlResource(rutaArchivo.toUri()), headers, HttpStatus.OK);
	}

	@Override
	public void VisualizarPDFCotizacionA5(HttpServletResponse response, Long id_cotizacion) throws IOException {
		response.setContentType("application/pdf");
		Cotizacion cotizacion = CotizacionDAO.findById(id_cotizacion).orElse(null);
		String nombrePDF = cotizacion.getCliente().getId_cliente() + "-" + cotizacion.getNro_documento() + "-"
				+ cotizacion.getDocumento().getDescripcion() + ".pdf";
		Path rutaArchivo = Paths.get("src/main/resources/static/cotizacion/pdf/A5").resolve(nombrePDF).toAbsolutePath();
		InputStream inputStream = new FileInputStream(new File(rutaArchivo.toString()));
		int nRead;
		while ((nRead = inputStream.read()) != -1) {
			response.getWriter().write(nRead);
		}
	}

	@Override
	public void VisualizarPDFCotizacion80(HttpServletResponse response, Long id_cotizacion) throws IOException {
		response.setContentType("application/pdf");
		Cotizacion cotizacion = CotizacionDAO.findById(id_cotizacion).orElse(null);
		String nombrePDF = cotizacion.getCliente().getId_cliente() + "-" + cotizacion.getNro_documento() + "-"
				+ cotizacion.getDocumento().getDescripcion() + ".pdf";
		Path rutaArchivo = Paths.get("src/main/resources/static/cotizacion/pdf/80").resolve(nombrePDF).toAbsolutePath();
		InputStream inputStream = new FileInputStream(new File(rutaArchivo.toString()));
		int nRead;
		while ((nRead = inputStream.read()) != -1) {
			response.getWriter().write(nRead);
		}
	}

	@Override
	public void VisualizarPDFCotizacion50(HttpServletResponse response, Long id_cotizacion) throws IOException {
		response.setContentType("application/pdf");
		Cotizacion cotizacion = CotizacionDAO.findById(id_cotizacion).orElse(null);
		String nombrePDF = cotizacion.getCliente().getId_cliente() + "-" + cotizacion.getNro_documento() + "-"
				+ cotizacion.getDocumento().getDescripcion() + ".pdf";
		Path rutaArchivo = Paths.get("src/main/resources/static/cotizacion/pdf/50").resolve(nombrePDF).toAbsolutePath();
		InputStream inputStream = new FileInputStream(new File(rutaArchivo.toString()));
		int nRead;
		while ((nRead = inputStream.read()) != -1) {
			response.getWriter().write(nRead);
		}
	}

	@Override
	public ResponseEntity<Resource> descargarPDF(Long id_cotizacion)
			throws FileNotFoundException, JRException, MalformedURLException {
		Cotizacion cotizacion = CotizacionDAO.findById(id_cotizacion).orElse(null);
		String nombrePDF = cotizacion.getEmpresa().getRuc() + ".pdf";
//		Path rutaArchivo = Paths.get("../cotizacion/pdf/").resolve(nombrePDF).toAbsolutePath();
		Path rutaArchivo = Paths.get("src/main/resources/static/cotizacion/pdf").resolve(nombrePDF).toAbsolutePath();
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + rutaArchivo + "\"");
		return new ResponseEntity<Resource>(new UrlResource(rutaArchivo.toUri()), headers, HttpStatus.OK);
	}

}
