package hts.backend.entity;

import hts.backend.entity.NomCatMonedas;
import hts.backend.entity.PacEpisodio;
import hts.backend.entity.PacPagadorAsociado;
import hts.backend.entity.NomCatBanco;
import hts.backend.entity.NomCatMetodoPago;
import hts.backend.entity.PacPaciente;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "fac_abonos_aseg_particular")
public class FacAbonosAsegParticular implements Serializable {
	private Integer abonoAsegParticularId;
	private Float subtotal;
	private Float iva;
	private BigDecimal importe;
	private String referenciaPago;
	private Float tipoCambio;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Boolean conciliado;
	private Integer variosFormasPago;

	private PacPaciente pacPaciente;
	private Integer pacienteId;
	private PacEpisodio pacEpisodio;
	private Integer episodioId;
	private PacPagadorAsociado pacPagadorAsociado;
	private Integer pagadorAsociadoId;
	private NomCatMetodoPago nomCatMetodoPago;
	private Integer metodoPagoId;
	private NomCatMonedas nomCatMonedas;
	private Integer monedaId;
	private NomCatBanco nomCatBanco;
	private Integer bancoId;

	private BigDecimal importeTransaccion;

	private FacCatTipoTransaccion facCatTipoTransaccion;
	private Integer tipoTransaccionId;

	private FacAbonosAsegParticular facAbonosAsegParticular;
	private Integer transaccionId;

	@Transient
	private BigDecimal pendienteConciliacion;

	private Set<FacConcilAsegParticular> conciliaciones;
	private Set<FacFormasPagoAsegPart> formasPago;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ABONO_ASEG_PARTICULAR_ID", nullable = false)
	public Integer getAbonoAsegParticularId() {
		return abonoAsegParticularId;
	}

	public void setAbonoAsegParticularId(Integer abonoAsegParticularId) {
		this.abonoAsegParticularId = abonoAsegParticularId;
	}


	@Basic
	@Column(name = "SUBTOTAL")
	public Float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}


	@Basic
	@Column(name = "IVA")
	public Float getIva() {
		return iva;
	}


	public void setIva(Float iva) {
		this.iva = iva;
	}


	@Basic
	@Column(name = "IMPORTE", nullable = false)
	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}


	@Basic
	@Column(name = "REFERENCIA_PAGO", length = 50)
	public String getReferenciaPago() {
		return referenciaPago;
	}

	public void setReferenciaPago(String referenciaPago) {
		this.referenciaPago = referenciaPago;
	}


	@Basic
	@Column(name = "TIPO_CAMBIO")
	public Float getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(Float tipoCambio) {
		this.tipoCambio = tipoCambio;
	}


	@Basic
	@Column(name = "FECHA_REGISTRO", nullable = false)
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@Basic
	@Column(name = "USUARIO_REGISTRO", nullable = false, length = 20)
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Basic
	@Column(name = "VARIOS_FORMAS_PAGO", nullable = false, length = 20)
	public Integer getVariosFormasPago() {
		return variosFormasPago;
	}

	public void setVariosFormasPago(Integer variosFormasPago) {
		this.variosFormasPago = variosFormasPago;
	}


	@ManyToOne
	@JoinColumn(name = "ID_PACIENTE", referencedColumnName = "ID_PACIENTE", insertable = false, updatable = false)
	public PacPaciente getPacPaciente() {
		return pacPaciente;
	}

	public void setPacPaciente(PacPaciente pacPacienteByIdPaciente) {
		this.pacPaciente = pacPacienteByIdPaciente;
	}


	@ManyToOne
	@JoinColumn(name = "EPISODIO_ID", referencedColumnName = "EPISODIO_ID", insertable = false, updatable = false)
	public PacEpisodio getPacEpisodio() {
		return pacEpisodio;
	}

	public void setPacEpisodio(PacEpisodio pacEpisodioByEpisodioId) {
		this.pacEpisodio = pacEpisodioByEpisodioId;
	}


	@ManyToOne
	@JoinColumn(name = "PAGADOR_ASOCIADO_ID", referencedColumnName = "PAGADOR_ASOCIADO_ID", insertable = false, updatable = false)
	public PacPagadorAsociado getPacPagadorAsociado() {
		return pacPagadorAsociado;
	}

	public void setPacPagadorAsociado(PacPagadorAsociado pacPagadorAsociadoByPagadorAsociadoId) {
		this.pacPagadorAsociado = pacPagadorAsociadoByPagadorAsociadoId;
	}


	@ManyToOne
	@JoinColumn(name = "METODO_PAGO_ID", referencedColumnName = "METODO_PAGO_ID", insertable = false, updatable = false)
	public NomCatMetodoPago getNomCatMetodoPago() {
		return nomCatMetodoPago;
	}

	public void setNomCatMetodoPago(NomCatMetodoPago nomCatMetodoPagoByMetodoPagoId) {
		this.nomCatMetodoPago = nomCatMetodoPagoByMetodoPagoId;
	}


	@ManyToOne
	@JoinColumn(name = "MONEDA_ID", referencedColumnName = "MONEDAS_ID", insertable = false, updatable = false)
	public NomCatMonedas getNomCatMonedas() {
		return nomCatMonedas;
	}

	public void setNomCatMonedas(NomCatMonedas nomCatMonedasByMonedaId) {
		this.nomCatMonedas = nomCatMonedasByMonedaId;
	}


	@ManyToOne
	@JoinColumn(name = "BANCO_ID", referencedColumnName = "BANCO_ID", insertable = false, updatable = false)
	public NomCatBanco getNomCatBanco() {
		return nomCatBanco;
	}

	public void setNomCatBanco(NomCatBanco nomCatBancoByBancoId) {
		this.nomCatBanco = nomCatBancoByBancoId;
	}


	@OneToMany(mappedBy = "cargoAsegParticular")
	public Set<FacConcilAsegParticular> getConciliaciones() {
		return conciliaciones;
	}

	public void setConciliaciones(Set<FacConcilAsegParticular> facConcilAsegParticularsByAbonoAsegParticularId) {
		this.conciliaciones = facConcilAsegParticularsByAbonoAsegParticularId;
	}


	@Basic
	@Column(name = "CONCILIADO", nullable = false)
	public Boolean getConciliado() {
		return conciliado;
	}

	public void setConciliado(Boolean conciliado) {
		this.conciliado = conciliado;
	}


	@OneToMany(mappedBy = "facAbonosAsegParticular")
	public Set<FacFormasPagoAsegPart> getFormasPago() {
		return formasPago;
	}

	public void setFormasPago(Set<FacFormasPagoAsegPart> facFormasPagoAsegPartsByAbonoAsegParticularId) {
		this.formasPago = facFormasPagoAsegPartsByAbonoAsegParticularId;
	}


	@Transient
	public BigDecimal getPendienteConciliacion() {
		return pendienteConciliacion;
	}

	public void setPendienteConciliacion(BigDecimal pendienteConciliacion) {
		this.pendienteConciliacion = pendienteConciliacion;
	}


	@Column(name = "ID_PACIENTE", nullable = false)
	public Integer getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Integer pacienteId) {
		this.pacienteId = pacienteId;
	}


	@Column(name = "EPISODIO_ID", nullable = false)
	public Integer getEpisodioId() {
		return episodioId;
	}

	public void setEpisodioId(Integer episodioId) {
		this.episodioId = episodioId;
	}


	@Column(name = "PAGADOR_ASOCIADO_ID", nullable = true)
	public Integer getPagadorAsociadoId() {
		return pagadorAsociadoId;
	}

	public void setPagadorAsociadoId(Integer pagadorAsociadoId) {
		this.pagadorAsociadoId = pagadorAsociadoId;
	}


	@Column(name = "METODO_PAGO_ID", nullable = false)
	public Integer getMetodoPagoId() {
		return metodoPagoId;
	}

	public void setMetodoPagoId(Integer metodoPagoId) {
		this.metodoPagoId = metodoPagoId;
	}


	@Column(name = "MONEDA_ID", nullable = false)
	public Integer getMonedaId() {
		return monedaId;
	}

	public void setMonedaId(Integer monedaId) {
		this.monedaId = monedaId;
	}


	@Column(name = "BANCO_ID")
	public Integer getBancoId() {
		return bancoId;
	}

	public void setBancoId(Integer bancoId) {
		this.bancoId = bancoId;
	}

	@Basic
	@Column(name = "IMPORTE_TRANSACCION", nullable = true)
	public BigDecimal getImporteTransaccion() {
		return importeTransaccion;
	}

	public void setImporteTransaccion(BigDecimal importeTransaccion) {
		this.importeTransaccion = importeTransaccion;
	}

	@Basic
	@Column(name = "TIPO_TRANSACCION_ID", nullable = true)
	public Integer getTipoTransaccionId() {
		return tipoTransaccionId;
	}

	public void setTipoTransaccionId(Integer tipoTransaccionId) {
		this.tipoTransaccionId = tipoTransaccionId;
	}

	@Basic
	@Column(name = "TRANSACCION_ID")
	public Integer getTransaccionId() {
		return transaccionId;
	}

	public void setTransaccionId(Integer transaccionId) {
		this.transaccionId = transaccionId;
	}

	@ManyToOne
	@JoinColumn(name = "TRANSACCION_ID", referencedColumnName = "TRANSACCION_ID", insertable = false, updatable = false)
	public FacAbonosAsegParticular getFacAbonosAsegParticular() {
		return facAbonosAsegParticular;
	}

	public void setFacAbonosAsegParticular(FacAbonosAsegParticular facAbonosAsegParticular) {
		this.facAbonosAsegParticular = facAbonosAsegParticular;
	}

	@ManyToOne
	@JoinColumn(name = "TIPO_TRANSACCION_ID", referencedColumnName = "TIPO_TRANSACCION_ID", insertable = false, updatable = false)
	public FacCatTipoTransaccion getFacCatTipoTransaccion() {
		return facCatTipoTransaccion;
	}

	public void setFacCatTipoTransaccion(FacCatTipoTransaccion facCatTipoTransaccion) {
		this.facCatTipoTransaccion = facCatTipoTransaccion;
	}
}
