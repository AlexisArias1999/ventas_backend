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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "documento_correlativo")
public class DocumentoCorrelativo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_documento_correlativo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Empresa empresa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_documento")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Documento documento;

	private String serie;

	private Long emitidos;

	private Boolean ventas;


	private static final long serialVersionUID = 1L;

	public Long getId_documento_correlativo() {
		return id_documento_correlativo;
	}

	public void setId_documento_correlativo(Long id_documento_correlativo) {
		this.id_documento_correlativo = id_documento_correlativo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public Boolean getVentas() {
		return ventas;
	}

	public void setVentas(Boolean ventas) {
		this.ventas = ventas;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Long getEmitidos() {
		return emitidos;
	}

	public void setEmitidos(Long emitidos) {
		this.emitidos = emitidos;
	}


}
