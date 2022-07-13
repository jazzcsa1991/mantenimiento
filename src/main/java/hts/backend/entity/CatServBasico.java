package hts.backend.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "adm_cat_serv_basico")
public class CatServBasico implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer servBasicoId;
	private AdmHospital admHospital;
	private String clave;
	private String nombre;
	private String descripcion;
	private Integer indicaDefault;
	private Integer status;
	private Date fechaRegistro;
	private String usuarioCve;
	private Integer medico;

	private Set<CatServEspecialidad> catServEspecialidads = new HashSet<>(0);


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SERV_BASICO_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getServBasicoId() {
		return this.servBasicoId;
	}

	public void setServBasicoId(Integer servBasicoId) {
		this.servBasicoId = servBasicoId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HOSPITAL_ID")
	public AdmHospital getAdmHospital() {
		return this.admHospital;
	}

	public void setAdmHospital(AdmHospital admHospital) {
		this.admHospital = admHospital;
	}


	@Column(name = "CLAVE", precision = 22, scale = 0)
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}


	@Column(name = "NOMBRE", length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Column(name = "DESCRIPCION", length = 50)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Column(name = "VALOR_DEFAULT", precision = 22, scale = 0)
	public Integer getIndicaDefault() {
		return this.indicaDefault;
	}

	public void setIndicaDefault(Integer indicaDefault) {
		this.indicaDefault = indicaDefault;
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
	public String getUsuarioCve() {
		return this.usuarioCve;
	}

	public void setUsuarioCve(String usuarioCve) {
		this.usuarioCve = usuarioCve;
	}


	@Column(name = "MEDICO", nullable = false)
	public Integer getMedico() {
		return medico;
	}

	public void setMedico(Integer medico) {
		this.medico = medico;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catServBasico")
	public Set<CatServEspecialidad> getCatServEspecialidads() {
		return this.catServEspecialidads;
	}

	public void setCatServEspecialidads(Set<CatServEspecialidad> catServEspecialidads) {
		this.catServEspecialidads = catServEspecialidads;
	}
}
