package hts.backend.entity;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(
        name = "nom_cat_actividad_principal"
)
public class NomCatActividadPrincipal implements Serializable {
    private static final long serialVersionUID = 8882551437996780088L;
    private Integer catActividadPrincipalId;
    private String nombre;
    private String descripcion;
    private boolean indicaDefault;
    private Integer status;
    private String cve;
    private String usuarioCve;
    private Date fechaRegistro;

    public NomCatActividadPrincipal() {
    }

    public NomCatActividadPrincipal(Integer catActividadPrincipalId, String nombre, String descripcion, boolean indicaDefault, Integer status, String usuarioCve, Date fechaRegistro) {
        this.catActividadPrincipalId = catActividadPrincipalId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.indicaDefault = indicaDefault;
        this.status = status;
        this.usuarioCve = usuarioCve;
        this.fechaRegistro = fechaRegistro;
    }

    public NomCatActividadPrincipal(Integer catActividadPrincipalId, String nombre, String descripcion, boolean indicaDefault, Integer status, String cve, String usuarioCve, Date fechaRegistro) {
        this.catActividadPrincipalId = catActividadPrincipalId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.indicaDefault = indicaDefault;
        this.status = status;
        this.cve = cve;
        this.usuarioCve = usuarioCve;
        this.fechaRegistro = fechaRegistro;
    }

    @Id
    @Column(
            name = "CAT_ACTIVIDAD_PRINCIPAL_ID",
            unique = true,
            nullable = false
    )
    public Integer getCatActividadPrincipalId() {
        return this.catActividadPrincipalId;
    }

    public void setCatActividadPrincipalId(Integer catActividadPrincipalId) {
        this.catActividadPrincipalId = catActividadPrincipalId;
    }

    @Column(
            name = "NOMBRE",
            nullable = false,
            length = 50
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
            length = 60
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
            nullable = false
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
}
