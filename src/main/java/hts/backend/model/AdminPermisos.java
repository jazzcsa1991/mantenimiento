package hts.backend.model;

import hts.backend.entity.AdmHospital;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "admin_permisos")
public class AdminPermisos implements  java.io.Serializable{
private static final long serialVersionUID = 1L;

	private Integer adminPermisosAdminId;
	private String permisos;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private AdmHospital admHospitalByHospitalId;
	private UsuarioAdmin usuarioAdmin;
	private Integer hospitalId;
	private Integer usuarioAdminId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADMIN_PERMISOS_ADMIN_ID", nullable = false)
	public Integer getAdminPermisosAdminId() {
		return adminPermisosAdminId;
	}

	public void setAdminPermisosAdminId(Integer adminPermisosAdminId) {
		this.adminPermisosAdminId = adminPermisosAdminId;
	}

	@Basic
	@Column(name = "PERMISOS", nullable = false)
	public String getPermisos() {
		return permisos;
	}

	public void setPermisos(String permisos) {
		this.permisos = permisos;
	}

	@Basic
	@Column(name = "FECHA_REGISTRO", nullable = false)
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic
	@Column(name = "USUARIO_REGISTRO", nullable = false)
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}



	@ManyToOne
	@JoinColumn(name = "HOSPITAL_ID", insertable = false, updatable = false)
	public AdmHospital getAdmHospitalByHospitalId() {
		return admHospitalByHospitalId;
	}

	public void setAdmHospitalByHospitalId(AdmHospital admHospitalByHospitalId) {
		this.admHospitalByHospitalId = admHospitalByHospitalId;
	}

	@Basic
	@Column(name = "HOSPITAL_ID", nullable = false)
	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	@ManyToOne
	@JoinColumn(name = "USUARIO_ADMIN_ID", insertable = false, updatable = false)
	public UsuarioAdmin getUsuarioAdmin() {
		return usuarioAdmin;
	}

	public void setUsuarioAdmin(UsuarioAdmin usuarioAdmin) {
		this.usuarioAdmin = usuarioAdmin;
	}

	@Basic
	@Column(name = "USUARIO_ADMIN_ID", nullable = false)
	public Integer getUsuarioAdminId() {
		return usuarioAdminId;
	}

	public void setUsuarioAdminId(Integer usuarioAdminId) {
		this.usuarioAdminId = usuarioAdminId;
	}
}
