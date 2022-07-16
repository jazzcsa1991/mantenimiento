package hts.backend.model.dto;

import java.util.Date;

public class ResponsableHospitalDTO {

	private Integer responsableHospitalId;
	private Integer usuarioId;
	private Integer estadoId;
	private Integer rissId;
	private Integer jurisdiccionId;
	private Integer hospitalId;
	private Integer idClues;
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

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Integer getIdClues() {
		return idClues;
	}

	public void setIdClues(Integer idClues) {
		this.idClues = idClues;
	}

	public Integer getResponsableHospitalId() {
		return responsableHospitalId;
	}

	public void setResponsableHospitalId(Integer responsableHospitalId) {
		this.responsableHospitalId = responsableHospitalId;
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

	public Integer getRissId() {
		return rissId;
	}

	public void setRissId(Integer rissId) {
		this.rissId = rissId;
	}

	public Integer getJurisdiccionId() {
		return jurisdiccionId;
	}

	public void setJurisdiccionId(Integer jurisdiccionId) {
		this.jurisdiccionId = jurisdiccionId;
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
