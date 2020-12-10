package mys.ventas.models.services;

import java.util.List;

import mys.ventas.models.entity.Operacion;

public interface IOperacionService {
	
	public List<Operacion> findAll();
	
	public Operacion save(Operacion operacion);
	
}
