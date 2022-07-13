package hts.backend.entity;

import hts.backend.entity.CatMotivoEnvioReferencia;
import hts.backend.entity.CatTipoTrasladoReferencia;
import hts.backend.entity.CatTipoUnidadReferencia;
import hts.backend.entity.NomCatCie10;
import hts.backend.entity.*;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by SASA Desarrollo on 15/06/2017.
 */
@Entity
@Table(name = "core_contrarreferencia")
public class CoreContrarreferencia implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer contrarreferenciaId;
	private Integer urgente;
	private String resumenClinico;
	private String observaciones;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private String servicioEspecialidadExterna;
	private String profesionalExterno;
	private Date fechaElaboracion;

	private CoreReferencia coreReferencia;
	private CatEstatusPeticion catEstatusPeticion;
	private NomCatCie10 nomCatCie10;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTRARREFERENCIA_ID") public Integer getContrarreferenciaId() {
		return contrarreferenciaId;
	}

	public void setContrarreferenciaId(Integer contrarreferenciaId) {
		this.contrarreferenciaId = contrarreferenciaId;
	}

	@Basic @Column(name = "URGENTE") public Integer getUrgente() {
		return urgente;
	}

	public void setUrgente(Integer urgente) {
		this.urgente = urgente;
	}

	@Basic @Column(name = "RESUMEN_CLINICO") public String getResumenClinico() {
		return resumenClinico;
	}

	public void setResumenClinico(String resumenClinico) {
		this.resumenClinico = resumenClinico;
	}

	@Basic @Column(name = "OBSERVACIONES") public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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




	@Basic @Column(name = "PROFESIONAL_EXTERNO")
	public String getProfesionalExterno() {
		return profesionalExterno;
	}

	public void setProfesionalExterno(String profesionalExterno) {
		this.profesionalExterno = profesionalExterno;
	}

	@Basic @Column(name = "FECHA_ELABORACION")
	public Date getFechaElaboracion() {
		return fechaElaboracion;
	}

	public void setFechaElaboracion(Date fechaElaboracion) {
		this.fechaElaboracion = fechaElaboracion;
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
	@JoinColumn(name = "ESTATUS_PETICION_ID")

	public CatEstatusPeticion getCatEstatusPeticion() {
		return catEstatusPeticion;
	}

	public void setCatEstatusPeticion(CatEstatusPeticion catEstatusPeticion) {
		this.catEstatusPeticion = catEstatusPeticion;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CIE_10_ID")
	public NomCatCie10 getNomCatCie10() {
		return nomCatCie10;
	}

	public void setNomCatCie10(NomCatCie10 nomCatCie10) {
		this.nomCatCie10 = nomCatCie10;
	}
}