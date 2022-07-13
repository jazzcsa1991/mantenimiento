package hts.backend.entity;

import hts.backend.entity.NomCatMonedas;
import hts.backend.entity.NomCatBanco;
import hts.backend.entity.NomCatMetodoPago;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "fac_formas_pago_aseg_part")
public class FacFormasPagoAsegPart implements java.io.Serializable{
	private Integer formasPagoAsegPartId;
	private String referenciaPago;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Float importe;
	private Float tipoCambio;
	private NomCatMetodoPago nomCatMetodoPago;
	private Integer metodoPagoId;
	private NomCatMonedas nomCatMonedas;
	private Integer monedaId;
	private NomCatBanco nomCatBanco;
	private Integer bancoId;
	private FacAbonosAsegParticular facAbonosAsegParticular;
	private Integer abonoAsegParticularId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FORMAS_PAGO_ASEG_PART_ID", nullable = false)
	public Integer getFormasPagoAsegPartId() {
		return formasPagoAsegPartId;
	}

	public void setFormasPagoAsegPartId(Integer formasPagoAsegPartId) {
		this.formasPagoAsegPartId = formasPagoAsegPartId;
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
	@Column(name = "IMPORTE", nullable = false)
	public Float getImporte() {
		return importe;
	}

	public void setImporte(Float importe) {
		this.importe = importe;
	}


	@Basic
	@Column(name = "TIPO_CAMBIO", nullable = false)
	public Float getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(Float tipoCambio) {
		this.tipoCambio = tipoCambio ;
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
	@JoinColumn(name = "MONEDAS_ID", referencedColumnName = "MONEDAS_ID",  updatable = false, insertable = false)
	public NomCatMonedas getNomCatMonedas() {
		return nomCatMonedas;
	}

	public void setNomCatMonedas(NomCatMonedas nomCatMonedasByMonedasId) {
		this.nomCatMonedas = nomCatMonedasByMonedasId;
	}

	@Column(name = "MONEDAS_ID", nullable = false)
	public Integer getMonedaId() {
		return monedaId;
	}

	public void setMonedaId(Integer monedaId) {
		this.monedaId = monedaId;
	}

	@ManyToOne
	@JoinColumn(name = "BANCO_ID", referencedColumnName = "BANCO_ID",  updatable = false, insertable = false)
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


	@ManyToOne
	@JoinColumn(name = "ABONO_ASEG_PARTICULAR_ID", referencedColumnName = "ABONO_ASEG_PARTICULAR_ID", updatable = false, insertable = false)
	public FacAbonosAsegParticular getFacAbonosAsegParticular() {
		return facAbonosAsegParticular;
	}

	public void setFacAbonosAsegParticular(FacAbonosAsegParticular facAbonosAsegParticularByAbonoAsegParticularId) {
		this.facAbonosAsegParticular = facAbonosAsegParticularByAbonoAsegParticularId;
	}

	@Column(name = "ABONO_ASEG_PARTICULAR_ID", nullable = false)
	public Integer getAbonoAsegParticularId() {
		return abonoAsegParticularId;
	}

	public void setAbonoAsegParticularId(Integer abonoAsegParticularId) {
		this.abonoAsegParticularId = abonoAsegParticularId;
	}
}
