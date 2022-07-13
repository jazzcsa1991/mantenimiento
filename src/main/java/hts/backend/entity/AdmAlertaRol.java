package hts.backend.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "adm_alerta_rol")
public class AdmAlertaRol implements Serializable{
	
	private Integer alertaRolId;
	private Integer alertaId;
	private Integer rolId;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Date fechaEliminacion;
	private String usuarioEliminacion;
	private Integer captura;
	private Integer consulta;
	
	public AdmAlertaRol() {
	}

	public AdmAlertaRol(Integer alertaRolId, Integer alertaId, Integer rolId, Date fechaRegistro,
			String usuarioRegistro, Date fechaEliminacion, String usuarioEliminacion, Integer captura,
			Integer consulta) {
		super();
		this.alertaRolId = alertaRolId;
		this.alertaId = alertaId;
		this.rolId = rolId;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaEliminacion = fechaEliminacion;
		this.usuarioEliminacion = usuarioEliminacion;
		this.captura = captura;
		this.consulta = consulta;
	}

	@Id
	@Column(name = "ALERTA_ROL_ID", unique = true, nullable = false)
	public Integer getAlertaRolId() {
		return alertaRolId;
	}

	public void setAlertaRolId(Integer alertaRolId) {
		this.alertaRolId = alertaRolId;
	}

	@Column(name = "ALERTA_ID", nullable = false)
	public Integer getAlertaId() {
		return alertaId;
	}

	public void setAlertaId(Integer alertaId) {
		this.alertaId = alertaId;
	}

	@Column(name = "ROL_ID", nullable = false)
	public Integer getRolId() {
		return rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", nullable = false)
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Column(name = "USUARIO_REGISTRO", nullable = false)
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_ELIMINACION", nullable = false)
	public Date getFechaEliminacion() {
		return fechaEliminacion;
	}

	public void setFechaEliminacion(Date fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}

	@Column(name = "USUARIO_ELIMINACION", nullable = false)
	public String getUsuarioEliminacion() {
		return usuarioEliminacion;
	}

	public void setUsuarioEliminacion(String usuarioEliminacion) {
		this.usuarioEliminacion = usuarioEliminacion;
	}

	@Column(name = "CAPTURA", nullable = false)
	public Integer getCaptura() {
		return captura;
	}

	public void setCaptura(Integer captura) {
		this.captura = captura;
	}

	@Column(name = "CONSULTA", nullable = false)
	public Integer getConsulta() {
		return consulta;
	}

	public void setConsulta(Integer consulta) {
		this.consulta = consulta;
	}
	
	

}
