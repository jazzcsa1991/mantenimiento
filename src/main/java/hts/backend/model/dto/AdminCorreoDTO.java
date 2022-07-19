package hts.backend.model.dto;

import java.util.Date;

public class AdminCorreoDTO {

	private Integer correoAdminId;
	private String correoAdmin;
	private String usuarioRegistro;
	private Date fechaRegistro;
	private Integer usuarioAdminId;


	public Integer getCorreoAdminId() {
		return correoAdminId;
	}

	public void setCorreoAdminId(Integer correoAdminId) {
		this.correoAdminId = correoAdminId;
	}

	public String getCorreoAdmin() {
		return correoAdmin;
	}

	public void setCorreoAdmin(String correoAdmin) {
		this.correoAdmin = correoAdmin;
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

	public Integer getUsuarioAdminId() {
		return usuarioAdminId;
	}

	public void setUsuarioAdminId(Integer usuarioAdminId) {
		this.usuarioAdminId = usuarioAdminId;
	}
}
