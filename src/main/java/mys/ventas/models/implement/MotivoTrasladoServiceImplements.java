package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IMotivoTrasladoDAO;
import mys.ventas.models.entity.MotivoTraslado;
import mys.ventas.models.services.IMotivoTrasladoService;

@Service
public class MotivoTrasladoServiceImplements implements IMotivoTrasladoService{

	@Autowired
	private IMotivoTrasladoDAO MotivoTrasladoDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<MotivoTraslado> findAll() {
		return (List<MotivoTraslado>)MotivoTrasladoDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public MotivoTraslado findById(Long id_motivo_traslado) {
		return MotivoTrasladoDAO.findById(id_motivo_traslado).orElse(null);
	}

	@Override
	public MotivoTraslado save(MotivoTraslado motivoTraslado) {
		return MotivoTrasladoDAO.save(motivoTraslado);
	}

}
