package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IDocumentoDAO;
import mys.ventas.models.entity.Documento;
import mys.ventas.models.services.IDocumentoService;

@Service
public class DocumentoServiceImplements implements IDocumentoService{
	
	@Autowired
	private IDocumentoDAO documentoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Documento> findAll() {
		return (List<Documento>)documentoDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Documento findById(Long id_documento) {
		return documentoDAO.findById(id_documento).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Documento> obtenerDocumentoNotaVenta() {
		return (List<Documento>)documentoDAO.obtenerDocumentoNotaVenta();
		
	}

	@Override
	public List<Documento> obtenerDocumentosComprobante() {
		return (List<Documento>)documentoDAO.obtenerDocumentosComprobante();
	}
	
	
	
}
