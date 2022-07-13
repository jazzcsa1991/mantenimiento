package hts.backend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "core_aseguradora_hospital")
public class CoreAseguradoraHospital implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer aseguradoraHospitalId;
	private Integer aseguradoraId;
	private Integer hospitalId;
	private Integer estatus;
	private String usuarioRegistro;
	private Date fechaRegistro;
	private AdmCatAseguradora admCatAseguradora;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ASEGURADORA_HOSPITAL_ID", nullable = false, precision = 0) public Integer getAseguradoraHospitalId() {
		return aseguradoraHospitalId;
	}

	public void setAseguradoraHospitalId(Integer aseguradoraHospitalId) {
		this.aseguradoraHospitalId = aseguradoraHospitalId;
	}

	@Basic @Column(name = "ASEGURADORA_ID", nullable = false, precision = 0) public Integer getAseguradoraId() {
		return aseguradoraId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ASEGURADORA_ID", updatable = false, insertable = false)
	public AdmCatAseguradora getAdmCatAseguradora() {
		return this.admCatAseguradora;
	}

	public void setAdmCatAseguradora(AdmCatAseguradora admCatAseguradora) {
		this.admCatAseguradora = admCatAseguradora;
	}

	public void setAseguradoraId(Integer aseguradoraId) {
		this.aseguradoraId = aseguradoraId;
	}

	@Basic @Column(name = "HOSPITAL_ID", nullable = false, precision = 0) public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	@Basic @Column(name = "ESTATUS", nullable = false, precision = 0) public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@Basic @Column(name = "USUARIO_REGISTRO", nullable = false, length = 20) public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Basic @Column(name = "FECHA_REGISTRO", nullable = false) public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


}
