package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IGastoDAO;
import mys.ventas.models.entity.Gasto;
import mys.ventas.models.services.IGastoService;

@Service
public class GastoServiceImplements implements IGastoService{

	@Autowired
	private IGastoDAO gastoDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Gasto> findAll() {
		return (List<Gasto>)gastoDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Gasto findById(Long id_gasto) {
		return gastoDAO.findById(id_gasto).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public Gasto save(Gasto gasto) {
		return gastoDAO.save(gasto);
	}

}
