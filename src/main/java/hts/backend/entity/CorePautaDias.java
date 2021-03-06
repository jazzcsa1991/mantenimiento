package hts.backend.entity;



import java.util.Date;
import javax.persistence.*;

/**
 * CorePautaDias generated by hbm2java
 */
@Entity
@Table(name = "core_pauta_dias")
public class CorePautaDias implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private int pautaDiasId;
    private CorePauta corePauta;
    private int lunes;
    private int martes;
    private int miercoles;
    private int jueves;
    private int viernes;
    private int sabado;
    private int domingo;
    private Date fechaRegistro;
    private String usuarioRegistro;

    public CorePautaDias() {
    }

    public CorePautaDias(int pautaDiasId, CorePauta corePauta, int lunes, int martes, int miercoles,
                         int jueves, int viernes, int sabado, int domingo, Date fechaRegistro, String usuarioRegistro) {
        this.pautaDiasId = pautaDiasId;
        this.corePauta = corePauta;
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.sabado = sabado;
        this.domingo = domingo;
        this.fechaRegistro = fechaRegistro;
        this.usuarioRegistro = usuarioRegistro;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAUTA_DIAS_ID", unique = true, nullable = false, precision = 22, scale = 0)
    public int getPautaDiasId() {
        return this.pautaDiasId;
    }

    public void setPautaDiasId(int pautaDiasId) {
        this.pautaDiasId = pautaDiasId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PAUTA_ID", nullable = false)
    public CorePauta getCorePauta() {
        return this.corePauta;
    }

    public void setCorePauta(CorePauta corePauta) {
        this.corePauta = corePauta;
    }

    @Column(name = "LUNES", nullable = false, length = 20)
    public int getLunes() {
        return this.lunes;
    }

    public void setLunes(int lunes) {
        this.lunes = lunes;
    }

    @Column(name = "MARTES", nullable = false, length = 20)
    public int getMartes() {
        return this.martes;
    }

    public void setMartes(int martes) {
        this.martes = martes;
    }

    @Column(name = "MIERCOLES", nullable = false, length = 20)
    public int getMiercoles() {
        return this.miercoles;
    }

    public void setMiercoles(int miercoles) {
        this.miercoles = miercoles;
    }

    @Column(name = "JUEVES", nullable = false, length = 20)
    public int getJueves() {
        return this.jueves;
    }

    public void setJueves(int jueves) {
        this.jueves = jueves;
    }

    @Column(name = "VIERNES", nullable = false, length = 20)
    public int getViernes() {
        return this.viernes;
    }

    public void setViernes(int viernes) {
        this.viernes = viernes;
    }

    @Column(name = "SABADO", nullable = false, length = 20)
    public int getSabado() {
        return this.sabado;
    }

    public void setSabado(int sabado) {
        this.sabado = sabado;
    }


    @Column(name = "DOMINGO", nullable = false, length = 20)
    public int getDomingo() {
        return domingo;
    }

    public void setDomingo(int domingo) {
        this.domingo = domingo;
    }


    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_REGISTRO", nullable = false, length = 7)
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Column(name = "USUARIO_REGISTRO", nullable = false, length = 20)
    public String getUsuarioRegistro() {
        return this.usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

}
