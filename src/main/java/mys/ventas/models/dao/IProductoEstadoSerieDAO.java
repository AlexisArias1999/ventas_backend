package mys.ventas.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mys.ventas.models.entity.ProductoEstadoSerie;

public interface IProductoEstadoSerieDAO extends JpaRepository<ProductoEstadoSerie, Long>{

}
