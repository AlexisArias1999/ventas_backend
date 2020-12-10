package mys.ventas.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mys.ventas.models.entity.Proveedor;

public interface IProveedorDAO extends JpaRepository<Proveedor, Long>{

}
