package hts.backend.model.dto;

import java.util.Date;

public class AdminPermisosDTO {

	private Integer adminPermisosAdminId;
	private String permisos;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Integer hospitalId;
	private Integer usuarioAdminId;


	public Integer getUsuarioAdminId() {
		return usuarioAdminId;
	}

	public void setUsuarioAdminId(Integer usuarioAdminId) {
		this.usuarioAdminId = usuarioAdminId;
	}

	public Integer getAdminPermisosAdminId() {
		return adminPermisosAdminId;
	}

	public void setAdminPermisosAdminId(Integer adminPermisosAdminId) {
		this.adminPermisosAdminId = adminPermisosAdminId;
	}

	public String getPermisos() {
		return permisos;
	}

	public void setPermisos(String permisos) {
		this.permisos = permisos;
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

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
}
