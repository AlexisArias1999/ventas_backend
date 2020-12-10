package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IOperacionDAO;
import mys.ventas.models.entity.Operacion;
import mys.ventas.models.services.IOperacionService;

@Service
public class OperacionServiceImplements implements IOperacionService{

	@Autowired
	private IOperacionDAO operacionDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Operacion> findAll() {
		return (List<Operacion>)operacionDAO.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Operacion save(Operacion operacion) {
		return operacionDAO.save(operacion);
	}

}
