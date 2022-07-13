package hts.backend.entity;
// Generated 1/06/2017 03:43:06 PM by Hibernate Tools 5.2.0.CR1

import hts.backend.entity.CexPrescripcionesMedicamento;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CatMotInterrupcionPresc generated by hbm2java
 */
@Entity
@Table(name = "cat_mot_interrupcion_presc")
public class CatMotInterrupcionPresc implements java.io.Serializable {

	private Integer motivoInterrupcionPrescId;
	private String clave;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Set<CexPrescripcionesMedicamento> cexPrescripcionesMedicamentos = new HashSet<CexPrescripcionesMedicamento>(0);

	public CatMotInterrupcionPresc() {
	}

	public CatMotInterrupcionPresc(Integer motivoInterrupcionPrescId, String clave, String nombre,
								   String descripcion, Integer valorDefault, Integer estatus, Date fechaRegistro,
								   String usuarioRegistro) {
		this.motivoInterrupcionPrescId = motivoInterrupcionPrescId;
		this.clave = clave;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valorDefault = valorDefault;
		this.estatus = estatus;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistro = usuarioRegistro;
	}

	public CatMotInterrupcionPresc(Integer motivoInterrupcionPrescId, String clave, String nombre,
								   String descripcion, Integer valorDefault, Integer estatus, Date fechaRegistro, String usuarioRegistro,
								   Set cexPrescripcionesMedicamentos) {
		this.motivoInterrupcionPrescId = motivoInterrupcionPrescId;
		this.clave = clave;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valorDefault = valorDefault;
		this.estatus = estatus;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistro = usuarioRegistro;
		this.cexPrescripcionesMedicamentos = cexPrescripcionesMedicamentos;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOT_INTERRUPCION_PRESC_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getMotivoInterrupcionPrescId() {
		return this.motivoInterrupcionPrescId;
	}

	public void setMotivoInterrupcionPrescId(Integer motivoInterrupcionPrescId) {
		this.motivoInterrupcionPrescId = motivoInterrupcionPrescId;
	}

	@Column(name = "CVE", nullable = false, precision = 22, scale = 0)
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Column(name = "NOMBRE", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "DESCRIPCION", nullable = false, length = 50)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "VALOR_DEFAULT", nullable = false, precision = 22, scale = 0)
	public Integer getValorDefault() {
		return this.valorDefault;
	}

	public void setValorDefault(Integer valorDefault) {
		this.valorDefault = valorDefault;
	}

	@Column(name = "ESTATUS", nullable = false, precision = 22, scale = 0)
	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", nullable = false, length = 7)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Column(name = "USUARIO_REGISTRO", nullable = false, length = 20)
	public String getUsuarioRegistro() {
		return this.usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catMotInterrupcionPresc")
	public Set<CexPrescripcionesMedicamento> getCexPrescripcionesMedicamentos() {
		return this.cexPrescripcionesMedicamentos;
	}

	public void setCexPrescripcionesMedicamentos(Set<CexPrescripcionesMedicamento> cexPrescripcionesMedicamentos) {
		this.cexPrescripcionesMedicamentos = cexPrescripcionesMedicamentos;
	}


}
