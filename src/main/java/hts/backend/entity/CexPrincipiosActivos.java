package hts.backend.entity;
// Generated 12/05/2017 02:12:43 PM by Hibernate Tools 5.2.0.CR1

import hts.backend.entity.CatIdiomaApp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * CexPrincipiosActivos generated by hbm2java
 */
@Entity
@Table(name = "cex_principios_activos")
public class CexPrincipiosActivos implements java.io.Serializable {

	private Integer principioActivoId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private CatIdiomaApp catIdiomaAppByIdiomaAppId;
	private Set<CexGenericos> cexGenericoses = new HashSet<CexGenericos>(0);

	public CexPrincipiosActivos() {
	}

	public CexPrincipiosActivos(Integer principioActivoId) {
		this.principioActivoId = principioActivoId;
	}

	public CexPrincipiosActivos(Integer principioActivoId, String cve, String nombre, String descripcion,
								Integer valorDefault, Integer estatus, Date fechaRegistro, String usuarioRegistro, Set<CexGenericos> cexGenericoses) {
		this.principioActivoId = principioActivoId;
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valorDefault = valorDefault;
		this.estatus = estatus;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistro = usuarioRegistro;
		this.cexGenericoses = cexGenericoses;
	}

	@Id

	@Column(name = "PRINCIPIO_ACTIVO_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getPrincipioActivoId() {
		return this.principioActivoId;
	}

	public void setPrincipioActivoId(Integer principioActivoId) {
		this.principioActivoId = principioActivoId;
	}

	@Column(name = "CVE", length = 50)
	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	@Column(name = "NOMBRE", length = 250)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "DESCRIPCION", length = 250)
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
	@Column(name = "FECHA_REGISTRO", length = 7)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Column(name = "USUARIO_REGISTRO", length = 20)
	public String getUsuarioRegistro() {
		return this.usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@ManyToOne @JoinColumn(name = "IDIOMA_APP_ID", referencedColumnName = "IDIOMA_APP_ID")
	public CatIdiomaApp getCatIdiomaAppByIdiomaAppId() {
		return catIdiomaAppByIdiomaAppId;
	}

	public void setCatIdiomaAppByIdiomaAppId(CatIdiomaApp catIdiomaAppByIdiomaAppId) {
		this.catIdiomaAppByIdiomaAppId = catIdiomaAppByIdiomaAppId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cexPrincipiosActivos")
	public Set<CexGenericos> getCexGenericoses() {
		return this.cexGenericoses;
	}

	public void setCexGenericoses(Set<CexGenericos> cexGenericoses) {
		this.cexGenericoses = cexGenericoses;
	}

}

