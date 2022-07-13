package hts.backend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "fac_cat_tipo_transaccion")
public class FacCatTipoTransaccion {
	private Integer tipoTransaccionId;
	private String nombre;
	private String descripcion;
	private Boolean estatus;
	private String usuarioRegistro;
	private Date fechaRegistro;


	@Id
	@Column(name = "TIPO_TRANSACCION_ID", nullable = false)
	public Integer getTipoTransaccionId() {
		return tipoTransaccionId;
	}

	public void setTipoTransaccionId(Integer tipoTransaccionId) {
		this.tipoTransaccionId = tipoTransaccionId;
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
	@Column(name = "DESCRIPCION", nullable = false, length = 60)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Basic
	@Column(name = "ESTATUS", nullable = false)
	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
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
	@Column(name = "FECHA_REGISTRO", nullable = false)
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
}
