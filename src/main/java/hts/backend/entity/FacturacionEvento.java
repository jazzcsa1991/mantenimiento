package hts.backend.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Lenovo2 on 15/06/2017.
 */
@Entity
@Table(name = "facturacion_evento")
public class FacturacionEvento implements java.io.Serializable{

	private Integer facturacionEventoId;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private PacEvento pacEventoByEventoId;
	private Integer cantidad;
	private Date fechaCarga;
	private Integer prestacionDefault;
	private Integer origenPrestacion;
	private Integer prioridad;
	private String noPoliza;
	private Integer limiteSeguro;
	private Date fecIniAseg;
	private Date fecFinAseg;
	private Date fecIniCon;
	private Date fecFinCon;
	private Integer cantidadDet;
	private Date fecIniDet;
	private Date fecFinDet;
	private Double precio;
	private Integer cobertura;
	private Integer descuento;
	private Integer deducible;
	private Double iva;
	private Integer anticipo;
	private Integer balance;
	private Integer importe;
	private Integer coaseguro;
	private Integer modifManual;
	private Integer descuentoManual;
	private Integer emitioFactura;
	private FacturacionPagoEvento facturacionPagoEventoByPagoEventoId;

	private NomPrductoPrestacion nomPrductoPrestacionByProductoPrestacionId;
	private PacPaciente pacPacienteByIdPaciente;
	private AdmCatAseguradora admCatAseguradoraByAseguradoraId;
	private PacAseguradora pacAseguradoraByPacAseguradoraId;
	private PacConvenioAseguradora pacConvenioAseguradoraByConvenioAseguradoraId;
	private PacConvenioDetalleEvento pacConvenioDetalleEventoByConvenioDetalleEventoId;
	private CatTipoEpisodio catTipoEpisodioByTipoEpisodioId;
	private CatEstatusPago catEstatusPagoByEstadoPagoId;
	private CatTipoConcepto catTipoConceptoByTipoConceptoId;
	//private CatMotAnulaPresta catMotAnulaPrestaByMotAnulaPrestaId;
	private PacEventoPrestacion pacEventoPrestacionByEventoPrestacionId;
	private PacPagadorAsociado pacPagadorAsociadoByPagadorAsociadoId;
	private AdmHospital admHospitalByHospitalId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FACTURACION_EVENTO_ID", nullable = false, precision = 0) public Integer getFacturacionEventoId() {
		return facturacionEventoId;
	}

	public void setFacturacionEventoId(Integer facturacionEventoId) {
		this.facturacionEventoId = facturacionEventoId;
	}

	@Basic @Column(name = "FECHA_REGISTRO", nullable = false) public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO", nullable = false, length = 20) public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Basic @Column(name = "CANTIDAD", nullable = false, precision = 0) public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Basic @Column(name = "FECHA_CARGA", nullable = true) public Date getFechaCarga() {
		return fechaCarga;
	}

	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	@Basic @Column(name = "PRESTACION_DEFAULT", nullable = true, precision = 0) public Integer getPrestacionDefault() {
		return prestacionDefault;
	}

	public void setPrestacionDefault(Integer prestacionDefault) {
		this.prestacionDefault = prestacionDefault;
	}

	@Basic @Column(name = "ORIGEN_PRESTACION", nullable = true, precision = 0) public Integer getOrigenPrestacion() {
		return origenPrestacion;
	}

	public void setOrigenPrestacion(Integer origenPrestacion) {
		this.origenPrestacion = origenPrestacion;
	}

	@Basic @Column(name = "PRIORIDAD", nullable = true, precision = 0) public Integer getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

	@Basic @Column(name = "NO_POLIZA", nullable = true, length = 20) public String getNoPoliza() {
		return noPoliza;
	}

	public void setNoPoliza(String noPoliza) {
		this.noPoliza = noPoliza;
	}

	@Basic @Column(name = "LIMITE_SEGURO", nullable = true, precision = 0) public Integer getLimiteSeguro() {
		return limiteSeguro;
	}

	public void setLimiteSeguro(Integer limiteSeguro) {
		this.limiteSeguro = limiteSeguro;
	}

	@Basic @Column(name = "FEC_INI_ASEG", nullable = true) public Date getFecIniAseg() {
		return fecIniAseg;
	}

	public void setFecIniAseg(Date fecIniAseg) {
		this.fecIniAseg = fecIniAseg;
	}

	@Basic @Column(name = "FEC_FIN_ASEG", nullable = true) public Date getFecFinAseg() {
		return fecFinAseg;
	}

	public void setFecFinAseg(Date fecFinAseg) {
		this.fecFinAseg = fecFinAseg;
	}

	@Basic @Column(name = "FEC_INI_CON", nullable = true) public Date getFecIniCon() {
		return fecIniCon;
	}

	public void setFecIniCon(Date fecIniCon) {
		this.fecIniCon = fecIniCon;
	}

	@Basic @Column(name = "FEC_FIN_CON", nullable = true) public Date getFecFinCon() {
		return fecFinCon;
	}

	public void setFecFinCon(Date fecFinCon) {
		this.fecFinCon = fecFinCon;
	}

	@Basic @Column(name = "CANTIDAD_DET", nullable = true, precision = 0) public Integer getCantidadDet() {
		return cantidadDet;
	}

	public void setCantidadDet(Integer cantidadDet) {
		this.cantidadDet = cantidadDet;
	}

	@Basic @Column(name = "FEC_INI_DET", nullable = true) public Date getFecIniDet() {
		return fecIniDet;
	}

	public void setFecIniDet(Date fecIniDet) {
		this.fecIniDet = fecIniDet;
	}

	@Basic @Column(name = "FEC_FIN_DET", nullable = true) public Date getFecFinDet() {
		return fecFinDet;
	}

	public void setFecFinDet(Date fecFinDet) {
		this.fecFinDet = fecFinDet;
	}

	@Basic @Column(name = "PRECIO", nullable = false, precision = 0) public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Basic @Column(name = "COBERTURA", nullable = true, precision = 0) public Integer getCobertura() {
		return cobertura;
	}

	public void setCobertura(Integer cobertura) {
		this.cobertura = cobertura;
	}

	@Basic @Column(name = "DESCUENTO", nullable = true, precision = 0) public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}

	@Basic @Column(name = "DEDUCIBLE", nullable = true, precision = 0) public Integer getDeducible() {
		return deducible;
	}

	public void setDeducible(Integer deducible) {
		this.deducible = deducible;
	}

	@Basic @Column(name = "IVA", nullable = true, precision = 0) public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	@Basic @Column(name = "ANTICIPO", nullable = true, precision = 0) public Integer getAnticipo() {
		return anticipo;
	}

	public void setAnticipo(Integer anticipo) {
		this.anticipo = anticipo;
	}

	@Basic @Column(name = "BALANCE", nullable = true, precision = 0) public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	@Basic @Column(name = "IMPORTE", nullable = true, precision = 0) public Integer getImporte() {
		return importe;
	}

	public void setImporte(Integer importe) {
		this.importe = importe;
	}

	@Basic @Column(name = "COASEGURO", nullable = true, precision = 0) public Integer getCoaseguro() {
		return coaseguro;
	}

	public void setCoaseguro(Integer coaseguro) {
		this.coaseguro = coaseguro;
	}

	@Basic @Column(name = "MODIF_MANUAL", nullable = true, precision = 0) public Integer getModifManual() {
		return modifManual;
	}

	public void setModifManual(Integer modifManual) {
		this.modifManual = modifManual;
	}

	@Basic @Column(name = "DESCUENTO_MANUAL", nullable = true, precision = 0) public Integer getDescuentoManual() {
		return descuentoManual;
	}

	public void setDescuentoManual(Integer descuentoManual) {
		this.descuentoManual = descuentoManual;
	}

	@Basic @Column(name = "EMITIO_FACTURA", nullable = true, precision = 0) public Integer getEmitioFactura() {
		return emitioFactura;
	}

	public void setEmitioFactura(Integer emitioFactura) {
		this.emitioFactura = emitioFactura;
	}

	@ManyToOne
	@JoinColumn(name = "PAGO_EVENTO_ID", referencedColumnName = "PAGO_EVENTO_ID")
	public FacturacionPagoEvento getFacturacionPagoEventoByPagoEventoId() {
		return facturacionPagoEventoByPagoEventoId;
	}

	public void setFacturacionPagoEventoByPagoEventoId(FacturacionPagoEvento facturacionPagoEventoByPagoEventoId) {
		this.facturacionPagoEventoByPagoEventoId = facturacionPagoEventoByPagoEventoId;
	}

	@ManyToOne
	@JoinColumn(name = "EVENTO_ID", referencedColumnName = "EVENTO_ID", nullable = false)
	public PacEvento getPacEventoByEventoId() {
		return pacEventoByEventoId;
	}

	public void setPacEventoByEventoId(PacEvento pacEventoByEventoId) {
		this.pacEventoByEventoId = pacEventoByEventoId;
	}

	@ManyToOne @JoinColumn(name = "PRODUCTO_PRESTACION_ID", referencedColumnName = "PRODUCTO_PRESTACION_ID", nullable = false) public NomPrductoPrestacion getNomPrductoPrestacionByProductoPrestacionId() {
		return nomPrductoPrestacionByProductoPrestacionId;
	}

	public void setNomPrductoPrestacionByProductoPrestacionId(NomPrductoPrestacion nomPrductoPrestacionByProductoPrestacionId) {
		this.nomPrductoPrestacionByProductoPrestacionId = nomPrductoPrestacionByProductoPrestacionId;
	}

	@ManyToOne @JoinColumn(name = "ID_PACIENTE", referencedColumnName = "ID_PACIENTE", nullable = false) public PacPaciente getPacPacienteByIdPaciente() {
		return pacPacienteByIdPaciente;
	}

	public void setPacPacienteByIdPaciente(PacPaciente pacPacienteByIdPaciente) {
		this.pacPacienteByIdPaciente = pacPacienteByIdPaciente;
	}

	@ManyToOne @JoinColumn(name = "ASEGURADORA_ID", referencedColumnName = "ASEGURADORA_ID") public AdmCatAseguradora getAdmCatAseguradoraByAseguradoraId() {
		return admCatAseguradoraByAseguradoraId;
	}

	public void setAdmCatAseguradoraByAseguradoraId(AdmCatAseguradora admCatAseguradoraByAseguradoraId) {
		this.admCatAseguradoraByAseguradoraId = admCatAseguradoraByAseguradoraId;
	}

	@ManyToOne @JoinColumn(name = "PAC_ASEGURADORA_ID", referencedColumnName = "PAC_ASEGURADORA_ID") public PacAseguradora getPacAseguradoraByPacAseguradoraId() {
		return pacAseguradoraByPacAseguradoraId;
	}

	public void setPacAseguradoraByPacAseguradoraId(PacAseguradora pacAseguradoraByPacAseguradoraId) {
		this.pacAseguradoraByPacAseguradoraId = pacAseguradoraByPacAseguradoraId;
	}

	@ManyToOne @JoinColumn(name = "CONVENIO_ASEGURADORA_ID", referencedColumnName = "CONVENIO_ASEGURADORA_ID") public PacConvenioAseguradora getPacConvenioAseguradoraByConvenioAseguradoraId() {
		return pacConvenioAseguradoraByConvenioAseguradoraId;
	}

	public void setPacConvenioAseguradoraByConvenioAseguradoraId(PacConvenioAseguradora pacConvenioAseguradoraByConvenioAseguradoraId) {
		this.pacConvenioAseguradoraByConvenioAseguradoraId = pacConvenioAseguradoraByConvenioAseguradoraId;
	}

	@ManyToOne @JoinColumn(name = "CONVENIO_DETALLE_EVENTO_ID", referencedColumnName = "CONVENIO_DETALLE_EVENTO_ID") public PacConvenioDetalleEvento getPacConvenioDetalleEventoByConvenioDetalleEventoId() {
		return pacConvenioDetalleEventoByConvenioDetalleEventoId;
	}

	public void setPacConvenioDetalleEventoByConvenioDetalleEventoId(PacConvenioDetalleEvento pacConvenioDetalleEventoByConvenioDetalleEventoId) {
		this.pacConvenioDetalleEventoByConvenioDetalleEventoId = pacConvenioDetalleEventoByConvenioDetalleEventoId;
	}

	@ManyToOne @JoinColumn(name = "TIPO_EPISODIO_ID", referencedColumnName = "TIPO_EPISODIO_ID") public CatTipoEpisodio getCatTipoEpisodioByTipoEpisodioId() {
		return catTipoEpisodioByTipoEpisodioId;
	}

	public void setCatTipoEpisodioByTipoEpisodioId(CatTipoEpisodio catTipoEpisodioByTipoEpisodioId) {
		this.catTipoEpisodioByTipoEpisodioId = catTipoEpisodioByTipoEpisodioId;
	}

	@ManyToOne @JoinColumn(name = "ESTADO_PAGO_ID", referencedColumnName = "ESTATUS_PAGO_ID", nullable = false) public CatEstatusPago getCatEstatusPagoByEstadoPagoId() {
		return catEstatusPagoByEstadoPagoId;
	}

	public void setCatEstatusPagoByEstadoPagoId(CatEstatusPago catEstatusPagoByEstadoPagoId) {
		this.catEstatusPagoByEstadoPagoId = catEstatusPagoByEstadoPagoId;
	}

	@ManyToOne @JoinColumn(name = "TIPO_CONCEPTO_ID", referencedColumnName = "TIPO_CONCEPTO_ID") public CatTipoConcepto getCatTipoConceptoByTipoConceptoId() {
		return catTipoConceptoByTipoConceptoId;
	}

	public void setCatTipoConceptoByTipoConceptoId(CatTipoConcepto catTipoConceptoByTipoConceptoId) {
		this.catTipoConceptoByTipoConceptoId = catTipoConceptoByTipoConceptoId;
	}

//	@ManyToOne @JoinColumn(name = "MOT_ANULA_PRESTA_ID", referencedColumnName = "MOT_ANULA_PRESTA_ID") public CatMotAnulaPresta getCatMotAnulaPrestaByMotAnulaPrestaId() {
//		return catMotAnulaPrestaByMotAnulaPrestaId;
//	}
//
//	public void setCatMotAnulaPrestaByMotAnulaPrestaId(CatMotAnulaPresta catMotAnulaPrestaByMotAnulaPrestaId) {
//		this.catMotAnulaPrestaByMotAnulaPrestaId = catMotAnulaPrestaByMotAnulaPrestaId;
//	}

	@ManyToOne @JoinColumn(name = "EVENTO_PRESTACION_ID", referencedColumnName = "EVENTO_PRESTACION_ID") public PacEventoPrestacion getPacEventoPrestacionByEventoPrestacionId() {
		return pacEventoPrestacionByEventoPrestacionId;
	}

	public void setPacEventoPrestacionByEventoPrestacionId(PacEventoPrestacion pacEventoPrestacionByEventoPrestacionId) {
		this.pacEventoPrestacionByEventoPrestacionId = pacEventoPrestacionByEventoPrestacionId;
	}

	@ManyToOne @JoinColumn(name = "PAGADOR_ASOCIADO_ID", referencedColumnName = "PAGADOR_ASOCIADO_ID") public PacPagadorAsociado getPacPagadorAsociadoByPagadorAsociadoId() {
		return pacPagadorAsociadoByPagadorAsociadoId;
	}

	public void setPacPagadorAsociadoByPagadorAsociadoId(PacPagadorAsociado pacPagadorAsociadoByPagadorAsociadoId) {
		this.pacPagadorAsociadoByPagadorAsociadoId = pacPagadorAsociadoByPagadorAsociadoId;
	}

	@ManyToOne @JoinColumn(name = "HOSPITAL_ID", referencedColumnName = "HOSPITAL_ID") public AdmHospital getAdmHospitalByHospitalId() {
		return admHospitalByHospitalId;
	}

	public void setAdmHospitalByHospitalId(AdmHospital admHospitalByHospitalId) {
		this.admHospitalByHospitalId = admHospitalByHospitalId;
	}

}
