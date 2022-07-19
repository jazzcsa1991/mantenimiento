package hts.backend.model.dto;

public class ReporteDatosHospitalDTO {
	private Integer hospitalId;
	private String nombre;
	private String nombreCorto;
	private String calle;
	private String numeroInterior;
	private String numeroInteriorLetra;
	private String numeroExterior;
	private String numeroExteriorLetra;
	private String localidad;
	private String municipio;
	private String estado;
	private String pais;
	private String codigoPostal;
	private String licenciaSanitaria;
	private String telefono;
	private String asentamiento;
	private String clues;
	private String correo;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumeroInterior() {
		return numeroInterior;
	}

	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}

	public String getNumeroExterior() {
		return numeroExterior;
	}

	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getLicenciaSanitaria() {
		return licenciaSanitaria;
	}

	public void setLicenciaSanitaria(String licenciaSanitaria) {
		this.licenciaSanitaria = licenciaSanitaria;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getAsentamiento() {
		return asentamiento;
	}

	public void setAsentamiento(String asentamiento) {
		this.asentamiento = asentamiento;
	}

	public String getClues() {
		return clues;
	}

	public void setClues(String clues) {
		this.clues = clues;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getNumeroInteriorLetra() {
		return numeroInteriorLetra;
	}

	public void setNumeroInteriorLetra(String numeroInteriorLetra) {
		this.numeroInteriorLetra = numeroInteriorLetra;
	}

	public String getNumeroExteriorLetra() {
		return numeroExteriorLetra;
	}

	public void setNumeroExteriorLetra(String numeroExteriorLetra) {
		this.numeroExteriorLetra = numeroExteriorLetra;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
}
