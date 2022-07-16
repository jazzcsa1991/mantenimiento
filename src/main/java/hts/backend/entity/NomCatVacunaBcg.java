package hts.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by SASA Desarrollo on 23/08/2017.
 */
@Entity
@Table(name = "nom_cat_vacuna_bcg")
public class NomCatVacunaBcg implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer vacunaBcgId;
	private String cve;
	private String descripcion;
	private Date fechaRegistro;
	private String usuarioRegistro;

	@Id @Column(name = "ACUNA_BCG_ID")
	public Integer getVacunaBcgId() {
		return vacunaBcgId;
	}

	public void setVacunaBcgId(Integer vacunaBcgId) {
		this.vacunaBcgId = vacunaBcgId;
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


}
