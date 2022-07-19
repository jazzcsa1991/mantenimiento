package hts.backend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "admin_correo")
public class AdminCorreo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer correoAdminId;
	private String correoAdmin;
	private String usuarioRegistro;
	private Date fechaRegistro;
	private UsuarioAdmin UsuarioAdmin;
	private Integer usuarioAdminId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADMIN_CORREO_ID", nullable = false)
	public Integer getCorreoAdminId() {
		return correoAdminId;
	}

	public void setCorreoAdminId(Integer correoAdminId) {
		this.correoAdminId = correoAdminId;
	}

	@Basic
	@Column(name = "CORREO_ADMIN", nullable = false)
	public String getCorreoAdmin() {
		return correoAdmin;
	}

	public void setCorreoAdmin(String correoAdmin) {
		this.correoAdmin = correoAdmin;
	}

	@Basic
	@Column(name = "USUARIO_REGISTRO", nullable = false)
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
	public hts.backend.model.UsuarioAdmin getUsuarioAdmin() {
		return UsuarioAdmin;
	}

	public void setUsuarioAdmin(UsuarioAdmin usuarioAdmin) {
		UsuarioAdmin = usuarioAdmin;
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
