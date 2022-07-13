package hts.backend.model.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CatDocumentoIdentificacionDTO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer documentoIdentificacionId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistra;
	private Integer idiomaAppId;
	private Set<DocumentoDTO> documentos = new HashSet<DocumentoDTO>(0);

	public CatDocumentoIdentificacionDTO() {
	}

	public CatDocumentoIdentificacionDTO(Integer documentoIdentificacionId, String cve, String nombre,
			String descripcion, Integer valorDefault, Integer estatus) {
		this.documentoIdentificacionId = documentoIdentificacionId;
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valorDefault = valorDefault;
		this.estatus = estatus;
	}

	public CatDocumentoIdentificacionDTO(Integer documentoIdentificacionId, String cve, String nombre,
			String descripcion, Integer valorDefault, Integer estatus, Date fechaRegistro, String usuarioRegistra,
			Integer idiomaAppId, Set<DocumentoDTO> documentos) {
		this.documentoIdentificacionId = documentoIdentificacionId;
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valorDefault = valorDefault;
		this.estatus = estatus;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistra = usuarioRegistra;
		this.idiomaAppId = idiomaAppId;
		this.documentos = documentos;
	}

	public Integer getDocumentoIdentificacionId() {
		return this.documentoIdentificacionId;
	}

	public void setDocumentoIdentificacionId(Integer documentoIdentificacionId) {
		this.documentoIdentificacionId = documentoIdentificacionId;
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

	public Integer getValorDefault() {
		return this.valorDefault;
	}

	public void setValorDefault(Integer valorDefault) {
		this.valorDefault = valorDefault;
	}

	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
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

	public Integer getIdiomaAppId() {
		return this.idiomaAppId;
	}

	public void setIdiomaAppId(Integer idiomaAppId) {
		this.idiomaAppId = idiomaAppId;
	}

	public Set<DocumentoDTO> getDocumentos() {
		return this.documentos;
	}

	public void setDocumentos(Set<DocumentoDTO> documentos) {
		this.documentos = documentos;
	}

}
