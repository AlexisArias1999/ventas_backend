package mys.ventas.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mys.ventas.models.entity.ProductoUnidad;

public interface IProductoUnidadService {

	public List<ProductoUnidad> findAll();
	
	public Page<ProductoUnidad> paginacionProducto(Pageable pageable);
	
	public ProductoUnidad findById(Long id_producto_unidad);
	
	public ProductoUnidad save (ProductoUnidad productoUnidad);
	
}
