package hts.backend.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "nom_cat_perfil")
public class NomCatPerfil implements java.io.Serializable {

	private Integer perfilId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer status;
	private Date fechaRegistro;
	private String usuarioRegistra;
	private Boolean medico;

	private Set<CatRol> catRols = new HashSet<>();
	private Set<AdmPersonalRol> admPersonalRol = new HashSet<>();


	@Id
	@Column(name = "PERFIL_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getPerfilId() {
		return this.perfilId;
	}

	public void setPerfilId(Integer perfilId) {
		this.perfilId = perfilId;
	}


	@Column(name = "CVE", length = 20)
	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}


	@Column(name = "NOMBRE", length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Column(name = "DESCRIPCION", length = 100)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Column(name = "VALOR_DEFAULT", precision = 22, scale = 0)
	public Integer getValorDefault() {
		return this.valorDefault;
	}

	public void setValorDefault(Integer valorDefault) {
		this.valorDefault = valorDefault;
	}


	@Column(name = "ESTATUS", precision = 22, scale = 0)
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
	public String getUsuarioRegistra() {
		return this.usuarioRegistra;
	}

	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}


	@Column(name = "MEDICO", nullable = false)
	public Boolean getMedico() {
		return medico;
	}

	public void setMedico(Boolean medico) {
		this.medico = medico;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nomCatPerfil")
	public Set<CatRol> getCatRols() {
		return this.catRols;
	}

	public void setCatRols(Set<CatRol> catRols) {
		this.catRols = catRols;
	}
}
