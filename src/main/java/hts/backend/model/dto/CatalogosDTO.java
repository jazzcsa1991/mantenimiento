package hts.backend.model.dto;

import java.util.Date;

public class CatalogosDTO {

	private Integer id;
	private Integer idOpcion;
	private Integer clave;
	private String nombre;
	private String descripcion;
	private Integer indicadefault;
	private Integer estatus;
	private Date fecharegistro;
	private String nousuario;





	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdOpcion() {
		return idOpcion;
	}
	public void setIdOpcion(Integer idOpcion) {
		this.idOpcion = idOpcion;
	}
	public Integer getClave() {
		return clave;
	}
	public void setClave(Integer clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getIndicadefault() {
		return indicadefault;
	}
	public void setIndicadefault(Integer indicadefault) {
		this.indicadefault = indicadefault;
	}
	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
	public Date getFecharegistro() {
		return fecharegistro;
	}
	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}
	public String getNousuario() {
		return nousuario;
	}
	public void setNousuario(String nousuario) {
		this.nousuario = nousuario;
	}



}
