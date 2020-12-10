package mys.ventas.models.services;

import java.util.List;

import mys.ventas.models.entity.ProveedorCredito;

public interface IProveedorCreditoService {
	
	public List<ProveedorCredito> findAll();
	
	public ProveedorCredito findById(Long id_proveedor_credito);
	
	public ProveedorCredito save(ProveedorCredito proveedorCredito);

}
