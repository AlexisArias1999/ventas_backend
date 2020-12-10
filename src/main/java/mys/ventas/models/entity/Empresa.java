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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "empresas")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_empresa;

	@NotEmpty(message = "El campo razon social de la empresa no puede estar vacio")
	@Size(min = 3, message = "El campo razon social la empresa debe tener minimo 3 caracteres")
	@Column(nullable = false)
	private String razon_social;

//	@NotEmpty(message = "El campo ruc de la empresa no puede estar vacio")
//	@Size(min = 11, message = "El campo ruc de la empresa debe tener minimo 11 caracteres")
	@Column(nullable = false)
	private String ruc;

	@Email(message = "Error al ingresar el email")
	@Column(nullable = false, unique = true)
	private String correo;

//	@NotEmpty(message = "El capo dirección de la empresa no puede estar vacio")
//	@Size(min = 3, message = "El campo dirección la empresa debe tener minimo 3 caracteres")
	@Column(nullable = false)
	private String direccion;

	@Column(nullable = false)
	private String distrito;

	@Column(nullable = false)
	private String provincia;

	@Column(nullable = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date creado;

	@Column(nullable = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificado;

	@Column(nullable = true)
	private String imagen;

//	@NotEmpty(message = "El capo celular de la empresa no puede estar vacio")
	@Column(nullable = true)
	private String celular;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_persona")
	private TipoPersona tipo_persona;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_documento_persona")
	private DocumentoPersona documento_persona;

	@Column(nullable = false)
	private Boolean estado;

	public Long getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(Long id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getCelular() {
		return celular;
	}

	public TipoPersona getTipo_persona() {
		return tipo_persona;
	}

	public void setTipo_persona(TipoPersona tipo_persona) {
		this.tipo_persona = tipo_persona;
	}

	public DocumentoPersona getDocumento_persona() {
		return documento_persona;
	}

	public void setDocumento_persona(DocumentoPersona documento_persona) {
		this.documento_persona = documento_persona;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}
