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
@Table(name = "cotizaciones")
public class Cotizacion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cotizacion;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa")
	@NotNull(message = "Ingrese la empresa")
	private Empresa empresa;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	@NotNull(message = "Ingrese el cliente")
	private Cliente cliente;

	@NotEmpty(message = "El campo N° de cotización no puede estar vacio")
	@Column(nullable = false)
	private String nro_documento;

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
	@NotNull(message = "Seleccione documento")
	private Documento documento;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cotizacion")
	@Valid
	private List<CotizacionDetalle> cotizacion_detalle;

	@NotNull(message = "El campo total de la cotización no puede ser 0")
	@Column(nullable = false, precision = 10, scale = 2)
	private double total_cotizacion;

	@Min(value = 1, message = "El campo sub total no puede ser 0")
	@Column(nullable = false, precision = 10, scale = 2)
	private double subtotal_cotizacion;

	@NotNull(message = "El campo descuento no puede ser vacio")
	@Column(nullable = false, precision = 10, scale = 2)
	private double descuento_cotizacion;

	@NotNull(message = "El campo delivery no puede ser vacio")
	@Column(nullable = false, precision = 10, scale = 2)
	private double delivery_cotizacion;

	@NotNull(message = "El campo impuesto no puede ser vacio")
	@Column(nullable = false, precision = 10, scale = 2)
	private double impuesto_cotizacion;

	@Column(nullable = false)
	private Boolean estado;

	public Long getId_cotizacion() {
		return id_cotizacion;
	}

	public void setId_cotizacion(Long id_cotizacion) {
		this.id_cotizacion = id_cotizacion;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Date getVencimiento() {
		return vencimiento;
	}

	public double getDelivery_cotizacion() {
		return delivery_cotizacion;
	}

	public void setDelivery_cotizacion(double delivery_cotizacion) {
		this.delivery_cotizacion = delivery_cotizacion;
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

	public List<CotizacionDetalle> getCotizacion_detalle() {
		return cotizacion_detalle;
	}

	public void setCotizacion_detalle(List<CotizacionDetalle> cotizacion_detalle) {
		this.cotizacion_detalle = cotizacion_detalle;
	}

	public double getTotal_cotizacion() {
		return total_cotizacion;
	}

	public void setTotal_cotizacion(double total_cotizacion) {
		this.total_cotizacion = total_cotizacion;
	}

	public double getSubtotal_cotizacion() {
		return subtotal_cotizacion;
	}

	public void setSubtotal_cotizacion(double subtotal_cotizacion) {
		this.subtotal_cotizacion = subtotal_cotizacion;
	}

	public double getDescuento_cotizacion() {
		return descuento_cotizacion;
	}

	public void setDescuento_cotizacion(double descuento_cotizacion) {
		this.descuento_cotizacion = descuento_cotizacion;
	}

	public double getImpuesto_cotizacion() {
		return impuesto_cotizacion;
	}

	public void setImpuesto_cotizacion(double impuesto_cotizacion) {
		this.impuesto_cotizacion = impuesto_cotizacion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	private static final long serialVersionUID = 1L;
}
