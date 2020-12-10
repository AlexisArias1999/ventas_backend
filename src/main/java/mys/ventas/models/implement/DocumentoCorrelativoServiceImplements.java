package mys.ventas.models.implement;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IDocumentoCorrelativoDAO;
import mys.ventas.models.entity.DocumentoCorrelativo;
import mys.ventas.models.services.IDocumentoCorrelativoService;

@Service
public class DocumentoCorrelativoServiceImplements implements IDocumentoCorrelativoService{

	@Autowired
	private IDocumentoCorrelativoDAO documentoCorrelativoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<DocumentoCorrelativo> findAll() {
		return (List<DocumentoCorrelativo>)documentoCorrelativoDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> obtenerCorrelativoDocumento(Long id_documento) {
		return documentoCorrelativoDAO.obtenerCorrelativoDocumento(id_documento);
	}

	@Override
	@Transactional(readOnly = true)
	public DocumentoCorrelativo aumCorrelativo(DocumentoCorrelativo documentoCorrelativo) {
		return documentoCorrelativoDAO.save(documentoCorrelativo);
	}

	@Override
	@Transactional(readOnly = true)
	public DocumentoCorrelativo findById(Long id_documento) {
		return documentoCorrelativoDAO.findById(id_documento).orElse(null);
	}

	@Override
	public DocumentoCorrelativo save(DocumentoCorrelativo documentoCorrelativo) {
		return documentoCorrelativoDAO.save(documentoCorrelativo);
	}

	@Override
	public DocumentoCorrelativo DataCorrelativoDocumentoIdDocumento(Long id_documento) {
		return documentoCorrelativoDAO.DataCorrelativoDocumentoIdDocumento(id_documento);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Map<String, Object>> obtenercorrealtivos() {
		return documentoCorrelativoDAO.obtenercorrealtivos();
	}
	
	
	
}
