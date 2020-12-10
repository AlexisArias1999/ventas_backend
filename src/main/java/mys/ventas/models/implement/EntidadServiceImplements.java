package mys.ventas.models.implement;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IEntidadDAO;
import mys.ventas.models.entity.Entidad;
import mys.ventas.models.services.IEntidadService;

@Service
public class EntidadServiceImplements implements IEntidadService {

	@Autowired
	private IEntidadDAO entidadDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Entidad> findAll() {
		return (List<Entidad>) entidadDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Entidad findById(Long id_entidad) {
		return entidadDAO.findById(id_entidad).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public Entidad save(Entidad entidad) {
		return entidadDAO.save(entidad);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getAllEntidadIdFormaPago(Long id_forma_pago) {
		return entidadDAO.getAllEntidadIdFormaPago(id_forma_pago);
	}
}
