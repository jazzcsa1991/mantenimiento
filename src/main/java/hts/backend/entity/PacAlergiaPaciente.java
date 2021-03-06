package hts.backend.entity;
// Generated 15/05/2017 04:24:20 PM by Hibernate Tools 5.2.1.Final

import hts.backend.entity.CatAlergia;
import hts.backend.entity.PacPaciente;

import java.util.Date;
import javax.persistence.*;

/**
 * PacAlergiaPaciente generated by hbm2java
 */
@Entity
@Table(name = "pac_alergia_paciente")
public class PacAlergiaPaciente implements java.io.Serializable {

	private Integer alergiaPacienteId;
	private PacPaciente pacPaciente;
	private CatAlergia catAlergia;
	private Date fechaInicial;
	private Date fechaFinal;
	private String observaciones;
	private Date fechaRegistro;
	private String usaurioRegistro;

	public PacAlergiaPaciente() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ALERGIA_PACIENTE_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getAlergiaPacienteId() {
		return this.alergiaPacienteId;
	}

	public void setAlergiaPacienteId(Integer alergiaPacienteId) {
		this.alergiaPacienteId = alergiaPacienteId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PACIENTE", nullable = false)
	public PacPaciente getPacPaciente() {
		return this.pacPaciente;
	}

	public void setPacPaciente(PacPaciente pacPaciente) {
		this.pacPaciente = pacPaciente;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ALERGIA_ID", nullable = false)
	public CatAlergia getCatAlergia() {
		return this.catAlergia;
	}

	public void setCatAlergia(CatAlergia catAlergia) {
		this.catAlergia = catAlergia;
	}

	@Column(name = "FECHA_INICIAL", nullable = false, length = 7)
	public Date getFechaInicial() {
		return this.fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	@Column(name = "FECHA_FINAL", nullable = false, length = 7)
	public Date getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	@Column(name = "OBSERVACIONES", nullable = false, length = 250)
	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", nullable = false, length = 7)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Column(name = "USUARIO_REGISTRO", nullable = false, length = 20)
	public String getUsaurioRegistro() {
		return this.usaurioRegistro;
	}

	public void setUsaurioRegistro(String usaurioRegistro) {
		this.usaurioRegistro = usaurioRegistro;
	}

}
