package mys.ventas.models.services;

import java.util.List;

import mys.ventas.models.entity.Impuesto;

public interface IImpuestoService {

	public List<Impuesto> findAll();
	
	public Impuesto save(Impuesto impuesto);
	
	public Impuesto findById(Long id_impuesto);
	
}
