package mys.ventas.models.services;

import java.util.List;

import mys.ventas.models.entity.ReciboEstado;

public interface IReciboEstadoService {

	public List<ReciboEstado> findAll();
	
	public ReciboEstado findById(Long id_recibo_estado);
	
	public ReciboEstado save(ReciboEstado ReciboEstado);
	
}
