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

import mys.ventas.models.entity.ProductoMarca;
import mys.ventas.models.services.IProductoMarcaService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class ProductoMarcaRest {

	@Autowired
	private IProductoMarcaService productoMarcaService;
	
	@GetMapping("/producto_marca/paginacion/{page}")
	public Page<ProductoMarca> paginacion(@PathVariable Integer page){
		return productoMarcaService.paginacion(PageRequest.of(page, 5));
	}
	
	@GetMapping("/producto_marca")
	public List<ProductoMarca> findAll(){
		return productoMarcaService.findAll();
	}
	
	@GetMapping("/producto_marca/{id_producto_marca}")
	public ProductoMarca findById(@PathVariable Long id_producto_marca){
		return productoMarcaService.findById(id_producto_marca);
	}
	
	@PostMapping("/producto_marca")
	public ProductoMarca save(@RequestBody ProductoMarca productoMarca){
		return productoMarcaService.save(productoMarca);
	}
	
}
