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
        name = "nom_cat_instituciones"
)
public class NomCatInstituciones implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer catInstitucionesId;
    private Integer insId;
    private String insClave;
    private String insNombreMay;
    private String insNombreMin;
    private String insAbreviatura;
    private Integer insOrden;
    private Integer insVigente;
    private Integer status;
    private String cve;
    private String usuarioCve;
    private Date fechaRegistro;
    private Set<AdmPersonalDatos> admPersonalDatos = new HashSet(0);

    public NomCatInstituciones() {
    }

    public NomCatInstituciones(Integer catInstitucionesId, Integer insId, String insClave, String insNombreMay, String insNombreMin, String insAbreviatura, Integer insOrden, Integer insVigente) {
        this.catInstitucionesId = catInstitucionesId;
        this.insId = insId;
        this.insClave = insClave;
        this.insNombreMay = insNombreMay;
        this.insNombreMin = insNombreMin;
        this.insAbreviatura = insAbreviatura;
        this.insOrden = insOrden;
        this.insVigente = insVigente;
    }

    public NomCatInstituciones(Integer catInstitucionesId, Integer insId, String insClave, String insNombreMay, String insNombreMin, String insAbreviatura, Integer insOrden, Integer insVigente, Integer status, String cve, String usuarioCve, Date fechaRegistro, Set<AdmPersonalDatos> admPersonalDatos) {
        this.catInstitucionesId = catInstitucionesId;
        this.insId = insId;
        this.insClave = insClave;
        this.insNombreMay = insNombreMay;
        this.insNombreMin = insNombreMin;
        this.insAbreviatura = insAbreviatura;
        this.insOrden = insOrden;
        this.insVigente = insVigente;
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
            name = "CAT_INSTITUCIONES_ID",
            unique = true,
            nullable = false,
            precision = 22,
            scale = 0
    )
    public Integer getCatInstitucionesId() {
        return this.catInstitucionesId;
    }

    public void setCatInstitucionesId(Integer catInstitucionesId) {
        this.catInstitucionesId = catInstitucionesId;
    }

    @Column(
            name = "INS_ID",
            nullable = false,
            precision = 22,
            scale = 0
    )
    public Integer getInsId() {
        return this.insId;
    }

    public void setInsId(Integer insId) {
        this.insId = insId;
    }

    @Column(
            name = "INS_CLAVE",
            nullable = false,
            length = 3
    )
    public String getInsClave() {
        return this.insClave;
    }

    public void setInsClave(String insClave) {
        this.insClave = insClave;
    }

    @Column(
            name = "INS_NOMBRE_MAY",
            nullable = false,
            length = 80
    )
    public String getInsNombreMay() {
        return this.insNombreMay;
    }

    public void setInsNombreMay(String insNombreMay) {
        this.insNombreMay = insNombreMay;
    }

    @Column(
            name = "INS_NOMBRE_MIN",
            nullable = false,
            length = 80
    )
    public String getInsNombreMin() {
        return this.insNombreMin;
    }

    public void setInsNombreMin(String insNombreMin) {
        this.insNombreMin = insNombreMin;
    }

    @Column(
            name = "INS_ABREVIATURA",
            nullable = false,
            length = 20
    )
    public String getInsAbreviatura() {
        return this.insAbreviatura;
    }

    public void setInsAbreviatura(String insAbreviatura) {
        this.insAbreviatura = insAbreviatura;
    }

    @Column(
            name = "INS_ORDEN",
            nullable = false,
            precision = 22,
            scale = 0
    )
    public Integer getInsOrden() {
        return this.insOrden;
    }

    public void setInsOrden(Integer insOrden) {
        this.insOrden = insOrden;
    }

    @Column(
            name = "INS_VIGENTE",
            nullable = false,
            precision = 22,
            scale = 0
    )
    public Integer getInsVigente() {
        return this.insVigente;
    }

    public void setInsVigente(Integer insVigente) {
        this.insVigente = insVigente;
    }

    @Column(
            name = "ESTATUS",
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
            mappedBy = "nomCatInstituciones"
    )
    public Set<AdmPersonalDatos> getAdmPersonalDatos() {
        return this.admPersonalDatos;
    }

    public void setAdmPersonalDatos(Set<AdmPersonalDatos> admPersonalDatos) {
        this.admPersonalDatos = admPersonalDatos;
    }
}
