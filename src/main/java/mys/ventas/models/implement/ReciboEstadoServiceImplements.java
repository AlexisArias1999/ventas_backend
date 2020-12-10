package mys.ventas.models.implement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mys.ventas.models.dao.IReciboEstadoDAO;
import mys.ventas.models.entity.ReciboEstado;
import mys.ventas.models.services.IReciboEstadoService;

@Service
public class ReciboEstadoServiceImplements implements IReciboEstadoService{

	@Autowired
	IReciboEstadoDAO reciboEstadoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<ReciboEstado> findAll() {
		return (List<ReciboEstado>)reciboEstadoDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public ReciboEstado findById(Long id_recibo_estado) {
		return reciboEstadoDAO.findById(id_recibo_estado).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public ReciboEstado save(ReciboEstado ReciboEstado) {
		return reciboEstadoDAO.save(ReciboEstado);
	}



	
}
