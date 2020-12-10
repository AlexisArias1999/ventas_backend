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
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "operaciones")
public class Operacion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_operacion;

	@Size(min = 4, max = 100)
	@Column(nullable = false)
	private String concepto;

	private Double monto;

	private Double pagado;

	private Double vuelto;

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date creado;

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date modificado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_operacion")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoOperacion tipo_operacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empleado")
	@JsonIgnoreProperties(value = { "empresa", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	private Empleado empleado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_forma_pago")
	@JsonIgnoreProperties(value = { "entidad", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	private FormaPago forma_pago;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_entidad")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Entidad entidad;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Empresa empresa;

	public Long getId_operacion() {
		return id_operacion;
	}

	public void setId_operacion(Long id_operacion) {
		this.id_operacion = id_operacion;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public Double getMonto() {
		return monto;
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

	public Date getCreado() {
		return creado;
	}

	public void setCreado(Date creado) {
		this.creado = creado;
	}

	public Date getModificado() {
		return modificado;
	}

	public void setModificado(Date modificado) {
		this.modificado = modificado;
	}

	public TipoOperacion getTipo_operacion() {
		return tipo_operacion;
	}

	public void setTipo_operacion(TipoOperacion tipo_operacion) {
		this.tipo_operacion = tipo_operacion;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public FormaPago getForma_pago() {
		return forma_pago;
	}

	public void setForma_pago(FormaPago forma_pago) {
		this.forma_pago = forma_pago;
	}

	public Entidad getEntidad() {
		return entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	private static final long serialVersionUID = 1L;

}
