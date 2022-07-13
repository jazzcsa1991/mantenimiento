package hts.backend.entity;
// Generated 15/03/2017 10:07:24 AM by Hibernate Tools 5.2.0.CR1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * NomCatTipoPrestacion2 generated by hbm2java
 */
@Entity
@Table(name = "adm_cat_tipo_prestacion2")
public class NomCatTipoPrestacion2 implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int tipoPrestacion2Id;
	private AdmCatTipoPrestacion3 nomCatTipoPrestacion3;
	private CatIdiomaApp catIdiomaApp;
	private String cve;
	private String nombre;
	private String descripcion;
	private int valorDefault;
	private int estatus;
	private Date fechaRegistro;
	private String usuarioCve;
	private Set<NomCatTipoPrestacion1> nomCatTipoPrestacion1s = new HashSet<NomCatTipoPrestacion1>(0);
	private AdmHospital admHospital;
	private Integer hospitalId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TIPO_PRESTACION2_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public int getTipoPrestacion2Id() {
		return this.tipoPrestacion2Id;
	}

	public void setTipoPrestacion2Id(int tipoPrestacion2Id) {
		this.tipoPrestacion2Id = tipoPrestacion2Id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_PRESTACION3_ID", nullable = false)
	public AdmCatTipoPrestacion3 getNomCatTipoPrestacion3() {
		return this.nomCatTipoPrestacion3;
	}

	public void setNomCatTipoPrestacion3(AdmCatTipoPrestacion3 nomCatTipoPrestacion3) {
		this.nomCatTipoPrestacion3 = nomCatTipoPrestacion3;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDIOMA_APP_ID")
	public CatIdiomaApp getCatIdiomaApp() {
		return this.catIdiomaApp;
	}

	public void setCatIdiomaApp(CatIdiomaApp catIdiomaApp) {
		this.catIdiomaApp = catIdiomaApp;
	}

	@Column(name = "CVE", nullable = false, length = 18)
	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
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
	public int getValorDefault() {
		return this.valorDefault;
	}

	public void setValorDefault(int valorDefault) {
		this.valorDefault = valorDefault;
	}

	@Column(name = "ESTATUS", nullable = false, precision = 22, scale = 0)
	public int getEstatus() {
		return this.estatus;
	}

	public void setEstatus(int estatus) {
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
	public String getUsuarioCve() {
		return this.usuarioCve;
	}

	public void setUsuarioCve(String usuarioCve) {
		this.usuarioCve = usuarioCve;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nomCatTipoPrestacion2")
	public Set<NomCatTipoPrestacion1> getNomCatTipoPrestacion1s() {
		return this.nomCatTipoPrestacion1s;
	}

	public void setNomCatTipoPrestacion1s(Set<NomCatTipoPrestacion1> nomCatTipoPrestacion1s) {
		this.nomCatTipoPrestacion1s = nomCatTipoPrestacion1s;
	}
	@ManyToOne @JoinColumn(name = "HOSPITAL_ID", insertable = false, updatable = false)
	public AdmHospital getAdmHospital() {
		return admHospital;
	}
	public void setAdmHospital(AdmHospital admHospital) {
		this.admHospital = admHospital;
	}
	@Column(name = "HOSPITAL_ID", nullable = false)
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}



}
