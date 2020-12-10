package mys.ventas.models.services;

import java.util.List;
import java.util.Map;

import mys.ventas.models.entity.DocumentoCorrelativo;

public interface IDocumentoCorrelativoService  {

	public List<DocumentoCorrelativo> findAll();
	
	public DocumentoCorrelativo findById(Long id_documento);
	
	public DocumentoCorrelativo DataCorrelativoDocumentoIdDocumento(Long id_documento);
	
	public DocumentoCorrelativo save(DocumentoCorrelativo documentoCorrelativo);
	
	public DocumentoCorrelativo aumCorrelativo(DocumentoCorrelativo documentoCorrelativo);
	
	public Map<String, Object> obtenerCorrelativoDocumento(Long id_documento);
	
	public List<Map<String, Object>> obtenercorrealtivos();
	
}
