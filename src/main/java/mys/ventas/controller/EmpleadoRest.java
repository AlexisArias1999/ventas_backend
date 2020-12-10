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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.ventas.models.entity.Empleado;
import mys.ventas.models.services.IEmpleadoService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class EmpleadoRest {

	@Autowired
	private IEmpleadoService empleadoService;

	@GetMapping("/empleado")
	public List<Empleado> findAll() {
		return empleadoService.findAll();
	}
	
	@PostMapping("/empleado")
	public Empleado save(@RequestBody Empleado empleado) {
		return empleadoService.save(empleado);
	}

	@GetMapping("/empleado/{id_empleado}")
	public Empleado findById(@PathVariable Long id_empleado) {
		return empleadoService.findById(id_empleado);
	}
	
	@GetMapping("/empleado/page/{page}")
	public Page<Map<String, Object>> PaginacionEmpleado(@PathVariable Integer page) {
		return empleadoService.PaginacionEmpleado(PageRequest.of(page, 5));
	}
	
	@GetMapping("/empleado/especialistas")
	public List<Map<String, Object>> RegistrosEspecialistas() {
		return empleadoService.RegistrosEspecialistas();
	}
	
	@GetMapping("/empleado/empresa/{id_empresa}")
	public List<Map<String, Object>> RegistrosEmpleadosByEmpresa(@PathVariable Long id_empresa) {
		return empleadoService.RegistrosEmpleadosByEmpresa(id_empresa);
	}

}
