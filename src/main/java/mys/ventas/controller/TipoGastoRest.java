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

import mys.ventas.models.entity.TipoGasto;
import mys.ventas.models.services.ITipoGastoService;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
@RequestMapping("/api")
public class TipoGastoRest {

	@Autowired
	private ITipoGastoService tipoGastoService;
	
	@GetMapping("/tipogastos")
	public List<TipoGasto> findAll(){
		return tipoGastoService.findAll();
	}
	
	@GetMapping("/tipogastos/{id_tipo_gasto}")
	public TipoGasto findById(@PathVariable Long id_tipo_gasto){
		return tipoGastoService.findById(id_tipo_gasto);
	}
	
	@PostMapping("/tipogastos")
	public TipoGasto save(@RequestBody TipoGasto tipo_gasto){
		return tipoGastoService.save(tipo_gasto);
	}
	
}
