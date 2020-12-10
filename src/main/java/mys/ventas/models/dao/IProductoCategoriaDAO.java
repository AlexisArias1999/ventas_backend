package mys.ventas.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mys.ventas.models.entity.ProductoCategoria;

public interface IProductoCategoriaDAO extends JpaRepository<ProductoCategoria, Long>{

}
