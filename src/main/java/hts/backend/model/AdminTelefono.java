package hts.backend.model;

import hts.backend.entity.CatTipoTelefono;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "admin_telefono")
public class AdminTelefono implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer telefonoAdminId;
	private String telefonoAdmin;
	private String usuarioRegistro;
	private Date fechaRegistro;
	private CatTipoTelefono catTipoTelefonoByTipoTelefonoAdminId;
	private Integer tipoTelefonoId;
	private UsuarioAdmin adminUsuarioId;
	private Integer usuarioAdminId;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADMIN_TELEFONO_ID", nullable = false)
	public Integer getTelefonoAdminId() {
		return telefonoAdminId;
	}

	public void setTelefonoAdminId(Integer telefonoAdminId) {
		this.telefonoAdminId = telefonoAdminId;
	}

	@Basic
	@Column(name = "TELEFONO_ADMIN", nullable = false)
	public String getTelefonoAdmin() {
		return telefonoAdmin;
	}

	public void setTelefonoAdmin(String telefonoAdmin) {
		this.telefonoAdmin = telefonoAdmin;
	}

	@Basic
	@Column(name = "USUARIO_REGISTRO")
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Basic
	@Column(name = "FECHA_REGISTRO")
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@ManyToOne
	@JoinColumn(name = "TIPO_TELEFONO_ADMIN_ID", insertable = false, updatable = false)
	public CatTipoTelefono getCatTipoTelefonoByTipoTelefonoAdminId() {
		return catTipoTelefonoByTipoTelefonoAdminId;
	}

	public void setCatTipoTelefonoByTipoTelefonoAdminId(CatTipoTelefono catTipoTelefonoByTipoTelefonoAdminId) {
		this.catTipoTelefonoByTipoTelefonoAdminId = catTipoTelefonoByTipoTelefonoAdminId;
	}

	@ManyToOne
	@JoinColumn(name = "USUARIO_ADMIN_ID", insertable = false, updatable = false)
	public UsuarioAdmin getAdminUsuarioId() {
		return adminUsuarioId;
	}

	public void setAdminUsuarioId(UsuarioAdmin adminUsuarioId) {
		this.adminUsuarioId = adminUsuarioId;
	}

	@Basic
	@Column(name = "TIPO_TELEFONO_ADMIN_ID", nullable = false)
	public Integer getTipoTelefonoId() {
		return tipoTelefonoId;
	}

	public void setTipoTelefonoId(Integer tipoTelefonoId) {
		this.tipoTelefonoId = tipoTelefonoId;
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
