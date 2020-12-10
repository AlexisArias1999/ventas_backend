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

import mys.ventas.models.entity.FormaPago;
import mys.ventas.models.services.IFormaPagoService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class FormaPagoRest {

	@Autowired
	private IFormaPagoService formaPagoService;

	@GetMapping("/formapago")
	public List<FormaPago> findAll() {
		return formaPagoService.findAll();
	}
	
	@PostMapping("/formapago")
	public FormaPago save(@RequestBody FormaPago formaPago) {
		return formaPagoService.save(formaPago);
	}
	
	@GetMapping("/formapago/{id_forma_pago}")
	public FormaPago findById(@PathVariable Long id_forma_pago) {
		return formaPagoService.findById(id_forma_pago);
	}

}
