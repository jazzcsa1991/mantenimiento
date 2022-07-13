package hts.backend.model.dto;

import java.util.Date;

public class AgenteContactoDTO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer agenteContactoId;
	private CatTipoAgenteDTO catTipoAgente;
	private ContactoDTO contacto;
	private Integer agenteId;
	private Integer status;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private String cve;
	private String agenteCve;

	public Integer getAgenteContactoId() {
		return this.agenteContactoId;
	}

	public void setAgenteContactoId(Integer agenteContactoId) {
		this.agenteContactoId = agenteContactoId;
	}

	public CatTipoAgenteDTO getCatTipoAgente() {
		return this.catTipoAgente;
	}

	public void setCatTipoAgente(CatTipoAgenteDTO catTipoAgente) {
		this.catTipoAgente = catTipoAgente;
	}

	public ContactoDTO getContacto() {
		return this.contacto;
	}

	public void setContacto(ContactoDTO contacto) {
		this.contacto = contacto;
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
