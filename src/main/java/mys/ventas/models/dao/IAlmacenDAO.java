package mys.ventas.models.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mys.ventas.models.entity.Almacen;

public interface IAlmacenDAO extends JpaRepository<Almacen, Long>{

	@Query(value = "SELECT * FROM ALMACENES WHERE ID_EMPRESA = ?", nativeQuery =true)
	public List<Map<String, Object>> findByIdEmpresa(Long id_empresa);
	
}
