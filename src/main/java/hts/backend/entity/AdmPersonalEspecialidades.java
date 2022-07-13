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
        name = "adm_personal_especialidades"
)
public class AdmPersonalEspecialidades implements Serializable {
    private static final long serialVersionUID = -7356131248462472460L;
    private Integer profSaludEspecialidadesId;
    private String cve;
    private Integer status;
    private Date fechaRegistro;
    private String usuarioCve;
    private AdmPersonalDatos admPersonalDatos;
    private CatServEspecialidad catServEspecialidad;

    public AdmPersonalEspecialidades() {
    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "PROF_SALUD_ESPECIALIDADES_ID",
            unique = true,
            nullable = false
    )
    public Integer getProfSaludEspecialidadesId() {
        return this.profSaludEspecialidadesId;
    }

    public void setProfSaludEspecialidadesId(Integer profSaludEspecialidadesId) {
        this.profSaludEspecialidadesId = profSaludEspecialidadesId;
    }

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "SERV_ESPECIALIDAD_ID"
    )
    public CatServEspecialidad getCatServEspecialidad() {
        return this.catServEspecialidad;
    }

    public void setCatServEspecialidad(CatServEspecialidad catServEspecialidad) {
        this.catServEspecialidad = catServEspecialidad;
    }

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "ADM_PROF_SALUD_DATAPROF_ID"
    )
    public AdmPersonalDatos getAdmPersonalDatos() {
        return this.admPersonalDatos;
    }

    public void setAdmPersonalDatos(AdmPersonalDatos admPersonalDatos) {
        this.admPersonalDatos = admPersonalDatos;
    }

    @Column(
            name = "CVE",
            length = 30
    )
    public String getCve() {
        return this.cve;
    }

    public void setCve(String cve) {
        this.cve = cve;
    }

    @Column(
            name = "ESTATUS"
    )
    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Temporal(TemporalType.DATE)
    @Column(
            name = "FECHA_REGISTRO",
            length = 7
    )
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Column(
            name = "USUARIO_REGISTRO",
            length = 20
    )
    public String getUsuarioCve() {
        return this.usuarioCve;
    }

    public void setUsuarioCve(String usuarioCve) {
        this.usuarioCve = usuarioCve;
    }
}
