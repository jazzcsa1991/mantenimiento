package hts.backend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "adm_usuario_admin")
public class AdmUsuarioAdmin implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer usuarioAdminId;
	private String numeroEmpleadoAdmin;
	private String passwordAdmin;
	private String nombreAdmin;
	private String primerApellidoAdmin;
	private String segundoApellidoAdmin;
	private Integer root;
	private String usuarioRegistro;
	private String userName;
	private Date fechaRegistro;
	private Date fechaPassword;
	private Integer usuarioNuevo;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USUARIO_ADMIN_ID", nullable = false, precision = 0)
	public Integer getUsuarioAdminId() {
		return usuarioAdminId;
	}

	public void setUsuarioAdminId(Integer usuarioAdminId) {
		this.usuarioAdminId = usuarioAdminId;
	}

	@Basic
	@Column(name = "NUMERO_EMPLEADO_ADMIN", nullable = false, length = 255)
	public String getNumeroEmpleadoAdmin() {
		return numeroEmpleadoAdmin;
	}

	public void setNumeroEmpleadoAdmin(String numeroEmpleadoAdmin) {
		this.numeroEmpleadoAdmin = numeroEmpleadoAdmin;
	}

	@Basic
	@Column(name = "PASSWORD_ADMIN", nullable = false, length = 255)
	public String getPasswordAdmin() {
		return passwordAdmin;
	}

	public void setPasswordAdmin(String passwordAdmin) {
		this.passwordAdmin = passwordAdmin;
	}

	@Basic
	@Column(name = "NOMBRE_ADMIN", nullable = false, length = 255)
	public String getNombreAdmin() {
		return nombreAdmin;
	}

	public void setNombreAdmin(String nombreAdmin) {
		this.nombreAdmin = nombreAdmin;
	}

	@Basic
	@Column(name = "PRIMER_APELLIDO_ADMIN", nullable = false, length = 255)
	public String getPrimerApellidoAdmin() {
		return primerApellidoAdmin;
	}

	public void setPrimerApellidoAdmin(String primerApellidoAdmin) {
		this.primerApellidoAdmin = primerApellidoAdmin;
	}

	@Basic
	@Column(name = "SEGUNDO_APELLIDO_ADMIN", nullable = true, length = 255)
	public String getSegundoApellidoAdmin() {
		return segundoApellidoAdmin;
	}

	public void setSegundoApellidoAdmin(String segundoApellidoAdmin) {
		this.segundoApellidoAdmin = segundoApellidoAdmin;
	}

	@Basic
	@Column(name = "ROOT", nullable = false, precision = 0)
	public Integer getRoot() {
		return root;
	}

	public void setRoot(Integer root) {
		this.root = root;
	}

	@Basic
	@Column(name = "USUARIO_REGISTRO", nullable = false, length = 255)
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

	@Basic
	@Column(name = "FECHA_PASSWORD", nullable = false)
	public Date getFechaPassword() {
		return fechaPassword;
	}

	public void setFechaPassword(Date fechaPassword) {
		this.fechaPassword = fechaPassword;
	}

	@Basic
	@Column(name = "USUARIO_NUEVO", nullable = false, precision = 0)
	public Integer getUsuarioNuevo() {
		return usuarioNuevo;
	}

	public void setUsuarioNuevo(Integer usuarioNuevo) {
		this.usuarioNuevo = usuarioNuevo;
	}


	@Basic
	@Column(name = "USER_NAME", nullable = false, precision = 0)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
