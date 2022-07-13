package hts.backend.model.dto;

import java.util.Date;
import java.util.List;

public class PacRepresentanteLegalDTO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer idRepresentante;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private Date fechaNacimiento;
	private String curp;
	private Integer sexoId;
	private Integer nacionalidadId;	
	private String telefono;
	private String correo;
	private Integer parentescoId;	
	private Integer entidadId;
	private String entidadNacimientoCve;
	private String municipioNacimientoCve;
	private String codigoPostal;	
	
	private List<BiometricosDTO> biometricos;
	
	private String fotoRepresentante;
	


	public Integer getIdRepresentante() {
		return idRepresentante;
	}

	public void setIdRepresentante(Integer idRepresentante) {
		this.idRepresentante = idRepresentante;
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

	public Integer getSexoId() {
		return sexoId;
	}

	public void setSexoId(Integer sexoId) {
		this.sexoId = sexoId;
	}

	public Integer getNacionalidadId() {
		return nacionalidadId;
	}

	public void setNacionalidadId(Integer nacionalidadId) {
		this.nacionalidadId = nacionalidadId;
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

	public Integer getParentescoId() {
		return parentescoId;
	}

	public void setParentescoId(Integer parentescoId) {
		this.parentescoId = parentescoId;
	}

	public Integer getEntidadId() {
		return entidadId;
	}

	public void setEntidadId(Integer entidadId) {
		this.entidadId = entidadId;
	}

	public String getEntidadNacimientoCve() {
		return entidadNacimientoCve;
	}

	public void setEntidadNacimientoCve(String entidadNacimientoCve) {
		this.entidadNacimientoCve = entidadNacimientoCve;
	}

	public String getMunicipioNacimientoCve() {
		return municipioNacimientoCve;
	}

	public void setMunicipioNacimientoCve(String municipioNacimientoCve) {
		this.municipioNacimientoCve = municipioNacimientoCve;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public List<BiometricosDTO> getBiometricos() {
		return biometricos;
	}

	public void setBiometricos(List<BiometricosDTO> biometricos) {
		this.biometricos = biometricos;
	}

	public String getFotoRepresentante() {
		return fotoRepresentante;
	}

	public void setFotoRepresentante(String fotoRepresentante) {
		this.fotoRepresentante = fotoRepresentante;
	}
	
	
	
	
	

}
