package mys.ventas.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import mys.ventas.models.entity.TipoGasto;

public interface ITipoGastoDAO extends JpaRepository<TipoGasto, Long>{

}
