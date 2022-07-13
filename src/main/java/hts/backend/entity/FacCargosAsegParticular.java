package hts.backend.entity;

import hts.backend.entity.CatMotivoDescuento;
import hts.backend.entity.CoreEventoAseguradoraConcepto;
import hts.backend.entity.PacConvenioDetalleEvento;
import hts.backend.entity.PacEpisodio;
import hts.backend.entity.PacEventoPrestacion;
import hts.backend.entity.PacPaciente;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "fac_cargos_aseg_particular")
public class FacCargosAsegParticular implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer cargoAsegParticularId;
	private BigDecimal cobertura;
	private BigDecimal precio;
	private BigDecimal descuento;
	private BigDecimal iva;
	private BigDecimal importe;
	private Date fechaRegistro;
	private Boolean pagado;
	private BigDecimal descuentoManual;
	private BigDecimal impuesto;
	private String usuarioRegistro;
	private CatMotivoDescuento catMotivoDescuento;
	private Integer motivoDescuentoId;
	private PacPaciente pacPaciente;
	private Integer idPaciente;
	private PacEpisodio pacEpisodio;
	private Integer episodioId;
	private PacEventoPrestacion pacEventoPrestacion;
	private Integer eventoPrestacionId;
	private PacConvenioDetalleEvento pacConvenioDetalleEvento;
	private Integer convenioDetalleEventoId;
	private FacCatTipoCargo facCatTipoCargo;
	private Integer tipoCargoId;
	private Integer pacAseguradoraId;
	private FacBitSeparacionCuenta separacionCuenta;
	private Integer separacionCuentaId;
	private Integer eventoAseguradoraConceptoId;
	private CoreEventoAseguradoraConcepto eventoAseguradoraConcepto;
	private Boolean modificado;





	private Set<FacConcilAsegParticular> conciliaciones;

	@Transient
	private BigDecimal pendienteConciliacion;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CARGO_ASEG_PARTICULAR_ID", nullable = false) public Integer getCargoAsegParticularId() {
		return cargoAsegParticularId;
	}

	public void setCargoAsegParticularId(Integer cargoAsegParticularId) {
		this.cargoAsegParticularId = cargoAsegParticularId;
	}


	@Basic @Column(name = "COBERTURA", nullable = false) public BigDecimal getCobertura() {
		return cobertura;
	}

	public void setCobertura(BigDecimal cobertura) {
		this.cobertura = cobertura;
	}

	@Basic @Column(name = "PRECIO", nullable = false) public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	@Basic @Column(name = "DESCUENTO", nullable = false) public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}


	@Basic @Column(name = "IVA", nullable = false) public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}


	@Basic @Column(name = "IMPORTE", nullable = false) public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	@Basic @Column(name = "FECHA_REGISTRO", nullable = false) public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "PAGADO", nullable = false) public Boolean getPagado() {
		return pagado;
	}

	public void setPagado(Boolean pagado) {
		this.pagado = pagado;
	}

	@Basic @Column(name = "DESCUENTO_MANUAL", nullable = true) public BigDecimal getDescuentoManual() {
		return descuentoManual;
	}

	@Basic @Column(name = "IMPUESTO", nullable = false) public BigDecimal getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(BigDecimal impuesto) {
		this.impuesto = impuesto;
	}

	public void setDescuentoManual(BigDecimal descuentoManual) {
		this.descuentoManual = descuentoManual;
	}

	@ManyToOne @JoinColumn(name = "ID_PACIENTE", referencedColumnName = "ID_PACIENTE", updatable = false, insertable = false)
	public PacPaciente getPacPaciente() {
		return pacPaciente;
	}

	public void setPacPaciente(PacPaciente pacPacienteByIdPaciente) {
		this.pacPaciente = pacPacienteByIdPaciente;
	}

	@ManyToOne @JoinColumn(name = "EPISODIO_ID", referencedColumnName = "EPISODIO_ID", updatable = false, insertable = false)
	public PacEpisodio getPacEpisodio() {
		return pacEpisodio;
	}

	public void setPacEpisodio(PacEpisodio pacEpisodioByEpisodioId) {
		this.pacEpisodio = pacEpisodioByEpisodioId;
	}

	@ManyToOne @JoinColumn(name = "MOTIVO_DESCUENTO_ID", referencedColumnName = "MOTIVO_DESCUENTO_ID", updatable = false, insertable = false)
	public CatMotivoDescuento getCatMotivoDescuento() {
		return catMotivoDescuento;
	}

	public void setCatMotivoDescuento(CatMotivoDescuento motivoDescuentoId) {
		this.catMotivoDescuento = motivoDescuentoId;
	}


	@ManyToOne @JoinColumn(name = "EVENTO_PRESTACION_ID", referencedColumnName = "EVENTO_PRESTACION_ID", updatable = false, insertable = false)
	public PacEventoPrestacion getPacEventoPrestacion() {
		return pacEventoPrestacion;
	}

	public void setPacEventoPrestacion(PacEventoPrestacion pacEventoPrestacionByEventoPrestacionId) {
		this.pacEventoPrestacion = pacEventoPrestacionByEventoPrestacionId;
	}

	@ManyToOne @JoinColumn(name = "CONVENIO_DETALLE_EVENTO_ID", referencedColumnName = "CONVENIO_DETALLE_EVENTO_ID", updatable = false, insertable = false)
	public PacConvenioDetalleEvento getPacConvenioDetalleEvento() {
		return pacConvenioDetalleEvento;
	}

	public void setPacConvenioDetalleEvento(PacConvenioDetalleEvento pacConvenioDetalleEventoByConvenioDetalleEventoId) {
		this.pacConvenioDetalleEvento = pacConvenioDetalleEventoByConvenioDetalleEventoId;
	}

	@OneToMany(mappedBy = "cargoAsegParticular")
	public Set<FacConcilAsegParticular> getConciliaciones() {
		return conciliaciones;
	}

	public void setConciliaciones(Set<FacConcilAsegParticular> facConcilAsegParticularsByCargoAsegParticularId) {
		this.conciliaciones = facConcilAsegParticularsByCargoAsegParticularId;
	}

	@ManyToOne @JoinColumn(name = "TIPO_CARGO_ID", referencedColumnName = "CAT_TIPO_CARGO_ID", updatable = false, insertable = false)
	public FacCatTipoCargo getFacCatTipoCargo() {
		return facCatTipoCargo;
	}

	public void setFacCatTipoCargo(FacCatTipoCargo facCatTipoCargoByTipoCargoId) {
		this.facCatTipoCargo = facCatTipoCargoByTipoCargoId;
	}


	@Column(name = "USUARIO_REGISTRO")
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Transient
	public BigDecimal getPendienteConciliacion() {
		return pendienteConciliacion;
	}

	public void setPendienteConciliacion(BigDecimal pendienteConciliacion) {
		this.pendienteConciliacion = pendienteConciliacion;
	}


	@Column(name = "ID_PACIENTE", nullable = false)
	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer pacienteId) {
		this.idPaciente = pacienteId;
	}


	@Column(name = "EPISODIO_ID", nullable = false)
	public Integer getEpisodioId() {
		return episodioId;
	}

	public void setEpisodioId(Integer episodioId) {
		this.episodioId = episodioId;
	}


	@Column(name = "EVENTO_PRESTACION_ID", nullable = false)
	public Integer getEventoPrestacionId() {
		return eventoPrestacionId;
	}

	public void setEventoPrestacionId(Integer eventoPrestacionId) {
		this.eventoPrestacionId = eventoPrestacionId;
	}


	@Column(name = "CONVENIO_DETALLE_EVENTO_ID")
	public Integer getConvenioDetalleEventoId() {
		return convenioDetalleEventoId;
	}

	public void setConvenioDetalleEventoId(Integer convenioDetalleEventoId) {
		this.convenioDetalleEventoId = convenioDetalleEventoId;
	}


	@Column(name = "TIPO_CARGO_ID", nullable = false)
	public Integer getTipoCargoId() {
		return tipoCargoId;
	}

	public void setTipoCargoId(Integer tipoCargoId) {
		this.tipoCargoId = tipoCargoId;
	}


	@Column(name = "MOTIVO_DESCUENTO_ID")
	public Integer getMotivoDescuentoId() {
		return motivoDescuentoId;
	}

	public void setMotivoDescuentoId(Integer motivoDescuentoId) {
		this.motivoDescuentoId = motivoDescuentoId;
	}

	@Column(name = "PAC_ASEGURADORA_ID")
	public Integer getPacAseguradoraId() {
		return pacAseguradoraId;
	}

	public void setPacAseguradoraId(Integer pacAseguradoraId) {
		this.pacAseguradoraId = pacAseguradoraId;
	}

	@ManyToOne
	@JoinColumn(name = "SEPARACION_CUENTA_ID", referencedColumnName = "SEPARACION_CUENTA_ID", updatable = false , insertable = false)
	public FacBitSeparacionCuenta getSeparacionCuenta() {
		return separacionCuenta;
	}

	public void setSeparacionCuenta(FacBitSeparacionCuenta separacionCuenta) {
		this.separacionCuenta = separacionCuenta;
	}

	@Basic @Column(name = "SEPARACION_CUENTA_ID")
	public Integer getSeparacionCuentaId() {
		return separacionCuentaId;
	}




	@ManyToOne
	@JoinColumn(name = "EVENTO_ASEGURADORA_CONCEPTO_ID", referencedColumnName = "EVENTO_ASEGURADORA_CONCEPTO_ID", updatable = false , insertable = false)
	public CoreEventoAseguradoraConcepto getEventoAseguradoraConcepto() {
		return eventoAseguradoraConcepto;
	}

	public void setEventoAseguradoraConcepto(CoreEventoAseguradoraConcepto eventoAseguradoraConcepto) {
		this.eventoAseguradoraConcepto = eventoAseguradoraConcepto;
	}



	@Basic @Column(name = "EVENTO_ASEGURADORA_CONCEPTO_ID")
	public Integer getEventoAseguradoraConceptoId() {
		return eventoAseguradoraConceptoId;
	}

	public void setEventoAseguradoraConceptoId(Integer eventoAseguradoraConceptoId) {
		this.eventoAseguradoraConceptoId = eventoAseguradoraConceptoId;
	}

	public void setSeparacionCuentaId(Integer separacionCuentaId) {
		this.separacionCuentaId = separacionCuentaId;
	}

	@Basic @Column(name = "MODIFICADO")
	public Boolean getModificado() {
		return modificado;
	}

	public void setModificado(Boolean modificado) {
		this.modificado = modificado;
	}
}
