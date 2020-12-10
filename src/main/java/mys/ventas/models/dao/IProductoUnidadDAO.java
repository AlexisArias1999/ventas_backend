package mys.ventas.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mys.ventas.models.entity.ProductoUnidad;

public interface IProductoUnidadDAO extends JpaRepository<ProductoUnidad, Long>{

}
