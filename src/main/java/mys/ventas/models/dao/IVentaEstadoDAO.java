package mys.ventas.models.dao;

import org.springframework.data.repository.CrudRepository;

import mys.ventas.models.entity.VentaEstado;

public interface IVentaEstadoDAO extends CrudRepository<VentaEstado, Long>{

}
