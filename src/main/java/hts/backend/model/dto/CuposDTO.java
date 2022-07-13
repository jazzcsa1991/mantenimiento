package hts.backend.model.dto;

import java.util.Date;

public class CuposDTO {
	private Integer cupoId;
	private Integer agendaModeloId;
	private Integer agendaDetalleId;
	private Integer statusId;
	private Date Fecha;
	private Integer horaInicio;
	private Integer horaFinal;
	private Date fechaHoraInicio;
	private Date fechaHoraFinal;
	private boolean flagExisteOtraCita;
	private Integer peticionExpedienteId;
	private Integer bloqueo;
	private Integer hospitalId;
	private Date horaInicioS;
	private Date horaFinalS;
	private Integer cexId;

	private long cupoIdLong;

	private String tipoCupo;

	private Integer profId;
	private Integer consultorioId;
	private Integer isEquipo;

	public Integer getProfId() {
		return profId;
	}

	public void setProfId(Integer profId) {
		this.profId = profId;
	}

	public Integer getConsultorioId() {
		return consultorioId;
	}

	public void setConsultorioId(Integer consultorioId) {
		this.consultorioId = consultorioId;
	}

	public Integer getCupoId() {
		return cupoId;
	}
	public void setCupoId(Integer cupoId) {
		this.cupoId = cupoId;
	}
	public Integer getAgendaModeloId() {
		return agendaModeloId;
	}
	public void setAgendaModeloId(Integer agendaModeloId) {
		this.agendaModeloId = agendaModeloId;
	}
	public Integer getAgendaDetalleId() {
		return agendaDetalleId;
	}
	public void setAgendaDetalleId(Integer agendaDetalleId) {
		this.agendaDetalleId = agendaDetalleId;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public Integer getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Integer horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Integer getHoraFinal() {
		return horaFinal;
	}
	public void setHoraFinal(Integer horaFinal) {
		this.horaFinal = horaFinal;
	}
	public String getTipoCupo() {
		return tipoCupo;
	}
	public void setTipoCupo(String tipoCupo) {
		this.tipoCupo = tipoCupo;
	}
	public Date getFechaHoraInicio() {
		return fechaHoraInicio;
	}
	public void setFechaHoraInicio(Date fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}
	public Date getFechaHoraFinal() {
		return fechaHoraFinal;
	}
	public void setFechaHoraFinal(Date fechaHoraFinal) {
		this.fechaHoraFinal = fechaHoraFinal;
	}
	public long getCupoIdLong() {
		return cupoIdLong;
	}
	public void setCupoIdLong(long cupoIdLong) {
		this.cupoIdLong = cupoIdLong;
	}

	public boolean isFlagExisteOtraCita() {
		return flagExisteOtraCita;
	}

	public void setFlagExisteOtraCita(boolean flagExisteOtraCita) {
		this.flagExisteOtraCita = flagExisteOtraCita;
	}

	public Integer getPeticionExpedienteId() {
		return peticionExpedienteId;
	}

	public void setPeticionExpedienteId(Integer peticionExpedienteId) {
		this.peticionExpedienteId = peticionExpedienteId;
	}

	public Date getHoraInicioS() {
		return horaInicioS;
	}

	public void setHoraInicioS(Date horaInicioS) {
		this.horaInicioS = horaInicioS;
	}

	public Date getHoraFinalS() {
		return horaFinalS;
	}

	public void setHoraFinalS(Date horaFinalS) {
		this.horaFinalS = horaFinalS;
	}

	public Integer getBloqueo() {
		return bloqueo;
	}

	public void setBloqueo(Integer bloqueo) {
		this.bloqueo = bloqueo;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Integer getCexId() {
		return cexId;
	}

	public void setCexId(Integer cexId) {
		this.cexId = cexId;
	}

	public Integer getIsEquipo() {
		return isEquipo;
	}

	public void setIsEquipo(Integer isEquipo) {
		this.isEquipo = isEquipo;
	}
}