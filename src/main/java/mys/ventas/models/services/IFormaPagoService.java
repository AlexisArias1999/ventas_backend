package mys.ventas.models.services;

import java.util.List;

import mys.ventas.models.entity.FormaPago;

public interface IFormaPagoService {

	public List<FormaPago> findAll();
	
	public FormaPago save(FormaPago formaPago);
	
	public FormaPago findById(Long id_forma_pago);
	
}
