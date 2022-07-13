package hts.backend.entity;


import hts.backend.entity.CexCitaPaciente;
import hts.backend.entity.CitaEquipo;
import hts.backend.entity.*;

import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name = "pac_peticion_arch_clinico")
public class PacPeticionArchClinico implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer peticionArchClinicoId;
	private CatMotivoPeticionExp catMotivoPeticionExp;
	private AdmConsultorio admConsultorio;
	private CatDestinoPrestamoExp catDestinoPrestamoExp;
	private CatEstatusPeticion catEstatusPeticion;
	private CatTipoAgente catTipoAgente;
	private CatServEspecialidad catServEspecialidad;
	private CexCitaPaciente cexCitaPaciente;
	private CitaEquipo citaEquipo;
	private Integer agenteId;
	//private Date fechaCita;
	private String observaciones;
	private Date fechaRegistro;
	private String usuarioRegistro;
	//private String noCita;
	//private String noExpediente;
	private Date fechaPrevista;
	private Date fechaFin;
	private Integer dias;
	private Integer tipoMovimiento;
	private PacPaciente pacPaciente;
	private String usuarioModificacion;
	private Date fechaModificacion;

	public PacPeticionArchClinico() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PETICION_ARCH_CLINICO_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getPeticionArchClinicoId() {
		return this.peticionArchClinicoId;
	}

	public void setPeticionArchClinicoId(Integer peticionArchClinicoId) {
		this.peticionArchClinicoId = peticionArchClinicoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MOTIVO_PETICION_ID", nullable = false)
	public CatMotivoPeticionExp getCatMotivoPeticionExp() {
		return this.catMotivoPeticionExp;
	}

	public void setCatMotivoPeticionExp(CatMotivoPeticionExp catMotivoPeticionExp) {
		this.catMotivoPeticionExp = catMotivoPeticionExp;
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
	@JoinColumn(name = "DESTINO_PRESTAMO_ID", nullable = false)
	public CatDestinoPrestamoExp getCatDestinoPrestamoExp() {
		return this.catDestinoPrestamoExp;
	}

	public void setCatDestinoPrestamoExp(CatDestinoPrestamoExp catDestinoPrestamoExp) {
		this.catDestinoPrestamoExp = catDestinoPrestamoExp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ESTATUS_PETICION_ID", nullable = false)
	public CatEstatusPeticion getCatEstatusPeticion() {
		return this.catEstatusPeticion;
	}

	public void setCatEstatusPeticion(CatEstatusPeticion catEstatusPeticion) {
		this.catEstatusPeticion = catEstatusPeticion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_AGENTE_ID", nullable = false)
	public CatTipoAgente getCatTipoAgente() {
		return this.catTipoAgente;
	}

	public void setCatTipoAgente(CatTipoAgente catTipoAgente) {
		this.catTipoAgente = catTipoAgente;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SERV_ESPECIALIDAD_ID", nullable = false)
	public CatServEspecialidad getCatServEspecialidad() {
		return this.catServEspecialidad;
	}

	public void setCatServEspecialidad(CatServEspecialidad catServEspecialidad) {
		this.catServEspecialidad = catServEspecialidad;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CITA_PACIENTE_ID")
	public CexCitaPaciente getCexCitaPaciente() {
		return this.cexCitaPaciente;
	}

	public void setCexCitaPaciente(CexCitaPaciente cexCitaPaciente) {
		this.cexCitaPaciente = cexCitaPaciente;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CITA_EQUIPO_ID")
	public CitaEquipo getCitaEquipo() {
		return this.citaEquipo;
	}

	public void setCitaEquipo(CitaEquipo citaEquipo) {
		this.citaEquipo = citaEquipo;
	}

	@Column(name = "AGENTE_ID", precision = 22, scale = 0)
	public Integer getAgenteId() {
		return this.agenteId;
	}

	public void setAgenteId(Integer agenteId) {
		this.agenteId = agenteId;
	}

	/*@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_CITA", nullable = false, length = 7)
	public Date getFechaCita() {
		return this.fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}*/

	@Column(name = "OBSERVACIONES", length = 500)
	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_REGISTRO", nullable = false, length = 7)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Column(name = "USUARIO_REGISTRO", nullable = false, length = 50)
	public String getUsuarioRegistro() {
		return this.usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	/*@Column(name = "NO_CITA", nullable = false, length = 20)
	public String getNoCita() {
		return this.noCita;
	}

	public void setNoCita(String noCita) {
		this.noCita = noCita;
	}

	@Column(name = "NO_EXPEDIENTE", nullable = false, length = 20)
	public String getNoExpediente() {
		return this.noExpediente;
	}

	public void setNoExpediente(String noExpediente) {
		this.noExpediente = noExpediente;
	}*/

	@Basic @Column(name = "FECHA_PREVISTA") public Date getFechaPrevista() {
		return fechaPrevista;
	}

	public void setFechaPrevista(Date fechaPrevista) {
		this.fechaPrevista = fechaPrevista;
	}

	@Basic @Column(name = "FECHA_FIN") public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Basic @Column(name = "DIAS") public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	@Basic @Column(name = "TIPO_MOVIMIENTO")

	public Integer getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(Integer tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PACIENTE")
	public PacPaciente getPacPaciente() {
		return pacPaciente;
	}

	public void setPacPaciente(PacPaciente pacPaciente) {
		this.pacPaciente = pacPaciente;
	}


	@Column(name = "USUARIO_MODIFICACION")
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}
	@Column(name = "FECHA_MODIFICACION")
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
}
