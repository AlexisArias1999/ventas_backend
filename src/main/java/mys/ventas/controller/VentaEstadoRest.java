package mys.ventas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.ventas.models.entity.VentaEstado;
import mys.ventas.models.services.IVentaEstadoService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class VentaEstadoRest {
	
	@Autowired
	private IVentaEstadoService ventaEstadoService;
	
	@GetMapping("/venta_estado/{id_venta_estado}")
	public VentaEstado findById(@PathVariable Long id_venta_estado) {
		return ventaEstadoService.finfById(id_venta_estado);
	}
	
	
}
