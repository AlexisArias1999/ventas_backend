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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_producto;

	@NotEmpty(message = "El nombre del producto no puede estar vacio")
	@NotNull(message = "El nombre del producto no puede nulo")
	@Column(nullable = false)
	@Size(min = 2, message = "Ingrese minimo 2 caracteres")
	private String nombre;

	private String nombre_secundario;

	private String descripcion;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto_unidad")
	private ProductoUnidad producto_unidad;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_moneda")
	private Moneda moneda;

	@Min(value = 1, message = "El precio de venta no puede ser 0")
	@NotNull(message = "El precio unitario de venta no puede ser nulo")
	@Column(nullable = false, precision = 10, scale = 2)
	private Double precio_unitario_venta;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_afectacion_venta")
	private TipoAfectacion tipo_afectacion_venta;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto_categoria")
	private ProductoCategoria producto_categoria;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto_marca")
	private ProductoMarca producto_marca;

	private Boolean calcular_cantidad_precio;

	private Boolean incluye_igv_venta;

	private String codigo_interno;

	private String codigo_sunat;

	@Min(value = 1, message = "Valor minimo 1")
	@NotNull(message = "El stock inicial no puede ser nulo")
	@Column(nullable = false)
	private Integer stock_inicial;

	private Integer stock_minimo;

	private Boolean maneja_lotes;

	private String codigo_lote;

	private Boolean maneja_series;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_producto")
	private List<ProductoSerie> producto_serie;

	private Boolean incluye_percepcion;

	private Double porcentaje_percepcion;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_almacen")
	@NotNull(message = "Debe seleccionar un almacen")
	private Almacen almacen;

	@Temporal(TemporalType.DATE)
	private Date fecha_vencimiento;

	private String linea_producto;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_producto")
	private List<ProductoAtributos> producto_atributos;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_afectacion_compra")
	private TipoAfectacion tipo_afectacion_compra;

	private Double precio_unitario_compra;

	private Boolean porcentaje_ganancia;

	private Double porcentaje;

	private Boolean incluye_igv_compra;

	private String imagen;

	private Boolean estado;

	public Long getId_producto() {
		return id_producto;
	}

	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre_secundario() {
		return nombre_secundario;
	}

	public void setNombre_secundario(String nombre_secundario) {
		this.nombre_secundario = nombre_secundario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ProductoUnidad getProducto_unidad() {
		return producto_unidad;
	}

	public void setProducto_unidad(ProductoUnidad producto_unidad) {
		this.producto_unidad = producto_unidad;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public Double getPrecio_unitario_venta() {
		return precio_unitario_venta;
	}

	public void setPrecio_unitario_venta(Double precio_unitario_venta) {
		this.precio_unitario_venta = precio_unitario_venta;
	}

	public TipoAfectacion getTipo_afectacion_venta() {
		return tipo_afectacion_venta;
	}

	public void setTipo_afectacion_venta(TipoAfectacion tipo_afectacion_venta) {
		this.tipo_afectacion_venta = tipo_afectacion_venta;
	}

	public ProductoCategoria getProducto_categoria() {
		return producto_categoria;
	}

	public void setProducto_categoria(ProductoCategoria producto_categoria) {
		this.producto_categoria = producto_categoria;
	}

	public ProductoMarca getProducto_marca() {
		return producto_marca;
	}

	public void setProducto_marca(ProductoMarca producto_marca) {
		this.producto_marca = producto_marca;
	}

	public Boolean getCalcular_cantidad_precio() {
		return calcular_cantidad_precio;
	}

	public void setCalcular_cantidad_precio(Boolean calcular_cantidad_precio) {
		this.calcular_cantidad_precio = calcular_cantidad_precio;
	}

	public Boolean getIncluye_igv_venta() {
		return incluye_igv_venta;
	}

	public void setIncluye_igv_venta(Boolean incluye_igv_venta) {
		this.incluye_igv_venta = incluye_igv_venta;
	}

	public String getCodigo_interno() {
		return codigo_interno;
	}

	public void setCodigo_interno(String codigo_interno) {
		this.codigo_interno = codigo_interno;
	}

	public String getCodigo_sunat() {
		return codigo_sunat;
	}

	public void setCodigo_sunat(String codigo_sunat) {
		this.codigo_sunat = codigo_sunat;
	}

	public Integer getStock_inicial() {
		return stock_inicial;
	}

	public void setStock_inicial(Integer stock_inicial) {
		this.stock_inicial = stock_inicial;
	}

	public Integer getStock_minimo() {
		return stock_minimo;
	}

	public void setStock_minimo(Integer stock_minimo) {
		this.stock_minimo = stock_minimo;
	}

	public Boolean getManeja_lotes() {
		return maneja_lotes;
	}

	public void setManeja_lotes(Boolean maneja_lotes) {
		this.maneja_lotes = maneja_lotes;
	}

	public String getCodigo_lote() {
		return codigo_lote;
	}

	public void setCodigo_lote(String codigo_lote) {
		this.codigo_lote = codigo_lote;
	}

	public Boolean getManeja_series() {
		return maneja_series;
	}

	public void setManeja_series(Boolean maneja_series) {
		this.maneja_series = maneja_series;
	}

	public List<ProductoSerie> getProducto_serie() {
		return producto_serie;
	}

	public void setProducto_serie(List<ProductoSerie> producto_serie) {
		this.producto_serie = producto_serie;
	}

	public Boolean getIncluye_percepcion() {
		return incluye_percepcion;
	}

	public void setIncluye_percepcion(Boolean incluye_percepcion) {
		this.incluye_percepcion = incluye_percepcion;
	}

	public Double getPorcentaje_percepcion() {
		return porcentaje_percepcion;
	}

	public void setPorcentaje_percepcion(Double porcentaje_percepcion) {
		this.porcentaje_percepcion = porcentaje_percepcion;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public Date getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(Date fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}

	public String getLinea_producto() {
		return linea_producto;
	}

	public void setLinea_producto(String linea_producto) {
		this.linea_producto = linea_producto;
	}

	public List<ProductoAtributos> getProducto_atributos() {
		return producto_atributos;
	}

	public void setProducto_atributos(List<ProductoAtributos> producto_atributos) {
		this.producto_atributos = producto_atributos;
	}

	public TipoAfectacion getTipo_afectacion_compra() {
		return tipo_afectacion_compra;
	}

	public void setTipo_afectacion_compra(TipoAfectacion tipo_afectacion_compra) {
		this.tipo_afectacion_compra = tipo_afectacion_compra;
	}

	public Double getPrecio_unitario_compra() {
		return precio_unitario_compra;
	}

	public void setPrecio_unitario_compra(Double precio_unitario_compra) {
		this.precio_unitario_compra = precio_unitario_compra;
	}

	public Boolean getPorcentaje_ganancia() {
		return porcentaje_ganancia;
	}

	public void setPorcentaje_ganancia(Boolean porcentaje_ganancia) {
		this.porcentaje_ganancia = porcentaje_ganancia;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Boolean getIncluye_igv_compra() {
		return incluye_igv_compra;
	}

	public void setIncluye_igv_compra(Boolean incluye_igv_compra) {
		this.incluye_igv_compra = incluye_igv_compra;
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

	private static final long serialVersionUID = 1L;

}
