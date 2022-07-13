package hts.backend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "admin_logos_hospital")
public class AdminLogos implements java.io.Serializable{

	private int idLogos;
	private String nombre;
	private String imagen;
	private int idHospital;
	private int posicion;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private int estatus;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic@Column(name = "LOGOS_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public int getIdLogos() {
		return idLogos;
	}

	public void setIdLogos(int idLogos) {
		this.idLogos = idLogos;
	}

	@Basic@Column(name = "HOSPITAL_ID", nullable = false, length = 10)
	public int getIdHospital() {
		return idHospital;
	}

	public void setIdHospital(int idHospital) {
		this.idHospital = idHospital;
	}

	@Basic@Column(name = "POSICION", nullable = false, length = 10)
	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	@Temporal(TemporalType.DATE)
	@Basic@Column(name = "FECHA_REGISTRO", nullable = false, length = 7)
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic@Column(name = "USUARIO_REGISTRO", nullable = false, length = 20)
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Basic@Column(name = "NOMBRE", nullable = false, length = 100)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Basic@Column(name = "IMAGEN")
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Basic@Column(name = "ESTATUS", nullable = false, precision = 22, scale = 0)
	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
}
