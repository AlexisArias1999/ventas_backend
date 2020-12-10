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

import mys.ventas.models.entity.TipoCuenta;
import mys.ventas.models.services.ITipoCuentaService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class TipoCuentaRest {

	@Autowired
	private ITipoCuentaService CajaBancoService;

	@GetMapping("/tipo_cuentas")
	public List<TipoCuenta> findAll() {
		return CajaBancoService.findAll();
	}

	@GetMapping("/tipo_cuentas/{id_tipo_cuenta}")
	public TipoCuenta findById(@PathVariable Long id_tipo_cuenta) {
		return CajaBancoService.findById(id_tipo_cuenta);
	}

	@PostMapping("/tipo_cuentas")
	public TipoCuenta save(@RequestBody TipoCuenta tipoCuenta) {
		return CajaBancoService.save(tipoCuenta);
	}

}
