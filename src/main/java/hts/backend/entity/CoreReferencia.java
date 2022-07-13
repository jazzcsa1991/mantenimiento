package hts.backend.entity;

import hts.backend.entity.*;


import javax.persistence.*;
import java.io.Serializable;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SASA Desarrollo on 15/06/2017.
 */
@Entity
@Table(name = "core_referencia")
public class CoreReferencia implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer referenciaId;
	private Integer urgente;
	private String direccion;
	private String motivoDescripcion;
	private String resumenClinico;
	private String observaciones;
	private Date   fechaRegistro;
	private String usuarioRegistro;
	private String nombreHospitalExterno;
	private String telefonoHospitalExterno;
	private String servicioEspecialidadExterna;

	private CatEstatusPeticion catEstatusPeticion;
	private CatServEspecialidad catServEspecialidad;
	private AdmPersonal admPersonal;
	private CatTipoUnidadReferencia catTipoUnidadReferencia;
	private CatTipoTrasladoReferencia catTipoTrasladoReferencia;
	private CatMotivoEnvioReferencia catMotivoEnvioReferencia;
	private NomCatCie10 nomCatCie10;
	private PacEvento pacEvento;


	private Set<CoreContrarreferencia> coreContrarreferencias = new HashSet<CoreContrarreferencia>(0);

	private Set<CoreTrasladoAmbulancia> coreTrasladoAmbulancias = new HashSet<CoreTrasladoAmbulancia>(0);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REFERENCIA_ID") public Integer getReferenciaId() {
		return referenciaId;
	}

	public void setReferenciaId(Integer referenciaId) {
		this.referenciaId = referenciaId;
	}

	@Basic @Column(name = "URGENTE") public Integer getUrgente() {
		return urgente;
	}

	public void setUrgente(Integer urgente) {
		this.urgente = urgente;
	}

	@Basic @Column(name = "DIRECCION") public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	@Basic @Column(name = "NOMBRE_HOSPITAL_EXTERNO")
	public String getNombreHospitalExterno() {
		return nombreHospitalExterno;
	}

	public void setNombreHospitalExterno(String nombreHospitalExterno) {
		this.nombreHospitalExterno = nombreHospitalExterno;
	}

	@Basic @Column(name = "TELEFONO_HOSPITAL_EXTERNO")
	public String getTelefonoHospitalExterno() {
		return telefonoHospitalExterno;
	}

	public void setTelefonoHospitalExterno(String telefonoHospitalExterno) {
		this.telefonoHospitalExterno = telefonoHospitalExterno;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ESTATUS_PETICION_ID")

	public CatEstatusPeticion getCatEstatusPeticion() {
		return catEstatusPeticion;
	}

	public void setCatEstatusPeticion(CatEstatusPeticion catEstatusPeticion) {
		this.catEstatusPeticion = catEstatusPeticion;
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

	@OneToMany(mappedBy = "coreReferencia")

	public Set<CoreContrarreferencia> getCoreContrarreferencias() {
		return coreContrarreferencias;
	}

	public void setCoreContrarreferencias(Set<CoreContrarreferencia> coreContrarreferencias) {
		this.coreContrarreferencias = coreContrarreferencias;
	}

	@OneToMany(mappedBy = "coreReferencia")
	public Set<CoreTrasladoAmbulancia> getCoreTrasladoAmbulancias() {
		return coreTrasladoAmbulancias;
	}

	public void setCoreTrasladoAmbulancias(Set<CoreTrasladoAmbulancia> coreTrasladoAmbulancias) {
		this.coreTrasladoAmbulancias = coreTrasladoAmbulancias;
	}
	@Basic @Column(name = "SERVICIO_ESPECIALIDAD_EXTERNO")
	public String getServicioEspecialidadExterna() {
		return servicioEspecialidadExterna;
	}

	public void setServicioEspecialidadExterna(String servicioEspecialidadExterna) {
		this.servicioEspecialidadExterna = servicioEspecialidadExterna;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EVENTO_ID")

	public PacEvento getPacEvento() {
		return pacEvento;
	}

	public void setPacEvento(PacEvento pacEvento) {
		this.pacEvento = pacEvento;
	}
}
