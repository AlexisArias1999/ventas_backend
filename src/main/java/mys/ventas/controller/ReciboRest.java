package mys.ventas.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.ventas.models.entity.Recibo;
import mys.ventas.models.services.IReciboService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class ReciboRest {

	@Autowired
	private IReciboService ReciboService;	
	
	@GetMapping("/recibos/page/{page}/{id_empresa}")
	public Page<Map<String, Object>> PaginacionRecibos(@PathVariable Integer page,
			@PathVariable Long id_empresa) {
		return ReciboService.PaginacionRecibos(id_empresa, PageRequest.of(page, 5));
	}
	
	@PostMapping("/recibos")
	public Recibo save(@RequestBody Recibo recibo) {
		return this.ReciboService.save(recibo);
	}
	
	@PutMapping("/recibos/pagado")
	public Recibo edit(@RequestBody Recibo recibo) {
		return this.ReciboService.save(recibo);
	}
	
	@GetMapping("/recibos")
	public List<Recibo> findAll(){
		return this.ReciboService.findAll();
	}
	
	@GetMapping("/recibos/{id_recibo}")
	public Recibo findById(@PathVariable Long id_recibo){
		return this.ReciboService.findById(id_recibo);
	}
	
	@GetMapping("/recibos/deuda/{id_venta}")
	public Map<Double, Object> ObtenerDeudaVenta(@PathVariable Long id_venta){
		return this.ReciboService.ObtenerDeudaVenta(id_venta);
	}
	
	@GetMapping("/recibos/generados/{id_venta}")
	public List<Map<String, Object>> findAllReciboVenta(@PathVariable Long id_venta){
		return this.ReciboService.findAllReciboVenta(id_venta);
	}
}
