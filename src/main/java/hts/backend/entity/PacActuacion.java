package hts.backend.entity;


import hts.backend.entity.AdmCama;
import hts.backend.entity.AdmConsultorio;
import hts.backend.entity.AdmPersonal;
import hts.backend.entity.CatServEspecialidad;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by SASA Desarrollo on 17/04/2017.
 */
@Entity
@Deprecated
@Table(name = "pac_actuacion")
public class PacActuacion implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer actuacionId;
	private Date fechaCreacion;
	private String noActuacion;
	private PacEvento pacEventoByEventoId;
	private CatTipoActuacion catTipoActuacionByTipoActuacionId;
	private AdmPersonal admPersonalByProfesionalRespId;
	private CatServEspecialidad catServEspecialidadByServicioEspecialidadRespId;
	private CatTipoActorActuacion catTipoActorActuacionByTipoActorActuacionId;
	private AdmConsultorio admConsultorioByConsultorioId;
	private AdmCama admCamaByCamaId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACTUACION_ID") public Integer getActuacionId() {
		return actuacionId;
	}

	public void setActuacionId(Integer actuacionId) {
		this.actuacionId = actuacionId;
	}

	@Basic @Column(name = "FECHA_CREACION") public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@ManyToOne @JoinColumn(name = "EVENTO_ID", referencedColumnName = "EVENTO_ID", nullable = false)
	public PacEvento getPacEventoByEventoId() {
		return pacEventoByEventoId;
	}

	public void setPacEventoByEventoId(PacEvento pacEventoByEventoId) {
		this.pacEventoByEventoId = pacEventoByEventoId;
	}

	@ManyToOne @JoinColumn(name = "TIPO_ACTUACION_ID", referencedColumnName = "TIPO_ACTUACION_ID", nullable = false)
	public CatTipoActuacion getCatTipoActuacionByTipoActuacionId() {
		return catTipoActuacionByTipoActuacionId;
	}

	public void setCatTipoActuacionByTipoActuacionId(CatTipoActuacion catTipoActuacionByTipoActuacionId) {
		this.catTipoActuacionByTipoActuacionId = catTipoActuacionByTipoActuacionId;
	}

	@ManyToOne @JoinColumn(name = "PROFESIONAL_RESP_ID", referencedColumnName = "ADM_PROF_SALUD_GRAL_ID", nullable = false)
	public AdmPersonal getAdmPersonalByProfesionalRespId() {
		return admPersonalByProfesionalRespId;
	}

	public void setAdmPersonalByProfesionalRespId(AdmPersonal admPersonalByProfesionalRespId) {
		this.admPersonalByProfesionalRespId = admPersonalByProfesionalRespId;
	}

	@ManyToOne @JoinColumn(name = "SERVICIO_ESPECIALIDAD_RESP_ID", referencedColumnName = "SERV_ESPECIALIDAD_ID", nullable = false)
	public CatServEspecialidad getCatServEspecialidadByServicioEspecialidadRespId() {
		return catServEspecialidadByServicioEspecialidadRespId;
	}

	public void setCatServEspecialidadByServicioEspecialidadRespId(CatServEspecialidad catServEspecialidadByServicioEspecialidadRespId) {
		this.catServEspecialidadByServicioEspecialidadRespId = catServEspecialidadByServicioEspecialidadRespId;
	}

	@ManyToOne @JoinColumn(name = "TIPO_ACTOR_ACTUACION_ID", referencedColumnName = "TIPO_ACTOR_ACTUACION_ID")
	public CatTipoActorActuacion getCatTipoActorActuacionByTipoActorActuacionId() {
		return catTipoActorActuacionByTipoActorActuacionId;
	}

	public void setCatTipoActorActuacionByTipoActorActuacionId(CatTipoActorActuacion catTipoActorActuacionByTipoActorActuacionId) {
		this.catTipoActorActuacionByTipoActorActuacionId = catTipoActorActuacionByTipoActorActuacionId;
	}


	@ManyToOne @JoinColumn(name = "CONSULTORIO_ID", referencedColumnName = "CONSULTORIO_ID")
	public AdmConsultorio getAdmConsultorioByConsultorioId() {
		return admConsultorioByConsultorioId;
	}

	public void setAdmConsultorioByConsultorioId(AdmConsultorio admConsultorioByConsultorioId) {
		this.admConsultorioByConsultorioId = admConsultorioByConsultorioId;
	}

	@ManyToOne @JoinColumn(name = "CAMA_ID", referencedColumnName = "CAMA_ID")
	public AdmCama getAdmCamaByCamaId() {
		return admCamaByCamaId;
	}

	public void setAdmCamaByCamaId(AdmCama admCamaByCamaId) {
		this.admCamaByCamaId = admCamaByCamaId;
	}


	@Basic @Column(name = "NO_ACTUACION")
	public String getNoActuacion() {
		return noActuacion;
	}

	public void setNoActuacion(String noActuacion) {
		this.noActuacion = noActuacion;
	}
}
