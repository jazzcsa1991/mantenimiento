package hts.backend.model.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DocumentoDTO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer documentoId;
	private CatDocumentoIdentificacionDTO catDocumentoIdentificacion;
	private String numero;
	private Integer status;
	private String cve;
	private Date fechaRegistro;
	private String usuarioRegistra;
	private Set<AgenteDocumentoDTO> agenteDocumentos = new HashSet<AgenteDocumentoDTO>(0);

	public DocumentoDTO() {
	}

	public Integer getDocumentoId() {
		return this.documentoId;
	}

	public void setDocumentoId(Integer documentoId) {
		this.documentoId = documentoId;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
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

	public CatDocumentoIdentificacionDTO getCatDocumentoIdentificacion() {
		return catDocumentoIdentificacion;
	}

	public void setCatDocumentoIdentificacion(CatDocumentoIdentificacionDTO catDocumentoIdentificacion) {
		this.catDocumentoIdentificacion = catDocumentoIdentificacion;
	}

	public Set<AgenteDocumentoDTO> getAgenteDocumentos() {
		return agenteDocumentos;
	}

	public void setAgenteDocumentos(Set<AgenteDocumentoDTO> agenteDocumentos) {
		this.agenteDocumentos = agenteDocumentos;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
