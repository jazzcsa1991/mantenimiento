package hts.backend.entity;



import hts.backend.entity.CexPrescripcionesMedicamento;
import hts.backend.entity.CexReceta;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * CatTipoPrescripcion generated by hbm2java
 */
@Entity
@Table(name = "nom_cat_tipo_prescripcion")
public class CatTipoPrescripcion implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private int tipoPrescripcionId;
    private String cve;
    private String nombre;
    private String descripcion;
    private int defaults;
    private int estatus;
    private Date fechaResgistro;
    private String usuarioRegistro;
    private Set<CorePautaPrescripcion> corePautaPrescripcions = new HashSet<CorePautaPrescripcion>(0);
    private Set<CexPrescripcionesMedicamento> cexPrescripcionesMedicamentos = new HashSet<CexPrescripcionesMedicamento>(0);
    private CatIdiomaApp catIdiomaAppByIdiomaAppId;

    public CatTipoPrescripcion() {
    }

    public CatTipoPrescripcion(int tipoPrescripcionId, String cve, String nombre, String descripcion,
                               int defaults, int estatus, Date fechaResgistro, String usuarioRegistro) {
        this.tipoPrescripcionId = tipoPrescripcionId;
        this.cve = cve;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.defaults = defaults;
        this.estatus = estatus;
        this.fechaResgistro = fechaResgistro;
        this.usuarioRegistro = usuarioRegistro;
    }

    public CatTipoPrescripcion(int tipoPrescripcionId, String cve, String nombre, String descripcion,
                               int defaults, int estatus, Date fechaResgistro, String usuarioRegistro,
                               Set corePautaPrescripcions, Set cexPrescripcionesMedicamentos) {
        this.tipoPrescripcionId = tipoPrescripcionId;
        this.cve = cve;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.defaults = defaults;
        this.estatus = estatus;
        this.fechaResgistro = fechaResgistro;
        this.usuarioRegistro = usuarioRegistro;
        this.corePautaPrescripcions = corePautaPrescripcions;
        this.cexPrescripcionesMedicamentos = cexPrescripcionesMedicamentos;
    }

    @Id

    @Column(name = "TIPO_PRESCRIPCION_ID", unique = true, nullable = false, precision = 22, scale = 0)
    public int getTipoPrescripcionId() {
        return this.tipoPrescripcionId;
    }

    public void setTipoPrescripcionId(int tipoPrescripcionId) {
        this.tipoPrescripcionId = tipoPrescripcionId;
    }

    @Column(name = "CVE", nullable = false, length = 20)
    public String getCve() {
        return this.cve;
    }

    public void setCve(String cve) {
        this.cve = cve;
    }

    @Column(name = "NOMBRE", nullable = false, length = 20)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "DESCRIPCION", nullable = false, length = 20)
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "VALOR_DEFAULT", nullable = false, precision = 22, scale = 0)
    public int getDefaults() {
        return this.defaults;
    }

    public void setDefaults(int defaults) {
        this.defaults = defaults;
    }

    @Column(name = "ESTATUS", nullable = false, precision = 22, scale = 0)
    public int getEstatus() {
        return this.estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_REGISTRO", nullable = false, length = 7)
    public Date getFechaResgistro() {
        return this.fechaResgistro;
    }

    public void setFechaResgistro(Date fechaResgistro) {
        this.fechaResgistro = fechaResgistro;
    }

    @Column(name = "USUARIO_REGISTRO", nullable = false, length = 20)
    public String getUsuarioRegistro() {
        return this.usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "catTipoPrescripcion")
    public Set<CorePautaPrescripcion> getCorePautaPrescripcions() {
        return corePautaPrescripcions;
    }

    public void setCorePautaPrescripcions(Set<CorePautaPrescripcion> corePautaPrescripcions) {
        this.corePautaPrescripcions = corePautaPrescripcions;
    }

    @ManyToOne @JoinColumn(name = "IDIOMA_APP_ID", referencedColumnName = "IDIOMA_APP_ID", nullable = false) public CatIdiomaApp getCatIdiomaAppByIdiomaAppId() {
        return catIdiomaAppByIdiomaAppId;
    }

    public void setCatIdiomaAppByIdiomaAppId(CatIdiomaApp catIdiomaAppByIdiomaAppId) {
        this.catIdiomaAppByIdiomaAppId = catIdiomaAppByIdiomaAppId;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "catTipoPrescripcion")
    public Set<CexPrescripcionesMedicamento> getCexRecetas() {
        return this.cexPrescripcionesMedicamentos;
    }

    public void setCexRecetas(Set<CexPrescripcionesMedicamento> cexRecetas) {
        this.cexPrescripcionesMedicamentos = cexRecetas;
    }
}
