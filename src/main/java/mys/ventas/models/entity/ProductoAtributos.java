package mys.ventas.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "producto_atributos")
public class ProductoAtributos implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_producto_atributos;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_producto_atributos")
	private TipoProductoAtributos tipo_producto_atributos;

	private String descripcion;

	private Boolean estado;

	public Long getId_producto_atributos() {
		return id_producto_atributos;
	}

	public void setId_producto_atributos(Long id_producto_atributos) {
		this.id_producto_atributos = id_producto_atributos;
	}

	public TipoProductoAtributos getTipo_producto_atributos() {
		return tipo_producto_atributos;
	}

	public void setTipo_producto_atributos(TipoProductoAtributos tipo_producto_atributos) {
		this.tipo_producto_atributos = tipo_producto_atributos;
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
