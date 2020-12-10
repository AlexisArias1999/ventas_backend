package mys.ventas.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mys.ventas.models.entity.TipoPersona;

public interface ITipoPersonaDAO extends JpaRepository<TipoPersona, Long>{

}
