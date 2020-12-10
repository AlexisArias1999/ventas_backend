package mys.ventas.models.entity;

import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name = "entidades")
public class Entidad implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_entidad;

	private String descripcion;

	@Column(unique = true)
	private String nro_cuenta;

	private Double gastos_financieros;

	private String tiempo_disponibilidad;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_cuenta")
	private TipoCuenta tipo_cuenta;

	private Boolean estado;

	public Long getId_entidad() {
		return id_entidad;
	}

	public void setId_entidad(Long id_entidad) {
		this.id_entidad = id_entidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNro_cuenta() {
		return nro_cuenta;
	}

	public void setNro_cuenta(String nro_cuenta) {
		this.nro_cuenta = nro_cuenta;
	}

	public Double getGastos_financieros() {
		return gastos_financieros;
	}

	public void setGastos_financieros(Double gastos_financieros) {
		this.gastos_financieros = gastos_financieros;
	}

	public String getTiempo_disponibilidad() {
		return tiempo_disponibilidad;
	}

	public void setTiempo_disponibilidad(String tiempo_disponibilidad) {
		this.tiempo_disponibilidad = tiempo_disponibilidad;
	}

	public TipoCuenta getTipo_cuenta() {
		return tipo_cuenta;
	}

	public void setTipo_cuenta(TipoCuenta tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	private static final long serialVersionUID = 1L;

}
