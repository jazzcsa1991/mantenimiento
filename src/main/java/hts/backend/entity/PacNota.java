package hts.backend.entity;

// Generated 24/03/2017 11:54:30 AM by Hibernate Tools 5.2.0.CR1

import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;
import javax.persistence.*;

/**
 * PacNota generated by hbm2java
 */
@Entity
@Table(name = "pac_nota")
public class PacNota implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer notaId;
	private PacPaciente pacPaciente;
	private Integer pacienteId;
	private String descripcion;
	private Date fechaRegistro;
	private String usuarioRegistra;
	private Integer status;

	public PacNota() {
	}

	// Constructor para registro de notas
	public PacNota(Integer pacienteId, String descripcion) {
		this.pacienteId = pacienteId;
		this.descripcion = descripcion;

		this.fechaRegistro = new Date();
		this.usuarioRegistra = SecurityContextHolder.getContext().getAuthentication().getName();
		this.status = 1;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NOTA_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getNotaId() {
		return this.notaId;
	}

	public void setNotaId(Integer notaId) {
		this.notaId = notaId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PACIENTE", updatable = false, insertable = false)
	public PacPaciente getPacPaciente() {
		return this.pacPaciente;
	}

	public void setPacPaciente(PacPaciente pacPaciente) {
		this.pacPaciente = pacPaciente;
	}


	@Column(name = "ID_PACIENTE")
	public Integer getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Integer pacienteId) {
		this.pacienteId = pacienteId;
	}


	@Column(name = "DESCRIPCION", nullable = false, length = 20)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", nullable = false, length = 7)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@Column(name = "USUARIO_REGISTRO", nullable = false, length = 18)
	public String getUsuarioRegistra() {
		return this.usuarioRegistra;
	}

	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}


	@Column(name = "ESTATUS", precision = 22, scale = 0)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
