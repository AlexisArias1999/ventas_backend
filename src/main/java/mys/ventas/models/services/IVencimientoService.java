package mys.ventas.models.services;

import java.util.List;

import mys.ventas.models.entity.Vencimiento;

public interface IVencimientoService {

	public List<Vencimiento> findAll();
	
	public Vencimiento findById(Long id_vencimiento);
	
}
