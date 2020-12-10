package mys.ventas.models.implement;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IClienteDAO;
import mys.ventas.models.entity.Cliente;
import mys.ventas.models.services.IClienteService;

@Service
public class ClienteServiceImplements implements IClienteService{

	@Autowired
	private IClienteDAO clienteDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>)clienteDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Map<String, Object>> findAllClientesDeuda() {
		return clienteDao.findAllCliente();
	}

	@Override
	@Transactional(readOnly = false)
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id_cliente) {
		return clienteDao.findById(id_cliente).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Map<String, Object>> paginacionCliente(Pageable pageable) {
		return paginacionCliente(pageable);
	}

	@Override
	public Page<Map<String, Object>> findAllClientesRUCDNI(Pageable pageable) {
		return clienteDao.findAllClientesRUCDNI(pageable);
	}

}
