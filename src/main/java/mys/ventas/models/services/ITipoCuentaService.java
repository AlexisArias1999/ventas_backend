package mys.ventas.models.services;

import java.util.List;

import mys.ventas.models.entity.TipoCuenta;

public interface ITipoCuentaService {
	
	public List<TipoCuenta> findAll();
	
	public TipoCuenta findById(Long id_tipo_cuenta);
	
	public TipoCuenta save (TipoCuenta tipoCuenta);
	
	
}
