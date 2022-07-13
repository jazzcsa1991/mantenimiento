package hts.backend.entity;


import hts.backend.entity.PacPaciente;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by SASA Desarrollo on 15/06/2017.
 */
@Entity
@Table(name = "core_traslado_ambulancia")
public class CoreTrasladoAmbulancia implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer trasladoAmbulanciaId;
	private String observaciones;
	private Date fechaSalida;
	private Date fechaRegreso;
	private Date fechaRegistro;
	private String usuarioRegistro;

	private CoreReferencia coreReferencia;
	private PacPaciente pacPaciente;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRASLADO_AMBULANCIA_ID") public Integer getTrasladoAmbulanciaId() {
		return trasladoAmbulanciaId;
	}

	public void setTrasladoAmbulanciaId(Integer trasladoAmbulanciaId) {
		this.trasladoAmbulanciaId = trasladoAmbulanciaId;
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


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REFERENCIA_ID")

	public CoreReferencia getCoreReferencia() {
		return coreReferencia;
	}

	public void setCoreReferencia(CoreReferencia coreReferencia) {
		this.coreReferencia = coreReferencia;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PACIENTE")
	public PacPaciente getPacPaciente() {
		return pacPaciente;
	}

	public void setPacPaciente(PacPaciente pacPaciente) {
		this.pacPaciente = pacPaciente;
	}

}
