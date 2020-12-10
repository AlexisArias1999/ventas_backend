package mys.ventas.models.services;

import java.util.List;

import mys.ventas.models.entity.Menu;

public interface IMenuService {

	public List<Menu> findAll();

	public List<Menu> getAllPrincipal();
	
	public Menu findById(Long id_menu);
	
}
