package hts.backend.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "responsable_riss")

public class ResponsableRiss implements Serializable{

	private Integer responsableRissId;
	private Integer usuarioId;
	private Integer estadoId;
	private Integer rissId;
	private String usuarioRegistro;
	private Date fechaRegistro;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "responsable_riss_id")
	public Integer getResponsableRissId() {
		return responsableRissId;
	}

	public void setResponsableRissId(Integer responsableRissId) {
		this.responsableRissId = responsableRissId;
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
	@Column(name = "id_riss")
	public Integer getRissId() {
		return rissId;
	}

	public void setRissId(Integer rissId) {
		this.rissId = rissId;
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
