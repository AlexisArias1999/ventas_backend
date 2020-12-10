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

import mys.ventas.models.entity.Proveedor;
import mys.ventas.models.services.IProveedorService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class ProveedorRest {
	
	@Autowired
	private IProveedorService proveedorService;
	
	@GetMapping("/proveedores")
	public List<Proveedor> findAll(){
		return proveedorService.findAll();
	}
	
	@GetMapping("/proveedores/{id_proveedor}")
	public Proveedor findById(@PathVariable Long id_proveedor){
		return proveedorService.findById(id_proveedor);
	}
	
	@PostMapping("/proveedores")
	public Proveedor save(@RequestBody Proveedor proveedor) {
		return proveedorService.save(proveedor);
	}
	
}
