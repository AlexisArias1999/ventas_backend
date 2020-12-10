package mys.ventas.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mys.ventas.models.entity.ProductoCategoria;

public interface IProductoCategoriaService {

	public List<ProductoCategoria> findAll();
	
	public Page<ProductoCategoria> paginacion(Pageable pageable);
	
	public ProductoCategoria findById(Long id_producto_categoria);
	
	public ProductoCategoria save (ProductoCategoria productoCategoria);
	
}
