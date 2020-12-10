package mys.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.ventas.models.entity.TipoMovimiento;
import mys.ventas.models.services.ITipoMovimientoService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class TipoMovimientoRest {

	@Autowired
	private ITipoMovimientoService tipoMovimientoService;
	
	@GetMapping("/tipo_movimiento")
	public List<TipoMovimiento> findAll(){
		return tipoMovimientoService.findAll();
	}
	
	@GetMapping("/tipo_movimiento/{id_tipo_movimiento}")
	public TipoMovimiento findById(@PathVariable Long id_tipo_movimiento){
		return tipoMovimientoService.findById(id_tipo_movimiento);
	}
	
}
