package mys.ventas.models.implement;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mys.ventas.models.dao.IAlmacenDAO;
import mys.ventas.models.entity.Almacen;
import mys.ventas.models.services.IAlmacenService;

@Service
public class AlmacenServiceImplements implements IAlmacenService{

	@Autowired
	private IAlmacenDAO almacenDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Almacen> findAll() {
		return (List<Almacen>)almacenDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Almacen findById(Long id_almacen) {
		return almacenDAO.findById(id_almacen).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public Almacen save(Almacen almacen) {
		return almacenDAO.save(almacen);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Map<String, Object>> findByIdEmpresa(Long id_empresa) {
		return almacenDAO.findByIdEmpresa(id_empresa);
	}

}
