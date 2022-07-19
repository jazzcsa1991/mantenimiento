package hts.backend.model.dto;

import java.util.Date;

public class AdminTelefonoDTO {


	private String telefonoAdmin;
	private String usuarioRegistro;
	private Date fechaRegistro;
	private Integer tipoTelefonoId;
	private Integer telefonoAdminId;


	private Integer usuarioAdminId;


	public Integer getTelefonoAdminId() {
		return telefonoAdminId;
	}

	public void setTelefonoAdminId(Integer telefonoAdminId) {
		this.telefonoAdminId = telefonoAdminId;
	}

	public String getTelefonoAdmin() {
		return telefonoAdmin;
	}

	public void setTelefonoAdmin(String telefonoAdmin) {
		this.telefonoAdmin = telefonoAdmin;
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

	public Integer getTipoTelefonoId() {
		return tipoTelefonoId;
	}

	public void setTipoTelefonoId(Integer tipoTelefonoId) {
		this.tipoTelefonoId = tipoTelefonoId;
	}


	public Integer getUsuarioAdminId() {
		return usuarioAdminId;
	}

	public void setUsuarioAdminId(Integer usuarioAdminId) {
		this.usuarioAdminId = usuarioAdminId;
	}
}
