package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mys.ventas.models.dao.IProductoDAO;
import mys.ventas.models.entity.Producto;
import mys.ventas.models.services.IProductoService;

@Service
public class ProductoServiceImplements implements IProductoService{
	
	@Autowired
	private IProductoDAO productoDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDAO.findAll();
	}

	@Override
	public Producto save(Producto producto) {		
		return productoDAO.save(producto);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id_producto) {
		return productoDAO.findById(id_producto).orElse(null);
	}
	
}
