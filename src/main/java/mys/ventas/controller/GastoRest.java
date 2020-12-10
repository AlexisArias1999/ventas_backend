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

import mys.ventas.models.entity.Gasto;
import mys.ventas.models.services.IGastoService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class GastoRest {

	@Autowired
	private IGastoService gastoService;
	
	@GetMapping("/gastos")
	public List<Gasto> findAll(){
		return gastoService.findAll();
	}
	
	@GetMapping("/gastos/{id_gasto}")
	public Gasto findById(@PathVariable Long id_gasto){
		return gastoService.findById(id_gasto);
	}
	
	@PostMapping("/gastos")
	public Gasto save(@RequestBody Gasto gasto){
		return gastoService.save(gasto);
	}
	
}
