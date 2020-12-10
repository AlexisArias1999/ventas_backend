package mys.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.ventas.models.entity.Documento;
import mys.ventas.models.services.IDocumentoService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class DocumentoRest {
	
	 @Autowired
	 private IDocumentoService documentoService;
	 
	 @GetMapping("/documentos")
	 private List<Documento> findAll(){
		 return documentoService.findAll();
	 }
	 
	 @GetMapping("/documentos/ventas")
	 private List<Documento> obtenerDocumentosVenta(){
		 return documentoService.obtenerDocumentoNotaVenta();
	 }
	 
	 @GetMapping("/documentos/ventas/comprobantes")
	 private List<Documento> obtenerDocumentosComprobante(){
		 return documentoService.obtenerDocumentosComprobante();
	 }
	 
	 @GetMapping("/documentos/{id_documento}")
	 private Documento findById(@PathVariable Long id_documento){
		 return documentoService.findById(id_documento);
	 }
}
