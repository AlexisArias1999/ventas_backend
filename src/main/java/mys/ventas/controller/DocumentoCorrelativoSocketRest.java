package mys.ventas.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import mys.ventas.models.services.IDocumentoCorrelativoService;

@Controller
public class DocumentoCorrelativoSocketRest {

	@Autowired
	private IDocumentoCorrelativoService documentocorrealtivoService;

	@MessageMapping("/correlativo")
	@SendTo("/mys/correlativo")
	public List<Map<String, Object>> correlativoBoleta(Long id_documento) {
		List<Map<String, Object>> correlativos = documentocorrealtivoService.obtenercorrealtivos();
		return correlativos;
	}

}
