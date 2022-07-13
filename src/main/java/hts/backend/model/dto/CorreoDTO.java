package hts.backend.model.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CorreoDTO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer correoId;
	private String correo;
	private Integer status;
	private Integer agenteId;
	private String cve;
	private String usuarioCve;
	private Date fechaRegistro;
	private Set<AgenteCorreoDTO> agenteCorreos = new HashSet<AgenteCorreoDTO>(0);

	public CorreoDTO() {
	}

	public CorreoDTO(Integer correoId, String correo, Integer status, String usuarioCve, Date fechaRegistro) {
		this.correoId = correoId;
		this.correo = correo;
		this.status = status;
		this.usuarioCve = usuarioCve;
		this.fechaRegistro = fechaRegistro;
	}

	public CorreoDTO(Integer correoId, String correo, Integer status, String cve, String usuarioCve,
			Date fechaRegistro, Set<AgenteCorreoDTO> agenteCorreos) {
		this.correoId = correoId;
		this.correo = correo;
		this.status = status;
		this.cve = cve;
		this.usuarioCve = usuarioCve;
		this.fechaRegistro = fechaRegistro;
		this.agenteCorreos = agenteCorreos;
	}

	public Integer getAgenteId() {
		return agenteId;
	}

	public void setAgenteId(Integer agenteId) {
		this.agenteId = agenteId;
	}

	public Integer getCorreoId() {
		return this.correoId;
	}

	public void setCorreoId(Integer correoId) {
		this.correoId = correoId;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	public String getUsuarioCve() {
		return this.usuarioCve;
	}

	public void setUsuarioCve(String usuarioCve) {
		this.usuarioCve = usuarioCve;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Set<AgenteCorreoDTO> getAgenteCorreos() {
		return this.agenteCorreos;
	}

	public void setAgenteCorreos(Set<AgenteCorreoDTO> agenteCorreos) {
		this.agenteCorreos = agenteCorreos;
	}

}

