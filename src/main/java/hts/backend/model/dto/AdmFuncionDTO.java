package hts.backend.model.dto;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import hts.backend.model.dto.RolDTO;


public class AdmFuncionDTO extends AdmMenuDTO implements java.io.Serializable {


	private static final long serialVersionUID = 1L;

	private AdmAccionDTO admAccion;

	private Set<RolDTO> catRols = new HashSet<RolDTO>(0);


	public AdmFuncionDTO() {
		super();
	}

	public AdmFuncionDTO(Integer moduloId, AdmAccionDTO admAccion, String nombre, String descripcion, Integer estatus,
			Date fecha, String usuario, String icono) {
		super(moduloId, nombre, descripcion, estatus, fecha, usuario, icono);

		this.admAccion = admAccion;

	}

	public AdmFuncionDTO(Integer moduloId, AdmAccionDTO admAccion, String nombre, String descripcion, Integer estatus,
			Date fecha, String usuario, String icono, Set<RolDTO> catRols) {
		super(moduloId, nombre, descripcion, estatus, fecha, usuario, icono);

		this.admAccion = admAccion;
		this.catRols = catRols;

	}

	public AdmAccionDTO getAdmAccion() {
		return this.admAccion;
	}

	public void setAdmAccion(AdmAccionDTO admAccion) {
		this.admAccion = admAccion;
	}

	public Set<RolDTO> getCatRols() {
		return this.catRols;
	}

	public void setCatRols(Set<RolDTO> catRols) {
		this.catRols = catRols;
	}


}
