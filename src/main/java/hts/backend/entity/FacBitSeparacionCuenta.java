package hts.backend.entity;

import hts.backend.entity.PacEvento;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "fac_bit_separacion_cuenta")
public class FacBitSeparacionCuenta  implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer separacionCuentaId;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private PacEvento pacEventoByEventoId;
	private Integer eventoId;
	private Date fechaAnulacion;
	private String usuarioAnulacion;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SEPARACION_CUENTA_ID", nullable = false) public Integer getSeparacionCuentaId() {
		return separacionCuentaId;
	}

	public void setSeparacionCuentaId(Integer separacionCuentaId) {
		this.separacionCuentaId = separacionCuentaId;
	}

	@Basic @Column(name = "FECHA_REGISTRO", nullable = false) public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@Basic @Column(name = "FECHA_ANULACION")
	public Date getFechaAnulacion() {
		return fechaAnulacion;
	}

	public void setFechaAnulacion(Date fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
	}




	@Basic @Column(name = "USUARIO_REGISTRO", nullable = false, length = 20) public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Basic @Column(name = "USUARIO_ANULACION", length = 20)
	public String getUsuarioAnulacion() {
		return usuarioAnulacion;
	}

	public void setUsuarioAnulacion(String usuarioAnulacion) {
		this.usuarioAnulacion = usuarioAnulacion;
	}


	@ManyToOne
	@JoinColumn(name = "EVENTO_ID", referencedColumnName = "EVENTO_ID", nullable = false , insertable = false , updatable = false) public PacEvento getPacEventoByEventoId() {
		return pacEventoByEventoId;
	}

	public void setPacEventoByEventoId(PacEvento pacEventoByEventoId) {
		this.pacEventoByEventoId = pacEventoByEventoId;
	}

	@Column(name = "EVENTO_ID", nullable = false)
	public Integer getEventoId() {
		return eventoId;
	}

	public void setEventoId(Integer eventoId) {
		this.eventoId = eventoId;
	}



}
