package mys.ventas.models.implement;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IMovimientoDAO;
import mys.ventas.models.entity.Movimiento;
import mys.ventas.models.services.IMovimientoService;

@Service
public class MovimientoServiceImplements implements IMovimientoService{

	@Autowired
	private IMovimientoDAO movimientoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Movimiento> findAll() {
		return (List<Movimiento>)movimientoDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Movimiento findById(Long id_movimento) {
		return movimientoDAO.findById(id_movimento).orElse(null);
	}

	@Override
	public Movimiento save(Movimiento movimiento) {
		return movimientoDAO.save(movimiento);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Map<String, Object>> PagiacionMovimientosProductos(Long id_empresa, Pageable pageable) {
		return movimientoDAO.PagiacionMovimientosProductos(id_empresa, pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> MovimientoByIdProducto(Long id_producto) {
		return movimientoDAO.MovimientoByIdProducto(id_producto);
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> MovimientoByIdProductoAlmacen(Long id_producto, Long id_almacen) {
		return movimientoDAO.MovimientoByIdProductoAlmacen(id_producto, id_almacen);
	}
	
}
