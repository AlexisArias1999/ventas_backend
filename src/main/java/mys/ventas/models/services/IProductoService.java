package mys.ventas.models.services;

import java.util.List;

import mys.ventas.models.entity.Producto;

public interface IProductoService {
	
	public List<Producto> findAll();
	
	public Producto findById(Long id_producto);
	
	public Producto save(Producto producto);
	
}
