package mys.ventas.models.services;

import java.util.List;

import mys.ventas.models.entity.MenuEmpleado;

public interface IMenuEmpleadoService {

	public MenuEmpleado save(MenuEmpleado menuEmpleado);
	
	public void deleteByIdEmpleado(Long id_empleado);
	
	public List<MenuEmpleado> findMenuByEmpleado(Long id_empleado);
	
}
