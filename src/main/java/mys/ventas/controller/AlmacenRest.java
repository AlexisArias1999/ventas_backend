package mys.ventas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

import mys.ventas.models.entity.Almacen;
import mys.ventas.models.services.IAlmacenService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class AlmacenRest {

	@Autowired
	private IAlmacenService almacenService;

	@GetMapping("/almacen")
	public ResponseEntity<?> findAll() {
		List<Almacen> almacen = almacenService.findAll();
		Map<String, Object> response = new HashMap<String, Object>();
		if (almacen.size() == 0) {
			response.put("mensaje", "No hay almacenes registrados");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONTINUE);
		}
		return new ResponseEntity<List<Almacen>>(almacen, HttpStatus.OK);
	}
	
	@GetMapping("/almacen/{id_empresa}")
	public ResponseEntity<?> findByIdEmpresa(@PathVariable Long id_empresa) {
		List<Map<String, Object>> almacen = almacenService.findByIdEmpresa(id_empresa);
		Map<String, Object> response = new HashMap<String, Object>();
		if (almacen.size() == 0) {
			response.put("mensaje", "No hay almacenes registrados");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONTINUE);
		}
		return new ResponseEntity<List<Map<String, Object>>>(almacen, HttpStatus.OK);
	}

	@PostMapping("/almacen")
	public ResponseEntity<?> save(@Valid @RequestBody Almacen almacen, BindingResult result) {
		Map<String, Object> response = new HashMap<String, Object>();
		Almacen nuevoAlmacen = null;
		if(result.hasErrors()) {
			List<String> error = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			response.put("error", error);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			if(almacen.getId_almacen() == null) {
				nuevoAlmacen = almacenService.save(almacen);				
			} else {
				return new ResponseEntity<Almacen>(almacen, HttpStatus.OK);				
			}
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al registrar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Almacen>(nuevoAlmacen, HttpStatus.OK);
	}

}
