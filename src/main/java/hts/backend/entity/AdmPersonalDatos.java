package hts.backend.entity;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//



import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(
        name = "adm_personal_datos"
)
public class AdmPersonalDatos implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer admProfSaludDataprofId;
    private String numeroEmpleado;
    private String codigoPuesto;
    private String descripcionPuesto;
    private Date fechaIngresoInst;
    private Date fechaIngresoReg;
    private Float salario;
    private Integer flagField;
    private Integer flagVigenciaField;
    private Integer flagAtencionCirugia;
    private Integer flagPersonalInterno;
    private Integer flagEstatusRegistro;
    private Integer consultorioSalaId;
    private String certificadoPor;
    private Integer flagResidenciaMedica;
    private String notasMedico;
    private Integer flagTieneAgenda;
    private String cve;
    private String descripcion;
    private Integer status;
    private String usuarioCve;
    private String firmaElectronica;
    private Date fechaRegistro;
    private NomCatJornada nomCatJornada;
    private NomCatTipoContrato nomCatTipoContrato;
    private NomCatAreaTrabajo nomCatAreaTrabajo;
    private NomCatAnioRecidencia nomCatAnioRecidencia;
    private NomCatInstituciones nomCatInstituciones;
    private NomCatTipoPlaza nomCatTipoPlaza;
    private NomCatPersonalMedico nomCatPersonalMedico;
    private AdmPersonal admPersonal;
    private NomCatActividadPrincipal nomCatActividadPrincipal;
    private NomCatEntidades nomCatEntidades;
    private NomCatEspecialidades nomCatEspecialidades;
    private CatClues catCluesByCluesAdscripNominaId;
    private CatClues catCluesByCluesAdscripRealId;
    private Set<AdmPersonalDiasLaborales> admPersonalDiasLaborales = new HashSet(0);
    private Set<AdmPersonalEspecialidades> admPersonalEspecialidadese = new HashSet(0);

    public AdmPersonalDatos() {
    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "ADM_PROF_SALUD_DATAPROF_ID",
            unique = true,
            nullable = false
    )
    public Integer getAdmProfSaludDataprofId() {
        return this.admProfSaludDataprofId;
    }

    public void setAdmProfSaludDataprofId(Integer admProfSaludDataprofId) {
        this.admProfSaludDataprofId = admProfSaludDataprofId;
    }

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "JORNADA_ID",
            nullable = false
    )
    public NomCatJornada getNomCatJornada() {
        return this.nomCatJornada;
    }

    public void setNomCatJornada(NomCatJornada nomCatJornada) {
        this.nomCatJornada = nomCatJornada;
    }

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "TIPO_CONTRATO_ID",
            nullable = false
    )
    public NomCatTipoContrato getNomCatTipoContrato() {
        return this.nomCatTipoContrato;
    }

    public void setNomCatTipoContrato(NomCatTipoContrato nomCatTipoContrato) {
        this.nomCatTipoContrato = nomCatTipoContrato;
    }

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "AREA_SERVICIO_TRABAJO_ID",
            nullable = false
    )
    public NomCatAreaTrabajo getNomCatAreaTrabajo() {
        return this.nomCatAreaTrabajo;
    }

    public void setNomCatAreaTrabajo(NomCatAreaTrabajo nomCatAreaTrabajo) {
        this.nomCatAreaTrabajo = nomCatAreaTrabajo;
    }

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "ANIO_RESIDENCIA_ID"
    )
    public NomCatAnioRecidencia getNomCatAnioRecidencia() {
        return this.nomCatAnioRecidencia;
    }

    public void setNomCatAnioRecidencia(NomCatAnioRecidencia nomCatAnioRecidencia) {
        this.nomCatAnioRecidencia = nomCatAnioRecidencia;
    }

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "INSTITUCION_PERTENENCIA_ID",
            nullable = false
    )
    public NomCatInstituciones getNomCatInstituciones() {
        return this.nomCatInstituciones;
    }

    public void setNomCatInstituciones(NomCatInstituciones nomCatInstituciones) {
        this.nomCatInstituciones = nomCatInstituciones;
    }

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "TIPO_PLAZA_ID",
            nullable = false
    )
    public NomCatTipoPlaza getNomCatTipoPlaza() {
        return this.nomCatTipoPlaza;
    }

    public void setNomCatTipoPlaza(NomCatTipoPlaza nomCatTipoPlaza) {
        this.nomCatTipoPlaza = nomCatTipoPlaza;
    }

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "TIPO_RECURSO_ID",
            nullable = false
    )
    public NomCatPersonalMedico getNomCatPersonalMedico() {
        return this.nomCatPersonalMedico;
    }

    public void setNomCatPersonalMedico(NomCatPersonalMedico nomCatPersonalMedico) {
        this.nomCatPersonalMedico = nomCatPersonalMedico;
    }

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "ACTIVIDAD_PRINCIPAL_ID",
            nullable = false
    )
    public NomCatActividadPrincipal getNomCatActividadPrincipal() {
        return this.nomCatActividadPrincipal;
    }

    public void setNomCatActividadPrincipal(NomCatActividadPrincipal nomCatActividadPrincipal) {
        this.nomCatActividadPrincipal = nomCatActividadPrincipal;
    }

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "ENTIDAD_FEDERATIVA_ID",
            nullable = false
    )
    public NomCatEntidades getNomCatEntidades() {
        return this.nomCatEntidades;
    }

    public void setNomCatEntidades(NomCatEntidades nomCatEntidades) {
        this.nomCatEntidades = nomCatEntidades;
    }

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "ESPECIALIDAD_RESIDENCIA_ID",
            nullable = false
    )
    public NomCatEspecialidades getNomCatEspecialidades() {
        return this.nomCatEspecialidades;
    }

    public void setNomCatEspecialidades(NomCatEspecialidades nomCatEspecialidades) {
        this.nomCatEspecialidades = nomCatEspecialidades;
    }

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "ADM_PROF_SALUD_GRAL_ID",
            nullable = false
    )
    public AdmPersonal getAdmPersonal() {
        return this.admPersonal;
    }

    public void setAdmPersonal(AdmPersonal admPersonal) {
        this.admPersonal = admPersonal;
    }

    @Column(
            name = "NUMERO_EMPLEADO",
            nullable = false,
            length = 20
    )
    public String getNumeroEmpleado() {
        return this.numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    @Column(
            name = "CODIGO_PUESTO",
            nullable = false,
            length = 20
    )
    public String getCodigoPuesto() {
        return this.codigoPuesto;
    }

    public void setCodigoPuesto(String codigoPuesto) {
        this.codigoPuesto = codigoPuesto;
    }

    @Column(
            name = "DESCRIPCION_PUESTO",
            nullable = false,
            length = 70
    )
    public String getDescripcionPuesto() {
        return this.descripcionPuesto;
    }

    public void setDescripcionPuesto(String descripcionPuesto) {
        this.descripcionPuesto = descripcionPuesto;
    }

    @Temporal(TemporalType.DATE)
    @Column(
            name = "FECHA_INGRESO_INST",
            nullable = false,
            length = 7
    )
    public Date getFechaIngresoInst() {
        return this.fechaIngresoInst;
    }

    public void setFechaIngresoInst(Date fechaIngresoInst) {
        this.fechaIngresoInst = fechaIngresoInst;
    }

    @Temporal(TemporalType.DATE)
    @Column(
            name = "FECHA_INGRESO_REG",
            nullable = false,
            length = 7
    )
    public Date getFechaIngresoReg() {
        return this.fechaIngresoReg;
    }

    public void setFechaIngresoReg(Date fechaIngresoReg) {
        this.fechaIngresoReg = fechaIngresoReg;
    }

    @Column(
            name = "SALARIO",
            nullable = false
    )
    public Float getSalario() {
        return this.salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    @Column(
            name = "FLAG_FIELD",
            precision = 1
    )
    public Integer getFlagField() {
        return this.flagField;
    }

    public void setFlagField(Integer flagField) {
        this.flagField = flagField;
    }

    @Column(
            name = "FLAG_VIGENCIA_FIELD",
            precision = 1
    )
    public Integer getFlagVigenciaField() {
        return this.flagVigenciaField;
    }

    public void setFlagVigenciaField(Integer flagVigenciaField) {
        this.flagVigenciaField = flagVigenciaField;
    }

    @Column(
            name = "FLAG_ATENCION_CIRUGIA",
            precision = 1
    )
    public Integer getFlagAtencionCirugia() {
        return this.flagAtencionCirugia;
    }

    public void setFlagAtencionCirugia(Integer flagAtencionCirugia) {
        this.flagAtencionCirugia = flagAtencionCirugia;
    }

    @Column(
            name = "FLAG_PERSONAL_INTERNO",
            precision = 1
    )
    public Integer getFlagPersonalInterno() {
        return this.flagPersonalInterno;
    }

    public void setFlagPersonalInterno(Integer flagPersonalInterno) {
        this.flagPersonalInterno = flagPersonalInterno;
    }

    @Column(
            name = "FLAG_ESTATUS_REGISTRO",
            precision = 1
    )
    public Integer getFlagEstatusRegistro() {
        return this.flagEstatusRegistro;
    }

    public void setFlagEstatusRegistro(Integer flagEstatusRegistro) {
        this.flagEstatusRegistro = flagEstatusRegistro;
    }

    @Column(
            name = "CONSULTORIO_SALA_ID"
    )
    public Integer getConsultorioSalaId() {
        return this.consultorioSalaId;
    }

    public void setConsultorioSalaId(Integer consultorioSalaId) {
        this.consultorioSalaId = consultorioSalaId;
    }

    @Column(
            name = "CERTIFICADO_POR",
            nullable = false,
            length = 200
    )
    public String getCertificadoPor() {
        return this.certificadoPor;
    }

    public void setCertificadoPor(String certificadoPor) {
        this.certificadoPor = certificadoPor;
    }

    @Column(
            name = "FLAG_RESIDENCIA_MEDICA",
            precision = 1
    )
    public Integer getFlagResidenciaMedica() {
        return this.flagResidenciaMedica;
    }

    public void setFlagResidenciaMedica(Integer flagResidenciaMedica) {
        this.flagResidenciaMedica = flagResidenciaMedica;
    }

    @Column(
            name = "NOTAS_MEDICO",
            length = 100
    )
    public String getNotasMedico() {
        return this.notasMedico;
    }

    public void setNotasMedico(String notasMedico) {
        this.notasMedico = notasMedico;
    }

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "CLUES_ADSCRIP_NOMINA_ID",
            nullable = false
    )
    public CatClues getCatCluesByCluesAdscripNominaId() {
        return this.catCluesByCluesAdscripNominaId;
    }

    public void setCatCluesByCluesAdscripNominaId(CatClues catCluesByCluesAdscripNominaId) {
        this.catCluesByCluesAdscripNominaId = catCluesByCluesAdscripNominaId;
    }

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "CLUES_ADSCRIP_REAL_ID",
            nullable = false
    )
    public CatClues getCatCluesByCluesAdscripRealId() {
        return this.catCluesByCluesAdscripRealId;
    }

    public void setCatCluesByCluesAdscripRealId(CatClues catCluesByCluesAdscripRealId) {
        this.catCluesByCluesAdscripRealId = catCluesByCluesAdscripRealId;
    }

    @Column(
            name = "FLAG_TIENE_AGENDA",
            precision = 1
    )
    public Integer getFlagTieneAgenda() {
        return this.flagTieneAgenda;
    }

    public void setFlagTieneAgenda(Integer flagTieneAgenda) {
        this.flagTieneAgenda = flagTieneAgenda;
    }

    @Column(
            name = "CVE",
            length = 20
    )
    public String getCve() {
        return this.cve;
    }

    public void setCve(String cve) {
        this.cve = cve;
    }

    @Column(
            name = "DESCRIPCION",
            length = 60
    )
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(
            name = "ESTATUS",
            nullable = false,
            precision = 1
    )
    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(
            name = "USUARIO_REGISTRO",
            nullable = false,
            length = 20
    )
    public String getUsuarioCve() {
        return this.usuarioCve;
    }

    public void setUsuarioCve(String usuarioCve) {
        this.usuarioCve = usuarioCve;
    }

    @Temporal(TemporalType.DATE)
    @Column(
            name = "FECHA_REGISTRO",
            nullable = false,
            length = 7
    )
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "admPersonalDatos"
    )
    public Set<AdmPersonalDiasLaborales> getAdmPersonalDiasLaborales() {
        return this.admPersonalDiasLaborales;
    }

    public void setAdmPersonalDiasLaborales(Set<AdmPersonalDiasLaborales> admPersonalDiasLaborales) {
        this.admPersonalDiasLaborales = admPersonalDiasLaborales;
    }

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "admPersonalDatos"
    )
    public Set<AdmPersonalEspecialidades> getAdmPersonalEspecialidadese() {
        return this.admPersonalEspecialidadese;
    }

    public void setAdmPersonalEspecialidadese(Set<AdmPersonalEspecialidades> admPersonalEspecialidadese) {
        this.admPersonalEspecialidadese = admPersonalEspecialidadese;
    }

    @Column(
            name = "FIRMA_ELECTRONICA"
    )
    public String getFirmaElectronica() {
        return this.firmaElectronica;
    }

    public void setFirmaElectronica(String firmaElectronica) {
        this.firmaElectronica = firmaElectronica;
    }
}
