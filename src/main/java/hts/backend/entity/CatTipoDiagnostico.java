package hts.backend.entity;
// Generated 28/04/2017 03:45:46 PM by Hibernate Tools 5.2.0.Beta1

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CatTipoDiagnostico generated by hbm2java
 */
@Entity
@Table(name = "nom_cat_tipo_diagnostico")
public class CatTipoDiagnostico implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int tipoDiagnosticoId;
	private String cve;
	private String nombre;
	private String descripcion;
	private int defauls;
	private int estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Set<PacDiagnosticoEvento> pacDiagnosticoEventos = new HashSet<PacDiagnosticoEvento>(0);

	public CatTipoDiagnostico() {
	}

	public CatTipoDiagnostico(int tipoDiagnosticoId, String cve, String nombre, String descripcion,
							  int defauls, int estatus, Date fechaRegistro, String usuarioRegistro) {
		this.tipoDiagnosticoId = tipoDiagnosticoId;
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.defauls = defauls;
		this.estatus = estatus;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistro = usuarioRegistro;
	}

	public CatTipoDiagnostico(int tipoDiagnosticoId, String cve, String nombre, String descripcion,
							  int defauls, int estatus, Date fechaRegistro, String usuarioRegistro,
							  Set pacDiagnosticoEventos) {
		this.tipoDiagnosticoId = tipoDiagnosticoId;
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.defauls = defauls;
		this.estatus = estatus;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistro = usuarioRegistro;
		this.pacDiagnosticoEventos = pacDiagnosticoEventos;
	}

	@Id

	@Column(name = "TIPO_DIAGNOSTICO_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public int getTipoDiagnosticoId() {
		return this.tipoDiagnosticoId;
	}

	public void setTipoDiagnosticoId(int tipoDiagnosticoId) {
		this.tipoDiagnosticoId = tipoDiagnosticoId;
	}

	@Column(name = "CVE", nullable = false, length = 20)
	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
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

	@Column(name = "VALOR_DEFAULT", nullable = false, precision = 22, scale = 0)
	public int getDefauls() {
		return this.defauls;
	}

	public void setDefauls(int defauls) {
		this.defauls = defauls;
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
	public String getUsuarioRegistro() {
		return this.usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catTipoDiagnostico")

	public Set<PacDiagnosticoEvento> getPacDiagnosticoEventos() {
		return pacDiagnosticoEventos;
	}

	public void setPacDiagnosticoEventos(Set<PacDiagnosticoEvento> pacDiagnosticoEventos) {
		this.pacDiagnosticoEventos = pacDiagnosticoEventos;
	}
}