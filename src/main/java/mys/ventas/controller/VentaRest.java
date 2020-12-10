package mys.ventas.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

import mys.ventas.models.entity.Venta;
import mys.ventas.models.services.IVentaService;
import net.sf.jasperreports.engine.JRException;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class VentaRest {

	@Autowired
	private IVentaService ventaService;

	@GetMapping("/ventas")
	public List<Venta> findAll() {
		return ventaService.findAll();
	}

	@GetMapping("/ventas/descargar/pdf/A4/{id_venta}")
	public ResponseEntity<Resource> FindVentaIdReporteA4(@PathVariable Long id_venta)
			throws FileNotFoundException, JRException, MalformedURLException {
		return ventaService.FindVentaIdReporteDescargarA4(id_venta);
	}

	@GetMapping("/ventas/recibos/pagados")
	public List<Map<String, Object>> findAllVentasRecibos() {
		return ventaService.findAllVentasRecibos();
	}

	@GetMapping("/ventas/recibos/page/{page}")
	public Page<Map<String, Object>> PaginacionVentasRecibos(@PathVariable Integer page) {
		return ventaService.PaginacionVentasRecibos(PageRequest.of(page, 5));
	}

//	@GetMapping("ventas/enviar/email/{id_venta}/{mensaje}")
//	@ResponseBody
//	public void EnviarCorreoVenta(@PathVariable Long id_venta, @PathVariable String mensaje)
//			throws MessagingException, FileNotFoundException, MalformedURLException, JRException {
//		ventaService.EnviarCorreoVenta(id_venta, mensaje);
//	}

	@GetMapping("/ventas/{id_venta}")
	public Venta findById(@PathVariable Long id_venta) {
		return ventaService.findById(id_venta);
	}

	@PostMapping("/ventas")
	public ResponseEntity<?> save(@Valid @RequestBody Venta venta, BindingResult result)
			throws FileNotFoundException, MalformedURLException, JRException {
		Map<String, Object> response = new HashMap<String, Object>();
		Venta nuevaVenta = null;
		if (result.hasErrors()) {
			List<String> error = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			response.put("error", error);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			if (venta.getId_venta() == null) {
				if (venta.getVenta_detalle().size() == 0) {
					List<String> error = new ArrayList<>();
					error.add("No a registrado ni un producto o servicio");
					response.put("error", error);
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
				}
				nuevaVenta = ventaService.save(venta);
			} else {
				if(venta.getVenta_estado().getId_venta_estado() == 1) {
					return new ResponseEntity<Venta>(venta, HttpStatus.OK);					
				} else {
					nuevaVenta = ventaService.save(venta);					
				}
			}
		} catch (DataAccessException e) {
			System.out.print(e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("mensaje", "Error al registrar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Venta>(nuevaVenta, HttpStatus.CREATED);
	}

	@PostMapping("/ventas/estado-venta")
	public Venta modificarVenta(@RequestBody Venta venta)
			throws FileNotFoundException, MalformedURLException, JRException {
		return ventaService.save(venta);
	}

	@GetMapping("/ventas/vista/pdf/A4/{id_venta}")
	public void showPdfA4(HttpServletResponse response, @PathVariable Long id_venta) throws IOException {
		ventaService.VisualizarPDFVentaA4(response, id_venta);
	}

	

}
