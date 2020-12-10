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
@Table(name = "tipo_movimientos")
public class TipoMovimiento implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tipo_movimiento;

	@NotEmpty(message = "Ingrese una descripción")
	@NotNull(message = "Ingrese una descripción")
	@Column(nullable = false, unique = true)
	private String descripcion;

	@Column(nullable = false)
	private Boolean estado;

	public Long getId_tipo_movimiento() {
		return id_tipo_movimiento;
	}

	public void setId_tipo_movimiento(Long id_tipo_movimiento) {
		this.id_tipo_movimiento = id_tipo_movimiento;
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
