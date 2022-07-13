package hts.backend.entity;
// Generated 30/05/2017 06:49:38 PM by Hibernate Tools 5.2.0.CR1

import hts.backend.entity.CexPrescripcionesMedicamento;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CatEstadoPrescripcion generated by hbm2java
 */
@Entity
@Table(name = "nom_cat_estado_prescripcion")
public class CatEstadoPrescripcion implements java.io.Serializable {

	private Integer estadoPrescripcionId;
	private Integer cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Integer idiomaAppId;
	private Set<CexPrescripcionesMedicamento> cexPrescripcionesMedicamentos = new HashSet<CexPrescripcionesMedicamento>(0);

	public CatEstadoPrescripcion() {
	}

	public CatEstadoPrescripcion(Integer estadoPrescripcionId, Date fechaRegistro, String usuarioRegistro,
			Integer idiomaAppId) {
		this.estadoPrescripcionId = estadoPrescripcionId;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistro = usuarioRegistro;
		this.idiomaAppId = idiomaAppId;
	}

	public CatEstadoPrescripcion(Integer estadoPrescripcionId, Integer cve, String nombre, String descripcion,
			Integer valorDefault, Integer estatus, Date fechaRegistro, String usuarioRegistro,
			Integer idiomaAppId, Set cexRecetas) {
		this.estadoPrescripcionId = estadoPrescripcionId;
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valorDefault = valorDefault;
		this.estatus = estatus;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistro = usuarioRegistro;
		this.idiomaAppId = idiomaAppId;
		this.cexPrescripcionesMedicamentos = cexPrescripcionesMedicamentos;
	}

	@Id

	@Column(name = "ESTADO_PRESCRIPCION_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getEstadoPrescripcionId() {
		return this.estadoPrescripcionId;
	}

	public void setEstadoPrescripcionId(Integer estadoPrescripcionId) {
		this.estadoPrescripcionId = estadoPrescripcionId;
	}

	@Column(name = "CVE", precision = 22, scale = 0)
	public Integer getCve() {
		return this.cve;
	}

	public void setCve(Integer cve) {
		this.cve = cve;
	}

	@Column(name = "NOMBRE", length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "DESCRIPCION", length = 50)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "VALOR_DEFAULT", precision = 22, scale = 0)
	public Integer getValorDefault() {
		return this.valorDefault;
	}

	public void setValorDefault(Integer valorDefault) {
		this.valorDefault = valorDefault;
	}

	@Column(name = "ESTATUS", precision = 22, scale = 0)
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

	@Column(name = "IDIOMA_APP_ID", nullable = false, precision = 22, scale = 0)
	public Integer getIdiomaAppId() {
		return this.idiomaAppId;
	}

	public void setIdiomaAppId(Integer idiomaAppId) {
		this.idiomaAppId = idiomaAppId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catEstadoPrescripcion")
	public Set<CexPrescripcionesMedicamento> getCexRecetas() {
		return this.cexPrescripcionesMedicamentos;
	}

	public void setCexRecetas(Set<CexPrescripcionesMedicamento> cexRecetas) {
		this.cexPrescripcionesMedicamentos = cexRecetas;
	}

}
