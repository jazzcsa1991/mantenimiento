package hts.backend.entity;

import hts.backend.entity.AdmPersonal;
import hts.backend.entity.CatServEspecialidad;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Lenovo3 on 20/06/2017.
 */
@Entity
@Table(name = "respuesta_interconsulta")
public class RespuestaInterconsulta implements java.io.Serializable {

	private static final long serialVersionUID = 3099407188269548480L;
	private Integer respuestaInterconsultaId;
	private Date 	fechaRecepcion;
	private Date 	fechaRespuesta;
	private String 	resumenClinico;
	private Date 	fechaRegistro;
	private String 	usuarioRegistro;
	private CatServEspecialidad servEspecialidadRespuesta;
	private AdmPersonal profesionalRespuesta;
	private Interconsulta interconsultaId;






	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RESPUESTA_INTERCONSULTA_ID", nullable = false, precision = 0) public Integer getRespuestaInterconsultaId() {
		return respuestaInterconsultaId;
	}

	public void setRespuestaInterconsultaId(Integer respuestaInterconsultaId) {
		this.respuestaInterconsultaId = respuestaInterconsultaId;
	}

	@Basic @Column(name = "FECHA_RECEPCION", nullable = false) public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	@Basic @Column(name = "FECHA_RESPUESTA", nullable = true) public Date getFechaRespuesta() {
		return fechaRespuesta;
	}

	public void setFechaRespuesta(Date fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}

	@Basic @Column(name = "RESUMEN_CLINICO", nullable = false, length = 1000) public String getResumenClinico() {
		return resumenClinico;
	}

	public void setResumenClinico(String resumenClinico) {
		this.resumenClinico = resumenClinico;
	}

	@Basic @Column(name = "FECHA_REGISTRO", nullable = false) public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO", nullable = false, length = 50) public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}



	@ManyToOne @JoinColumn(name = "SERV_ESPECIALIDAD_RESPUESTA", referencedColumnName = "SERV_ESPECIALIDAD_ID", nullable = false)

	public CatServEspecialidad getServEspecialidadRespuesta() {
		return servEspecialidadRespuesta;
	}

	public void setServEspecialidadRespuesta(CatServEspecialidad servEspecialidadRespuesta) {
		this.servEspecialidadRespuesta = servEspecialidadRespuesta;
	}

	@ManyToOne @JoinColumn(name = "PROFESIONAL_RESPUESTA", referencedColumnName = "ADM_PROF_SALUD_GRAL_ID", nullable = false)
	public AdmPersonal getProfesionalRespuesta() {
		return profesionalRespuesta;
	}

	public void setProfesionalRespuesta(AdmPersonal profesionalRespuesta) {
		this.profesionalRespuesta = profesionalRespuesta;
	}







	@ManyToOne @JoinColumn(name = "INTERCONSULTA_ID", referencedColumnName = "INTERCONSULTA_ID", nullable = false)

	public Interconsulta getInterconsultaId() {
		return interconsultaId;
	}

	public void setInterconsultaId(Interconsulta interconsultaId) {
		this.interconsultaId = interconsultaId;
	}




}
