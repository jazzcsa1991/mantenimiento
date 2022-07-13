package hts.backend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nom_cat_motivo_bloqueo_cama")
public class NomCatMotivoBloqueoCama {
	private Integer motivoBloqueoCamaId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Boolean valorDefault;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;


	@Id
	@Column(name = "MOTIVO_BLOQUEO_CAMA_ID", nullable = false)
	public Integer getMotivoBloqueoCamaId() {
		return motivoBloqueoCamaId;
	}

	public void setMotivoBloqueoCamaId(Integer motivoBloqueoCamaId) {
		this.motivoBloqueoCamaId = motivoBloqueoCamaId;
	}


	@Basic
	@Column(name = "CVE", nullable = false, length = 20)
	public String getCve() {
		return cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
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
	@Column(name = "DESCRIPCION", length = 150)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Basic
	@Column(name = "VALOR_DEFAULT", nullable = false)
	public Boolean getValorDefault() {
		return valorDefault;
	}

	public void setValorDefault(Boolean valorDefault) {
		this.valorDefault = valorDefault;
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
