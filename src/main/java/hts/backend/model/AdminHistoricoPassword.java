package hts.backend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "admin_historico_password")
public class AdminHistoricoPassword implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer adminHistoricoPassId;
	private String password;
	private String usuarioRegistro;
	private Date fechaRegistro;
	private UsuarioAdmin UsuarioAdminByUsuarioAdminId;
	private Integer usuarioAdminId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADMIN_HISTORICO_PASS_ID", nullable = false)
	public Integer getAdminHistoricoPassId() {
		return adminHistoricoPassId;
	}

	public void setAdminHistoricoPassId(Integer adminHistoricoPassId) {
		this.adminHistoricoPassId = adminHistoricoPassId;
	}

	@Basic
	@Column(name = "PASSWORD", nullable = false, length = 250)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Basic
	@Column(name = "USUARIO_REGISTRO", length = 250)
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Basic
	@Column(name = "FECHA_REGISTRO", nullable = false)
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@ManyToOne
	@JoinColumn(name = "USUARIO_ADMIN_ID", insertable = false, updatable = false)
	public UsuarioAdmin getUsuarioAdminByUsuarioAdminId() {
		return UsuarioAdminByUsuarioAdminId;
	}

	public void setUsuarioAdminByUsuarioAdminId(UsuarioAdmin UsuarioAdminByUsuarioAdminId) {
		this.UsuarioAdminByUsuarioAdminId = UsuarioAdminByUsuarioAdminId;
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
