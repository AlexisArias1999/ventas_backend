package mys.ventas.models.services;

import java.util.List;

import mys.ventas.models.entity.Moneda;

public interface IMonedaService {

	public List<Moneda> findAll();
	
	public Moneda findById(Long id_moneda);
	
}
