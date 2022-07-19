package hts.backend.entity;

import hts.backend.entity.AdmHospital;
import hts.backend.entity.AdmRolAccion;
import hts.backend.entity.AdmFuncion;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "adm_cat_rol")
public class CatRol implements java.io.Serializable {
	private Integer rolId;
	private String nombre;
	private String descripcion;
	private Integer status;
	private Date fechaRegistro;
	private String usuarioRegistra;

	private NomCatPerfil nomCatPerfil;
	private AdmHospital admHospital;

	private Set<AdmFuncion> admFuncions = new HashSet<>(0);
	private Set<AdmPersonalRol> admPersonalRol = new HashSet<>(0);
	private Set<AdmRolAccion> admRolAccions = new HashSet<>(0);


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROL_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getRolId() {
		return this.rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERFIL_ID", nullable = false)
	public NomCatPerfil getNomCatPerfil() {
		return this.nomCatPerfil;
	}

	public void setNomCatPerfil(NomCatPerfil nomCatPerfil) {
		this.nomCatPerfil = nomCatPerfil;
	}


	@Column(name = "NOMBRE", length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Column(name = "DESCRIPCION", length = 100)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Column(name = "ESTATUS", precision = 22, scale = 0)
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
	public String getUsuarioRegistra() {
		return this.usuarioRegistra;
	}

	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HOSPITAL_ID", nullable = false)
	public AdmHospital getAdmHospital() {
		return admHospital;
	}

	public void setAdmHospital(AdmHospital admHospital) {
		this.admHospital = admHospital;
	}


	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "catRols")
	public Set<AdmFuncion> getAdmFuncions() {
		return this.admFuncions;
	}

	public void setAdmFuncions(Set<AdmFuncion> admFuncions) {
		this.admFuncions = admFuncions;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catRol")
	public Set<AdmPersonalRol> getAdmPersonalRol() {
		return admPersonalRol;
	}

	public void setAdmPersonalRol(Set<AdmPersonalRol> admPersonalRol) {
		this.admPersonalRol = admPersonalRol;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catRol")
	public Set<AdmRolAccion> getAdmRolAccions() {
		return this.admRolAccions;
	}

	public void setAdmRolAccions(Set<AdmRolAccion> admRolAccions) {
		this.admRolAccions = admRolAccions;
	}
}
