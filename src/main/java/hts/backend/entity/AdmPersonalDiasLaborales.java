package hts.backend.entity;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.io.Serializable;
import java.util.Date;
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

@Entity
@Table(
        name = "adm_personal_dias_laborales"
)
public class AdmPersonalDiasLaborales implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer admProfSaludDiasLaboralId;
    private Date horaEntrada;
    private Date horaSalida;
    private Integer lunes;
    private Integer martes;
    private Integer miercoles;
    private Integer jueves;
    private Integer viernes;
    private Integer sabado;
    private Integer domingo;
    private String cve;
    private String descripcion;
    private Integer status;
    private String usuarioCve;
    private Date fechaRegistro;
    private AdmPersonalDatos admPersonalDatos;

    public AdmPersonalDiasLaborales() {
    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "ADM_PROF_SALUD_DIAS_LABORAL_ID",
            unique = true,
            nullable = false
    )
    public Integer getAdmProfSaludDiasLaboralId() {
        return this.admProfSaludDiasLaboralId;
    }

    public void setAdmProfSaludDiasLaboralId(Integer admProfSaludDiasLaboralId) {
        this.admProfSaludDiasLaboralId = admProfSaludDiasLaboralId;
    }

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "ADM_PROF_SALUD_DATAPROF_ID",
            nullable = false
    )
    public AdmPersonalDatos getAdmPersonalDatos() {
        return this.admPersonalDatos;
    }

    public void setAdmPersonalDatos(AdmPersonalDatos admPersonalDatos) {
        this.admPersonalDatos = admPersonalDatos;
    }

    @Column(
            name = "HORA_ENTRADA"
    )
    public Date getHoraEntrada() {
        return this.horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    @Column(
            name = "HORA_SALIDA"
    )
    public Date getHoraSalida() {
        return this.horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    @Column(
            name = "LUNES",
            nullable = false
    )
    public Integer getLunes() {
        return this.lunes;
    }

    public void setLunes(Integer lunes) {
        this.lunes = lunes;
    }

    @Column(
            name = "MARTES",
            nullable = false
    )
    public Integer getMartes() {
        return this.martes;
    }

    public void setMartes(Integer martes) {
        this.martes = martes;
    }

    @Column(
            name = "MIERCOLES",
            nullable = false
    )
    public Integer getMiercoles() {
        return this.miercoles;
    }

    public void setMiercoles(Integer miercoles) {
        this.miercoles = miercoles;
    }

    @Column(
            name = "JUEVES",
            nullable = false
    )
    public Integer getJueves() {
        return this.jueves;
    }

    public void setJueves(Integer jueves) {
        this.jueves = jueves;
    }

    @Column(
            name = "VIERNES",
            nullable = false
    )
    public Integer getViernes() {
        return this.viernes;
    }

    public void setViernes(Integer viernes) {
        this.viernes = viernes;
    }

    @Column(
            name = "SABADO",
            nullable = false
    )
    public Integer getSabado() {
        return this.sabado;
    }

    public void setSabado(Integer sabado) {
        this.sabado = sabado;
    }

    @Column(
            name = "DOMINGO",
            nullable = false
    )
    public Integer getDomingo() {
        return this.domingo;
    }

    public void setDomingo(Integer domingo) {
        this.domingo = domingo;
    }

    @Column(
            name = "CVE",
            length = 10
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
            nullable = false
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
}
