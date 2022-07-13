package hts.backend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "fac_cat_motivo_anulacion_abono")
public class FacCatMotivoAnulacionAbono implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer motivoAnulacionAbonoId;
	private String nombre;
	private String descripcion;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOTIVO_ANULACION_ABONO_ID", nullable = false, precision = 0)
	public Integer getMotivoAnulacionAbonoId() {
		return motivoAnulacionAbonoId;
	}

	public void setMotivoAnulacionAbonoId(Integer motivoAnulacionAbonoId) {
		this.motivoAnulacionAbonoId = motivoAnulacionAbonoId;
	}

	@Basic
	@Column(name = "NOMBRE", nullable = false, length = 100)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Basic
	@Column(name = "DESCRIPCION", nullable = true, length = 150)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Basic
	@Column(name = "ESTATUS", nullable = false, precision = 0)
	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
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
