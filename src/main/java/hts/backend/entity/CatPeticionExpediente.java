package hts.backend.entity;



import hts.backend.entity.AdmAgendaDetalle;

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


@Entity
@Table(name = "nom_cat_peticion_expediente")
public class CatPeticionExpediente implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer peticionExpedienteId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistra;
	private Integer idiomaAppId;
	private Set<AdmAgendaDetalle> admAgendaDetalles = new HashSet<AdmAgendaDetalle>(0);

	public CatPeticionExpediente() {
	}
	public CatPeticionExpediente(Integer peticionExpedienteId) {
		this.peticionExpedienteId = peticionExpedienteId;
	}
	public CatPeticionExpediente(Integer peticionExpedienteId, String cve, String nombre, String descripcion,
								 Integer valorDefault, Integer estatus) {
		this.peticionExpedienteId = peticionExpedienteId;
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valorDefault = valorDefault;
		this.estatus = estatus;
	}

	public CatPeticionExpediente(Integer peticionExpedienteId, String cve, String nombre, String descripcion,
								 Integer valorDefault, Integer estatus, Date fechaRegistro, String usuarioRegistra,
								 Integer idiomaAppId, Set<AdmAgendaDetalle> admAgendaDetalles) {
		this.peticionExpedienteId = peticionExpedienteId;
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valorDefault = valorDefault;
		this.estatus = estatus;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistra = usuarioRegistra;
		this.idiomaAppId = idiomaAppId;
		this.admAgendaDetalles = admAgendaDetalles;
	}

	@Id

	@Column(name = "PETICION_EXPEDIENTE_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getPeticionExpedienteId() {
		return this.peticionExpedienteId;
	}

	public void setPeticionExpedienteId(Integer peticionExpedienteId) {
		this.peticionExpedienteId = peticionExpedienteId;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_REGISTRO", length = 7)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Column(name = "USUARIO_REGISTRO", length = 20)
	public String getUsuarioRegistra() {
		return this.usuarioRegistra;
	}

	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}

	@Column(name = "IDIOMA_APP_ID", precision = 22, scale = 0)
	public Integer getIdiomaAppId() {
		return this.idiomaAppId;
	}

	public void setIdiomaAppId(Integer idiomaAppId) {
		this.idiomaAppId = idiomaAppId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catPeticionExpediente")
	public Set<AdmAgendaDetalle> getAdmAgendaDetalles() {
		return this.admAgendaDetalles;
	}

	public void setAdmAgendaDetalles(Set<AdmAgendaDetalle> admAgendaDetalles) {
		this.admAgendaDetalles = admAgendaDetalles;
	}

}
