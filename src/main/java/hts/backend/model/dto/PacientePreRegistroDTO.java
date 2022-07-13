package hts.backend.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PacientePreRegistroDTO implements Serializable{

	private Integer idPaciente;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private Date fechaNacimiento;
	private String curp;
	private String telefono;
	private String correo;
	private Integer sexo_id;
	private Integer nacionalidad_id;
	private Integer entidad_id;
	private String entidadNacimiento_cve;
	private String municipioNacimiento_cve;
	private String codigo_postal;
	
	private PacRepresentanteLegalDTO representanteLegal;
	
	private List<BiometricosDTO> biometricos;
	
	private String fotoPaciente;
	

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public PacRepresentanteLegalDTO getRepresentanteLegal() {
		return representanteLegal;
	}

	public void setRepresentanteLegal(PacRepresentanteLegalDTO representanteLegal) {
		this.representanteLegal = representanteLegal;
	}

	public List<BiometricosDTO> getBiometricos() {
		return biometricos;
	}

	public void setBiometricos(List<BiometricosDTO> biometricos) {
		this.biometricos = biometricos;
	}

	public String getFotoPaciente() {
		return fotoPaciente;
	}

	public void setFotoPaciente(String fotoPaciente) {
		this.fotoPaciente = fotoPaciente;
	}

	public Integer getSexo_id() {
		return sexo_id;
	}

	public void setSexo_id(Integer sexo_id) {
		this.sexo_id = sexo_id;
	}

	public Integer getNacionalidad_id() {
		return nacionalidad_id;
	}

	public void setNacionalidad_id(Integer nacionalidad_id) {
		this.nacionalidad_id = nacionalidad_id;
	}

	public Integer getEntidad_id() {
		return entidad_id;
	}

	public void setEntidad_id(Integer entidad_id) {
		this.entidad_id = entidad_id;
	}

	public String getEntidadNacimiento_cve() {
		return entidadNacimiento_cve;
	}

	public void setEntidadNacimiento_cve(String entidadNacimiento_cve) {
		this.entidadNacimiento_cve = entidadNacimiento_cve;
	}

	public String getMunicipioNacimiento_cve() {
		return municipioNacimiento_cve;
	}

	public void setMunicipioNacimiento_cve(String municipioNacimiento_cve) {
		this.municipioNacimiento_cve = municipioNacimiento_cve;
	}

	public String getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}	
	

}
