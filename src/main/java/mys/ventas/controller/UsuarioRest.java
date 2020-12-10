package mys.ventas.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.ventas.models.entity.Usuario;
import mys.ventas.models.services.IUsuarioService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class UsuarioRest {

	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/usuario")
	public List<Usuario> findAll(){
		return usuarioService.findAll();
	}
	
	@GetMapping("/usuario/page/{page}")
	public Page<Map<String, Object>> usuarioPaginacion(@PathVariable Integer page){
		return usuarioService.usuarioPaginacion(PageRequest.of(page, 5));
	}
	
	@PostMapping("/usuario")
	public Usuario save(@RequestBody Usuario usuario) {
		String passwordBCrypt = passwordEncoder.encode(usuario.getPassword());
		usuario.setUsername(passwordBCrypt);
		return usuarioService.save(usuario);
	}

}
