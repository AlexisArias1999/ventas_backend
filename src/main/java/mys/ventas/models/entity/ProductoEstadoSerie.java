package mys.ventas.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto_estado_serie")
public class ProductoEstadoSerie implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_producto_estado_serie;

	private String descripcion;

	private Boolean estado;

	public Long getId_producto_estado_serie() {
		return id_producto_estado_serie;
	}

	public void setId_producto_estado_serie(Long id_producto_estado_serie) {
		this.id_producto_estado_serie = id_producto_estado_serie;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	private static final long serialVersionUID = 1L;

}
