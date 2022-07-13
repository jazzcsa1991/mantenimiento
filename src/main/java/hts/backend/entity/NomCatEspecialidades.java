package hts.backend.entity;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//



import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(
        name = "nom_cat_especialidades"
)
public class NomCatEspecialidades implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer catEspecialidadId;
    private Integer cveespmedcifrhs;
    private Integer cveespmedbecarios;
    private String especialidad;
    private Integer indicaDefault;
    private Integer estatus;
    private Date fechaRegistro;
    private String noUsuario;

    public NomCatEspecialidades() {
    }

    public NomCatEspecialidades(Integer catEspecialidadId) {
        this.catEspecialidadId = catEspecialidadId;
    }

    public NomCatEspecialidades(Integer catEspecialidadId, Integer cveespmedcifrhs, Integer cveespmedbecarios, String especialidad, Integer indicaDefault, Integer estatus, Date fechaRegistro, String noUsuario) {
        this.catEspecialidadId = catEspecialidadId;
        this.cveespmedcifrhs = cveespmedcifrhs;
        this.cveespmedbecarios = cveespmedbecarios;
        this.especialidad = especialidad;
        this.indicaDefault = indicaDefault;
        this.estatus = estatus;
        this.fechaRegistro = fechaRegistro;
        this.noUsuario = noUsuario;
    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "CAT_ESPECIALIDAD_ID",
            unique = true,
            nullable = false,
            precision = 22,
            scale = 0
    )
    public Integer getCatEspecialidadId() {
        return this.catEspecialidadId;
    }

    public void setCatEspecialidadId(Integer catEspecialidadId) {
        this.catEspecialidadId = catEspecialidadId;
    }

    @Column(
            name = "CVEESPMEDCIFRHS",
            precision = 22,
            scale = 0
    )
    public Integer getCveespmedcifrhs() {
        return this.cveespmedcifrhs;
    }

    public void setCveespmedcifrhs(Integer cveespmedcifrhs) {
        this.cveespmedcifrhs = cveespmedcifrhs;
    }

    @Column(
            name = "CVEESPMEDBECARIOS",
            precision = 22,
            scale = 0
    )
    public Integer getCveespmedbecarios() {
        return this.cveespmedbecarios;
    }

    public void setCveespmedbecarios(Integer cveespmedbecarios) {
        this.cveespmedbecarios = cveespmedbecarios;
    }

    @Column(
            name = "ESPECIALIDAD",
            length = 70
    )
    public String getEspecialidad() {
        return this.especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Column(
            name = "VALOR_DEFAULT",
            precision = 22,
            scale = 0
    )
    public Integer getIndicaDefault() {
        return this.indicaDefault;
    }

    public void setIndicaDefault(Integer indicaDefault) {
        this.indicaDefault = indicaDefault;
    }

    @Column(
            name = "ESTATUS",
            precision = 22,
            scale = 0
    )
    public Integer getEstatus() {
        return this.estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
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
            name = "NO_USUARIO",
            length = 20
    )
    public String getNoUsuario() {
        return this.noUsuario;
    }

    public void setNoUsuario(String noUsuario) {
        this.noUsuario = noUsuario;
    }
}
