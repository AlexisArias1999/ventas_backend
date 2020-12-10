package mys.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.ventas.models.entity.DocumentoPersona;
import mys.ventas.models.services.IDocumentoPersonaService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class DocumentoPersonaRest {

	@Autowired
	private IDocumentoPersonaService documentoPersonaService;
	
	@GetMapping("/documento_persona")
	public List<DocumentoPersona> findAll(){
		return documentoPersonaService.findAll();
	}
	
	@GetMapping("/documento_persona/{id_documento_persona}")
	public DocumentoPersona findById(@PathVariable Long id_documento_persona){
		return documentoPersonaService.findById(id_documento_persona);
	}
	
}
