package hts.backend.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "responsable_hospital")

public class ResponsableHospital implements Serializable{

	private Integer responsableHospitalId;
	private Integer usuarioId;
	private Integer estadoId;
	private Integer rissId;
	private Integer jurisdiccionId;
	private String usuarioRegistro;
	private Date fechaRegistro;
	private Integer hospitalId;
	private Integer idClues;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "responsable_hospital_id")
	public Integer getResponsableHospitalId() {
		return responsableHospitalId;
	}

	public void setResponsableHospitalId(Integer responsableHospitalId) {
		this.responsableHospitalId = responsableHospitalId;
	}

	@Basic
	@Column(name = "hospital_id")
	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	@Basic
	@Column(name = "id_clues")
	public Integer getIdClues() {
		return idClues;
	}

	public void setIdClues(Integer idClues) {
		this.idClues = idClues;
	}

	@Basic
	@Column(name = "id_usuario")
	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	@Basic
	@Column(name = "id_estado")
	public Integer getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Integer estadoId) {
		this.estadoId = estadoId;
	}

	@Basic
	@Column(name = "id_riss")
	public Integer getRissId() {
		return rissId;
	}

	public void setRissId(Integer rissId) {
		this.rissId = rissId;
	}

	@Basic
	@Column(name = "id_jurisdiccion")
	public Integer getJurisdiccionId() {
		return jurisdiccionId;
	}

	public void setJurisdiccionId(Integer jurisdiccionId) {
		this.jurisdiccionId = jurisdiccionId;
	}

	@Basic
	@Column(name = "us_registro")
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Basic
	@Column(name = "fe_registro")
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


}
