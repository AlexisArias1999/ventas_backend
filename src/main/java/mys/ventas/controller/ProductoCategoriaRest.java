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

import mys.ventas.models.entity.ProductoCategoria;
import mys.ventas.models.services.IProductoCategoriaService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class ProductoCategoriaRest {

	@Autowired
	private IProductoCategoriaService productoCategoriaService;

	@GetMapping("/producto_categoria/paginacion/{page}")
	public Page<ProductoCategoria> paginacion(@PathVariable Integer page) {
		return productoCategoriaService.paginacion(PageRequest.of(page, 5));
	}
	
	@GetMapping("/producto_categoria")
	public List<ProductoCategoria> findAll() {
		return productoCategoriaService.findAll();
	}
	
	@GetMapping("/producto_categoria/{id_producto_categoria}")
	public ProductoCategoria findById(@PathVariable Long id_producto_categoria) {
		return productoCategoriaService.findById(id_producto_categoria);
	}

	@PostMapping("/producto_categoria/{id_producto_categoria}")
	public ProductoCategoria save(@RequestBody ProductoCategoria productoCategoria) {
		return productoCategoriaService.save(productoCategoria);
	}
	
}
