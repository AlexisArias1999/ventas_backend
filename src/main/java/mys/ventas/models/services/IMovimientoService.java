package mys.ventas.models.services;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mys.ventas.models.entity.Movimiento;

public interface IMovimientoService {

	public List<Movimiento> findAll();
	
	public Movimiento findById(Long id_movimento);
	
	public Movimiento save(Movimiento movimiento); 
	
	public Page<Map<String, Object>> PagiacionMovimientosProductos(Long id_empresa, Pageable pageable);
	
	public Map<String, Object> MovimientoByIdProducto(Long id_producto);
	
	public Map<String, Object> MovimientoByIdProductoAlmacen(Long id_producto, Long id_almacen);
	
}
