package mys.ventas.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_afectacion")
public class TipoAfectacion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tipo_afectacion;

	@Column(unique = true)
	private String descripcion;

	private Boolean estado;

	public Long getId_tipo_afectacion() {
		return id_tipo_afectacion;
	}

	public void setId_tipo_afectacion(Long id_tipo_afectacion) {
		this.id_tipo_afectacion = id_tipo_afectacion;
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
