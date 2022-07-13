package hts.backend.entity;



import hts.backend.entity.PacPeticionArchClinico;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "nom_cat_motivo_peticion_exp")
public class CatMotivoPeticionExp implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer motivoPeticionId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer estatus;
	private Integer idiomaAppId;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Integer diasPrestamo;
	private Set<PacPeticionArchClinico> pacPeticionArchClinicos = new HashSet<PacPeticionArchClinico>(0);

	public CatMotivoPeticionExp() {
	}

	public CatMotivoPeticionExp(Integer motivoPeticionId ) {
		this.motivoPeticionId = motivoPeticionId;
	}
	public CatMotivoPeticionExp(Integer motivoPeticionId, String cve, String nombre, Integer valorDefault,
								Integer estatus, Integer idiomaAppId, Date fechaRegistro, String usuarioRegistro,
								Integer diasPrestamo) {
		this.motivoPeticionId = motivoPeticionId;
		this.cve = cve;
		this.nombre = nombre;
		this.valorDefault = valorDefault;
		this.estatus = estatus;
		this.idiomaAppId = idiomaAppId;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistro = usuarioRegistro;
		this.diasPrestamo = diasPrestamo;
	}

	public CatMotivoPeticionExp(Integer motivoPeticionId, String cve, String nombre, String descripcion,
								Integer valorDefault, Integer estatus, Integer idiomaAppId, Date fechaRegistro,
								String usuarioRegistro, Integer diasPrestamo, Set<PacPeticionArchClinico> pacPeticionArchClinicos) {
		this.motivoPeticionId = motivoPeticionId;
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valorDefault = valorDefault;
		this.estatus = estatus;
		this.idiomaAppId = idiomaAppId;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistro = usuarioRegistro;
		this.diasPrestamo = diasPrestamo;
		this.pacPeticionArchClinicos = pacPeticionArchClinicos;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOTIVO_PETICION_EXP_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getMotivoPeticionId() {
		return this.motivoPeticionId;
	}

	public void setMotivoPeticionId(Integer motivoPeticionId) {
		this.motivoPeticionId = motivoPeticionId;
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

	@Column(name = "DIAS_PRESTAMO", nullable = false, precision = 22, scale = 0)
	public Integer getDiasPrestamo() {
		return this.diasPrestamo;
	}

	public void setDiasPrestamo(Integer diasPrestamo) {
		this.diasPrestamo = diasPrestamo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catMotivoPeticionExp")
	public Set<PacPeticionArchClinico> getPacPeticionArchClinicos() {
		return this.pacPeticionArchClinicos;
	}

	public void setPacPeticionArchClinicos(Set<PacPeticionArchClinico> pacPeticionArchClinicos) {
		this.pacPeticionArchClinicos = pacPeticionArchClinicos;
	}

}

