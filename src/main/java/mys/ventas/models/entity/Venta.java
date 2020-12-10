package mys.ventas.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ventas")
public class Venta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_venta;

	@Valid
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;

	@Valid
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@NotEmpty(message = "El campo N° de documento no puede estar vacio")
	@Column(nullable = false)
	private String nro_documento;

	@Column(nullable = false)
	private String nro_cotizacion;

	@Column(nullable = false)
	private String observacion;

	@NotNull(message = "El campo emitida no puede estar vacio")
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date emitida;

	@NotNull(message = "El campo vencimiento no puede estar vacio")
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date vencimiento;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_vencimiento")
	private Vencimiento vencimientos;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_moneda")
	private Moneda moneda;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_documento")
	private Documento documento;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_venta_estado")
	private VentaEstado venta_estado;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_venta")
	@Valid
	private List<VentaDetalle> venta_detalle;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_optometria")
	private Optometria optometria;

	@Min(value = 1, message = "El campo total no puede ser 0")
	@Column(nullable = false, precision = 10, scale = 2)
	private double total_venta;

	@Min(value = 1, message = "El campo sub total no puede ser 0")
	@Column(nullable = false, precision = 10, scale = 2)
	private double subtotal_venta;

	@NotNull(message = "El campo descuento no puede ser vacio")
	@Column(nullable = false, precision = 10, scale = 2)
	private double descuento_venta;

	@NotNull(message = "El campo delivery no puede ser vacio")
	@Column(nullable = false, precision = 10, scale = 2)
	private double delivery_venta;

	@NotNull(message = "El campo impuesto no puede ser vacio")
	@Column(nullable = false, precision = 10, scale = 2)
	private double impuesto_venta;

	@Column(nullable = false)
	private Boolean estado;

	public Long getId_venta() {
		return id_venta;
	}

	public void setId_venta(Long id_venta) {
		this.id_venta = id_venta;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNro_documento() {
		return nro_documento;
	}

	public void setNro_documento(String nro_documento) {
		this.nro_documento = nro_documento;
	}

	public String getNro_cotizacion() {
		return nro_cotizacion;
	}

	public void setNro_cotizacion(String nro_cotizacion) {
		this.nro_cotizacion = nro_cotizacion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getEmitida() {
		return emitida;
	}

	public void setEmitida(Date emitida) {
		this.emitida = emitida;
	}

	public Date getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

	public Vencimiento getVencimientos() {
		return vencimientos;
	}

	public void setVencimientos(Vencimiento vencimientos) {
		this.vencimientos = vencimientos;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public VentaEstado getVenta_estado() {
		return venta_estado;
	}

	public void setVenta_estado(VentaEstado venta_estado) {
		this.venta_estado = venta_estado;
	}

	public List<VentaDetalle> getVenta_detalle() {
		return venta_detalle;
	}

	public void setVenta_detalle(List<VentaDetalle> venta_detalle) {
		this.venta_detalle = venta_detalle;
	}

	public Optometria getOptometria() {
		return optometria;
	}

	public void setOptometria(Optometria optometria) {
		this.optometria = optometria;
	}

	public double getTotal_venta() {
		return total_venta;
	}

	public void setTotal_venta(double total_venta) {
		this.total_venta = total_venta;
	}

	public double getSubtotal_venta() {
		return subtotal_venta;
	}

	public void setSubtotal_venta(double subtotal_venta) {
		this.subtotal_venta = subtotal_venta;
	}

	public double getDescuento_venta() {
		return descuento_venta;
	}

	public void setDescuento_venta(double descuento_venta) {
		this.descuento_venta = descuento_venta;
	}

	public double getDelivery_venta() {
		return delivery_venta;
	}

	public void setDelivery_venta(double delivery_venta) {
		this.delivery_venta = delivery_venta;
	}

	public double getImpuesto_venta() {
		return impuesto_venta;
	}

	public void setImpuesto_venta(double impuesto_venta) {
		this.impuesto_venta = impuesto_venta;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	private static final long serialVersionUID = 1L;

}
