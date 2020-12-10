package mys.ventas.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import mys.ventas.models.entity.Documento;

public interface IDocumentoDAO extends CrudRepository<Documento, Long>{

	@Query(value = "SELECT * FROM DOCUMENTOS WHERE DOC_VENTA = TRUE", nativeQuery =true)
	public List<Documento> obtenerDocumentoNotaVenta();
	
	@Query(value = "SELECT * FROM DOCUMENTOS WHERE DOC_VENTA = FALSE AND COMPROBANTES_ELECTRONICOS = TRUE", nativeQuery =true)
	public List<Documento> obtenerDocumentosComprobante();
	
}
