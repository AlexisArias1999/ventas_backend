package mys.ventas.models.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "venta_detalle")
public class VentaDetalle implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_venta_detalle;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto")
	private Producto producto;

	@NotEmpty(message = "El campo producto o servicio no puede estar vacio")
	@Column(nullable = false)
	private String producto_servicio;

	@Column(nullable = false)
	private Integer tiempo;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_especificacion_tiempo")
	private EspecificacionTiempo especificacion_tiempo;

	@Min(value = 1, message = "La cantidad debe ser mayor a 0")
	@Column(nullable = false)
	@NotNull(message = "El campo cantidad no puede ser vacio")
	private Integer cantidad;

	@Min(value = 1, message = "El precio unitario no puede estar en 0")
	@Column(nullable = false, precision = 10, scale = 2)
	@NotNull(message = "El campo precio unitario no puede ser vacio")
	private Double precio_unitario;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "id_impuesto", nullable = false)
	private Impuesto impuesto;

	@Min(value = 1, message = "El total no puede estar en 0")
	@Column(nullable = false, precision = 10, scale = 2)
	@NotNull(message = "El campo total no puede ser vacio")
	private Double total;

	@Column(nullable = false, precision = 10, scale = 2)
	@NotNull(message = "El campo total impeusto no puede ser vacio")
	private Double total_impuesto;

	@Column(nullable = false)
	private Boolean estado;

	public Long getId_venta_detalle() {
		return id_venta_detalle;
	}

	public void setId_venta_detalle(Long id_venta_detalle) {
		this.id_venta_detalle = id_venta_detalle;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public String getProducto_servicio() {
		return producto_servicio;
	}

	public void setProducto_servicio(String producto_servicio) {
		this.producto_servicio = producto_servicio;
	}

	public Integer getTiempo() {
		return tiempo;
	}

	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}

	public EspecificacionTiempo getEspecificacion_tiempo() {
		return especificacion_tiempo;
	}

	public void setEspecificacion_tiempo(EspecificacionTiempo especificacion_tiempo) {
		this.especificacion_tiempo = especificacion_tiempo;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(Double precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	public Impuesto getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(Impuesto impuesto) {
		this.impuesto = impuesto;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getTotal_impuesto() {
		return total_impuesto;
	}

	public void setTotal_impuesto(Double total_impuesto) {
		this.total_impuesto = total_impuesto;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	private static final long serialVersionUID = 1L;
}
