package mys.ventas.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mys.ventas.models.entity.Gasto;

public interface IGastoDAO extends JpaRepository<Gasto, Long>{

}
