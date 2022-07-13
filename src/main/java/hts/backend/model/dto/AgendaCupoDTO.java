package hts.backend.model.dto;

import java.util.Date;

/**
 * Created by SASA Desarrollo on 20/06/2017.
 */
public class AgendaCupoDTO {

	private Date fechaInicio;
	private Date fechaFin;
	private Integer turnos;
	private Integer cupoId;
	private Integer pacienteId;
	private Integer peticionExpedienteId;
	private Integer tipoConsultaId;
	private Integer agendaId;
	private String agenda;
	private Boolean servicio;
	private Boolean extra;
	private Integer lcExtra;
	private String clave;
	private Boolean flex;
	private Integer consId;
	private Integer servEspecialidadId;

	public Integer getConsId() {
		return consId;
	}

	public void setConsId(Integer consId) {
		this.consId = consId;
	}

	public Integer getCupoId() {
		return cupoId;
	}

	public void setCupoId(Integer cupoId) {
		this.cupoId = cupoId;
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

	public Integer getTurnos() {
		return turnos;
	}

	public void setTurnos(Integer turnos) {
		this.turnos = turnos;
	}

	public Integer getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Integer pacienteId) {
		this.pacienteId = pacienteId;
	}

	public Integer getPeticionExpedienteId() {
		return peticionExpedienteId;
	}

	public void setPeticionExpedienteId(Integer peticionExpedienteId) {
		this.peticionExpedienteId = peticionExpedienteId;
	}

	public Integer getAgendaId() {
		return agendaId;
	}

	public void setAgendaId(Integer agendaId) {
		this.agendaId = agendaId;
	}

	public Boolean getServicio() {
		return servicio;
	}

	public void setServicio(Boolean servicio) {
		this.servicio = servicio;
	}

	public String getAgenda() {
		return agenda;
	}

	public void setAgenda(String agenda) {
		this.agenda = agenda;
	}

	public Boolean getExtra() {
		return extra;
	}

	public void setExtra(Boolean extra) {
		this.extra = extra;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Boolean getFlex() {
		return flex;
	}

	public void setFlex(Boolean flex) {
		this.flex = flex;
	}

	public Integer getTipoConsultaId() {
		return tipoConsultaId;
	}

	public void setTipoConsultaId(Integer tipoConsultaId) {
		this.tipoConsultaId = tipoConsultaId;
	}

	public Integer getServEspecialidadId() {
		return servEspecialidadId;
	}

	public void setServEspecialidadId(Integer servEspecialidadId) {
		this.servEspecialidadId = servEspecialidadId;
	}

	public Integer getLcExtra() {
		return lcExtra;
	}

	public void setLcExtra(Integer lcExtra) {
		this.lcExtra = lcExtra;
	}
}
