package mys.ventas.models.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mys.ventas.models.entity.Empleado;

public interface IEmpleadoDAO extends CrudRepository<Empleado, Long>{

	@Query(value = "SELECT \r\n" + 
			"E.ID_EMPLEADO,\r\n" + 
			"UPPER(CASE\r\n" + 
			"WHEN E.RAZON_SOCIAL = '' OR E.RAZON_SOCIAL IS NULL THEN CONCAT(E.APELLIDO_PATERNO,' ',E.APELLIDO_MATERNO,' ',E.NOMBRES)\r\n" + 
			"ELSE E.RAZON_SOCIAL\r\n" + 
			"END) AS EMPLEADO,\r\n" + 
			"CONCAT(DP.DESCRIPCION, ' ', E.NRO_DOCUMENTO) AS DOCUMENTO,\r\n" + 
			"E.TELEFONO,\r\n" + 
			"STRING_AGG(REPLACE(R.DESCRIPCION,'ROLE_',''), ', ') as ROLES,\r\n" + 
			"(CASE\r\n" + 
			"WHEN E.ESTADO = TRUE THEN 'HABILITADO'\r\n" + 
			"ELSE 'DESHABILITADO'\r\n" + 
			"END) AS ESTADO\r\n" + 
			"FROM EMPLEADOS E\r\n" + 
			"INNER JOIN USUARIOS U ON E.ID_USUARIO = U.ID_USUARIO\r\n" + 
			"LEFT JOIN USUARIOS_ROLES UR ON U.ID_USUARIO = UR.ID_USUARIO\r\n" + 
			"LEFT JOIN ROLES R ON UR.ID_ROL = R.ID_ROL\r\n" + 
			"INNER JOIN DOCUMENTO_PERSONA DP ON DP.ID_DOCUMENTO_PERSONA = E.ID_DOCUMENTO_PERSONA \r\n" + 
			"GROUP BY E.ID_EMPLEADO, DOCUMENTO\r\n" + 
			"ORDER BY E.ID_EMPLEADO DESC", nativeQuery =true)
	public Page<Map<String, Object>> PaginacionEmpleado(Pageable pageable);
	
	@Query(value = "SELECT\r\n" + 
			"E.ID_EMPLEADO,\r\n" + 
			"UPPER(CASE\r\n" + 
			"WHEN E.RAZON_SOCIAL = '' OR E.RAZON_SOCIAL IS NULL THEN CONCAT(E.APELLIDO_PATERNO,' ',E.APELLIDO_MATERNO,' ',E.NOMBRES)\r\n" + 
			"ELSE E.RAZON_SOCIAL\r\n" + 
			"END) AS EMPLEADO\r\n" + 
			"FROM EMPLEADOS E\r\n" + 
			"INNER JOIN USUARIOS U ON E.ID_USUARIO = U.ID_USUARIO\r\n" + 
			"INNER JOIN USUARIOS_ROLES UR ON U.ID_USUARIO = UR.ID_USUARIO\r\n" + 
			"INNER JOIN ROLES R ON UR.ID_ROL = 1\r\n" + 
			"WHERE E.ESTADO = TRUE\r\n" + 
			"GROUP BY E.ID_EMPLEADO, EMPLEADO", nativeQuery =true)
	public List<Map<String, Object>> RegistrosEspecialistas();
	
	
	@Query(value = "SELECT\r\n" + 
			"E.ID_EMPLEADO,\r\n" + 
			"UPPER(CASE\r\n" + 
			"WHEN E.RAZON_SOCIAL = '' OR E.RAZON_SOCIAL IS NULL THEN CONCAT(E.APELLIDO_PATERNO,' ',E.APELLIDO_MATERNO,' ',E.NOMBRES)\r\n" + 
			"ELSE LTRIM(RTRIM(E.RAZON_SOCIAL))\r\n" + 
			"END) AS EMPLEADO\r\n" + 
			"FROM EMPLEADOS E\r\n" + 
			"INNER JOIN USUARIOS U ON E.ID_USUARIO = U.ID_USUARIO\r\n" + 
			"INNER JOIN USUARIOS_ROLES UR ON U.ID_USUARIO = UR.ID_USUARIO\r\n" + 
			"WHERE E.ESTADO = TRUE AND E.ID_EMPRESA = ? \r\n" + 
			"GROUP BY E.ID_EMPLEADO, EMPLEADO \r\n" + 
			"", nativeQuery =true)
	public List<Map<String, Object>> RegistrosEmpleadosByEmpresa(Long id_empresa);
	
}
