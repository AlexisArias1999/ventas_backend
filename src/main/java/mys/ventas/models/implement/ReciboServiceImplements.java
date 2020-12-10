package mys.ventas.models.implement;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IReciboDAO;
import mys.ventas.models.entity.Recibo;
import mys.ventas.models.services.IReciboService;

@Service
public class ReciboServiceImplements implements IReciboService{

	@Autowired
	private IReciboDAO reciboDAO;
	
	@Override
	@Transactional(readOnly = false)
	public Recibo save(Recibo recibo) {
		return reciboDAO.save(recibo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Recibo> findAll() {
		return (List<Recibo>)reciboDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Map<Double, Object> ObtenerDeudaVenta(Long id_venta) {
		return reciboDAO.ObtenerDeudaVenta(id_venta);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Map<String, Object>> findAllReciboVenta(Long id_venta) {
		return reciboDAO.findAllReciboVenta(id_venta);
	}

	@Override
	@Transactional(readOnly = true)
	public Recibo findById(Long id_recibo) {
		return reciboDAO.findById(id_recibo).orElse(null);
	}

	@Override
	public Page<Map<String, Object>> PaginacionRecibos(Long id_empresa, Pageable pageable) {
		return reciboDAO.PaginacionRecibos(id_empresa, pageable);
	}

}
