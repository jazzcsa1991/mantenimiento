package hts.backend.model.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class AdmPortalDTO extends AdmMenuDTO implements java.io.Serializable  {


	private static final long serialVersionUID = 1L;

	private Integer hospitalId;

	@JsonIgnore private Set<AdmModuloDTO> admModulos = new HashSet<AdmModuloDTO>(0);

	public AdmPortalDTO() {
		super();
	}

	public AdmPortalDTO(Integer portalId, Integer hospitalId, String nombre, String descripcion, Integer estatus,
			Date fecha, String usuario, String icono) {

		super(portalId, nombre, descripcion, estatus, fecha, usuario, icono);
		this.hospitalId = hospitalId;

	}

	public AdmPortalDTO(Integer portalId, Integer hospitalId, String nombre, String descripcion, Integer estatus,
			Date fecha, String usuario, String icono, Set<AdmModuloDTO> admModulos) {
		super(portalId, nombre, descripcion, estatus, fecha, usuario, icono);

		this.hospitalId = hospitalId;
		this.admModulos = admModulos;
	}

	public Integer getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Set<AdmModuloDTO> getAdmModulos() {
		return this.admModulos;
	}

	public void setAdmModulos(Set<AdmModuloDTO> admModulos) {
		this.admModulos = admModulos;
	}

}
