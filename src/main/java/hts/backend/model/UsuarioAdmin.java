package hts.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import hts.backend.controller.CatalogosController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Entity
@Table(name = "admin_usuario")
public class UsuarioAdmin implements UserDetails {

	private static final Log logger = LogFactory.getLog(CatalogosController.class);
	private static final long serialVersionUID = 1L;

	private Integer usuarioAdminId;
	private String numeroEmpleado;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String password;
	private Integer root;
	private String usuarioRegistro;
	private Date fechaRegistro;
	private String permisos;

	private Date fechaPassword;
	private Integer usuarioNuevo;

	private String usuarioEliminacion;
	private Timestamp fechaEliminacion;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USUARIO_ADMIN_ID", updatable = false, unique = true, nullable = false)
	public Integer getUsuarioAdminId() {
		logger.info("############# OBTENIENDO PERMISOS 3  #####################");
		return usuarioAdminId;
	}

	public void setUsuarioAdminId(Integer id) {
		this.usuarioAdminId = id;
	}


	@Basic
	@Column(name = "USER_NAME", updatable = false, unique = true, length = 20)
	public String getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(String usuario) {
		this.numeroEmpleado = usuario;
	}


	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "PASSWORD_ADMIN")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Basic
	@Column(name = "NOMBRE_ADMIN", nullable = false, length = 90)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Basic
	@Column(name = "PRIMER_APELLIDO_ADMIN", nullable = false, length = 90)
	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}


	@Basic
	@Column(name = "SEGUNDO_APELLIDO_ADMIN", length = 90)
	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
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
	@Column(name = "PERMISOS")
	public String getPermisos() {

		logger.info("############# OBTENIENDO PERMISOS 3  #####################");
		return permisos;
	}

	public void setPermisos(String permisos) {
		this.permisos = permisos;
	}

	@Basic
	@Column(name = "USUARIO_ELIMINACION")
	public String getUsuarioEliminacion() {
		return usuarioEliminacion;
	}

	public void setUsuarioEliminacion(String usuarioEliminacion) {
		this.usuarioEliminacion = usuarioEliminacion;
	}

	@Basic
	@Column(name = "FECHA_ELIMINACION")
	public Timestamp getFechaEliminacion() {
		return fechaEliminacion;
	}

	public void setFechaEliminacion(Timestamp fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}


	// Métodos para seguridad /////////////////////////////////////////////////////////////////////////////

	@Override
	@Transient
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	@Transient
	@JsonIgnore
	@SuppressWarnings("JpaAttributeMemberSignatureInspection")
	public String getUsername() {
		return numeroEmpleado;
	}

	@Override
	@Transient
	@JsonIgnore
	@SuppressWarnings("JpaAttributeMemberSignatureInspection")
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	@Transient
	@JsonIgnore
	@SuppressWarnings("JpaAttributeMemberSignatureInspection")
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	@Transient
	@JsonIgnore
	@SuppressWarnings("JpaAttributeMemberSignatureInspection")
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	@Transient
	@JsonIgnore
	@SuppressWarnings("JpaAttributeMemberSignatureInspection")
	public boolean isEnabled() {
		return true;
	}
}
