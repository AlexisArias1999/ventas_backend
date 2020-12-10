package mys.ventas.models.services;

import java.util.List;

import mys.ventas.models.entity.VentaEstado;

public interface IVentaEstadoService {
	
	public List<VentaEstado> findall();
	
	public VentaEstado finfById(Long id_venta_estado);
	
}
