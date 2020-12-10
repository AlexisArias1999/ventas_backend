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
import mys.ventas.models.entity.ReciboEstado;
import mys.ventas.models.services.IReciboEstadoService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class ReciboEstadoRest {

	@Autowired
	private IReciboEstadoService reciboEstadoService;
	
	@GetMapping("/recibo_estado")
	public List<ReciboEstado> findAll(){
		return reciboEstadoService.findAll();
	}
	
	@GetMapping("/recibo_estado/{id_recibo_estado}")
	public ReciboEstado findById(@PathVariable Long id_recibo_estado){
		return reciboEstadoService.findById(id_recibo_estado);
	}
	
	@PostMapping("/recibo_estado")
	public ReciboEstado save(@RequestBody ReciboEstado gasto){
		return reciboEstadoService.save(gasto);
	}
	
}
