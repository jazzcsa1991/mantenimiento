package hts.backend.entity;
// Generated 03-feb-2017 12:09:42 by Hibernate Tools 5.2.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "adm_modulo")
public class AdmModulo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer moduloId;
	private AdmPortal admPortal;
	private String nombre;
	private String descripcion;
	private Integer estatus;
	private Date fecha;
	private String usuario;
	private Set<AdmAccion> admAccions = new HashSet<AdmAccion>(0);


	public AdmModulo() {
	}


	public AdmModulo(Integer moduloId) {
		this.moduloId = moduloId;
	}


	public AdmModulo(Integer moduloId, AdmPortal admPortal, String nombre, String descripcion, Integer estatus, Date fecha, String usuario) {
		this.moduloId = moduloId;
		this.admPortal = admPortal;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.fecha = fecha;
		this.usuario = usuario;
	}


	public AdmModulo(AdmPortal admPortal, String nombre, String descripcion, Integer estatus,
					 Date fecha, String usuario) {
		this.admPortal = admPortal;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.fecha = fecha;
		this.usuario = usuario;
	}


	public AdmModulo(Integer moduloId, AdmPortal admPortal, String nombre, String descripcion, Integer estatus, Date fecha, String usuario, Set<AdmAccion> admAccions) {
		this.moduloId = moduloId;
		this.admPortal = admPortal;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.fecha = fecha;
		this.usuario = usuario;
		this.admAccions = admAccions;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MODULO_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getModuloId() {
		return this.moduloId;
	}


	public void setModuloId(Integer moduloId) {
		this.moduloId = moduloId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PORTAL_ID", nullable = false)
	public AdmPortal getAdmPortal() {
		return this.admPortal;
	}


	public void setAdmPortal(AdmPortal admPortal) {
		this.admPortal = admPortal;
	}


	@Column(name = "NOMBRE", nullable = false, length = 20)
	public String getNombre() {
		return this.nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Column(name = "DESCRIPCION", nullable = false, length = 150)
	public String getDescripcion() {
		return this.descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Column(name = "ESTATUS", nullable = false, precision = 22, scale = 0)
	public Integer getEstatus() {
		return this.estatus;
	}


	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA", nullable = false, length = 7)
	public Date getFecha() {
		return this.fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	@Column(name = "USUARIO", nullable = false, length = 20)
	public String getUsuario() {
		return this.usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "admModulo")
	public Set<AdmAccion> getAdmAccions() {
		return this.admAccions;
	}


	public void setAdmAccions(Set<AdmAccion> admAccions) {
		this.admAccions = admAccions;
	}
}
