package hts.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by SASA Desarrollo on 23/08/2017.
 */
@Entity
@Table(name = "nom_cat_vitamina_k")
public class NomCatVitaminaK implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer vitaminaKId;
	private String cve;
	private String descripcion;
	private Date fechaRegistro;
	private String usuarioRegistro;

	@Id @Column(name = "VITAMINA_K_ID") public Integer getVitaminaKId() {
		return vitaminaKId;
	}

	public void setVitaminaKId(Integer vitaminaKId) {
		this.vitaminaKId = vitaminaKId;
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
