package hts.backend.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import hts.backend.entity.PacActuacion;
import hts.backend.entity.PacPeticionArchClinico;
import hts.backend.entity.AdmAgendaDetalle;

@Entity
@Table(name = "adm_consultorio")
public class AdmConsultorio implements java.io.Serializable {
	private static final long serialVersionUID = 8667227486172235201L;

	private Integer consultorioId;
	private AdmCentroCosto catCentroCosto;
	private AdmSala admSala;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer status;
	private Date fechaRegistro;
	private String usuarioCve;
	private Boolean estatusOcupado;

	private Set<AdmAgendaDetalle> admAgendaDetalles = new HashSet<>(0);
	private Set<PacActuacion> pacActuacionsByConsultorioId = new HashSet<>(0);
	//	private Set<CexCitaPaciente> cexCitaPacientesByConsultorioId= new HashSet<>(0);
	private Set<PacPeticionArchClinico> pacPeticionArchClinicos = new HashSet<>(0);

	public AdmConsultorio() {
	}

	public AdmConsultorio(Integer consultorioId) {
		this.consultorioId = consultorioId;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONSULTORIO_ID", unique = true, nullable = false)
	public Integer getConsultorioId() {
		return this.consultorioId;
	}

	public void setConsultorioId(Integer consultorioId) {
		this.consultorioId = consultorioId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CENTRO_COSTO_ID")
	public AdmCentroCosto getCatCentroCosto() {
		return this.catCentroCosto;
	}

	public void setCatCentroCosto(AdmCentroCosto catCentroCosto) {
		this.catCentroCosto = catCentroCosto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SALA_ID", nullable = false)
	public AdmSala getAdmSala() {
		return this.admSala;
	}

	public void setAdmSala(AdmSala admSala) {
		this.admSala = admSala;
	}


	@Column(name = "CVE", nullable = false, length = 15)
	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}


	@Column(name = "NOMBRE", nullable = false, length = 20)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Column(name = "DESCRIPCION", length = 40)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Column(name = "ESTATUS", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
	public String getUsuarioCve() {
		return this.usuarioCve;
	}

	public void setUsuarioCve(String usuarioCve) {
		this.usuarioCve = usuarioCve;
	}

	@Column(name = "ESTATUS_OCUPADO", nullable = false)
	public Boolean getEstatusOcupado() {
		return estatusOcupado;
	}

	public void setEstatusOcupado(Boolean estatusOcupado) {
		this.estatusOcupado = estatusOcupado;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "admConsultorio")
	public Set<AdmAgendaDetalle> getAdmAgendaDetalles() {
		return this.admAgendaDetalles;
	}

	public void setAdmAgendaDetalles(Set<AdmAgendaDetalle> admAgendaDetalles) {
		this.admAgendaDetalles = admAgendaDetalles;
	}

	@OneToMany(mappedBy = "admConsultorioByConsultorioId")
	public Set<PacActuacion> getPacActuacionsByConsultorioId() {
		return pacActuacionsByConsultorioId;
	}

	public void setPacActuacionsByConsultorioId(Set<PacActuacion> pacActuacionsByConsultorioId) {
		this.pacActuacionsByConsultorioId = pacActuacionsByConsultorioId;
	}

	/*@OneToMany(mappedBy = "admConsultorioByConsultorioId")
	public Set<CexCitaPaciente> getCexCitaPacientesByConsultorioId() {
		return cexCitaPacientesByConsultorioId;
	}

	public void setCexCitaPacientesByConsultorioId(Set<CexCitaPaciente> cexCitaPacientesByConsultorioId) {
		this.cexCitaPacientesByConsultorioId = cexCitaPacientesByConsultorioId;
	}*/

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "admConsultorio")
	public Set<PacPeticionArchClinico> getPacPeticionArchClinicos() {
		return this.pacPeticionArchClinicos;
	}

	public void setPacPeticionArchClinicos(Set<PacPeticionArchClinico> pacPeticionArchClinicos) {
		this.pacPeticionArchClinicos = pacPeticionArchClinicos;
	}
}
