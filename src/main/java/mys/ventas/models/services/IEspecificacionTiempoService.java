package mys.ventas.models.services;

import java.util.List;

import mys.ventas.models.entity.EspecificacionTiempo;

public interface IEspecificacionTiempoService {

	public List<EspecificacionTiempo> findAll();
	
	public EspecificacionTiempo findById(Long id_especificacion_tiempo);
	
}
