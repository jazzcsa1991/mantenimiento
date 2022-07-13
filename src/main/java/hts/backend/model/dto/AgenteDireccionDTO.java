package hts.backend.model.dto;

import java.util.Date;
public class AgenteDireccionDTO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer agenteDireccionId;
	private CatTipoAgenteDTO catTipoAgente;
	private DireccionDTO direccion;
	private Integer agenteId;
	private Integer status;
	private Date fechaRegistro;
	private String usuarioCve;
	private String cve;
	private String agenteCve;

	public AgenteDireccionDTO() {
	}

	public AgenteDireccionDTO(Integer agenteDireccionId, CatTipoAgenteDTO catTipoAgente, DireccionDTO direccion, Integer agenteId, Integer status, Date fechaRegistro, String usuarioCve) {
		this.agenteDireccionId = agenteDireccionId;
		this.catTipoAgente = catTipoAgente;
		this.direccion = direccion;
		this.agenteId = agenteId;
		this.status = status;
		this.fechaRegistro = fechaRegistro;
		this.usuarioCve = usuarioCve;
	}

	public AgenteDireccionDTO(Integer agenteDireccionId, CatTipoAgenteDTO catTipoAgente, DireccionDTO direccion, Integer agenteId, Integer status, Date fechaRegistro, String usuarioCve, String cve, String agenteCve) {
		this.agenteDireccionId = agenteDireccionId;
		this.catTipoAgente = catTipoAgente;
		this.direccion = direccion;
		this.agenteId = agenteId;
		this.status = status;
		this.fechaRegistro = fechaRegistro;
		this.usuarioCve = usuarioCve;
		this.cve = cve;
		this.agenteCve = agenteCve;
	}

	public Integer getAgenteDireccionId() {
		return this.agenteDireccionId;
	}

	public void setAgenteDireccionId(Integer agenteDireccionId) {
		this.agenteDireccionId = agenteDireccionId;
	}

	public CatTipoAgenteDTO getCatTipoAgente() {
		return this.catTipoAgente;
	}

	public void setCatTipoAgente(CatTipoAgenteDTO catTipoAgente) {
		this.catTipoAgente = catTipoAgente;
	}

	public DireccionDTO getDireccion() {
		return this.direccion;
	}

	public void setDireccion(DireccionDTO direccion) {
		this.direccion = direccion;
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
