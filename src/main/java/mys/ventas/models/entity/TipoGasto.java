package mys.ventas.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_gastos")
public class TipoGasto implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tipo_gasto;
	
	private String descripcion;
	
	private boolean estado;
	
	public Long getId_tipo_gasto() {
		return id_tipo_gasto;
	}

	public void setId_tipo_gasto(Long id_tipo_gasto) {
		this.id_tipo_gasto = id_tipo_gasto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	private static final long serialVersionUID = 1L;
	
}
