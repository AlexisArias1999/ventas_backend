package mys.ventas.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import mys.ventas.models.entity.Moneda;

public interface IMonedaDAO extends JpaRepository<Moneda, Long>{

}
