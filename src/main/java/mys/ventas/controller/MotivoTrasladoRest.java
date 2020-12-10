package mys.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.ventas.models.entity.MotivoTraslado;
import mys.ventas.models.services.IMotivoTrasladoService;


@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class MotivoTrasladoRest {

	@Autowired
	private IMotivoTrasladoService motivoTrasladoService;
	
	@GetMapping("/motivo_traslado")
	public List<MotivoTraslado> findAll(){
		return motivoTrasladoService.findAll();
	}
	
	@GetMapping("/motivo_traslado/{id_motivo_traslado}")
	public MotivoTraslado findById(@PathVariable Long id_motivo_traslado){
		return motivoTrasladoService.findById(id_motivo_traslado);
	}
	
}
