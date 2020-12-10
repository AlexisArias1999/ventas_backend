package mys.ventas.models.services;

import java.util.List;

import mys.ventas.models.entity.Proveedor;

public interface IProveedorService {

	public List<Proveedor> findAll();
	
	public Proveedor findById(Long id_proveedor);
	
	public Proveedor save(Proveedor proveedor);
	
}
