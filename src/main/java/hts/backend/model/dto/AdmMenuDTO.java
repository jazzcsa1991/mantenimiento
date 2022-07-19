package hts.backend.model.dto;


import java.util.Date;

public class AdmMenuDTO implements java.io.Serializable {


	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nombre;
	private String descripcion;
	private Integer estatus;
	private Date fecha;
	private String usuario;
	private String icono;
	private Boolean esEdicion = false;

	public AdmMenuDTO() {
	}

	public AdmMenuDTO(Integer id, String nombre, String descripcion, Integer estatus,
			Date fecha, String usuario, String icono) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.fecha = fecha;
		this.usuario = usuario;
		this.icono = icono;
	}



	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Date getFecha(Date date) {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Boolean getEsEdicion() {
		return esEdicion;
	}

	public void setEsEdicion(Boolean esEdicion) {
		this.esEdicion = esEdicion;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}
}
