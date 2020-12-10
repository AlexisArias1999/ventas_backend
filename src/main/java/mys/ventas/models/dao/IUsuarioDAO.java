package mys.ventas.models.dao;
import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mys.ventas.models.entity.Usuario;

public interface IUsuarioDAO extends CrudRepository<Usuario, Long> {

	@Query(value = "SELECT U.USUARIO,U.CLAVE FROM USUARIOS U", nativeQuery = true)
	public Page<Map<String, Object>> usuarioPaginacion(Pageable pageable);

	@Query("from Usuario where usuario = ?1")
	public Usuario findByUsername(String username);
	
}
