package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mys.ventas.models.dao.IMenuEmpleadoDAO;
import mys.ventas.models.entity.Menu;
import mys.ventas.models.entity.MenuEmpleado;
import mys.ventas.models.services.IMenuEmpleadoService;

@Service
public class MenuEmpleadoServiceImplements implements IMenuEmpleadoService{

	@Autowired
	private IMenuEmpleadoDAO menuEmpleadoDao;

	@Override
	public MenuEmpleado save(MenuEmpleado menuEmpleado) {
		return menuEmpleadoDao.save(menuEmpleado);
	}

	@Override
	public void deleteByIdEmpleado(Long id_empleado) {
		menuEmpleadoDao.deleteByIdEmpleado(id_empleado);
	}

	@Override
	public List<MenuEmpleado> findMenuByEmpleado(Long id_empleado) {
		return menuEmpleadoDao.findMenuByEmpleado(id_empleado);
	}



	
}
