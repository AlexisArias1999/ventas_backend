package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IMenuDAO;
import mys.ventas.models.entity.Menu;
import mys.ventas.models.services.IMenuService;

@Service
public class MenuServiceImplements implements IMenuService{

	@Autowired
	private IMenuDAO menuDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Menu> findAll() {
		return menuDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Menu> getAllPrincipal() {
		return menuDao.getAllPrincipal();
	}

	@Override
	@Transactional(readOnly = true)
	public Menu findById(Long id_menu) {
		return menuDao.findById(id_menu).orElse(null);
	}

}
