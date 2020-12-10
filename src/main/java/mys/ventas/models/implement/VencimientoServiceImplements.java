package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IVencimientoDAO;
import mys.ventas.models.entity.Vencimiento;
import mys.ventas.models.services.IVencimientoService;

@Service
public class VencimientoServiceImplements implements IVencimientoService{

	@Autowired
	private IVencimientoDAO vencimientoDAO;
	
	@Override
	@Transactional(readOnly = false)
	public List<Vencimiento> findAll() {
		return (List<Vencimiento>) vencimientoDAO.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Vencimiento findById(Long id_vencimiento) {
		return vencimientoDAO.findById(id_vencimiento).orElse(null);
	}

}
