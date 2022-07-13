package hts.backend.entity;

import hts.backend.entity.*;
import hts.backend.entity.AdmEquipo;
import hts.backend.entity.AdmAgendaCupos;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "core_cita_equipo")
public class CitaEquipo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer citaEquipoId;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Date horaLlegada;
	private Date horaEntrada;
	private Date horaSalida;
	private String noCita;
	private Date derivacionFecha;
	private String derivacionUsuario;
	private Integer tipoDerivacionId;
	private PacEvento pacEvento;
	private Integer eventoId;

	private AdmEquipo admEquipo;
	private Integer equipoId;

	private PeticionesClinicas peticionClinica;
	private Integer peticionClinicaId;

	private NomCatEstatusCita catEstatusCitaByEstatusCitaId;
	private CatEstatusPago catEstatusPago;
	private AdmAgendaCupos admAgendaCuposByCupoId;
	private Integer admAgendaCupoId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CITA_EQUIPO_ID")
	public Integer getCitaEquipoId() {
		return citaEquipoId;
	}

	public void setCitaEquipoId(Integer citaEquipoId) {
		this.citaEquipoId = citaEquipoId;
	}


	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "EVENTO_ID", updatable = false, insertable = false)
	public PacEvento getPacEvento() {
		return pacEvento;
	}

	public void setPacEvento(PacEvento pacEvento) {
		this.pacEvento = pacEvento;
	}


	@Column(name = "EVENTO_ID", nullable = false)
	public Integer getEventoId() {
		return eventoId;
	}

	public void setEventoId(Integer eventoId) {
		this.eventoId = eventoId;
	}

	@Basic
	@Column(name = "FECHA_REGISTRO")
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
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
	@Column(name = "HORA_LLEGADA")
	public Date getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(Date horaLlegada) {
		this.horaLlegada = horaLlegada;
	}


	@Basic
	@Column(name = "HORA_ENTRADA")
	public Date getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}


	@Basic
	@Column(name = "HORA_SALIDA")
	public Date getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}


	@Basic
	@Column(name = "NO_CITA")
	public String getNoCita() {
		return noCita;
	}

	public void setNoCita(String noCita) {
		this.noCita = noCita;
	}


	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "ESTATUS_CITA_ID", referencedColumnName = "ESTATUS_CITA_ID", nullable = false)
	public NomCatEstatusCita getCatEstatusCitaByEstatusCitaId() {
		return catEstatusCitaByEstatusCitaId;
	}

	public void setCatEstatusCitaByEstatusCitaId(NomCatEstatusCita catEstatusCitaByEstatusCitaId) {
		this.catEstatusCitaByEstatusCitaId = catEstatusCitaByEstatusCitaId;
	}


	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "ESTADO_PAGO_ID", referencedColumnName = "ESTATUS_PAGO_ID", nullable = false)
	public CatEstatusPago getCatEstatusPago() {
		return catEstatusPago;
	}

	public void setCatEstatusPago(CatEstatusPago catEstatusPago) {
		this.catEstatusPago = catEstatusPago;
	}


	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "CUPO_ID", referencedColumnName = "CUPO_ID", nullable = false)
	public AdmAgendaCupos getAdmAgendaCuposByCupoId() {
		return admAgendaCuposByCupoId;
	}

	public void setAdmAgendaCuposByCupoId(AdmAgendaCupos admAgendaCuposByCupoId) {
		this.admAgendaCuposByCupoId = admAgendaCuposByCupoId;
	}


	@Basic
	@Column(name = "DERIVACION_FECHA")
	public Date getDerivacionFecha() {
		return derivacionFecha;
	}

	public void setDerivacionFecha(Date derivacionFecha) {
		this.derivacionFecha = derivacionFecha;
	}


	@Basic
	@Column(name = "DERIVACION_USUARIO")
	public String getDerivacionUsuario() {
		return derivacionUsuario;
	}

	public void setDerivacionUsuario(String derivacionUsuario) {
		this.derivacionUsuario = derivacionUsuario;
	}


	@Basic
	@Column(name = "TIPO_DERIVACION_ID")
	public Integer getTipoDerivacionId() {
		return tipoDerivacionId;
	}

	public void setTipoDerivacionId(Integer tipoDerivacionId) {
		this.tipoDerivacionId = tipoDerivacionId;
	}


	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "PETICION_CLINICA_ID", insertable = false, updatable = false)
	public PeticionesClinicas getPeticionClinica() {
		return peticionClinica;
	}

	public void setPeticionClinica(PeticionesClinicas peticionClinica) {
		this.peticionClinica = peticionClinica;
	}


	@Column(name = "PETICION_CLINICA_ID")
	public Integer getPeticionClinicaId() {
		return peticionClinicaId;
	}

	public void setPeticionClinicaId(Integer peticionClinicaId) {
		this.peticionClinicaId = peticionClinicaId;
	}


	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "EQUIPO_ID", insertable = false, updatable = false)
	public AdmEquipo getAdmEquipo() {
		return admEquipo;
	}

	public void setAdmEquipo(AdmEquipo admEquipo) {
		this.admEquipo = admEquipo;
	}


	@Column(name = "EQUIPO_ID", nullable = false)
	public Integer getEquipoId() {
		return equipoId;
	}

	public void setEquipoId(Integer equipoId) {
		this.equipoId = equipoId;
	}

	@Column(name = "ADM_AGENDA_CUPO_ID")
	public Integer getAdmAgendaCupoId() {
		return admAgendaCupoId;
	}

	public void setAdmAgendaCupoId(Integer admAgendaCupoId) {
		this.admAgendaCupoId = admAgendaCupoId;
	}
}
