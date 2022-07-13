package hts.backend.model.dto;

import java.util.Date;

public class PacEventoAlertaDTO {
	private Integer eventoAlertaId;
	private Integer eventoId;
	private Integer alertaId;
	private String comentario;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Date fechaEliminacion;
	private String usuarioEliminacion;

	public Integer getEventoAlertaId() {
		return eventoAlertaId;
	}

	public void setEventoAlertaId(Integer eventoAlertaId) {
		this.eventoAlertaId = eventoAlertaId;
	}

	public Integer getEventoId() {
		return eventoId;
	}

	public void setEventoId(Integer eventoId) {
		this.eventoId = eventoId;
	}

	public Integer getAlertaId() {
		return alertaId;
	}

	public void setAlertaId(Integer alertaId) {
		this.alertaId = alertaId;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
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

	public Date getFechaEliminacion() {
		return fechaEliminacion;
	}

	public void setFechaEliminacion(Date fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}

	public String getUsuarioEliminacion() {
		return usuarioEliminacion;
	}

	public void setUsuarioEliminacion(String usuarioEliminacion) {
		this.usuarioEliminacion = usuarioEliminacion;
	}
}
