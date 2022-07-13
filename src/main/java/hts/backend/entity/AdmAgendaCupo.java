package hts.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "adm_agenda_cupo")
public class AdmAgendaCupo implements Serializable {
	private Integer admAgendaCupoId;
	private Integer admAgendaId;
	private Integer admAgendaBitacoraId;
	private Timestamp fechaInicio;
	private Timestamp fechaFin;
	private Integer turno;
	private Boolean cupoExtra;
	private Timestamp fechaRegistro;
	private String usuarioRegistro;
	private Integer consultorioId;
	private Integer personalId;
	private Integer tipoConsultaId;
	private Timestamp fechaConfirmacionAsistencia;
	private String usuarioConfirmacionAsistencia;
	private Timestamp fechaEliminacion;
	private String usuarioEliminacion;
	private Integer servicioEspecialidadId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADM_AGENDA_CUPO_ID")
	public Integer getAdmAgendaCupoId() {
		return admAgendaCupoId;
	}

	public void setAdmAgendaCupoId(Integer admAgendaCupoId) {
		this.admAgendaCupoId = admAgendaCupoId;
	}

	@Basic
	@Column(name = "ADM_AGENDA_ID")
	public Integer getAdmAgendaId() {
		return admAgendaId;
	}

	public void setAdmAgendaId(Integer admAgendaId) {
		this.admAgendaId = admAgendaId;
	}

	@Basic
	@Column(name = "ADM_AGENDA_BITACORA_ID")
	public Integer getAdmAgendaBitacoraId() {
		return admAgendaBitacoraId;
	}

	public void setAdmAgendaBitacoraId(Integer admAgendaBitacoraId) {
		this.admAgendaBitacoraId = admAgendaBitacoraId;
	}

	@Basic
	@Column(name = "FECHA_INICIO")
	public Timestamp getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Basic
	@Column(name = "FECHA_FIN")
	public Timestamp getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Basic
	@Column(name = "TURNO")
	public Integer getTurno() {
		return turno;
	}

	public void setTurno(Integer turno) {
		this.turno = turno;
	}

	@Basic
	@Column(name = "CUPO_EXTRA")
	public Boolean getCupoExtra() {
		return cupoExtra;
	}

	public void setCupoExtra(Boolean cupoExtra) {
		this.cupoExtra = cupoExtra;
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
	@Column(name = "USUARIO_REGISTRO")
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}


	@Basic
	@Column(name = "CONSULTORIO_ID")
	public Integer getConsultorioId() {
		return consultorioId;
	}

	public void setConsultorioId(Integer consultorioId) {
		this.consultorioId = consultorioId;
	}

	@Basic
	@Column(name = "FECHA_CONFIRMACION_ASISTENCIA")
	public Timestamp getFechaConfirmacionAsistencia() {
		return fechaConfirmacionAsistencia;
	}

	public void setFechaConfirmacionAsistencia(Timestamp fechaConfirmacionAsistencia) {
		this.fechaConfirmacionAsistencia = fechaConfirmacionAsistencia;
	}

	@Basic
	@Column(name = "USUARIO_CONFIRMACION_ASISTENCIA")
	public String getUsuarioConfirmacionAsistencia() {
		return usuarioConfirmacionAsistencia;
	}

	public void setUsuarioConfirmacionAsistencia(String usuarioConfirmacionAsistencia) {
		this.usuarioConfirmacionAsistencia = usuarioConfirmacionAsistencia;
	}

	@Basic
	@Column(name = "PERSONAL_ID")
	public Integer getPersonalId() {
		return personalId;
	}

	public void setPersonalId(Integer personalId) {
		this.personalId = personalId;
	}


	@Basic
	@Column(name = "TIPO_CONSULTA_ID")
	public Integer getTipoConsultaId() {
		return tipoConsultaId;
	}

	public void setTipoConsultaId(Integer tipoConsultaId) {
		this.tipoConsultaId = tipoConsultaId;
	}


	@Basic
	@Column(name = "SERVICIO_ESPECIALIDAD_ID")
	public Integer getServicioEspecialidadId() {
		return servicioEspecialidadId;
	}

	public void setServicioEspecialidadId(Integer servicioEspecialidadId) {
		this.servicioEspecialidadId = servicioEspecialidadId;
	}

	@Basic
	@Column(name = "FECHA_ELIMINACION")
	public Timestamp getFechaEliminacion() {
		return fechaEliminacion;
	}

	public void setFechaEliminacion(Timestamp fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}

	@Basic
	@Column(name = "USUARIO_ELIMINACION")
	public String getUsuarioEliminacion() {
		return usuarioEliminacion;
	}

	public void setUsuarioEliminacion(String usuarioEliminacion) {
		this.usuarioEliminacion = usuarioEliminacion;
	}
}
