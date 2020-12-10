package mys.ventas.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mys.ventas.models.entity.Vencimiento;

public interface IVencimientoDAO extends JpaRepository<Vencimiento, Long>{

}
