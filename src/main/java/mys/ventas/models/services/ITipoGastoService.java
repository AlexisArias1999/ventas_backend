package mys.ventas.models.services;

import java.util.List;

import mys.ventas.models.entity.TipoGasto;

public interface ITipoGastoService {

	public List<TipoGasto> findAll();
	
	public TipoGasto findById(Long id_tipo_gasto);
	
	public TipoGasto save(TipoGasto tipoGasto);
	
}
