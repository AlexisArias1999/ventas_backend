package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IProveedorCreditoDAO;
import mys.ventas.models.entity.ProveedorCredito;
import mys.ventas.models.services.IProveedorCreditoService;

@Service
public class ProveedorCreditoServiceImplements implements IProveedorCreditoService{
	
	@Autowired
	private IProveedorCreditoDAO proveedorCreditoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<ProveedorCredito> findAll() {
		return (List<ProveedorCredito>) proveedorCreditoDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public ProveedorCredito findById(Long id_proveedor_credito) {
		return proveedorCreditoDAO.findById(id_proveedor_credito).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public ProveedorCredito save(ProveedorCredito proveedorCredito) {
		return proveedorCreditoDAO.save(proveedorCredito);
	}

}
