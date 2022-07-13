package hts.backend.model.dto;

import java.util.Date;

public class AgenteDocumentoDTO implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Integer agenteDocumentoId;
	private CatTipoAgenteDTO catTipoAgente;
	private DocumentoDTO documento;
	private Integer agenteId;
	private Integer status;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private String cve;
	private String agenteCve;

	public AgenteDocumentoDTO() {
	}

	public AgenteDocumentoDTO(Integer agenteDocumentoId, CatTipoAgenteDTO catTipoAgente, Integer agenteId,
			Integer status, Date fechaRegistro, String usuarioRegistro) {
		this.agenteDocumentoId = agenteDocumentoId;
		this.catTipoAgente = catTipoAgente;
		this.agenteId = agenteId;
		this.status = status;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistro = usuarioRegistro;
	}

	public AgenteDocumentoDTO(Integer agenteDocumentoId, CatTipoAgenteDTO catTipoAgente, DocumentoDTO documento,
			Integer agenteId, Integer status, Date fechaRegistro, String usuarioRegistro, String cve,
			String agenteCve) {
		this.agenteDocumentoId = agenteDocumentoId;
		this.catTipoAgente = catTipoAgente;
		this.documento = documento;
		this.agenteId = agenteId;
		this.status = status;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistro = usuarioRegistro;
		this.cve = cve;
		this.agenteCve = agenteCve;
	}

	public Integer getAgenteDocumentoId() {
		return this.agenteDocumentoId;
	}

	public void setAgenteDocumentoId(Integer agenteDocumentoId) {
		this.agenteDocumentoId = agenteDocumentoId;
	}

	public CatTipoAgenteDTO getCatTipoAgente() {
		return this.catTipoAgente;
	}

	public void setCatTipoAgente(CatTipoAgenteDTO catTipoAgente) {
		this.catTipoAgente = catTipoAgente;
	}

	public DocumentoDTO getDocumento() {
		return this.documento;
	}

	public void setDocumento(DocumentoDTO documento) {
		this.documento = documento;
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

	public String getUsuarioRegistro() {
		return this.usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
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
