package mys.ventas.models.dao;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import mys.ventas.models.entity.Entidad;

public interface IEntidadDAO extends CrudRepository<Entidad, Long> {

	@Query(value = "SELECT\r\n" + 
			"X.ID_FORMA_PAGO,\r\n" + 
			"X.ID_ENTIDAD,\r\n" + 
			"CONCAT(E.DESCRIPCION, ' - ' , T.DESCRIPCION, ' - N°', E.NRO_CUENTA) AS DESCRIPCION\r\n" + 
			"FROM FORMA_PAGO_ENTIDADES X\r\n" + 
			"INNER JOIN ENTIDADES E ON X.ID_ENTIDAD = E.ID_ENTIDAD\r\n" + 
			"INNER JOIN TIPO_CUENTA T ON E.ID_TIPO_CUENTA= T.ID_TIPO_CUENTA\r\n" + 
			"WHERE X.ID_FORMA_PAGO = ?", nativeQuery = true)
	public List<Map<String, Object>> getAllEntidadIdFormaPago(Long id_forma_pago);

}
