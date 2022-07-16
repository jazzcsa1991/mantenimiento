package hts.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "responsable_estado")

public class ResponsableEstado implements Serializable{
	private Integer responsableEstadoId;
	private Integer usuarioId;
	private Integer estadoId;
	private String usuarioRegistro;
	private Date fechaRegistro;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "responsable_estado_id")
	public Integer getResponsableEstadoId() {
		return responsableEstadoId;
	}

	public void setResponsableEstadoId(Integer responsableEstadoId) {
		this.responsableEstadoId = responsableEstadoId;
	}

	@Basic
	@Column(name = "id_usuario")
	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	@Basic
	@Column(name = "id_estado")
	public Integer getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Integer estadoId) {
		this.estadoId = estadoId;
	}

	@Basic
	@Column(name = "us_registro")
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Basic
	@Column(name = "fecha_registro")
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
}
