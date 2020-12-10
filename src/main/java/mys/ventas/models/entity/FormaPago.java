package mys.ventas.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "forma_pago")
public class FormaPago implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_forma_pago;

	@Column(unique = true)
	private String descripcion;

	private Boolean disopnibilidad_fondos;

	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "forma_pago_entidades", joinColumns = @JoinColumn(name = "id_forma_pago"), inverseJoinColumns = @JoinColumn(name = "id_entidad"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "id_forma_pago", "id_entidad" }) })
	private List<Entidad> entidad;

	private Boolean estado;

	public Long getId_forma_pago() {
		return id_forma_pago;
	}

	public void setId_forma_pago(Long id_forma_pago) {
		this.id_forma_pago = id_forma_pago;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getDisopnibilidad_fondos() {
		return disopnibilidad_fondos;
	}

	public void setDisopnibilidad_fondos(Boolean disopnibilidad_fondos) {
		this.disopnibilidad_fondos = disopnibilidad_fondos;
	}

	public List<Entidad> getEntidad() {
		return entidad;
	}

	public void setEntidad(List<Entidad> entidad) {
		this.entidad = entidad;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	private static final long serialVersionUID = 1L;

}
