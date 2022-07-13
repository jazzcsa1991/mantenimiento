package hts.backend.entity;

import hts.backend.entity.BqrTipoProcedimiento;
import hts.backend.entity.CoreCuidadosClinicos;
import hts.backend.entity.CorePerfilesCuidados;
import hts.backend.entity.CoreTipoCamaPrestacion;
import hts.backend.entity.FacturacionEvento;
import hts.backend.entity.PacEpisodio;
import hts.backend.entity.PrestacionTipoServesp;
import hts.backend.entity.RegistroRangoNse;
import hts.backend.entity.TrsGrupoPreguntas;
import hts.backend.entity.UrgGrupoNivel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "adm_hospital")
public class AdmHospital implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer hospitalId;
	private CatTipoEstablecimiento catTipoEstablecimiento;
	private CatEstadoJurisdiccion catEstadoJurisdiccion;
	private AdmUnidadMedica admUnidadMedica;
	private CatTipoServ catTipoServ;
	private CatVialidad catVialidad;
	private CatJurisdiccion catJurisdiccion;
	private String nombreCorto;
	private String nombre;
	private String clueId;
	private CatClues clues;
	private String cveInstSalud;
	private String cveCtaInstSalud;
	private String calle;
	private String noExt;
	private String noInt;
	private String noExtLetra;
	private String noIntLetra;
	private String estadoCve;
	private String municipioCve;
	private String coloniaCve;
	private String localidadCve;
	private String cpCve;
	private String telefono;
	private String correo;
	private Date fechaRegistro;
	private String usuarioCve;
	private Integer estatus;
	private String claveDependencia;
	private String nombreVialidad;
	private Integer tipoAsen;
	private String claveOid;
	private String licenciaSanitaria;
	private String nombreAsentamiento;
	private String pais;
	private Integer idTipoUnidadPsiq;
	private Integer serHospContinuoId;
	private Integer serHospParcialId;
	private String lada;

	private AdmCatTipoHospital tipoHospital;
	private Integer tipoHospitalId;

	private Set<AdmEdificio> admEdificios = new HashSet<>(0);
	private Set<PrestacionTipoServesp> prestacionTipoServesps = new HashSet<>(0);
	private Set<FacturacionEvento> facturacionEventosByHospitalId;
	private Set<PacEpisodio> pacEpisodiosByHospitalId;
	private Set<AdmTurnos> admTurnos = new HashSet<>(0);
	private Set<BqrTipoProcedimiento> bqrTipoProcedimiento = new HashSet<>(0);
	private Set<CorePerfilesCuidados> corePerfilesCuidadosByHospitalId = new HashSet<>(0);
	private Set<CoreCuidadosClinicos> coreCuidadosClinicosByHospitalId;
	private Set<CoreTipoCamaPrestacion> coreTipoCamaPrestacionsByHospitalId;
	private Set<TrsGrupoPreguntas> trsGrupoPreguntasByHospitalId;
	private Set<UrgGrupoNivel> urgGrupoNivel = new HashSet<>(0);

	private Set<RegistroRangoNse> registroRangoNsesByHospitalId;

	private Integer idClues;
	private Integer rissId;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HOSPITAL_ID", unique = true, nullable = false)
	public Integer getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}


	@Basic
	@Column(name = "NOMBRE_CORTO", length = 20)
	public String getNombreCorto() {
		return this.nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}


	@Basic
	@Column(name = "NOMBRE", length = 250)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Basic
	@Column(name = "CLUE_ID", length = 20)
	public String getClueId() {
		return this.clueId;
	}

	public void setClueId(String clueId) {
		this.clueId = clueId;
	}


	@Basic
	@Column(name = "CVE_INST_SALUD", length = 50)
	public String getCveInstSalud() {
		return this.cveInstSalud;
	}

	public void setCveInstSalud(String cveInstSalud) {
		this.cveInstSalud = cveInstSalud;
	}


	@Basic
	@Column(name = "CVE_CTA_INST_SALUD", length = 50)
	public String getCveCtaInstSalud() {
		return this.cveCtaInstSalud;
	}

	public void setCveCtaInstSalud(String cveCtaInstSalud) {
		this.cveCtaInstSalud = cveCtaInstSalud;
	}


	@Basic
	@Column(name = "CALLE", length = 150)
	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}


	@Basic
	@Column(name = "NO_EXT", length = 50)
	public String getNoExt() {
		return this.noExt;
	}

	public void setNoExt(String noExt) {
		this.noExt = noExt;
	}


	@Basic
	@Column(name = "NO_INT", length = 50)
	public String getNoInt() {
		return this.noInt;
	}

	public void setNoInt(String noInt) {
		this.noInt = noInt;
	}


	@Basic
	@Column(name = "ESTADO_CVE", length = 20)
	public String getEstadoCve() {
		return this.estadoCve;
	}

	public void setEstadoCve(String estadoCve) {
		this.estadoCve = estadoCve;
	}


	@Basic
	@Column(name = "MUNICIPIO_CVE", length = 20)
	public String getMunicipioCve() {
		return this.municipioCve;
	}

	public void setMunicipioCve(String municipioCve) {
		this.municipioCve = municipioCve;
	}


	@Basic
	@Column(name = "COLONIA_CVE", length = 150)
	public String getColoniaCve() {
		return this.coloniaCve;
	}

	public void setColoniaCve(String coloniaCve) {
		this.coloniaCve = coloniaCve;
	}


	@Basic
	@Column(name = "LOCALIDAD_CVE", length = 20)
	public String getLocalidadCve() {
		return this.localidadCve;
	}

	public void setLocalidadCve(String localidadCve) {
		this.localidadCve = localidadCve;
	}


	@Basic
	@Column(name = "CP_CVE", length = 20)
	public String getCpCve() {
		return this.cpCve;
	}

	public void setCpCve(String cpCve) {
		this.cpCve = cpCve;
	}


	@Basic
	@Column(name = "TELEFONO", length = 20)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	@Basic
	@Column(name = "CORREO", length = 50)
	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}


	@Temporal(TemporalType.DATE)
	@Basic
	@Column(name = "FECHA_REGISTRO", length = 7)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@Basic
	@Column(name = "USUARIO_REGISTRO", length = 20)
	public String getUsuarioCve() {
		return this.usuarioCve;
	}

	public void setUsuarioCve(String usuarioCve) {
		this.usuarioCve = usuarioCve;
	}


	@Basic
	@Column(name = "ESTATUS")
	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}


	@Basic
	@Column(name = "CLAVE_DEPENDENCIA", length = 20)
	public String getClaveDependencia() {
		return this.claveDependencia;
	}

	public void setClaveDependencia(String claveDependencia) {
		this.claveDependencia = claveDependencia;
	}


	@Basic
	@Column(name = "NOMBRE_VIALIDAD", length = 20)
	public String getNombreVialidad() {
		return this.nombreVialidad;
	}

	public void setNombreVialidad(String nombreVialidad) {
		this.nombreVialidad = nombreVialidad;
	}


	@Basic
	@Column(name = "TIPO_ASEN")
	public Integer getTipoAsen() {
		return this.tipoAsen;
	}

	public void setTipoAsen(Integer tipoAsen) {
		this.tipoAsen = tipoAsen;
	}


	@Basic
	@Column(name = "CLAVE_OID", length = 30)
	public String getClaveOid() {
		return this.claveOid;
	}

	public void setClaveOid(String claveOid) {
		this.claveOid = claveOid;
	}


	@Basic
	@Column(name = "LICENCIA_SANITARIA", length = 20)
	public String getLicenciaSanitaria() {
		return this.licenciaSanitaria;
	}

	public void setLicenciaSanitaria(String licenciaSanitaria) {
		this.licenciaSanitaria = licenciaSanitaria;
	}


	@Basic
	@Column(name = "NOMBRE_ASENTAMIENTO", length = 50)
	public String getNombreAsentamiento() {
		return this.nombreAsentamiento;
	}

	public void setNombreAsentamiento(String nombreAsentamiento) {
		this.nombreAsentamiento = nombreAsentamiento;
	}


	@Basic
	@Column(name = "PAIS", length = 20)
	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}


	@Basic
	@Column(name = "ID_TIPO_UNIDAD_PSIQ")
	public Integer getIdTipoUnidadPsiq() {
		return this.idTipoUnidadPsiq;
	}

	public void setIdTipoUnidadPsiq(Integer idTipoUnidadPsiq) {
		this.idTipoUnidadPsiq = idTipoUnidadPsiq;
	}


	@Basic
	@Column(name = "SER_HOSP_CONTINUO_ID")
	public Integer getSerHospContinuoId() {
		return this.serHospContinuoId;
	}

	public void setSerHospContinuoId(Integer serHospContinuoId) {
		this.serHospContinuoId = serHospContinuoId;
	}


	@Basic
	@Column(name = "SER_HOSP_PARCIAL_ID")
	public Integer getSerHospParcialId() {
		return this.serHospParcialId;
	}

	public void setSerHospParcialId(Integer serHospParcialId) {
		this.serHospParcialId = serHospParcialId;
	}


	@Basic
	@Column(name = "LADA", length = 5)
	public String getLada() {
		return this.lada;
	}

	public void setLada(String lada) {
		this.lada = lada;
	}


	@Basic
	@Column(name = "NO_EXT_LETRA")
	public String getNoExtLetra() {
		return noExtLetra;
	}

	public void setNoExtLetra(String noExtLetra) {
		this.noExtLetra = noExtLetra;
	}


	@Basic
	@Column(name = "NO_INT_LETRA")
	public String getNoIntLetra() {
		return noIntLetra;
	}

	public void setNoIntLetra(String noIntLetra) {
		this.noIntLetra = noIntLetra;
	}


	@Basic
	@Column(name = "TIPO_HOSPITAL_ID", nullable = false)
	public Integer getTipoHospitalId() {
		return tipoHospitalId;
	}

	public void setTipoHospitalId(Integer tipoHospitalId) {
		this.tipoHospitalId = tipoHospitalId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_ESTABLECIMIENTO")
	public CatTipoEstablecimiento getCatTipoEstablecimiento() {
		return this.catTipoEstablecimiento;
	}

	public void setCatTipoEstablecimiento(CatTipoEstablecimiento catTipoEstablecimiento) {
		this.catTipoEstablecimiento = catTipoEstablecimiento;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ESTADO_JURISDICCION")
	public CatEstadoJurisdiccion getCatEstadoJurisdiccion() {
		return this.catEstadoJurisdiccion;
	}

	public void setCatEstadoJurisdiccion(CatEstadoJurisdiccion catEstadoJurisdiccion) {
		this.catEstadoJurisdiccion = catEstadoJurisdiccion;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_UNIDAD_MEDICA")
	public AdmUnidadMedica getAdmUnidadMedica() {
		return this.admUnidadMedica;
	}

	public void setAdmUnidadMedica(AdmUnidadMedica admUnidadMedica) {
		this.admUnidadMedica = admUnidadMedica;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_SERVICIO")
	public CatTipoServ getCatTipoServ() {
		return this.catTipoServ;
	}

	public void setCatTipoServ(CatTipoServ catTipoServ) {
		this.catTipoServ = catTipoServ;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_VIALIDAD")
	public CatVialidad getCatVialidad() {
		return this.catVialidad;
	}

	public void setCatVialidad(CatVialidad catVialidad) {
		this.catVialidad = catVialidad;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_JURISDICCION")
	public CatJurisdiccion getCatJurisdiccion() {
		return this.catJurisdiccion;
	}

	public void setCatJurisdiccion(CatJurisdiccion catJurisdiccion) {
		this.catJurisdiccion = catJurisdiccion;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "admHospital")
	public Set<AdmEdificio> getAdmEdificios() {
		return this.admEdificios;
	}

	public void setAdmEdificios(Set<AdmEdificio> admEdificios) {
		this.admEdificios = admEdificios;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "admHospital")
	public Set<PrestacionTipoServesp> getPrestacionTipoServesps() {
		return this.prestacionTipoServesps;
	}

	public void setPrestacionTipoServesps(Set<PrestacionTipoServesp> prestacionTipoServesps) {
		this.prestacionTipoServesps = prestacionTipoServesps;
	}

	@OneToMany(mappedBy = "admHospitalByHospitalId")
	public Set<FacturacionEvento> getFacturacionEventosByHospitalId() {
		return facturacionEventosByHospitalId;
	}

	public void setFacturacionEventosByHospitalId(Set<FacturacionEvento> facturacionEventosByHospitalId) {
		this.facturacionEventosByHospitalId = facturacionEventosByHospitalId;
	}


	@OneToMany(mappedBy = "admHospital")
	public Set<PacEpisodio> getPacEpisodiosByHospitalId() {
		return pacEpisodiosByHospitalId;
	}

	public void setPacEpisodiosByHospitalId(Set<PacEpisodio> pacEpisodiosByHospitalId) {
		this.pacEpisodiosByHospitalId = pacEpisodiosByHospitalId;
	}


	@OneToMany(mappedBy = "admHospital")
	public Set<AdmTurnos> getAdmTurnos() {
		return admTurnos;
	}

	public void setAdmTurnos(Set<AdmTurnos> admTurnos) {
		this.admTurnos = admTurnos;
	}


	@OneToMany(mappedBy = "hospital")
	public Set<UrgGrupoNivel> getUrgGrupoNivel() {
		return urgGrupoNivel;
	}

	public void setUrgGrupoNivel(Set<UrgGrupoNivel> urgGrupoNivel) {
		this.urgGrupoNivel = urgGrupoNivel;
	}


	@OneToMany(mappedBy = "admHospital")
	public Set<BqrTipoProcedimiento> getBqrTipoProcedimiento() {
		return bqrTipoProcedimiento;
	}

	public void setBqrTipoProcedimiento(Set<BqrTipoProcedimiento> bqrTipoProcedimiento) {
		this.bqrTipoProcedimiento = bqrTipoProcedimiento;
	}


	@OneToMany(mappedBy = "admHospitalByHospitalId")
	public Set<TrsGrupoPreguntas> getTrsGrupoPreguntasByHospitalId() {
		return trsGrupoPreguntasByHospitalId;
	}

	public void setTrsGrupoPreguntasByHospitalId(Set<TrsGrupoPreguntas> trsGrupoPreguntasByHospitalId) {
		this.trsGrupoPreguntasByHospitalId = trsGrupoPreguntasByHospitalId;
	}


	@ManyToOne
	@JoinColumn(name = "TIPO_HOSPITAL_ID", referencedColumnName = "TIPO_HOSPITAL_ID", updatable = false, insertable = false)
	public AdmCatTipoHospital getTipoHospital() {
		return tipoHospital;
	}

	public void setTipoHospital(AdmCatTipoHospital admCatTipoHospitalByTipoHospitalId) {
		this.tipoHospital = admCatTipoHospitalByTipoHospitalId;
	}


	@OneToMany(mappedBy = "admHospitalByHospitalId")
	public Set<CoreTipoCamaPrestacion> getCoreTipoCamaPrestacionsByHospitalId() {
		return coreTipoCamaPrestacionsByHospitalId;
	}

	public void setCoreTipoCamaPrestacionsByHospitalId(Set<CoreTipoCamaPrestacion> coreTipoCamaPrestacionsByHospitalId) {
		this.coreTipoCamaPrestacionsByHospitalId = coreTipoCamaPrestacionsByHospitalId;
	}


	@OneToMany(mappedBy = "admHospitalByHospitalId")
	public Set<CoreCuidadosClinicos> getCoreCuidadosClinicosByHospitalId() {
		return coreCuidadosClinicosByHospitalId;
	}

	public void setCoreCuidadosClinicosByHospitalId(Set<CoreCuidadosClinicos> coreCuidadosClinicosByHospitalId) {
		this.coreCuidadosClinicosByHospitalId = coreCuidadosClinicosByHospitalId;
	}


	@OneToMany(mappedBy = "admHospitalByHospitalId")
	public Set<CorePerfilesCuidados> getCorePerfilesCuidadosByHospitalId() {
		return corePerfilesCuidadosByHospitalId;
	}

	public void setCorePerfilesCuidadosByHospitalId(Set<CorePerfilesCuidados> corePerfilesCuidadosByHospitalId) {
		this.corePerfilesCuidadosByHospitalId = corePerfilesCuidadosByHospitalId;
	}

	@OneToMany(mappedBy = "admHospitalByHospitalId") public Set<RegistroRangoNse> getRegistroRangoNsesByHospitalId() {
		return registroRangoNsesByHospitalId;
	}

	public void setRegistroRangoNsesByHospitalId(Set<RegistroRangoNse> registroRangoNsesByHospitalId) {
		this.registroRangoNsesByHospitalId = registroRangoNsesByHospitalId;
	}


	@ManyToOne
	@JoinColumn(name = "CLUE_ID", referencedColumnName = "CLUES", updatable = false, insertable = false)
	public CatClues getClues() {
		return clues;
	}

	public void setClues(CatClues clues) {
		this.clues = clues;
	}

	@Basic
	@Column(name = "ID_CLUES", nullable = false)
	public Integer getIdClues() {
		return idClues;
	}

	public void setIdClues(Integer idClues) {
		this.idClues = idClues;
	}

	@Basic
	@Column(name = "RISS_ID", nullable = false)
	public Integer getRissId() {
		return rissId;
	}

	public void setRissId(Integer rissId) {
		this.rissId = rissId;
	}
}
