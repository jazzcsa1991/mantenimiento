package hts.backend.entity;

import hts.backend.entity.*;
import hts.backend.entity.AdmHospitalesExternos;
import hts.backend.entity.AdmPersonal;
import hts.backend.entity.CatServEspecialidad;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by SASA Desarrollo on 20/06/2017.
 */
@Entity
@Table(name = "core_referencias_externas")
public class CoreReferenciasExternas implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer referenciasExternasId;
	private String tipo;
	private Integer urgente;
	private String motivoDescripcion;
	private String resumenClinico;
	private String observaciones;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private String folio;

	private CatEstatusPeticionClinica catEstatusPeticionClinica;
	private CatServEspecialidad catServEspecialidad;
	private AdmPersonal admPersonal;
	private CatTipoUnidadReferencia catTipoUnidadReferencia;
	private CatTipoTrasladoReferencia catTipoTrasladoReferencia;
	private CatMotivoEnvioReferencia catMotivoEnvioReferencia;
	private NomCatCie10 nomCatCie10;
	private PacEvento pacEvento;
	private AdmHospitalesExternos hospitalesExternos;
	private Date fechaModificacion;
	private String usuarioModificacion;
	private Set<CoreTrasladoAmbulanciaExt> coreTrasladoAmbulanciaExt = new HashSet<CoreTrasladoAmbulanciaExt>(0);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REFERENCIAS_EXTERNAS_ID")
	public Integer getReferenciasExternasId() {
		return referenciasExternasId;
	}

	public void setReferenciasExternasId(Integer referenciasExternasId) {
		this.referenciasExternasId = referenciasExternasId;
	}
	@Basic @Column(name = "TIPO") public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Basic @Column(name = "URGENTE") public Integer getUrgente() {
		return urgente;
	}

	public void setUrgente(Integer urgente) {
		this.urgente = urgente;
	}

	@Basic @Column(name = "MOTIVO_DESCRIPCION") public String getMotivoDescripcion() {
		return motivoDescripcion;
	}

	public void setMotivoDescripcion(String motivoDescripcion) {
		this.motivoDescripcion = motivoDescripcion;
	}

	@Basic @Column(name = "RESUMEN_CLINICO") public String getResumenClinico() {
		return resumenClinico;
	}

	public void setResumenClinico(String resumenClinico) {
		this.resumenClinico = resumenClinico;
	}

	@Basic @Column(name = "OBSERVACIONES") public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Basic @Column(name = "FECHA_REGISTRO") public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO") public String getUsuarioRegistro() {
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



	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ESTATUS_PETICION_CLINICA_ID")
	public CatEstatusPeticionClinica getCatEstatusPeticionClinica() {
		return catEstatusPeticionClinica;
	}

	public void setCatEstatusPeticionClinica(CatEstatusPeticionClinica catEstatusPeticionClinica) {
		this.catEstatusPeticionClinica = catEstatusPeticionClinica;
	}



	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SERV_ESPECIALIDAD_ID")

	public CatServEspecialidad getCatServEspecialidad() {
		return catServEspecialidad;
	}

	public void setCatServEspecialidad(CatServEspecialidad catServEspecialidad) {
		this.catServEspecialidad = catServEspecialidad;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ADM_PROF_SALUD_GRAL_ID")

	public AdmPersonal getAdmPersonal() {
		return admPersonal;
	}

	public void setAdmPersonal(AdmPersonal admPersonal) {
		this.admPersonal = admPersonal;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_UNIDAD_REF_ID")
	public CatTipoUnidadReferencia getCatTipoUnidadReferencia() {
		return catTipoUnidadReferencia;
	}

	public void setCatTipoUnidadReferencia(CatTipoUnidadReferencia catTipoUnidadReferencia) {
		this.catTipoUnidadReferencia = catTipoUnidadReferencia;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_TRASLADO_REFERENCIA_ID")
	public CatTipoTrasladoReferencia getCatTipoTrasladoReferencia() {
		return catTipoTrasladoReferencia;
	}

	public void setCatTipoTrasladoReferencia(CatTipoTrasladoReferencia catTipoTrasladoReferencia) {
		this.catTipoTrasladoReferencia = catTipoTrasladoReferencia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MOTIVO_ENVIO_REFERENCIA_ID")
	public CatMotivoEnvioReferencia getCatMotivoEnvioReferencia() {
		return catMotivoEnvioReferencia;
	}

	public void setCatMotivoEnvioReferencia(CatMotivoEnvioReferencia catMotivoEnvioReferencia) {
		this.catMotivoEnvioReferencia = catMotivoEnvioReferencia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CIE_10_ID")
	public NomCatCie10 getNomCatCie10() {
		return nomCatCie10;
	}

	public void setNomCatCie10(NomCatCie10 nomCatCie10) {
		this.nomCatCie10 = nomCatCie10;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EVENTO_ID")

	public PacEvento getPacEvento() {
		return pacEvento;
	}

	public void setPacEvento(PacEvento pacEvento) {
		this.pacEvento = pacEvento;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HOSPITAL_EXTERNO_ID")
	public AdmHospitalesExternos getHospitalesExternos() {
		return hospitalesExternos;
	}

	public void setHospitalesExternos(AdmHospitalesExternos hospitalesExternos) {
		this.hospitalesExternos = hospitalesExternos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "coreReferenciasExternas")
	public Set<CoreTrasladoAmbulanciaExt> getCoreTrasladoAmbulanciaExt() {
		return coreTrasladoAmbulanciaExt;
	}

	public void setCoreTrasladoAmbulanciaExt(Set<CoreTrasladoAmbulanciaExt> coreTrasladoAmbulanciaExt) {
		this.coreTrasladoAmbulanciaExt = coreTrasladoAmbulanciaExt;
	}

	@Basic @Column(name = "FOLIO")
	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}
}
