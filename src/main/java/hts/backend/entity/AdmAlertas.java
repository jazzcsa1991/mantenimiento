package hts.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "adm_alertas")
public class AdmAlertas implements Serializable {
	private Integer alertaId;
	private String nombre;
	private Integer estatus;
	private Integer comentario;
	private String icono;
	private Integer sexoId;
	private Integer hospitalId;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Date fechaEliminacion;
	private String usuarioEliminacion;
	private String interfazCaptura;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ALERTA_ID", nullable = false)
	public Integer getAlertaId() {
		return alertaId;
	}

	public void setAlertaId(Integer alertaId) {
		this.alertaId = alertaId;
	}

	@Basic
	@Column(name = "NOMBRE", nullable = false, length = 50)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Basic
	@Column(name = "ESTATUS", nullable = false)
	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@Basic
	@Column(name = "COMENTARIO", nullable = false)
	public Integer getComentario() {
		return comentario;
	}

	public void setComentario(Integer comentario) {
		this.comentario = comentario;
	}

	@Basic
	@Column(name = "ICONO", nullable = false, length = 100)
	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	@Basic
	@Column(name = "SEXO_ID", nullable = true)
	public Integer getSexoId() {
		return sexoId;
	}

	public void setSexoId(Integer sexoId) {
		this.sexoId = sexoId;
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
	@Column(name = "USUARIO_ELIMINACION", nullable = true, length = 20)
	public String getUsuarioEliminacion() {
		return usuarioEliminacion;
	}

	public void setUsuarioEliminacion(String usuarioEliminacion) {
		this.usuarioEliminacion = usuarioEliminacion;
	}

	@Basic
	@Column(name = "INTERFAZ_CAPTURA", nullable = true, length = 255)
	public String getInterfazCaptura() {
		return interfazCaptura;
	}

	public void setInterfazCaptura(String interfazCaptura) {
		this.interfazCaptura = interfazCaptura;
	}

	@Basic
	@Column(name = "HOSPITAL_ID", nullable = false)
	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
}