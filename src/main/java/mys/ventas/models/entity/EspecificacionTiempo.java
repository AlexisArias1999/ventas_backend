package mys.ventas.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "especificacion_tiempo")
public class EspecificacionTiempo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_especificacion_tiempo;

	@NotEmpty(message = "El campo descripción no puede estar vacio")
	@Column(nullable = false, unique = true)
	private String descripcion;

	@Column(nullable = false)
	private Boolean estado;

	public Long getId_especificacion_tiempo() {
		return id_especificacion_tiempo;
	}

	public void setId_especificacion_tiempo(Long id_especificacion_tiempo) {
		this.id_especificacion_tiempo = id_especificacion_tiempo;
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
