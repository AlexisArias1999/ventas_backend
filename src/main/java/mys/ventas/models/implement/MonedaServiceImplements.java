package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IMonedaDAO;
import mys.ventas.models.entity.Moneda;
import mys.ventas.models.services.IMonedaService;

@Service
public class MonedaServiceImplements implements IMonedaService{

	@Autowired
	private IMonedaDAO monedaDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Moneda> findAll() {
		return (List<Moneda>) monedaDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Moneda findById(Long id_moneda) {
		return monedaDAO.findById(id_moneda).orElse(null);
	}
	
}
