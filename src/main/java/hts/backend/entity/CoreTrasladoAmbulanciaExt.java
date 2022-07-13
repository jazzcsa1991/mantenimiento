package hts.backend.entity;

import hts.backend.entity.CoreReferenciasExternas;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by SASA Desarrollo on 22/06/2017.
 */
@Entity
@Table(name = "core_traslado_ambulancia_ext")
public class CoreTrasladoAmbulanciaExt  implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer trasladoAmbulanciaExtId;
	private String observaciones;
	private Date fechaSalida;
	private Date fechaRegreso;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private CoreReferenciasExternas coreReferenciasExternas;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRASLADO_AMBULANCIA_EXT_ID") public Integer getTrasladoAmbulanciaExtId() {
		return trasladoAmbulanciaExtId;
	}

	public void setTrasladoAmbulanciaExtId(Integer trasladoAmbulanciaExtId) {
		this.trasladoAmbulanciaExtId = trasladoAmbulanciaExtId;
	}

	@Basic @Column(name = "OBSERVACIONES") public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Basic @Column(name = "FECHA_SALIDA") public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	@Basic @Column(name = "FECHA_REGRESO") public Date getFechaRegreso() {
		return fechaRegreso;
	}

	public void setFechaRegreso(Date fechaRegreso) {
		this.fechaRegreso = fechaRegreso;
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


	@ManyToOne
	@JoinColumn(name = "REFERENCIA_EXTERNA_ID")
	public CoreReferenciasExternas getCoreReferenciasExternas() {
		return coreReferenciasExternas;
	}

	public void setCoreReferenciasExternas(CoreReferenciasExternas coreReferenciasExternas) {
		this.coreReferenciasExternas = coreReferenciasExternas;
	}
}
