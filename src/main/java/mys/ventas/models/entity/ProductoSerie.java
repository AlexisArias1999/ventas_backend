package mys.ventas.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "producto_series")
public class ProductoSerie implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_producto_serie;

	private String descripcion;

	private ProductoEstadoSerie producto_estado_serie;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Boolean estado;

	public Long getId_producto_serie() {
		return id_producto_serie;
	}

	public void setId_producto_serie(Long id_producto_serie) {
		this.id_producto_serie = id_producto_serie;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public ProductoEstadoSerie getProducto_estado_serie() {
		return producto_estado_serie;
	}

	public void setProducto_estado_serie(ProductoEstadoSerie producto_estado_serie) {
		this.producto_estado_serie = producto_estado_serie;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	private static final long serialVersionUID = 1L;

}
