package mys.ventas.models.dao;

import org.springframework.data.repository.CrudRepository;

import mys.ventas.models.entity.FormaPago;

public interface IFormaPagoDAO extends CrudRepository<FormaPago, Long>{

}
