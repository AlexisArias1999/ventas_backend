package mys.ventas.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "documento_persona")
public class DocumentoPersona implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_documento_persona;

	@NotEmpty(message = "La descripción no puede estar vacia")
	@Column(nullable = false, unique = true)
	@NotNull(message = "La descripción no puede ser nula")
	private String descripcion;

	@Column(nullable = false)
	@NotNull(message = "El estado no puede ser nula")
	private Boolean estado;

	public Long getId_documento_persona() {
		return id_documento_persona;
	}

	public void setId_documento_persona(Long id_documento_persona) {
		this.id_documento_persona = id_documento_persona;
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
