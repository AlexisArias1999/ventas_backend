package mys.ventas.models.entity;

import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "recibo_estado")
public class ReciboEstado implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_recibo_estado;

	private String descripcion;

	private Boolean estado;

	public Long getId_recibo_estado() {
		return id_recibo_estado;
	}

	public void setId_recib_estadoo(Long id_recibo_estado) {
		this.id_recibo_estado = id_recibo_estado;
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
