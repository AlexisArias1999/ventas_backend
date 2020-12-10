package mys.ventas.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.ventas.models.entity.Documento;
import mys.ventas.models.entity.DocumentoCorrelativo;
import mys.ventas.models.services.IDocumentoCorrelativoService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class DocumentoCorrelativoRest {

	@Autowired
	private IDocumentoCorrelativoService documentocorrelativoService;
	
	@GetMapping("/documento_correlativo")
	public List<DocumentoCorrelativo> findAll(){
		return documentocorrelativoService.findAll();
	}
	
	@GetMapping("/documento_correlativo/correlativo/{id_documento}")
	public Map<String, Object> obtenerCorrelativoDocumento(@PathVariable Long id_documento){
		return documentocorrelativoService.obtenerCorrelativoDocumento(id_documento);
	}
	
	@PostMapping("/documento_correlativo")
	public DocumentoCorrelativo aumCorrelativo(@RequestBody Documento documento){
		DocumentoCorrelativo correlativoActual = documentocorrelativoService.DataCorrelativoDocumentoIdDocumento(documento.getId_documento());
		DocumentoCorrelativo correlativoUpdate = null;
		correlativoActual.setEmitidos(correlativoActual.getEmitidos()+1);
		correlativoUpdate = correlativoActual;
		return documentocorrelativoService.save(correlativoUpdate);
	}
	
}
