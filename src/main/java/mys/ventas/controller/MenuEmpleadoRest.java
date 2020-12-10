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

import mys.ventas.models.entity.MenuEmpleado;
import mys.ventas.models.services.IMenuEmpleadoService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class MenuEmpleadoRest {

	@Autowired
	private IMenuEmpleadoService menuEmpleadoService;

	@PostMapping("/menu-empleado")
	public ResponseEntity<?> save(@Valid @RequestBody MenuEmpleado menuEmpleado, BindingResult result) {
		Map<String, Object> response = new HashMap<String, Object>();
		MenuEmpleado nuevoMenuEmpleado = new MenuEmpleado();
		if (result.hasErrors()) {
			List<String> error = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			response.put("error", error);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
//			menuEmpleadoService.deleteByIdEmpleado(menuEmpleado.getEmpleado().getId_empleado());
			nuevoMenuEmpleado = menuEmpleadoService.save(menuEmpleado);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al registrar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<MenuEmpleado>(nuevoMenuEmpleado, HttpStatus.CREATED);
	}

	@GetMapping("/menu-empleado/empleado/{id_empleado}")
	public List<MenuEmpleado> findByEmpres( @PathVariable Long id_empleado) {
		return menuEmpleadoService.findMenuByEmpleado(id_empleado);
	}

}
