package hts.backend.entity;

import hts.backend.entity.CexReceta;
import hts.backend.entity.CorePrescripcionesRecetas;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "adm_personal_cedula")
public class AdmPersonalCedula implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer admProfSaludCedulaId;
	private String cedulaProf;
	private String escolaridad;
	private Integer tituloProf;
	private Integer status;
	private Date fechaRegistro;
	private String usuarioCve;
	private String tipoPersonal;

	private CatServEspecialidad catServEspecialidad;
	private AdmPersonalDatos admPersonalDatos;

	private Set<CexReceta> cexRecetas = new HashSet<>(0);


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADM_PROF_SALUD_CEDULA_ID", unique = true, nullable = false)
	public Integer getAdmProfSaludCedulaId() {
		return this.admProfSaludCedulaId;
	}

	public void setAdmProfSaludCedulaId(Integer admProfSaludCedulaId) {
		this.admProfSaludCedulaId = admProfSaludCedulaId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SERV_ESPECIALIDAD_ID", nullable = false)
	public CatServEspecialidad getCatServEspecialidad() {
		return this.catServEspecialidad;
	}

	public void setCatServEspecialidad(CatServEspecialidad catServEspecialidad) {
		this.catServEspecialidad = catServEspecialidad;
	}


	@Column(name = "CEDULA_PROF")
	public String getCedulaProf() {
		return this.cedulaProf;
	}

	public void setCedulaProf(String cedulaProf) {
		this.cedulaProf = cedulaProf;
	}


	@Column(name = "ESCOLARIDAD", length = 100)
	public String getEscolaridad() {
		return this.escolaridad;
	}

	public void setEscolaridad(String escolaridad) {
		this.escolaridad = escolaridad;
	}


	@Column(name = "TITULO_PROF", precision = 22)
	public Integer getTituloProf() {
		return this.tituloProf;
	}

	public void setTituloProf(Integer tituloProf) {
		this.tituloProf = tituloProf;
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

	@Column(name = "TIPO_PERSONAL", length = 20)
	public String getTipoPersonal() {
		return this.tipoPersonal;
	}

	public void setTipoPersonal(String tipoPersonal) {
		this.tipoPersonal = tipoPersonal;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ADM_PROF_SALUD_DATAPROF_ID")
	public AdmPersonalDatos getAdmPersonalDatos() {
		return this.admPersonalDatos;
	}

	public void setAdmPersonalDatos(AdmPersonalDatos admPersonalDatos) {
		this.admPersonalDatos = admPersonalDatos;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "admPersonalCedula")
	public Set<CexReceta> getCexRecetas() {
		return this.cexRecetas;
	}

	public void setCexRecetas(Set<CexReceta> cexRecetas) {
		this.cexRecetas = cexRecetas;
	}

}
