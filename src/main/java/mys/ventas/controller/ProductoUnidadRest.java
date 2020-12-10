package mys.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.ventas.models.entity.ProductoUnidad;
import mys.ventas.models.services.IProductoUnidadService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class ProductoUnidadRest {

	@Autowired
	private IProductoUnidadService productoUnidadService;

	@GetMapping("/producto_unidad/paginacion/{page}")
	public Page<ProductoUnidad> paginacion(@PathVariable Integer page){
		return productoUnidadService.paginacionProducto(PageRequest.of(page, 5));
	}
	
	@GetMapping("/producto_unidad")
	public List<ProductoUnidad> findAll(){
		return productoUnidadService.findAll();
	}
	
	@PostMapping("/producto_unidad")
	public ProductoUnidad save(@RequestBody ProductoUnidad productoUnidad) {
		return productoUnidadService.save(productoUnidad);
	}
	
	public ProductoUnidad fidnById(@PathVariable Long id_producto_unidad) {
		return productoUnidadService.findById(id_producto_unidad);
	}
	
	

}
