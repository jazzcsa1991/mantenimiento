package hts.backend.model.dto;

import java.util.Date;
import java.util.Objects;

public class CatVialidadDTO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer vialidadId;
	private String clave;
	private String nombre;
	private String descripcion;
	private Integer indicaDefault;
	private Integer estatus;
	private Date fechaRegistro;
	private String noUsuario;
//	private Set<AdmHospital> admHospitals = new HashSet<AdmHospital>(0);

	public CatVialidadDTO() {
	}

	public Integer getVialidadId() {
		return this.vialidadId;
	}

	public void setVialidadId(Integer vialidadId) {
		this.vialidadId = vialidadId;
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

	public String getNoUsuario() {
		return this.noUsuario;
	}

	public void setNoUsuario(String noUsuario) {
		this.noUsuario = noUsuario;
	}



//	public Set<AdmHospital> getAdmHospitals() {
//		return this.admHospitals;
//	}
//
//	public void setAdmHospitals(Set<AdmHospital> admHospitals) {
//		this.admHospitals = admHospitals;
//	}


	/**
	 * Valida si todas las propiedades son nulas
	 *
	 * @return true/false
	 */
	public boolean isNull() {
		return (
				this.vialidadId == null &&
						this.clave == null &&
						Objects.equals(this.nombre, "") &&
						Objects.equals(this.descripcion, "") &&
						this.indicaDefault == null &&
						this.estatus == null &&
						this.fechaRegistro == null &&
						Objects.equals(this.noUsuario, "")
		);
	}
}
