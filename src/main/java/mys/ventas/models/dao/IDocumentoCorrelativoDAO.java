package mys.ventas.models.dao;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mys.ventas.models.entity.DocumentoCorrelativo;

public interface IDocumentoCorrelativoDAO extends CrudRepository<DocumentoCorrelativo, Long>{

	@Query(value = "SELECT CONCAT(SERIE,'-',RIGHT('00000000'||DC.EMITIDOS + 1,8)) AS CORRELATIVO, RIGHT('00000000'||DC.EMITIDOS + 1,8) AS NRO FROM DOCUMENTO_CORRELATIVO DC WHERE DC.ID_DOCUMENTO = ?", nativeQuery =true)
	public Map<String, Object> obtenerCorrelativoDocumento(Long id_documento);
	
	@Query(value = "SELECT\r\n" + 
			"DC.ID_DOCUMENTO,\r\n" + 
			"CONCAT(SERIE,'-',RIGHT('00000000'||DC.EMITIDOS + 1,8)) AS CORRELATIVO, RIGHT('00000000'||DC.EMITIDOS + 1,8) AS NRO\r\n" + 
			"FROM DOCUMENTO_CORRELATIVO DC", nativeQuery =true)
	public List<Map<String, Object>> obtenercorrealtivos();
	
	@Query(value = "SELECT * FROM DOCUMENTO_CORRELATIVO WHERE ID_DOCUMENTO = ?", nativeQuery =true)
	public DocumentoCorrelativo DataCorrelativoDocumentoIdDocumento(Long id_documento);
	
}
