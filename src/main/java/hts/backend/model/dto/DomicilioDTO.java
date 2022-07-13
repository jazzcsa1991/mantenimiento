package hts.backend.model.dto;

import java.util.Date;
import java.util.Objects;

public class DomicilioDTO {
	private Integer direccionId;
	private String calle;
	private String noExt;
	private String noExtLetra;
	private String noInt;
	private String noIntLetra;
	private String nombreVialidad;
	private String nombreAsentamiento;
	
	private Integer localidadId;
	
	private Integer municipioId;
	private String cveEnt;
	private String cveMun;
	
	private Integer entidadId;
	private String entidadCve;

	private Integer codigoPostalId;
	private Integer vialidadId;
	private Integer tipoAsenId;
	private Boolean status;
	private Date fechaRegistro;
	private String cve;
	private Boolean isDomicilioAlternativo;

	public DomicilioDTO() {
	}

	public Integer getDireccionId() {
		return direccionId;
	}

	public void setDireccionId(Integer direccionId) {
		this.direccionId = direccionId;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNoExt() {
		return noExt;
	}

	public void setNoExt(String noExt) {
		this.noExt = noExt;
	}

	public String getNoExtLetra() {
		return noExtLetra;
	}

	public void setNoExtLetra(String noExtLetra) {
		this.noExtLetra = noExtLetra;
	}

	public String getNoInt() {
		return noInt;
	}

	public void setNoInt(String noInt) {
		this.noInt = noInt;
	}

	public String getNoIntLetra() {
		return noIntLetra;
	}

	public void setNoIntLetra(String noIntLetra) {
		this.noIntLetra = noIntLetra;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getCve() {
		return cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	public Boolean getIsDomicilioAlternativo() {
		return isDomicilioAlternativo;
	}

	public void setIsDomicilioAlternativo(Boolean isDomicilioAlternativo) {
		this.isDomicilioAlternativo = isDomicilioAlternativo;
	}

	public String getNombreVialidad() {
		return nombreVialidad;
	}

	public void setNombreVialidad(String nombreVialidad) {
		this.nombreVialidad = nombreVialidad;
	}

	public String getNombreAsentamiento() {
		return nombreAsentamiento;
	}

	public void setNombreAsentamiento(String nombreAsentamiento) {
		this.nombreAsentamiento = nombreAsentamiento;
	}

	public Integer getMunicipioId() {
		return municipioId;
	}

	public void setMunicipioId(Integer municipioId) {
		this.municipioId = municipioId;
	}

	public Integer getLocalidadId() {
		return localidadId;
	}

	public void setLocalidadId(Integer localidadId) {
		this.localidadId = localidadId;
	}

	public Integer getCodigoPostalId() {
		return codigoPostalId;
	}

	public void setCodigoPostalId(Integer codigoPostalId) {
		this.codigoPostalId = codigoPostalId;
	}

	public Integer getVialidadId() {
		return vialidadId;
	}

	public void setVialidadId(Integer vialidadId) {
		this.vialidadId = vialidadId;
	}

	public Integer getTipoAsenId() {
		return tipoAsenId;
	}

	public void setTipoAsenId(Integer tipoAsenId) {
		this.tipoAsenId = tipoAsenId;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getCveEnt() {
		return cveEnt;
	}

	public void setCveEnt(String cveEnt) {
		this.cveEnt = cveEnt;
	}

	public String getCveMun() {
		return cveMun;
	}

	public void setCveMun(String cveMun) {
		this.cveMun = cveMun;
	}

	public Integer getEntidadId() {
		return entidadId;
	}

	public void setEntidadId(Integer entidadId) {
		this.entidadId = entidadId;
	}

	public String getEntidadCve() {
		return entidadCve;
	}

	public void setEntidadCve(String entidadCve) {
		this.entidadCve = entidadCve;
	}



	
}
