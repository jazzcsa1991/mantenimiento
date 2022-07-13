package hts.backend.entity;

import hts.backend.entity.*;
import hts.backend.entity.CoreEventoAseguradoraConcepto;
import hts.backend.entity.PacPaciente;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Lenovo2 on 30/06/2017.
 */
@Entity
@Table(name = "fac_bit_cargos_aseg_particular")
public class FacBitCargosAsegParticular implements Serializable {
	private Integer bitCargosAsegParticularId;
	private String usuarioCancela;
	private Date fechaCancela;
	private Integer cargoAsegParticularId;
	private Boolean modificacionManual;
	private BigDecimal cobertura;
	private BigDecimal precio;
	private BigDecimal descuento;
	private BigDecimal iva;
	private BigDecimal importe;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private CatMotivoAnulacionPrest catMotivoAnulacionPrestByMotivoCancelacionCargoId;
	private Integer motivoCancelacionCargoId;
	private PacPaciente pacPacienteByIdPaciente;
	private Integer idPaciente;
	private PacEpisodio pacEpisodioByEpisodioId;
	private Integer episodioId;
	private PacEvento pacEvento;
	private NomPrductoPrestacion nomPrductoPrestacion;
	private Boolean pagado;
	private FacCatTipoCargo facCatTipoCargo;
	private Integer tipoCargoId;
	private BigDecimal impuesto;
	private FacBitSeparacionCuenta separacionCuenta;
	private Integer separacionCuentaId;
	private Integer eventoAseguradoraConceptoId;
	private CoreEventoAseguradoraConcepto eventoAseguradoraConcepto;

	private Integer eventoId;
	private Integer productoPrestacionId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BIT_CARGOS_ASEG_PARTICULAR_ID", nullable = false, precision = 0) public Integer getBitCargosAsegParticularId() {
		return bitCargosAsegParticularId;
	}

	public void setBitCargosAsegParticularId(Integer bitCargosAsegParticularId) {
		this.bitCargosAsegParticularId = bitCargosAsegParticularId;
	}

	@Basic @Column(name = "USUARIO_CANCELA", nullable = false, length = 20) public String getUsuarioCancela() {
		return usuarioCancela;
	}

	public void setUsuarioCancela(String usuarioCancela) {
		this.usuarioCancela = usuarioCancela;
	}

	@Basic @Column(name = "FECHA_CANCELA", nullable = false) public Date getFechaCancela() {
		return fechaCancela;
	}

	public void setFechaCancela(Date fechaCancela) {
		this.fechaCancela = fechaCancela;
	}

	@Basic @Column(name = "CARGO_ASEG_PARTICULAR_ID", nullable = false, precision = 0) public Integer getCargoAsegParticularId() {
		return cargoAsegParticularId;
	}

	public void setCargoAsegParticularId(Integer cargoAsegParticularId) {
		this.cargoAsegParticularId = cargoAsegParticularId;
	}

	@Basic @Column(name = "MODIFICACION_MANUAL", nullable = false, precision = 0) public Boolean getModificacionManual() {
		return modificacionManual;
	}

	public void setModificacionManual(Boolean modificacionManual) {
		this.modificacionManual = modificacionManual;
	}

	@Basic @Column(name = "COBERTURA", nullable = false, precision = 0) public BigDecimal getCobertura() {
		return cobertura;
	}

	public void setCobertura(BigDecimal cobertura) {
		this.cobertura = cobertura;
	}

	@Basic @Column(name = "PRECIO", nullable = false, precision = 0) public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	@Basic @Column(name = "DESCUENTO", nullable = false, precision = 0) public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}


	@Basic @Column(name = "IVA", nullable = false, precision = 0) public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	@Basic @Column(name = "IMPORTE", nullable = false, precision = 0) public BigDecimal getImporte() {
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

	@Basic @Column(name = "USUARIO_REGISTRO", nullable = false, length = 20) public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}


	@ManyToOne @JoinColumn(name = "MOTIVO_CANCELACION_CARGO_ID", referencedColumnName = "MOTIVO_ANULACION_PREST_ID", updatable = false, insertable = false)
	public CatMotivoAnulacionPrest getCatMotivoAnulacionPrestByMotivoCancelacionCargoId() {
		return catMotivoAnulacionPrestByMotivoCancelacionCargoId;
	}

	public void setCatMotivoAnulacionPrestByMotivoCancelacionCargoId(CatMotivoAnulacionPrest catMotivoAnulacionPrestByMotivoCancelacionCargoId) {
		this.catMotivoAnulacionPrestByMotivoCancelacionCargoId = catMotivoAnulacionPrestByMotivoCancelacionCargoId;
	}

	@Column(name = "MOTIVO_CANCELACION_CARGO_ID")
	public Integer getMotivoCancelacionCargoId() {
		return motivoCancelacionCargoId;
	}

	public void setMotivoCancelacionCargoId(Integer motivoCancelacionCargoId) {
		this.motivoCancelacionCargoId = motivoCancelacionCargoId;
	}

	@ManyToOne @JoinColumn(name = "ID_PACIENTE", referencedColumnName = "ID_PACIENTE", updatable = false, insertable = false)
	public PacPaciente getPacPacienteByIdPaciente() {
		return pacPacienteByIdPaciente;
	}

	public void setPacPacienteByIdPaciente(PacPaciente pacPacienteByIdPaciente) {
		this.pacPacienteByIdPaciente = pacPacienteByIdPaciente;
	}

	@Column(name = "ID_PACIENTE")
	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	@ManyToOne @JoinColumn(name = "EPISODIO_ID", referencedColumnName = "EPISODIO_ID", updatable = false, insertable = false)
	public PacEpisodio getPacEpisodioByEpisodioId() {
		return pacEpisodioByEpisodioId;
	}

	public void setPacEpisodioByEpisodioId(PacEpisodio pacEpisodioByEpisodioId) {
		this.pacEpisodioByEpisodioId = pacEpisodioByEpisodioId;
	}

	@Column(name = "EPISODIO_ID")
	public Integer getEpisodioId() {
		return episodioId;
	}

	public void setEpisodioId(Integer episodioId) {
		this.episodioId = episodioId;
	}




	@Basic @Column(name = "PAGADO", nullable = false, precision = 0)
	public Boolean getPagado() {
		return pagado;
	}

	public void setPagado(Boolean pagado) {
		this.pagado = pagado;
	}

	@ManyToOne @JoinColumn(name = "TIPO_CARGO_ID", referencedColumnName = "CAT_TIPO_CARGO_ID", updatable = false, insertable = false)
	public FacCatTipoCargo getFacCatTipoCargo() {
		return facCatTipoCargo;
	}

	public void setFacCatTipoCargo(FacCatTipoCargo facCatTipoCargoByTipoCargoId) {
		this.facCatTipoCargo = facCatTipoCargoByTipoCargoId;
	}
	@Column(name = "TIPO_CARGO_ID", nullable = false)
	public Integer getTipoCargoId() {
		return tipoCargoId;
	}

	public void setTipoCargoId(Integer tipoCargoId) {
		this.tipoCargoId = tipoCargoId;
	}

	@Basic @Column(name = "IMPUESTO", nullable = false, precision = 0)
	public BigDecimal getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(BigDecimal impuesto) {
		this.impuesto = impuesto;
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

	public void setSeparacionCuentaId(Integer separacionCuentaId) {
		this.separacionCuentaId = separacionCuentaId;
	}



	@Basic @Column(name = "EVENTO_ASEGURADORA_CONCEPTO_ID")

	public Integer getEventoAseguradoraConceptoId() {
		return eventoAseguradoraConceptoId;
	}

	public void setEventoAseguradoraConceptoId(Integer eventoAseguradoraConceptoId) {
		this.eventoAseguradoraConceptoId = eventoAseguradoraConceptoId;
	}

	@ManyToOne
	@JoinColumn(name = "EVENTO_ASEGURADORA_CONCEPTO_ID", referencedColumnName = "EVENTO_ASEGURADORA_CONCEPTO_ID", updatable = false , insertable = false)
	public CoreEventoAseguradoraConcepto getEventoAseguradoraConcepto() {
		return eventoAseguradoraConcepto;
	}

	public void setEventoAseguradoraConcepto(CoreEventoAseguradoraConcepto eventoAseguradoraConcepto) {
		this.eventoAseguradoraConcepto = eventoAseguradoraConcepto;
	}

	@ManyToOne
	@JoinColumn(name = "EVENTO_ID", updatable = false , insertable = false)
	public PacEvento getPacEvento() {
		return pacEvento;
	}

	public void setPacEvento(PacEvento pacEvento) {
		this.pacEvento = pacEvento;
	}

	@ManyToOne
	@JoinColumn(name = "PRODUCTO_PRESTACION_ID", updatable = false , insertable = false)
	public NomPrductoPrestacion getNomPrductoPrestacion() {
		return nomPrductoPrestacion;
	}

	public void setNomPrductoPrestacion(NomPrductoPrestacion nomPrductoPrestacion) {
		this.nomPrductoPrestacion = nomPrductoPrestacion;
	}

	@Column(name = "EVENTO_ID")
	public Integer getEventoId() {
		return eventoId;
	}

	public void setEventoId(Integer eventoId) {
		this.eventoId = eventoId;
	}

	@Column(name = "PRODUCTO_PRESTACION_ID")
	public Integer getProductoPrestacionId() {
		return productoPrestacionId;
	}

	public void setProductoPrestacionId(Integer productoPrestacionId) {
		this.productoPrestacionId = productoPrestacionId;
	}
}
