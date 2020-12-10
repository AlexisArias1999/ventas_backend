package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.ICajaChicaDAO;
import mys.ventas.models.entity.CajaChica;
import mys.ventas.models.services.ICajaChicaService;

@Service
public class CajaChicaServiceImplements implements ICajaChicaService{

	@Autowired
	private ICajaChicaDAO CajachicaDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<CajaChica> findAll() {
		return (List<CajaChica>)CajachicaDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public CajaChica findById(Long id_caja_chica) {
		return CajachicaDAO.findById(id_caja_chica).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public CajaChica save(CajaChica caja_chica) {
		return CajachicaDAO.save(caja_chica);
	}

}
