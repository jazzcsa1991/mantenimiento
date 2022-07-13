package hts.backend.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "core_config")
public class CoreConfig implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Integer configId;
	private Integer hospitalId;
	private String configuracion;
	private Date fechaRegistro;
	private String usuarioRegistro;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONFIG_ID", nullable = false)
	public Integer getConfigId() {
		return configId;
	}

	public void setConfigId(Integer configId) {
		this.configId = configId;
	}

	@Basic
	@Column(name = "HOSPITAL_ID", nullable = false)
	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	@Basic
	@Column(name = "CONFIGURACION", nullable = false, length = -1)
	public String getConfiguracion() {
		return configuracion;
	}

	public void setConfiguracion(String configuracion) {
		this.configuracion = configuracion;
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

}
