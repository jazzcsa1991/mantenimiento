package hts.backend.model.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;



public class AdmAccionDTO extends AdmMenuDTO implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private AdmModuloDTO admModulo;
	private Integer padreId;
	private Integer orden;
	private String urlVista;
	private String icono;
	private Integer nivel;
	private int portalID;
	private int moduloID;
	private int accionID;

	private Set<AdmFuncionDTO> admFuncions = new HashSet<AdmFuncionDTO>(0);


	public AdmAccionDTO() {
		super();

	}

	public AdmAccionDTO(Integer accionId, AdmModuloDTO admModulo, String nombre, String descripcion, Integer orden,
			String urlVista, Integer nivel, Integer estatus, Date fecha, String usuario, String icono) {

		super(accionId, nombre, descripcion, estatus, fecha, usuario, icono);

		this.admModulo = admModulo;
		this.orden = orden;
		this.urlVista = urlVista;
		this.nivel = nivel;

	}

	public AdmAccionDTO(Integer accionId, AdmModuloDTO admModulo, String nombre, String descripcion, Integer padreId,
			Integer orden, String urlVista, Integer nivel, Integer estatus, Date fecha, String usuario, String icono) {

		super(accionId, nombre, descripcion, estatus, fecha, usuario, icono);

		this.admModulo = admModulo;
		this.orden = orden;
		this.urlVista = urlVista;
		this.nivel = nivel;
		this.padreId = padreId;
		this.icono = icono;

	}

	public AdmAccionDTO(Integer accionId, AdmModuloDTO admModulo, String nombre, String descripcion,
			Integer padreId, Integer orden, String urlVista, Integer nivel, Integer estatus,
			Date fecha, String usuario,Set<AdmFuncionDTO> admFuncions,  String icono ) {

		super(accionId, nombre, descripcion, estatus, fecha, usuario, icono);

		this.admModulo = admModulo;
		this.orden = orden;
		this.urlVista = urlVista;
		this.nivel = nivel;
		this.padreId = padreId;
		this.icono = icono;
		this.setAdmFuncions(admFuncions);

	}


	public AdmModuloDTO getAdmModulo() {
		return this.admModulo;
	}

	public void setAdmModulo(AdmModuloDTO admModulo) {
		this.admModulo = admModulo;
	}


	public Integer getPadreId() {
		return this.padreId;
	}

	public void setPadreId(Integer padreId) {
		this.padreId = padreId;
	}

	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getUrlVista() {
		return this.urlVista;
	}

	public void setUrlVista(String urlVista) {
		this.urlVista = urlVista;
	}

	public Integer getNivel() {
		return this.nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
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

	public Set<AdmFuncionDTO> getAdmFuncions() {
		return admFuncions;
	}

	public void setAdmFuncions(Set<AdmFuncionDTO> admFuncions) {
		this.admFuncions = admFuncions;
	}

	@Override public String getIcono() {
		return icono;
	}

	@Override public void setIcono(String icono) {
		this.icono = icono;
	}
}
