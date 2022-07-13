package hts.backend.entity;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "nom_cat_ocupacion")
public class NomCatOcupacion implements java.io.Serializable {
	private Integer ocupacionId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefualt;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistra;
	private Integer idiomaAppId;
//	private Set<PacPaciente> pacPacientes = new HashSet<PacPaciente>(0);
//	private Set<Contacto> contactos = new HashSet<Contacto>(0);

	public NomCatOcupacion() {
	}

	public NomCatOcupacion(Integer ocupacionId) {
		this.ocupacionId = ocupacionId;
	}


	@Id
	@Column(name = "OCUPACION_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getOcupacionId() {
		return this.ocupacionId;
	}

	public void setOcupacionId(Integer ocupacionId) {
		this.ocupacionId = ocupacionId;
	}


	@Column(name = "CVE", nullable = false, length = 20)
	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}


	@Column(name = "NOMBRE", nullable = false, length = 20)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Column(name = "DESCRIPCION", nullable = false, length = 20)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Column(name = "VALOR_DEFAULT", nullable = false, precision = 22, scale = 0)
	public Integer getValorDefualt() {
		return this.valorDefualt;
	}

	public void setValorDefualt(Integer valorDefualt) {
		this.valorDefualt = valorDefualt;
	}


	@Column(name = "ESTATUS", nullable = false, precision = 22, scale = 0)
	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
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


	@Column(name = "IDIOMA_APP_ID", precision = 22, scale = 0)
	public Integer getIdiomaAppId() {
		return this.idiomaAppId;
	}

	public void setIdiomaAppId(Integer idiomaAppId) {
		this.idiomaAppId = idiomaAppId;
	}


	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "nomCatOcupacion")
	public Set<PacPaciente> getPacPacientes() {
		return this.pacPacientes;
	}

	public void setPacPacientes(Set<PacPaciente> pacPacientes) {
		this.pacPacientes = pacPacientes;
	}*/


	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "nomCatOcupacion")
	public Set<Contacto> getContactos() {
		return this.contactos;
	}

	public void setContactos(Set<Contacto> contactos) {
		this.contactos = contactos;
	}*/
}
