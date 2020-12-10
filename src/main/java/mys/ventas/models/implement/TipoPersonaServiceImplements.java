package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.ITipoPersonaDAO;
import mys.ventas.models.entity.TipoPersona;
import mys.ventas.models.services.ITipoPersonaService;

@Service
public class TipoPersonaServiceImplements implements ITipoPersonaService{

	@Autowired
	private ITipoPersonaDAO tipoPersonaDAO;

	@Override
	@Transactional(readOnly = true)
	public List<TipoPersona> findAll() {
		return (List<TipoPersona>)tipoPersonaDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public TipoPersona findById(Long id_tipo_persona) {
		return tipoPersonaDAO.findById(id_tipo_persona).orElse(null);
	}
	
}
