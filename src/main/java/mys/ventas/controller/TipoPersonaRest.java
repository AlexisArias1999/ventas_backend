package mys.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.ventas.models.entity.TipoPersona;
import mys.ventas.models.services.ITipoPersonaService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class TipoPersonaRest {

	@Autowired
	private ITipoPersonaService tipoPersonaService;
	
	@GetMapping("/tipo_persona")
	public List<TipoPersona> findAll(){
		return tipoPersonaService.findAll();
	}
	
	@GetMapping("/tipo_persona/{id_tipo_persona}")
	public TipoPersona findById(@PathVariable Long id_tipo_persona){
		return tipoPersonaService.findById(id_tipo_persona);
	}
	
}
