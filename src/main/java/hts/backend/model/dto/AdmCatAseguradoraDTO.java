package hts.backend.model.dto;

import java.util.Date;


public class AdmCatAseguradoraDTO {
	private int aseguradoraId;
	private int hospitalId;
	private Integer asegHospId;
	private int clasificacionFiscalId;
	private Integer tipoMonedaId;
	private int tipoAseguradoraId;
	private String cve;
	private String nombre;
	private String descripcion;
	private String telefono;
	private String fiscalId;
	private String deudor;
	private String cuentaAsociada;
	private int valorDefault;
	private Date fechaRegistra;
	private String usuarioRegistro;
	private int estatus;
	private String asentamiento;
    private String tipoAsen;
	private String tipoVial;
	private String vialidad;
	private String pais;
	private String entidad;
	private String localidad;
	private String municipio;
	private String cp;
	private String calle;

	private String nomTipoAseguradora;
	private String nomTipoMoneda;
	private String nomClasFiscal;

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public int getAseguradoraId() {
		return aseguradoraId;
	}
	public void setAseguradoraId(int aseguradoraId) {
		this.aseguradoraId = aseguradoraId;
	}
	public int getClasificacionFiscalId() {
		return clasificacionFiscalId;
	}
	public void setClasificacionFiscalId(int clasificacionFiscalId) {
		this.clasificacionFiscalId = clasificacionFiscalId;
	}

	public Integer getTipoMonedaId() {
		return tipoMonedaId;
	}

	public void setTipoMonedaId(Integer tipoMonedaId) {
		this.tipoMonedaId = tipoMonedaId;
	}

	public int getTipoAseguradoraId() {
		return tipoAseguradoraId;
	}
	public void setTipoAseguradoraId(int tipoAseguradoraId) {
		this.tipoAseguradoraId = tipoAseguradoraId;
	}
	public String getCve() {
		return cve;
	}
	public void setCve(String cve) {
		this.cve = cve;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getFiscalId() {
		return fiscalId;
	}
	public void setFiscalId(String fiscalId) {
		this.fiscalId = fiscalId;
	}
	public String getDeudor() {
		return deudor;
	}
	public void setDeudor(String deudor) {
		this.deudor = deudor;
	}
	public String getCuentaAsociada() {
		return cuentaAsociada;
	}
	public void setCuentaAsociada(String cuentaAsociada) {
		this.cuentaAsociada = cuentaAsociada;
	}
	public int getValorDefault() {
		return valorDefault;
	}
	public void setValorDefault(int valorDefault) {
		this.valorDefault = valorDefault;
	}
	public Date getFechaRegistra() {
		return fechaRegistra;
	}
	public void setFechaRegistra(Date fechaRegistra) {
		this.fechaRegistra = fechaRegistra;
	}
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}
	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}
	public int getEstatus() {
		return estatus;
	}
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}


	public String getNomTipoAseguradora() {
		return nomTipoAseguradora;
	}
	public void setNomTipoAseguradora(String nomTipoAseguradora) {
		this.nomTipoAseguradora = nomTipoAseguradora;
	}
	public String getNomTipoMoneda() {
		return nomTipoMoneda;
	}
	public void setNomTipoMoneda(String nomTipoMoneda) {
		this.nomTipoMoneda = nomTipoMoneda;
	}
	public String getNomClasFiscal() {
		return nomClasFiscal;
	}
	public void setNomClasFiscal(String nomClasFiscal) {
		this.nomClasFiscal = nomClasFiscal;
	}

	public String getAsentamiento() {
		return asentamiento;
	}

	public void setAsentamiento(String asentamiento) {
		this.asentamiento = asentamiento;
	}

	public String getTipoAsen() {
		return tipoAsen;
	}

	public void setTipoAsen(String tipoAsen) {
		this.tipoAsen = tipoAsen;
	}

	public String getTipoVial() {
		return tipoVial;
	}

	public void setTipoVial(String tipoVial) {
		this.tipoVial = tipoVial;
	}

	public String getVialidad() {
		return vialidad;
	}

	public void setVialidad(String vialidad) {
		this.vialidad = vialidad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
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

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getAsegHospId() {
		return asegHospId;
	}

	public void setAsegHospId(Integer asegHospId) {
		this.asegHospId = asegHospId;
	}
}
