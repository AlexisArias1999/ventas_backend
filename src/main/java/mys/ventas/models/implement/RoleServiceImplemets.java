package mys.ventas.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IRoleDAO;
import mys.ventas.models.entity.Role;
import mys.ventas.models.services.IRoleService;

@Service
public class RoleServiceImplemets implements IRoleService{

	@Autowired
	private IRoleDAO roleDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Role> findAll() {
		return (List<Role>)roleDAO.findAll();
	}
	
	
	
}
