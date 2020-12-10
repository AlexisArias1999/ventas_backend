package mys.ventas.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
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

import mys.ventas.models.entity.Producto;
import mys.ventas.models.services.IProductoService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class ProductoRest {

	@Autowired
	private IProductoService productoService;

	@GetMapping("/producto")
	public List<Producto> findAll() {
		return productoService.findAll();
	}

	@GetMapping("/producto/{id_producto}")
	public ResponseEntity<?> findById(@PathVariable Long id_producto) {
		Map<String, Object> response = new HashMap<String, Object>();
		Producto productoBuscar = productoService.findById(id_producto);
		if(productoBuscar == null) {
			response.put("mensaje", "Producto no encontrado");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		response.put("producto", productoBuscar);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PostMapping("/producto")
	public ResponseEntity<?> save(@Valid @RequestBody Producto producto, BindingResult result) {
		Map<String, Object> response = new HashMap<String, Object>();
		Producto nuevoProducto = null;
		if (result.hasErrors()) {
			List<String> error = result.getFieldErrors().stream().map(err -> {
				return err.getDefaultMessage();
			}).collect(Collectors.toList());
			response.put("error", error);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			nuevoProducto = productoService.save(producto);
			response.put("producto", nuevoProducto);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al registrar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PostMapping("/producto/upload")
	public ResponseEntity<?> cargarImagenProducto(@RequestParam("archivo") MultipartFile archivo,
			@RequestParam("id_producto") Long id_producto) {
		Map<String, Object> response = new HashMap<>();
		Producto producto = productoService.findById(id_producto);
		if (!archivo.isEmpty()) {
			String nombreArchivo = UUID.randomUUID().toString() + "_" + producto.getId_producto() + ".png";
			Path rutaAchivo = Paths.get("src/main/resources/static/upload/productos/").resolve(nombreArchivo)
					.toAbsolutePath();
			try {
				Files.copy(archivo.getInputStream(), rutaAchivo);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen");
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			String nombreFotoAnterior = producto.getImagen();
			if (nombreFotoAnterior != null && nombreFotoAnterior.length() > 0) {
				Path rutaFotoAnterior = Paths.get("src/main/resources/static/upload/productos/")
						.resolve(nombreFotoAnterior).toAbsolutePath();
				File ArchivoAnterior = rutaFotoAnterior.toFile();
				if (ArchivoAnterior.exists() && ArchivoAnterior.canRead()) {
					ArchivoAnterior.delete();
				}
			}
			producto.setImagen(rutaAchivo.toString());
			productoService.save(producto);
			response.put("producto", producto);
			response.put("mensaje", "Has subido correctamente la imagen: " + nombreArchivo);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
