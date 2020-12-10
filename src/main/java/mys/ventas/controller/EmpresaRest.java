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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import mys.ventas.models.entity.Empresa;
import mys.ventas.models.services.IEmpresaService;
import mys.ventas.util.Sunat;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class EmpresaRest {

	@Autowired
	private IEmpresaService empresaService;
	
	private Sunat SUNAT;
	
	//TODAS LAS EMPRESAS
	@GetMapping("/empresa")
	public ResponseEntity<?> findAll() {
		List<Empresa> empresa = empresaService.findAll();
		Map<String, Object> response = new HashMap<String, Object>();
		if (empresa.size() == 0) {
			response.put("mensaje", "No hay empresas registradas");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONTINUE);
		}
		return new ResponseEntity<List<Empresa>>(empresa, HttpStatus.OK);
	}
	
	//BUSCAR RUC EN SUNAT
	@GetMapping("/empresa/ruc/{ruc}")
	public ResponseEntity<?> ruc(@PathVariable String ruc) {
		return SUNAT.buscarRUC(ruc);
	}

	//BUSCAR EMPRESA
	@GetMapping("/empresa/{id_empresa}")
	public ResponseEntity<?> findById(@PathVariable Long id_empresa) {
		Empresa empresa = empresaService.findById(id_empresa);
		Map<String, Object> response = new HashMap<String, Object>();
		if (empresa == null) {
			response.put("mensaje", "Empresa no encontrado en la base de datos.");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
	}

	//REGISTRAR EMPRESA
	@PostMapping("/empresa")
	public ResponseEntity<?> save(@Valid @RequestBody Empresa empresa, BindingResult result) {
		Map<String, Object> response = new HashMap<String, Object>();
		Empresa nuevaEmpresa = new Empresa();
		if (result.hasErrors()) {
			List<String> error = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			response.put("error", error);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			if (empresa.getId_empresa() == null) {
				nuevaEmpresa = empresaService.save(empresa);
			} else {
				return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
			}
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al registrar la empresa");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Empresa>(nuevaEmpresa, HttpStatus.OK);
	}

	//CARGAR LOGO DE LA EMPRESA
	@PostMapping("/empresa/upload")
	public ResponseEntity<?> cargarImagenProducto(@RequestParam("archivo") MultipartFile archivo,
			@RequestParam("id_empresa") Long id_empresa) {		
		return empresaService.uploadLogo(archivo, id_empresa);		
	}

}
