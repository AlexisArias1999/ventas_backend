package mys.ventas.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tipo_operacion")
public class TipoOperacion implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tipo_operacion;
	
	@Size(min = 4, max = 100)
	@Column(nullable = false)
	private String descripcion;
	
	private Boolean ingreso;

	public Boolean getIngreso() {
		return ingreso;
	}

	public void setIngreso(Boolean ingreso) {
		this.ingreso = ingreso;
	}

	public Long getId_tipo_operacion() {
		return id_tipo_operacion;
	}
	
	public void setId_tipo_operacion(Long id_tipo_operacion) {
		this.id_tipo_operacion = id_tipo_operacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	private static final long serialVersionUID = 1L;
		
}
