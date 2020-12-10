package mys.ventas.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mys.ventas.models.entity.ProductoMarca;

public interface IProductoMarcaService {

	public List<ProductoMarca> findAll();
	
	public Page<ProductoMarca> paginacion(Pageable pageable);
	
	public ProductoMarca findById(Long id_producto_marca);
	
	public ProductoMarca save(ProductoMarca productoMarca);
	
}
