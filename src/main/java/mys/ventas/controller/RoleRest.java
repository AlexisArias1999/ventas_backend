package mys.ventas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.ventas.models.entity.Role;
import mys.ventas.models.services.IRoleService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class RoleRest {

	@Autowired
	private IRoleService roleService;

	@GetMapping("/role")
	public ResponseEntity<?> findAll() {
		List<Role> role = roleService.findAll();
		Map<String, Object> response = new HashMap<String, Object>();
		if (role.size() == 0) {
			response.put("mensaje", "No hay roles registrados");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONTINUE);
		}
		return new ResponseEntity<List<Role>>(role, HttpStatus.OK);
	}
	
}
