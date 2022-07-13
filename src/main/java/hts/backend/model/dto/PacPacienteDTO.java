package hts.backend.model.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PacPacienteDTO  implements java.io.Serializable,EntidadDTO {
	private static final long serialVersionUID = 1L;

	private Integer idPaciente;
	private String noExpediente;
	private String nombre;
	private String nombreCompleto;
	private String primerApellido;
	private String segundoApellido;
	private Date fechaNacimiento;
	private Integer fechaEstimada;
	private String curp;
	private Float peso;
	private Float talla;
	private Integer fallecido;
	private Integer migrante;
	private Integer factorRH;
	private Date fechaRegistro;
	private String usuarioRegistra;
	private Integer cupoId;
	private Date horaCupoExtra;
	private Integer idAgendaDetalle;
	private Integer servEspecialidadId;
	private Integer peticionExpG;
	private Integer peticionId;
	private Integer hospitalId;
	private CuposDTO cuposDTO;
	private AgendaCupoDTO cupo;
	private Integer presupuestoId;
	private Integer consId;

	private Set<NomProductoPrestacionDTO> prestaciones = new HashSet<NomProductoPrestacionDTO>(0);
    private Integer profesionalIdResp;

	private TipoExpedienteDTO catTipoExpediente;
	private NomCatOcupacionDTO nomCatOcupacion;
	private NomCatEstadoCivilDTO nomCatEstadoCivil;
	private NomCatEscolaridadDTO nomCatEscolaridad;
	private NomCatNacionalidadesDTO nomCatNacionalidades;
	private CatTipoSangreDTO catTipoSangre;
	private CatProcedenciaDTO catProcedencia;
	private NomCatSexoDTO nomCatSexo;
	private NomCatEntidadesDTO nomCatEntidades;
	private NomCatMunicipioDTO nomCatMunicipio;
	private NomCatReligionDTO nomCatReligion;
	private NomCatSinoDTO indigena;
	private NomCatSinoDTO hablaIndigena;
	private NomCatSinoDTO hablaEspanol;
	private NomCatSinoDTO trabajaActualmente;
	private NomCatTipoLenguaIndigenaDTO nomCatTipoLenguaIndigena;


	private Set<PacAseguradoraDTO> pacAseguradoras = new HashSet<PacAseguradoraDTO>(0);
	private Set<TelefonoDTO> telefonos = new HashSet<TelefonoDTO>(0);
	private Set<PacNotaDTO> pacNotas = new HashSet<PacNotaDTO>(0);
	private Set<CorreoDTO> correos = new HashSet<CorreoDTO>(0);
	private Set<DocumentoDTO> documentos = new HashSet<DocumentoDTO>(0);

	public Integer getFechaEstimada() {
		return fechaEstimada;
	}

	public void setFechaEstimada(Integer fechaEstimada) {
		this.fechaEstimada = fechaEstimada;
	}

	public PacPacienteDTO() {
	}

	public PacPacienteDTO(Integer idPaciente, String noPaciente, String noExpediente, String nombre, String primerApellido, Date fechaNacimiento, Integer sexoId,  Date fechaRegistro, String usuarioRegistra, NomCatSexoDTO nomCatSexo) {
		this.idPaciente = idPaciente;
		this.noExpediente = noExpediente;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.fechaNacimiento = fechaNacimiento;

		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistra = usuarioRegistra;
		this.nomCatSexo = nomCatSexo;
	}

	public PacPacienteDTO(Integer idPaciente, TipoExpedienteDTO catTipoExpediente, NomCatOcupacionDTO nomCatOcupacion,
						  NomCatEstadoCivilDTO nomCatEstadoCivil, NomCatEscolaridadDTO nomCatEscolaridad, CatTipoSangreDTO catTipoSangre,
						  CatProcedenciaDTO catProcedencia, String noPaciente, String noExpediente, String nombre, String primerApellido,
						  String segundoApellido, Date fechaNacimiento, String curp, NomCatNacionalidadesDTO nomCatNacionalidades,
						  NomCatEntidadesDTO nomCatEntidades, NomCatMunicipioDTO nomCatMunicipio, Float peso, Float talla, NomCatSexoDTO nomCatSexo,
						  NomCatReligionDTO nomCatReligion, Integer fallecido,Integer migrante,Integer factorRH,
						  NomCatSinoDTO indigena, NomCatSinoDTO hablaIndigena, NomCatSinoDTO hablaEspanol, NomCatSinoDTO trabajaActualmente,
						  NomCatTipoLenguaIndigenaDTO nomCatTipoLenguaIndigena, Date fechaRegistro, String usuarioRegistra
//			, Set<PacAseguradora> pacAseguradoras, Set<PacPacienteDuplicado> pacPacienteDuplicados
			) {
		this.idPaciente = idPaciente;
		this.catTipoExpediente = catTipoExpediente;
		this.nomCatOcupacion = nomCatOcupacion;
		this.nomCatEstadoCivil = nomCatEstadoCivil;
		this.nomCatEscolaridad = nomCatEscolaridad;
		this.catTipoSangre = catTipoSangre;
		this.catProcedencia = catProcedencia;
		this.noExpediente = noExpediente;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.fechaNacimiento = fechaNacimiento;
		this.curp = curp;
		this.nomCatNacionalidades = nomCatNacionalidades;
		this.nomCatEntidades = nomCatEntidades;
		this.nomCatMunicipio = nomCatMunicipio;
		this.peso = peso;
		this.talla = talla;
		this.nomCatSexo = nomCatSexo;
		this.nomCatReligion = nomCatReligion;
		this.fallecido = fallecido;
		this.migrante = migrante;
		this.factorRH = factorRH;
		this.indigena = indigena;
		this.hablaIndigena = hablaIndigena;
		this.hablaEspanol = hablaEspanol;
		this.trabajaActualmente = trabajaActualmente;
		this.nomCatTipoLenguaIndigena = nomCatTipoLenguaIndigena;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistra = usuarioRegistra;
//		this.pacAseguradoras = pacAseguradoras;
//		this.pacPacienteDuplicados =pacPacienteDuplicados;
	}


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getPresupuestoId() {
		return presupuestoId;
	}

	public void setPresupuestoId(Integer presupuestoId) {
		this.presupuestoId = presupuestoId;
	}

	public Integer getIdPaciente() {
		return this.idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public TipoExpedienteDTO getCatTipoExpediente() {
		return this.catTipoExpediente;
	}

	public void setCatTipoExpediente(TipoExpedienteDTO catTipoExpediente) {
		this.catTipoExpediente = catTipoExpediente;
	}

	public NomCatOcupacionDTO getNomCatOcupacion() {
		return this.nomCatOcupacion;
	}

	public void setNomCatOcupacion(NomCatOcupacionDTO nomCatOcupacion) {
		this.nomCatOcupacion = nomCatOcupacion;
	}

	public NomCatEstadoCivilDTO getNomCatEstadoCivil() {
		return this.nomCatEstadoCivil;
	}

	public void setNomCatEstadoCivil(NomCatEstadoCivilDTO nomCatEstadoCivil) {
		this.nomCatEstadoCivil = nomCatEstadoCivil;
	}

	public NomCatEscolaridadDTO getNomCatEscolaridad() {
		return this.nomCatEscolaridad;
	}

	public void setNomCatEscolaridad(NomCatEscolaridadDTO nomCatEscolaridad) {
		this.nomCatEscolaridad = nomCatEscolaridad;
	}

	public CatTipoSangreDTO getCatTipoSangre() {
		return this.catTipoSangre;
	}

	public void setCatTipoSangre(CatTipoSangreDTO catTipoSangre) {
		this.catTipoSangre = catTipoSangre;
	}

	public CatProcedenciaDTO getCatProcedencia() {
		return this.catProcedencia;
	}

	public NomCatSexoDTO getNomCatSexo() {
		return nomCatSexo;
	}

	public void setNomCatSexo(NomCatSexoDTO nomCatSexo) {
		this.nomCatSexo = nomCatSexo;
	}

	public void setCatProcedencia(CatProcedenciaDTO catProcedencia) {
		this.catProcedencia = catProcedencia;
	}

	public String getNoExpediente() {
		return this.noExpediente;
	}

	public void setNoExpediente(String noExpediente) {
		this.noExpediente = noExpediente;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCurp() {
		return this.curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public NomCatNacionalidadesDTO getNomCatNacionalidades() {
		return nomCatNacionalidades;
	}

	public void setNomCatNacionalidades(NomCatNacionalidadesDTO nomCatNacionalidades) {
		this.nomCatNacionalidades = nomCatNacionalidades;
	}

	public NomCatEntidadesDTO getNomCatEntidades() {
		return this.nomCatEntidades;
	}

	public void setNomCatEntidades(NomCatEntidadesDTO nomCatEntidades) {
		this.nomCatEntidades = nomCatEntidades;
	}

	public NomCatMunicipioDTO getNomCatMunicipio() {
		return this.nomCatMunicipio;
	}

	public void setNomCatMunicipio(NomCatMunicipioDTO nomCatMunicipio) {
		this.nomCatMunicipio = nomCatMunicipio;
	}

	public Float getPeso() {
		return this.peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Float getTalla() {
		return this.talla;
	}

	public void setTalla(Float talla) {
		this.talla = talla;
	}

	public NomCatReligionDTO getNomCatReligion() {
		return nomCatReligion;
	}

	public void setNomCatReligion(NomCatReligionDTO nomCatReligion) {
		this.nomCatReligion = nomCatReligion;
	}

	public Integer getFallecido() {
		return this.fallecido;
	}

	public void setFallecido(Integer fallecido) {
		this.fallecido = fallecido;
	}

	public NomCatSinoDTO getIndigena() {
		return indigena;
	}

	public void setIndigena(NomCatSinoDTO indigena) {
		this.indigena = indigena;
	}

	public NomCatSinoDTO getHablaIndigena() {
		return hablaIndigena;
	}

	public void setHablaIndigena(NomCatSinoDTO hablaIndigena) {
		this.hablaIndigena = hablaIndigena;
	}

	public NomCatSinoDTO getHablaEspanol() {
		return hablaEspanol;
	}

	public void setHablaEspanol(NomCatSinoDTO hablaEspanol) {
		this.hablaEspanol = hablaEspanol;
	}

	public NomCatSinoDTO getTrabajaActualmente() {
		return trabajaActualmente;
	}

	public void setTrabajaActualmente(NomCatSinoDTO trabajaActualmente) {
		this.trabajaActualmente = trabajaActualmente;
	}

	public NomCatTipoLenguaIndigenaDTO getNomCatTipoLenguaIndigena() {
		return nomCatTipoLenguaIndigena;
	}

	public void setNomCatTipoLenguaIndigena(NomCatTipoLenguaIndigenaDTO nomCatTipoLenguaIndigena) {
		this.nomCatTipoLenguaIndigena = nomCatTipoLenguaIndigena;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUsuarioRegistra() {
		return this.usuarioRegistra;
	}

	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}

	@Override
	public Integer getId() {
		return getIdPaciente();
	}

	public Set<TelefonoDTO> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(Set<TelefonoDTO> telefonos) {
		this.telefonos = telefonos;
	}

	public Set<PacNotaDTO> getPacNotas() {
		return pacNotas;
	}

	public void setPacNotas(Set<PacNotaDTO> pacNotas) {
		this.pacNotas = pacNotas;
	}

	public Set<CorreoDTO> getCorreos() {
		return correos;
	}

	public void setCorreos(Set<CorreoDTO> correos) {
		this.correos = correos;
	}

	public Set<DocumentoDTO> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(Set<DocumentoDTO> documentos) {
		this.documentos = documentos;
	}

	public Set<PacAseguradoraDTO> getPacAseguradoras() {
		return pacAseguradoras;
	}

	public void setPacAseguradoras(Set<PacAseguradoraDTO> pacAseguradoras) {
		this.pacAseguradoras = pacAseguradoras;
	}


	public Integer getCupoId() {
		return cupoId;
	}

	public void setCupoId(Integer cupoId) {
		this.cupoId = cupoId;
	}

	public Integer getProfesionalIdResp() {
		return profesionalIdResp;
	}

	public void setProfesionalIdResp(Integer profesionalIdResp) {
		this.profesionalIdResp = profesionalIdResp;
	}

	//	public Set<PacPacienteDuplicado> getPacPacienteDuplicados() {
//		return pacPacienteDuplicados;
//	}
//
//	public void setPacPacienteDuplicados(Set<PacPacienteDuplicado> pacPacienteDuplicados) {
//		this.pacPacienteDuplicados = pacPacienteDuplicados;
//	}


	public Set<NomProductoPrestacionDTO> getPrestaciones() {
		return prestaciones;
	}

	public void setPrestaciones(Set<NomProductoPrestacionDTO> prestaciones) {
		this.prestaciones = prestaciones;
	}

	public Date getHoraCupoExtra() {
		return horaCupoExtra;
	}

	public void setHoraCupoExtra(Date horaCupoExtra) {
		this.horaCupoExtra = horaCupoExtra;
	}

	public Integer getIdAgendaDetalle() {
		return idAgendaDetalle;
	}

	public void setIdAgendaDetalle(Integer idAgendaDetalle) {
		this.idAgendaDetalle = idAgendaDetalle;
	}

	public Integer getServEspecialidadId() {
		return servEspecialidadId;
	}

	public void setServEspecialidadId(Integer servEspecialidadId) {
		this.servEspecialidadId = servEspecialidadId;
	}

	public Integer getPeticionExpG() {
		return peticionExpG;
	}

	public void setPeticionExpG(Integer peticionExpG) {
		this.peticionExpG = peticionExpG;
	}

	public Integer getPeticionId() {
		return peticionId;
	}

	public void setPeticionId(Integer peticionId) {
		this.peticionId = peticionId;
	}


	public String getNombreCompleto() {
		String aux = "";

		if (primerApellido != null) {
			aux = primerApellido;
			if (segundoApellido != null) {
				aux = aux + " " + segundoApellido;
				if (nombre != null) {
					aux = aux + ", " + nombre;
				}
			}
		}
		return aux;
	}

	public void setNombreCompleto(String nombreCOmpleto) {
		this.nombreCompleto = nombreCOmpleto;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public CuposDTO getCuposDTO() {
		return cuposDTO;
	}

	public void setCuposDTO(CuposDTO cuposDTO) {
		this.cuposDTO = cuposDTO;
	}

	public AgendaCupoDTO getCupo() {
		return cupo;
	}

	public void setCupo(AgendaCupoDTO cupo) {
		this.cupo = cupo;
	}

	public Integer getConsId() {
		return consId;
	}

	public void setConsId(Integer consId) {
		this.consId = consId;
	}

	public Integer getMigrante() {
		return migrante;
	}

	public void setMigrante(Integer migrante) {
		this.migrante = migrante;
	}

	public Integer getFactorRH() {
		return factorRH;
	}

	public void setFactorRH(Integer factorRH) {
		this.factorRH = factorRH;
	}
}