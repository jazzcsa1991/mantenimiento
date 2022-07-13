package hts.backend.model.dto;

import java.util.Date;

public class OpcionCatalogoComunDTO {

	private Integer formId;
	private int idOpcion;
	private String cveOpcion;
	private String nombreOpcion;
	private String descripcionOpcion;
	private int valorDefault;
	private Float valorDefaultFloat;
	private int statusOpcion;
	private Float statusOpcionFloat;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Double comodin;
	private Float comodinFloat;
	private int idIdioma;

	private String nombreCompleto;

	private Date fechaInicio;
	private Date fechaFin;
	private Integer idOpcion2;
	private Integer eventoId;
	private Integer ordenMedicoId;

	public Integer getOrdenMedicoId() {
		return ordenMedicoId;
	}

	public void setOrdenMedicoId(Integer ordenMedicoId) {
		this.ordenMedicoId = ordenMedicoId;
	}

	public String getNombreCompleto() {
		return nombreOpcion + " " + cveOpcion + " " + (descripcionOpcion == null ? "" : descripcionOpcion);
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	private String nombreCatalogo;


	public int getIdOpcion() {
		return idOpcion;
	}

	public void setIdOpcion(int idOpcion) {
		this.idOpcion = idOpcion;
	}

	public String getCveOpcion() {
		return cveOpcion;
	}

	public void setCveOpcion(String cveOpcion) {
		this.cveOpcion = cveOpcion;
	}

	public String getNombreOpcion() {
		return nombreOpcion;
	}

	public void setNombreOpcion(String nombreOpcion) {
		this.nombreOpcion = nombreOpcion;
	}

	public String getDescripcionOpcion() {
		return descripcionOpcion;
	}

	public void setDescripcionOpcion(String descripcionOpcion) {
		this.descripcionOpcion = descripcionOpcion;
	}


	public int getStatusOpcion() {
		return statusOpcion;
	}

	public void setStatusOpcion(int statusOpcion) {
		this.statusOpcion = statusOpcion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public int getValorDefault() {
		return valorDefault;
	}

	public void setValorDefault(int valorDefault) {
		this.valorDefault = valorDefault;
	}

	public String getNombreCatalogo() {
		return nombreCatalogo;
	}

	public void setNombreCatalogo(String nombreCatalogo) {
		this.nombreCatalogo = nombreCatalogo;
	}


	public int getIdIdioma() {
		return idIdioma;
	}

	public void setIdIdioma(int idIdioma) {
		this.idIdioma = idIdioma;
	}

	public Double getComodin() {
		return comodin;
	}

	public void setComodin(Double comodin) {
		this.comodin = comodin;
	}


	public String toString() {
		String returnValue = " -- idOpcion :: " + this.idOpcion
				+ " -- cveOpcion ::" + this.cveOpcion
				+ " -- nombreOpcion :: " + this.nombreOpcion
				+ " -- descripcionOpcion :: " + this.descripcionOpcion
				+ " -- valorDefault :: " + this.valorDefault
				+ " -- statusOpcion :: " + this.statusOpcion
				+ " -- fechaRegistro :: " + this.fechaRegistro
				+ " -- usuarioRegistro :: " + this.usuarioRegistro
				+ " -- comodin :: " + this.comodin
				+ " --idIdioma :: " + this.idIdioma
				+ " -- nombreCompleto :: " + this.nombreCompleto
				+ " -- nombreCatalogo :: " + this.nombreCatalogo;

		return returnValue;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Integer getIdOpcion2() {
		return idOpcion2;
	}

	public void setIdOpcion2(Integer idOpcion2) {
		this.idOpcion2 = idOpcion2;
	}

	public Float getComodinFloat() {
		return comodinFloat;
	}

	public void setComodinFloat(Float comodinFloat) {
		this.comodinFloat = comodinFloat;
	}

	public Float getValorDefaultFloat() {
		return valorDefaultFloat;
	}

	public void setValorDefaultFloat(Float valorDefaultFloat) {
		this.valorDefaultFloat = valorDefaultFloat;
	}

	public Float getStatusOpcionFloat() {
		return statusOpcionFloat;
	}

	public void setStatusOpcionFloat(Float statusOpcionFloat) {
		this.statusOpcionFloat = statusOpcionFloat;
	}

	public Integer getEventoId() {
		return eventoId;
	}

	public void setEventoId(Integer eventoId) {
		this.eventoId = eventoId;
	}

	public Integer getFormId() {
		return formId;
	}

	public void setFormId(Integer formId) {
		this.formId = formId;
	}
}
