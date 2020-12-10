package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IVentaEstadoDAO;
import mys.ventas.models.entity.VentaEstado;
import mys.ventas.models.services.IVentaEstadoService;

@Service
public class EstadoVentaServiceImplements implements IVentaEstadoService{

	@Autowired
	private IVentaEstadoDAO ventaEstadoDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<VentaEstado> findall() {
		return (List<VentaEstado>)ventaEstadoDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public VentaEstado finfById(Long id_venta_estado) {
		return ventaEstadoDAO.findById(id_venta_estado).orElse(null);
	}

}
