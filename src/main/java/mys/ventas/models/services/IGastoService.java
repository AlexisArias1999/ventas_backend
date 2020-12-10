package mys.ventas.models.services;

import java.util.List;

import mys.ventas.models.entity.Gasto;

public interface IGastoService {
	
	public List<Gasto> findAll();
	
	public Gasto findById(Long id_gasto);
	
	public Gasto save(Gasto gasto);
	
}
