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

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "gastos")
public class Gasto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_gastos;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_proveedor")
	private Proveedor proveedor;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_cuenta")
	private TipoCuenta tipo_cuenta;

	@Column(name = "fecha_pago")
	@Temporal(TemporalType.DATE)
	private Date fecha_pago;

	@Column(name = "fecha_modificado")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date fecha_modificado;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_forma_pago")
	private FormaPago forma_pago;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_entidad")
	private Entidad entidad;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_gasto")
	private List<GastoDetalle> gasto_detalle;

	private String nro_referencia;

	public Long getId_gastos() {
		return id_gastos;
	}

	public void setId_gastos(Long id_gastos) {
		this.id_gastos = id_gastos;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public TipoCuenta getTipo_cuenta() {
		return tipo_cuenta;
	}

	public void setTipo_cuenta(TipoCuenta tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}

	public Date getFecha_pago() {
		return fecha_pago;
	}

	public void setFecha_pago(Date fecha_pago) {
		this.fecha_pago = fecha_pago;
	}

	public Date getFecha_modificado() {
		return fecha_modificado;
	}

	public void setFecha_modificado(Date fecha_modificado) {
		this.fecha_modificado = fecha_modificado;
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

	public List<GastoDetalle> getGasto_detalle() {
		return gasto_detalle;
	}

	public void setGasto_detalle(List<GastoDetalle> gasto_detalle) {
		this.gasto_detalle = gasto_detalle;
	}

	public String getNro_referencia() {
		return nro_referencia;
	}

	public void setNro_referencia(String nro_referencia) {
		this.nro_referencia = nro_referencia;
	}

	private static final long serialVersionUID = 1L;

}
