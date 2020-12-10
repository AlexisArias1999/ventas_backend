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
@Table(name = "motivo_traslado")
public class MotivoTraslado implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_motivo_traslado;

	@NotEmpty(message = "Ingrese una descripción")
	@NotNull(message = "Ingrese una descripción")
	@Column(nullable = false, unique = true)
	private String descripcion;

	private Boolean estado;

	public Long getId_motivo_traslado() {
		return id_motivo_traslado;
	}

	public void setId_motivo_traslado(Long id_motivo_traslado) {
		this.id_motivo_traslado = id_motivo_traslado;
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
