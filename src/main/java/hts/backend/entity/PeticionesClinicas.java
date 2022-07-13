package hts.backend.entity;

import hts.backend.entity.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "peticiones_clinicas")
public class PeticionesClinicas implements java.io.Serializable {
	private Integer peticionesClinicasId;
	private CatTipoEvento tipoEventoId;
	private CatTipoPrueba tipoPruebaId;
	private CatServEspecialidad servEspecialidadId;
	private AdmPersonal profSalGralId;
	private CatEstatusPeticionClinica estatus;
	private Date fechaSugerida;
	private Integer urgente;
	private String datosClinicos;
	private NomCatCie10 cie10Id;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private String peticionClinicasFolio;
	private PacEvento eventoId;
	private Date fechaModificacion;
	private String usuarioModificacion;
	private CatServEspecialidad admCatServEspecialidadByServEspecialidadIdSte;

	private Set<EstudiosPeticiones> estudiosPeticiones = new HashSet<>(0);


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EVENTO_ID")
	public PacEvento getEventoId() {
		return eventoId;
	}

	public void setEventoId(PacEvento eventoId) {
		this.eventoId = eventoId;
	}


	@Basic @Column(name = "PETICION_CLINICA_FOLIO", nullable = false, length = 20)
	public String getPeticionClinicasFolio() {
		return peticionClinicasFolio;
	}

	public void setPeticionClinicasFolio(String peticionClinicasFolio) {
		this.peticionClinicasFolio = peticionClinicasFolio;
	}


	@Basic @Column(name = "FECHA_MODIFICACION")
	public Date getFechaModificacion() {
		return fechaModificacion;
	}


	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}


	@Basic @Column(name = "USUARIO_MODIFICACION")
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}


	@OneToMany(mappedBy = "peticionesClinicasId")
	public Set<EstudiosPeticiones> getEstudiosPeticiones() {
		return estudiosPeticiones;
	}

	public void setEstudiosPeticiones(Set<EstudiosPeticiones> estudiosPeticiones) {
		this.estudiosPeticiones = estudiosPeticiones;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_EVENTO_ID")
	public CatTipoEvento getTipoEventoId() {
		return tipoEventoId;
	}

	public void setTipoEventoId(CatTipoEvento tipoEventoId) {
		this.tipoEventoId = tipoEventoId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_PRUEBA_ID")
	public CatTipoPrueba getTipoPruebaId() {
		return tipoPruebaId;
	}

	public void setTipoPruebaId(CatTipoPrueba tipoPruebaId) {
		this.tipoPruebaId = tipoPruebaId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SERV_ESPECIALIDAD_ID")
	public CatServEspecialidad getServEspecialidadId() {
		return servEspecialidadId;
	}

	public void setServEspecialidadId(CatServEspecialidad servEspecialidadId) {
		this.servEspecialidadId = servEspecialidadId;
	}

	@ManyToOne @JoinColumn(name = "SERV_ESPECIALIDAD_ID_STE", referencedColumnName = "SERV_ESPECIALIDAD_ID")
	public CatServEspecialidad getAdmCatServEspecialidadByServEspecialidadIdSte() {
		return admCatServEspecialidadByServEspecialidadIdSte;
	}

	public void setAdmCatServEspecialidadByServEspecialidadIdSte(CatServEspecialidad admCatServEspecialidadByServEspecialidadIdSte) {
		this.admCatServEspecialidadByServEspecialidadIdSte = admCatServEspecialidadByServEspecialidadIdSte;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ADM_PROF_SALUD_GRAL_ID")
	public AdmPersonal getProfSalGralId() {
		return profSalGralId;
	}

	public void setProfSalGralId(AdmPersonal profSalGralId) {
		this.profSalGralId = profSalGralId;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PETICIONES_CLINICAS_ID", nullable = false)
	public Integer getPeticionesClinicasId() {
		return peticionesClinicasId;
	}

	public void setPeticionesClinicasId(Integer peticionesClinicasId) {
		this.peticionesClinicasId = peticionesClinicasId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ESTATUS")
	public CatEstatusPeticionClinica getEstatus() {
		return estatus;
	}

	public void setEstatus(CatEstatusPeticionClinica estatus) {
		this.estatus = estatus;
	}


	@Basic @Column(name = "FECHA_SUGERIDA", nullable = false)
	public Date getFechaSugerida() {
		return fechaSugerida;
	}

	public void setFechaSugerida(Date fechaSugerida) {
		this.fechaSugerida = fechaSugerida;
	}

	@Basic @Column(name = "URGENTE")
	public Integer getUrgente() {
		return urgente;
	}

	public void setUrgente(Integer urgente) {
		this.urgente = urgente;
	}

	@Basic @Column(name = "DATOS_CLINICOS")
	public String getDatosClinicos() {
		return datosClinicos;
	}

	public void setDatosClinicos(String datosClinicos) {
		this.datosClinicos = datosClinicos;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CIE_10_ID")
	public NomCatCie10 getCie10Id() {
		return cie10Id;
	}

	public void setCie10Id(NomCatCie10 cie10Id) {
		this.cie10Id = cie10Id;
	}


	@Basic @Column(name = "FECHA_REGISTRO", nullable = false)
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@Basic @Column(name = "USUARIO_REGISTRO", nullable = false, length = 50)
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

}
