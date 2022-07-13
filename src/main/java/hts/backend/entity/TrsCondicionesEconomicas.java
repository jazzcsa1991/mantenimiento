package hts.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import hts.backend.entity.CatServEspecialidad;
import hts.backend.entity.PacAseguradora;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Francisco Toscano on 28/06/2017.
 */
@Entity
@Table(name = "trs_condiciones_economicas")
@NamedQueries({
        @NamedQuery(name = "TrsCondicionesEconomicas.test", query = "FROM TrsCondicionesEconomicas"),
        @NamedQuery(name = "TrsCondicionesEconomicas.obtenerEstudioSocioEconomico",
                query = "select trsCondicionesEconomicas.condicionesEconomicasId, "
                        + "pacAseguradoras.folioAsignacion, " //No. Asignación. --Folio asignacion0
                        + "trsCondicionesEconomicas.folio, "//No. Estudio. --Folio Estudio
                        + "trsCondicionesEconomicas.pacConvenioAseguradora.nombre, "//Nivel Socioeconómico. -NSE (cve)
                        + "pacAseguradoras.fechaInicia, "//Fecha Inicio. -- Fecah asignacion
                        + "pacAseguradoras.fechaFin, "//Fecha Fin
                        + "pacAseguradoras.prioridad, "//Prioridad.
                        + "trsCondicionesEconomicas.estatusAsignacion.nombre, "//Estatus.*--Estatus Asignacion
                        + "trsCondicionesEconomicas.catServEspecialidad.catServBasico.admHospital.hospitalId,"
                        + "trsCondicionesEconomicas.catServEspecialidad.catServBasico.admHospital.nombre, "
						+ "trsCondicionesEconomicas.estatusAsignacion.estatusNseId "//Estatus.*--Estatus Asignacion estatusNseId
                        + "from TrsCondicionesEconomicas as trsCondicionesEconomicas "
                        + "left join trsCondicionesEconomicas.pacAseguradora as pacAseguradoras " +
                        "left join trsCondicionesEconomicas.catServEspecialidad as catServEspecialidad " +
                        " left  join catServEspecialidad.catServBasico as catServBasico " +
                        "left join catServBasico.admHospital as admHospital "
                        + "where trsCondicionesEconomicas.pacienteId = ?0"

        ),
        @NamedQuery(name = "TrsCondicionesEconomicas.obtenerReporteCondEconomicaPDF1",
                query = "select new map( "
                        + "trsCondicionesEconomicas.diagnosticoSocial as diagnosticoSocial, "
                        + "trsCondicionesEconomicas.puntajeTotal as puntajeTotal, "
                        + "trsCondicionesEconomicas.usuarioRegistro as usuarioRegistro, "
                        + "trsCondicionesEconomicas.pacienteId as pacienteId, "
                        + "trsCondicionesEconomicas.pacConvenioAseguradora.convenioAseguradoraId as convenioAseguradoraId, "
                        + "trsCondicionesEconomicas.diagnostico as diagnostico, "
                        + "trsCondicionesEconomicas.estatusAsignacion.nombre as diagnosticoMedico, "
                        + "catServEspecialidad.nombre as servicioEspecialidad "
                        + ")"
                        + "from TrsCondicionesEconomicas as trsCondicionesEconomicas "
                        + "inner join trsCondicionesEconomicas.catServEspecialidad as catServEspecialidad "
                        + "where trsCondicionesEconomicas.condicionesEconomicasId = ?0"

        ),
        @NamedQuery(name = "TrsCondicionesEconomicas.obtenerReporteUsuarioPDF2",
                query = "select new map( concat("
                        + "admUsuario.nombre,' ',"
                        + "admUsuario.APaterno,' ',"
                        + "admUsuario.AMaterno "
                        + ") as responsable "
                        + ")"
                        + "from AdmUsuario as admUsuario "
                        + "where admUsuario.username = ?0"
        ),
        @NamedQuery(name = "TrsCondicionesEconomicas.obtenerReportePacientePDF3",
                query = "select new map( " +
                        "CONCAT(pacPaciente.nombre , ' ', pacPaciente.primerApellido, ' ', " +
                        "CASE WHEN pacPaciente.segundoApellido IS NULL THEN '' ELSE pacPaciente" +
                        ".segundoApellido END) as paciente ,"
                        + "pacPaciente.fechaNacimiento as fechaNacimiento, "
                        + "pacPaciente.nomCatSexo.descripcion as sexo "
                        + ")"
                        + "from PacPaciente as pacPaciente "
                        + "where pacPaciente.idPaciente = ?0"
        ),
        @NamedQuery(name = "TrsCondicionesEconomicas.obtenerReporteExpedientePDF4",
                query = "select new map("
                        + "pacExpediente.noExpediente as noExpediente"
                        + ")"
                        + "from PacExpediente as pacExpediente "
                        + "where pacExpediente.pacienteId = ?0 and pacExpediente.hospitalId = ?0"
        ),
        @NamedQuery(name = "TrsCondicionesEconomicas.obtenerReporteNivelSocioEconomicoAsignadoPDF5",
                query = "select new map( concat("
                        + "registroRangoNse.descripcionNse,'(',"
                        + "registroRangoNse.limiteInferior,'% -',"
                        + "registroRangoNse.limiteSuperior || '%)'"
                        + ") as nivelSocioEconomicoAsignado "
                        + ")"
                        + "from RegistroRangoNse as registroRangoNse "
                        + "where registroRangoNse.convenioAseguradoraId.convenioAseguradoraId = ?0"
        ),
        @NamedQuery(name = "TrsCondicionesEconomicas.obtenerReporteDiagnosticoMedicoPDF6",
                query = "select new map( "
                        + "nomCatCie10.nombre as diagnosticoMedico"
                        + ")"
                        + "from NomCatCie10 as nomCatCie10 "
                        + "where nomCatCie10.cie10Id = ?0"
        )


})

public class TrsCondicionesEconomicas implements java.io.Serializable {

    private Long condicionesEconomicasId;
    @JsonManagedReference(value = "condEconomToEstudioResp")
    /*@JsonBackReference(value="condEconomToEstudioResp")*/
    private Set<TrsEstudioRespuestas> trsEstudioRespuestas = new HashSet<TrsEstudioRespuestas>(0);
    /*@JsonManagedReference(value="condEconomToTrsAnulaNSE")*/
    /*@JsonIgnore*/
    @JsonIgnore
    private Set<TrsAnulacionNse> trsAnulacionNses = new HashSet<TrsAnulacionNse>(0);
    private Long puntajeTotal;
    private Date fechaRegistro;
    private String usuarioRegistro;
    private String diagnosticoSocial;


    private CatServEspecialidad catServEspecialidad;


    private Long pacienteId;
    //@JsonIgnore
//	@JsonManagedReference(value="condTrsCondicionesEconomicasToCatEstatusNse")
    @JsonBackReference(value = "condTrsCondicionesEconomicasToCatEstatusNse")
    private TrsEstatusNse estatusAsignacion;
    private Date fechaAsignacion;
    private Long diagnostico;
    private String trabajadorSocial;


    private String folio;

    @JsonBackReference(value = "condConvAsegToCondEcon")
    private PacConvenioAseguradora pacConvenioAseguradora;

    /*private String folioAsignacion;//*/
    @JsonIgnore
    private PacAseguradora pacAseguradora;

    /*@OneToOne(fetch = FetchType.LAZY, mappedBy = "trsCondicionesEconomicas" )//Original*/
    @OneToOne
    @JoinColumn(name = "FOLIO_ASIGNACION", referencedColumnName = "FOLIO_ASIGNACION")
    public PacAseguradora getPacAseguradora() {
        return pacAseguradora;
    }

    public void setPacAseguradora(PacAseguradora pacAseguradora) {
        this.pacAseguradora = pacAseguradora;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONDICIONES_ECONOMICAS_ID")
    public Long getCondicionesEconomicasId() {
        return condicionesEconomicasId;
    }

    public void setCondicionesEconomicasId(Long condicionesEconomicasId) {
        this.condicionesEconomicasId = condicionesEconomicasId;
    }


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "trsCondicionesEconomicas", cascade = {CascadeType.ALL})
    public Set<TrsEstudioRespuestas> getTrsEstudioRespuestas() {
        return trsEstudioRespuestas;
    }

    public void setTrsEstudioRespuestas(Set<TrsEstudioRespuestas> trsEstudioRespuestas) {
        this.trsEstudioRespuestas = trsEstudioRespuestas;
    }


    @Basic
    @Column(name = "PUNTAJE_TOTAL")
    public Long getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(Long puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }


    @Basic
    @Column(name = "FECHA_REGISTRO", updatable = false)
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }


    @Basic
    @Column(name = "USUARIO_REGISTRO", updatable = false)
    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }


    @Basic
    @Column(name = "DIAGNOSTICO_SOCIAL")
    public String getDiagnosticoSocial() {
        return diagnosticoSocial;
    }

    public void setDiagnosticoSocial(String diagnosticoSocial) {
        this.diagnosticoSocial = diagnosticoSocial;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SERV_ESPECIALIDAD_ID")
    public CatServEspecialidad getCatServEspecialidad() {
        return catServEspecialidad;
    }

    public void setCatServEspecialidad(CatServEspecialidad catServEspecialidad) {
        this.catServEspecialidad = catServEspecialidad;
    }


    @Basic
    @Column(name = "PACIENTE_ID")
    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "ESTATUS_ASIGNACION", nullable = false)
    public TrsEstatusNse getEstatusAsignacion() {
        return estatusAsignacion;
    }

    public void setEstatusAsignacion(TrsEstatusNse estatusAsignacion) {
        this.estatusAsignacion = estatusAsignacion;
    }


    @Basic
    @Column(name = "FECHA_ASIGNACION")
    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }


    @Basic
    @Column(name = "CIE_10_ID")
    public Long getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Long diagnostico) {
        this.diagnostico = diagnostico;
    }


    @Basic
    @Column(name = "TRABAJADOR_SOCIAL")
    public String getTrabajadorSocial() {
        return trabajadorSocial;
    }

    public void setTrabajadorSocial(String trabajadorSocial) {
        this.trabajadorSocial = trabajadorSocial;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONVENIO_ASEGURADORA_ID", nullable = false)
    public PacConvenioAseguradora getPacConvenioAseguradora() {
        return pacConvenioAseguradora;
    }

    public void setPacConvenioAseguradora(PacConvenioAseguradora pacConvenioAseguradora) {
        this.pacConvenioAseguradora = pacConvenioAseguradora;
    }


    @Basic
    @Column(name = "FOLIO", updatable = false)
    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }


    @Override
    public String toString() {
        return "OBJECT::" + this.hashCode()
                + " condicionesEconomicasId::" + this.condicionesEconomicasId
                + " puntajeTotal::" + this.puntajeTotal
                + " fechaRegistro::" + this.fechaRegistro
                + " usuarioRegistro::" + this.usuarioRegistro
                + " diagnosticoSocial::" + this.diagnosticoSocial
                + " pacienteId::" + this.pacienteId
                + " estatusAsignacion::" + this.estatusAsignacion
                + " fechaAsignacion::" + this.fechaAsignacion
                + " diagnostico::" + this.diagnostico
                + " trabajadorSocial::" + this.trabajadorSocial;
    }

    @OneToMany(mappedBy = "trsCondicionesEconomicas")
    public Set<TrsAnulacionNse> getTrsAnulacionNses() {
        return trsAnulacionNses;
    }

    public void setTrsAnulacionNses(Set<TrsAnulacionNse> trsAnulacionNses) {
        this.trsAnulacionNses = trsAnulacionNses;
    }
}
