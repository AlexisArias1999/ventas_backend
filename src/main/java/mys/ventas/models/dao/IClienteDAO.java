package mys.ventas.models.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mys.ventas.models.entity.Cliente;

public interface IClienteDAO extends CrudRepository<Cliente, Long>{
	
	@Query(value = "SELECT \r\n" + 
			"C.ID_CLIENTE,\r\n" + 
			"CONCAT(C.APELLIDO_PATERNO,' ',C.APELLIDO_MATERNO,' ',C.NOMBRES) AS NOMBRES,\r\n" + 
			"C.TELEFONO,\r\n" + 
			"TO_CHAR((SUM(V.TOTAL_VENTA)-COALESCE(SUM(PAGADO),0)),'999G999G999G999D99') AS DEUDA\r\n" + 
			"FROM CLIENTES C \r\n" + 
			"INNER JOIN VENTA V ON C.ID_CLIENTE = V.ID_CLIENTE\r\n" + 
			"LEFT JOIN OPERACIONES O ON O.ID_VENTA = V.ID_VENTA\r\n" + 
			"GROUP BY V.TOTAL_VENTA,C.ID_CLIENTE", nativeQuery =true)
	public List<Map<String, Object>> findAllCliente();
	
	@Query(value = "SELECT \r\n" + 
			"C.ID_CLIENTE,\r\n" + 
			"CONCAT(C.APELLIDO_PATERNO,' ',C.APELLIDO_MATERNO,' ',C.NOMBRES) AS NOMBRES,\r\n" + 
			"C.TELEFONO,\r\n" + 
			"TO_CHAR((SUM(V.TOTAL_VENTA)-COALESCE(SUM(PAGADO),0)),'999G999G999G999D99') AS DEUDA\r\n" + 
			"FROM CLIENTES C \r\n" + 
			"INNER JOIN VENTA V ON C.ID_CLIENTE = V.ID_CLIENTE\r\n" + 
			"LEFT JOIN OPERACIONES O ON O.ID_VENTA = V.ID_VENTA\r\n" + 
			"GROUP BY V.TOTAL_VENTA,C.ID_CLIENTE", nativeQuery =true)
	public Page<Map<String, Object>> paginacionCliente(Pageable pageable);
	
	@Query(value = "SELECT \r\n" + 
			"C.ID_CLIENTE,\r\n" + 
			"(CASE \r\n" + 
			"WHEN C.RAZON_SOCIAL = '' THEN CONCAT(C.APELLIDO_PATERNO,' ',C.APELLIDO_MATERNO,' ',C.NOMBRES)\r\n" + 
			"ELSE C.RAZON_SOCIAL\r\n" + 
			"END) AS CLIENTE,\r\n" + 
			"C.NRO_DOCUMENTO,\r\n" + 
			"C.CORREO,\r\n" + 
			"C.CELULAR,\r\n" + 
			"C.DIRECCION,\r\n" + 
			"DP.DESCRIPCION AS DOCUMENTO,\r\n" + 
			"TP.DESCRIPCION AS PERSONA,C.CREADO\r\n" + 
			"FROM CLIENTES C\r\n" + 
			"INNER JOIN DOCUMENTO_PERSONA DP ON DP.ID_DOCUMENTO_PERSONA = C.ID_DOCUMENTO_PERSONA\r\n" + 
			"INNER JOIN TIPO_PERSONA TP ON TP.ID_TIPO_PERSONA = C.ID_TIPO_PERSONA\r\n" + 
			"ORDER BY C.CREADO DESC" + 
			"", nativeQuery =true)
	public Page<Map<String, Object>> findAllClientesRUCDNI(Pageable pageable);
	
	
}
