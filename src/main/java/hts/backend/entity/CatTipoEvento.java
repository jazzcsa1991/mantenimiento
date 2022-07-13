package hts.backend.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "nom_cat_tipo_evento")
public class CatTipoEvento implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer tipoEventoId;
	private String clave;
	private String nombre;
	private String descripcion;
	private Integer indicaDefault;
	private Integer status;
	private Date fechaRegistro;
	private String usuarioCve;
	private Set<PacEvento> pacEventosByTipoEventoId = new HashSet<>(0);


	public CatTipoEvento() {
	}

	public CatTipoEvento(Integer tipoEventoId) {
		this.tipoEventoId = tipoEventoId;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TIPO_EVENTO_ID", unique = true, nullable = false, precision = 22)
	public Integer getTipoEventoId() {
		return this.tipoEventoId;
	}

	public void setTipoEventoId(Integer tipoEventoId) {
		this.tipoEventoId = tipoEventoId;
	}


	@Column(name = "CVE", precision = 22)
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
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


	@Column(name = "VALOR_DEFAULT", precision = 22)
	public Integer getIndicaDefault() {
		return this.indicaDefault;
	}

	public void setIndicaDefault(Integer indicaDefault) {
		this.indicaDefault = indicaDefault;
	}


	@Column(name = "ESTATUS", precision = 22)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
	public String getUsuarioCve() {
		return this.usuarioCve;
	}

	public void setUsuarioCve(String usuarioCve) {
		this.usuarioCve = usuarioCve;
	}

	@OneToMany(mappedBy = "catTipoEventoByTipoEventoId")
	public Set<PacEvento> getPacEventosByTipoEventoId() {
		return pacEventosByTipoEventoId;
	}

	public void setPacEventosByTipoEventoId(Set<PacEvento> pacEventosByTipoEventoId) {
		this.pacEventosByTipoEventoId = pacEventosByTipoEventoId;
	}
}
