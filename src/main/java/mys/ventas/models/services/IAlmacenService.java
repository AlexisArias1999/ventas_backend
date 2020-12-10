package mys.ventas.models.services;

import java.util.List;
import java.util.Map;

import mys.ventas.models.entity.Almacen;

public interface IAlmacenService {

	public List<Almacen> findAll();

	public Almacen save(Almacen almacen);

	public Almacen findById(Long id_almacen);

	public List<Map<String, Object>> findByIdEmpresa(Long id_empresa);

}
