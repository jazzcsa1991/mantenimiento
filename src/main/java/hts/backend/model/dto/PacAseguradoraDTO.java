package hts.backend.model.dto;

import java.util.Date;

public class PacAseguradoraDTO {

	private Integer pacAseguradoraId;
	private Integer pacienteId;
	private Integer catCoaseguroId;
	private Integer catAseguradoraId;
	private Integer convenioAseguradoraId;
	private Integer catMotivoAsignacionId;
	private Integer prioridad;
	private String noPoliza;
	private Integer deducible;
	private Integer limiteSeguro;
	private Date fechaInicia;
	private Date fechaFin;
	private Date fechaRegistro;
	private String usuarioRegistra;
	private String pacienteNombre;
	private String catCoaseguroNombre;
	private String catAseguradoraNombre;
	private String catAseguradoraCve;
	private String convenioAseguradoraNombre;
	private String catMotivoAsignacionNombre;
	private String nombreCompuesto;

	public Integer getPacAseguradoraId() {
		return pacAseguradoraId;
	}
	public void setPacAseguradoraId(Integer pacAseguradoraId) {
		this.pacAseguradoraId = pacAseguradoraId;
	}

	public Integer getPacienteId() {
		return pacienteId;
	}
	public void setPacienteId(Integer pacienteId) {
		this.pacienteId = pacienteId;
	}
	public String getPacienteNombre() {
		return pacienteNombre;
	}
	public void setPacienteNombre(String pacienteNombre) {
		this.pacienteNombre = pacienteNombre;
	}
	public Integer getCatCoaseguroId() {
		return catCoaseguroId;
	}
	public void setCatCoaseguroId(Integer catCoaseguroId) {
		this.catCoaseguroId = catCoaseguroId;
	}
	public Integer getCatAseguradoraId() {
		return catAseguradoraId;
	}
	public void setCatAseguradoraId(Integer catAseguradoraId) {
		this.catAseguradoraId = catAseguradoraId;
	}
	public Integer getConvenioAseguradoraId() {
		return convenioAseguradoraId;
	}
	public void setConvenioAseguradoraId(Integer convenioAseguradoraId) {
		this.convenioAseguradoraId = convenioAseguradoraId;
	}
	public Integer getCatMotivoAsignacionId() {
		return catMotivoAsignacionId;
	}
	public void setCatMotivoAsignacionId(Integer catMotivoAsignacionId) {
		this.catMotivoAsignacionId = catMotivoAsignacionId;
	}
	public Integer getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}
	public String getNoPoliza() {
		return noPoliza;
	}
	public void setNoPoliza(String noPoliza) {
		this.noPoliza = noPoliza;
	}
	public Integer getDeducible() {
		return deducible;
	}
	public void setDeducible(Integer deducible) {
		this.deducible = deducible;
	}
	public Integer getLimiteSeguro() {
		return limiteSeguro;
	}
	public void setLimiteSeguro(Integer limiteSeguro) {
		this.limiteSeguro = limiteSeguro;
	}
	public Date getFechaInicia() {
		return fechaInicia;
	}
	public void setFechaInicia(Date fechaInicia) {
		this.fechaInicia = fechaInicia;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getUsuarioRegistra() {
		return usuarioRegistra;
	}
	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}
	public String getCatCoaseguroNombre() {
		return catCoaseguroNombre;
	}
	public void setCatCoaseguroNombre(String catCoaseguroNombre) {
		this.catCoaseguroNombre = catCoaseguroNombre;
	}
	public String getCatAseguradoraNombre() {
		return catAseguradoraNombre;
	}
	public void setCatAseguradoraNombre(String catAseguradoraNombre) {
		this.catAseguradoraNombre = catAseguradoraNombre;
	}
	public String getConvenioAseguradoraNombre() {
		return convenioAseguradoraNombre;
	}
	public void setConvenioAseguradoraNombre(String convenioAseguradoraNombre) {
		this.convenioAseguradoraNombre = convenioAseguradoraNombre;
	}
	public String getCatAseguradoraCve() {
		return catAseguradoraCve;
	}
	public void setCatAseguradoraCve(String catAseguradoraCve) {
		this.catAseguradoraCve = catAseguradoraCve;
	}
	public String getCatMotivoAsignacionNombre() {
		return catMotivoAsignacionNombre;
	}
	public void setCatMotivoAsignacionNombre(String catMotivoAsignacionNombre) {
		this.catMotivoAsignacionNombre = catMotivoAsignacionNombre;
	}

	public String getNombreCompuesto() {
		return catAseguradoraNombre+" / "+convenioAseguradoraNombre;
	}

	public void setNombreCompuesto(String nombreCompuesto) {
		this.nombreCompuesto = nombreCompuesto;
	}


}
