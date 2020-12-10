package mys.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.ventas.models.entity.ProductoEstadoSerie;
import mys.ventas.models.services.IProductoEstadoSerieService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class ProductoEstadoSerieRest {

	@Autowired
	private IProductoEstadoSerieService productoEstadoSerieService;
	
	@GetMapping("/producto_estado_serie")
	public List<ProductoEstadoSerie> findAll(){
		return productoEstadoSerieService.findAll();
	}
	
}
