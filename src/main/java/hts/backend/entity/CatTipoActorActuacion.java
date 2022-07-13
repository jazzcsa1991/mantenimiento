package hts.backend.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SASA Desarrollo on 17/04/2017.
 */
@Entity
@Table(name = "nom_cat_tipo_actor_actuacion")
public class CatTipoActorActuacion implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer tipoActorActuacionId;
	private String clave;
	private String nombre;
	private String descripcion;
	private Integer indicaDefault;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Set<PacActuacion> pacActuacionsByTipoActorActuacionId = new HashSet<PacActuacion>(0);

	public CatTipoActorActuacion() {
	}

	public CatTipoActorActuacion(Integer tipoActorActuacionId) {
		this.tipoActorActuacionId = tipoActorActuacionId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TIPO_ACTOR_ACTUACION_ID") public Integer getTipoActorActuacionId() {
		return tipoActorActuacionId;
	}

	public void setTipoActorActuacionId(Integer tipoActorActuacionId) {
		this.tipoActorActuacionId = tipoActorActuacionId;
	}

	@Basic @Column(name = "CVE") public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Basic @Column(name = "NOMBRE") public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Basic @Column(name = "DESCRIPCION") public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Basic @Column(name = "VALOR_DEFAULT") public Integer getIndicaDefault() {
		return indicaDefault;
	}

	public void setIndicaDefault(Integer indicaDefault) {
		this.indicaDefault = indicaDefault;
	}

	@Basic @Column(name = "ESTATUS") public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@Basic @Column(name = "FECHA_REGISTRO") public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO") public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Override public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CatTipoActorActuacion that = (CatTipoActorActuacion) o;

		if (tipoActorActuacionId != that.tipoActorActuacionId) return false;
		if (indicaDefault != that.indicaDefault) return false;
		if (estatus != that.estatus) return false;
		if (clave != null ? !clave.equals(that.clave) : that.clave != null) return false;
		if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
		if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
		if (fechaRegistro != null ? !fechaRegistro.equals(that.fechaRegistro) : that.fechaRegistro != null)
			return false;
		if (usuarioRegistro != null ? !usuarioRegistro.equals(that.usuarioRegistro) : that.usuarioRegistro != null)
			return false;

		return true;
	}

	@Override public int hashCode() {
		int result = (int) (tipoActorActuacionId ^ (tipoActorActuacionId >>> 32));
		result = 31 * result + (clave != null ? clave.hashCode() : 0);
		result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
		result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
		result = 31 * result + (int) (indicaDefault ^ (indicaDefault >>> 32));
		result = 31 * result + (int) (estatus ^ (estatus >>> 32));
		result = 31 * result + (fechaRegistro != null ? fechaRegistro.hashCode() : 0);
		result = 31 * result + (usuarioRegistro != null ? usuarioRegistro.hashCode() : 0);
		return result;
	}

	@OneToMany(mappedBy = "catTipoActorActuacionByTipoActorActuacionId") public Set<PacActuacion> getPacActuacionsByTipoActorActuacionId() {
		return pacActuacionsByTipoActorActuacionId;
	}

	public void setPacActuacionsByTipoActorActuacionId(Set<PacActuacion> pacActuacionsByTipoActorActuacionId) {
		this.pacActuacionsByTipoActorActuacionId = pacActuacionsByTipoActorActuacionId;
	}
}
