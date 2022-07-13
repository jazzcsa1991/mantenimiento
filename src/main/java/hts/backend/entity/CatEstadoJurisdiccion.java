package hts.backend.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "nom_cat_estado_jurisdiccion")
public class CatEstadoJurisdiccion {


    private Integer idEstadoJurisdiccion;
    private Integer clave;
    private String nombre;
    private String descripcion;
    private Integer indicaDefault;
    private Integer estatus;
    private Date fechaRegistro;
    private String noUsuario;

    private Set<AdmHospital> admHospitals = new HashSet<AdmHospital>(0);


    public CatEstadoJurisdiccion() {

    }

    public CatEstadoJurisdiccion(Integer idEstadoJurisdiccion, Integer clave, String nombre, String descripcion,
                                 Integer indicaDefault, Integer estatus, Date fechaRegistro, String noUsuario, Set<AdmHospital> admHospitals) {
        super();
        this.idEstadoJurisdiccion = idEstadoJurisdiccion;
        this.clave = clave;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.indicaDefault = indicaDefault;
        this.estatus = estatus;
        this.fechaRegistro = fechaRegistro;
        this.noUsuario = noUsuario;
        this.admHospitals = admHospitals;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ESTADO_JURISDICCION_ID", unique = true, nullable = false)
    public Integer getIdEstadoJurisdiccion() {
        return idEstadoJurisdiccion;
    }

    public void setIdEstadoJurisdiccion(Integer idEstadoJurisdiccion) {
        this.idEstadoJurisdiccion = idEstadoJurisdiccion;
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
    public Integer getIndicaDefault() {
        return indicaDefault;
    }

    public void setIndicaDefault(Integer indicaDefault) {
        this.indicaDefault = indicaDefault;
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
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }


    @Column(name = "USUARIO_REGISTRO")
    public String getNoUsuario() {
        return noUsuario;
    }

    public void setNoUsuario(String noUsuario) {
        this.noUsuario = noUsuario;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "catEstadoJurisdiccion")
    public Set<AdmHospital> getAdmHospitals() {
        return this.admHospitals;
    }

    public void setAdmHospitals(Set<AdmHospital> admHospitals) {
        this.admHospitals = admHospitals;
    }


}

