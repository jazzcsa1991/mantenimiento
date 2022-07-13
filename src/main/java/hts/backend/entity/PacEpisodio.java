package hts.backend.entity;

import hts.backend.entity.*;
import hts.backend.entity.AdmHospital;
import hts.backend.entity.PacPaciente;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "pac_episodio")
public class PacEpisodio implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer episodioId;
	private String noEpisodio;
	private Date fechaApertura;
	private Date fechaCierre;
	private Date fechaRegistro;
	private String usuarioRegistro;

	private PacPaciente paciente;
	private Integer pacienteId;

	private CatTipoEpisodio tipoEpisodio;
	private Integer tipoEpisodioId;

	private AdmHospital admHospital;
	private Integer hospitalId;

	private PacDiagnosticoEvento pacDiagnosticoEvento;

	private Set<PacProcedimientoEpisodio> pacProcedimientoEpisodiosByEpisodioId;
	private Set<PacEvento> pacEventos;



	public PacEpisodio() {
	}

	// Constructor para inserciones
	public PacEpisodio(String noEpisodio, Integer pacienteId, Integer tipoEpisodioId, Integer hospitalId) {
		this.noEpisodio = noEpisodio;
		this.pacienteId = pacienteId;
		this.tipoEpisodioId = tipoEpisodioId;
		this.hospitalId = hospitalId;

		this.fechaApertura = new Date();
		this.fechaRegistro = this.fechaApertura;
		this.usuarioRegistro = SecurityContextHolder.getContext().getAuthentication().getName();
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EPISODIO_ID")
	public Integer getEpisodioId() {
		return episodioId;
	}

	public void setEpisodioId(Integer episodioId) {
		this.episodioId = episodioId;
	}

	@Basic
	@Column(name = "NO_EPISODIO")
	public String getNoEpisodio() {
		return noEpisodio;
	}

	public void setNoEpisodio(String noEpisodio) {
		this.noEpisodio = noEpisodio;
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


	@Column(name = "FECHA_REGISTRO", nullable = false)
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@Column(name = "USUARIO_REGISTRO", nullable = false)
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}


	@Column(name = "TIPO_EPISODIO_ID", nullable = false)
	public Integer getTipoEpisodioId() {
		return tipoEpisodioId;
	}

	public void setTipoEpisodioId(Integer tipoEpisodioId) {
		this.tipoEpisodioId = tipoEpisodioId;
	}


	@ManyToOne
	@JoinColumn(name = "TIPO_EPISODIO_ID", referencedColumnName = "TIPO_EPISODIO_ID", insertable = false, updatable = false)
	public CatTipoEpisodio getTipoEpisodio() {
		return tipoEpisodio;
	}

	public void setTipoEpisodio(CatTipoEpisodio tipoEpisodio) {
		this.tipoEpisodio = tipoEpisodio;
	}


	@OneToMany(mappedBy = "pacEpisodioByEpisodioId")
	public Set<PacProcedimientoEpisodio> getPacProcedimientoEpisodiosByEpisodioId() {
		return pacProcedimientoEpisodiosByEpisodioId;
	}

	public void setPacProcedimientoEpisodiosByEpisodioId(Set<PacProcedimientoEpisodio> pacProcedimientoEpisodiosByEpisodioId) {
		this.pacProcedimientoEpisodiosByEpisodioId = pacProcedimientoEpisodiosByEpisodioId;
	}


	@OneToMany(mappedBy = "pacEpisodio")
	public Set<PacEvento> getPacEventos() {
		return pacEventos;
	}

	public void setPacEventos(Set<PacEvento> pacEventos) {
		this.pacEventos = pacEventos;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DIAGNOSTICO_EVENTO_ID")
	public PacDiagnosticoEvento getPacDiagnosticoEvento() {
		return pacDiagnosticoEvento;
	}

	public void setPacDiagnosticoEvento(PacDiagnosticoEvento pacDiagnosticoEvento) {
		this.pacDiagnosticoEvento = pacDiagnosticoEvento;
	}


	@Column(name = "HOSPITAL_ID", nullable = false)
	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HOSPITAL_ID", referencedColumnName = "HOSPITAL_ID", updatable = false, insertable = false)
	public AdmHospital getAdmHospital() {
		return admHospital;
	}

	public void setAdmHospital(AdmHospital admHospital) {
		this.admHospital = admHospital;
	}

	@ManyToOne
	@JoinColumn(name = "PACIENTE_ID", referencedColumnName = "ID_PACIENTE", updatable = false, insertable = false)
	public PacPaciente getPaciente() {
		return paciente;
	}

	public void setPaciente(PacPaciente paciente) {
		this.paciente = paciente;
	}


	@Column(name = "PACIENTE_ID", nullable = false)
	public Integer getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Integer pacienteId) {
		this.pacienteId = pacienteId;
	}
}
