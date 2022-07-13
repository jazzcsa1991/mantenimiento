package hts.backend.entity;

import org.springframework.security.core.context.SecurityContextHolder;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pac_expediente")
public class PacExpediente implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	private Integer expedienteId;
	private String noExpediente;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private String servicioEspRegistro;
	private Date fechaModificacion;
	private String usuarioModificacion;
	private String servicioEspModificacion;
	private Integer dias;
	private Integer noPeticion;
	private CatTipoExpediente catTipoExpediente;
	private CatUbicacionExpediente catUbicacionExpediente;
	private CatEstatusExpediente catEstatusExpediente;
	private CatServEspecialidad catServEspecialidad1;
	private CatServEspecialidad catServEspecialidad2;
	private AdmHospital admHospital;
	private Integer hospitalId;
	private PacPaciente pacPaciente;
	private Integer pacienteId;

	public static PacExpediente NuevoExpediente(int idPaciente, String noExpediente, CatTipoExpediente tipoExpediente, CatServEspecialidad servEspecialidadRegistro, CatUbicacionExpediente ubicacionExpediente, CatEstatusExpediente estatusExpediente, int idHospital) {
		PacExpediente obj = new PacExpediente();

		obj.setPacienteId(idPaciente);
		obj.setHospitalId(idHospital);
		obj.setNoExpediente(noExpediente);
		obj.setCatTipoExpediente(tipoExpediente);
		obj.setCatServEspecialidad1(servEspecialidadRegistro);

		obj.setFechaRegistro(new Date());
		obj.setUsuarioRegistro(SecurityContextHolder.getContext().getAuthentication().getName());
		obj.setFechaModificacion(null);
		obj.setUsuarioModificacion(null);
		obj.setDias(0);
		obj.setNoPeticion(0);
		obj.setCatUbicacionExpediente(ubicacionExpediente);
		obj.setCatEstatusExpediente(estatusExpediente);
		obj.setCatServEspecialidad2(null);

		return obj;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EXPEDIENTE_ID") public Integer getExpedienteId() {
		return expedienteId;
	}

	public void setExpedienteId(Integer expedienteId) {
		this.expedienteId = expedienteId;
	}

	@Basic @Column(name = "NO_EXPEDIENTE") public String getNoExpediente() {
		return noExpediente;
	}

	public void setNoExpediente(String noExpediente) {
		this.noExpediente = noExpediente;
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

	/*@Basic @Column(name = "SERVICIO_ESP_REGISTRO") public String getServicioEspRegistro() {
		return servicioEspRegistro;
	}

	public void setServicioEspRegistro(String servicioEspRegistro) {
		this.servicioEspRegistro = servicioEspRegistro;
	}*/

	@Basic @Column(name = "FECHA_MODIFICACION") public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	@Basic @Column(name = "USUARIO_MODIFICACION") public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

/*	@Basic @Column(name = "SERVICIO_ESP_MODIFICACION") public String getServicioEspModificacion() {
		return servicioEspModificacion;
	}

	public void setServicioEspModificacion(String servicioEspModificacion) {
		this.servicioEspModificacion = servicioEspModificacion;
	}*/

	@Basic @Column(name = "DIAS") public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}


	@Basic @Column(name = "NO_PETICION") public Integer getNoPeticion() {
		return noPeticion;
	}

	public void setNoPeticion(Integer noPeticion) {
		this.noPeticion = noPeticion;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_EXPEDIENTE_ID")
	public CatTipoExpediente getCatTipoExpediente() {
		return catTipoExpediente;
	}

	public void setCatTipoExpediente(CatTipoExpediente catTipoExpediente) {
		this.catTipoExpediente = catTipoExpediente;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UBICACION_EXPEDIENTE_ID")
	public CatUbicacionExpediente getCatUbicacionExpediente() {
		return catUbicacionExpediente;
	}

	public void setCatUbicacionExpediente(CatUbicacionExpediente catUbicacionExpediente) {
		this.catUbicacionExpediente = catUbicacionExpediente;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ESTATUS_EXPEDIENTE_ID")
	public CatEstatusExpediente getCatEstatusExpediente() {
		return catEstatusExpediente;
	}

	public void setCatEstatusExpediente(CatEstatusExpediente catEstatusExpediente) {
		this.catEstatusExpediente = catEstatusExpediente;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SERVICIO_ESP_REGISTRO")
	public CatServEspecialidad getCatServEspecialidad1() {
		return catServEspecialidad1;
	}

	public void setCatServEspecialidad1(CatServEspecialidad catServEspecialidad1) {
		this.catServEspecialidad1 = catServEspecialidad1;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SERVICIO_ESP_MODIFICACION")
	public CatServEspecialidad getCatServEspecialidad2() {
		return catServEspecialidad2;
	}

	public void setCatServEspecialidad2(CatServEspecialidad catServEspecialidad2) {
		this.catServEspecialidad2 = catServEspecialidad2;
	}

	@ManyToOne
	@JoinColumn(name = "HOSPITAL_ID", referencedColumnName = "HOSPITAL_ID", updatable = false , insertable = false)
	public AdmHospital getAdmHospital() {
		return admHospital;
	}

	public void setAdmHospital(AdmHospital admHospital) {
		this.admHospital = admHospital;
	}

	@Basic @Column(name = "HOSPITAL_ID")
	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	@ManyToOne
	@JoinColumn(name = "PACIENTE_ID", referencedColumnName = "ID_PACIENTE", updatable = false , insertable = false)
	public PacPaciente getPacPaciente() {
		return pacPaciente;
	}

	public void setPacPaciente(PacPaciente pacPaciente) {
		this.pacPaciente = pacPaciente;
	}

	@Basic @Column(name = "PACIENTE_ID")
	public Integer getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Integer pacienteId) {
		this.pacienteId = pacienteId;
	}
}

