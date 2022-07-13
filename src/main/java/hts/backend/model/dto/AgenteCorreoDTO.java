package hts.backend.model.dto;

import java.util.Date;

public class AgenteCorreoDTO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer agenteCorreoId;
	private CatTipoAgenteDTO catTipoAgente;
	private CorreoDTO correo;
	private Integer agenteId;
	private Integer status;
	private Date fechaRegistro;
	private String usuarioCve;
	private String cve;
	private String agenteCve;

	public AgenteCorreoDTO() {
	}

	public AgenteCorreoDTO(Integer agenteCorreoId, CatTipoAgenteDTO catTipoAgente, CorreoDTO correo, Integer agenteId,
			Integer status, Date fechaRegistro, String usuarioCve) {
		this.agenteCorreoId = agenteCorreoId;
		this.catTipoAgente = catTipoAgente;
		this.correo = correo;
		this.agenteId = agenteId;
		this.status = status;
		this.fechaRegistro = fechaRegistro;
		this.usuarioCve = usuarioCve;
	}

	public AgenteCorreoDTO(Integer agenteCorreoId, CatTipoAgenteDTO catTipoAgente, CorreoDTO correo, Integer agenteId,
			Integer status, Date fechaRegistro, String usuarioCve, String cve, String agenteCve) {
		this.agenteCorreoId = agenteCorreoId;
		this.catTipoAgente = catTipoAgente;
		this.correo = correo;
		this.agenteId = agenteId;
		this.status = status;
		this.fechaRegistro = fechaRegistro;
		this.usuarioCve = usuarioCve;
		this.cve = cve;
		this.agenteCve = agenteCve;
	}


	public Integer getAgenteCorreoId() {
		return this.agenteCorreoId;
	}

	public void setAgenteCorreoId(Integer agenteCorreoId) {
		this.agenteCorreoId = agenteCorreoId;
	}


	public CatTipoAgenteDTO getCatTipoAgente() {
		return this.catTipoAgente;
	}

	public void setCatTipoAgente(CatTipoAgenteDTO catTipoAgente) {
		this.catTipoAgente = catTipoAgente;
	}


	public CorreoDTO getCorreo() {
		return this.correo;
	}

	public void setCorreo(CorreoDTO correo) {
		this.correo = correo;
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

}

