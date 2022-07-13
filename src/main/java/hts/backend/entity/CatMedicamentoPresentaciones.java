package hts.backend.entity;
// Generated 15/05/2017 06:36:43 PM by Hibernate Tools 5.2.0.Beta1


import hts.backend.entity.CexMedicamentosMateriales;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * CatMedicamentoPresentaciones generated by hbm2java
 */
@Entity
@Table(name = "cat_medicamento_presentaciones")
public class CatMedicamentoPresentaciones implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer presentacionesId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer defaults;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private CatIdiomaApp catIdiomaApp;
	private Set<CexMedicamentosMateriales> cexMedicamentosMaterialeses = new HashSet<CexMedicamentosMateriales>(0);

	public CatMedicamentoPresentaciones() {
	}

	public CatMedicamentoPresentaciones(Integer presentacionesId, String cve, String nombre, String descripcion,
										Integer defaults, Integer estatus, Date fechaRegistro, String usuarioRegistro) {
		this.presentacionesId = presentacionesId;
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.defaults = defaults;
		this.estatus = estatus;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistro = usuarioRegistro;
	}

	public CatMedicamentoPresentaciones(Integer presentacionesId, String cve, String nombre, String descripcion,
										Integer defaults, Integer estatus, Date fechaRegistro, String usuarioRegistro,
										Set cexMedicamentosMaterialeses) {
		this.presentacionesId = presentacionesId;
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.defaults = defaults;
		this.estatus = estatus;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistro = usuarioRegistro;
		this.cexMedicamentosMaterialeses = cexMedicamentosMaterialeses;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEDICAMENTO_PRESENTACIONES_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getPresentacionesId() {
		return this.presentacionesId;
	}

	public void setPresentacionesId(Integer presentacionesId) {
		this.presentacionesId = presentacionesId;
	}

	@Column(name = "CVE", nullable = false, length = 20)
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
	public Integer getDefaults() {
		return this.defaults;
	}

	public void setDefaults(Integer defaults) {
		this.defaults = defaults;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catMedicamentoPresentaciones")

	public Set<CexMedicamentosMateriales> getCexMedicamentosMaterialeses() {
		return cexMedicamentosMaterialeses;
	}

	public void setCexMedicamentosMaterialeses(Set<CexMedicamentosMateriales> cexMedicamentosMaterialeses) {
		this.cexMedicamentosMaterialeses = cexMedicamentosMaterialeses;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDIOMA_APP_ID" , nullable = false)

	public CatIdiomaApp getCatIdiomaApp() {
		return catIdiomaApp;
	}

	public void setCatIdiomaApp(CatIdiomaApp catIdiomaApp) {
		this.catIdiomaApp = catIdiomaApp;
	}
}
