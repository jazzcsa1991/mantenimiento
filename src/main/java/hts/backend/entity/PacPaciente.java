package hts.backend.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.context.SecurityContextHolder;

@Entity
@Table(name = "pac_paciente")
public class PacPaciente implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idPaciente;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private Date fechaNacimiento;
	private Integer fechaEstimada;
	private String curp;
	private Float peso;
	private Float talla;
	private Integer fallecido;
	private Date fechaRegistro;
	private String usuarioRegistra;
	private Integer estatus;
	private Integer idPacientePadre;
	private Integer desconocido;
	private Integer catMunicipioId;
	private Integer sexoResumenId;

	private NomCatOcupacion nomCatOcupacion;
	private Integer ocupacionId;
	private NomCatEstadoCivil nomCatEstadoCivil;
	private Integer estadoCivilId;
	private NomCatEscolaridad nomCatEscolaridad;
	private Integer escolaridadId;
	private NomCatNacionalidades nomCatNacionalidades;
	private Integer nacionalidadId;
	private CatTipoSangre catTipoSangre;
	private Integer tipoSangreId;
	private CatProcedencia catProcedencia;
	private Integer procedenciaId;
	private NomCatSexo nomCatSexo;
	private Integer sexoId;
	private NomCatEntidades nomCatEntidades;
	private String entidadCve;
	private NomCatMunicipio nomCatMunicipio;
	private String municipioCve;
	private NomCatReligion nomCatReligion;
	private Integer religionId;
	private NomCatSino indigena;
	private Integer indigenaId;
	private NomCatSino hablaIndigena;
	private Integer hablaIndigenaId;
	private NomCatSino hablaEspanol;
	private Integer hablaEspanolId;
	private NomCatSino trabajaActualmente;
	private Integer trabajaActualmenteId;
	private NomCatTipoLenguaIndigena nomCatTipoLenguaIndigena;
	private Integer tipoLenguaIndigenaId;
	private NomCatTipoRegistro nomCatTipoRegistro;
	private Integer tipoRegistroId;
	private Integer migrante;
	private Integer factorRH;
	private Date fechaIdTipoSangre;
	private Date pacFechaActualizacion;
	private Integer desconoceCurp;
	private String fotoPaciente;
	private Boolean banValidacion;
	private String codigoPostal;

	private Set<PacAseguradora> pacAseguradoras = new HashSet<>(0);
	private Set<PacPacienteDuplicado> pacPacienteDuplicados = new HashSet<>(0);
	private Set<PacNota> pacNotas = new HashSet<>(0);

	@Column(name = "FECHA_ESTIMADA")
	public Integer getFechaEstimada() {
		return fechaEstimada;
	}

	public void setFechaEstimada(Integer fechaEstimada) {
		this.fechaEstimada = fechaEstimada;
	}

	public PacPaciente() {
	}

	public PacPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	// Constructor para nuevos registros
		public PacPaciente(String nombre, String primerApellido, String segundoApellido, Date fechaNacimiento, Integer fechaEstimada, String curp, Integer desconoceCurp, Float peso, Float talla, Integer fallecido, Integer ocupacionId, Integer estadoCivilId, Integer escolaridadId, Integer nacionalidadId, Integer tipoSangreId, Integer procedenciaId, Integer sexoId, String entidadCve, String municipioCve, Integer religionId, Integer indigenaId, Integer hablaIndigenaId, Integer hablaEspanolId, Integer trabajaActualmenteId, Integer tipoLenguaIndigenaId, Integer tipoRegistroId , Integer catMunicipioId, Integer migrante, Integer factorRH, Date fechaIdTipoSangre) {
			this.nombre = nombre;
			this.primerApellido = primerApellido;
			this.segundoApellido = segundoApellido;
			this.fechaNacimiento = fechaNacimiento;
			this.fechaEstimada = fechaEstimada;
			this.curp = curp;
			this.desconoceCurp = desconoceCurp;
			this.peso = peso;
			this.talla = talla;
			this.fallecido = fallecido;
			this.ocupacionId = ocupacionId;
			this.estadoCivilId = estadoCivilId;
			this.escolaridadId = escolaridadId;
			this.nacionalidadId = nacionalidadId;
			this.tipoSangreId = tipoSangreId;
			this.procedenciaId = procedenciaId;
			this.sexoId = sexoId;
			this.entidadCve = entidadCve;
			this.municipioCve = municipioCve;
			this.religionId = religionId;
			this.indigenaId = indigenaId;
			this.hablaIndigenaId = hablaIndigenaId;
			this.hablaEspanolId = hablaEspanolId;
			this.trabajaActualmenteId = trabajaActualmenteId;
			this.tipoLenguaIndigenaId = tipoLenguaIndigenaId;
			this.catMunicipioId = catMunicipioId;
			this.migrante = migrante;
			this.factorRH = factorRH;


			this.usuarioRegistra = SecurityContextHolder.getContext().getAuthentication().getName();
			this.fechaRegistro = new Date();
			this.idPacientePadre = null;
			this.estatus = 1;
			this.desconocido = 0;
			this.tipoLenguaIndigenaId = tipoLenguaIndigenaId;
			this.tipoRegistroId = tipoRegistroId;
			this.fechaIdTipoSangre = fechaIdTipoSangre;
		}

		// Constructor para actualización de registros
		public PacPaciente(Integer idPaciente, String nombre, String primerApellido, String segundoApellido, Date fechaNacimiento, Integer fechaEstimada, String curp , Integer desconoceCurp, Float peso, Float talla, Integer fallecido, Integer ocupacionId, Integer estadoCivilId, Integer escolaridadId, Integer nacionalidadId, Integer tipoSangreId, Integer procedenciaId, Integer sexoId, String entidadCve, String municipioCve, Integer religionId, Integer indigenaId, Integer hablaIndigenaId, Integer hablaEspanolId, Integer trabajaActualmenteId, Integer tipoLenguaIndigenaId , Integer catMunicipioId, Integer migrante, Integer factorRH , Date fechaIdTipoSangre, Date pacFechaActualizacion) {
			this.idPaciente = idPaciente;
			this.nombre = nombre;
			this.primerApellido = primerApellido;
			this.segundoApellido = segundoApellido;
			this.fechaNacimiento = fechaNacimiento;
			this.fechaEstimada = fechaEstimada;
			this.curp = curp;
			this.desconoceCurp = desconoceCurp;
			this.peso = peso;
			this.talla = talla;
			this.fallecido = fallecido;
			this.ocupacionId = ocupacionId;
			this.estadoCivilId = estadoCivilId;
			this.escolaridadId = escolaridadId;
			this.nacionalidadId = nacionalidadId;
			this.tipoSangreId = tipoSangreId;
			this.procedenciaId = procedenciaId;
			this.sexoId = sexoId;
			this.entidadCve = entidadCve;
			this.municipioCve = municipioCve;
			this.religionId = religionId;
			this.indigenaId = indigenaId;
			this.hablaIndigenaId = hablaIndigenaId;
			this.hablaEspanolId = hablaEspanolId;
			this.trabajaActualmenteId = trabajaActualmenteId;
			this.tipoLenguaIndigenaId = tipoLenguaIndigenaId;
			this.catMunicipioId = catMunicipioId;
			this.migrante = migrante;
			this.factorRH = factorRH;
			this.fechaIdTipoSangre = fechaIdTipoSangre;
			this.pacFechaActualizacion = pacFechaActualizacion;


		}

		// Constructor para registro corto
		public PacPaciente(String nombre, String primerApellido, String segundoApellido, Date fechaNacimiento, Integer fechaEstimada, String curp, Float peso, Float talla, Integer fallecido, Integer nacionalidadId, Integer tipoSangreId, Integer procedenciaId, Integer sexoId, String entidadCve, String municipioCve, Integer tipoRegistroId , Integer catMunicipioId) {
			this.nombre = nombre;
			this.primerApellido = primerApellido;
			this.segundoApellido = segundoApellido;
			this.fechaNacimiento = fechaNacimiento;
			this.fechaEstimada = fechaEstimada;
			this.curp = curp;
			this.peso = peso;
			this.talla = talla;
			this.fallecido = fallecido;
			this.nacionalidadId = nacionalidadId;
			this.tipoSangreId = tipoSangreId;
			this.procedenciaId = procedenciaId;
			this.sexoId = sexoId;
			this.entidadCve = entidadCve;
			this.municipioCve = municipioCve;
			this.catMunicipioId = catMunicipioId;



			this.usuarioRegistra = SecurityContextHolder.getContext().getAuthentication().getName();
			this.fechaRegistro = new Date();
			this.idPacientePadre = null;
			this.estatus = 1;
			this.desconocido = 0;
			this.tipoRegistroId = tipoRegistroId;
		}

		// Constructor para registro desconocido
		public PacPaciente(String nombre, String primerApellido, Date fechaNacimiento, Integer fallecido, Integer nacionalidadId, Integer procedenciaId, Integer sexoId, String entidadCve, Integer desconocido, Integer tipoRegistroId ) {
			this.nombre = nombre;
			this.primerApellido = primerApellido;
			this.fechaNacimiento = fechaNacimiento;
			this.fallecido = fallecido;
			this.nacionalidadId = nacionalidadId;
			this.procedenciaId = procedenciaId;
			this.sexoId = sexoId;
			this.entidadCve = entidadCve;



			this.usuarioRegistra = SecurityContextHolder.getContext().getAuthentication().getName();
			this.fechaRegistro = new Date();
			this.idPacientePadre = null;
			this.estatus = 1;
			this.desconocido = desconocido;
			this.tipoRegistroId = tipoRegistroId;
		}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PACIENTE", unique = true, nullable = false, precision = 22)
	public Integer getIdPaciente() {
		return this.idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OCUPACION_ID", updatable = false, insertable = false)
	public NomCatOcupacion getNomCatOcupacion() {
		return this.nomCatOcupacion;
	}

	public void setNomCatOcupacion(NomCatOcupacion nomCatOcupacion) {
		this.nomCatOcupacion = nomCatOcupacion;
	}


	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ESTADO_CIVIL_ID", updatable = false, insertable = false)
	public NomCatEstadoCivil getNomCatEstadoCivil() {
		return this.nomCatEstadoCivil;
	}

	public void setNomCatEstadoCivil(NomCatEstadoCivil nomCatEstadoCivil) {
		this.nomCatEstadoCivil = nomCatEstadoCivil;
	}


	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ESCOLARIDAD_ID", updatable = false, insertable = false)
	public NomCatEscolaridad getNomCatEscolaridad() {
		return this.nomCatEscolaridad;
	}

	public void setNomCatEscolaridad(NomCatEscolaridad nomCatEscolaridad) {
		this.nomCatEscolaridad = nomCatEscolaridad;
	}


	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "TIPO_SANGRE_ID", updatable = false, insertable = false)
	public CatTipoSangre getCatTipoSangre() {
		return this.catTipoSangre;
	}

	public void setCatTipoSangre(CatTipoSangre catTipoSangre) {
		this.catTipoSangre = catTipoSangre;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROCEDENCIA_ID", updatable = false, insertable = false)
	public CatProcedencia getCatProcedencia() {
		return this.catProcedencia;
	}

	public void setCatProcedencia(CatProcedencia catProcedencia) {
		this.catProcedencia = catProcedencia;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SEXO_ID", updatable = false, insertable = false)
	public NomCatSexo getNomCatSexo() {
		return nomCatSexo;
	}

	public void setNomCatSexo(NomCatSexo nomCatSexo) {
		this.nomCatSexo = nomCatSexo;
	}


	@Column(name = "ESTATUS", nullable = false)
	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}


	@Column(name = "ID_PACIENTE_PADRE")
	public Integer getIdPacientePadre() {
		return this.idPacientePadre;
	}

	public void setIdPacientePadre(Integer idPacientePadre) {
		this.idPacientePadre = idPacientePadre;
	}

	@Column(name = "DESCONOCE_CURP")
	public Integer getDesconoceCurp() {
		return this.desconoceCurp;
	}

	public void setDesconoceCurp(Integer desconoceCurp) {
		this.desconoceCurp = desconoceCurp;
	}


	@Column(name = "NOMBRE", nullable = false, length = 20)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Column(name = "PRIMER_APELLIDO", nullable = false, length = 20)
	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}


	@Column(name = "SEGUNDO_APELLIDO", length = 20)
	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_NACIMIENTO", length = 7)
	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	@Column(name = "CURP", length = 20, unique = true)
	public String getCurp() {
		return this.curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NACIONALIDAD_ID", updatable = false, insertable = false)
	public NomCatNacionalidades getNomCatNacionalidades() {
		return nomCatNacionalidades;
	}

	public void setNomCatNacionalidades(NomCatNacionalidades nomCatNacionalidades) {
		this.nomCatNacionalidades = nomCatNacionalidades;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ENTIDAD_NAC_ID", updatable = false, insertable = false)
	public NomCatEntidades getNomCatEntidades() {
		return this.nomCatEntidades;
	}

	public void setNomCatEntidades(NomCatEntidades nomCatEntidades) {
		this.nomCatEntidades = nomCatEntidades;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MUNICIPIO_NAC_ID", updatable = false, insertable = false)
	public NomCatMunicipio getNomCatMunicipio() {
		return this.nomCatMunicipio;
	}

	public void setNomCatMunicipio(NomCatMunicipio nomCatMunicipio) {
		this.nomCatMunicipio = nomCatMunicipio;
	}

	@Column(name = "CAT_MUNICIPIO_ID")
	public Integer getCatMunicipioId() {
		return catMunicipioId;
	}

	public void setCatMunicipioId(Integer catMunicipioId) {
		this.catMunicipioId = catMunicipioId;
	}

	@Column(name = "PESO", precision = 22)
	public Float getPeso() {
		return this.peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}


	@Column(name = "TALLA", precision = 22)
	public Float getTalla() {
		return this.talla;
	}

	public void setTalla(Float talla) {
		this.talla = talla;
	}


	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "RELIGION_ID", updatable = false, insertable = false)
	public NomCatReligion getNomCatReligion() {
		return nomCatReligion;
	}

	public void setNomCatReligion(NomCatReligion nomCatReligion) {
		this.nomCatReligion = nomCatReligion;
	}


	@Column(name = "FALLECIDO", nullable = false)
	public Integer getFallecido() {
		return this.fallecido;
	}

	public void setFallecido(Integer fallecido) {
		this.fallecido = fallecido;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INDIGENA_ID", updatable = false, insertable = false)
	public NomCatSino getIndigena() {
		return indigena;
	}

	public void setIndigena(NomCatSino seConsideraIndigena) {
		this.indigena = seConsideraIndigena;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HABLA_INDIGENA_ID", updatable = false, insertable = false)
	public NomCatSino getHablaIndigena() {
		return hablaIndigena;
	}

	public void setHablaIndigena(NomCatSino hablaIndigena) {
		this.hablaIndigena = hablaIndigena;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HABLA_ESPANOL_ID", updatable = false, insertable = false)
	public NomCatSino getHablaEspanol() {
		return hablaEspanol;
	}

	public void setHablaEspanol(NomCatSino hablaEspanol) {
		this.hablaEspanol = hablaEspanol;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRABAJA_ACTUALMENTE_ID", updatable = false, insertable = false)
	public NomCatSino getTrabajaActualmente() {
		return trabajaActualmente;
	}

	public void setTrabajaActualmente(NomCatSino trabajaActualmente) {
		this.trabajaActualmente = trabajaActualmente;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_LENGUA_INDIGENA_ID", updatable = false, insertable = false)
	public NomCatTipoLenguaIndigena getNomCatTipoLenguaIndigena() {
		return nomCatTipoLenguaIndigena;
	}

	public void setNomCatTipoLenguaIndigena(NomCatTipoLenguaIndigena nomCatTipoLenguaIndigena) {
		this.nomCatTipoLenguaIndigena = nomCatTipoLenguaIndigena;
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
	public String getUsuarioRegistra() {
		return this.usuarioRegistra;
	}

	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}

	@Column(name = "DESCONOCIDO", nullable = false)
	public Integer getDesconocido() {
		return desconocido;
	}

	public void setDesconocido(Integer desconocido) {
		this.desconocido = desconocido;
	}

	@Column(name = "OCUPACION_ID")
	public Integer getOcupacionId() {
		return ocupacionId;
	}

	public void setOcupacionId(Integer ocupacionId) {
		this.ocupacionId = ocupacionId;
	}

	@Column(name = "ESTADO_CIVIL_ID")
	public Integer getEstadoCivilId() {
		return estadoCivilId;
	}

	public void setEstadoCivilId(Integer estadoCivilId) {
		this.estadoCivilId = estadoCivilId;
	}

	@Column(name = "ESCOLARIDAD_ID")
	public Integer getEscolaridadId() {
		return escolaridadId;
	}

	public void setEscolaridadId(Integer escolaridadId) {
		this.escolaridadId = escolaridadId;
	}

	@Column(name = "NACIONALIDAD_ID")
	public Integer getNacionalidadId() {
		return nacionalidadId;
	}

	public void setNacionalidadId(Integer nacionalidadId) {
		this.nacionalidadId = nacionalidadId;
	}

	@Column(name = "TIPO_SANGRE_ID")
	public Integer getTipoSangreId() {
		return tipoSangreId;
	}

	public void setTipoSangreId(Integer tipoSangreId) {
		this.tipoSangreId = tipoSangreId;
	}

	@Column(name = "PROCEDENCIA_ID")
	public Integer getProcedenciaId() {
		return procedenciaId;
	}

	public void setProcedenciaId(Integer procedenciaId) {
		this.procedenciaId = procedenciaId;
	}

	@Column(name = "SEXO_ID")
	public Integer getSexoId() {
		return sexoId;
	}

	public void setSexoId(Integer sexoId) {
		this.sexoId = sexoId;
	}

	@Column(name = "SEXO_RESUMEN_ID")
	public Integer getSexoResumenId() {
		return sexoResumenId;
	}

	public void setSexoResumenId(Integer sexoResumenId) {
		this.sexoResumenId = sexoResumenId;
	}

	@Column(name = "ENTIDAD_NAC_ID")
	public String getEntidadCve() {
		return entidadCve;
	}

	public void setEntidadCve(String entidadCve) {
		this.entidadCve = entidadCve;
	}

	@Column(name = "MUNICIPIO_NAC_ID")
	public String getMunicipioCve() {
		return municipioCve;
	}

	public void setMunicipioCve(String municipioCve) {
		this.municipioCve = municipioCve;
	}

	@Column(name = "RELIGION_ID")
	public Integer getReligionId() {
		return religionId;
	}

	public void setReligionId(Integer religionId) {
		this.religionId = religionId;
	}

	@Column(name = "INDIGENA_ID")
	public Integer getIndigenaId() {
		return indigenaId;
	}

	public void setIndigenaId(Integer indigenaId) {
		this.indigenaId = indigenaId;
	}

	@Column(name = "HABLA_INDIGENA_ID")
	public Integer getHablaIndigenaId() {
		return hablaIndigenaId;
	}

	public void setHablaIndigenaId(Integer hablaIndigenaId) {
		this.hablaIndigenaId = hablaIndigenaId;
	}

	@Column(name = "HABLA_ESPANOL_ID")
	public Integer getHablaEspanolId() {
		return hablaEspanolId;
	}

	public void setHablaEspanolId(Integer hablaEspanolId) {
		this.hablaEspanolId = hablaEspanolId;
	}

	@Column(name = "TRABAJA_ACTUALMENTE_ID")
	public Integer getTrabajaActualmenteId() {
		return trabajaActualmenteId;
	}

	public void setTrabajaActualmenteId(Integer trabajaActualmenteId) {
		this.trabajaActualmenteId = trabajaActualmenteId;
	}

	@Column(name = "TIPO_LENGUA_INDIGENA_ID")
	public Integer getTipoLenguaIndigenaId() {
		return tipoLenguaIndigenaId;
	}

	public void setTipoLenguaIndigenaId(Integer tipoLenguaIndigenaId) {
		this.tipoLenguaIndigenaId = tipoLenguaIndigenaId;
	}

	public void setNomCatTipoRegistro(NomCatTipoRegistro nomCatTipoRegistro) {
		this.nomCatTipoRegistro = nomCatTipoRegistro;
	}

	@Column(name = "TIPO_REGISTRO_ID")
	public Integer getTipoRegistroId() {
		return tipoRegistroId;
	}

	public void setTipoRegistroId(Integer tipoRegistroId) {
		this.tipoRegistroId = tipoRegistroId;
	}


	@Column(name = "PAC_MIGRANTE")
	public Integer getMigrante() {
		return migrante;
	}

	public void setMigrante(Integer migrante) {
		this.migrante = migrante;
	}
	@Column(name = "PAC_FACTOR_RH")
	public Integer getFactorRH() {
		return factorRH;
	}

	public void setFactorRH(Integer factorRH) {
		this.factorRH = factorRH;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PAC_FECHA_ID_TIPO_SANGRE")
	public Date getFechaIdTipoSangre() {
		return fechaIdTipoSangre;
	}

	public void setFechaIdTipoSangre(Date fechaIdTipoSangre) {
		this.fechaIdTipoSangre = fechaIdTipoSangre;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PAC_FECHA_ACTUALIZACION")
	public Date getPacFechaActualizacion() {
		return pacFechaActualizacion;
	}

	public void setPacFechaActualizacion(Date pacFechaActualizacion) {
		this.pacFechaActualizacion = pacFechaActualizacion;
	}

	
	@Column(name = "FOTO_PACIENTE")
	public String getFotoPaciente() {
		return fotoPaciente;
	}

	public void setFotoPaciente(String fotoPaciente) {
		this.fotoPaciente = fotoPaciente;
	}

	@Column(name = "BAN_VALIDACION")
	public Boolean getBanValidacion() {
		return banValidacion;
	}

	public void setBanValidacion(Boolean banValidacion) {
		this.banValidacion = banValidacion;
	}

	@Column(name = "CODIGO_POSTAL")
	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String correo) {
		this.codigoPostal = correo;
	}

}
