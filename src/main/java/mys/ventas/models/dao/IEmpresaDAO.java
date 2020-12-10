package mys.ventas.models.dao;

import org.springframework.data.repository.CrudRepository;

import mys.ventas.models.entity.Empresa;

public interface IEmpresaDAO extends CrudRepository<Empresa, Long>{

}
