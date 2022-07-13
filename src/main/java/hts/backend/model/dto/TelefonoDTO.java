package hts.backend.model.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TelefonoDTO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer telefonoId;
	private CatTipoTelefonoDTO catTipoTelefono;
	private String telefono;
	private Integer status;
	private Integer agenteId;
	private String cve;
	private String usuarioCve;
	private Date fechaRegistro;
	private Set<AgenteTelefonoDTO> agenteTelefonos = new HashSet<AgenteTelefonoDTO>(0);

	public TelefonoDTO() {
	}

	public TelefonoDTO(Integer telefonoId, CatTipoTelefonoDTO catTipoTelefono, String telefono, Integer status,
			String usuarioCve, Date fechaRegistro) {
		this.telefonoId = telefonoId;
		this.catTipoTelefono = catTipoTelefono;
		this.telefono = telefono;
		this.status = status;
		this.usuarioCve = usuarioCve;
		this.fechaRegistro = fechaRegistro;
	}

	public TelefonoDTO(Integer telefonoId, CatTipoTelefonoDTO catTipoTelefono, String telefono, Integer status,
			String cve, String usuarioCve, Date fechaRegistro, Set<AgenteTelefonoDTO> agenteTelefonos) {
		this.telefonoId = telefonoId;
		this.catTipoTelefono = catTipoTelefono;
		this.telefono = telefono;
		this.status = status;
		this.cve = cve;
		this.usuarioCve = usuarioCve;
		this.fechaRegistro = fechaRegistro;
		this.agenteTelefonos = agenteTelefonos;
	}


	public Integer getAgenteId() {
		return agenteId;
	}

	public void setAgenteId(Integer agenteId) {
		this.agenteId = agenteId;
	}

	public Integer getTelefonoId() {
		return this.telefonoId;
	}

	public void setTelefonoId(Integer telefonoId) {
		this.telefonoId = telefonoId;
	}

	public CatTipoTelefonoDTO getCatTipoTelefono() {
		return this.catTipoTelefono;
	}

	public void setCatTipoTelefono(CatTipoTelefonoDTO catTipoTelefono) {
		this.catTipoTelefono = catTipoTelefono;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public Set<AgenteTelefonoDTO> getAgenteTelefonos() {
		return this.agenteTelefonos;
	}

	public void setAgenteTelefonos(Set<AgenteTelefonoDTO> agenteTelefonos) {
		this.agenteTelefonos = agenteTelefonos;
	}

}
