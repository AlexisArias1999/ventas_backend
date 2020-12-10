package mys.ventas.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mys.ventas.models.entity.Role;

public interface IRoleDAO extends JpaRepository<Role, Long>{

}
