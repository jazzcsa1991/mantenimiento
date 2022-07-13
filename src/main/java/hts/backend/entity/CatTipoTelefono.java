package hts.backend.entity;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "cat_tipo_telefono")
public class CatTipoTelefono implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer tipoTelefonoId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer status;
	private Date fechaRegistro;
	private String usuarioRegistra;
	private Integer indicaDefault;
	private Set<Telefono> telefonos = new HashSet<Telefono>(0);

	public CatTipoTelefono() {
	}

	public CatTipoTelefono(Integer tipoTelefonoId) {
		this.tipoTelefonoId = tipoTelefonoId;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TIPO_TELEFONO_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getTipoTelefonoId() {
		return this.tipoTelefonoId;
	}

	public void setTipoTelefonoId(Integer tipoTelefonoId) {
		this.tipoTelefonoId = tipoTelefonoId;
	}


	@Column(name = "CVE", nullable = false, length = 20)
	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}


	@Column(name = "NOMBRE", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Column(name = "DESCRIPCION", nullable = false, length = 100)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Column(name = "ESTATUS", nullable = false, precision = 22, scale = 0)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", nullable = false, length = 7)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@Column(name = "USUARIO_REGISTRO", nullable = false, length = 20)
	public String getUsuarioRegistra() {
		return this.usuarioRegistra;
	}

	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}

	@Column(name = "VALOR_DEFAULT", precision = 22, scale = 0)
	public Integer getIndicaDefault() {
		return this.indicaDefault;
	}

	public void setIndicaDefault(Integer indicaDefault) {
		this.indicaDefault = indicaDefault;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catTipoTelefono")
	public Set<Telefono> getTelefonos() {
		return this.telefonos;
	}

	public void setTelefonos(Set<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
}
