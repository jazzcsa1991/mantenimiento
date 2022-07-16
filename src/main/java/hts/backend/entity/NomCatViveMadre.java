package hts.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by SASA Desarrollo on 24/08/2017.
 */
@Entity
@Table(name = "nom_cat_vive_madre")
public class NomCatViveMadre implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer viveMadreId;
	private String cve;
	private String descripcion;
	private Date fechaRegistro;
	private String usuarioRegistro;

	@Id @Column(name = "VIVE_MADRE_ID") public Integer getViveMadreId() {
		return viveMadreId;
	}

	public void setViveMadreId(Integer viveMadreId) {
		this.viveMadreId = viveMadreId;
	}

	@Basic @Column(name = "CVE") public String getCve() {
		return cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	@Basic @Column(name = "DESCRIPCION") public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Basic @Column(name = "FECHA_REGISTRO") public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO") public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Override public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		NomCatViveMadre that = (NomCatViveMadre) o;

		if (viveMadreId != null ? !viveMadreId.equals(that.viveMadreId) : that.viveMadreId != null) return false;
		if (cve != null ? !cve.equals(that.cve) : that.cve != null) return false;
		if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
		if (fechaRegistro != null ? !fechaRegistro.equals(that.fechaRegistro) : that.fechaRegistro != null)
			return false;
		if (usuarioRegistro != null ? !usuarioRegistro.equals(that.usuarioRegistro) : that.usuarioRegistro != null)
			return false;

		return true;
	}

	@Override public int hashCode() {
		int result = viveMadreId != null ? viveMadreId.hashCode() : 0;
		result = 31 * result + (cve != null ? cve.hashCode() : 0);
		result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
		result = 31 * result + (fechaRegistro != null ? fechaRegistro.hashCode() : 0);
		result = 31 * result + (usuarioRegistro != null ? usuarioRegistro.hashCode() : 0);
		return result;
	}
}
