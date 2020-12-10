package mys.ventas.controller;

import java.util.ArrayList;
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

import mys.ventas.models.entity.Movimiento;
import mys.ventas.models.services.IMovimientoService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class MovimientoRest {

	@Autowired
	private IMovimientoService movimientoService;

	@GetMapping("/movimiento/page/{page}/{id_empresa}")
	public Page<Map<String, Object>> PagiacionMovimientosProductos(@PathVariable Integer page,
			@PathVariable Long id_empresa) {
		return movimientoService.PagiacionMovimientosProductos(id_empresa, PageRequest.of(page, 5));
	}

	@GetMapping("/movimiento/producto/{id_producto}")
	public Map<String, Object> MovimientoByIdProducto(@PathVariable Long id_producto) {
		return movimientoService.MovimientoByIdProducto(id_producto);
	}

	@GetMapping("/movimiento/producto/almacen/{id_producto}/{id_almacen}")
	public Map<String, Object> MovimientoByIdProductoAlmacen(@PathVariable Long id_producto,
			@PathVariable Long id_almacen) {
		return movimientoService.MovimientoByIdProductoAlmacen(id_producto, id_almacen);
	}

	@GetMapping("/movimiento")
	public List<Movimiento> findAll() {
		return movimientoService.findAll();
	}

	@PostMapping("/movimiento")
	public ResponseEntity<?> save(@Valid @RequestBody Movimiento movimiento, BindingResult result) {
		Map<String, Object> response = new HashMap<String, Object>();
		Movimiento nuevoMovimiento = null;
		if (result.hasErrors()) {
			List<String> error = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			response.put("error", error);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			Map<String, Object> movimientoProductoAlmacen = new HashMap<String, Object>();
			if (movimiento.getCantidad_ingreso() == 0 || movimiento.getCantidad_salida() == 0) {
				List<String> error = new ArrayList<String>();
				error.add("La cantidad ingresada no puede ser 0");
				response.put("error", error);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
			if (movimiento.getTipo_movimiento().getId_tipo_movimiento() == 2) {
				movimientoProductoAlmacen = movimientoService.MovimientoByIdProductoAlmacen(
						movimiento.getProducto().getId_producto(), movimiento.getAlmacen().getId_almacen());
				if (movimientoProductoAlmacen.isEmpty()) {
					List<String> error = new ArrayList<String>();
					error.add("El producto no cuenta con stock en el almacen: "
							+ movimiento.getAlmacen().getDescripcion());
					response.put("error", error);
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
				} else {
					if ((Integer.parseInt(movimientoProductoAlmacen.get("cant_ingreso").toString())
							- Integer.parseInt(movimientoProductoAlmacen.get("cant_salida").toString())) < movimiento
									.getCantidad_salida()) {
						List<String> error = new ArrayList<String>();
						error.add("La cantidad ingresada es mayor al stock actual del producto en el almacen: "
								+ movimiento.getAlmacen().getDescripcion());
						response.put("error", error);
						return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
					}
				}
			}
			nuevoMovimiento = movimientoService.save(movimiento);
		} catch (DataAccessException e) {
			response.put("error", "Error al registrar un nuevo movimiento");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("movimiento", nuevoMovimiento);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
