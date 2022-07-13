package hts.backend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "foliador")
public class Foliador implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer foliadorId;
	private Integer tipoFoliadorId;
	private String secuencia;
	private Date fechaActualizacion;
	private String usuarioRegistra;
	private Integer hospitalId;
	private Integer ceros;
	private String cve;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FOLIADOR_ID", nullable = false) public Integer getFoliadorId() {
		return foliadorId;
	}

	public void setFoliadorId(Integer foliadorId) {
		this.foliadorId = foliadorId;
	}

	@Basic @Column(name = "TIPO_FOLIADOR_ID", nullable = false) public Integer getTipoFoliadorId() {
		return tipoFoliadorId;
	}

	public void setTipoFoliadorId(Integer tipoFoliadorId) {
		this.tipoFoliadorId = tipoFoliadorId;
	}

	@Basic @Column(name = "SECUENCIA", nullable = false, length = 20) public String getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(String secuencia) {
		this.secuencia = secuencia;
	}

	@Basic @Column(name = "FECHA_ACTUALIZACION", nullable = false) public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	@Basic @Column(name = "USUARIO_REGISTRO", nullable = false, length = 20) public String getUsuarioRegistra() {
		return usuarioRegistra;
	}

	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}

	@Basic @Column(name = "HOSPITAL_ID") public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	@Basic @Column(name = "CEROS") public Integer getCeros() {
		return ceros;
	}

	public void setCeros(Integer ceros) {
		this.ceros = ceros;
	}

	@Basic @Column(name = "CVE") public String getCve() {
		return cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

}
