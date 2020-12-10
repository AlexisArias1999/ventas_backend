package mys.ventas.models.services;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mys.ventas.models.entity.Optometria;

public interface IOptometriaService {

	public Optometria findById(Long id_optometria);
	
	public  Page<Map<String, Object>> PaginacionGestionarOptometria(Long id_cliente, Pageable pageable);
	
	public Optometria save(Optometria optometria);
	
}
