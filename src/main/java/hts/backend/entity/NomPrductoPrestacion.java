package hts.backend.entity;



import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "adm_producto_prestacion")
public class NomPrductoPrestacion implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Integer prductoPrestacionId;
    private NomCatTipoPrestacion1 nomCatTipoPrestacion1;
    private CatClasePrestacion catClasePrestacion;
    private CatUnidadMedidaPres catUnidadMedidaPres;
    private CatClasificacionFiscal catClasificacionFiscal;
    private String cve;
    private String nombre;
    private String descripcion;
    private Date fechaIncio;
    private Date fechaFin;
    private Double precio;
    private String codigoExterno;
    private Integer valorDefault;
    private Integer estatus;
    private Integer grupoPrestacion;
    private Integer desglosaGrupo;
    private Integer prestacionFacturable;
    private Date fechaRegistro;
    private String usuarioRegistro;
    private Boolean cobroOxigeno;

    private AdmHospital admHospital;
    private Integer hospitalId;


    private Set<PacConvenioDetalle> pacConvenioDetalles = new HashSet<>(0);
    private Set<CexMedicamentosMateriales> cexMedicamentosMaterialeses = new HashSet<>(0);
    private Set<PrestacionTipoServesp> prestacionTipoServesps = new HashSet<>(0);
    private Set<PacEventoPrestacion> pacEventoPrestacions = new HashSet<>(0);
    private Set<FacturacionEvento> facturacionEventosByPrductoPrestacionId;

    private Set<AdmPrestacionesPaquete> admPrestacionesPaquetesByPrductoPrestacionId;
    private Set<AdmPrestacionesPaquete> admPrestacionesPaquetesByPrductoPrestacionId_1;

    private Set<AdmPrestacionesGrupo> admPrestacionesGruposByPrductoPrestacionId;
    private Set<AdmPrestacionesGrupo> admPrestacionesGruposByPrductoPrestacionId_0;
    private Set<BqrKitPrestacion> bqrKitPrestacion;
    private Set<CoreTipoCamaPrestacion> coreTipoCamaPrestacionsByPrductoPrestacionId;


    public NomPrductoPrestacion() {
    }

    public NomPrductoPrestacion(int prductoPrestacionId) {
        this.prductoPrestacionId = prductoPrestacionId;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCTO_PRESTACION_ID", unique = true, nullable = false, precision = 22)
    public Integer getPrductoPrestacionId() {
        return this.prductoPrestacionId;
    }

    public void setPrductoPrestacionId(Integer prductoPrestacionId) {
        this.prductoPrestacionId = prductoPrestacionId;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TIPO_PRESTACION1_ID")
    public NomCatTipoPrestacion1 getNomCatTipoPrestacion1() {
        return this.nomCatTipoPrestacion1;
    }

    public void setNomCatTipoPrestacion1(NomCatTipoPrestacion1 nomCatTipoPrestacion1) {
        this.nomCatTipoPrestacion1 = nomCatTipoPrestacion1;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLASE_PRESTACION_ID")
    public CatClasePrestacion getCatClasePrestacion() {
        return this.catClasePrestacion;
    }

    public void setCatClasePrestacion(CatClasePrestacion catClasePrestacion) {
        this.catClasePrestacion = catClasePrestacion;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UNIDAD_MEDIDA_PRES_ID")
    public CatUnidadMedidaPres getCatUnidadMedidaPres() {
        return this.catUnidadMedidaPres;
    }

    public void setCatUnidadMedidaPres(CatUnidadMedidaPres catUnidadMedidaPres) {
        this.catUnidadMedidaPres = catUnidadMedidaPres;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLASIFICACION_FISCAL_ID")
    public CatClasificacionFiscal getCatClasificacionFiscal() {
        return this.catClasificacionFiscal;
    }

    public void setCatClasificacionFiscal(CatClasificacionFiscal catClasificacionFiscal) {
        this.catClasificacionFiscal = catClasificacionFiscal;
    }


    @Column(name = "CVE", nullable = false, length = 20)
    public String getCve() {
        return this.cve;
    }

    public void setCve(String cve) {
        this.cve = cve;
    }


    @Column(name = "NOMBRE", nullable = false, length = 50)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Column(name = "DESCRIPCION", length = 50)
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    // @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_INCIO", nullable = false, length = 7)
    public Date getFechaIncio() {
        return this.fechaIncio;
    }

    public void setFechaIncio(Date fechaIncio) {
        this.fechaIncio = fechaIncio;
    }


    // @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_FIN", nullable = false, length = 7)
    public Date getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }


    @Column(name = "PRECIO", precision = 126)
    public Double getPrecio() {
        return this.precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    @Column(name = "CODIGO_EXTERNO", length = 20)
    public String getCodigoExterno() {
        return this.codigoExterno;
    }

    public void setCodigoExterno(String codigoExterno) {
        this.codigoExterno = codigoExterno;
    }


    @Column(name = "VALOR_DEFAULT", nullable = false, precision = 22)
    public Integer getValorDefault() {
        return this.valorDefault;
    }

    public void setValorDefault(Integer valorDefault) {
        this.valorDefault = valorDefault;
    }


    @Column(name = "ESTATUS", nullable = false, precision = 22)
    public Integer getEstatus() {
        return this.estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }


    @Column(name = "GRUPO_PRESTACION", precision = 22)
    public Integer getGrupoPrestacion() {
        return this.grupoPrestacion;
    }

    public void setGrupoPrestacion(Integer grupoPrestacion) {
        this.grupoPrestacion = grupoPrestacion;
    }


    @Column(name = "DESGLOSA_GRUPO", precision = 22)
    public Integer getDesglosaGrupo() {
        return this.desglosaGrupo;
    }

    public void setDesglosaGrupo(Integer desglosaGrupo) {
        this.desglosaGrupo = desglosaGrupo;
    }


    @Column(name = "PRESTACION_FACTURABLE", precision = 22)
    public Integer getPrestacionFacturable() {
        return this.prestacionFacturable;
    }

    public void setPrestacionFacturable(Integer prestacionFacturable) {
        this.prestacionFacturable = prestacionFacturable;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nomPrductoPrestacion")
    public Set<PacConvenioDetalle> getPacConvenioDetalles() {
        return this.pacConvenioDetalles;
    }

    public void setPacConvenioDetalles(Set<PacConvenioDetalle> pacConvenioDetalles) {
        this.pacConvenioDetalles = pacConvenioDetalles;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nomPrductoPrestacion")
    public Set<PrestacionTipoServesp> getPrestacionTipoServesps() {
        return this.prestacionTipoServesps;
    }

    public void setPrestacionTipoServesps(Set<PrestacionTipoServesp> prestacionTipoServesps) {
        this.prestacionTipoServesps = prestacionTipoServesps;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nomPrductoPrestacion")
    public Set<PacEventoPrestacion> getPacEventoPrestacions() {
        return pacEventoPrestacions;
    }

    public void setPacEventoPrestacions(Set<PacEventoPrestacion> pacEventoPrestacions) {
        this.pacEventoPrestacions = pacEventoPrestacions;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nomPrductoPrestacion")
    public Set<CexMedicamentosMateriales> getCexMedicamentosMaterialeses() {
        return cexMedicamentosMaterialeses;
    }

    public void setCexMedicamentosMaterialeses(Set<CexMedicamentosMateriales> cexMedicamentosMaterialeses) {
        this.cexMedicamentosMaterialeses = cexMedicamentosMaterialeses;
    }


    @OneToMany(mappedBy = "nomPrductoPrestacionByProductoPrestacionId")
    public Set<FacturacionEvento> getFacturacionEventosByPrductoPrestacionId() {
        return facturacionEventosByPrductoPrestacionId;
    }

    public void setFacturacionEventosByPrductoPrestacionId(Set<FacturacionEvento> facturacionEventosByPrductoPrestacionId) {
        this.facturacionEventosByPrductoPrestacionId = facturacionEventosByPrductoPrestacionId;
    }


    @OneToMany(mappedBy = "nomPrductoPrestacionByProductoPrestacionIdP")
    public Set<AdmPrestacionesPaquete> getAdmPrestacionesPaquetesByPrductoPrestacionId() {
        return admPrestacionesPaquetesByPrductoPrestacionId;
    }

    public void setAdmPrestacionesPaquetesByPrductoPrestacionId(Set<AdmPrestacionesPaquete> admPrestacionesPaquetesByPrductoPrestacionId) {
        this.admPrestacionesPaquetesByPrductoPrestacionId = admPrestacionesPaquetesByPrductoPrestacionId;
    }


    @OneToMany(mappedBy = "nomPrductoPrestacionByProductoPrestacionId")
    public Set<AdmPrestacionesPaquete> getAdmPrestacionesPaquetesByPrductoPrestacionId_1() {
        return admPrestacionesPaquetesByPrductoPrestacionId_1;
    }

    public void setAdmPrestacionesPaquetesByPrductoPrestacionId_1(Set<AdmPrestacionesPaquete> admPrestacionesPaquetesByPrductoPrestacionId_1) {
        this.admPrestacionesPaquetesByPrductoPrestacionId_1 = admPrestacionesPaquetesByPrductoPrestacionId_1;
    }


    @OneToMany(mappedBy = "nomPrductoPrestacionByProductoPrestacionIdG")
    public Set<AdmPrestacionesGrupo> getAdmPrestacionesGruposByPrductoPrestacionId() {
        return admPrestacionesGruposByPrductoPrestacionId;
    }

    public void setAdmPrestacionesGruposByPrductoPrestacionId(Set<AdmPrestacionesGrupo> admPrestacionesGruposByPrductoPrestacionId) {
        this.admPrestacionesGruposByPrductoPrestacionId = admPrestacionesGruposByPrductoPrestacionId;
    }


    @OneToMany(mappedBy = "nomPrductoPrestacionByProductoPrestacionId")
    public Set<AdmPrestacionesGrupo> getAdmPrestacionesGruposByPrductoPrestacionId_0() {
        return admPrestacionesGruposByPrductoPrestacionId_0;
    }

    public void setAdmPrestacionesGruposByPrductoPrestacionId_0(Set<AdmPrestacionesGrupo> admPrestacionesGruposByPrductoPrestacionId_0) {
        this.admPrestacionesGruposByPrductoPrestacionId_0 = admPrestacionesGruposByPrductoPrestacionId_0;
    }

    @OneToMany(mappedBy = "nomPrductoPrestacion")
    public Set<BqrKitPrestacion> getBqrKitPrestacion() {
        return bqrKitPrestacion;
    }

    public void setBqrKitPrestacion(Set<BqrKitPrestacion> bqrKitPrestacion) {
        this.bqrKitPrestacion = bqrKitPrestacion;
    }


    @OneToMany(mappedBy = "nomPrductoPrestacionByProductoPrestacionId")
    public Set<CoreTipoCamaPrestacion> getCoreTipoCamaPrestacionsByPrductoPrestacionId() {
        return coreTipoCamaPrestacionsByPrductoPrestacionId;
    }

    public void setCoreTipoCamaPrestacionsByPrductoPrestacionId(Set<CoreTipoCamaPrestacion> coreTipoCamaPrestacionsByPrductoPrestacionId) {
        this.coreTipoCamaPrestacionsByPrductoPrestacionId = coreTipoCamaPrestacionsByPrductoPrestacionId;
    }

    @ManyToOne
    @JoinColumn(name = "HOSPITAL_ID", insertable = false, updatable = false)
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

    @Column(name = "FECHA_REGISTRO")
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }


    @Column(name = "USUARIO_REGISTRO", length = 20)
    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }


    @Basic
    @Column(name = "COBRO_OXIGENO")
    public Boolean getCobroOxigeno() {
        return cobroOxigeno;
    }

    public void setCobroOxigeno(Boolean cobroOxigeno) {
        this.cobroOxigeno = cobroOxigeno;
    }
}
