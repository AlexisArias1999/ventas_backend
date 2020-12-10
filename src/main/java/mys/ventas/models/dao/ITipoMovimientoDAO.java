package mys.ventas.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mys.ventas.models.entity.TipoMovimiento;

public interface ITipoMovimientoDAO extends JpaRepository<TipoMovimiento, Long>{

}
