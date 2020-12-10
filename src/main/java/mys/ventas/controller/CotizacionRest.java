package mys.ventas.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.ventas.models.dao.ICotizacionDAO;
import mys.ventas.models.entity.Cotizacion;
import mys.ventas.models.services.ICotizacionService;
import net.sf.jasperreports.engine.JRException;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class CotizacionRest {

	@Autowired
	private ICotizacionService cotizacionService;

	@Autowired
	ICotizacionDAO CotizacionDAO;

	@GetMapping("/cotizaciones")
	public List<Cotizacion> findAll() {
		return cotizacionService.findAll();
	}

	@GetMapping("/cotizaciones/{id_cotizacion}")
	public Cotizacion findById(@PathVariable Long id_cotizacion) {
		return cotizacionService.findById(id_cotizacion);
	}

	@GetMapping("/cotizaciones/descargar/pdf/A4/{id_cotizacion}")
	public ResponseEntity<Resource> FindCotizacionIdReporteA4(@PathVariable Long id_cotizacion)
			throws FileNotFoundException, JRException, MalformedURLException {
		return cotizacionService.FindCotizacionIdReporteDescargarA4(id_cotizacion);
	}

	@GetMapping("/cotizaciones/descargar/pdf/A5/{id_cotizacion}")
	public ResponseEntity<Resource> FindCotizacionIdReporteA5(@PathVariable Long id_cotizacion)
			throws FileNotFoundException, JRException, MalformedURLException {
		return cotizacionService.FindCotizacionIdReporteDescargarA5(id_cotizacion);
	}

	@GetMapping("/cotizaciones/descargar/pdf/50/{id_cotizacion}")
	public ResponseEntity<Resource> FindCotizacionIdReporte50(@PathVariable Long id_cotizacion)
			throws FileNotFoundException, JRException, MalformedURLException {
		return cotizacionService.FindCotizacionIdReporteDescargar50(id_cotizacion);
	}

	@GetMapping("/cotizaciones/descargar/pdf/80/{id_cotizacion}")
	public ResponseEntity<Resource> FindCotizacionIdReporte80(@PathVariable Long id_cotizacion)
			throws FileNotFoundException, JRException, MalformedURLException {
		return cotizacionService.FindCotizacionIdReporteDescargar80(id_cotizacion);
	}

	@GetMapping("/cotizaciones/vista/pdf/A4/{id_cotizacion}")
	public void showPdfA4(HttpServletResponse response, @PathVariable Long id_cotizacion) throws IOException {
		cotizacionService.VisualizarPDFCotizacionA4(response, id_cotizacion);
	}

	@GetMapping("/cotizaciones/vista/pdf/A5/{id_cotizacion}")
	public void showPdfA5(HttpServletResponse response, @PathVariable Long id_cotizacion) throws IOException {
		cotizacionService.VisualizarPDFCotizacionA5(response, id_cotizacion);
	}

	@GetMapping("/cotizaciones/vista/pdf/50/{id_cotizacion}")
	public void showPdf50(HttpServletResponse response, @PathVariable Long id_cotizacion) throws IOException {
		cotizacionService.VisualizarPDFCotizacion50(response, id_cotizacion);
	}

	@GetMapping("/cotizaciones/vista/pdf/80/{id_cotizacion}")
	public void showPdf80(HttpServletResponse response, @PathVariable Long id_cotizacion) throws IOException {
		cotizacionService.VisualizarPDFCotizacion80(response, id_cotizacion);
	}

	@PostMapping("/cotizacion/{pie_pagina}/{mensaje_correo}/{envio}")
	public ResponseEntity<?> save(@Valid @RequestBody Cotizacion cotizacion, @PathVariable String pie_pagina,
			@PathVariable String mensaje_correo, @PathVariable Integer envio, BindingResult result)
			throws FileNotFoundException, MalformedURLException, JRException, MessagingException {
		System.out.println("" + cotizacion.getCliente().getNombres());
		Map<String, Object> response = new HashMap<String, Object>();
		Cotizacion nuevaCotizacion = null;
		if (result.hasErrors()) {
			List<String> error = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			response.put("error", error);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			if (cotizacion.getId_cotizacion() == null) {
				if (cotizacion.getCotizacion_detalle().size() == 0) {
					List<String> error = new ArrayList<>();
					error.add("No a registrado ni un producto o servicio");
					response.put("error", error);
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
				}
				nuevaCotizacion = cotizacionService.save(cotizacion, pie_pagina, mensaje_correo, envio);
			} else {
				return new ResponseEntity<Cotizacion>(cotizacion, HttpStatus.OK);
			}
		} catch (DataAccessException e) {
			System.out.print(e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("mensaje", "Error al registrar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Cotizacion>(nuevaCotizacion, HttpStatus.CREATED);
	}

	@GetMapping("/cotizacion/descargar/pdf/{id_cotizacion}")
	public ResponseEntity<Resource> descargarPDF(@PathVariable Long id_cotizacion)
			throws FileNotFoundException, JRException, MalformedURLException {
		return cotizacionService.descargarPDF(id_cotizacion);
	}

	@GetMapping("/cotizaciones/correlativo/{nro_documento}")
	public Cotizacion findCotizacionNroDocumento(@PathVariable String nro_documento) {
		return cotizacionService.findCotizacionNroDocumento(nro_documento);
	}

	@GetMapping("/cotizacion/page/{page}")
	public Page<Map<String, Object>> PaginacionCotizacion(@PathVariable Integer page) {
		return cotizacionService.PaginacionCotizacion(PageRequest.of(page, 5));
	}

}
