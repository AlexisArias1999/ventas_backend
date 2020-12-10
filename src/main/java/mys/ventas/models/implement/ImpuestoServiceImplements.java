package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IImpuestoDAO;
import mys.ventas.models.entity.Impuesto;
import mys.ventas.models.services.IImpuestoService;

@Service
public class ImpuestoServiceImplements implements IImpuestoService{

	@Autowired
	private IImpuestoDAO impuestoDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Impuesto> findAll() {
		return (List<Impuesto>) impuestoDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Impuesto findById(Long id_impuesto) {
		return impuestoDAO.findById(id_impuesto).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public Impuesto save(Impuesto impuesto) {
		return impuestoDAO.save(impuesto);
	}

}
