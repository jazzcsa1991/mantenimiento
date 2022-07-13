package hts.backend.model.dto;

import java.util.Date;

public class AdmAlertasDTO {

	private Integer eventoAlertaId;
	private Integer alertaId;
	private String nombre;
	private Integer estatus;
	private Integer comentario;
	private String comentarioGuardado;
	private String icono;
	private Integer sexoId;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Date fechaEliminacion;
	private String usuarioEliminacion;
	private String interfazCaptura;
	private Integer hospitalId;
	private Integer captura;


	public Integer getEventoAlertaId() {
		return eventoAlertaId;
	}

	public void setEventoAlertaId(Integer eventoAlertaId) {
		this.eventoAlertaId = eventoAlertaId;
	}

	public Integer getCaptura() {
		return captura;
	}

	public void setCaptura(Integer captura) {
		this.captura = captura;
	}

	public String getComentarioGuardado() {
		return comentarioGuardado;
	}

	public void setComentarioGuardado(String comentarioGuardado) {
		this.comentarioGuardado = comentarioGuardado;
	}

	public Integer getAlertaId() {
		return alertaId;
	}

	public void setAlertaId(Integer alertaId) {
		this.alertaId = alertaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Integer getComentario() {
		return comentario;
	}

	public void setComentario(Integer comentario) {
		this.comentario = comentario;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public Integer getSexoId() {
		return sexoId;
	}

	public void setSexoId(Integer sexoId) {
		this.sexoId = sexoId;
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

	public String getInterfazCaptura() {
		return interfazCaptura;
	}

	public void setInterfazCaptura(String interfazCaptura) {
		this.interfazCaptura = interfazCaptura;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
}
