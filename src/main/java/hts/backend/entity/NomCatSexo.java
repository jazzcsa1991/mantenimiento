package hts.backend.entity;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "nom_cat_sexo")
public class NomCatSexo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer sexoId;
	private String descripcion;
	private Date fechaRegistro;
	private Integer indicaDefault;
	private Integer estatus;
	private String noUsuario;
	private String sexNombre;
	private String sexAbrev;

//	private Set<AdmPersonal> admProfSaludGrals = new HashSet<AdmPersonal>(0);
//	private Set<PacPaciente> pacPacientes = new HashSet<PacPaciente>(0);
//	private Set<Contacto> contactos = new HashSet<Contacto>(0);
//	private Set<AdmSvSexo> admSvSexos = new HashSet<AdmSvSexo>(0);

	public NomCatSexo() {
	}

	public NomCatSexo(Integer sexoId) {
		this.sexoId = sexoId;
	}


	@Id
	@Column(name = "SEXO_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getSexoId() {
		return this.sexoId;
	}

	public void setSexoId(Integer sexoId) {
		this.sexoId = sexoId;
	}


	@Column(name = "DESCRIPCION", nullable = false, length = 60)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", nullable = false, length = 7)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@Column(name = "VALOR_DEFAULT", nullable = false, precision = 22, scale = 0)
	public Integer getIndicaDefault() {
		return this.indicaDefault;
	}

	public void setIndicaDefault(Integer indicaDefault) {
		this.indicaDefault = indicaDefault;
	}


	@Column(name = "ESTATUS", nullable = false, precision = 22, scale = 0)
	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}


	@Column(name = "NO_USUARIO", nullable = false, length = 50)
	public String getNoUsuario() {
		return this.noUsuario;
	}

	public void setNoUsuario(String noUsuario) {
		this.noUsuario = noUsuario;
	}

	@Column(name = "SEX_ABREVIATURA", nullable = false, length = 5)
	public String getSexAbrev() {
		return this.sexAbrev;
	}

	public void setSexAbrev(String sexAbrev) {
		this.sexAbrev = sexAbrev;
	}

	@Column(name = "SEX_NOMBRE", nullable = false, length = 50)
	public String getSexNombre() {
		return this.sexNombre;
	}

	public void setSexNombre(String sexNombre) {
		this.sexNombre = sexNombre;
	}


	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "nomCatSexo")
	public Set<AdmPersonal> getAdmPersonals() {
		return this.admProfSaludGrals;
	}

	public void setAdmPersonals(Set<AdmPersonal> admProfSaludGrals) {
		this.admProfSaludGrals = admProfSaludGrals;
	}*/


	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "nomCatSexo")
	public Set<PacPaciente> getPacPacientes() {
		return pacPacientes;
	}

	public void setPacPacientes(Set<PacPaciente> pacPacientes) {
		this.pacPacientes = pacPacientes;
	}*/


	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "nomCatSexo")
	public Set<Contacto> getContactos() {
		return this.contactos;
	}

	public void setContactos(Set<Contacto> contactos) {
		this.contactos = contactos;
	}*/


	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "nomCatSexo")
	public Set<AdmSvSexo> getAdmSvSexo() {
		return this.admSvSexos;
	}

	public void setAdmSvSexo(Set<AdmSvSexo> admSvSexos) {
		this.admSvSexos = admSvSexos;
	}*/
}
