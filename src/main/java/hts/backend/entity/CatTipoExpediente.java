package hts.backend.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

// Generated 28/02/2017 11:04:15 AM by Hibernate Tools 5.2.0.Beta1


/**
 * CatTipoExpediente generated by hbm2java
 */
@Entity
@Table(name = "cat_tipo_expediente")
public class CatTipoExpediente implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int tipoExpedienteId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer indicaDefault;
	private Integer status;
	private Date fecha;
	private String usuario;

	public CatTipoExpediente() {
	}

	public CatTipoExpediente(int tipoExpedienteId) {
		this.tipoExpedienteId = tipoExpedienteId;
	}

	public CatTipoExpediente(int tipoExpedienteId, String cve, String nombre, String descripcion, Integer indicaDefault,
							 Integer status, Date fecha, String usuario, //Set<AdmAgendaDetalle> admAgendaDetalles,
							 Set<PacPaciente> pacPacientes) {
		this.tipoExpedienteId = tipoExpedienteId;
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.indicaDefault = indicaDefault;
		this.status = status;
		this.fecha = fecha;
		this.usuario = usuario;
//		this.admAgendaDetalles = admAgendaDetalles;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TIPO_EXPEDIENTE_ID", unique = true, nullable = false, precision = 5, scale = 0)
	public int getTipoExpedienteId() {
		return this.tipoExpedienteId;
	}

	public void setTipoExpedienteId(int tipoExpedienteId) {
		this.tipoExpedienteId = tipoExpedienteId;
	}

	@Column(name = "CVE", length = 5)
	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	@Column(name = "NOMBRE", length = 30)
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

	@Column(name = "VALOR_DEFAULT", precision = 1, scale = 0)
	public Integer getIndicaDefault() {
		return this.indicaDefault;
	}

	public void setIndicaDefault(Integer indicaDefault) {
		this.indicaDefault = indicaDefault;
	}

	@Column(name = "ESTATUS", precision = 1, scale = 0)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", length = 7)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "USUARIO_REGISTRO", length = 30)
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
