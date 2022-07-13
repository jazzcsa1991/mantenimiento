package hts.backend.entity;


import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "agente_direccion")
public class AgenteDireccion implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer agenteDireccionId;
	private CatTipoAgente catTipoAgente;
	private Integer tipoAgenteId;
	private Direccion direccion;
	private Integer agenteId;
	private Integer status;
	private Date fechaRegistro;
	private String usuarioCve;
	private String cve;
	private String agenteCve;

	public AgenteDireccion() {
	}

	public static AgenteDireccion DireccionPaciente(Direccion direccion, int idPaciente) {
		AgenteDireccion obj = new AgenteDireccion();

		obj.setTipoAgenteId(2);
		obj.setDireccion(direccion);
		obj.setAgenteId(idPaciente);
		obj.setStatus(1);
		obj.setFechaRegistro(new Date());
		obj.setUsuarioCve(SecurityContextHolder.getContext().getAuthentication().getName());
		obj.setCve(null);
		obj.setAgenteCve(null);

		return obj;
	}

	public static AgenteDireccion DireccionContactoPaciente(Direccion direccion, int idContacto) {
		AgenteDireccion obj = new AgenteDireccion();

		obj.setTipoAgenteId(5);
		obj.setDireccion(direccion);
		obj.setAgenteId(idContacto);
		obj.setStatus(1);
		obj.setFechaRegistro(new Date());
		obj.setUsuarioCve(SecurityContextHolder.getContext().getAuthentication().getName());
		obj.setCve(null);
		obj.setAgenteCve(null);

		return obj;
	}

	public static AgenteDireccion DireccionEmpleado(Direccion direccion, int idPaciente) {
		AgenteDireccion obj = new AgenteDireccion();

		obj.setTipoAgenteId(1);
		obj.setDireccion(direccion);
		obj.setAgenteId(idPaciente);
		obj.setStatus(1);
		obj.setFechaRegistro(new Date());
		obj.setUsuarioCve(SecurityContextHolder.getContext().getAuthentication().getName());
		obj.setCve(null);
		obj.setAgenteCve(null);

		return obj;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AGENTE_DIRECCION_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getAgenteDireccionId() {
		return this.agenteDireccionId;
	}

	public void setAgenteDireccionId(Integer agenteDireccionId) {
		this.agenteDireccionId = agenteDireccionId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_AGENTE_ID", updatable = false, insertable = false)
	public CatTipoAgente getCatTipoAgente() {
		return this.catTipoAgente;
	}

	public void setCatTipoAgente(CatTipoAgente catTipoAgente) {
		this.catTipoAgente = catTipoAgente;
	}


	@Column(name = "TIPO_AGENTE_ID", nullable = false)
	public Integer getTipoAgenteId() {
		return tipoAgenteId;
	}

	public void setTipoAgenteId(Integer tipoAgenteId) {
		this.tipoAgenteId = tipoAgenteId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DIRECCION_ID", nullable = false)
	public Direccion getDireccion() {
		return this.direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
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
}
