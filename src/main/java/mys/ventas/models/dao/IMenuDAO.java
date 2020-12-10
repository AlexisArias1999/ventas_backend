package mys.ventas.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mys.ventas.models.entity.Menu;

public interface IMenuDAO extends JpaRepository<Menu, Long>{

	@Query(value = "SELECT * FROM MENUS WHERE MENU = TRUE", nativeQuery = true)
	public List<Menu> getAllPrincipal();
	
}
