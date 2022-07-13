package hts.backend.model.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class NomCatMunicipioDTO implements java.io.Serializable, EntidadDTO {
	private static final long serialVersionUID = 1L;

	private Integer catMunicipioId;
	private String cveEnt;
	private String cveMun;
	private String descripcion;
	private Integer indicaDefault;
	private Integer status;
	private String usuarioCve;
	private Date fechaRegistro;
	private Set<DireccionDTO> direccions = new HashSet<DireccionDTO>(0);

	public NomCatMunicipioDTO() {
	}

	public Integer getCatMunicipioId() {
		return this.catMunicipioId;
	}

	public void setCatMunicipioId(Integer catMunicipioId) {
		this.catMunicipioId = catMunicipioId;
	}

	public String getCveEnt() {
		return this.cveEnt;
	}

	public void setCveEnt(String cveEnt) {
		this.cveEnt = cveEnt;
	}

	public String getCveMun() {
		return this.cveMun;
	}

	public void setCveMun(String cveMun) {
		this.cveMun = cveMun;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public Integer getIndicaDefault() {
		return indicaDefault;
	}

	public void setIndicaDefault(Integer indicaDefault) {
		this.indicaDefault = indicaDefault;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public Integer getId() {
		return getCatMunicipioId();
	}

	/**
	 * Valida si todas las propiedades son nulas
	 *
	 * @return true/false
	 */
	public boolean isNull() {
		return (
				this.catMunicipioId == null &&
						Objects.equals(this.cveEnt, "") &&
						Objects.equals(this.cveMun, "") &&
						Objects.equals(this.descripcion, "") &&
						this.indicaDefault == null &&
						this.status == null &&
						Objects.equals(this.usuarioCve, "") &&
						this.fechaRegistro == null
		);
	}
}