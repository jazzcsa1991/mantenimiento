package hts.backend.model.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CatTipoAgenteDTO implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Integer tipoAgenteId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer status;
	private Date fechaRegistro;
	private String usuarioRegistra;
	private Set<AgenteTelefonoDTO> agenteTelefonos = new HashSet<AgenteTelefonoDTO>(0);
//	private Set<AgenteCorreo> agenteCorreos = new HashSet<AgenteCorreo>(0);
//	private Set<AgenteDireccion> agenteDireccions = new HashSet<AgenteDireccion>(0);
	private Set<AgenteContactoDTO> agenteContactos = new HashSet<AgenteContactoDTO>(0);


	public CatTipoAgenteDTO() {

	}

	public CatTipoAgenteDTO(Integer tipoAgenteId) {
		this.tipoAgenteId=tipoAgenteId;
	}

	public CatTipoAgenteDTO(Integer tipoAgenteId, String cve, String nombre, String descripcion, Integer status,
			Date fechaRegistro, String usuarioRegistra) {
		this.tipoAgenteId = tipoAgenteId;
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.status = status;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistra = usuarioRegistra;
	}

	public CatTipoAgenteDTO(Integer tipoAgenteId, String cve, String nombre, String descripcion, Integer status,
			Date fechaRegistro, String usuarioRegistra, Set<AgenteTelefonoDTO> agenteTelefonos
//			,Set<AgenteCorreo> agenteCorreos, Set<AgenteDireccion> agenteDireccions
			) {
		this.tipoAgenteId = tipoAgenteId;
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.status = status;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistra = usuarioRegistra;
		this.agenteTelefonos = agenteTelefonos;
//		this.agenteCorreos = agenteCorreos;
//		this.agenteDireccions = agenteDireccions;
	}

	public CatTipoAgenteDTO(Integer tipoAgenteId, String cve, String nombre, String descripcion, Integer status,
			Date fechaRegistro, String usuarioRegistra, Set<AgenteTelefonoDTO> agenteTelefonos,Set<AgenteContactoDTO> agenteContactos
//			,Set<AgenteCorreo> agenteCorreos, Set<AgenteDireccion> agenteDireccions
			) {
		this.tipoAgenteId = tipoAgenteId;
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.status = status;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistra = usuarioRegistra;
		this.agenteTelefonos = agenteTelefonos;
//		this.agenteCorreos = agenteCorreos;
//		this.agenteDireccions = agenteDireccions;
		this.agenteContactos=agenteContactos;
	}

	public Integer getTipoAgenteId() {
		return this.tipoAgenteId;
	}

	public void setTipoAgenteId(Integer tipoAgenteId) {
		this.tipoAgenteId = tipoAgenteId;
	}

	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public String getUsuarioRegistra() {
		return this.usuarioRegistra;
	}

	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}

	public Set<AgenteTelefonoDTO> getAgenteTelefonos() {
		return this.agenteTelefonos;
	}

	public void setAgenteTelefonos(Set<AgenteTelefonoDTO> agenteTelefonos) {
		this.agenteTelefonos = agenteTelefonos;
	}

	public Set<AgenteContactoDTO> getAgenteContactos() {
		return agenteContactos;
	}

	public void setAgenteContactos(Set<AgenteContactoDTO> agenteContactos) {
		this.agenteContactos = agenteContactos;
	}

//	public Set<AgenteCorreo> getAgenteCorreos() {
//		return this.agenteCorreos;
//	}
//
//	public void setAgenteCorreos(Set<AgenteCorreo> agenteCorreos) {
//		this.agenteCorreos = agenteCorreos;
//	}
//
//	public Set<AgenteDireccion> getAgenteDireccions() {
//		return this.agenteDireccions;
//	}
//
//	public void setAgenteDireccions(Set<AgenteDireccion> agenteDireccions) {
//		this.agenteDireccions = agenteDireccions;
//	}

}
