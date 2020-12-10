package mys.ventas.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_producto_atributos")
public class TipoProductoAtributos implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tipo_producto_atributos;

	private String descripcion;

	private Boolean estado;

	public Long getId_tipo_producto_atributos() {
		return id_tipo_producto_atributos;
	}

	public void setId_tipo_producto_atributos(Long id_tipo_producto_atributos) {
		this.id_tipo_producto_atributos = id_tipo_producto_atributos;
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
