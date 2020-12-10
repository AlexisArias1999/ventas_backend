package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IProductoMarcaDAO;
import mys.ventas.models.entity.ProductoMarca;
import mys.ventas.models.services.IProductoMarcaService;

@Service
public class ProductoMarcaServiceImplements implements IProductoMarcaService{

	@Autowired
	private IProductoMarcaDAO productoMarcaDAO;
	
	@Override
	@Transactional(readOnly = true)
	public Page<ProductoMarca> paginacion(Pageable pageable) {
		return productoMarcaDAO.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public ProductoMarca findById(Long id_producto_marca) {
		return productoMarcaDAO.findById(id_producto_marca).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public ProductoMarca save(ProductoMarca productoMarca) {
		return productoMarcaDAO.save( productoMarca);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductoMarca> findAll() {
		return (List<ProductoMarca>)productoMarcaDAO.findAll();
	}

}
