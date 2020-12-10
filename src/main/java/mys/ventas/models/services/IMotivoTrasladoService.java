package mys.ventas.models.services;

import java.util.List;

import mys.ventas.models.entity.MotivoTraslado;


public interface IMotivoTrasladoService {

	public List<MotivoTraslado> findAll();
	
	public MotivoTraslado findById(Long id_motivo_traslado);
	
	public MotivoTraslado save(MotivoTraslado motivoTraslado); 
	
}
