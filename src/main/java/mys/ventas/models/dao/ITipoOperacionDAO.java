package mys.ventas.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mys.ventas.models.entity.TipoOperacion;

public interface ITipoOperacionDAO extends JpaRepository<TipoOperacion, Long>{

}
