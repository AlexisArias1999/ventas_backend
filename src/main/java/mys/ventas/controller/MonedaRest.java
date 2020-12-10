package mys.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.ventas.models.entity.Moneda;
import mys.ventas.models.services.IMonedaService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class MonedaRest {

	@Autowired
	private IMonedaService monedaService;
	
	@GetMapping("/moneda")
	public List<Moneda> findAll(){
		return monedaService.findAll();
	}	
	
	@GetMapping("/moneda/{id_moneda}")
	public Moneda findById(@PathVariable Long id_moneda){
		return monedaService.findById(id_moneda);
	}
	
}
