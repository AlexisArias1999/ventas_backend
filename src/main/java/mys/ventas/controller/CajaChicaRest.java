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

import mys.ventas.models.entity.CajaChica;
import mys.ventas.models.services.ICajaChicaService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class CajaChicaRest {

	@Autowired
	private ICajaChicaService CajaChicaService;
	
	@GetMapping("/caja_chica")
	public List<CajaChica> findAll(){
		return CajaChicaService.findAll();
	}
	
	@GetMapping("/caja_chica/{id_caja_chica}")
	public CajaChica findAll(@PathVariable Long id_caja_chica){
		return CajaChicaService.findById(id_caja_chica);
	}
	
	@PostMapping("/caja_chica")
	public CajaChica save(@RequestBody CajaChica caja_chica){
		return CajaChicaService.save(caja_chica);
	}
	
	@PostMapping("/caja_chicas")
	public CajaChica save2(@RequestBody CajaChica caja_chica){
		return CajaChicaService.save(caja_chica);
	}
	
}
