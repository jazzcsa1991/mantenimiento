package hts.backend.entity;


import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "agente_contacto")
public class AgenteContacto implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer agenteContactoId;
	private CatTipoAgente catTipoAgente;
	private Integer tipoAgenteId;
	private Contacto contacto;
	private Integer agenteId;
	private Integer status;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private String cve;
	private String agenteCve;

	public AgenteContacto() {
	}

	public static AgenteContacto ContactoPaciente(Contacto contacto, int idPaciente) {
		AgenteContacto obj = new AgenteContacto();

		obj.setContacto(contacto);
		obj.setAgenteId(idPaciente);

		obj.setTipoAgenteId(2);
		obj.setAgenteCve(null);
		obj.setStatus(1);
		obj.setFechaRegistro(new Date());
		obj.setUsuarioRegistro(SecurityContextHolder.getContext().getAuthentication().getName());

		return obj;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AGENTE_CONTACTO_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getAgenteContactoId() {
		return this.agenteContactoId;
	}

	public void setAgenteContactoId(Integer agenteContactoId) {
		this.agenteContactoId = agenteContactoId;
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
	@JoinColumn(name = "CONTACTO_ID")
	public Contacto getContacto() {
		return this.contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
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
	public String getUsuarioRegistro() {
		return this.usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}


	@Column(name = "CVE", length = 20)
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
