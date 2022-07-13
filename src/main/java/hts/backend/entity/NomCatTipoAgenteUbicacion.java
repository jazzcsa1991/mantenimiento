package hts.backend.entity;

import hts.backend.entity.PacEventoPrestacion;

import javax.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "nom_cat_tipo_agente_ubicacion")
public class NomCatTipoAgenteUbicacion {
	private Integer tipoAgenteUbicacionId;
	private String nombre;
	private String descripcion;
	private Boolean estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Set<PacEventoPrestacion> pacEventoPrestacionsByTipoAgenteUbicacionId;

	@OneToMany(mappedBy = "nomCatTipoAgenteUbicacionByTipoAgenteUbicacionId") public Set<PacEventoPrestacion> getPacEventoPrestacionsByTipoAgenteUbicacionId() {
		return pacEventoPrestacionsByTipoAgenteUbicacionId;
	}

	public void setPacEventoPrestacionsByTipoAgenteUbicacionId(Set<PacEventoPrestacion> pacEventoPrestacionsByTipoAgenteUbicacionId) {
		this.pacEventoPrestacionsByTipoAgenteUbicacionId = pacEventoPrestacionsByTipoAgenteUbicacionId;
	}

	@Id
	@Column(name = "TIPO_AGENTE_UBICACION_ID", nullable = false)
	public Integer getTipoAgenteUbicacionId() {
		return tipoAgenteUbicacionId;
	}

	public void setTipoAgenteUbicacionId(Integer tipoAgenteUbicacionId) {
		this.tipoAgenteUbicacionId = tipoAgenteUbicacionId;
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
	@Column(name = "DESCRIPCION", length = 100)
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
