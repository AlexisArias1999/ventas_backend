package mys.ventas.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mys.ventas.models.entity.DocumentoPersona;

public interface IDocumentoPersonaDAO extends JpaRepository<DocumentoPersona, Long>{

}
