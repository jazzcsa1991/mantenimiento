package hts.backend.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "nom_cat_jurisdiccion")
public class CatJurisdiccion implements Serializable {


    private static final long serialVersionUID = 1L;


    private Integer catJurisdiccionId;
    private String edo;
    private String jur;
    private String descripcion;
    private Integer estatus;
    private Date fechaRegistro;
    private String noUsuario;
    private Set<AdmHospital> admHospitals = new HashSet<AdmHospital>(0);


    public CatJurisdiccion(){

    }


    public CatJurisdiccion(Integer catJurisdiccionId, String edo, String jur) {
        this.catJurisdiccionId = catJurisdiccionId;
        this.edo = edo;
        this.jur = jur;
    }

    public CatJurisdiccion(Integer catJurisdiccionId, String edo, String jur, String descripcion, Integer estatus,
                           Date fechaRegistro, String noUsuario, Set<AdmHospital> admHospitals) {
        this.catJurisdiccionId = catJurisdiccionId;
        this.edo = edo;
        this.jur = jur;
        this.descripcion = descripcion;
        this.estatus = estatus;
        this.fechaRegistro = fechaRegistro;
        this.noUsuario = noUsuario;
        this.admHospitals = admHospitals;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JURISDICCION_ID", unique = true, nullable = false)
    public Integer getCatJurisdiccionId() {
        return this.catJurisdiccionId;
    }

    public void setCatJurisdiccionId(Integer catJurisdiccionId) {
        this.catJurisdiccionId = catJurisdiccionId;
    }
    @Column(name = "EDO", nullable = false, length = 10)
    public String getEdo() {
        return this.edo;
    }

    public void setEdo(String edo) {
        this.edo = edo;
    }

    @Column(name = "JUR", nullable = false, length = 10)
    public String getJur() {
        return this.jur;
    }

    public void setJur(String jur) {
        this.jur = jur;
    }

    @Column(name = "DESCRIPCION", length = 60)
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "ESTATUS")
    public Integer getEstatus() {
        return this.estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
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
    public String getNoUsuario() {
        return this.noUsuario;
    }

    public void setNoUsuario(String noUsuario) {
        this.noUsuario = noUsuario;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "catJurisdiccion")
    public Set<AdmHospital> getAdmHospitals() {
        return this.admHospitals;
    }

    public void setAdmHospitals(Set<AdmHospital> admHospitals) {
        this.admHospitals = admHospitals;
    }

}
