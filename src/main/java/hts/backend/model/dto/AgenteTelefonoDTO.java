package hts.backend.model.dto;

import java.util.Date;

public class AgenteTelefonoDTO {
	private Integer agenteTelefonoId;
	private CatTipoAgenteDTO catTipoAgente;
	private Integer tipoAgenteId;
	private TelefonoDTO telefono;
	private Integer agenteId;
	private Integer status;
	private Date fechaRegistro;
	private String usuarioCve;
	private String cve;
	private String agenteCve;

	public AgenteTelefonoDTO() {
	}

	public AgenteTelefonoDTO(Integer agenteTelefonoId, CatTipoAgenteDTO catTipoAgente, TelefonoDTO telefono, Integer agenteId, Integer status, Date fechaRegistro, String usuarioCve) {
		this.agenteTelefonoId = agenteTelefonoId;
		this.catTipoAgente = catTipoAgente;
		this.telefono = telefono;
		this.agenteId = agenteId;
		this.status = status;
		this.fechaRegistro = fechaRegistro;
		this.usuarioCve = usuarioCve;
	}

	public AgenteTelefonoDTO(Integer agenteTelefonoId, CatTipoAgenteDTO catTipoAgente, TelefonoDTO telefono, Integer agenteId, Integer status, Date fechaRegistro, String usuarioCve, String cve, String agenteCve) {
		this.agenteTelefonoId = agenteTelefonoId;
		this.catTipoAgente = catTipoAgente;
		this.telefono = telefono;
		this.agenteId = agenteId;
		this.status = status;
		this.fechaRegistro = fechaRegistro;
		this.usuarioCve = usuarioCve;
		this.cve = cve;
		this.agenteCve = agenteCve;
	}

	public Integer getAgenteTelefonoId() {
		return this.agenteTelefonoId;
	}

	public void setAgenteTelefonoId(Integer agenteTelefonoId) {
		this.agenteTelefonoId = agenteTelefonoId;
	}

	public CatTipoAgenteDTO getCatTipoAgente() {
		return this.catTipoAgente;
	}

	public void setCatTipoAgente(CatTipoAgenteDTO catTipoAgente) {
		this.catTipoAgente = catTipoAgente;
	}

	public TelefonoDTO getTelefono() {
		return this.telefono;
	}

	public void setTelefono(TelefonoDTO telefono) {
		this.telefono = telefono;
	}

	public Integer getAgenteId() {
		return this.agenteId;
	}

	public void setAgenteId(Integer agenteId) {
		this.agenteId = agenteId;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUsuarioCve() {
		return this.usuarioCve;
	}

	public void setUsuarioCve(String usuarioCve) {
		this.usuarioCve = usuarioCve;
	}

	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	public String getAgenteCve() {
		return this.agenteCve;
	}

	public void setAgenteCve(String agenteCve) {
		this.agenteCve = agenteCve;
	}

	public Integer getTipoAgenteId() {
		return tipoAgenteId;
	}

	public void setTipoAgenteId(Integer tipoAgenteId) {
		this.tipoAgenteId = tipoAgenteId;
	}
}