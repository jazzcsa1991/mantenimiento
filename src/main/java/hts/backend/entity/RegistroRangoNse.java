package hts.backend.entity;


import hts.backend.entity.AdmHospital;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Lenovo3 on 22/05/2017.
 */
@Entity
@Table(name = "registro_rango_nse")
public class RegistroRangoNse implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer registroRangoNseId;
	private String descripcionNse;
	private Integer limiteInferior;
	private Integer limiteSuperior;
	private Integer defaultNse;
	private Integer estatusNse;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private AdmHospital admHospitalByHospitalId;
	private Integer hospitalId;

	private PacConvenioAseguradora convenioAseguradoraId;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CONVENIO_ASEGURADORA_ID")
	public PacConvenioAseguradora getConvenioAseguradoraId() {
		return convenioAseguradoraId;
	}

	public void setConvenioAseguradoraId(PacConvenioAseguradora convenioAseguradoraId) {
		this.convenioAseguradoraId = convenioAseguradoraId;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REGISTRO_RANGO_NSE_ID", nullable = false, length = 10) public Integer getRegistroRangoNseId() {
		return registroRangoNseId;
	}

	public void setRegistroRangoNseId(Integer registroRangoNseId) {
		this.registroRangoNseId = registroRangoNseId;
	}

	@Basic @Column(name = "DESCRIPCION_NSE", nullable = false, length = 100) public String getDescripcionNse() {
		return descripcionNse;
	}

	public void setDescripcionNse(String descripcionNse) {
		this.descripcionNse = descripcionNse;
	}

	@Basic @Column(name = "LIMITE_INFERIOR", nullable = false) public Integer getLimiteInferior() {
		return limiteInferior;
	}

	public void setLimiteInferior(Integer limiteInferior) {
		this.limiteInferior = limiteInferior;
	}

	@Basic @Column(name = "LIMITE_SUPERIOR", nullable = false) public Integer getLimiteSuperior() {
		return limiteSuperior;
	}

	public void setLimiteSuperior(Integer limiteSuperior) {
		this.limiteSuperior = limiteSuperior;
	}

	@Basic @Column(name = "DEFAULT_NSE", nullable = false) public Integer getDefaultNse() {
		return defaultNse;
	}


	public void setDefaultNse(Integer defaultNse) {
		this.defaultNse = defaultNse;
	}

	@Basic @Column(name = "ESTATUS_NSE", nullable = false) public Integer getEstatusNse() {
		return estatusNse;
	}

	public void setEstatusNse(Integer estatusNse) {
		this.estatusNse = estatusNse;
	}

	@Basic @Column(name = "FECHA_REGISTRO", nullable = false, length = 50) public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO", nullable = false, length = 50) public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}


	@ManyToOne @JoinColumn(name = "HOSPITAL_ID", referencedColumnName = "HOSPITAL_ID", updatable = false, insertable = false) public AdmHospital getAdmHospitalByHospitalId() {
		return admHospitalByHospitalId;
	}

	public void setAdmHospitalByHospitalId(AdmHospital admHospitalByHospitalId) {
		this.admHospitalByHospitalId = admHospitalByHospitalId;
	}

	@Basic
	@Column(name = "HOSPITAL_ID", nullable = false)
	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
}
