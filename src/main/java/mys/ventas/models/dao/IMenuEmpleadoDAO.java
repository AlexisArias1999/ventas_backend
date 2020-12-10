package mys.ventas.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mys.ventas.models.entity.MenuEmpleado;

public interface IMenuEmpleadoDAO extends JpaRepository<MenuEmpleado, Long>{

	@Query(value = "DELETE FROM MENUS_EMPLEADOS WHERE ID_EMPLEADO = ?" , nativeQuery = true)
	public void deleteByIdEmpleado(Long id_empleado);
	
	@Query(value = "SELECT \r\n" + 
			"ME.*\r\n" + 
			"FROM MENUS_EMPLEADOS ME\r\n" + 
			"INNER JOIN MENUS M ON M.ID_MENU = ME.ID_MENU AND M.MENU = TRUE\r\n" + 
			"WHERE ME.ID_EMPLEADO = ? AND ME.MENU = TRUE", nativeQuery = true)
	public List<MenuEmpleado> findMenuByEmpleado(Long id_empleado);
	

}
