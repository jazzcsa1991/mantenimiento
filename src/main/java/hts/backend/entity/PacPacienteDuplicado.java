package hts.backend.entity;


import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "pac_paciente_duplicado")
public class PacPacienteDuplicado implements java.io.Serializable {
	private Integer idDuplicado;
	private PacPaciente pacPaciente;
	private Integer idPaciente;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private String folio;
	private Integer estatus;
	private Date fusionFecha;
	private String fusionUsuario;
	private Integer fusionIdPaciente;

	public PacPacienteDuplicado() {
	}

	public PacPacienteDuplicado(Integer idPaciente, String folio) {
		this.idPaciente = idPaciente;
		this.fechaRegistro = new Date();
		this.usuarioRegistro = SecurityContextHolder.getContext().getAuthentication().getName();
		this.folio = folio;
		this.estatus = 1;
		this.fusionFecha = null;
		this.fusionUsuario = null;
		this.fusionIdPaciente = null;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DUPLICADO", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getIdDuplicado() {
		return this.idDuplicado;
	}

	public void setIdDuplicado(Integer idDuplicado) {
		this.idDuplicado = idDuplicado;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PACIENTE", nullable = true, insertable = false, updatable = false)
	public PacPaciente getPacPaciente() {
		return this.pacPaciente;
	}

	public void setPacPaciente(PacPaciente pacPaciente) {
		this.pacPaciente = pacPaciente;
	}


	@Column(name = "ID_PACIENTE", nullable = false)
	public Integer getIdPaciente() {
		return this.idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", nullable = false, length = 7)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRe) {
		this.fechaRegistro = fechaRe;
	}


	@Column(name = "USUARIO_REGISTRO", nullable = false, length = 50)
	public String getUsuarioRegistro() {
		return this.usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRe) {
		this.usuarioRegistro = usuarioRe;
	}


	@Column(name = "FOLIO", nullable = false, length = 50)
	public String getFolio() {
		return this.folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}


	@Column(name = "ESTATUS", nullable = false, length = 1)
	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}


	@Column(name = "FUSION_FECHA")
	public Date getFusionFecha() {
		return fusionFecha;
	}

	public void setFusionFecha(Date fusionFecha) {
		this.fusionFecha = fusionFecha;
	}


	@Column(name = "FUSION_USUARIO")
	public String getFusionUsuario() {
		return fusionUsuario;
	}

	public void setFusionUsuario(String fusionUsuario) {
		this.fusionUsuario = fusionUsuario;
	}


	@Column(name = "FUSION_ID_PACIENTE")
	public Integer getFusionIdPaciente() {
		return fusionIdPaciente;
	}

	public void setFusionIdPaciente(Integer fusionIdPaciente) {
		this.fusionIdPaciente = fusionIdPaciente;
	}
}
