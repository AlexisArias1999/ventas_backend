package mys.ventas.models.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import mys.ventas.models.entity.TipoCuenta;

public interface ITipoCuentaDAO extends JpaRepository<TipoCuenta, Long>{
	
}
