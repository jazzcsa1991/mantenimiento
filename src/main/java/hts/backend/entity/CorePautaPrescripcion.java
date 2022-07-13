package hts.backend.entity;



import java.util.Date;
import javax.persistence.*;

/**
 * CorePautaPrescripcion generated by hbm2java
 */
@Entity
@Table(name = "core_pauta_prescripcion")
public class CorePautaPrescripcion implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private int pautaPrescripcionId;
    private CatTipoPrescripcion catTipoPrescripcion;
    private CorePauta corePauta;
    private Date fechaRegistro;
    private String usuarioRegistro;

    public CorePautaPrescripcion() {
    }

    public CorePautaPrescripcion(int pautaPrescripcionId, CatTipoPrescripcion catTipoPrescripcion,
                                 CorePauta corePauta, Date fechaRegistro, String usuarioRegistro) {
        this.pautaPrescripcionId = pautaPrescripcionId;
        this.catTipoPrescripcion = catTipoPrescripcion;
        this.corePauta = corePauta;
        this.fechaRegistro = fechaRegistro;
        this.usuarioRegistro = usuarioRegistro;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAUTA_PRESCRIPCION_ID", unique = true, nullable = false, precision = 22, scale = 0)
    public int getPautaPrescripcionId() {
        return this.pautaPrescripcionId;
    }

    public void setPautaPrescripcionId(int pautaPrescripcionId) {
        this.pautaPrescripcionId = pautaPrescripcionId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TIPO_PRESCRIPCION_ID", nullable = false)
    public CatTipoPrescripcion getCatTipoPrescripcion() {
        return this.catTipoPrescripcion;
    }

    public void setCatTipoPrescripcion(CatTipoPrescripcion catTipoPrescripcion) {
        this.catTipoPrescripcion = catTipoPrescripcion;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PAUTA_ID", nullable = false)
    public CorePauta getCorePauta() {
        return this.corePauta;
    }

    public void setCorePauta(CorePauta corePauta) {
        this.corePauta = corePauta;
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
