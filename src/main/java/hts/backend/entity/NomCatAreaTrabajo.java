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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(
        name = "nom_cat_area_trabajo"
)
public class NomCatAreaTrabajo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer catAreaTrabajoId;
    private String nombre;
    private String descripcion;
    private boolean indicaDefault;
    private Integer status;
    private String cve;
    private String usuarioCve;
    private Date fechaRegistro;
    private Set<AdmPersonalDatos> admPersonalDatos = new HashSet(0);

    public NomCatAreaTrabajo() {
    }

    public NomCatAreaTrabajo(Integer catAreaTrabajoId, String nombre, String descripcion, boolean indicaDefault, Integer status, String usuarioCve, Date fechaRegistro) {
        this.catAreaTrabajoId = catAreaTrabajoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.indicaDefault = indicaDefault;
        this.status = status;
        this.usuarioCve = usuarioCve;
        this.fechaRegistro = fechaRegistro;
    }

    public NomCatAreaTrabajo(Integer catAreaTrabajoId, String nombre, String descripcion, boolean indicaDefault, Integer status, String cve, String usuarioCve, Date fechaRegistro, Set<AdmPersonalDatos> admPersonalDatos) {
        this.catAreaTrabajoId = catAreaTrabajoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.indicaDefault = indicaDefault;
        this.status = status;
        this.cve = cve;
        this.usuarioCve = usuarioCve;
        this.fechaRegistro = fechaRegistro;
        this.admPersonalDatos = admPersonalDatos;
    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "CAT_AREA_TRABAJO_ID",
            unique = true,
            nullable = false,
            precision = 22,
            scale = 0
    )
    public Integer getCatAreaTrabajoId() {
        return this.catAreaTrabajoId;
    }

    public void setCatAreaTrabajoId(Integer catAreaTrabajoId) {
        this.catAreaTrabajoId = catAreaTrabajoId;
    }

    @Column(
            name = "NOMBRE",
            nullable = false,
            length = 30
    )
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(
            name = "DESCRIPCION",
            nullable = false,
            length = 30
    )
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(
            name = "VALOR_DEFAULT",
            nullable = false,
            precision = 1,
            scale = 0
    )
    public boolean isIndicaDefault() {
        return this.indicaDefault;
    }

    public void setIndicaDefault(boolean indicaDefault) {
        this.indicaDefault = indicaDefault;
    }

    @Column(
            name = "ESTATUS",
            nullable = false,
            precision = 22,
            scale = 0
    )
    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
            mappedBy = "nomCatAreaTrabajo"
    )
    public Set<AdmPersonalDatos> getAdmPersonalDatos() {
        return this.admPersonalDatos;
    }

    public void setAdmPersonalDatos(Set<AdmPersonalDatos> admPersonalDatos) {
        this.admPersonalDatos = admPersonalDatos;
    }
}
