package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.ITipoAfectacionDAO;
import mys.ventas.models.entity.TipoAfectacion;
import mys.ventas.models.services.ITipoAfectacionService;

@Service
public class TipoAfectacionServiceImplements implements ITipoAfectacionService{

	@Autowired
	private ITipoAfectacionDAO tipoAfectacionDAO;

	@Override
	@Transactional(readOnly = true)
	public Page<TipoAfectacion> paginacion(Pageable pageable) {
		return tipoAfectacionDAO.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public TipoAfectacion findById(Long id_tipo_afectacion) {
		return tipoAfectacionDAO.findById(id_tipo_afectacion).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public TipoAfectacion save(TipoAfectacion afectacion) {
		return tipoAfectacionDAO.save(afectacion);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoAfectacion> findAll() {
		return (List<TipoAfectacion>)tipoAfectacionDAO.findAll();
	}
	
}
