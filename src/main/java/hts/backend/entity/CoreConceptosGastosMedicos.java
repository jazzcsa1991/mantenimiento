package hts.backend.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "core_conceptos_gastos_medicos")
public class CoreConceptosGastosMedicos implements java.io.Serializable {
    private static final long serialVersionUID = 1L;


    private Integer conceptoGastosMedicosId;
    private AdmHospital admHospital;
    private Integer hospitalId;
    private String clave;
    private String nombre;
    private String descripcion;
    private Integer estatus;
    private Date fechaRegistro;
    private String usuarioRegistro;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONCEPTO_GASTOS_MEDICOS_ID")
    public Integer getConceptoGastosMedicosId() {
        return conceptoGastosMedicosId;
    }

    public void setConceptoGastosMedicosId(Integer conceptoGastosMedicosId) {
        this.conceptoGastosMedicosId = conceptoGastosMedicosId;
    }

    @Basic
    @Column(name = "CLAVE")
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Basic
    @Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @ManyToOne
    @JoinColumn(name = "HOSPITAL_ID", updatable = false, insertable = false)
    public AdmHospital getAdmHospital() {

        return admHospital;
    }

    public void setAdmHospital(AdmHospital admHospital) {
        this.admHospital = admHospital;
    }


    @Column(name = "HOSPITAL_ID", nullable = false)
    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }


    @Basic
    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "ESTATUS")
    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    @Basic
    @Column(name = "FECHA_REGISTRO")
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Basic
    @Column(name = "USUARIO_REGISTRO")
    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }
}
