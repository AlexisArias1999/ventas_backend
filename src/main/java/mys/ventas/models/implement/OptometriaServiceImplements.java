package mys.ventas.models.implement;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IOptometriaDAO;
import mys.ventas.models.entity.Optometria;
import mys.ventas.models.services.IOptometriaService;

@Service
public class OptometriaServiceImplements implements IOptometriaService{

	@Autowired
	private IOptometriaDAO optometriaDAO;
	
	@Override
	@Transactional(readOnly = true)
	public Optometria findById(Long id_optometria) {
		return optometriaDAO.findById(id_optometria).orElse(null);
	}

	@Override
	public Optometria save(Optometria optometria) {
		return optometriaDAO.save(optometria);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Map<String, Object>> PaginacionGestionarOptometria(Long id_cliente, Pageable pageable) {
		return optometriaDAO.PaginacionGestionarOptometria(id_cliente, pageable);
	}

}
