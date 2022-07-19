package hts.backend.model.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class AdmModuloDTO extends AdmMenuDTO implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private AdmPortalDTO admPortal;
	private int portalID;
	private int moduloID;
	private int accionID;

	@JsonIgnore private Set<AdmAccionDTO> admAccions = new HashSet<AdmAccionDTO>(0);

	public AdmModuloDTO() {
		super();
	}

	public AdmModuloDTO(Integer moduloId, AdmPortalDTO admPortal, String nombre, String descripcion, Integer estatus,
			Date fecha, String usuario, String icono) {
		super(moduloId, nombre, descripcion, estatus, fecha, usuario, icono);

		this.admPortal = admPortal;

	}

	public AdmModuloDTO(Integer moduloId, AdmPortalDTO admPortal, String nombre, String descripcion, Integer estatus,
			Date fecha, String usuario, String icono, Set<AdmAccionDTO> admAccions) {

		super(moduloId, nombre, descripcion, estatus, fecha, usuario, icono);

		this.admPortal = admPortal;
		this.admAccions = admAccions;
	}


	public AdmPortalDTO getAdmPortal() {
		return this.admPortal;
	}

	public void setAdmPortal(AdmPortalDTO admPortal) {
		this.admPortal = admPortal;
	}

	public Set<AdmAccionDTO> getAdmAccions() {
		return this.admAccions;
	}

	public void setAdmAccions(Set<AdmAccionDTO> admAccions) {
		this.admAccions = admAccions;
	}

	public int getPortalID() {
		return portalID;
	}

	public void setPortalID(int portalID) {
		this.portalID = portalID;
	}

	public int getModuloID() {
		return moduloID;
	}

	public void setModuloID(int moduloID) {
		this.moduloID = moduloID;
	}

	public int getAccionID() {
		return accionID;
	}

	public void setAccionID(int accionID) {
		this.accionID = accionID;
	}

}
