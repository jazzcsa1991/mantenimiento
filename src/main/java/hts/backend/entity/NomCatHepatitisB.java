package hts.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by SASA Desarrollo on 23/08/2017.
 */
@Entity
@Table(name = "nom_cat_hepatitis_b")
public class NomCatHepatitisB implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer hepatitisBId;
	private String cve;
	private String descripcion;
	private Date fechaRegistro;
	private String idiomaAppId;

	@Id @Column(name = "HEPATITIS_B_ID") public Integer getHepatitisBId() {
		return hepatitisBId;
	}

	public void setHepatitisBId(Integer hepatitisBId) {
		this.hepatitisBId = hepatitisBId;
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

	@Basic @Column(name = "IDIOMA_APP_ID") public String getIdiomaAppId() {
		return idiomaAppId;
	}

	public void setIdiomaAppId(String idiomaAppId) {
		this.idiomaAppId = idiomaAppId;
	}

}
