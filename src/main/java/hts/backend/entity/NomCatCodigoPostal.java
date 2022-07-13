package hts.backend.entity;


// Generated 24/02/2017 07:59:12 PM by Hibernate Tools 5.2.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * NomCatCodigoPostal generated by hbm2java
 */
@Entity
@Table(name = "nom_cat_codigo_postal")
public class NomCatCodigoPostal implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Integer catCodigoPostalId;
	private String nombre;
	private String descripcion;
	private String CEstado;
	private String CMunicipio;
	private String cve;
	private Integer status;
	private String usuarioCve;
	private Integer indicaDefault;
	private Date fechaRegistro;
	private Set<Direccion> direccions = new HashSet<Direccion>(0);

	public NomCatCodigoPostal() {
	}

	public NomCatCodigoPostal(Integer catCodigoPostalId) {
		this.catCodigoPostalId = catCodigoPostalId;
	}

	public NomCatCodigoPostal(Integer catCodigoPostalId, String nombre, String descripcion, String CEstado,
			String CMunicipio, Integer status, String usuarioCve, Integer indicaDefault, Date fechaRegistro) {
		this.catCodigoPostalId = catCodigoPostalId;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.CEstado = CEstado;
		this.CMunicipio = CMunicipio;
		this.status = status;
		this.usuarioCve = usuarioCve;
		this.indicaDefault = indicaDefault;
		this.fechaRegistro = fechaRegistro;
	}

	public NomCatCodigoPostal(Integer catCodigoPostalId, String nombre, String descripcion, String cEstado,
			String cMunicipio, String cve, Integer status, String usuarioCve, Integer indicaDefault, Date fechaRegistro,
			Set<Direccion> direccions) {

		this.catCodigoPostalId = catCodigoPostalId;
		this.nombre = nombre;
		this.descripcion = descripcion;
		CEstado = cEstado;
		CMunicipio = cMunicipio;
		this.cve = cve;
		this.status = status;
		this.usuarioCve = usuarioCve;
		this.indicaDefault = indicaDefault;
		this.fechaRegistro = fechaRegistro;
		this.direccions = direccions;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CAT_CODIGO_POSTAL_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getCatCodigoPostalId() {
		return this.catCodigoPostalId;
	}

	public void setCatCodigoPostalId(Integer catCodigoPostalId) {
		this.catCodigoPostalId = catCodigoPostalId;
	}

	@Column(name = "NOMBRE", nullable = false, length = 20)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "DESCRIPCION", nullable = false, length = 20)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "C_ESTADO", nullable = false, length = 10)
	public String getCEstado() {
		return this.CEstado;
	}

	public void setCEstado(String CEstado) {
		this.CEstado = CEstado;
	}

	@Column(name = "C_MUNICIPIO", nullable = false, length = 10)
	public String getCMunicipio() {
		return this.CMunicipio;
	}

	public void setCMunicipio(String CMunicipio) {
		this.CMunicipio = CMunicipio;
	}

	@Column(name = "CVE", length = 20)
	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	@Column(name = "ESTATUS", nullable = false, precision = 1, scale = 0)
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "VALOR_DEFAULT", nullable = false, precision = 1, scale = 0)
	public Integer getIndicaDefault() {
		return indicaDefault;
	}

	public void setIndicaDefault(Integer indicaDefault) {
		this.indicaDefault = indicaDefault;
	}

	@Column(name = "USUARIO_REGISTRO", nullable = false, length = 20)
	public String getUsuarioCve() {
		return this.usuarioCve;
	}

	public void setUsuarioCve(String usuarioCve) {
		this.usuarioCve = usuarioCve;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", nullable = false, length = 7)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nomCatCodigoPostal")
	public Set<Direccion> getDireccions() {
		return this.direccions;
	}

	public void setDireccions(Set<Direccion> direccions) {
		this.direccions = direccions;
	}

}
