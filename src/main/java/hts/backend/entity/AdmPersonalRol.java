package hts.backend.entity;

import hts.backend.entity.AdmPersonal;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "adm_personal_rol")
public class AdmPersonalRol implements java.io.Serializable {
	private Integer profRolId;
	private Date fechaRegistro;
	private String usuarioRegistra;

	private AdmPersonal admPersonal;
	private CatRol catRol;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROF_ROL_ID", unique = true, nullable = false, precision = 22)
	public Integer getProfRolId() {
		return this.profRolId;
	}

	public void setProfRolId(Integer profRolId) {
		this.profRolId = profRolId;
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
	public String getUsuarioRegistra() {
		return this.usuarioRegistra;
	}

	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROFESIONAL_ID", referencedColumnName = "ADM_PROF_SALUD_GRAL_ID", nullable = false)
	public AdmPersonal getAdmPersonal() {
		return admPersonal;
	}

	public void setAdmPersonal(AdmPersonal admPersonal) {
		this.admPersonal = admPersonal;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROL_ID", nullable = false)
	public CatRol getCatRol() {
		return catRol;
	}

	public void setCatRol(CatRol catRol) {
		this.catRol = catRol;
	}
}
