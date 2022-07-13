package hts.backend.entity;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import hts.backend.entity.CexReceta;
import hts.backend.entity.AdmUnidadMedica;

@Entity
@Table(
        name = "gus_modulos"
)
public class GusModulos {
    private Integer gusModuloId;
    private String nombre;
    private String cve;
    private Set<CexReceta> cexRecetas = new HashSet(0);
    private Set<AdmUnidadMedica> admUnidadMedicas = new HashSet(0);

    public GusModulos() {
    }

    @Id
    @Column(
            name = "GUS_MODULO_ID",
            nullable = false
    )
    public Integer getGusModuloId() {
        return this.gusModuloId;
    }

    public void setGusModuloId(Integer gusModuloId) {
        this.gusModuloId = gusModuloId;
    }

    @Basic
    @Column(
            name = "NOMBRE",
            nullable = false,
            length = 70
    )
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(
            name = "CVE",
            nullable = false,
            length = 10
    )
    public String getCve() {
        return this.cve;
    }

    public void setCve(String cve) {
        this.cve = cve;
    }

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "gusModulos"
    )
    public Set<CexReceta> getCexRecetas() {
        return this.cexRecetas;
    }

    public void setCexRecetas(Set<CexReceta> cexRecetas) {
        this.cexRecetas = cexRecetas;
    }

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "gusModulos"
    )
    public Set<AdmUnidadMedica> getAdmUnidadMedicas() {
        return this.admUnidadMedicas;
    }

    public void setAdmUnidadMedicas(Set<AdmUnidadMedica> admUnidadMedicas) {
        this.admUnidadMedicas = admUnidadMedicas;
    }
}
