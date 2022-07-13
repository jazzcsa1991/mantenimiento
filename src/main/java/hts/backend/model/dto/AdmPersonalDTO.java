package hts.backend.model.dto;

import java.util.Date;

public class AdmPersonalDTO {
	private Integer admProfSaludGralId;
	private NomCatSexoDTO nomCatSexo;
	private NomCatNacionalidadesDTO nomCatNacionalidades;
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
	private String numeroEmpleado;
	private String nombreHospital;
	private String nombrePerfil;
	private Integer admProfSaludDataprofId;
	private Integer sexoId;
	private Integer nomCatNacionalidadesId;
	private String pais;
	private String descripcion;
	private Boolean medico;
	private String nombreCompleto;
	private Integer personalInterno;
	private String cedulaProfesional;


	public Integer getAdmProfSaludGralId() {
		return this.admProfSaludGralId;
	}

	public void setAdmProfSaludGralId(Integer admProfSaludGralId) {
		this.admProfSaludGralId = admProfSaludGralId;
	}

	public NomCatSexoDTO getNomCatSexo() {
		return this.nomCatSexo;
	}

	public void setNomCatSexo(NomCatSexoDTO nomCatSexo) {
		this.nomCatSexo = nomCatSexo;
	}


	public NomCatNacionalidadesDTO getNomCatNacionalidades() {
		return this.nomCatNacionalidades;
	}

	public void setNomCatNacionalidades(NomCatNacionalidadesDTO nomCatNacionalidades) {
		this.nomCatNacionalidades = nomCatNacionalidades;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreCorto() {
		return this.nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getPaterno() {
		return this.paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return this.materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCurp() {
		return this.curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getRfc() {
		return this.rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUsuarioCve() {
		return this.usuarioCve;
	}

	public void setUsuarioCve(String usuarioCve) {
		this.usuarioCve = usuarioCve;
	}

	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	public String getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(String numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

	public String getNombreHospital() {
		return nombreHospital;
	}

	public void setNombreHospital(String nombreHospital) {
		this.nombreHospital = nombreHospital;
	}

	public String getNombrePerfil() {
		return nombrePerfil;
	}

	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
	}

	public Integer getAdmProfSaludDataprofId() {
		return admProfSaludDataprofId;
	}

	public void setAdmProfSaludDataprofId(Integer admProfSaludDataprofId) {
		this.admProfSaludDataprofId = admProfSaludDataprofId;
	}

	public Integer getSexoId() {
		return sexoId;
	}

	public void setSexoId(Integer sexoId) {
		this.sexoId = sexoId;
	}

	public Integer getNomCatNacionalidadesId() {
		return nomCatNacionalidadesId;
	}

	public void setNomCatNacionalidadesId(Integer nomCatNacionalidadesId) {
		this.nomCatNacionalidadesId = nomCatNacionalidadesId;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getMedico() {
		return medico;
	}

	public void setMedico(Boolean medico) {
		this.medico = medico;
	}

	public String getNombreCompleto() {
		return paterno + (materno != null ? (" " + materno + ", ") : ", ") + nombre;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Integer getPersonalInterno() {
		return personalInterno;
	}

	public void setPersonalInterno(Integer personalInterno) {
		this.personalInterno = personalInterno;
	}

	public String getCedulaProfesional() {
		return cedulaProfesional;
	}

	public void setCedulaProfesional(String cedulaProfesional) {
		this.cedulaProfesional = cedulaProfesional;
	}
}
