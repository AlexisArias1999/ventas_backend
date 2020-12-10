package mys.ventas.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mys.ventas.models.entity.TipoAfectacion;

public interface ITipoAfectacionService {

	public List<TipoAfectacion> findAll();

	public Page<TipoAfectacion> paginacion(Pageable pageable);

	public TipoAfectacion findById(Long id_tipo_afectacion);

	public TipoAfectacion save(TipoAfectacion afectacion);

}
