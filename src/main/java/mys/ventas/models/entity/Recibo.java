package mys.ventas.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "recibos")
public class Recibo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_recibo;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_venta")
	private Venta venta;

	private Double monto;

	private Double pagado;

	private Double vuelto;

	private String nro_recibo;

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date registro;

	@Temporal(TemporalType.DATE)
	private Date vencimiento;

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date modificado;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_recibo_estado")
	private ReciboEstado recibo_estado;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_documento")
	@NotNull(message = "Seleccione documento")
	private Documento documento;

	public Long getId_recibo() {
		return id_recibo;
	}

	public void setId_recibo(Long id_recibo) {
		this.id_recibo = id_recibo;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Double getMonto() {
		return monto;
	}

	public String getNro_recibo() {
		return nro_recibo;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public void setNro_recibo(String nro_recibo) {
		this.nro_recibo = nro_recibo;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Double getPagado() {
		return pagado;
	}

	public void setPagado(Double pagado) {
		this.pagado = pagado;
	}

	public Double getVuelto() {
		return vuelto;
	}

	public void setVuelto(Double vuelto) {
		this.vuelto = vuelto;
	}

	public Date getRegistro() {
		return registro;
	}

	public void setRegistro(Date registro) {
		this.registro = registro;
	}

	public Date getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

	public Date getModificado() {
		return modificado;
	}

	public void setModificado(Date modificado) {
		this.modificado = modificado;
	}

	public ReciboEstado getRecibo_estado() {
		return recibo_estado;
	}

	public void setRecibo_estado(ReciboEstado recibo_estado) {
		this.recibo_estado = recibo_estado;
	}

	private static final long serialVersionUID = 1L;

}
