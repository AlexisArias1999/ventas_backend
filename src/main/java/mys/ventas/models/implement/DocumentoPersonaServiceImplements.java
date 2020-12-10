package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IDocumentoPersonaDAO;
import mys.ventas.models.entity.DocumentoPersona;
import mys.ventas.models.services.IDocumentoPersonaService;

@Service
public class DocumentoPersonaServiceImplements implements IDocumentoPersonaService {

	@Autowired
	private IDocumentoPersonaDAO documentoPersonaDAO;

	@Override
	@Transactional(readOnly = true)
	public List<DocumentoPersona> findAll() {
		return (List<DocumentoPersona>) documentoPersonaDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public DocumentoPersona findById(Long id_documento_persona) {
		return documentoPersonaDAO.findById(id_documento_persona).orElse(null);
	}

}
