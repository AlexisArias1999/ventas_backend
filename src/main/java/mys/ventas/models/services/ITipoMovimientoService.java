package mys.ventas.models.services;

import java.util.List;

import mys.ventas.models.entity.TipoMovimiento;

public interface ITipoMovimientoService {

	public List<TipoMovimiento> findAll();
	
	public TipoMovimiento findById(Long id_tipo_movimiento);
	
	public TipoMovimiento save(TipoMovimiento tipoMovimiento); 
	
}
