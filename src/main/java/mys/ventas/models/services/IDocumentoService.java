package mys.ventas.models.services;

import java.util.List;

import mys.ventas.models.entity.Documento;

public interface IDocumentoService {

	public List<Documento> findAll();
	
	public List<Documento> obtenerDocumentoNotaVenta();
	
	public List<Documento> obtenerDocumentosComprobante();
	
	public Documento findById(Long id_documento);
	
}
