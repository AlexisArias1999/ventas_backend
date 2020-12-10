package mys.ventas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.ventas.models.entity.Cliente;
import mys.ventas.models.services.IClienteService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class ClienteRest {
	
	@Autowired
	private IClienteService ClienteService;
	
	@GetMapping("/cliente/deuda")
	public List<Map<String, Object>> findAllClientesDeuda(){
		return ClienteService.findAllClientesDeuda();
	}
	
//	@GetMapping("/clientes/{page}")
//	public Page<Map<String, Object>> paginacionCliente(@PathVariable Integer page){
//		return ClienteService.paginacionCliente(PageRequest.of(page, 5));
//	}
	
	@GetMapping("/cliente/page/{page}")
	public Page<Map<String, Object>> findAllClientesRUCDNI(@PathVariable Integer page){
		return ClienteService.findAllClientesRUCDNI(PageRequest.of(page, 5));
	}
	
	@GetMapping("/cliente")
	public List<Cliente> findAll(){
		return ClienteService.findAll();
	}
	
	@GetMapping("/cliente/{id_cliente}")
	public Cliente findById(@PathVariable Long id_cliente){
		return ClienteService.findById(id_cliente);
	}
	
	@PostMapping("/cliente")
	public ResponseEntity<?> save(@Valid @RequestBody Cliente cliente, BindingResult result) {
		Map<String, Object> response = new HashMap<String, Object>();
		Cliente nuevoCliente = new Cliente();
		if (result.hasErrors()) {
			List<String> error = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			response.put("error", error);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			if(cliente.getId_cliente() == null) {
				nuevoCliente = ClienteService.save(cliente);				
			} else {
				return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
			}
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al registrar el cliente");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Cliente>(nuevoCliente, HttpStatus.OK);
	}
	
	
}
