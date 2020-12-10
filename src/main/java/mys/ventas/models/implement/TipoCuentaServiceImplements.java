package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.ITipoCuentaDAO;
import mys.ventas.models.entity.TipoCuenta;
import mys.ventas.models.services.ITipoCuentaService;

@Service
public class TipoCuentaServiceImplements implements ITipoCuentaService{

	@Autowired
	private ITipoCuentaDAO tipoCuentaDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<TipoCuenta> findAll() {
		return (List<TipoCuenta>)tipoCuentaDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public TipoCuenta findById(Long id_tipoCuenta) {
		return tipoCuentaDAO.findById(id_tipoCuenta).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public TipoCuenta save(TipoCuenta tipoCuenta) {
		return tipoCuentaDAO.save(tipoCuenta);
	}


}
