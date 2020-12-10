package mys.ventas.models.implement;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mys.ventas.models.dao.IUsuarioDAO;
import mys.ventas.models.entity.Usuario;
import mys.ventas.models.services.IUsuarioService;

@Service
public class UsuarioServiceImplements implements IUsuarioService{

	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return (List<Usuario>)usuarioDAO.findAll();
	}

	@Override
	public Page<Map<String, Object>> usuarioPaginacion(Pageable pageable) {
		return usuarioDAO.usuarioPaginacion(pageable);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioDAO.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id_usuario) {
		return usuarioDAO.findById(id_usuario).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByUsername(String usuario) {
		return usuarioDAO.findByUsername(usuario);
	}

}
