package mys.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import mys.ventas.models.entity.Operacion;
import mys.ventas.models.services.IOperacionService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class OperacionRest {

	@Autowired
	private IOperacionService operacionService;

	@GetMapping("/operaciones")
	public List<Operacion> findAll() {
		return operacionService.findAll();
	}

	@PostMapping("/operaciones")
	public Operacion save(@RequestBody Operacion operacion) {
		return operacionService.save(operacion);
	}

}
