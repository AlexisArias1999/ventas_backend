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
@Table(name = "tipo_persona")
public class TipoPersona implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tipo_persona;

	@NotEmpty(message = "El tipo de persona no puede estar vacio")
	@Column(nullable = false, unique = true)
	private String descripcion;

	@Column(nullable = false)
	private Boolean estado;

	public Long getId_tipo_persona() {
		return id_tipo_persona;
	}

	public void setId_tipo_persona(Long id_tipo_persona) {
		this.id_tipo_persona = id_tipo_persona;
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
