package hts.backend.entity;



import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "cat_triage_pregunta")
public class CatTriagePregunta {

	private Integer triagePreguntaId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Integer idiomaAppId;

	private Set<UrgPreguntaTriage> preguntasTriage;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRIAGE_PREGUNTA_ID", nullable = false)
	public Integer getTriagePreguntaId() {
		return triagePreguntaId;
	}

	public void setTriagePreguntaId(Integer triagePreguntaId) {
		this.triagePreguntaId = triagePreguntaId;
	}

	@Basic
	@Column(name = "CVE", nullable = false)
	public String getCve() {
		return cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	@Basic
	@Column(name = "NOMBRE", nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Basic
	@Column(name = "DESCRIPCION", nullable = false)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Basic
	@Column(name = "VALOR_DEFAULT", nullable = false)
	public Integer getValorDefault() {
		return valorDefault;
	}

	public void setValorDefault(Integer valorDefault) {
		this.valorDefault = valorDefault;
	}

	@Basic
	@Column(name = "ESTATUS", nullable = false)
	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@Basic
	@Column(name = "FECHA_REGISTRO", nullable = false)
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic
	@Column(name = "USUARIO_REGISTRO", nullable = false)
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Basic
	@Column(name = "IDIOMA_APP_ID", nullable = false)
	public Integer getIdiomaAppId() {
		return idiomaAppId;
	}

	public void setIdiomaAppId(Integer idiomaAppId) {
		this.idiomaAppId = idiomaAppId;
	}


	@OneToMany(mappedBy = "catTriagePregunta")
	public Set<UrgPreguntaTriage> getPreguntasTriage() {
		return preguntasTriage;
	}

	public void setPreguntasTriage(Set<UrgPreguntaTriage> preguntaTriage) {
		this.preguntasTriage = preguntaTriage;
	}
}
