package hts.backend.model.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CatTipoAsenDTO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer tipoAsenId;
	private String clave;
	private String nombre;
	private String descripcion;
	private Integer indicaDefault;
	private Integer status;
	private Date fechaRegistro;
	private String noUsuario;
	private Set<DireccionDTO> direccions = new HashSet<DireccionDTO>(0);

	public CatTipoAsenDTO() {
	}

	public Integer getTipoAsenId() {
		return this.tipoAsenId;
	}

	public void setTipoAsenId(Integer tipoAsenId) {
		this.tipoAsenId = tipoAsenId;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
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

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNoUsuario() {
		return this.noUsuario;
	}

	public void setNoUsuario(String noUsuario) {
		this.noUsuario = noUsuario;
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
				this.tipoAsenId == null &&
						Objects.equals(this.clave, "") &&
						Objects.equals(this.nombre, "") &&
						Objects.equals(this.descripcion, "") &&
						this.indicaDefault == null &&
						this.status == null &&
						this.fechaRegistro == null &&
						Objects.equals(this.noUsuario, "")
		);
	}
}
