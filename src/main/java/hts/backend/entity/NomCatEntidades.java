package hts.backend.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "nom_cat_entidades")
public class NomCatEntidades implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer catEntidadesId;
	private NomCatPaises nomCatPaises;
	private String cve;
	private String descripcion;
	private String nombre;
	private Integer indicaDefault;
	private Integer status;
	private String usuarioCve;
	private Date fechaRegistro;
	private Set<Direccion> direccions = new HashSet<Direccion>(0);
	private Set<PacPaciente> pacPacientes = new HashSet<PacPaciente>(0);

	public NomCatEntidades() {
	}

	public NomCatEntidades(Integer catEntidadesId) {
		this.catEntidadesId = catEntidadesId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CAT_ENTIDADES_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getCatEntidadesId() {
		return this.catEntidadesId;
	}

	public void setCatEntidadesId(Integer catEntidadesId) {
		this.catEntidadesId = catEntidadesId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAIS_ID", nullable = false)
	public NomCatPaises getNomCatPaises() {
		return this.nomCatPaises;
	}

	public void setNomCatPaises(NomCatPaises nomCatPaises) {
		this.nomCatPaises = nomCatPaises;
	}


	@Column(name = "CVE", nullable = false, length = 2)
	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}


	@Column(name = "DESCRIPCION", nullable = false, length = 50)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Column(name = "NOMBRE", nullable = false, length = 10)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// @Column(name = "VALOR_DEFAULT", nullable = false, precision = 1, scale =
	// 0)
	// public boolean isIndicaDefault() {
	// return this.indicaDefault;
	// }
	//
	// public void setIndicaDefault(boolean indicaDefault) {
	// this.indicaDefault = indicaDefault;
	// }
	@Column(name = "VALOR_DEFAULT", nullable = false, precision = 1, scale = 0)
	public Integer getIndicaDefault() {
		return indicaDefault;
	}

	public void setIndicaDefault(Integer indicaDefault) {
		this.indicaDefault = indicaDefault;
	}


	@Column(name = "ESTATUS", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	@Column(name = "USUARIO_REGISTRO", nullable = false, length = 20)
	public String getUsuarioCve() {
		return this.usuarioCve;
	}

	public void setUsuarioCve(String usuarioCve) {
		this.usuarioCve = usuarioCve;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", nullable = false, length = 7)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nomCatEntidades")
	public Set<Direccion> getDireccions() {
		return this.direccions;
	}

	public void setDireccions(Set<Direccion> direccions) {
		this.direccions = direccions;
	}

	// @OneToOne(mappedBy="nomCatEntidades")
	// public PacPaciente getPacPaciente() {
	// return pacPaciente;
	// }
	//
	//
	// public void setPacPaciente(PacPaciente pacPaciente) {
	// this.pacPaciente = pacPaciente;
	// }

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nomCatEntidades")
	public Set<PacPaciente> getPacPacientes() {
		return pacPacientes;
	}

	public void setPacPacientes(Set<PacPaciente> pacPacientes) {
		this.pacPacientes = pacPacientes;
	}

}
