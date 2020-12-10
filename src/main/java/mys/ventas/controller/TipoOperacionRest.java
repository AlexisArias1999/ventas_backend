package mys.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.ventas.models.entity.TipoOperacion;
import mys.ventas.models.services.ITipoOperacionService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class TipoOperacionRest {

	@Autowired
	private ITipoOperacionService tipoOperacionService;

	@GetMapping("/tipooperacion")
	public List<TipoOperacion> findAll() {
		return tipoOperacionService.findAll();
	}
	
	@GetMapping("/tipooperacion/{id_tipo_operacion}")
	public TipoOperacion findbyId(@PathVariable Long id_tipo_operacion) {
		return tipoOperacionService.findById(id_tipo_operacion);
	}

}
