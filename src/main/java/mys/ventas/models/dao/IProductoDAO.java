package mys.ventas.models.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mys.ventas.models.entity.Producto;

public interface IProductoDAO extends CrudRepository<Producto, Long>{
	
	@Query(value = "SELECT P.FOTO FROM PRODUCTOS P WHERE P.FOTO != ''", nativeQuery =true)
	public List<Map<String, Object>> findProductoImagen();
	
}
