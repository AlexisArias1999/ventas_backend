package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IFormaPagoDAO;
import mys.ventas.models.entity.FormaPago;
import mys.ventas.models.services.IFormaPagoService;

@Service
public class FormaPagoServiceImplements implements IFormaPagoService{

	@Autowired
	private IFormaPagoDAO formaPagoDAO; 
	
	@Override
	@Transactional(readOnly = true)
	public List<FormaPago> findAll() {
		return (List<FormaPago>)formaPagoDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public FormaPago findById(Long id_empresa) {
		return formaPagoDAO.findById(id_empresa).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public FormaPago save(FormaPago formaPago) {
		return formaPagoDAO.save(formaPago);
	}

}
