package mys.ventas.models.services;

import java.util.List;

import mys.ventas.models.entity.TipoPersona;

public interface ITipoPersonaService {

	public List<TipoPersona> findAll();
	
	public TipoPersona findById(Long id_tipo_persona);
	
}
