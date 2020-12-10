package mys.ventas.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor_credito")
public class ProveedorCredito implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_proveedor_credito;

	private String descripcion;

	private Boolean estado;

	public Long getId_proveedor_credito() {
		return id_proveedor_credito;
	}

	public void setId_proveedor_credito(Long id_proveedor_credito) {
		this.id_proveedor_credito = id_proveedor_credito;
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
