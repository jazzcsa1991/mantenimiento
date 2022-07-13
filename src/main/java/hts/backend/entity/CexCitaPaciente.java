package hts.backend.entity;

import hts.backend.entity.*;
import hts.backend.entity.AdmAgendaCupos;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cex_cita_paciente")
public class CexCitaPaciente implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer citaPacienteId;
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

	private Interconsulta interconsulta;
	private Integer interconsultaId;
	private Integer admAgendaCupoId;

	private NomCatEstatusCita catEstatusCitaByEstatusCitaId;
	private CatEstatusPago catEstatusPago;
	private AdmAgendaCupos admAgendaCuposByCupoId;

	private Set<PacPeticionArchClinico> pacPeticionesArchClinico = new HashSet<>(0);
	private Set<CexObservaciones> cexObservaciones = new HashSet<>(0);
	private Set<CexMotivoReprogramacion> cexMotivosReprogramacion = new HashSet<>(0);
	private Set<CexNotas> cexNotas = new HashSet<>(0);
	private Set<CexMotivoAnulacion> cexMotivosAnulacion = new HashSet<>(0);


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CITA_PACIENTE_ID")
	public Integer getCitaPacienteId() {
		return citaPacienteId;
	}

	public void setCitaPacienteId(Integer citaPacienteId) {
		this.citaPacienteId = citaPacienteId;
	}


	@ManyToOne @JoinColumn(name = "EVENTO_ID", updatable = false, insertable = false)
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

	@Basic @Column(name = "FECHA_REGISTRO")
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@Basic @Column(name = "USUARIO_REGISTRO")
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}


	@Basic @Column(name = "HORA_LLEGADA")
	public Date getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(Date horaLlegada) {
		this.horaLlegada = horaLlegada;
	}


	@Basic @Column(name = "HORA_ENTRADA")
	public Date getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}


	@Basic @Column(name = "HORA_SALIDA")
	public Date getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}


	@Basic @Column(name = "NO_CITA")
	public String getNoCita() {
		return noCita;
	}

	public void setNoCita(String noCita) {
		this.noCita = noCita;
	}


	@ManyToOne @JoinColumn(name = "ESTATUS_CITA_ID", referencedColumnName = "ESTATUS_CITA_ID")
	public NomCatEstatusCita getCatEstatusCitaByEstatusCitaId() {
		return catEstatusCitaByEstatusCitaId;
	}

	public void setCatEstatusCitaByEstatusCitaId(NomCatEstatusCita catEstatusCitaByEstatusCitaId) {
		this.catEstatusCitaByEstatusCitaId = catEstatusCitaByEstatusCitaId;
	}


	@ManyToOne @JoinColumn(name = "ESTADO_PAGO_ID", referencedColumnName = "ESTATUS_PAGO_ID")
	public CatEstatusPago getCatEstatusPago() {
		return catEstatusPago;
	}

	public void setCatEstatusPago(CatEstatusPago catEstatusPago) {
		this.catEstatusPago = catEstatusPago;
	}


	@ManyToOne @JoinColumn(name = "CUPO_ID", referencedColumnName = "CUPO_ID")
	public AdmAgendaCupos getAdmAgendaCuposByCupoId() {
		return admAgendaCuposByCupoId;
	}

	public void setAdmAgendaCuposByCupoId(AdmAgendaCupos admAgendaCuposByCupoId) {
		this.admAgendaCuposByCupoId = admAgendaCuposByCupoId;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cexCitaPaciente")
	public Set<PacPeticionArchClinico> getPacPeticionesArchClinico() {
		return this.pacPeticionesArchClinico;
	}

	public void setPacPeticionesArchClinico(Set<PacPeticionArchClinico> pacPeticionArchClinicos) {
		this.pacPeticionesArchClinico = pacPeticionArchClinicos;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cexCitaPaciente")
	public Set<CexObservaciones> getCexObservaciones() {
		return this.cexObservaciones;
	}

	public void setCexObservaciones(Set<CexObservaciones> cexObservacioneses) {
		this.cexObservaciones = cexObservacioneses;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cexCitaPaciente")
	public Set<CexMotivoReprogramacion> getCexMotivosReprogramacion() {
		return this.cexMotivosReprogramacion;
	}

	public void setCexMotivosReprogramacion(Set<CexMotivoReprogramacion> cexMotivoReprogramacions) {
		this.cexMotivosReprogramacion = cexMotivoReprogramacions;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cexCitaPaciente")
	public Set<CexNotas> getCexNotas() {
		return this.cexNotas;
	}

	public void setCexNotas(Set<CexNotas> cexNotases) {
		this.cexNotas = cexNotases;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cexCitaPaciente")
	public Set<CexMotivoAnulacion> getCexMotivosAnulacion() {
		return this.cexMotivosAnulacion;
	}

	public void setCexMotivosAnulacion(Set<CexMotivoAnulacion> cexMotivoAnulacions) {
		this.cexMotivosAnulacion = cexMotivoAnulacions;
	}


	@Basic @Column(name = "DERIVACION_FECHA")
	public Date getDerivacionFecha() {
		return derivacionFecha;
	}

	public void setDerivacionFecha(Date derivacionFecha) {
		this.derivacionFecha = derivacionFecha;
	}


	@Basic @Column(name = "DERIVACION_USUARIO")
	public String getDerivacionUsuario() {
		return derivacionUsuario;
	}

	public void setDerivacionUsuario(String derivacionUsuario) {
		this.derivacionUsuario = derivacionUsuario;
	}


	@Basic @Column(name = "TIPO_DERIVACION_ID")
	public Integer getTipoDerivacionId() {
		return tipoDerivacionId;
	}

	public void setTipoDerivacionId(Integer tipoDerivacionId) {
		this.tipoDerivacionId = tipoDerivacionId;
	}


	@ManyToOne @JoinColumn(name = "INTERCONSULTA_ID", insertable = false, updatable = false)
	public Interconsulta getInterconsulta() {
		return interconsulta;
	}

	public void setInterconsulta(Interconsulta interconsulta) {
		this.interconsulta = interconsulta;
	}


	@Column(name = "INTERCONSULTA_ID")
	public Integer getInterconsultaId() {
		return interconsultaId;
	}

	public void setInterconsultaId(Integer peticionClinicaId) {
		this.interconsultaId = peticionClinicaId;
	}

	@Column(name = "ADM_AGENDA_CUPO_ID")
	public Integer getAdmAgendaCupoId() {
		return admAgendaCupoId;
	}

	public void setAdmAgendaCupoId(Integer admAgendaCupoId) {
		this.admAgendaCupoId = admAgendaCupoId;
	}
}
