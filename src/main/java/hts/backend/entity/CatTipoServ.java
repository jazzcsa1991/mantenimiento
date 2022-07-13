package hts.backend.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * @author glend
 */
@Entity
@Table(name = "cat_tipo_serv")
public class CatTipoServ implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idtiposerv;
    private Integer clave;
    private String nombre;
    private String descripcion;
    private Integer indicadefault;
    private Integer estatus;
    private Date fecharegistro;
    private String nousuario;
    private Set<AdmHospital> admHospitals = new HashSet<AdmHospital>(0);

    public CatTipoServ() {


    }


    public CatTipoServ(Integer idtiposerv, Integer clave, String nombre, String descripcion, Integer indicadefault, Integer estatus, Date fecharegistro, String nousuario) {

        this.idtiposerv = idtiposerv;
        this.clave = clave;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.indicadefault = indicadefault;
        this.estatus = estatus;
        this.fecharegistro = fecharegistro;
        this.nousuario = nousuario;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIPO_SERV_ID", unique = true, nullable = false, precision = 22)
    public Integer getIdtiposerv() {
        return idtiposerv;
    }

    public void setIdtiposerv(Integer idtiposerv) {
        this.idtiposerv = idtiposerv;
    }

    @Column(name = "CVE")
    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    @Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "VALOR_DEFAULT")
    public Integer getIndicadefault() {
        return indicadefault;
    }

    public void setIndicadefault(Integer indicadefault) {
        this.indicadefault = indicadefault;
    }

    @Column(name = "ESTATUS")
    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_REGISTRO", length = 7)
    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    @Column(name = "USUARIO_REGISTRO")
    public String getNousuario() {
        return nousuario;
    }

    public void setNousuario(String nousuario) {
        this.nousuario = nousuario;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "catTipoServ")
    public Set<AdmHospital> getAdmHospitals() {
        return this.admHospitals;
    }

    public void setAdmHospitals(Set<AdmHospital> admHospitals) {
        this.admHospitals = admHospitals;
    }
}
