package mys.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.ventas.models.entity.EspecificacionTiempo;
import mys.ventas.models.services.IEspecificacionTiempoService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class EspecificacionTiempoRest {

	@Autowired
	private IEspecificacionTiempoService especificacionTiempoService;

	@GetMapping("/especificacion_tiempo")
	public List<EspecificacionTiempo> findAll() {
		return especificacionTiempoService.findAll();
	}
	
	@GetMapping("/especificacion_tiempo/{id_especificacion_tiempo}")
	public EspecificacionTiempo findAll(@PathVariable Long id_especificacion_tiempo) {
		return especificacionTiempoService.findById(id_especificacion_tiempo);
	}
	
}
