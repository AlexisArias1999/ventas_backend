package mys.ventas.models.services;

import java.util.List;

import mys.ventas.models.entity.DocumentoPersona;

public interface IDocumentoPersonaService {

	public List<DocumentoPersona> findAll();
	
	public DocumentoPersona findById(Long id_documento_persona);
	
}
