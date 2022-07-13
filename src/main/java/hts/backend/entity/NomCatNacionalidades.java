package hts.backend.entity;
// Generated 24/02/2017 07:59:12 PM by Hibernate Tools 5.2.0.CR1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * NomCatNacionalidades generated by hbm2java
 */
@Entity
@Table(name = "nom_cat_nacionalidades")
public class NomCatNacionalidades implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Integer nomCatNacionalidadesId;
	private String codigoPais;
	private String pais;
	private String cveNacionalidad;
	private Integer indicaDefault;
	private Integer status;
	private String usuarioCve;
	private Date fechaRegistro;
	private Set<AdmPersonal> admPersonals = new HashSet<AdmPersonal>(0);
	private Set<PacPaciente> pacPacientes = new HashSet<PacPaciente>(0);


	public NomCatNacionalidades() {
	}
	public NomCatNacionalidades(Integer nomCatNacionalidadesId) {
		this.nomCatNacionalidadesId = nomCatNacionalidadesId;
	}

	public NomCatNacionalidades(Integer nomCatNacionalidadesId, String codigoPais, String pais,
			String cveNacionalidad, Integer indicaDefault, Integer status, String usuarioCve,
			Date fechaRegistro) {
		this.nomCatNacionalidadesId = nomCatNacionalidadesId;
		this.codigoPais = codigoPais;
		this.pais = pais;
		this.cveNacionalidad = cveNacionalidad;
		this.indicaDefault = indicaDefault;
		this.status = status;
		this.usuarioCve = usuarioCve;
		this.fechaRegistro = fechaRegistro;
	}

	public NomCatNacionalidades(Integer nomCatNacionalidadesId, String codigoPais, String pais,
			String cveNacionalidad, Integer indicaDefault, Integer status, String usuarioCve, Date fechaRegistro,
			Set<AdmPersonal> admPersonals) {
		this.nomCatNacionalidadesId = nomCatNacionalidadesId;
		this.codigoPais = codigoPais;
		this.pais = pais;
		this.cveNacionalidad = cveNacionalidad;
		this.indicaDefault = indicaDefault;
		this.status = status;
		this.usuarioCve = usuarioCve;
		this.fechaRegistro = fechaRegistro;
		this.admPersonals = admPersonals;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NOM_CAT_NACIONALIDADES_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getNomCatNacionalidadesId() {
		return this.nomCatNacionalidadesId;
	}

	public void setNomCatNacionalidadesId(Integer nomCatNacionalidadesId) {
		this.nomCatNacionalidadesId = nomCatNacionalidadesId;
	}

	@Column(name = "CODIGO_PAIS", nullable = false, length = 10)
	public String getCodigoPais() {
		return this.codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	@Column(name = "PAIS", nullable = false, length = 50)
	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Column(name = "CVE_NACIONALIDAD", nullable = false, length = 20)
	public String getCveNacionalidad() {
		return this.cveNacionalidad;
	}

	public void setCveNacionalidad(String cveNacionalidad) {
		this.cveNacionalidad = cveNacionalidad;
	}

	@Column(name = "VALOR_DEFAULT", nullable = false, precision = 22, scale = 0)
	public Integer getIndicaDefault() {
		return this.indicaDefault;
	}

	public void setIndicaDefault(Integer indicaDefault) {
		this.indicaDefault = indicaDefault;
	}

	@Column(name = "ESTATUS", nullable = false, precision = 22, scale = 0)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "USUARIO_REGISTRO", nullable = false, length = 20)
	public String getUsuarioCve() {
		return this.usuarioCve;
	}

	public void setUsuarioCve(String usuarioCve) {
		this.usuarioCve = usuarioCve;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", nullable = false, length = 7)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nomCatNacionalidades")
	public Set<AdmPersonal> getAdmPersonals() {
		return this.admPersonals;
	}

	public void setAdmPersonals(Set<AdmPersonal> admPersonals) {
		this.admPersonals = admPersonals;
	}

//	@OneToOne(mappedBy="nomCatNacionalidades")
//	public PacPaciente getPacPaciente() {
//		return pacPaciente;
//	}
//	public void setPacPaciente(PacPaciente pacPaciente) {
//		this.pacPaciente = pacPaciente;
//	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nomCatNacionalidades")
	public Set<PacPaciente> getPacPacientes() {
		return pacPacientes;
	}
	public void setPacPacientes(Set<PacPaciente> pacPacientes) {
		this.pacPacientes = pacPacientes;
	}

}