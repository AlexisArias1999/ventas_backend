package mys.ventas.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mys.ventas.models.entity.TipoAfectacion;

public interface ITipoAfectacionDAO extends JpaRepository<TipoAfectacion, Long>{

}
