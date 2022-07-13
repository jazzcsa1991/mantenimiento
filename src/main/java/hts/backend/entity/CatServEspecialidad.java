package hts.backend.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import hts.backend.entity.CoreReferencia;
import hts.backend.entity.CoreReferenciasExternas;
import hts.backend.entity.*;
import hts.backend.entity.AdmAgendaDetalle;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "adm_cat_serv_especialidad")
public class CatServEspecialidad implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer servEspecialidadId;
	@JsonIgnore
	private CatServBasico catServBasico;
	@JsonIgnore
	private CatTipoEvento catTipoEvento;
	private String clave;
	private String nombre;
	private String descripcion;
	private Integer indicaDefault;
	private Integer status;
	private Date fechaRegistro;
	private String usuarioCve;
	@JsonIgnore
	private Set<AdmPersonalEspecialidades> admPersonalEspecialidadese = new HashSet<>(0);
	@JsonIgnore
	private Set<AdmPersonalCedula> admPersonalCedulas = new HashSet<>(0);
	@JsonIgnore
	private Set<AdmAgendaDetalle> admAgendaDetalles = new HashSet<>(0);
	@JsonIgnore
	private Set<AdmEquipoSerEspecialidad> admEquipoSerEspecialidads = new HashSet<>(0);
	@JsonIgnore
	private Set<PermisosCitas> permisosCitasesForServEspecialidadId2 = new HashSet<>(0);
	@JsonIgnore
	private Set<PermisosCitas> permisosCitasesForServEspecialidadId = new HashSet<>(0);
	@JsonIgnore
	private Set<PrestacionTipoServesp> prestacionTipoServesps = new HashSet<>(0);
	@JsonIgnore
	private Set<PacActuacion> pacActuacionsByServEspecialidadId = new HashSet<>(0);
	@JsonIgnore
	private Set<PacPeticionArchClinico> pacPeticionArchClinicos = new HashSet<>(0);
	@JsonIgnore
	private Set<PeticionesClinicas> peticionesClinicasByServEspecialidadId_0;
	@JsonIgnore
	private Set<PacExpediente> pacExpediente1 = new HashSet<>(0);
	@JsonIgnore
	private Set<PacExpediente> pacExpediente2 = new HashSet<>(0);
	@JsonIgnore
	private Set<CoreReferencia> coreReferencias = new HashSet<>(0);
	@JsonIgnore
	private Set<CoreReferenciasExternas> coreReferenciasExternas = new HashSet<>(0);
	@JsonIgnore
	private Set<HspAltaMedica> hspAltaMedicasByServEspecialidadId = new HashSet<>(0);

	@OneToMany(mappedBy = "admCatServEspecialidadByServEspecialidadId")
	public Set<HspAltaMedica> getHspAltaMedicasByServEspecialidadId() {
		return hspAltaMedicasByServEspecialidadId;
	}

	public void setHspAltaMedicasByServEspecialidadId(Set<HspAltaMedica> hspAltaMedicasByServEspecialidadId) {
		this.hspAltaMedicasByServEspecialidadId = hspAltaMedicasByServEspecialidadId;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SERV_ESPECIALIDAD_ID", unique = true, nullable = false, precision = 22)
	public Integer getServEspecialidadId() {
		return this.servEspecialidadId;
	}

	public void setServEspecialidadId(Integer servEspecialidadId) {
		this.servEspecialidadId = servEspecialidadId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SERV_BASICO_ID", nullable = false)
	public CatServBasico getCatServBasico() {
		return this.catServBasico;
	}

	public void setCatServBasico(CatServBasico catServBasico) {
		this.catServBasico = catServBasico;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_EVENTO_ID", nullable = false)
	public CatTipoEvento getCatTipoEvento() {
		return this.catTipoEvento;
	}

	public void setCatTipoEvento(CatTipoEvento catTipoEvento) {
		this.catTipoEvento = catTipoEvento;
	}


	@Column(name = "CVE", length = 4)
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}


	@Column(name = "NOMBRE", length = 30)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Column(name = "DESCRIPCION", length = 30)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Column(name = "VALOR_DEFAULT", precision = 22)
	public Integer getIndicaDefault() {
		return this.indicaDefault;
	}

	public void setIndicaDefault(Integer indicaDefault) {
		this.indicaDefault = indicaDefault;
	}


	@Column(name = "ESTATUS", precision = 22)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", length = 7)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@Column(name = "USUARIO_REGISTRO", length = 20)
	public String getUsuarioCve() {
		return this.usuarioCve;
	}

	public void setUsuarioCve(String usuarioCve) {
		this.usuarioCve = usuarioCve;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catServEspecialidad")
	public Set<AdmPersonalEspecialidades> getAdmPersonalEspecialidadese() {
		return this.admPersonalEspecialidadese;
	}

	public void setAdmPersonalEspecialidadese(Set<AdmPersonalEspecialidades> admPersonalEspecialidadese) {
		this.admPersonalEspecialidadese = admPersonalEspecialidadese;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catServEspecialidad")
	public Set<AdmPersonalCedula> getAdmPersonalCedulas() {
		return this.admPersonalCedulas;
	}

	public void setAdmPersonalCedulas(Set<AdmPersonalCedula> admPersonalCedulas) {
		this.admPersonalCedulas = admPersonalCedulas;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catServEspecialidad")
	public Set<AdmAgendaDetalle> getAdmAgendaDetalles() {
		return this.admAgendaDetalles;
	}


	public void setAdmAgendaDetalles(Set<AdmAgendaDetalle> admAgendaDetalles) {
		this.admAgendaDetalles = admAgendaDetalles;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catServEspecialidad")
	public Set<AdmEquipoSerEspecialidad> getAdmEquipoSerEspecialidads() {
		return admEquipoSerEspecialidads;
	}

	public void setAdmEquipoSerEspecialidads(Set<AdmEquipoSerEspecialidad> admEquipoSerEspecialidads) {
		this.admEquipoSerEspecialidads = admEquipoSerEspecialidads;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catServEspecialidadByServEspecialidadId2")
	public Set<PermisosCitas> getPermisosCitasesForServEspecialidadId2() {
		return this.permisosCitasesForServEspecialidadId2;
	}

	public void setPermisosCitasesForServEspecialidadId2(Set<PermisosCitas> permisosCitasesForServEspecialidadId2) {
		this.permisosCitasesForServEspecialidadId2 = permisosCitasesForServEspecialidadId2;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catServEspecialidadByServEspecialidadId")
	public Set<PermisosCitas> getPermisosCitasesForServEspecialidadId() {
		return this.permisosCitasesForServEspecialidadId;
	}

	public void setPermisosCitasesForServEspecialidadId(Set<PermisosCitas> permisosCitasesForServEspecialidadId) {
		this.permisosCitasesForServEspecialidadId = permisosCitasesForServEspecialidadId;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catServEspecialidad")
	public Set<PrestacionTipoServesp> getPrestacionTipoServesps() {
		return this.prestacionTipoServesps;
	}

	public void setPrestacionTipoServesps(Set<PrestacionTipoServesp> prestacionTipoServesps) {
		this.prestacionTipoServesps = prestacionTipoServesps;
	}


	@OneToMany(mappedBy = "catServEspecialidadByServicioEspecialidadRespId")
	public Set<PacActuacion> getPacActuacionsByServEspecialidadId() {
		return pacActuacionsByServEspecialidadId;
	}

	public void setPacActuacionsByServEspecialidadId(Set<PacActuacion> pacActuacionsByServEspecialidadId) {
		this.pacActuacionsByServEspecialidadId = pacActuacionsByServEspecialidadId;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catServEspecialidad")
	public Set<PacPeticionArchClinico> getPacPeticionArchClinicos() {
		return this.pacPeticionArchClinicos;
	}

	public void setPacPeticionArchClinicos(Set<PacPeticionArchClinico> pacPeticionArchClinicos) {
		this.pacPeticionArchClinicos = pacPeticionArchClinicos;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catServEspecialidad1")
	public Set<PacExpediente> getPacExpediente1() {
		return pacExpediente1;
	}

	public void setPacExpediente1(Set<PacExpediente> pacExpediente1) {
		this.pacExpediente1 = pacExpediente1;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catServEspecialidad2")
	public Set<PacExpediente> getPacExpediente2() {
		return pacExpediente2;
	}

	public void setPacExpediente2(Set<PacExpediente> pacExpediente2) {
		this.pacExpediente2 = pacExpediente2;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catServEspecialidad")
	public Set<CoreReferencia> getCoreReferencias() {
		return coreReferencias;
	}

	public void setCoreReferencias(Set<CoreReferencia> coreReferencias) {
		this.coreReferencias = coreReferencias;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catServEspecialidad")
	public Set<CoreReferenciasExternas> getCoreReferenciasExternas() {
		return coreReferenciasExternas;
	}

	public void setCoreReferenciasExternas(Set<CoreReferenciasExternas> coreReferenciasExternas) {
		this.coreReferenciasExternas = coreReferenciasExternas;
	}

	@OneToMany(mappedBy = "admCatServEspecialidadByServEspecialidadIdSte")
	public Set<PeticionesClinicas> getPeticionesClinicasByServEspecialidadId_0() {
		return peticionesClinicasByServEspecialidadId_0;
	}

	public void setPeticionesClinicasByServEspecialidadId_0(Set<PeticionesClinicas> peticionesClinicasByServEspecialidadId_0) {
		this.peticionesClinicasByServEspecialidadId_0 = peticionesClinicasByServEspecialidadId_0;
	}
}
