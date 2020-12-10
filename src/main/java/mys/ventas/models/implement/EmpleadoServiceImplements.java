package mys.ventas.models.implement;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IEmpleadoDAO;
import mys.ventas.models.entity.Empleado;
import mys.ventas.models.services.IEmpleadoService;

@Service
public class EmpleadoServiceImplements implements IEmpleadoService{

	@Autowired
	private IEmpleadoDAO empleadoDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAll() {
		return (List<Empleado>)empleadoDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado findById(Long id_empleado) {
		return empleadoDAO.findById(id_empleado).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Map<String, Object>> PaginacionEmpleado(Pageable pageable) {
		return empleadoDAO.PaginacionEmpleado(pageable);
	}

	@Override
	public Empleado save(Empleado empleado) {
		return empleadoDAO.save(empleado);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Map<String, Object>> RegistrosEspecialistas() {
		return empleadoDAO.RegistrosEspecialistas();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Map<String, Object>> RegistrosEmpleadosByEmpresa(Long id_empresa) {
		return empleadoDAO.RegistrosEmpleadosByEmpresa(id_empresa);
	}

}
