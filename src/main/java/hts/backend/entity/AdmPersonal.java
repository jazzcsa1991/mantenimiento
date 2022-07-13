package hts.backend.entity;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "adm_personal")
public class AdmPersonal implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer admProfSaludGralId;
	private String nombre;
	private String nombreCorto;
	private String paterno;
	private String materno;
	private Date fechaNacimiento;
	private String curp;
	private String rfc;
	private Integer status;
	private Date fechaRegistro;
	private String usuarioCve;
	private String cve;
	private Boolean medico;
	private NomCatSexo nomCatSexo;
	private NomCatNacionalidades nomCatNacionalidades;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADM_PROF_SALUD_GRAL_ID", unique = true, nullable = false)
	public Integer getAdmProfSaludGralId() {
		return this.admProfSaludGralId;
	}

	public void setAdmProfSaludGralId(Integer admProfSaludGralId) {
		this.admProfSaludGralId = admProfSaludGralId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SEXO_ID", nullable = false)
	public NomCatSexo getNomCatSexo() {
		return this.nomCatSexo;
	}

	public void setNomCatSexo(NomCatSexo nomCatSexo) {
		this.nomCatSexo = nomCatSexo;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NACIONALIDAD_ID", nullable = false)
	public NomCatNacionalidades getNomCatNacionalidades() {
		return this.nomCatNacionalidades;
	}

	public void setNomCatNacionalidades(NomCatNacionalidades nomCatNacionalidades) {
		this.nomCatNacionalidades = nomCatNacionalidades;
	}


	@Basic @Column(name = "NOMBRE", nullable = false, length = 90)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Basic @Column(name = "NOMBRE_CORTO", length = 30)
	public String getNombreCorto() {
		return this.nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}


	@Basic @Column(name = "PATERNO", nullable = false, length = 90)
	public String getPaterno() {
		return this.paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}


	@Basic @Column(name = "MATERNO", length = 90)
	public String getMaterno() {
		return this.materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}


	@Basic @Temporal(TemporalType.DATE)
	@Column(name = "FECHA_NACIMIENTO", nullable = false, length = 7)
	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	@Basic @Column(name = "CURP", nullable = false, length = 18)
	public String getCurp() {
		return this.curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}


	@Basic @Column(name = "RFC", nullable = false, length = 13)
	public String getRfc() {
		return this.rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}


	@Basic @Column(name = "ESTATUS", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	@Basic @Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", nullable = false, length = 7)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@Basic @Column(name = "USUARIO_REGISTRO", nullable = false, length = 20)
	public String getUsuarioCve() {
		return this.usuarioCve;
	}

	public void setUsuarioCve(String usuarioCve) {
		this.usuarioCve = usuarioCve;
	}


	@Basic @Column(name = "CVE", length = 50)
	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}


	@Basic @Column(name = "MEDICO", nullable = false, updatable = false)
	public Boolean getMedico() {
		return medico;
	}

	public void setMedico(Boolean medico) {
		this.medico = medico;
	}
}
