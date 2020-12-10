package mys.ventas.models.dao;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mys.ventas.models.entity.Optometria;

public interface IOptometriaDAO extends JpaRepository<Optometria, Long>{

	@Query(value = "SELECT\r\n" + 
			"O.ID_OPTOMETRIA,\r\n" + 
			"(CASE \r\n" + 
			"WHEN C.RAZON_SOCIAL = '' OR C.RAZON_SOCIAL IS NULL THEN CONCAT(C.APELLIDO_PATERNO,' ',C.APELLIDO_MATERNO,' ',C.NOMBRES)\r\n" + 
			"ELSE C.RAZON_SOCIAL\r\n" + 
			"END) AS CLIENTE,\r\n" + 
			"(CASE \r\n" + 
			"WHEN E.RAZON_SOCIAL = '' OR E.RAZON_SOCIAL IS NULL THEN CONCAT(E.APELLIDO_PATERNO,' ',E.APELLIDO_MATERNO,' ',E.NOMBRES)\r\n" + 
			"ELSE E.RAZON_SOCIAL\r\n" + 
			"END) AS ESPECIALISTA,\r\n" + 
			"O.CREADO\r\n" + 
			"FROM OPTOMETRIA O\r\n" + 
			"INNER JOIN CLIENTES C ON O.ID_CLIENTE = C.ID_CLIENTE\r\n" + 
			"INNER JOIN EMPLEADOS E ON E.ID_EMPLEADO = O.ID_EMPLEADO\r\n" + 
			"WHERE C.ID_CLIENTE = ?", nativeQuery =true)
	public Page<Map<String, Object>> PaginacionGestionarOptometria(Long id_cliente, Pageable pageable);
	
}
