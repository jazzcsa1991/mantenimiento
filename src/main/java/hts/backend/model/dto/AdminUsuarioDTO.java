package hts.backend.model.dto;

import java.util.Date;

public class AdminUsuarioDTO {


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
	private Integer usuarioAdminId;
	private String correo;


	public Integer getUsuarioAdminId() {
		return usuarioAdminId;
	}

	public void setUsuarioAdminId(Integer usuarioAdminId) {
		this.usuarioAdminId = usuarioAdminId;
	}

	public String getNumeroEmpleadoAdmin() {
		return numeroEmpleadoAdmin;
	}

	public void setNumeroEmpleadoAdmin(String numeroEmpleadoAdmin) {
		this.numeroEmpleadoAdmin = numeroEmpleadoAdmin;
	}

	public String getPasswordAdmin() {
		return passwordAdmin;
	}

	public void setPasswordAdmin(String passwordAdmin) {
		this.passwordAdmin = passwordAdmin;
	}

	public String getNombreAdmin() {
		return nombreAdmin;
	}

	public void setNombreAdmin(String nombreAdmin) {
		this.nombreAdmin = nombreAdmin;
	}

	public String getPrimerApellidoAdmin() {
		return primerApellidoAdmin;
	}

	public void setPrimerApellidoAdmin(String primerApellidoAdmin) {
		this.primerApellidoAdmin = primerApellidoAdmin;
	}

	public String getSegundoApellidoAdmin() {
		return segundoApellidoAdmin;
	}

	public void setSegundoApellidoAdmin(String segundoApellidoAdmin) {
		this.segundoApellidoAdmin = segundoApellidoAdmin;
	}

	public Integer getRoot() {
		return root;
	}

	public void setRoot(Integer root) {
		this.root = root;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaPassword() {
		return fechaPassword;
	}

	public void setFechaPassword(Date fechaPassword) {
		this.fechaPassword = fechaPassword;
	}

	public Integer getUsuarioNuevo() {
		return usuarioNuevo;
	}

	public void setUsuarioNuevo(Integer usuarioNuevo) {
		this.usuarioNuevo = usuarioNuevo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Valida que los datos requeridos estén inicializados.
	 *
	 * @return true/false
	 */
	public boolean validarDatosRequeridos() {
		return nombreAdmin != null &&
				primerApellidoAdmin != null &&
				numeroEmpleadoAdmin != null &&
				passwordAdmin != null;
	}
}
