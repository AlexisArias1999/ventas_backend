package mys.ventas.models.services;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mys.ventas.models.entity.Recibo;

public interface IReciboService {
	
	public List<Recibo> findAll();
	
	public Recibo findById(Long id_recibo);
	
	public Map<Double, Object> ObtenerDeudaVenta(Long id_venta);
	
	public Recibo save(Recibo recibo);
	
	public List<Map<String, Object>> findAllReciboVenta(Long id_venta);
	
	public Page<Map<String, Object>> PaginacionRecibos(Long id_empresa, Pageable pageable);
	
}
