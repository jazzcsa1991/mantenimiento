package hts.backend.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class NomCatEntidadesDTO implements Serializable, EntidadDTO {
	private static final long serialVersionUID = 1L;

	private Integer catEntidadesId;
	private NomCatPaisesDTO nomCatPaises;
	private String cve;
	private String descripcion;
	private String nombre;
	private Integer indicaDefault;
	private Integer status;
	private String usuarioCve;
	private Date fechaRegistro;
	private Set<DireccionDTO> direccions = new HashSet<DireccionDTO>(0);

	public NomCatEntidadesDTO() {
	}

	public Integer getCatEntidadesId() {
		return this.catEntidadesId;
	}

	public void setCatEntidadesId(Integer catEntidadesId) {
		this.catEntidadesId = catEntidadesId;
	}

	public NomCatPaisesDTO getNomCatPaises() {
		return this.nomCatPaises;
	}

	public void setNomCatPaises(NomCatPaisesDTO nomCatPaises) {
		this.nomCatPaises = nomCatPaises;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIndicaDefault() {
		return indicaDefault;
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

	@Override
	public Integer getId() {
		return getCatEntidadesId();
	}

	/**
	 * Valida si todas las propiedades son nulas
	 *
	 * @return true/false
	 */
	public boolean isNull() {
		return (
				this.catEntidadesId == null &&
						Objects.equals(this.cve, "") &&
						Objects.equals(this.descripcion, "") &&
						Objects.equals(this.nombre, "") &&
						this.indicaDefault == null &&
						this.status == null &&
						Objects.equals(this.usuarioCve, "") &&
						this.fechaRegistro == null
		);
	}
}
