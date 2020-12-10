package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.ITipoOperacionDAO;
import mys.ventas.models.entity.TipoOperacion;
import mys.ventas.models.services.ITipoOperacionService;

@Service
public class TipoOperacionServiceImplements implements ITipoOperacionService{

	@Autowired
	private ITipoOperacionDAO tipoOperacionDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<TipoOperacion> findAll() {
		return (List<TipoOperacion>)tipoOperacionDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public TipoOperacion findById(Long id_tipo_operacion) {
		return tipoOperacionDAO.findById(id_tipo_operacion).orElse(null);
	}

}
