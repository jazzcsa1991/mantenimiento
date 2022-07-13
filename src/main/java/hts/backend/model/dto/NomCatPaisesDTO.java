package hts.backend.model.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class NomCatPaisesDTO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer paisId;
	private String cve;
	private String descripcion;
	private String codOficial;
	private Integer indicaDefault;
	private Integer status;
	private String usuarioCve;
	private Date fechaRegistro;
	private Set<DireccionDTO> direccions = new HashSet<DireccionDTO>(0);
	private Set<NomCatEntidadesDTO> nomCatEntidadeses = new HashSet<NomCatEntidadesDTO>(0);

	public NomCatPaisesDTO() {
	}

	public Integer getPaisId() {
		return this.paisId;
	}

	public void setPaisId(Integer paisId) {
		this.paisId = paisId;
	}

	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodOficial() {
		return this.codOficial;
	}

	public void setCodOficial(String codOficial) {
		this.codOficial = codOficial;
	}

	public Integer getIndicaDefault() {
		return this.indicaDefault;
	}

	public void setIndicaDefault(Integer indicaDefault) {
		this.indicaDefault = indicaDefault;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Set<NomCatEntidadesDTO> getNomCatEntidadeses() {
		return this.nomCatEntidadeses;
	}

	public void setNomCatEntidadeses(Set<NomCatEntidadesDTO> nomCatEntidadeses) {
		this.nomCatEntidadeses = nomCatEntidadeses;
	}

	/**
	 * Valida si todas las propiedades son nulas
	 *
	 * @return true/false
	 */
	public boolean isNull() {
		return (
				this.paisId == null &&
						Objects.equals(this.cve, "") &&
						Objects.equals(this.descripcion, "") &&
						Objects.equals(this.codOficial, "") &&
						this.indicaDefault == null &&
						this.status == null &&
						Objects.equals(this.usuarioCve, "") &&
						this.fechaRegistro == null
		);
	}
}