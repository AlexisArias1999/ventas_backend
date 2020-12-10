package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IEspecificacionTiempoDAO;
import mys.ventas.models.entity.EspecificacionTiempo;
import mys.ventas.models.services.IEspecificacionTiempoService;

@Service
public class EspecificacionTiempoServiceImplements implements IEspecificacionTiempoService{

	@Autowired
	private IEspecificacionTiempoDAO especificacionTiempoDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<EspecificacionTiempo> findAll() {
		return (List<EspecificacionTiempo>)especificacionTiempoDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public EspecificacionTiempo findById(Long id_especificacion_tiempo) {
		return especificacionTiempoDAO.findById(id_especificacion_tiempo).orElse(null);
	}

}
