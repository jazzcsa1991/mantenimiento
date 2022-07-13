package hts.backend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "adm_cat_tipo_hospital")
public class AdmCatTipoHospital {
	private Integer tipoHospitalId;
	private String nombre;
	private String cve;
	private Integer estatus;
	private String descripcion;
	private Date fechaRegistro;
	private String usuarioRegistro;


	@Id
	@Column(name = "TIPO_HOSPITAL_ID", nullable = false)
	public Integer getTipoHospitalId() {
		return tipoHospitalId;
	}

	public void setTipoHospitalId(Integer tipoHospitalId) {
		this.tipoHospitalId = tipoHospitalId;
	}


	@Basic
	@Column(name = "NOMBRE", length = 50)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Basic
	@Column(name = "CVE", length = 50)
	public String getCve() {
		return cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}


	@Basic
	@Column(name = "ESTATUS")
	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}


	@Basic
	@Column(name = "DESCRIPCION", length = 20)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	@Column(name = "USUARIO_REGISTRO", length = 50)
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}
}
