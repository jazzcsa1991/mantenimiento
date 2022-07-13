package hts.backend.entity;
// Generated 28/02/2017 11:04:15 AM by Hibernate Tools 5.2.0.Beta1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import hts.backend.entity.AdmConsultorio;
import hts.backend.entity.CatPeticionExpediente;
import hts.backend.entity.CatServEspecialidad;

/**
 * AdmAgendaDetalle generated by hbm2java
 */
@Entity
@Table(name = "adm_agenda_detalle")
public class AdmAgendaDetalle implements java.io.Serializable {


	private static final long serialVersionUID = 1L;

	//private AdmAgendaDetalleId id;
	private Integer agendaDetalleId;
	private AdmCatTipoConsulta catTipoConsulta;
//	private CatTipoExpediente catTipoExpediente;
	private CatPeticionExpediente catPeticionExpediente;
	private AdmConsultorio admConsultorio;
	private CatServEspecialidad catServEspecialidad;
	private AdmAgendaModelo admAgendaModelo;
	private Date fechaInicio;
	private Date fechaFinal;
	private Date horaInicio;
	private Date horaFinal;
	private Integer limiteCupoExtra;
	private Date horaDescansoInicio;
	private Date horaDescansoFin;
	private Integer numPaciente;
	private Integer duracionConsulta;
	private Integer totalCupos;
	private Integer descanso;
	private Integer cupoExtra;
	private Integer bloqueoDias;
	private Integer status;
	private Integer lunes;
	private Integer martes;
	private Integer miercoles;
	private Integer jueves;
	private Integer viernes;
	private Integer sabado;
	private Integer domingo;
	private Set<AdmAgendaCupos> admAgendaCuposes = new HashSet<AdmAgendaCupos>(0);

	public AdmAgendaDetalle() {
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AGENDA_DETALLE_ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getAgendaDetalleId() {
		return agendaDetalleId;
	}

	public void setAgendaDetalleId(Integer agendaDetalleId) {
		this.agendaDetalleId = agendaDetalleId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_CONSULTA_ID", nullable = false)
	public AdmCatTipoConsulta getCatTipoConsulta() {
		return this.catTipoConsulta;
	}

	public void setCatTipoConsulta(AdmCatTipoConsulta catTipoConsulta) {
		this.catTipoConsulta = catTipoConsulta;
	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "PETICION_EXPEDIENTE_ID", nullable = false)
//	public CatTipoExpediente getCatTipoExpediente() {
//		return this.catTipoExpediente;
//	}
//
//	public void setCatTipoExpediente(CatTipoExpediente catTipoExpediente) {
//		this.catTipoExpediente = catTipoExpediente;
//	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PETICION_EXPEDIENTE_ID", nullable = false)
	public CatPeticionExpediente getCatPeticionExpediente() {
		return this.catPeticionExpediente;
	}

	public void setCatPeticionExpediente(CatPeticionExpediente catPeticionExpediente) {
		this.catPeticionExpediente = catPeticionExpediente;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CONSULTORIO_ID", nullable = false)
	public AdmConsultorio getAdmConsultorio() {
		return this.admConsultorio;
	}

	public void setAdmConsultorio(AdmConsultorio admConsultorio) {
		this.admConsultorio = admConsultorio;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SERV_ESPECIALES_ID", nullable = false)
	public CatServEspecialidad getCatServEspecialidad() {
		return this.catServEspecialidad;
	}

	public void setCatServEspecialidad(CatServEspecialidad catServEspecialidad) {
		this.catServEspecialidad = catServEspecialidad;
	}



	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AGENDA_MODELO_ID", nullable = false)
	public AdmAgendaModelo getAdmAgendaModelo() {
		return this.admAgendaModelo;
	}

	public void setAdmAgendaModelo(AdmAgendaModelo admAgendaModelo) {
		this.admAgendaModelo = admAgendaModelo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_INICIO", nullable = false, length = 7)
	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_FINAL", nullable = false, length = 7)
	public Date getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	@Column(name = "HORA_INICIO", nullable = false, precision = 10, scale = 0)
	public Date getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	@Column(name = "HORA_FINAL", nullable = false, precision = 10, scale = 0)
	public Date getHoraFinal() {
		return this.horaFinal;
	}

	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}

	@Column(name = "LIMITE_CUPO_EXTRA", nullable = false, precision = 10, scale = 0)
	public Integer getLimiteCupoExtra() {
		return this.limiteCupoExtra;
	}

	public void setLimiteCupoExtra(Integer limiteCupoExtra) {
		this.limiteCupoExtra = limiteCupoExtra;
	}

	@Column(name = "HORA_DESCANSO_INICIO", precision = 10, scale = 0)
	public Date getHoraDescansoInicio() {
		return this.horaDescansoInicio;
	}

	public void setHoraDescansoInicio(Date horaDescansoInicio) {
		this.horaDescansoInicio = horaDescansoInicio;
	}

	@Column(name = "HORA_DESCANSO_FIN", precision = 10, scale = 0)
	public Date getHoraDescansoFin() {
		return this.horaDescansoFin;
	}

	public void setHoraDescansoFin(Date horaDescansoFin) {
		this.horaDescansoFin = horaDescansoFin;
	}

	@Column(name = "NUM_PACIENTE", nullable = false, precision = 10, scale = 0)
	public Integer getNumPaciente() {
		return this.numPaciente;
	}

	public void setNumPaciente(Integer numPaciente) {
		this.numPaciente = numPaciente;
	}

	@Column(name = "DURACION_CONSULTA", nullable = false, precision = 10, scale = 0)
	public Integer getDuracionConsulta() {
		return this.duracionConsulta;
	}

	public void setDuracionConsulta(Integer duracionConsulta) {
		this.duracionConsulta = duracionConsulta;
	}

	@Column(name = "TOTAL_CUPOS", nullable = false, precision = 10, scale = 0)
	public Integer getTotalCupos() {
		return this.totalCupos;
	}

	public void setTotalCupos(Integer totalCupos) {
		this.totalCupos = totalCupos;
	}

	@Column(name = "DESCANSO", precision = 10, scale = 0)
	public Integer getDescanso() {
		return this.descanso;
	}

	public void setDescanso(Integer descanso) {
		this.descanso = descanso;
	}

	@Column(name = "CUPO_EXTRA", precision = 10, scale = 0)
	public Integer getCupoExtra() {
		return this.cupoExtra;
	}

	public void setCupoExtra(Integer cupoExtra) {
		this.cupoExtra = cupoExtra;
	}

	@Column(name = "BLOQUEO_DIAS", precision = 10, scale = 0)
	public Integer getBloqueoDias() {
		return this.bloqueoDias;
	}

	public void setBloqueoDias(Integer bloqueoDias) {
		this.bloqueoDias = bloqueoDias;
	}

	@Column(name = "ESTATUS", precision = 10, scale = 0)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	@Column(name = "LUNES", precision = 10, scale = 0)
	public Integer getLunes() {
		return this.lunes;
	}

	public void setLunes(Integer lunes) {
		this.lunes = lunes;
	}
	@Column(name = "MARTES", precision = 10, scale = 0)
	public Integer getMartes() {
		return this.martes;
	}

	public void setMartes(Integer martes) {
		this.martes = martes;
	}
	@Column(name = "MIERCOLES", precision = 10, scale = 0)
	public Integer getMiercoles() {
		return this.miercoles;
	}

	public void setMiercoles(Integer miercoles) {
		this.miercoles = miercoles;
	}
	@Column(name = "JUEVES", precision = 10, scale = 0)
	public Integer getJueves() {
		return this.jueves;
	}

	public void setJueves(Integer jueves) {
		this.jueves = jueves;
	}
	@Column(name = "VIERNES", precision = 10, scale = 0)
	public Integer getViernes() {
		return this.viernes;
	}

	public void setViernes(Integer viernes) {
		this.viernes = viernes;
	}
	@Column(name = "SABADO", precision = 10, scale = 0)
	public Integer getSabado() {
		return this.sabado;
	}

	public void setSabado(Integer sabado) {
		this.sabado = sabado;
	}
	@Column(name = "DOMINGO", precision = 10, scale = 0)
	public Integer getDomingo() {
		return this.domingo;
	}

	public void setDomingo(Integer domingo) {
		this.domingo = domingo;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "admAgendaDetalle")
	public Set<AdmAgendaCupos> getAdmAgendaCuposes() {
		return this.admAgendaCuposes;
	}

	public void setAdmAgendaCuposes(Set<AdmAgendaCupos> admAgendaCuposes) {
		this.admAgendaCuposes = admAgendaCuposes;
	}

}