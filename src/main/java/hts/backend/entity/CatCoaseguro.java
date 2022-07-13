package hts.backend.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cat_coaseguro")
public class CatCoaseguro implements java.io.Serializable {

	private Integer coaseguroId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Integer idiomaAppId;
	private Set<PacAseguradora> pacAseguradoras = new HashSet<>(0);


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COASEGURO_ID", unique = true, nullable = false, precision = 22)
	public Integer getCoaseguroId() {
		return coaseguroId;
	}

	public void setCoaseguroId(Integer coaseguroId) {
		this.coaseguroId = coaseguroId;
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


	@Column(name = "VALOR_DEFAULT", nullable = false, precision = 22)
	public Integer getValorDefault() {
		return this.valorDefault;
	}

	public void setValorDefault(Integer valorDefault) {
		this.valorDefault = valorDefault;
	}


	@Column(name = "ESTATUS", nullable = false, precision = 22)
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


	@Column(name = "IDIOMA_APP_ID", precision = 22)
	public Integer getIdiomaAppId() {
		return this.idiomaAppId;
	}

	public void setIdiomaAppId(Integer idiomaAppId) {
		this.idiomaAppId = idiomaAppId;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catCoaseguro")
	public Set<PacAseguradora> getPacAseguradoras() {
		return this.pacAseguradoras;
	}

	public void setPacAseguradoras(Set<PacAseguradora> pacAseguradoras) {
		this.pacAseguradoras = pacAseguradoras;
	}
}
