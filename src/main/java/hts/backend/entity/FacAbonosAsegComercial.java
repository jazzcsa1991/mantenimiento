package hts.backend.entity;

import hts.backend.entity.NomCatMonedas;
import hts.backend.entity.PacConvenioAseguradora;
import hts.backend.entity.PacEpisodio;
import hts.backend.entity.PacEvento;
import hts.backend.entity.NomCatBanco;
import hts.backend.entity.NomCatMetodoPago;
import hts.backend.entity.PacPaciente;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "fac_abonos_aseg_comercial")
public class FacAbonosAsegComercial implements Serializable {
	private Integer abonoAsegComercialId;
	private Float subtotal;
	private Float iva;
	private BigDecimal importe;
	private String referenciaPago;
	private Float tipoCambio;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Boolean conciliado;

	private PacPaciente pacPaciente;
	private Integer pacienteId;

	private PacEvento pacEvento;
	private Integer eventoId;

	private PacConvenioAseguradora pacConvenioAseguradora;
	private Integer convenioAseguradoraId;

	private NomCatMetodoPago nomCatMetodoPago;
	private Integer metodoPagoId;

	private NomCatMonedas nomCatMonedas;
	private Integer monedaId;

	private NomCatBanco nomCatBanco;
	private Integer bancoId;

	@Transient
	private BigDecimal pendienteConciliacion;

	private Set<FacConcilAsegComercial> conciliaciones;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ABONO_ASEG_COMERCIAL_ID", nullable = false)
	public Integer getAbonoAsegComercialId() {
		return abonoAsegComercialId;
	}

	public void setAbonoAsegComercialId(Integer abonoAsegComercialId) {
		this.abonoAsegComercialId = abonoAsegComercialId;
	}


	@Basic
	@Column(name = "SUBTOTAL", nullable = false)
	public Float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}


	@Basic
	@Column(name = "IVA", nullable = false)
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
	@Column(name = "TIPO_CAMBIO", nullable = false)
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


	@ManyToOne
	@JoinColumn(name = "ID_PACIENTE", referencedColumnName = "ID_PACIENTE", updatable = false, insertable = false)
	public PacPaciente getPacPaciente() {
		return pacPaciente;
	}

	public void setPacPaciente(PacPaciente pacPacienteByIdPaciente) {
		this.pacPaciente = pacPacienteByIdPaciente;
	}


	@Column(name = "ID_PACIENTE", nullable = false)
	public Integer getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Integer pacienteId) {
		this.pacienteId = pacienteId;
	}


	@ManyToOne
	@JoinColumn(name = "EVENTO_ID", referencedColumnName = "EVENTO_ID", updatable = false, insertable = false)
	public PacEvento getPacEvento() {
		return pacEvento;
	}

	public void setPacEvento(PacEvento pacEventoByEventoId) {
		this.pacEvento = pacEventoByEventoId;
	}


	@Column(name = "EVENTO_ID", nullable = false)
	public Integer getEventoId() {
		return eventoId;
	}

	public void setEventoId(Integer eventoId) {
		this.eventoId = eventoId;
	}


	@ManyToOne
	@JoinColumn(name = "CONVENIO_ASEGURADORA_ID", referencedColumnName = "CONVENIO_ASEGURADORA_ID", updatable = false, insertable = false)
	public PacConvenioAseguradora getPacConvenioAseguradora() {
		return pacConvenioAseguradora;
	}

	public void setPacConvenioAseguradora(PacConvenioAseguradora pacConvenioAseguradora) {
		this.pacConvenioAseguradora = pacConvenioAseguradora;
	}


	@Column(name = "CONVENIO_ASEGURADORA_ID", nullable = false)
	public Integer getConvenioAseguradoraId() {
		return convenioAseguradoraId;
	}

	public void setConvenioAseguradoraId(Integer convenioAseguradoraId) {
		this.convenioAseguradoraId = convenioAseguradoraId;
	}


	@ManyToOne
	@JoinColumn(name = "METODO_PAGO_ID", referencedColumnName = "METODO_PAGO_ID", updatable = false, insertable = false)
	public NomCatMetodoPago getNomCatMetodoPago() {
		return nomCatMetodoPago;
	}

	public void setNomCatMetodoPago(NomCatMetodoPago nomCatMetodoPagoByMetodoPagoId) {
		this.nomCatMetodoPago = nomCatMetodoPagoByMetodoPagoId;
	}


	@Column(name = "METODO_PAGO_ID", nullable = false)
	public Integer getMetodoPagoId() {
		return metodoPagoId;
	}

	public void setMetodoPagoId(Integer metodoPagoId) {
		this.metodoPagoId = metodoPagoId;
	}


	@ManyToOne
	@JoinColumn(name = "MONEDA_ID", referencedColumnName = "MONEDAS_ID", updatable = false, insertable = false)
	public NomCatMonedas getNomCatMonedas() {
		return nomCatMonedas;
	}

	public void setNomCatMonedas(NomCatMonedas nomCatMonedasByMonedaId) {
		this.nomCatMonedas = nomCatMonedasByMonedaId;
	}


	@Column(name = "MONEDA_ID", nullable = false)
	public Integer getMonedaId() {
		return monedaId;
	}

	public void setMonedaId(Integer monedaId) {
		this.monedaId = monedaId;
	}


	@ManyToOne
	@JoinColumn(name = "BANCO_ID", referencedColumnName = "BANCO_ID", updatable = false, insertable = false)
	public NomCatBanco getNomCatBanco() {
		return nomCatBanco;
	}

	public void setNomCatBanco(NomCatBanco nomCatBancoByBancoId) {
		this.nomCatBanco = nomCatBancoByBancoId;
	}


	@Column(name = "BANCO_ID")
	public Integer getBancoId() {
		return bancoId;
	}

	public void setBancoId(Integer bancoId) {
		this.bancoId = bancoId;
	}


	@OneToMany(mappedBy = "abonoAsegComercial")
	public Set<FacConcilAsegComercial> getConciliaciones() {
		return conciliaciones;
	}

	public void setConciliaciones(Set<FacConcilAsegComercial> facConcilAsegComercialsByAbonoAsegComercialId) {
		this.conciliaciones = facConcilAsegComercialsByAbonoAsegComercialId;
	}


	@Basic
	@Column(name = "CONCILIADO", nullable = false)
	public Boolean getConciliado() {
		return conciliado;
	}

	public void setConciliado(Boolean conciliado) {
		this.conciliado = conciliado;
	}


	@Transient
	public BigDecimal getPendienteConciliacion() {
		return pendienteConciliacion;
	}

	public void setPendienteConciliacion(BigDecimal pendienteConciliacion) {
		this.pendienteConciliacion = pendienteConciliacion;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		FacAbonosAsegComercial that = (FacAbonosAsegComercial) o;

		if (abonoAsegComercialId != null ? !abonoAsegComercialId.equals(that.abonoAsegComercialId) : that.abonoAsegComercialId != null)
			return false;
		if (subtotal != null ? !subtotal.equals(that.subtotal) : that.subtotal != null) return false;
		if (iva != null ? !iva.equals(that.iva) : that.iva != null) return false;
		if (importe != null ? !importe.equals(that.importe) : that.importe != null) return false;
		if (referenciaPago != null ? !referenciaPago.equals(that.referenciaPago) : that.referenciaPago != null)
			return false;
		if (tipoCambio != null ? !tipoCambio.equals(that.tipoCambio) : that.tipoCambio != null) return false;
		if (fechaRegistro != null ? !fechaRegistro.equals(that.fechaRegistro) : that.fechaRegistro != null)
			return false;
		if (usuarioRegistro != null ? !usuarioRegistro.equals(that.usuarioRegistro) : that.usuarioRegistro != null)
			return false;

		return true;
	}


	@Override
	public int hashCode() {
		int result = abonoAsegComercialId != null ? abonoAsegComercialId.hashCode() : 0;
		result = 31 * result + (subtotal != null ? subtotal.hashCode() : 0);
		result = 31 * result + (iva != null ? iva.hashCode() : 0);
		result = 31 * result + (importe != null ? importe.hashCode() : 0);
		result = 31 * result + (referenciaPago != null ? referenciaPago.hashCode() : 0);
		result = 31 * result + (tipoCambio != null ? tipoCambio.hashCode() : 0);
		result = 31 * result + (fechaRegistro != null ? fechaRegistro.hashCode() : 0);
		result = 31 * result + (usuarioRegistro != null ? usuarioRegistro.hashCode() : 0);
		return result;
	}
}
