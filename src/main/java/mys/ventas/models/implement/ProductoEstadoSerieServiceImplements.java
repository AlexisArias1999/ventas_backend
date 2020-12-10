package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IProductoEstadoSerieDAO;
import mys.ventas.models.entity.ProductoEstadoSerie;
import mys.ventas.models.services.IProductoEstadoSerieService;

@Service
public class ProductoEstadoSerieServiceImplements implements IProductoEstadoSerieService{

	@Autowired
	private IProductoEstadoSerieDAO productoEstadoSerieDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<ProductoEstadoSerie> findAll() {
		return (List<ProductoEstadoSerie>)productoEstadoSerieDAO.findAll();
	}

}
