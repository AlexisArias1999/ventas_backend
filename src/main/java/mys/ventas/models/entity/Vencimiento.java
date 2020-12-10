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
@Table(name = "vencimientos")
public class Vencimiento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_vencimiento;

	@NotEmpty(message = "El campo descripción no puede estar vacio")
	@Column(nullable = false, unique = true)
	private String descripcion;

	@NotEmpty(message = "el campo dias no puede estar vacio")
	@Column(nullable = false, unique = true)
	private Integer dias;

	@NotEmpty(message = "el campo estado no puede estar vacio")
	@Column(nullable = false)
	private Boolean estado;

	public Long getId_vencimiento() {
		return id_vencimiento;
	}

	public void setId_vencimiento(Long id_vencimiento) {
		this.id_vencimiento = id_vencimiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	private static final long serialVersionUID = 1L;

}
