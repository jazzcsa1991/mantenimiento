package hts.backend.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "contacto")
public class Contacto implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer contactoId;
	private NomCatEstadoCivil nomCatEstadoCivil;
	private NomCatSexo nomCatSexo;
	private NomCatEscolaridad nomCatEscolaridad;
	private NomCatOcupacion nomCatOcupacion;
	private NomCatParentesco nomCatParentesco;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private Date fechaNacimiento;
	private Integer respLegal;
	private String curp;
	private Integer status;
//	private Set<AgenteContacto> agenteContactos = new HashSet<AgenteContacto>(0);

	public Contacto() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTACTO_ID", unique = true, nullable = false, precision = 22)
	public Integer getContactoId() {
		return this.contactoId;
	}

	public void setContactoId(Integer contactoId) {
		this.contactoId = contactoId;
	}


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ESTADO_CIVIL_ID")
	public NomCatEstadoCivil getNomCatEstadoCivil() {
		return this.nomCatEstadoCivil;
	}

	public void setNomCatEstadoCivil(NomCatEstadoCivil nomCatEstadoCivil) {
		this.nomCatEstadoCivil = nomCatEstadoCivil;
	}


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SEXO_ID", nullable = false)
	public NomCatSexo getNomCatSexo() {
		return this.nomCatSexo;
	}

	public void setNomCatSexo(NomCatSexo nomCatSexo) {
		this.nomCatSexo = nomCatSexo;
	}


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ESCOLARIDAD_ID")
	public NomCatEscolaridad getNomCatEscolaridad() {
		return this.nomCatEscolaridad;
	}

	public void setNomCatEscolaridad(NomCatEscolaridad nomCatEscolaridad) {
		this.nomCatEscolaridad = nomCatEscolaridad;
	}


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "OCUPACION_ID")
	public NomCatOcupacion getNomCatOcupacion() {
		return this.nomCatOcupacion;
	}

	public void setNomCatOcupacion(NomCatOcupacion nomCatOcupacion) {
		this.nomCatOcupacion = nomCatOcupacion;
	}


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PARENTESCO_ID")
	public NomCatParentesco getNomCatParentesco() {
		return this.nomCatParentesco;
	}

	public void setNomCatParentesco(NomCatParentesco nomCatParentesco) {
		this.nomCatParentesco = nomCatParentesco;
	}


	@Column(name = "NOMBRE", nullable = false, length = 20)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Column(name = "PRIMER_APELLIDO", length = 20)
	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}


	@Column(name = "SEGUNDO_APELLIDO", length = 20)
	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_NACIMIENTO", length = 7)
	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	@Column(name = "RESP_LEGAL", precision = 22)
	public Integer getRespLegal() {
		return this.respLegal;
	}

	public void setRespLegal(Integer respLegal) {
		this.respLegal = respLegal;
	}


	@Column(name = "CURP", length = 20)
	public String getCurp() {
		return this.curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}


	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "contacto")
	public Set<AgenteContacto> getAgenteContactos() {
		return this.agenteContactos;
	}

	public void setAgenteContactos(Set<AgenteContacto> agenteContactos) {
		this.agenteContactos = agenteContactos;
	}*/


	@Column(name = "ESTATUS", precision = 22)
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
