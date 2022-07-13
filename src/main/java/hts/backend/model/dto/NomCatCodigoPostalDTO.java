package hts.backend.model.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class NomCatCodigoPostalDTO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer catCodigoPostalId;
	private String nombre;
	private String descripcion;
	private String CEstado;
	private String CMunicipio;
	private String cve;
	private Integer status;
	private String usuarioCve;
	private Integer indicaDefault;
	private Date fechaRegistro;
	private Set<DireccionDTO> direccions = new HashSet<DireccionDTO>(0);

	public NomCatCodigoPostalDTO() {
	}

	public Integer getCatCodigoPostalId() {
		return this.catCodigoPostalId;
	}

	public void setCatCodigoPostalId(Integer catCodigoPostalId) {
		this.catCodigoPostalId = catCodigoPostalId;
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

	public String getCEstado() {
		return this.CEstado;
	}

	public void setCEstado(String CEstado) {
		this.CEstado = CEstado;
	}

	public String getCMunicipio() {
		return this.CMunicipio;
	}

	public void setCMunicipio(String CMunicipio) {
		this.CMunicipio = CMunicipio;
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

	public Set<DireccionDTO> getDireccions() {
		return this.direccions;
	}

	public void setDireccions(Set<DireccionDTO> direccions) {
		this.direccions = direccions;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIndicaDefault() {
		return indicaDefault;
	}

	public void setIndicaDefault(Integer indicaDefault) {
		this.indicaDefault = indicaDefault;
	}

	/**
	 * Valida si todas las propiedades son nulas
	 *
	 * @return true/false
	 */
	public boolean isNull() {
		return (
				this.catCodigoPostalId == null &&
						Objects.equals(this.nombre, "") &&
						Objects.equals(this.descripcion, "") &&
						Objects.equals(this.CEstado, "") &&
						Objects.equals(this.CMunicipio, "") &&
						Objects.equals(this.cve, "") &&
						this.status == null &&
						Objects.equals(this.usuarioCve, "") &&
						this.indicaDefault == null &&
						this.fechaRegistro == null
		);
	}
}
