package hts.backend.model.dto;

public class AccionDTO {

	private int idAccion;
	private int idModulo;
	private int idPortal;
	private int idRol;
	private String nombreAccion;
	private String usuarioRegistra;
	private String fechaRegistra;


	public int getIdAccion() {
		return idAccion;
	}
	public void setIdAccion(int idAccion) {
		this.idAccion = idAccion;
	}
	public int getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(int idModulo) {
		this.idModulo = idModulo;
	}
	public int getIdPortal() {
		return idPortal;
	}
	public void setIdPortal(int idPortal) {
		this.idPortal = idPortal;
	}
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getNombreAccion() {
		return nombreAccion;
	}
	public void setNombreAccion(String nombreAccion) {
		this.nombreAccion = nombreAccion;
	}
	public String getUrlVista() {
		return urlVista;
	}
	public void setUrlVista(String urlVista) {
		this.urlVista = urlVista;
	}
	private String urlVista;


	public String getUsuarioRegistra() {
		return usuarioRegistra;
	}
	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}
	public String getFechaRegistra() {
		return fechaRegistra;
	}
	public void setFechaRegistra(String fechaRegistra) {
		this.fechaRegistra = fechaRegistra;
	}

}
