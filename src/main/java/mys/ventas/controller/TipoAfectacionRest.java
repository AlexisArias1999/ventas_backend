package mys.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.ventas.models.entity.TipoAfectacion;
import mys.ventas.models.services.ITipoAfectacionService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class TipoAfectacionRest {

	@Autowired
	private ITipoAfectacionService tipoAfectacionService;
	
	@GetMapping("/tipo_afectacion/paginacion/{page}")
	public Page<TipoAfectacion> paginacion(@PathVariable Integer page){
		return tipoAfectacionService.paginacion(PageRequest.of(page, 5));
	}
	
	@GetMapping("/tipo_afectacion")
	public List<TipoAfectacion> findAll(){
		return tipoAfectacionService.findAll();
	}
		
	@GetMapping("/tipo_afectacion/{id_tipo_afectacion}")
	public TipoAfectacion findById(@PathVariable Long id_tipo_afectacion){
		return tipoAfectacionService.findById(id_tipo_afectacion);
	}
	
	@PostMapping("/tipo_afectacion}")
	public TipoAfectacion save(@RequestBody TipoAfectacion tipo_afectacion){
		return tipoAfectacionService.save(tipo_afectacion);
	}
	
}
