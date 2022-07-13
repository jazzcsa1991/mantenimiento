package hts.backend.entity;

import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "direccion")
public class Direccion implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer direccionId;
	private NomCatEntidades nomCatEntidades;
	private Integer nomCatEntidadesId;
	private NomCatMunicipio nomCatMunicipio;
	private Integer nomCatMunicipioId;
	private NomCatLocalidad nomCatLocalidad;
	private Integer nomCatLocalidadId;
	private NomCatCodigoPostal nomCatCodigoPostal;
	private Integer nomCatCodigoPostalId;
	private CatTipoAsen catTipoAsen;
	private Integer catTipoAsenId;
	private NomCatPaises nomCatPaises;
	private Integer nomCatPaisesId;
	private CatVialidad catVialidad;
	private Integer catVialidadId;
	private String calle;
	private String noExt;
	private String noExtLetra;
	private String noInt;
	private String noIntLetra;
	private String nombreVialidad;
	private String nombreAsentamiento;
	private Integer status;
	private Date fechaRegistro;
	private String usuarioCve;
	private String cve;
	private Boolean isDomicilioAlternativo;
	private Set<AgenteDireccion> agenteDireccions = new HashSet<AgenteDireccion>(0);

	public Direccion() {
	}

	// Constructor para registro de direcciones
	public Direccion(String calle, String cve, Integer nomCatEntidadesId, Integer nomCatMunicipioId, Integer nomCatLocalidadId, Integer nomCatCodigoPostalId, Integer catTipoAsenId, Integer nomCatPaisesId, Integer catVialidadId, String noExt, String noExtLetra, String noInt, String noIntLetra, String nombreVialidad, String nombreAsentamiento) {
		this.cve = cve;
		this.nomCatEntidadesId = nomCatEntidadesId;
		this.nomCatMunicipioId = nomCatMunicipioId;
		this.nomCatLocalidadId = nomCatLocalidadId;
		this.nomCatCodigoPostalId = nomCatCodigoPostalId;
		this.catTipoAsenId = catTipoAsenId;
		this.nomCatPaisesId = nomCatPaisesId;
		this.catVialidadId = catVialidadId;
		this.noExt = noExt;
		this.noExtLetra = noExtLetra;
		this.noInt = noInt;
		this.noIntLetra = noIntLetra;
		this.nombreVialidad = nombreVialidad;
		this.nombreAsentamiento = nombreAsentamiento;
		this.calle = calle;

		this.usuarioCve = SecurityContextHolder.getContext().getAuthentication().getName();
		this.status = 1;
		this.fechaRegistro = new Date();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DIRECCION_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getDireccionId() {
		return this.direccionId;
	}

	public void setDireccionId(Integer direccionId) {
		this.direccionId = direccionId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ESTADO_ID", updatable = false, insertable = false)
	public NomCatEntidades getNomCatEntidades() {
		return this.nomCatEntidades;
	}

	public void setNomCatEntidades(NomCatEntidades nomCatEntidades) {
		this.nomCatEntidades = nomCatEntidades;
	}


	@Column(name = "ESTADO_ID")
	public Integer getNomCatEntidadesId() {
		return nomCatEntidadesId;
	}

	public void setNomCatEntidadesId(Integer nomCatEntidadesId) {
		this.nomCatEntidadesId = nomCatEntidadesId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MUNICIPIO_ID", updatable = false, insertable = false)
	public NomCatMunicipio getNomCatMunicipio() {
		return this.nomCatMunicipio;
	}

	public void setNomCatMunicipio(NomCatMunicipio nomCatMunicipio) {
		this.nomCatMunicipio = nomCatMunicipio;
	}


	@Column(name = "MUNICIPIO_ID")
	public Integer getNomCatMunicipioId() {
		return nomCatMunicipioId;
	}

	public void setNomCatMunicipioId(Integer nomCatMunicipioId) {
		this.nomCatMunicipioId = nomCatMunicipioId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOCALIDAD_ID", updatable = false, insertable = false)
	public NomCatLocalidad getNomCatLocalidad() {
		return this.nomCatLocalidad;
	}

	public void setNomCatLocalidad(NomCatLocalidad nomCatLocalidad) {
		this.nomCatLocalidad = nomCatLocalidad;
	}


	@Column(name = "LOCALIDAD_ID")
	public Integer getNomCatLocalidadId() {
		return nomCatLocalidadId;
	}

	public void setNomCatLocalidadId(Integer nomCatLocalidadId) {
		this.nomCatLocalidadId = nomCatLocalidadId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGO_POSTAL_ID", updatable = false, insertable = false)
	public NomCatCodigoPostal getNomCatCodigoPostal() {
		return this.nomCatCodigoPostal;
	}

	public void setNomCatCodigoPostal(NomCatCodigoPostal nomCatCodigoPostal) {
		this.nomCatCodigoPostal = nomCatCodigoPostal;
	}


	@Column(name = "CODIGO_POSTAL_ID")
	public Integer getNomCatCodigoPostalId() {
		return nomCatCodigoPostalId;
	}

	public void setNomCatCodigoPostalId(Integer nomCatCodigoPostalId) {
		this.nomCatCodigoPostalId = nomCatCodigoPostalId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_ASEN_ID", updatable = false, insertable = false)
	public CatTipoAsen getCatTipoAsen() {
		return this.catTipoAsen;
	}

	public void setCatTipoAsen(CatTipoAsen catTipoAsen) {
		this.catTipoAsen = catTipoAsen;
	}


	@Column(name = "TIPO_ASEN_ID")
	public Integer getCatTipoAsenId() {
		return catTipoAsenId;
	}

	public void setCatTipoAsenId(Integer catTipoAsenId) {
		this.catTipoAsenId = catTipoAsenId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAIS_ID", updatable = false, insertable = false)
	public NomCatPaises getNomCatPaises() {
		return this.nomCatPaises;
	}

	public void setNomCatPaises(NomCatPaises nomCatPaises) {
		this.nomCatPaises = nomCatPaises;
	}


	@Column(name = "PAIS_ID")
	public Integer getNomCatPaisesId() {
		return nomCatPaisesId;
	}

	public void setNomCatPaisesId(Integer nomCatPaisesId) {
		this.nomCatPaisesId = nomCatPaisesId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VIALIDAD_ID", updatable = false, insertable = false)
	public CatVialidad getCatVialidad() {
		return this.catVialidad;
	}

	public void setCatVialidad(CatVialidad catVialidad) {
		this.catVialidad = catVialidad;
	}


	@Column(name = "VIALIDAD_ID")
	public Integer getCatVialidadId() {
		return catVialidadId;
	}

	public void setCatVialidadId(Integer catVialidadId) {
		this.catVialidadId = catVialidadId;
	}


	@Column(name = "CALLE", length = 70)
	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}


	@Column(name = "NO_EXT", precision = 22, scale = 0)
	public String getNoExt() {
		return this.noExt;
	}

	public void setNoExt(String noExt) {
		this.noExt = noExt;
	}


	@Column(name = "NO_EXT_LETRA", length = 10)
	public String getNoExtLetra() {
		return this.noExtLetra;
	}

	public void setNoExtLetra(String noExtLetra) {
		this.noExtLetra = noExtLetra;
	}


	@Column(name = "NO_INT", precision = 22, scale = 0)
	public String getNoInt() {
		return this.noInt;
	}

	public void setNoInt(String noInt) {
		this.noInt = noInt;
	}


	@Column(name = "NO_INT_LETRA", length = 10)
	public String getNoIntLetra() {
		return this.noIntLetra;
	}

	public void setNoIntLetra(String noIntLetra) {
		this.noIntLetra = noIntLetra;
	}


	@Column(name = "NOMBRE_VIALIDAD", length = 60)
	public String getNombreVialidad() {
		return this.nombreVialidad;
	}

	public void setNombreVialidad(String nombreVialidad) {
		this.nombreVialidad = nombreVialidad;
	}


	@Column(name = "NOMBRE_ASENTAMIENTO", length = 60)
	public String getNombreAsentamiento() {
		return this.nombreAsentamiento;
	}

	public void setNombreAsentamiento(String nombreAsentamiento) {
		this.nombreAsentamiento = nombreAsentamiento;
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
	public String getUsuarioCve() {
		return this.usuarioCve;
	}

	public void setUsuarioCve(String usuarioCve) {
		this.usuarioCve = usuarioCve;
	}


	@Column(name = "CVE", length = 50)
	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "direccion")
	public Set<AgenteDireccion> getAgenteDireccions() {
		return this.agenteDireccions;
	}

	public void setAgenteDireccions(Set<AgenteDireccion> agenteDireccions) {
		this.agenteDireccions = agenteDireccions;
	}

	@Column(name = "BAN_DOMICILIO_ALTERNATIVO")
	public Boolean getIsDomicilioAlternativo() {
		return isDomicilioAlternativo;
	}

	public void setIsDomicilioAlternativo(Boolean isDomicilioAlternativo) {
		this.isDomicilioAlternativo = isDomicilioAlternativo;
	}
}
