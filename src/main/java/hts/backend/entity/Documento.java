package hts.backend.entity;

import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "documento")
public class Documento implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer documentoId;
	private CatDocumentoIdentificacion catDocumentoIdentificacion;
	private Integer documentoIdentificacionId;
	private String numero;
	private Integer status;
	private String cve;
	private Date fechaRegistro;
	private String usuarioRegistra;
	private Set<AgenteDocumento> agenteDocumentos = new HashSet<AgenteDocumento>(0);

	public Documento() {
	}

	// Constructor para registro de documentos
	public Documento(Integer documentoIdentificacionId, String numero) {
		this.documentoIdentificacionId = documentoIdentificacionId;
		this.numero = numero;

		this.status = 1;
		this.cve = null;
		this.fechaRegistro = new Date();
		this.usuarioRegistra = SecurityContextHolder.getContext().getAuthentication().getName();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DOCUMENTO_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getDocumentoId() {
		return this.documentoId;
	}

	public void setDocumentoId(Integer documentoId) {
		this.documentoId = documentoId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOCUMENTO_IDENTIFICACION_ID", nullable = false, insertable = false, updatable = false)
	public CatDocumentoIdentificacion getCatDocumentoIdentificacion() {
		return this.catDocumentoIdentificacion;
	}

	public void setCatDocumentoIdentificacion(CatDocumentoIdentificacion catDocumentoIdentificacion) {
		this.catDocumentoIdentificacion = catDocumentoIdentificacion;
	}


	@Column(name = "DOCUMENTO_IDENTIFICACION_ID", nullable = false)
	public Integer getDocumentoIdentificacionId() {
		return documentoIdentificacionId;
	}

	public void setDocumentoIdentificacionId(Integer documentoIdentificacionId) {
		this.documentoIdentificacionId = documentoIdentificacionId;
	}


	@Column(name = "NUMERO", nullable = false, length = 20)
	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}


	@Column(name = "CVE", length = 18)
	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
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
	public String getUsuarioRegistra() {
		return this.usuarioRegistra;
	}

	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "documento")
	public Set<AgenteDocumento> getAgenteDocumentos() {
		return this.agenteDocumentos;
	}

	public void setAgenteDocumentos(Set<AgenteDocumento> agenteDocumentos) {
		this.agenteDocumentos = agenteDocumentos;
	}


	@Column(name = "ESTATUS", precision = 22, scale = 0)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
