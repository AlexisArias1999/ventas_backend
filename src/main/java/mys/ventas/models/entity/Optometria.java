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

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "optometria")
public class Optometria implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_optometria;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empleado")
	private Empleado empleado;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date creado;

	private String vision_lejos_esferico_derecho;

	private String vision_lejos_cilindro_derecho;

	private String vision_lejos_eje_derecho;

	private String vision_lejos_av_derecho;

	private String vision_lejos_dnp;

	private String vision_lejos_prisma_derecho;

	private String vision_lejos_adicion_derecho;

	private String vision_lejos_adicion_media_derecho;

	private String vision_lejos_esferico_izquierdo;

	private String vision_lejos_cilindro_izquierdo;

	private String vision_lejos_eje_izquierdo;

	private String vision_lejos_av_izquierdo;

	private String vision_lejos_prisma_izquierdo;

	private String vision_lejos_adicion_izquierdo;

	private String vision_lejos_adicion_media_izquierdo;

	private String vision_cerca_esferico_derecho;

	private String vision_cerca_cilindro_derecho;

	private String vision_cerca_eje_derecho;

	private String vision_cerca_av_derecho;

	private String vision_cerca_dnp;

	private String vision_cerca_prisma_derecho;

	private String vision_cerca_esferico_izquierdo;

	private String vision_cerca_cilindro_izquierdo;

	private String vision_cerca_eje_izquierdo;

	private String vision_cerca_av_izquierdo;

	private String vision_cerca_prisma_izquierdo;

	private String vision_intermedia_esferico_derecho;

	private String vision_intermedia_cilindro_derecho;

	private String vision_intermedia_eje_derecho;

	private String vision_intermedia_av_derecho;

	private String vision_intermedia_dnp;

	private String vision_intermedia_prisma_derecho;

	private String vision_intermedia_esferico_izquierdo;

	private String vision_intermedia_cilindro_izquierdo;

	private String vision_intermedia_eje_izquierdo;

	private String vision_intermedia_av_izquierdo;

	private String vision_intermedia_prisma_izquierdo;

	private String lente_h_derecho;

	private String lente_v_derecho;

	private String lente_eje_derecho;

	private String lente_h_izquierdo;

	private String lente_v_izquierdo;

	private String lente_eje_izquierdo;

	private String lente_poder_derecho;

	private String lente_cb_derecho;

	private String lente_diametro_derecho;

	private String lente_contacto_derecho;

	private String lente_poder_izquierdo;

	private String lente_cb_izquierdo;

	private String lente_diametro_izquierdo;

	private String lente_contacto_izquierdo;

	private String lente_contacto;

	private String lente_lampara_hendidura;

	private String otros_lentes_usando_paciente;

	private String otros_medidas_od;

	private String otros_medidas_oi;

	private String otros_sistomatologia;

	private String otros_diagnostico;

	private String otros_tratamiento;

	private String observacion;

	private Boolean estado;

//	private String descripcion_lente_vendido;
//
//	private Double monto;
//
//	private Double a_cuenta;
//
//	private Double saldo;

	public Long getId_optometria() {
		return id_optometria;
	}

	public void setId_optometria(Long id_optometria) {
		this.id_optometria = id_optometria;
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

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Date getCreado() {
		return creado;
	}

	public void setCreado(Date creado) {
		this.creado = creado;
	}

	public String getVision_lejos_esferico_derecho() {
		return vision_lejos_esferico_derecho;
	}

	public void setVision_lejos_esferico_derecho(String vision_lejos_esferico_derecho) {
		this.vision_lejos_esferico_derecho = vision_lejos_esferico_derecho;
	}

	public String getVision_lejos_cilindro_derecho() {
		return vision_lejos_cilindro_derecho;
	}

	public void setVision_lejos_cilindro_derecho(String vision_lejos_cilindro_derecho) {
		this.vision_lejos_cilindro_derecho = vision_lejos_cilindro_derecho;
	}

	public String getVision_lejos_eje_derecho() {
		return vision_lejos_eje_derecho;
	}

	public void setVision_lejos_eje_derecho(String vision_lejos_eje_derecho) {
		this.vision_lejos_eje_derecho = vision_lejos_eje_derecho;
	}

	public String getVision_lejos_av_derecho() {
		return vision_lejos_av_derecho;
	}

	public void setVision_lejos_av_derecho(String vision_lejos_av_derecho) {
		this.vision_lejos_av_derecho = vision_lejos_av_derecho;
	}

	public String getVision_lejos_dnp() {
		return vision_lejos_dnp;
	}

	public void setVision_lejos_dnp(String vision_lejos_dnp) {
		this.vision_lejos_dnp = vision_lejos_dnp;
	}

	public String getVision_lejos_prisma_derecho() {
		return vision_lejos_prisma_derecho;
	}

	public void setVision_lejos_prisma_derecho(String vision_lejos_prisma_derecho) {
		this.vision_lejos_prisma_derecho = vision_lejos_prisma_derecho;
	}

	public String getVision_lejos_adicion_derecho() {
		return vision_lejos_adicion_derecho;
	}

	public void setVision_lejos_adicion_derecho(String vision_lejos_adicion_derecho) {
		this.vision_lejos_adicion_derecho = vision_lejos_adicion_derecho;
	}

	public String getVision_lejos_adicion_media_derecho() {
		return vision_lejos_adicion_media_derecho;
	}

	public void setVision_lejos_adicion_media_derecho(String vision_lejos_adicion_media_derecho) {
		this.vision_lejos_adicion_media_derecho = vision_lejos_adicion_media_derecho;
	}

	public String getVision_lejos_esferico_izquierdo() {
		return vision_lejos_esferico_izquierdo;
	}

	public void setVision_lejos_esferico_izquierdo(String vision_lejos_esferico_izquierdo) {
		this.vision_lejos_esferico_izquierdo = vision_lejos_esferico_izquierdo;
	}

	public String getVision_lejos_cilindro_izquierdo() {
		return vision_lejos_cilindro_izquierdo;
	}

	public void setVision_lejos_cilindro_izquierdo(String vision_lejos_cilindro_izquierdo) {
		this.vision_lejos_cilindro_izquierdo = vision_lejos_cilindro_izquierdo;
	}

	public String getVision_lejos_eje_izquierdo() {
		return vision_lejos_eje_izquierdo;
	}

	public void setVision_lejos_eje_izquierdo(String vision_lejos_eje_izquierdo) {
		this.vision_lejos_eje_izquierdo = vision_lejos_eje_izquierdo;
	}

	public String getVision_lejos_av_izquierdo() {
		return vision_lejos_av_izquierdo;
	}

	public void setVision_lejos_av_izquierdo(String vision_lejos_av_izquierdo) {
		this.vision_lejos_av_izquierdo = vision_lejos_av_izquierdo;
	}

	public String getVision_lejos_prisma_izquierdo() {
		return vision_lejos_prisma_izquierdo;
	}

	public void setVision_lejos_prisma_izquierdo(String vision_lejos_prisma_izquierdo) {
		this.vision_lejos_prisma_izquierdo = vision_lejos_prisma_izquierdo;
	}

	public String getVision_lejos_adicion_izquierdo() {
		return vision_lejos_adicion_izquierdo;
	}

	public void setVision_lejos_adicion_izquierdo(String vision_lejos_adicion_izquierdo) {
		this.vision_lejos_adicion_izquierdo = vision_lejos_adicion_izquierdo;
	}

	public String getVision_lejos_adicion_media_izquierdo() {
		return vision_lejos_adicion_media_izquierdo;
	}

	public void setVision_lejos_adicion_media_izquierdo(String vision_lejos_adicion_media_izquierdo) {
		this.vision_lejos_adicion_media_izquierdo = vision_lejos_adicion_media_izquierdo;
	}

	public String getVision_cerca_esferico_derecho() {
		return vision_cerca_esferico_derecho;
	}

	public void setVision_cerca_esferico_derecho(String vision_cerca_esferico_derecho) {
		this.vision_cerca_esferico_derecho = vision_cerca_esferico_derecho;
	}

	public String getVision_cerca_cilindro_derecho() {
		return vision_cerca_cilindro_derecho;
	}

	public void setVision_cerca_cilindro_derecho(String vision_cerca_cilindro_derecho) {
		this.vision_cerca_cilindro_derecho = vision_cerca_cilindro_derecho;
	}

	public String getVision_cerca_eje_derecho() {
		return vision_cerca_eje_derecho;
	}

	public void setVision_cerca_eje_derecho(String vision_cerca_eje_derecho) {
		this.vision_cerca_eje_derecho = vision_cerca_eje_derecho;
	}

	public String getVision_cerca_av_derecho() {
		return vision_cerca_av_derecho;
	}

	public void setVision_cerca_av_derecho(String vision_cerca_av_derecho) {
		this.vision_cerca_av_derecho = vision_cerca_av_derecho;
	}

	public String getVision_cerca_dnp() {
		return vision_cerca_dnp;
	}

	public void setVision_cerca_dnp(String vision_cerca_dnp) {
		this.vision_cerca_dnp = vision_cerca_dnp;
	}

	public String getVision_cerca_prisma_derecho() {
		return vision_cerca_prisma_derecho;
	}

	public void setVision_cerca_prisma_derecho(String vision_cerca_prisma_derecho) {
		this.vision_cerca_prisma_derecho = vision_cerca_prisma_derecho;
	}

	public String getVision_cerca_esferico_izquierdo() {
		return vision_cerca_esferico_izquierdo;
	}

	public void setVision_cerca_esferico_izquierdo(String vision_cerca_esferico_izquierdo) {
		this.vision_cerca_esferico_izquierdo = vision_cerca_esferico_izquierdo;
	}

	public String getVision_cerca_cilindro_izquierdo() {
		return vision_cerca_cilindro_izquierdo;
	}

	public void setVision_cerca_cilindro_izquierdo(String vision_cerca_cilindro_izquierdo) {
		this.vision_cerca_cilindro_izquierdo = vision_cerca_cilindro_izquierdo;
	}

	public String getVision_cerca_eje_izquierdo() {
		return vision_cerca_eje_izquierdo;
	}

	public void setVision_cerca_eje_izquierdo(String vision_cerca_eje_izquierdo) {
		this.vision_cerca_eje_izquierdo = vision_cerca_eje_izquierdo;
	}

	public String getVision_cerca_av_izquierdo() {
		return vision_cerca_av_izquierdo;
	}

	public void setVision_cerca_av_izquierdo(String vision_cerca_av_izquierdo) {
		this.vision_cerca_av_izquierdo = vision_cerca_av_izquierdo;
	}

	public String getVision_cerca_prisma_izquierdo() {
		return vision_cerca_prisma_izquierdo;
	}

	public void setVision_cerca_prisma_izquierdo(String vision_cerca_prisma_izquierdo) {
		this.vision_cerca_prisma_izquierdo = vision_cerca_prisma_izquierdo;
	}

	public String getVision_intermedia_esferico_derecho() {
		return vision_intermedia_esferico_derecho;
	}

	public void setVision_intermedia_esferico_derecho(String vision_intermedia_esferico_derecho) {
		this.vision_intermedia_esferico_derecho = vision_intermedia_esferico_derecho;
	}

	public String getVision_intermedia_cilindro_derecho() {
		return vision_intermedia_cilindro_derecho;
	}

	public void setVision_intermedia_cilindro_derecho(String vision_intermedia_cilindro_derecho) {
		this.vision_intermedia_cilindro_derecho = vision_intermedia_cilindro_derecho;
	}

	public String getVision_intermedia_eje_derecho() {
		return vision_intermedia_eje_derecho;
	}

	public void setVision_intermedia_eje_derecho(String vision_intermedia_eje_derecho) {
		this.vision_intermedia_eje_derecho = vision_intermedia_eje_derecho;
	}

	public String getVision_intermedia_av_derecho() {
		return vision_intermedia_av_derecho;
	}

	public void setVision_intermedia_av_derecho(String vision_intermedia_av_derecho) {
		this.vision_intermedia_av_derecho = vision_intermedia_av_derecho;
	}

	public String getVision_intermedia_dnp() {
		return vision_intermedia_dnp;
	}

	public void setVision_intermedia_dnp(String vision_intermedia_dnp) {
		this.vision_intermedia_dnp = vision_intermedia_dnp;
	}

	public String getVision_intermedia_prisma_derecho() {
		return vision_intermedia_prisma_derecho;
	}

	public void setVision_intermedia_prisma_derecho(String vision_intermedia_prisma_derecho) {
		this.vision_intermedia_prisma_derecho = vision_intermedia_prisma_derecho;
	}

	public String getVision_intermedia_esferico_izquierdo() {
		return vision_intermedia_esferico_izquierdo;
	}

	public void setVision_intermedia_esferico_izquierdo(String vision_intermedia_esferico_izquierdo) {
		this.vision_intermedia_esferico_izquierdo = vision_intermedia_esferico_izquierdo;
	}

	public String getVision_intermedia_cilindro_izquierdo() {
		return vision_intermedia_cilindro_izquierdo;
	}

	public void setVision_intermedia_cilindro_izquierdo(String vision_intermedia_cilindro_izquierdo) {
		this.vision_intermedia_cilindro_izquierdo = vision_intermedia_cilindro_izquierdo;
	}

	public String getVision_intermedia_eje_izquierdo() {
		return vision_intermedia_eje_izquierdo;
	}

	public void setVision_intermedia_eje_izquierdo(String vision_intermedia_eje_izquierdo) {
		this.vision_intermedia_eje_izquierdo = vision_intermedia_eje_izquierdo;
	}

	public String getVision_intermedia_av_izquierdo() {
		return vision_intermedia_av_izquierdo;
	}

	public void setVision_intermedia_av_izquierdo(String vision_intermedia_av_izquierdo) {
		this.vision_intermedia_av_izquierdo = vision_intermedia_av_izquierdo;
	}

	public String getVision_intermedia_prisma_izquierdo() {
		return vision_intermedia_prisma_izquierdo;
	}

	public void setVision_intermedia_prisma_izquierdo(String vision_intermedia_prisma_izquierdo) {
		this.vision_intermedia_prisma_izquierdo = vision_intermedia_prisma_izquierdo;
	}

	public String getLente_h_derecho() {
		return lente_h_derecho;
	}

	public void setLente_h_derecho(String lente_h_derecho) {
		this.lente_h_derecho = lente_h_derecho;
	}

	public String getLente_v_derecho() {
		return lente_v_derecho;
	}

	public void setLente_v_derecho(String lente_v_derecho) {
		this.lente_v_derecho = lente_v_derecho;
	}

	public String getLente_eje_derecho() {
		return lente_eje_derecho;
	}

	public void setLente_eje_derecho(String lente_eje_derecho) {
		this.lente_eje_derecho = lente_eje_derecho;
	}

	public String getLente_h_izquierdo() {
		return lente_h_izquierdo;
	}

	public void setLente_h_izquierdo(String lente_h_izquierdo) {
		this.lente_h_izquierdo = lente_h_izquierdo;
	}

	public String getLente_v_izquierdo() {
		return lente_v_izquierdo;
	}

	public void setLente_v_izquierdo(String lente_v_izquierdo) {
		this.lente_v_izquierdo = lente_v_izquierdo;
	}

	public String getLente_eje_izquierdo() {
		return lente_eje_izquierdo;
	}

	public void setLente_eje_izquierdo(String lente_eje_izquierdo) {
		this.lente_eje_izquierdo = lente_eje_izquierdo;
	}

	public String getLente_poder_derecho() {
		return lente_poder_derecho;
	}

	public void setLente_poder_derecho(String lente_poder_derecho) {
		this.lente_poder_derecho = lente_poder_derecho;
	}

	public String getLente_cb_derecho() {
		return lente_cb_derecho;
	}

	public void setLente_cb_derecho(String lente_cb_derecho) {
		this.lente_cb_derecho = lente_cb_derecho;
	}

	public String getLente_diametro_derecho() {
		return lente_diametro_derecho;
	}

	public void setLente_diametro_derecho(String lente_diametro_derecho) {
		this.lente_diametro_derecho = lente_diametro_derecho;
	}

	public String getLente_contacto_derecho() {
		return lente_contacto_derecho;
	}

	public void setLente_contacto_derecho(String lente_contacto_derecho) {
		this.lente_contacto_derecho = lente_contacto_derecho;
	}

	public String getLente_poder_izquierdo() {
		return lente_poder_izquierdo;
	}

	public void setLente_poder_izquierdo(String lente_poder_izquierdo) {
		this.lente_poder_izquierdo = lente_poder_izquierdo;
	}

	public String getLente_cb_izquierdo() {
		return lente_cb_izquierdo;
	}

	public void setLente_cb_izquierdo(String lente_cb_izquierdo) {
		this.lente_cb_izquierdo = lente_cb_izquierdo;
	}

	public String getLente_diametro_izquierdo() {
		return lente_diametro_izquierdo;
	}

	public void setLente_diametro_izquierdo(String lente_diametro_izquierdo) {
		this.lente_diametro_izquierdo = lente_diametro_izquierdo;
	}

	public String getLente_contacto_izquierdo() {
		return lente_contacto_izquierdo;
	}

	public void setLente_contacto_izquierdo(String lente_contacto_izquierdo) {
		this.lente_contacto_izquierdo = lente_contacto_izquierdo;
	}

	public String getLente_contacto() {
		return lente_contacto;
	}

	public void setLente_contacto(String lente_contacto) {
		this.lente_contacto = lente_contacto;
	}

	public String getLente_lampara_hendidura() {
		return lente_lampara_hendidura;
	}

	public void setLente_lampara_hendidura(String lente_lampara_hendidura) {
		this.lente_lampara_hendidura = lente_lampara_hendidura;
	}

	public String getOtros_lentes_usando_paciente() {
		return otros_lentes_usando_paciente;
	}

	public void setOtros_lentes_usando_paciente(String otros_lentes_usando_paciente) {
		this.otros_lentes_usando_paciente = otros_lentes_usando_paciente;
	}

	public String getOtros_medidas_od() {
		return otros_medidas_od;
	}

	public void setOtros_medidas_od(String otros_medidas_od) {
		this.otros_medidas_od = otros_medidas_od;
	}

	public String getOtros_medidas_oi() {
		return otros_medidas_oi;
	}

	public void setOtros_medidas_oi(String otros_medidas_oi) {
		this.otros_medidas_oi = otros_medidas_oi;
	}

	public String getOtros_sistomatologia() {
		return otros_sistomatologia;
	}

	public void setOtros_sistomatologia(String otros_sistomatologia) {
		this.otros_sistomatologia = otros_sistomatologia;
	}

	public String getOtros_diagnostico() {
		return otros_diagnostico;
	}

	public void setOtros_diagnostico(String otros_diagnostico) {
		this.otros_diagnostico = otros_diagnostico;
	}

	public String getOtros_tratamiento() {
		return otros_tratamiento;
	}

	public void setOtros_tratamiento(String otros_tratamiento) {
		this.otros_tratamiento = otros_tratamiento;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

//	public String getDescripcion_lente_vendido() {
//		return descripcion_lente_vendido;
//	}
//
//	public void setDescripcion_lente_vendido(String descripcion_lente_vendido) {
//		this.descripcion_lente_vendido = descripcion_lente_vendido;
//	}
//
//	public Double getMonto() {
//		return monto;
//	}
//
//	public void setMonto(Double monto) {
//		this.monto = monto;
//	}
//
//	public Double getA_cuenta() {
//		return a_cuenta;
//	}
//
//	public void setA_cuenta(Double a_cuenta) {
//		this.a_cuenta = a_cuenta;
//	}
//
//	public Double getSaldo() {
//		return saldo;
//	}
//
//	public void setSaldo(Double saldo) {
//		this.saldo = saldo;
//	}

	private static final long serialVersionUID = 1L;

}
