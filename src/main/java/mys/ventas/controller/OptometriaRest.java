package mys.ventas.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.ventas.models.entity.Optometria;
import mys.ventas.models.services.IOptometriaService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class OptometriaRest {

	@Autowired
	private IOptometriaService optometriaService;

	@GetMapping("/optometria/{id_optometria}")
	public ResponseEntity<?> findById(@PathVariable Long id_optometria) {
		Optometria optometria = optometriaService.findById(id_optometria);
		Map<String, Object> response = new HashMap<String, Object>();
		if (optometria == null) {
			response.put("mensaje", "No hay registrados");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONTINUE);
		}
		return new ResponseEntity<Optometria>(optometria, HttpStatus.OK);
	}

	@PostMapping("/optometria")
	public Optometria save(@RequestBody Optometria optometria) {
		return optometriaService.save(optometria);
	}

	@GetMapping("/optometria/page/{id_cliente}/{page}")
	public Page<Map<String, Object>> PaginacionVentasRecibos(@PathVariable Long id_cliente,
			@PathVariable Integer page) {
		return optometriaService.PaginacionGestionarOptometria(id_cliente, PageRequest.of(page, 5));
	}

}
