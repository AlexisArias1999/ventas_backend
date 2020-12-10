package mys.ventas.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.ventas.models.entity.Entidad;
import mys.ventas.models.services.IEntidadService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class EntidadRest {

	@Autowired
	private IEntidadService EntidadService;

	@GetMapping("/entidades")
	public List<Entidad> findAll() {
		return EntidadService.findAll();
	}

	@GetMapping("/entidades/{id_entidades}")
	public Entidad findById(@PathVariable Long id_entidades) {
		return EntidadService.findById(id_entidades);
	}

	@GetMapping("/entidades/busquedad_forma_pago/{id_forma_pago}")
	public List<Map<String, Object>> getAllEntidadIdFormaPago(@PathVariable Long id_forma_pago) {
		return EntidadService.getAllEntidadIdFormaPago(id_forma_pago);
	}

	@PostMapping("/entidades")
	public Entidad save(@RequestBody Entidad entidad) {
		return EntidadService.save(entidad);
	}

}
