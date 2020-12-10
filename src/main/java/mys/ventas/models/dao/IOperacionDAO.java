package mys.ventas.models.dao;

import org.springframework.data.repository.CrudRepository;

import mys.ventas.models.entity.Operacion;

public interface IOperacionDAO extends CrudRepository<Operacion, Long> {

}
