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

import mys.ventas.models.entity.ProveedorCredito;
import mys.ventas.models.services.IProveedorCreditoService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class ProveedorCreditoRest {
	
	@Autowired
	private IProveedorCreditoService proveedorCreditoService;
	
	@GetMapping("/proveedor_credito")
	public List<ProveedorCredito> findAll(){
		return proveedorCreditoService.findAll();
	}
	
	@GetMapping("/proveedor_credito/{id_proveedor_credito}")
	public ProveedorCredito findById(@PathVariable Long id_proveedor_credito){
		return proveedorCreditoService.findById(id_proveedor_credito);
	}
	
	@PostMapping("/proveedor_credito")
	public ProveedorCredito save(@RequestBody ProveedorCredito proveedor_credito){
		return proveedorCreditoService.save(proveedor_credito);
	}

}
