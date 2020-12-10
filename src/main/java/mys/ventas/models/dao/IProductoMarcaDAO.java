package mys.ventas.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mys.ventas.models.entity.ProductoMarca;

public interface IProductoMarcaDAO extends JpaRepository<ProductoMarca, Long>{

}
