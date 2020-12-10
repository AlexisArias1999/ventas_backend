package mys.ventas.models.services;

import java.util.List;
import mys.ventas.models.entity.TipoOperacion;

public interface ITipoOperacionService {

	public List<TipoOperacion> findAll();
	
	public TipoOperacion findById(Long id_tipo_operacion);
	
}
