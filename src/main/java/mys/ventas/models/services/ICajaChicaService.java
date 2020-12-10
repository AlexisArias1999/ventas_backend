package mys.ventas.models.services;

import java.util.List;

import mys.ventas.models.entity.CajaChica;

public interface ICajaChicaService {

	public List<CajaChica> findAll();
	
	public CajaChica findById(Long id_caja_chica);
	
	public CajaChica save(CajaChica caja_chica);
	
}
