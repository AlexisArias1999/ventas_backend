package mys.ventas.models.dao;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mys.ventas.models.entity.Movimiento;

public interface IMovimientoDAO extends JpaRepository<Movimiento, Long>{

	@Query(value = "SELECT\r\n" + 
			"P.ID_PRODUCTO,\r\n" + 
			"P.NOMBRE,\r\n" + 
			"A.DESCRIPCION AS ALMACEN,\r\n" + 
			"SUM(M.CANTIDAD_INGRESO) AS CANT_INGRESO,\r\n" + 
			"SUM(M.CANTIDAD_SALIDA) AS CANT_SALIDA\r\n" + 
			"FROM \r\n" + 
			"MOVIMIENTOS M\r\n" + 
			"INNER JOIN PRODUCTOS P ON M.ID_PRODUCTO = P.ID_PRODUCTO\r\n" + 
			"INNER JOIN ALMACENES A ON M.ID_ALMACEN = A.ID_ALMACEN\r\n" + 
			"WHERE M.ID_EMPRESA = ?\r\n" + 
			"GROUP BY P.NOMBRE, A.DESCRIPCION,P.ID_PRODUCTO", nativeQuery =true)
	public Page<Map<String, Object>> PagiacionMovimientosProductos(Long id_empresa, Pageable pageable);

	@Query(value = "SELECT\r\n" + 
			"P.ID_PRODUCTO,\r\n" + 
			"P.NOMBRE,\r\n" + 
			"A.DESCRIPCION AS ALMACEN,\r\n" + 
			"SUM(M.CANTIDAD_INGRESO) AS CANT_INGRESO,\r\n" + 
			"SUM(COALESCE(M.CANTIDAD_SALIDA,0)) AS CANT_SALIDA\r\n" + 
			"FROM \r\n" + 
			"MOVIMIENTOS M\r\n" + 
			"INNER JOIN PRODUCTOS P ON M.ID_PRODUCTO = P.ID_PRODUCTO\r\n" + 
			"INNER JOIN ALMACENES A ON M.ID_ALMACEN = A.ID_ALMACEN\r\n" + 
			"WHERE P.ID_PRODUCTO = ?\r\n" + 
			"GROUP BY P.NOMBRE, A.DESCRIPCION,P.ID_PRODUCTO", nativeQuery =true)
	public Map<String, Object> MovimientoByIdProducto(Long id_producto);
	
	@Query(value = "SELECT\r\n" + 
			"P.ID_PRODUCTO,\r\n" + 
			"P.NOMBRE,\r\n" + 
			"A.DESCRIPCION AS ALMACEN,\r\n" + 
			"SUM(COALESCE(M.CANTIDAD_INGRESO,0)) AS CANT_INGRESO,\r\n" + 
			"SUM(COALESCE(M.CANTIDAD_SALIDA,0)) AS CANT_SALIDA\r\n" + 
			"FROM \r\n" + 
			"MOVIMIENTOS M\r\n" + 
			"INNER JOIN PRODUCTOS P ON M.ID_PRODUCTO = P.ID_PRODUCTO\r\n" + 
			"INNER JOIN ALMACENES A ON M.ID_ALMACEN = A.ID_ALMACEN\r\n" + 
			"WHERE P.ID_PRODUCTO = ?1\r\n" + 
			"AND M.ID_ALMACEN = ?2\r\n" + 
			"GROUP BY P.NOMBRE, A.DESCRIPCION,P.ID_PRODUCTO", nativeQuery =true)
	public Map<String, Object> MovimientoByIdProductoAlmacen(Long id_producto, Long id_almacen);
	
}
