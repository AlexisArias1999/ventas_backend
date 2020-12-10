package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.ITipoGastoDAO;
import mys.ventas.models.entity.TipoGasto;
import mys.ventas.models.services.ITipoGastoService;

@Service
public class TipoGastoServiceImplements implements ITipoGastoService{

	@Autowired
	private ITipoGastoDAO tipoGastoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<TipoGasto> findAll() {
		return (List<TipoGasto>)tipoGastoDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public TipoGasto findById(Long id_tipo_gasto) {
		return tipoGastoDAO.findById(id_tipo_gasto).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public TipoGasto save(TipoGasto tipoGasto) {
		return tipoGastoDAO.save(tipoGasto);
	}
	
}
