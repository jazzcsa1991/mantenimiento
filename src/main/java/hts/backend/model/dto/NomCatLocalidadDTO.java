package hts.backend.model.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class NomCatLocalidadDTO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer catLocalidadId;
	private String cveEnt;
	private String cveMun;
	private String cveLoc;
	private String descripcion;
	private Integer indicaDefault;
	private Integer status;
	private String usuarioCve;
	private Date fechaRegistro;
	private Set<DireccionDTO> direccions = new HashSet<DireccionDTO>(0);

	public NomCatLocalidadDTO() {
	}

	public Integer getCatLocalidadId() {
		return this.catLocalidadId;
	}

	public void setCatLocalidadId(Integer catLocalidadId) {
		this.catLocalidadId = catLocalidadId;
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

	public String getCveLoc() {
		return this.cveLoc;
	}

	public void setCveLoc(String cveLoc) {
		this.cveLoc = cveLoc;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	/**
	 * Valida si todas las propiedades son nulas
	 *
	 * @return true/false
	 */
	public boolean isNull() {
		return (
				this.catLocalidadId == null &&
						Objects.equals(this.cveEnt, "") &&
						Objects.equals(this.cveMun, "") &&
						Objects.equals(this.cveLoc, "") &&
						Objects.equals(this.descripcion, "") &&
						this.indicaDefault == null &&
						this.status == null &&
						Objects.equals(this.usuarioCve, "") &&
						this.fechaRegistro == null
		);
	}
}