package hts.backend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bqr_alta_administrativa")
public class BqrAltaAdministrativa implements java.io.Serializable  {
	private static final Long serialVersionUID = 1L;
	private Integer altaAdministrativaId;
	private Integer eventoId;
	private Integer destinoEgresoHosId;
	private Integer transEntradaSalidaId;
	private String observaciones;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Date fechaAltaAdministrativa;
	private Integer estatus;
	private Date fechaAnulacion;
	private String usuarioAnulacion;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ALTA_ADMINISTRATIVA_ID", nullable = false, precision = 0) public Integer getAltaAdministrativaId() {
		return altaAdministrativaId;
	}

	public void setAltaAdministrativaId(Integer altaAdministrativaId) {
		this.altaAdministrativaId = altaAdministrativaId;
	}

	@Basic @Column(name = "EVENTO_ID", nullable = true, precision = 0) public Integer getEventoId() {
		return eventoId;
	}

	public void setEventoId(Integer eventoId) {
		this.eventoId = eventoId;
	}

	@Basic @Column(name = "DESTINO_EGRESO_HOS_ID", nullable = false, precision = 0) public Integer getDestinoEgresoHosId() {
		return destinoEgresoHosId;
	}

	public void setDestinoEgresoHosId(Integer destinoEgresoHosId) {
		this.destinoEgresoHosId = destinoEgresoHosId;
	}

	@Basic @Column(name = "TRANS_ENTRADA_SALIDA_ID", nullable = false, precision = 0) public Integer getTransEntradaSalidaId() {
		return transEntradaSalidaId;
	}

	public void setTransEntradaSalidaId(Integer transEntradaSalidaId) {
		this.transEntradaSalidaId = transEntradaSalidaId;
	}

	@Basic @Column(name = "OBSERVACIONES", nullable = false, length = 1000) public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Basic @Column(name = "FECHA_REGISTRO", nullable = true) public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO", nullable = true, length = 20) public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Basic @Column(name = "FECHA_ALTA_ADMINISTRATIVA", nullable = false) public Date getFechaAltaAdministrativa() {
		return fechaAltaAdministrativa;
	}

	public void setFechaAltaAdministrativa(Date fechaAltaAdministrativa) {
		this.fechaAltaAdministrativa = fechaAltaAdministrativa;
	}

	@Basic @Column(name = "ESTATUS", nullable = false, precision = 0) public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@Basic @Column(name = "FECHA_ANULACION", nullable = true) public Date getFechaAnulacion() {
		return fechaAnulacion;
	}

	public void setFechaAnulacion(Date fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
	}

	@Basic @Column(name = "USUARIO_ANULACION", nullable = true, length = 50) public String getUsuarioAnulacion() {
		return usuarioAnulacion;
	}

	public void setUsuarioAnulacion(String usuarioAnulacion) {
		this.usuarioAnulacion = usuarioAnulacion;
	}

}
