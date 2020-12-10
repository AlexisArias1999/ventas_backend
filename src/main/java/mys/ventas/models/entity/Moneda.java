package mys.ventas.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "monedas")
public class Moneda implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_moneda;

	@NotEmpty(message = "El campo descripción no puede estar vacio")
	@Size(min = 2, max = 100, message = "El campo descripción debe tener minimo 2 caracteres y maximo 100")
	@Column(nullable = false)
	private String descripcion;

	@NotEmpty(message = "El campo simbolo no puede estar vacio")
	@Size(min = 1, max = 100, message = "El campo descripción debe tener minimo 1 caracteres y maximo 100")
	@Column(nullable = false)
	private String simbolo;

	@NotEmpty(message = "El campo estado no puede estar vacio")
	@Column(nullable = false)
	private Boolean estado;

	public Long getId_moneda() {
		return id_moneda;
	}

	public void setId_moneda(Long id_moneda) {
		this.id_moneda = id_moneda;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	private static final long serialVersionUID = 1L;

}
