package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IProductoUnidadDAO;
import mys.ventas.models.entity.ProductoUnidad;
import mys.ventas.models.services.IProductoUnidadService;

@Service
public class ProductoUnidadServiceImplements implements IProductoUnidadService{

	@Autowired
	private IProductoUnidadDAO productoUnidadDAO;

	@Override
	@Transactional(readOnly = true)
	public Page<ProductoUnidad> paginacionProducto(Pageable pageable) {
		return productoUnidadDAO.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public ProductoUnidad findById(Long id_producto_unidad) {
		return productoUnidadDAO.findById(id_producto_unidad).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public ProductoUnidad save(ProductoUnidad productoUnidad) {
		return productoUnidadDAO.save(productoUnidad);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductoUnidad> findAll() {
		return (List<ProductoUnidad>)productoUnidadDAO.findAll();
	}
	
	
	
}
