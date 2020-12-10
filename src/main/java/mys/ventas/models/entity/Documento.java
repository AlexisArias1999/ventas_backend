package mys.ventas.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documentos")
public class Documento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_documento;

	private String descripcion;

	private String abreviatura;

	private Boolean doc_venta;

	private Boolean comprobantes_electronicos;

	private Boolean estado;

	public Long getId_documento() {
		return id_documento;
	}

	public Boolean getDoc_venta() {
		return doc_venta;
	}

	public void setDoc_venta(Boolean doc_venta) {
		this.doc_venta = doc_venta;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public void setId_documento(Long id_documento) {
		this.id_documento = id_documento;
	}

	public Boolean getComprobantes_electronicos() {
		return comprobantes_electronicos;
	}

	public void setComprobantes_electronicos(Boolean comprobantes_electronicos) {
		this.comprobantes_electronicos = comprobantes_electronicos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	private static final long serialVersionUID = 1L;

}
