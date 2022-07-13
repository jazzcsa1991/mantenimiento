package hts.backend.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "core_evento_aseguradora_concepto")
public class CoreEventoAseguradoraConcepto implements java.io.Serializable {
    private static final long serialVersionUID = 1L;


    private Integer eventoAseguradoraConceptoId;
    private Float monto;
    private Integer clasificacionFiscalId;
    private CatClasificacionFiscal clasificacionFiscal;
    private CoreConceptosGastosMedicos conceptoGastosMedicos;
    private PacEventoAseguradora eventoAseguradora;
    private Integer eventoAseguradoraId;
    private Integer conceptoGastosMedicosId;
    private Date fechaRegistro;
    private String usuarioRegistro;




    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVENTO_ASEGURADORA_CONCEPTO_ID")
    public Integer getEventoAseguradoraConceptoId() {
        return eventoAseguradoraConceptoId;
    }

    public void setEventoAseguradoraConceptoId(Integer eventoAseguradoraConceptoId) {
        this.eventoAseguradoraConceptoId = eventoAseguradoraConceptoId;
    }

    @Basic
    @Column(name = "MONTO")
    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }










    @Column(name = "CLASIFICACION_FISCAL_ID", nullable = false)
    public Integer getClasificacionFiscalId() {
        return clasificacionFiscalId;
    }

    public void setClasificacionFiscalId(Integer clasificacionFiscalId) {
        this.clasificacionFiscalId = clasificacionFiscalId;
    }
    @ManyToOne
    @JoinColumn(name = "CLASIFICACION_FISCAL_ID", updatable = false, insertable = false)
    public CatClasificacionFiscal getClasificacionFiscal() {
        return clasificacionFiscal;
    }

    public void setClasificacionFiscal(CatClasificacionFiscal clasificacionFiscal) {
        this.clasificacionFiscal = clasificacionFiscal;
    }
    @ManyToOne
    @JoinColumn(name = "CONCEPTO_GASTOS_MEDICOS_ID", updatable = false, insertable = false)
    public CoreConceptosGastosMedicos getConceptoGastosMedicos() {
        return conceptoGastosMedicos;
    }


    public void setConceptoGastosMedicos(CoreConceptosGastosMedicos conceptoGastosMedicos) {
        this.conceptoGastosMedicos = conceptoGastosMedicos;
    }

    @Column(name = "CONCEPTO_GASTOS_MEDICOS_ID", nullable = false)

    public Integer getConceptoGastosMedicosId() {
        return conceptoGastosMedicosId;
    }

    public void setConceptoGastosMedicosId(Integer conceptoGastosMedicosId) {
        this.conceptoGastosMedicosId = conceptoGastosMedicosId;
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

    @ManyToOne
    @JoinColumn(name = "EVENTO_ASEGURADORA_ID", updatable = false, insertable = false)
    public PacEventoAseguradora getEventoAseguradora() {
        return eventoAseguradora;
    }

    public void setEventoAseguradora(PacEventoAseguradora eventoAseguradora) {
        this.eventoAseguradora = eventoAseguradora;
    }


    @Column(name = "EVENTO_ASEGURADORA_ID", nullable = false)
    public Integer getEventoAseguradoraId() {
        return eventoAseguradoraId;
    }

    public void setEventoAseguradoraId(Integer eventoAseguradoraId) {
        this.eventoAseguradoraId = eventoAseguradoraId;
    }
}
