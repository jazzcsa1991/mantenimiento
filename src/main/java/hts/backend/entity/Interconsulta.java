package hts.backend.entity;


import hts.backend.entity.AdmPersonal;
import hts.backend.entity.CatServEspecialidad;
import hts.backend.entity.CatTipoEvento;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lenovo3 on 16/06/2017.
 */
@Entity
@Table(name = "interconsulta")
public class Interconsulta implements java.io.Serializable {
	private int interconsultaId;
	private CatTipoEvento tipoEventoId;
	private Date fechaSolicitud;
	private Integer urgente;
	private String motivoInterconsulta;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private CatEstatusPeticionClinica catEstatusPeticionClinica;
	private CatTipoPrueba catTipoPrueba;
	private CatServEspecialidad catServEspSolicita;
	private AdmPersonal profSaludEspSolicita;
	private NomCatCie10 nomCatCie10ByCie10Id;
	private CatServEspecialidad catServEspecResp;
	private AdmPersonal profSaludEspResp;
	private String interconsultaFolio;
	private PacEvento eventoId;
	private Date fechaModificacion;
	private String usuarioModificacion;
	private Set<RespuestaInterconsulta> respuestaInterconsulta  = new HashSet<RespuestaInterconsulta>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "interconsultaId")
	public Set<RespuestaInterconsulta> getRespuestaInterconsulta() {
		return respuestaInterconsulta;
	}

	public void setRespuestaInterconsulta(Set<RespuestaInterconsulta> respuestaInterconsulta) {
		this.respuestaInterconsulta = respuestaInterconsulta;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EVENTO_ID")
	public PacEvento getEventoId() {
		return eventoId;
	}

	public void setEventoId(PacEvento eventoId) {
		this.eventoId = eventoId;
	}

	@Basic @Column(name = "INTERCONSULTA_FOLIO", nullable = false, length = 20)
	public String getInterconsultaFolio() {
		return interconsultaFolio;
	}

	public void setInterconsultaFolio(String interconsultaFolio) {
		this.interconsultaFolio = interconsultaFolio;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_EVENTO_ID")
	public CatTipoEvento getTipoEventoId() {
		return tipoEventoId;
	}

	public void setTipoEventoId(CatTipoEvento tipoEventoId) {
		this.tipoEventoId = tipoEventoId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column	(name = "INTERCONSULTA_ID", nullable = false, precision = 0) public int getInterconsultaId() {
		return interconsultaId;
	}

	public void setInterconsultaId(int interconsultaId) {
		this.interconsultaId = interconsultaId;
	}

	@Basic @Column(name = "FECHA_SOLICITUD", nullable = false) public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	@Basic @Column(name = "URGENTE", nullable = true, precision = 0) public Integer getUrgente() {
		return urgente;
	}

	public void setUrgente(Integer urgente) {
		this.urgente = urgente;
	}

	@Basic @Column(name = "MOTIVO_INTERCONSULTA", nullable = false, length = 1000) public String getMotivoInterconsulta() {
		return motivoInterconsulta;
	}

	public void setMotivoInterconsulta(String motivoInterconsulta) {
		this.motivoInterconsulta = motivoInterconsulta;
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


	@ManyToOne
	@JoinColumn(name = "ESTATUS")
	public CatEstatusPeticionClinica getCatEstatusPeticionClinica() {
		return catEstatusPeticionClinica;
	}

	public void setCatEstatusPeticionClinica(CatEstatusPeticionClinica catEstatusPeticionClinica) {
		this.catEstatusPeticionClinica = catEstatusPeticionClinica;
	}







	@ManyToOne
	@JoinColumn(name = "TIPO_PRUEBA_ID", referencedColumnName = "TIPO_PRUEBA_ID", nullable = false)
	public CatTipoPrueba getCatTipoPrueba() {
		return catTipoPrueba;
	}

	public void setCatTipoPrueba(CatTipoPrueba catTipoPrueba) {
		this.catTipoPrueba = catTipoPrueba;
	}




	@ManyToOne
	@JoinColumn(name = "CIE_10_ID", referencedColumnName = "CIE_10_ID", nullable = false)
	public NomCatCie10 getNomCatCie10ByCie10Id() {
		return nomCatCie10ByCie10Id;
	}

	public void setNomCatCie10ByCie10Id(NomCatCie10 nomCatCie10ByCie10Id) {
		this.nomCatCie10ByCie10Id = nomCatCie10ByCie10Id;
	}






	@ManyToOne
	@JoinColumn(name = "SERV_ESP_SOLICITA", referencedColumnName = "SERV_ESPECIALIDAD_ID", nullable = false)public CatServEspecialidad getCatServEspSolicita() {
		return catServEspSolicita;
	}

	public void setCatServEspSolicita(CatServEspecialidad catServEspSolicita) {
		this.catServEspSolicita = catServEspSolicita;
	}


	@ManyToOne
	@JoinColumn(name = "PROF_SALUD_SOLICITA", referencedColumnName = "ADM_PROF_SALUD_GRAL_ID", nullable = false)public AdmPersonal getProfSaludEspSolicita() {
		return profSaludEspSolicita;
	}

	public void setProfSaludEspSolicita(AdmPersonal profSaludEspSolicita) {
		this.profSaludEspSolicita = profSaludEspSolicita;
	}



	@ManyToOne
	@JoinColumn(name = "SERV_ESP_SOLICITADO")
	public CatServEspecialidad getCatServEspecResp() {
		return catServEspecResp;
	}

	public void setCatServEspecResp(CatServEspecialidad catServEspecResp) {
		this.catServEspecResp = catServEspecResp;
	}

	@ManyToOne
	@JoinColumn(name = "PROF_SALUD_SOLICITADO", referencedColumnName = "ADM_PROF_SALUD_GRAL_ID", nullable = false)
	public AdmPersonal getProfSaludEspResp() {
		return profSaludEspResp;
	}

	public void setProfSaludEspResp(AdmPersonal profSaludEspResp) {
		this.profSaludEspResp = profSaludEspResp;
	}
}