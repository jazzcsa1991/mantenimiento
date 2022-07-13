package hts.backend.model.dto;

import java.util.Date;

public class PacNotaDTO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer notaId;
	private PacPacienteDTO pacPaciente;
	private String descripcion;
	private Date fechaRegistro;
	private String usuarioRegistra;
	private Integer status;

	public PacNotaDTO() {
	}

	public PacNotaDTO(Integer notaId) {
		this.notaId = notaId;
	}

	public PacNotaDTO(Integer notaId, String descripcion, Date fechaRegistro, String usuarioRegistra) {
		this.notaId = notaId;
		this.descripcion = descripcion;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistra = usuarioRegistra;
	}

	public PacNotaDTO(Integer notaId, PacPacienteDTO pacPaciente, String descripcion, Date fechaRegistro,
			String usuarioRegistra) {
		this.notaId = notaId;
		this.pacPaciente = pacPaciente;
		this.descripcion = descripcion;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistra = usuarioRegistra;
	}

	public Integer getNotaId() {
		return this.notaId;
	}

	public void setNotaId(Integer notaId) {
		this.notaId = notaId;
	}

	public PacPacienteDTO getPacPaciente() {
		return this.pacPaciente;
	}

	public void setPacPaciente(PacPacienteDTO pacPaciente) {
		this.pacPaciente = pacPaciente;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUsuarioRegistra() {
		return this.usuarioRegistra;
	}

	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
