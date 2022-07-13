package hts.backend.entity;



import hts.backend.entity.PacPeticionArchClinico;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "cat_destino_prestamo_exp")
public class CatDestinoPrestamoExp implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer destinoPrestamoId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer estatus;
	private Integer idiomaAppId;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Set<PacPeticionArchClinico> pacPeticionArchClinicos = new HashSet<PacPeticionArchClinico>(0);

	public CatDestinoPrestamoExp() {
	}
	public CatDestinoPrestamoExp(Integer destinoPrestamoId) {
		this.destinoPrestamoId = destinoPrestamoId;
	}
	public CatDestinoPrestamoExp(Integer destinoPrestamoId, String cve, String nombre, Integer valorDefault,
								 Integer estatus, Integer idiomaAppId, Date fechaRegistro, String usuarioRegistro) {
		this.destinoPrestamoId = destinoPrestamoId;
		this.cve = cve;
		this.nombre = nombre;
		this.valorDefault = valorDefault;
		this.estatus = estatus;
		this.idiomaAppId = idiomaAppId;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistro = usuarioRegistro;
	}

	public CatDestinoPrestamoExp(Integer destinoPrestamoId, String cve, String nombre, String descripcion,
								 Integer valorDefault, Integer estatus, Integer idiomaAppId, Date fechaRegistro,
								 String usuarioRegistro, Set<PacPeticionArchClinico> pacPeticionArchClinicos) {
		this.destinoPrestamoId = destinoPrestamoId;
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valorDefault = valorDefault;
		this.estatus = estatus;
		this.idiomaAppId = idiomaAppId;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistro = usuarioRegistro;
		this.pacPeticionArchClinicos = pacPeticionArchClinicos;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DESTINO_PRESTAMO_EXP_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getDestinoPrestamoId() {
		return this.destinoPrestamoId;
	}

	public void setDestinoPrestamoId(Integer destinoPrestamoId) {
		this.destinoPrestamoId = destinoPrestamoId;
	}

	@Column(name = "CVE", nullable = false, length = 40)
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

	@Column(name = "DESCRIPCION", length = 150)
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

	@Column(name = "IDIOMA_APP_ID", nullable = false, precision = 22, scale = 0)
	public Integer getIdiomaAppId() {
		return this.idiomaAppId;
	}

	public void setIdiomaAppId(Integer idiomaAppId) {
		this.idiomaAppId = idiomaAppId;
	}

	@Temporal(TemporalType.TIMESTAMP)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catDestinoPrestamoExp")
	public Set<PacPeticionArchClinico> getPacPeticionArchClinicos() {
		return this.pacPeticionArchClinicos;
	}

	public void setPacPeticionArchClinicos(Set<PacPeticionArchClinico> pacPeticionArchClinicos) {
		this.pacPeticionArchClinicos = pacPeticionArchClinicos;
	}

}
