package hts.backend.model.dto;

import java.util.Date;

public class ServicioEspecialidadDTO {


	private int idCentro;
	private int idAreaServicio;
	private int idServicioBasico;
	private int idServicioEspecializado;
	private String descripcion;
	private String nombre;
	private String nombreCorto;
	private String usuarioRegistra;
	private Date fechaRegistro;



	public int getIdCentro() {
		return idCentro;
	}
	public void setIdCentro(int idCentro) {
		this.idCentro = idCentro;
	}
	public int getIdAreaServicio() {
		return idAreaServicio;
	}
	public void setIdAreaServicio(int idAreaServicio) {
		this.idAreaServicio = idAreaServicio;
	}
	public int getIdServicioBasico() {
		return idServicioBasico;
	}
	public void setIdServicioBasico(int idServicioBasico) {
		this.idServicioBasico = idServicioBasico;
	}
	public int getIdServicioEspecializado() {
		return idServicioEspecializado;
	}
	public void setIdServicioEspecializado(int idServicioEspecializado) {
		this.idServicioEspecializado = idServicioEspecializado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreCorto() {
		return nombreCorto;
	}
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	public String getUsuarioRegistra() {
		return usuarioRegistra;
	}
	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


}
