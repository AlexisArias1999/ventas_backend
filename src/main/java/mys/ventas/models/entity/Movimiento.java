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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "movimientos")
public class Movimiento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_movimiento;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_producto")
	@NotNull(message = "Seleccione el producto")
	private Producto producto;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_almacen")
	@NotNull(message = "Seleccione el almacen")
	private Almacen almacen;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_motivo_traslado")
	@NotNull(message = "Seleccione el motivo de traslado")
	private MotivoTraslado motivo_traslado;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_tipo_movimiento")
	@NotNull(message = "Ingrese el tipo de movimiento")
	private TipoMovimiento tipo_movimiento;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_empresa")
	@NotNull(message = "Ingrese la empresa")
	private Empresa empresa;

	private Integer cantidad_ingreso;

	private Integer cantidad_salida;

	private Boolean estado;

	public Long getId_movimiento() {
		return id_movimiento;
	}

	public void setId_movimiento(Long id_movimiento) {
		this.id_movimiento = id_movimiento;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public TipoMovimiento getTipo_movimiento() {
		return tipo_movimiento;
	}

	public void setTipo_movimiento(TipoMovimiento tipo_movimiento) {
		this.tipo_movimiento = tipo_movimiento;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public MotivoTraslado getMotivo_traslado() {
		return motivo_traslado;
	}

	public void setMotivo_traslado(MotivoTraslado motivo_traslado) {
		this.motivo_traslado = motivo_traslado;
	}

	public Integer getCantidad_ingreso() {
		return cantidad_ingreso;
	}

	public void setCantidad_ingreso(Integer cantidad_ingreso) {
		this.cantidad_ingreso = cantidad_ingreso;
	}

	public Integer getCantidad_salida() {
		return cantidad_salida;
	}

	public void setCantidad_salida(Integer cantidad_salida) {
		this.cantidad_salida = cantidad_salida;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	private static final long serialVersionUID = 1L;

}
