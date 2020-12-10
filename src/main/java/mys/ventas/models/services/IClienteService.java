package mys.ventas.models.services;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mys.ventas.models.entity.Cliente;

public interface IClienteService {

	public List<Cliente> findAll();
	
	public List<Map<String, Object>>findAllClientesDeuda();
	
	public Cliente save(Cliente cliente);
	
	public Cliente findById(Long id_cliente);
	
	public Page<Map<String, Object>> paginacionCliente(Pageable pageable);
	
	public Page<Map<String, Object>> findAllClientesRUCDNI(Pageable pageable);
	
}
