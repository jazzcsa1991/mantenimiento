package hts.backend.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "admin_usuario_recuperacion")
public class AdminUsuarioRecuperacion implements Serializable {
	private String uuid;
	private String correo;
	private Date fechaRegistro;
	private Date fechaUtilizado;

	private Integer userId;
	private UsuarioAdmin admUsuario;


	@Id
	@Column(name = "UUID", nullable = false, unique = true)
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	@Basic
	@Column(name = "USER_ID", nullable = false)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	@Basic
	@Column(name = "CORREO", nullable = false)
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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
	@Column(name = "FECHA_UTILIZADO")
	public Date getFechaUtilizado() {
		return fechaUtilizado;
	}

	public void setFechaUtilizado(Date fechaUtilizado) {
		this.fechaUtilizado = fechaUtilizado;
	}


	@ManyToOne
	@JoinColumn(name = "USER_ID", referencedColumnName = "USUARIO_ADMIN_ID", updatable = false, insertable = false)
	public UsuarioAdmin getAdmUsuario() {
		return admUsuario;
	}

	public void setAdmUsuario(UsuarioAdmin admUsuario) {
		this.admUsuario = admUsuario;
	}
}
