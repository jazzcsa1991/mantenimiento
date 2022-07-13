package hts.backend.entity;

import hts.backend.entity.PacAseguradora;
import hts.backend.entity.PacPaciente;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by SASA Desarrollo on 03/07/2017.
 */
@Entity
@Table(name = "trs_nse_unica_ocasion")
public class TrsNseUnicaOcasion implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer nseUnicaOcasionId;
	private String concepto;
	private String motivo;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private TrsEstatusNse estatusAsignacion;
	private PacConvenioAseguradora pacConvenioAseguradora;
	private PacPaciente pacPaciente;
	private PacAseguradora pacAseguradora;
	private String folioUnicaOcasion;
	private Set<TrsAnulacionNse> trsAnulacionNses =new HashSet<TrsAnulacionNse>(0);
	private PacPacienteArchivo pacPacienteArchivo;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NSE_UNICA_OCASION_ID") public Integer getNseUnicaOcasionId() {
		return nseUnicaOcasionId;
	}

	public void setNseUnicaOcasionId(Integer nseUnicaOcasionId) {
		this.nseUnicaOcasionId = nseUnicaOcasionId;
	}

	@Basic @Column(name = "CONCEPTO") public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	@Basic @Column(name = "MOTIVO") public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	@Basic @Column(name = "FECHA_INICIO") public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Basic @Column(name = "FECHA_FIN") public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
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



	@Basic @Column(name = "FOLIO_UNICA_OCASION") public String getFolioUnicaOcasion() {
		return folioUnicaOcasion;
	}

	public void setFolioUnicaOcasion(String folioUnicaOcasion) {
		this.folioUnicaOcasion = folioUnicaOcasion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CONVENIO_ASEGURADORA_ID", nullable = false)

	public PacConvenioAseguradora getPacConvenioAseguradora() {
		return pacConvenioAseguradora;
	}

	public void setPacConvenioAseguradora(PacConvenioAseguradora pacConvenioAseguradora) {
		this.pacConvenioAseguradora = pacConvenioAseguradora;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PACIENTE_ID", nullable = false)
	public PacPaciente getPacPaciente() {
		return pacPaciente;
	}

	public void setPacPaciente(PacPaciente pacPaciente) {
		this.pacPaciente = pacPaciente;
	}



	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ESTATUS_ASIGNACION")
	public TrsEstatusNse getEstatusAsignacion() {
		return estatusAsignacion;
	}

	public void setEstatusAsignacion(TrsEstatusNse estatusAsignacion) {
		this.estatusAsignacion = estatusAsignacion;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trsNseUnicaOcasion")
	public Set<TrsAnulacionNse> getTrsAnulacionNses() {
		return trsAnulacionNses;
	}

	public void setTrsAnulacionNses(Set<TrsAnulacionNse> trsAnulacionNses) {
		this.trsAnulacionNses = trsAnulacionNses;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAC_ASEGURADORA_ID", nullable = false)
	public PacAseguradora getPacAseguradora() {
		return pacAseguradora;
	}

	public void setPacAseguradora(PacAseguradora pacAseguradora) {
		this.pacAseguradora = pacAseguradora;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PACIENTE_ARCHIVO_ID", nullable = false)
	public PacPacienteArchivo getPacPacienteArchivo() {
		return pacPacienteArchivo;
	}

	public void setPacPacienteArchivo(PacPacienteArchivo pacPacienteArchivo) {
		this.pacPacienteArchivo = pacPacienteArchivo;
	}
}
