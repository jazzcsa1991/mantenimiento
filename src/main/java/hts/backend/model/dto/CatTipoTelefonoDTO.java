package hts.backend.model.dto;

import java.util.Date;

public class CatTipoTelefonoDTO {

	private static final long serialVersionUID = 1L;
	private Integer tipoTelefonoId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer status;
	private Date fechaRegistro;
	private String usuarioRegistra;
	private Integer indicaDefault;

	public CatTipoTelefonoDTO() {
	}

	public CatTipoTelefonoDTO(Integer tipoTelefonoId, String cve, String nombre, String descripcion, Integer status,
			Date fechaRegistro, String usuarioRegistra) {
		this.tipoTelefonoId = tipoTelefonoId;
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.status = status;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistra = usuarioRegistra;
	}

	public CatTipoTelefonoDTO(Integer tipoTelefonoId, String cve, String nombre, String descripcion, Integer status,
			Date fechaRegistro, String usuarioRegistra, Integer indicaDefault) {
		this.tipoTelefonoId = tipoTelefonoId;
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.status = status;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistra = usuarioRegistra;
		this.indicaDefault = indicaDefault;

	}

	public Integer getTipoTelefonoId() {
		return this.tipoTelefonoId;
	}

	public void setTipoTelefonoId(Integer tipoTelefonoId) {
		this.tipoTelefonoId = tipoTelefonoId;
	}

	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUsuarioRegistra() {
		return this.usuarioRegistra;
	}

	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}

	public Integer getIndicaDefault() {
		return this.indicaDefault;
	}

	public void setIndicaDefault(Integer indicaDefault) {
		this.indicaDefault = indicaDefault;
	}


}
