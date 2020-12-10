package mys.ventas.models.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import mys.ventas.models.entity.Recibo;

public interface IReciboDAO extends CrudRepository<Recibo, Long>{

	@Query(value = "SELECT COALESCE(SUM(R.PAGADO),0) AS PAGADO FROM RECIBOS R WHERE R.ID_VENTA = ?", nativeQuery =true)
	public Map<Double, Object> ObtenerDeudaVenta(Long id_venta);
	

	@Query(value = "SELECT \r\n" + 
			"R.ID_RECIBO,\r\n" + 
			"R.ID_VENTA,\r\n" + 
			"D.DESCRIPCION AS DOCUMENTO,\r\n" + 
			"V.NRO_DOCUMENTO,\r\n" + 
			"R.NRO_RECIBO,\r\n" + 
			"R.REGISTRO,\r\n" + 
			"R.VENCIMIENTO,\r\n" + 
			"CONCAT(C.APELLIDO_PATERNO,' ', C.APELLIDO_MATERNO ,' ',C.NOMBRES) AS NOMBRES,\r\n" + 
			"RE.DESCRIPCION AS ESTADO,\r\n" + 
			"RE.ID_RECIBO_ESTADO,\r\n" + 
			"R.PAGADO\r\n" + 
			"FROM RECIBOS R\r\n" + 
			"INNER JOIN VENTAS V ON R.ID_VENTA = V.ID_VENTA\r\n" + 
			"INNER JOIN DOCUMENTOS D ON D.ID_DOCUMENTO = V.ID_DOCUMENTO\r\n" + 
			"INNER JOIN CLIENTES C ON C.ID_CLIENTE = V.ID_CLIENTE\r\n" + 
			"INNER JOIN RECIBO_ESTADO RE ON RE.ID_RECIBO_ESTADO = R.ID_RECIBO_ESTADO \r\n" + 
			"WHERE R.ID_VENTA = ?", nativeQuery =true)
	public List<Map<String, Object>> findAllReciboVenta(Long id_venta);
	
	@Query(value = "SELECT \r\n" + 
			"RE.ID_RECIBO_ESTADO,\r\n" + 
			"RE.DESCRIPCION AS ESTADO,\r\n" + 
			"CONCAT(D1.DESCRIPCION,' ',R.NRO_RECIBO) AS RECIBO,\r\n" + 
			"CONCAT(D2.DESCRIPCION,' ',V.NRO_DOCUMENTO) AS REFERENCIA,\r\n" + 
			"(CASE \r\n" + 
			"WHEN C.RAZON_SOCIAL = '' THEN CONCAT(C.APELLIDO_PATERNO,' ',C.APELLIDO_MATERNO,' ',C.NOMBRES)\r\n" + 
			"ELSE C.RAZON_SOCIAL\r\n" + 
			"END) AS CLIENTE,\r\n" + 
			"V.TOTAL_VENTA AS DEUDA,\r\n" + 
			"R.PAGADO AS MONTO_RECIBO\r\n" + 
			"FROM RECIBOS R\r\n" + 
			"INNER JOIN VENTAS V ON V.ID_VENTA = R.ID_VENTA\r\n" + 
			"INNER JOIN RECIBO_ESTADO RE ON RE.ID_RECIBO_ESTADO = R.ID_RECIBO_ESTADO\r\n" + 
			"INNER JOIN DOCUMENTOS D1 ON D1.ID_DOCUMENTO = R.ID_DOCUMENTO \r\n" + 
			"INNER JOIN DOCUMENTOS D2 ON D2.ID_DOCUMENTO = V.ID_DOCUMENTO\r\n" + 
			"INNER JOIN CLIENTES C ON C.ID_CLIENTE = V.ID_CLIENTE\r\n" + 
			"WHERE V.ID_EMPRESA = ?", nativeQuery =true)
	public Page<Map<String, Object>> PaginacionRecibos(Long id_empresa, Pageable pageable);
	
}
