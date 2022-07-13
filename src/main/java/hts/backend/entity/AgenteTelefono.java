package hts.backend.entity;


import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "agente_telefono")
public class AgenteTelefono implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer agenteTelefonoId;
	private CatTipoAgente catTipoAgente;
	private Integer tipoAgenteId;
	private Telefono telefono;
	private Integer agenteId;
	private Integer status;
	private Date fechaRegistro;
	private String usuarioCve;
	private String cve;
	private String agenteCve;

	public AgenteTelefono() {
	}

	public static AgenteTelefono TelefonoPaciente(Telefono telefono, Integer idPaciente) {
		AgenteTelefono at = new AgenteTelefono();

		at.setTipoAgenteId(2);
		at.setTelefono(telefono);
		at.setAgenteId(idPaciente);
		at.setCve(null);
		at.setAgenteCve(null);

		at.setFechaRegistro(new Date());
		at.setUsuarioCve(SecurityContextHolder.getContext().getAuthentication().getName());

		at.setStatus(1);

		return at;
	}

	public static AgenteTelefono TelefonoContactoPaciente(Telefono telefono, Integer idContacto) {
		AgenteTelefono at = new AgenteTelefono();

		at.setTipoAgenteId(5);
		at.setTelefono(telefono);
		at.setAgenteId(idContacto);
		at.setCve(null);
		at.setAgenteCve(null);

		at.setFechaRegistro(new Date());
		at.setUsuarioCve(SecurityContextHolder.getContext().getAuthentication().getName());

		at.setStatus(1);

		return at;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AGENTE_TELEFONO_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getAgenteTelefonoId() {
		return this.agenteTelefonoId;
	}

	public void setAgenteTelefonoId(Integer agenteTelefonoId) {
		this.agenteTelefonoId = agenteTelefonoId;
	}


	@Column(name = "AGENTE_ID", nullable = false, precision = 22, scale = 0)
	public Integer getAgenteId() {
		return this.agenteId;
	}

	public void setAgenteId(Integer agenteId) {
		this.agenteId = agenteId;
	}


	@Column(name = "ESTATUS", nullable = false, precision = 22, scale = 0)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", nullable = false, length = 7)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@Column(name = "USUARIO_REGISTRO", nullable = false, length = 20)
	public String getUsuarioCve() {
		return this.usuarioCve;
	}

	public void setUsuarioCve(String usuarioCve) {
		this.usuarioCve = usuarioCve;
	}


	@Column(name = "CVE", length = 50)
	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}


	@Column(name = "AGENTE_CVE", length = 20)
	public String getAgenteCve() {
		return this.agenteCve;
	}

	public void setAgenteCve(String agenteCve) {
		this.agenteCve = agenteCve;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_AGENTE_ID", nullable = false, insertable = false, updatable = false)
	public CatTipoAgente getCatTipoAgente() {
		return this.catTipoAgente;
	}

	public void setCatTipoAgente(CatTipoAgente catTipoAgente) {
		this.catTipoAgente = catTipoAgente;
	}


	@Column(name = "TIPO_AGENTE_ID")
	public Integer getTipoAgenteId() {
		return tipoAgenteId;
	}

	public void setTipoAgenteId(Integer tipoAgenteId) {
		this.tipoAgenteId = tipoAgenteId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TELEFONO_ID", nullable = false)
	public Telefono getTelefono() {
		return this.telefono;
	}

	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}


}
