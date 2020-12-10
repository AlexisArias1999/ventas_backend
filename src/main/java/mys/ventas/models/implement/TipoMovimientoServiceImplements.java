package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.ITipoMovimientoDAO;
import mys.ventas.models.entity.TipoMovimiento;
import mys.ventas.models.services.ITipoMovimientoService;

@Service
public class TipoMovimientoServiceImplements implements ITipoMovimientoService{

	@Autowired
	private ITipoMovimientoDAO TipoMovimientoDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<TipoMovimiento> findAll() {
		return (List<TipoMovimiento>)TipoMovimientoDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public TipoMovimiento findById(Long id_tipo_movimiento) {
		return TipoMovimientoDAO.findById(id_tipo_movimiento).orElse(null);
	}

	@Override
	public TipoMovimiento save(TipoMovimiento tipoMovimiento) {
		return TipoMovimientoDAO.save(tipoMovimiento);
	}

}
