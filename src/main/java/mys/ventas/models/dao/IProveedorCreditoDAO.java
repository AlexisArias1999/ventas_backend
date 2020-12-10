package mys.ventas.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mys.ventas.models.entity.ProveedorCredito;

public interface IProveedorCreditoDAO extends JpaRepository<ProveedorCredito, Long> {

}
