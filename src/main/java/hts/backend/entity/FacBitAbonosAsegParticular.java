package hts.backend.entity;

import hts.backend.entity.NomCatMonedas;
import hts.backend.entity.PacEpisodio;
import hts.backend.entity.PacPagadorAsociado;
import hts.backend.entity.NomCatBanco;
import hts.backend.entity.NomCatMetodoPago;
import hts.backend.entity.PacPaciente;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "fac_bit_abonos_aseg_particular")
public class FacBitAbonosAsegParticular implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer bitAbonoAsegParticularId;
	private Integer motivoCancelacionAbonoId;
	private Date fechaCancela;
	private String usuarioCancela;
	private Integer abonoAsegParticularId;
	private Integer idPaciente;
	private Integer episodioId;
	private Integer pagadorAsociadoId;
	private Integer subtotal;
	private Integer iva;
	private Integer importe;
	private Integer metodoPagoId;
	private Integer monedaId;
	private String referenciaPago;
	private Integer bancoId;
	private Double tipoCambio;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Integer conciliado;
	private Integer importeTransaccion;
	private Integer tipoTransaccionId;
	private Integer transaccionId;
	private PacPaciente pacPacienteByIdPaciente;
	private PacEpisodio pacEpisodioByEpisodioId;
	private PacPagadorAsociado pacPagadorAsociadoByPagadorAsociadoId;
	private NomCatMetodoPago nomCatMetodoPagoByMetodoPagoId;
	private NomCatMonedas nomCatMonedasByMonedaId;
	private NomCatBanco nomCatBancoByBancoId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BIT_ABONO_ASEG_PARTICULAR_ID",  precision = 0)
	public Integer getBitAbonoAsegParticularId() {
		return bitAbonoAsegParticularId;
	}

	public void setBitAbonoAsegParticularId(Integer bitAbonoAsegParticularId) {
		this.bitAbonoAsegParticularId = bitAbonoAsegParticularId;
	}

	@Basic
	@Column(name = "MOTIVO_CANCELACION_ABONO_ID",  precision = 0)
	public Integer getMotivoCancelacionAbonoId() {
		return motivoCancelacionAbonoId;
	}

	public void setMotivoCancelacionAbonoId(Integer motivoCancelacionAbonoId) {
		this.motivoCancelacionAbonoId = motivoCancelacionAbonoId;
	}

	@Basic
	@Column(name = "FECHA_CANCELA")
	public Date getFechaCancela() {
		return fechaCancela;
	}

	public void setFechaCancela(Date fechaCancela) {
		this.fechaCancela = fechaCancela;
	}

	@Basic
	@Column(name = "USUARIO_CANCELA")
	public String getUsuarioCancela() {
		return usuarioCancela;
	}

	public void setUsuarioCancela(String usuarioCancela) {
		this.usuarioCancela = usuarioCancela;
	}

	@Basic
	@Column(name = "ABONO_ASEG_PARTICULAR_ID",  precision = 0)
	public Integer getAbonoAsegParticularId() {
		return abonoAsegParticularId;
	}

	public void setAbonoAsegParticularId(Integer abonoAsegParticularId) {
		this.abonoAsegParticularId = abonoAsegParticularId;
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
	@Column(name = "ID_PACIENTE",  precision = 0)
	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	@Basic
	@Column(name = "EPISODIO_ID",  precision = 0)
	public Integer getEpisodioId() {
		return episodioId;
	}

	public void setEpisodioId(Integer episodioId) {
		this.episodioId = episodioId;
	}

	@Basic
	@Column(name = "PAGADOR_ASOCIADO_ID",  precision = 0)
	public Integer getPagadorAsociadoId() {
		return pagadorAsociadoId;
	}

	public void setPagadorAsociadoId(Integer pagadorAsociadoId) {
		this.pagadorAsociadoId = pagadorAsociadoId;
	}

	@Basic
	@Column(name = "SUBTOTAL",  precision = 0)
	public Integer getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}

	@Basic
	@Column(name = "IVA",  precision = 0)
	public Integer getIva() {
		return iva;
	}

	public void setIva(Integer iva) {
		this.iva = iva;
	}

	@Basic
	@Column(name = "IMPORTE",  precision = 0)
	public Integer getImporte() {
		return importe;
	}

	public void setImporte(Integer importe) {
		this.importe = importe;
	}

	@Basic
	@Column(name = "METODO_PAGO_ID",  precision = 0)
	public Integer getMetodoPagoId() {
		return metodoPagoId;
	}

	public void setMetodoPagoId(Integer metodoPagoId) {
		this.metodoPagoId = metodoPagoId;
	}

	@Basic
	@Column(name = "MONEDA_ID",  precision = 0)
	public Integer getMonedaId() {
		return monedaId;
	}

	public void setMonedaId(Integer monedaId) {
		this.monedaId = monedaId;
	}

	@Basic
	@Column(name = "REFERENCIA_PAGO",  length = 50)
	public String getReferenciaPago() {
		return referenciaPago;
	}

	public void setReferenciaPago(String referenciaPago) {
		this.referenciaPago = referenciaPago;
	}

	@Basic
	@Column(name = "BANCO_ID",  precision = 0)
	public Integer getBancoId() {
		return bancoId;
	}

	public void setBancoId(Integer bancoId) {
		this.bancoId = bancoId;
	}

	@Basic
	@Column(name = "TIPO_CAMBIO",  precision = 0)
	public Double getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(Double tipoCambio) {
		this.tipoCambio = tipoCambio;
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
	@Column(name = "CONCILIADO",  precision = 0)
	public Integer getConciliado() {
		return conciliado;
	}

	public void setConciliado(Integer conciliado) {
		this.conciliado = conciliado;
	}

	@Basic
	@Column(name = "IMPORTE_TRANSACCION",  precision = 0)
	public Integer getImporteTransaccion() {
		return importeTransaccion;
	}

	public void setImporteTransaccion(Integer importeTransaccion) {
		this.importeTransaccion = importeTransaccion;
	}

	@Basic
	@Column(name = "TIPO_TRANSACCION_ID",  precision = 0)
	public Integer getTipoTransaccionId() {
		return tipoTransaccionId;
	}

	public void setTipoTransaccionId(Integer tipoTransaccionId) {
		this.tipoTransaccionId = tipoTransaccionId;
	}

	@Basic
	@Column(name = "TRANSACCION_ID",  precision = 0)
	public Integer getTransaccionId() {
		return transaccionId;
	}

	public void setTransaccionId(Integer transaccionId) {
		this.transaccionId = transaccionId;
	}

	@ManyToOne
	@JoinColumn(name = "ID_PACIENTE", referencedColumnName = "ID_PACIENTE", insertable = false, updatable = false)
	public PacPaciente getPacPacienteByIdPaciente() {
		return pacPacienteByIdPaciente;
	}

	public void setPacPacienteByIdPaciente(PacPaciente pacPacienteByIdPaciente) {
		this.pacPacienteByIdPaciente = pacPacienteByIdPaciente;
	}

	@ManyToOne
	@JoinColumn(name = "EPISODIO_ID", referencedColumnName = "EPISODIO_ID", insertable = false, updatable = false)
	public PacEpisodio getPacEpisodioByEpisodioId() {
		return pacEpisodioByEpisodioId;
	}

	public void setPacEpisodioByEpisodioId(PacEpisodio pacEpisodioByEpisodioId) {
		this.pacEpisodioByEpisodioId = pacEpisodioByEpisodioId;
	}

	@ManyToOne
	@JoinColumn(name = "PAGADOR_ASOCIADO_ID", referencedColumnName = "PAGADOR_ASOCIADO_ID", insertable = false, updatable = false)
	public PacPagadorAsociado getPacPagadorAsociadoByPagadorAsociadoId() {
		return pacPagadorAsociadoByPagadorAsociadoId;
	}

	public void setPacPagadorAsociadoByPagadorAsociadoId(PacPagadorAsociado pacPagadorAsociadoByPagadorAsociadoId) {
		this.pacPagadorAsociadoByPagadorAsociadoId = pacPagadorAsociadoByPagadorAsociadoId;
	}

	@ManyToOne
	@JoinColumn(name = "METODO_PAGO_ID", referencedColumnName = "METODO_PAGO_ID", insertable = false, updatable = false)
	public NomCatMetodoPago getNomCatMetodoPagoByMetodoPagoId() {
		return nomCatMetodoPagoByMetodoPagoId;
	}

	public void setNomCatMetodoPagoByMetodoPagoId(NomCatMetodoPago nomCatMetodoPagoByMetodoPagoId) {
		this.nomCatMetodoPagoByMetodoPagoId = nomCatMetodoPagoByMetodoPagoId;
	}

	@ManyToOne
	@JoinColumn(name = "MONEDA_ID", referencedColumnName = "MONEDAS_ID", insertable = false, updatable = false)
	public NomCatMonedas getNomCatMonedasByMonedaId() {
		return nomCatMonedasByMonedaId;
	}

	public void setNomCatMonedasByMonedaId(NomCatMonedas nomCatMonedasByMonedaId) {
		this.nomCatMonedasByMonedaId = nomCatMonedasByMonedaId;
	}

	@ManyToOne
	@JoinColumn(name = "BANCO_ID", referencedColumnName = "BANCO_ID", insertable = false, updatable = false)
	public NomCatBanco getNomCatBancoByBancoId() {
		return nomCatBancoByBancoId;
	}

	public void setNomCatBancoByBancoId(NomCatBanco nomCatBancoByBancoId) {
		this.nomCatBancoByBancoId = nomCatBancoByBancoId;
	}
}
