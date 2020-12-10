package mys.ventas.models.services;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mys.ventas.models.entity.Empleado;

public interface IEmpleadoService {
	
	public List<Empleado> findAll();
	
	public Empleado findById(Long id_empleado);
	
	public Page<Map<String, Object>> PaginacionEmpleado(Pageable pageable);
	
	public Empleado save(Empleado empleado);
	
	public List<Map<String, Object>> RegistrosEspecialistas();
	
	public List<Map<String, Object>> RegistrosEmpleadosByEmpresa(Long id_empresa);
	
}
