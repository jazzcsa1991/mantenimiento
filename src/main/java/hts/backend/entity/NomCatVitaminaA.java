package hts.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

/**
 * Created by SASA Desarrollo on 23/08/2017.
 */
@Entity
@Table(name = "nom_cat_vitamina_a")
public class NomCatVitaminaA implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer vitaminaAId;
	private String cve;
	private String descripcion;
	private Time fechaRegistro;
	private String usuarioRegistro;

	@Id @Column(name = "VITAMINA_A_ID") public Integer getVitaminaAId() {
		return vitaminaAId;
	}

	public void setVitaminaAId(Integer vitaminaAId) {
		this.vitaminaAId = vitaminaAId;
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

	@Basic @Column(name = "FECHA_REGISTRO") public Time getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Time fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO") public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}


}
