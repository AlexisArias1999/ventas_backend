package mys.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.ventas.models.entity.Menu;
import mys.ventas.models.services.IMenuService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class MenuRest {

	@Autowired
	private IMenuService menuService;
	
	@GetMapping("/menu")
	public List<Menu> findAll(){
		return menuService.findAll();
	}
	
	@GetMapping("/menu/{id_menu}")
	public Menu findById(@PathVariable Long id_menu){
		return menuService.findById(id_menu);
	}
	
	@GetMapping("/menu/principal")
	public List<Menu> getAllPrincipal(){
		return menuService.getAllPrincipal();
	}
	
}
