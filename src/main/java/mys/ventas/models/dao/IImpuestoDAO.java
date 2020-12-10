package mys.ventas.models.dao;

import org.springframework.data.repository.CrudRepository;

import mys.ventas.models.entity.Impuesto;

public interface IImpuestoDAO extends CrudRepository<Impuesto, Long>{
	
}
