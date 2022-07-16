package hts.backend.model.dto;

import java.util.Date;

public class ResponsableEstadoDTO {

	private Integer responsableEstadoId;
	private Integer usuarioId;
	private Integer estadoId;
	private String usuarioRegistro;
	private String nombreCompleto;
	private String username;
	private Date fechaRegistro;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Integer getResponsableEstadoId() {
		return responsableEstadoId;
	}

	public void setResponsableEstadoId(Integer responsableEstadoId) {
		this.responsableEstadoId = responsableEstadoId;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Integer getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Integer estadoId) {
		this.estadoId = estadoId;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
}
