package mys.ventas.models.services;

import java.util.List;
import java.util.Map;

import mys.ventas.models.entity.Entidad;

public interface IEntidadService {

	public List<Entidad> findAll();

	public Entidad findById(Long id_entidad);

	public Entidad save(Entidad entidad);

	public List<Map<String, Object>> getAllEntidadIdFormaPago(Long id_forma_pago);

}
