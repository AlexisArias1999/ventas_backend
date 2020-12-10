package mys.ventas.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_cuenta")
public class TipoCuenta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tipo_cuenta;

	private String descripcion;

	private Double apertura;

	private Boolean estado;

	public Long getId_tipo_cuenta() {
		return id_tipo_cuenta;
	}

	public void setId_tipo_cuenta(Long id_tipo_cuenta) {
		this.id_tipo_cuenta = id_tipo_cuenta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getApertura() {
		return apertura;
	}

	public void setApertura(Double apertura) {
		this.apertura = apertura;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	private static final long serialVersionUID = 1L;

}
