package hts.backend.model.dto;

import java.util.Date;

public class TipoExpedienteDTO implements EntidadDTO{


	private Integer tipoExpedienteId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer indicaDefault;
	private Integer status;
	private Date fecha;
	private String usuario;

	public Integer getTipoExpedienteId() {
		return tipoExpedienteId;
	}
	public void setTipoExpedienteId(Integer tipoExpedienteId) {
		this.tipoExpedienteId = tipoExpedienteId;
	}
	public String getCve() {
		return cve;
	}
	public void setCve(String cve) {
		this.cve = cve;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getIndicaDefault() {
		return indicaDefault;
	}
	public void setIndicaDefault(Integer indicaDefault) {
		this.indicaDefault = indicaDefault;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public Integer getId() {
		return getTipoExpedienteId();
	}



}
