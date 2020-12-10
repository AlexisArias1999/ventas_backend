package mys.ventas.models.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import mys.ventas.models.entity.Cotizacion;
import net.sf.jasperreports.engine.JRException;

public interface ICotizacionService {

	public ResponseEntity<Resource> descargarPDF(Long id_cotizacion) throws FileNotFoundException, JRException, MalformedURLException;
	
	public List<Cotizacion> findAll();
	
	public Cotizacion findById(Long id_cotizacion);
	
	public Cotizacion save(Cotizacion cotizacion, String pie_pagina, String mensaje_correo, Integer envio) throws FileNotFoundException, MalformedURLException, JRException, MessagingException;
	
	public Cotizacion findCotizacionNroDocumento(String nro_documento);
	
	public ResponseEntity<Resource> FindCotizacionIdReporteDescargarA4(Long id_cotizacion) throws FileNotFoundException, JRException,  MalformedURLException;
	
	public ResponseEntity<Resource> FindCotizacionIdReporteDescargarA5(Long id_cotizacion) throws FileNotFoundException, JRException,  MalformedURLException;
	
	public ResponseEntity<Resource> FindCotizacionIdReporteDescargar80(Long id_cotizacion) throws FileNotFoundException, JRException,  MalformedURLException;
	
	public ResponseEntity<Resource> FindCotizacionIdReporteDescargar50(Long id_cotizacion) throws FileNotFoundException, JRException,  MalformedURLException;
	
	
	public Page<Map<String, Object>> PaginacionCotizacion(Pageable pageable);
	
	public void VisualizarPDFCotizacionA4(HttpServletResponse response,Long id_cotizacion) throws IOException;
	
	public void VisualizarPDFCotizacionA5(HttpServletResponse response,Long id_cotizacion) throws IOException;
	
	public void VisualizarPDFCotizacion80(HttpServletResponse response,Long id_cotizacion) throws IOException;
	
	public void VisualizarPDFCotizacion50(HttpServletResponse response,Long id_cotizacion) throws IOException;
	
}
