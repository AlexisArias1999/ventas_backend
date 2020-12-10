package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IProductoCategoriaDAO;
import mys.ventas.models.entity.ProductoCategoria;
import mys.ventas.models.services.IProductoCategoriaService;

@Service
public class ProductoCategoriaServiceImplements implements IProductoCategoriaService{

	@Autowired
	private IProductoCategoriaDAO productoCategoriaDAO;
	
	@Override
	@Transactional(readOnly = true)
	public Page<ProductoCategoria> paginacion(Pageable pageable) {
		return productoCategoriaDAO.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public ProductoCategoria findById(Long id_producto_categoria) {
		return productoCategoriaDAO.findById(id_producto_categoria).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public ProductoCategoria save(ProductoCategoria productoCategoria) {
		return productoCategoriaDAO.save(productoCategoria);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductoCategoria> findAll() {
		return (List<ProductoCategoria>)productoCategoriaDAO.findAll();
	}

}
