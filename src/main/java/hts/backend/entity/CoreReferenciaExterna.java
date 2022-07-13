package hts.backend.entity;

import hts.backend.entity.CatServicioEspecialidadExterno;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "core_referencia_externa")
public class CoreReferenciaExterna  implements Serializable {
	private Integer referenciaExternaId;
	private Integer eventoId;
	private Integer citaPacienteId;
	private Integer hspIngresoId;
	private Integer urgIngresoId;
	private Integer urgIngresoTriageId;
	private Boolean urgente;
	private String diagnostico;
	private Integer cie10Id;
	private Integer tipoUnidadRefId;
	private Integer hospitalExternoId;
	private String cluesId;
	private Integer tipoTrasladoReferenciaId;
	private Integer motivoEnvioReferenciaId;
	private Integer admProfSaludGralId;
	private Integer servEspecialidadId;
	private Integer servEspecialidadExternoId;
	private String medico;
	private String servicio;
	private String motivoDescripcion;
	private String resumenClinico;
	private String observaciones;
	private String signosVitales;
	private String usuarioRegistro;
	private Timestamp fechaRegistro;
	private String usuarioAnulacion;
	private Timestamp fechaAnulacion;
	private String cedula;
	private CatServicioEspecialidadExterno catServicioEspecialidadExterno;
	private Integer tipoConsultaId;
	private Integer tipoEventoId;
	private Integer tipoReferencia;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REFERENCIA_EXTERNA_ID")
	public Integer getReferenciaExternaId() {
		return referenciaExternaId;
	}

	public void setReferenciaExternaId(Integer referenciaExternaId) {
		this.referenciaExternaId = referenciaExternaId;
	}

	@Basic
	@Column(name = "EVENTO_ID")
	public Integer getEventoId() {
		return eventoId;
	}

	public void setEventoId(Integer eventoId) {
		this.eventoId = eventoId;
	}

	@Basic
	@Column(name="TIPO_CONSULTA_ID")
	public  Integer getTipoConsultaId(){return this.tipoConsultaId;}

	public void setTipoConsultaId(Integer tipoConsultaId){
		this.tipoConsultaId = tipoConsultaId;
	}
	@Basic
	@Column(name = "CITA_PACIENTE_ID")
	public Integer getCitaPacienteId() {
		return citaPacienteId;
	}

	public void setCitaPacienteId(Integer citaPacienteId) {
		this.citaPacienteId = citaPacienteId;
	}

	@Basic
	@Column(name = "HSP_INGRESO_ID")
	public Integer getHspIngresoId() {
		return hspIngresoId;
	}

	public void setHspIngresoId(Integer hspIngresoId) {
		this.hspIngresoId = hspIngresoId;
	}

	@Basic
	@Column(name = "URG_INGRESO_ID")
	public Integer getUrgIngresoId() {
		return urgIngresoId;
	}

	public void setUrgIngresoId(Integer urgIngresoId) {
		this.urgIngresoId = urgIngresoId;
	}

	@Basic
	@Column(name = "URG_INGRESO_TRIAGE_ID")
	public Integer getUrgIngresoTriageId() {
		return urgIngresoTriageId;
	}

	public void setUrgIngresoTriageId(Integer urgIngresoTriageId) {
		this.urgIngresoTriageId = urgIngresoTriageId;
	}

	@Basic
	@Column(name = "URGENTE")
	public Boolean getUrgente() {
		return urgente;
	}

	public void setUrgente(Boolean urgente) {
		this.urgente = urgente;
	}

	@Basic
	@Column(name = "DIAGNOSTICO")
	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	@Basic
	@Column(name = "CIE_10_ID")
	public Integer getCie10Id() {
		return cie10Id;
	}

	public void setCie10Id(Integer cie10Id) {
		this.cie10Id = cie10Id;
	}

	@Basic
	@Column(name = "TIPO_UNIDAD_REF_ID")
	public Integer getTipoUnidadRefId() {
		return tipoUnidadRefId;
	}

	public void setTipoUnidadRefId(Integer tipoUnidadRefId) {
		this.tipoUnidadRefId = tipoUnidadRefId;
	}

	@Basic
	@Column(name = "HOSPITAL_EXTERNO_ID")
	public Integer getHospitalExternoId() {
		return hospitalExternoId;
	}

	public void setHospitalExternoId(Integer hospitalExternoId) {
		this.hospitalExternoId = hospitalExternoId;
	}

	@Basic
	@Column(name = "CLUES_ID")
	public String getCluesId() {
		return cluesId;
	}

	public void setCluesId(String cluesId) {
		this.cluesId = cluesId;
	}

	@Basic
	@Column(name = "TIPO_TRASLADO_REFERENCIA_ID")
	public Integer getTipoTrasladoReferenciaId() {
		return tipoTrasladoReferenciaId;
	}

	public void setTipoTrasladoReferenciaId(Integer tipoTrasladoReferenciaId) {
		this.tipoTrasladoReferenciaId = tipoTrasladoReferenciaId;
	}

	@Basic
	@Column(name = "MOTIVO_ENVIO_REFERENCIA_ID")
	public Integer getMotivoEnvioReferenciaId() {
		return motivoEnvioReferenciaId;
	}

	public void setMotivoEnvioReferenciaId(Integer motivoEnvioReferenciaId) {
		this.motivoEnvioReferenciaId = motivoEnvioReferenciaId;
	}

	@Basic
	@Column(name = "ADM_PROF_SALUD_GRAL_ID")
	public Integer getAdmProfSaludGralId() {
		return admProfSaludGralId;
	}

	public void setAdmProfSaludGralId(Integer admProfSaludGralId) {
		this.admProfSaludGralId = admProfSaludGralId;
	}

	@Basic
	@Column(name = "SERV_ESPECIALIDAD_ID")
	public Integer getServEspecialidadId() {
		return servEspecialidadId;
	}

	public void setServEspecialidadId(Integer servEspecialidadId) {
		this.servEspecialidadId = servEspecialidadId;
	}

	@Basic
	@Column(name = "MEDICO")
	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	@Basic
	@Column(name = "SERVICIO")
	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	@Basic
	@Column(name = "MOTIVO_DESCRIPCION")
	public String getMotivoDescripcion() {
		return motivoDescripcion;
	}

	public void setMotivoDescripcion(String motivoDescripcion) {
		this.motivoDescripcion = motivoDescripcion;
	}

	@Basic
	@Column(name = "RESUMEN_CLINICO")
	public String getResumenClinico() {
		return resumenClinico;
	}

	public void setResumenClinico(String resumenClinico) {
		this.resumenClinico = resumenClinico;
	}

	@Basic
	@Column(name = "OBSERVACIONES")
	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Basic
	@Column(name = "SIGNOS_VITALES")
	public String getSignosVitales() {
		return signosVitales;
	}

	public void setSignosVitales(String signosVitales) {
		this.signosVitales = signosVitales;
	}

	@Basic
	@Column(name = "USUARIO_REGISTRO")
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Basic
	@Column(name = "FECHA_REGISTRO")
	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic
	@Column(name = "USUARIO_ANULACION")
	public String getUsuarioAnulacion() {
		return usuarioAnulacion;
	}

	public void setUsuarioAnulacion(String usuarioAnulacion) {
		this.usuarioAnulacion = usuarioAnulacion;
	}

	@Basic
	@Column(name = "FECHA_ANULACION")
	public Timestamp getFechaAnulacion() {
		return fechaAnulacion;
	}

	public void setFechaAnulacion(Timestamp fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
	}

	@Basic
	@Column(name = "CEDULA")
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	@Basic
	@Column(name = "SERVICIO_ESPECIALIDAD_EXTERNO_ID")
	public Integer getServEspecialidadExternoId() {
		return servEspecialidadExternoId;
	}

	public void setServEspecialidadExternoId(Integer servEspecialidadExternoId) {
		this.servEspecialidadExternoId = servEspecialidadExternoId;
	}



	@ManyToOne
	@JoinColumn(name = "SERVICIO_ESPECIALIDAD_EXTERNO_ID", updatable = false, insertable = false)
	public CatServicioEspecialidadExterno getCatServicioEspecialidadExterno() {
		return catServicioEspecialidadExterno;
	}

	public void setCatServicioEspecialidadExterno(CatServicioEspecialidadExterno catServicioEspecialidadExterno) {
		this.catServicioEspecialidadExterno = catServicioEspecialidadExterno;
	}
	@Basic
	@Column(name = "TIPO_EVENTO_ID")
	public Integer getTipoEventoId() {
		return tipoEventoId;
	}

	public void setTipoEventoId(Integer tipoEventoId) {
		this.tipoEventoId = tipoEventoId;
	}

	@Basic
	@Column(name = "TIPO_REFERENCIA")
	public Integer getTipoReferencia() {
		return tipoReferencia;
	}

	public void setTipoReferencia(Integer tipoReferencia) {
		this.tipoReferencia = tipoReferencia;
	}
}
