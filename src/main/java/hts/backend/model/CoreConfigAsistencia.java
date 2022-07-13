package hts.backend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "core_config_asistencia")
public class CoreConfigAsistencia implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer confirmacionAsistenciaId;
	private String nombre;
	private String descripcion;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONFIRMACION_ASISTENCIA_ID")
	public Integer getConfirmacionAsistenciaId() {
		return confirmacionAsistenciaId;
	}

	public void setConfirmacionAsistenciaId(Integer confirmacionAsistenciaId) {
		this.confirmacionAsistenciaId = confirmacionAsistenciaId;
	}

	@Basic
	@Column(name = "NOMBRE ")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Basic
	@Column(name = "DESCRIPCION")
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Basic
	@Column(name = "ESTATUS")
	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@Basic
	@Column(name = "FECHA_REGISTRO")
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic
	@Column(name = "USUARIO_REGISTRO")
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}
}
