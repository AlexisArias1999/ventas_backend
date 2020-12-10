package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IProveedorDAO;
import mys.ventas.models.entity.Proveedor;
import mys.ventas.models.services.IProveedorService;

@Service
public class ProveedorServiceImplements implements IProveedorService {

	@Autowired
	private IProveedorDAO proveedorDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Proveedor> findAll() {
		return (List<Proveedor>)proveedorDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Proveedor findById(Long id_proveedor) {
		return proveedorDAO.findById(id_proveedor).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public Proveedor save(Proveedor proveedor) {
		return proveedorDAO.save(proveedor);
	}
	
}
