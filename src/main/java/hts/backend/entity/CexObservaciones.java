package hts.backend.entity;
// Generated 4/05/2017 11:05:26 AM by Hibernate Tools 5.2.0.Beta1

import java.util.Date;
import javax.persistence.*;

/**
 * CexObservaciones generated by hbm2java
 */
@Entity
@Table(name = "cex_observaciones")
public class CexObservaciones implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int observacionId;
	private CexCitaPaciente cexCitaPaciente;
	private String observacion;
	private String usuarioRegistra;
	private Date fechaRegistro;

	public CexObservaciones() {
	}

	public CexObservaciones(int observacionId, String observacion, String usuarioRegistra, CexCitaPaciente cexCitaPaciente,
							Date fechaRegistro) {
		this.observacionId = observacionId;
		this.cexCitaPaciente = cexCitaPaciente;
		this.observacion = observacion;
		this.usuarioRegistra = usuarioRegistra;
		this.fechaRegistro = fechaRegistro;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OBSERVACION_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public int getObservacionId() {
		return this.observacionId;
	}

	public void setObservacionId(int observacionId) {
		this.observacionId = observacionId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CITA_PACIENTE_ID", nullable = false)
	public CexCitaPaciente getCexCitaPaciente() {
		return this.cexCitaPaciente;
	}

	public void setCexCitaPaciente(CexCitaPaciente cexCitaPaciente) {
		this.cexCitaPaciente = cexCitaPaciente;
	}

	@Column(name = "OBSERVACION", nullable = false, length = 200)
	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Column(name = "USUARIO_REGISTRO", nullable = false, length = 20)
	public String getUsuarioRegistra() {
		return this.usuarioRegistra;
	}

	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", nullable = false, length = 7)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}