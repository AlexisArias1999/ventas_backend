package mys.ventas.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
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
@Table(name = "caja_chica")
public class CajaChica implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_caja_chica;

	private String observacion_abrir;

	private String observacion_cerrar;

	@NotNull
	@Column(name = "fecha_apertura")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date fecha_apertura;

	@Column(name = "fecha_cierre")
	@Temporal(TemporalType.DATE)
	private Date fecha_cierre;

	private Double monto_apertura;

	private Double monto_efectivo;

	public Double getMonto_efectivo() {
		return monto_efectivo;
	}

	public void setMonto_efectivo(Double monto_efectivo) {
		this.monto_efectivo = monto_efectivo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_cuenta")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoCuenta tipo_cuenta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Empresa empresa;

	private Boolean estado_caja_chica;

	private Boolean estado;

	public Long getId_caja_chica() {
		return id_caja_chica;
	}

	public void setId_caja_chica(Long id_caja_chica) {
		this.id_caja_chica = id_caja_chica;
	}

	public String getObservacion_abrir() {
		return observacion_abrir;
	}

	public void setObservacion_abrir(String observacion_abrir) {
		this.observacion_abrir = observacion_abrir;
	}

	public String getObservacion_cerrar() {
		return observacion_cerrar;
	}

	public void setObservacion_cerrar(String observacion_cerrar) {
		this.observacion_cerrar = observacion_cerrar;
	}

	public Date getFecha_apertura() {
		return fecha_apertura;
	}

	public void setFecha_apertura(Date fecha_apertura) {
		this.fecha_apertura = fecha_apertura;
	}

	public Date getFecha_cierre() {
		return fecha_cierre;
	}

	public void setFecha_cierre(Date fecha_cierre) {
		this.fecha_cierre = fecha_cierre;
	}

	public Double getMonto_apertura() {
		return monto_apertura;
	}

	public void setMonto_apertura(Double monto_apertura) {
		this.monto_apertura = monto_apertura;
	}

	public TipoCuenta getTipo_cuenta() {
		return tipo_cuenta;
	}

	public void setTipo_cuenta(TipoCuenta tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Boolean getEstado_caja_chica() {
		return estado_caja_chica;
	}

	public void setEstado_caja_chica(Boolean estado_caja_chica) {
		this.estado_caja_chica = estado_caja_chica;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	private static final long serialVersionUID = 1L;

}
