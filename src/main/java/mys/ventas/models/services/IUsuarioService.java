package mys.ventas.models.services;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mys.ventas.models.entity.Usuario;

public interface IUsuarioService {

	public List<Usuario> findAll();
	
	public Usuario save(Usuario usuario);
	
	public Usuario findById(Long id_usuario);
	
	public Page<Map<String, Object>> usuarioPaginacion(Pageable pageable);
	
	public Usuario findByUsername(String usuario);

}
