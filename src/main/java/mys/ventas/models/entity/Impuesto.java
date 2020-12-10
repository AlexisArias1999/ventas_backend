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
@Table(name = "impuestos")
public class Impuesto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_impuesto;

	@NotEmpty(message = "El campo descripción no puede estar vacio")
	@Column(nullable = false)
	private String descripcion;

	@NotEmpty(message = "El campo impuesto no puede estar vacio")
	@Column(nullable = false)
	private Double impuesto;

	@NotEmpty(message = "El campo estado no puede estar vacio")
	@Column(nullable = false)
	private Boolean estado;

	public Long getId_impuesto() {
		return id_impuesto;
	}

	public void setId_impuesto(Long id_impuesto) {
		this.id_impuesto = id_impuesto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(Double impuesto) {
		this.impuesto = impuesto;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	private static final long serialVersionUID = 1L;
}
