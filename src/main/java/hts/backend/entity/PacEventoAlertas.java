package hts.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "pac_evento_alertas")
public class PacEventoAlertas implements Serializable {
	private Integer eventoAlertaId;
	private Integer eventoId;
	private Integer alertaId;
	private String comentario;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Date fechaEliminacion;
	private String usuarioEliminacion;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EVENTO_ALERTA_ID", nullable = false)
	public Integer getEventoAlertaId() {
		return eventoAlertaId;
	}

	public void setEventoAlertaId(Integer eventoAlertaId) {
		this.eventoAlertaId = eventoAlertaId;
	}

	@Basic
	@Column(name = "EVENTO_ID", nullable = false)
	public Integer getEventoId() {
		return eventoId;
	}

	public void setEventoId(Integer eventoId) {
		this.eventoId = eventoId;
	}

	@Basic
	@Column(name = "ALERTA_ID", nullable = false)
	public Integer getAlertaId() {
		return alertaId;
	}

	public void setAlertaId(Integer alertaId) {
		this.alertaId = alertaId;
	}

	@Basic
	@Column(name = "COMENTARIO", nullable = false, length = 255)
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
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
	@Column(name = "USUARIO_REGISTRO", nullable = false, length = 20)
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Basic
	@Column(name = "FECHA_ELIMINACION", nullable = false)
	public Date getFechaEliminacion() {
		return fechaEliminacion;
	}

	public void setFechaEliminacion(Date fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}

	@Basic
	@Column(name = "USUARIO_ELIMINACION", nullable = false, length = 20)
	public String getUsuarioEliminacion() {
		return usuarioEliminacion;
	}

	public void setUsuarioEliminacion(String usuarioEliminacion) {
		this.usuarioEliminacion = usuarioEliminacion;
	}

}
