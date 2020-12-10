package mys.ventas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.ventas.models.entity.Vencimiento;
import mys.ventas.models.services.IVencimientoService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class VencimientoRest {

	@Autowired
	private IVencimientoService vencimientoService;

	@GetMapping("/vencimiento")
	public List<Vencimiento> findAll() {
		return vencimientoService.findAll();
	}

	@GetMapping("/vencimiento/{id_vencimiento}")
	public ResponseEntity<?> findById(@PathVariable Long id_vencimiento) {
		Vencimiento vencimiento = vencimientoService.findById(id_vencimiento);
		Map<String, Object> response = new HashMap<String, Object>();
		if (vencimiento == null) {
			response.put("mensaje","Vencimiento no encontrado en la base de datos.");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Vencimiento>(vencimiento, HttpStatus.ACCEPTED);
	}

}
