package hts.backend.entity;


// Generated 24/02/2017 07:59:12 PM by Hibernate Tools 5.2.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * NomCatPaises generated by hbm2java
 */
@Entity
@Table(name = "nom_cat_paises")
public class NomCatPaises implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Integer paisId;
	private String cve;
	private String descripcion;
	private String codOficial;
	private Integer indicaDefault;
	private Integer status;
	private String usuarioCve;
	private Date fechaRegistro;
	private Set<Direccion> direccions = new HashSet<Direccion>(0);
	private Set<NomCatEntidades> nomCatEntidadeses = new HashSet<NomCatEntidades>(0);

	public NomCatPaises() {
	}

	public NomCatPaises(Integer paisId) {
		this.paisId = paisId;
	}

	public NomCatPaises(Integer paisId, String cve, String descripcion, String codOficial, Integer indicaDefault,
			Integer status, String usuarioCve, Date fechaRegistro) {
		this.paisId = paisId;
		this.cve = cve;
		this.descripcion = descripcion;
		this.codOficial = codOficial;
		this.indicaDefault = indicaDefault;
		this.status = status;
		this.usuarioCve = usuarioCve;
		this.fechaRegistro = fechaRegistro;
	}


	public NomCatPaises(Integer paisId, String cve, String descripcion, String codOficial, Integer indicaDefault,
			Integer status, String usuarioCve, Date fechaRegistro, Set<Direccion> direccions,
			Set<NomCatEntidades> nomCatEntidadeses) {

		this.paisId = paisId;
		this.cve = cve;
		this.descripcion = descripcion;
		this.codOficial = codOficial;
		this.indicaDefault = indicaDefault;
		this.status = status;
		this.usuarioCve = usuarioCve;
		this.fechaRegistro = fechaRegistro;
		this.direccions = direccions;
		this.nomCatEntidadeses = nomCatEntidadeses;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAIS_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getPaisId() {
		return this.paisId;
	}

	public void setPaisId(Integer paisId) {
		this.paisId = paisId;
	}

	@Column(name = "CVE", nullable = false, length = 10)
	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	@Column(name = "DESCRIPCION", nullable = false, length = 60)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "COD_OFICIAL", nullable = false, length = 4)
	public String getCodOficial() {
		return this.codOficial;
	}

	public void setCodOficial(String codOficial) {
		this.codOficial = codOficial;
	}

	@Column(name = "VALOR_DEFAULT", nullable = false, precision = 22, scale = 0)
	public Integer getIndicaDefault() {
		return this.indicaDefault;
	}

	public void setIndicaDefault(Integer indicaDefault) {
		this.indicaDefault = indicaDefault;
	}

	@Column(name = "ESTATUS", nullable = false, precision = 22, scale = 0)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nomCatPaises")
	public Set<Direccion> getDireccions() {
		return this.direccions;
	}

	public void setDireccions(Set<Direccion> direccions) {
		this.direccions = direccions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nomCatPaises")
	public Set<NomCatEntidades> getNomCatEntidadeses() {
		return this.nomCatEntidadeses;
	}

	public void setNomCatEntidadeses(Set<NomCatEntidades> nomCatEntidadeses) {
		this.nomCatEntidadeses = nomCatEntidadeses;
	}

}
