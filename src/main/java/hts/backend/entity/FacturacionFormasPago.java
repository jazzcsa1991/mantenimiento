package hts.backend.entity;


import hts.backend.entity.NomCatMonedas;
import hts.backend.entity.NomCatBanco;
import hts.backend.entity.NomCatMetodoPago;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by Lenovo2 on 15/06/2017.
 */
@Entity
@Table(name = "facturacion_formas_pago")
public class FacturacionFormasPago implements java.io.Serializable{

	private Integer formasPagoId;
	private String referenciaPago;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Float monto;
	private NomCatMetodoPago nomCatMetodoPagoByMetodoPagoId;
	private NomCatMonedas nomCatMonedasByMonedasId;
	private NomCatBanco nomCatBancoByBancoId;
	private FacturacionPagoEvento facturacionPagoEventoByPagoEventoId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FORMAS_PAGO_ID", nullable = false, precision = 0)
	public Integer getFormasPagoId() {
		return formasPagoId;
	}

	public void setFormasPagoId(Integer formasPagoId) {
		this.formasPagoId = formasPagoId;
	}

	@Basic @Column(name = "REFERENCIA_PAGO", length = 50)
	public String getReferenciaPago() {
		return referenciaPago;
	}

	public void setReferenciaPago(String referenciaPago) {
		this.referenciaPago = referenciaPago;
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

	@Basic @Column(name = "MONTO", nullable = false, precision = 0)
	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	@ManyToOne
	@JoinColumn(name = "METODO_PAGO_ID", referencedColumnName = "METODO_PAGO_ID", nullable = false)
	public NomCatMetodoPago getNomCatMetodoPagoByMetodoPagoId() {
		return nomCatMetodoPagoByMetodoPagoId;
	}

	public void setNomCatMetodoPagoByMetodoPagoId(NomCatMetodoPago nomCatMetodoPagoByMetodoPagoId) {
		this.nomCatMetodoPagoByMetodoPagoId = nomCatMetodoPagoByMetodoPagoId;
	}

	@ManyToOne
	@JoinColumn(name = "MONEDAS_ID", referencedColumnName = "MONEDAS_ID", nullable = false)
	public NomCatMonedas getNomCatMonedasByMonedasId() {
		return nomCatMonedasByMonedasId;
	}

	public void setNomCatMonedasByMonedasId(NomCatMonedas nomCatMonedasByMonedasId) {
		this.nomCatMonedasByMonedasId = nomCatMonedasByMonedasId;
	}

	@ManyToOne
	@JoinColumn(name = "BANCO_ID", referencedColumnName = "BANCO_ID")
	public NomCatBanco getNomCatBancoByBancoId() {

		return nomCatBancoByBancoId;
	}

	public void setNomCatBancoByBancoId(NomCatBanco nomCatBancoByBancoId) {
		this.nomCatBancoByBancoId = nomCatBancoByBancoId;
	}

	@ManyToOne
	@JoinColumn(name = "PAGO_EVENTO_ID", referencedColumnName = "PAGO_EVENTO_ID", nullable = false)
	public FacturacionPagoEvento getFacturacionPagoEventoByPagoEventoId() {
		return facturacionPagoEventoByPagoEventoId;
	}

	public void setFacturacionPagoEventoByPagoEventoId(FacturacionPagoEvento facturacionPagoEventoByPagoEventoId) {
		this.facturacionPagoEventoByPagoEventoId = facturacionPagoEventoByPagoEventoId;
	}
}
