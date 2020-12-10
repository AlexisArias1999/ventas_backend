package mys.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.ventas.models.entity.Impuesto;
import mys.ventas.models.services.IImpuestoService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class ImpuestoRest {

	@Autowired
	private IImpuestoService impuestoService;
	
	@GetMapping("/impuesto")
	public List<Impuesto> findAll(){
		return impuestoService.findAll();
	}
	
	@GetMapping("/impuesto/{id_impuesto}")
	public Impuesto findById(@PathVariable Long id_impuesto){
		return impuestoService.findById(id_impuesto);
	}
	
	@PostMapping("/impuesto")
	public Impuesto save(@RequestBody Impuesto impuesto) {
		return impuestoService.save(impuesto);
	}
	
}
