package hts.backend.entity;

import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pac_evento")
public class PacEvento implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer eventoId;
	private String noEvento;
	private Date fechaApertura;
	private Date fechaCierre;
	private PacEpisodio pacEpisodio;
	private CatTipoEvento catTipoEventoByTipoEventoId;
	private String usuarioRegistro;

	private PacPaciente pacPaciente;
	private Integer pacienteId;

	private Integer servEspecialidadId;

	private Integer camaId;

	private Integer consultorioId;

	private AdmPersonal admPersonal;
	private Integer personalId;

	private Integer equipoId;

	private AdmHospital admHospital;
	private Integer hospitalId;
	private Integer earBqrId;
	private Integer earUrgId;

	public PacEvento() {
		if (SecurityContextHolder.getContext().getAuthentication() != null)
			this.usuarioRegistro = SecurityContextHolder.getContext().getAuthentication().getName();
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EVENTO_ID")
	public Integer getEventoId() {
		return eventoId;
	}

	public void setEventoId(Integer eventoId) {
		this.eventoId = eventoId;
	}

	@Basic
	@Column(name = "NO_EVENTO")
	public String getNoEvento() {
		return noEvento;
	}

	public void setNoEvento(String noEvento) {
		this.noEvento = noEvento;
	}

	@Basic
	@Column(name = "FECHA_APERTURA")
	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	@Basic
	@Column(name = "FECHA_CIERRE")
	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EPISODIO_ID", referencedColumnName = "EPISODIO_ID", nullable = false)
	public PacEpisodio getPacEpisodio() {
		return pacEpisodio;
	}

	public void setPacEpisodio(PacEpisodio pacEpisodio) {
		this.pacEpisodio = pacEpisodio;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_EVENTO_ID", referencedColumnName = "TIPO_EVENTO_ID", nullable = false)
	public CatTipoEvento getCatTipoEventoByTipoEventoId() {
		return catTipoEventoByTipoEventoId;
	}

	public void setCatTipoEventoByTipoEventoId(CatTipoEvento catTipoEventoByTipoEventoId) {
		this.catTipoEventoByTipoEventoId = catTipoEventoByTipoEventoId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PACIENTE", referencedColumnName = "ID_PACIENTE", nullable = false)
	public PacPaciente getPacPaciente() {
		return pacPaciente;
	}

	public void setPacPaciente(PacPaciente pacPaciente) {
		this.pacPaciente = pacPaciente;
	}


	@Column(name = "SERV_ESPECIALIDAD_ID")
	public Integer getServEspecialidadId() {
		return servEspecialidadId;
	}

	public void setServEspecialidadId(Integer servEspecialidadId) {
		this.servEspecialidadId = servEspecialidadId;
	}


	@Column(name = "UBICACION_CAMA_ID")
	public Integer getCamaId() {
		return camaId;
	}

	public void setCamaId(Integer ubicacionCamaId) {
		this.camaId = ubicacionCamaId;
	}


	@Column(name = "UBICACION_CONSULTORIO_ID")
	public Integer getConsultorioId() {
		return consultorioId;
	}

	public void setConsultorioId(Integer ubicacionConsultorioId) {
		this.consultorioId = ubicacionConsultorioId;
	}


	@Column(name = "PERSONAL_ID")
	public Integer getPersonalId() {
		return personalId;
	}

	public void setPersonalId(Integer personalId) {
		this.personalId = personalId;
	}


	@ManyToOne
	@JoinColumn(name = "PERSONAL_ID", updatable = false, insertable = false)
	public AdmPersonal getAdmPersonal() {
		return admPersonal;
	}

	public void setAdmPersonal(AdmPersonal admPersonal) {
		this.admPersonal = admPersonal;
	}


	@Column(name = "EQUIPO_ID")
	public Integer getEquipoId() {
		return equipoId;
	}

	public void setEquipoId(Integer equipoId) {
		this.equipoId = equipoId;
	}


	@Column(name = "HOSPITAL_ID", nullable = false)
	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}


	@ManyToOne
	@JoinColumn(name = "HOSPITAL_ID", updatable = false, insertable = false)
	public AdmHospital getAdmHospital() {
		return admHospital;
	}

	public void setAdmHospital(AdmHospital admHospital) {
		this.admHospital = admHospital;
	}


	@Column(name = "ID_PACIENTE", insertable = false, updatable = false)
	public Integer getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Integer pacienteId) {
		this.pacienteId = pacienteId;
	}


	@Column(name = "UBICACION_EAR_BQR_ID")
	public Integer getEarBqrId() {
		return earBqrId;
	}

	public void setEarBqrId(Integer earBqrId) {
		this.earBqrId = earBqrId;
	}


	@Column(name = "UBICACION_EAR_URG_ID")
	public Integer getEarUrgId() {
		return earUrgId;
	}

	public void setEarUrgId(Integer earUrgId) {
		this.earUrgId = earUrgId;
	}


	@Column(name = "USUARIO_REGISTRO")
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}




}
