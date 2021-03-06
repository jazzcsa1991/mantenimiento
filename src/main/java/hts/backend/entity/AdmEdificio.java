package hts.backend.entity;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * AdmEdificio generated by hbm2java
 */
@Entity
@Table(name = "adm_edificio")
public class AdmEdificio implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Integer edificioId;
    private AdmHospital admHospital;
    private String nombre;
    private Integer status;
    private Date fechaRegistro;
    private String usuarioCve;
    private Set<AdmPiso> admPisos = new HashSet<>(0);

    public AdmEdificio() {
    }

    public AdmEdificio(Integer edificioId) {
        this.edificioId = edificioId;
    }

    public AdmEdificio(Integer edificioId, AdmHospital admHospital, String nombre, Integer status,
                       Date fechaRegistro, String usuarioCve, Set<AdmPiso> admPisos) {
        this.edificioId = edificioId;
        this.admHospital = admHospital;
        this.nombre = nombre;
        this.status = status;
        this.fechaRegistro = fechaRegistro;
        this.usuarioCve = usuarioCve;
        this.admPisos = admPisos;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EDIFICIO_ID", unique = true, nullable = false)
    public Integer getEdificioId() {
        return this.edificioId;
    }

    public void setEdificioId(Integer edificioId) {
        this.edificioId = edificioId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HOSPITAL_ID")
    public AdmHospital getAdmHospital() {
        return this.admHospital;
    }

    public void setAdmHospital(AdmHospital admHospital) {
        this.admHospital = admHospital;
    }

    @Column(name = "NOMBRE", length = 50)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "ESTATUS")
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "admEdificio")
    public Set<AdmPiso> getAdmPisos() {
        return this.admPisos;
    }

    public void setAdmPisos(Set<AdmPiso> admPisos) {
        this.admPisos = admPisos;
    }

}
