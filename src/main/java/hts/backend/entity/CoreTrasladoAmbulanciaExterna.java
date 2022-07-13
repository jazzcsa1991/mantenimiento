package hts.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "core_traslado_ambulancia_externa")
public class CoreTrasladoAmbulanciaExterna  implements Serializable {
	private Integer trasladoAmbulanciaExtId;
	private Integer referenciaExternaId;
	private String observaciones;
	private Timestamp fechaSalida;
	private Timestamp fechaRegreso;
	private Timestamp fechaRegistro;
	private String usuarioRegistro;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRASLADO_AMBULANCIA_EXT_ID")
	public Integer getTrasladoAmbulanciaExtId() {
		return trasladoAmbulanciaExtId;
	}

	public void setTrasladoAmbulanciaExtId(Integer trasladoAmbulanciaExtId) {
		this.trasladoAmbulanciaExtId = trasladoAmbulanciaExtId;
	}

	@Basic
	@Column(name = "REFERENCIA_EXTERNA_ID")
	public Integer getReferenciaExternaId() {
		return referenciaExternaId;
	}

	public void setReferenciaExternaId(Integer referenciaExternaId) {
		this.referenciaExternaId = referenciaExternaId;
	}

	@Basic
	@Column(name = "OBSERVACIONES")
	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Basic
	@Column(name = "FECHA_SALIDA")
	public Timestamp getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Timestamp fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	@Basic
	@Column(name = "FECHA_REGRESO")
	public Timestamp getFechaRegreso() {
		return fechaRegreso;
	}

	public void setFechaRegreso(Timestamp fechaRegreso) {
		this.fechaRegreso = fechaRegreso;
	}

	@Basic
	@Column(name = "FECHA_REGISTRO")
	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic
	@Column(name = "USUARIO_REGISTRO")
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}
}
