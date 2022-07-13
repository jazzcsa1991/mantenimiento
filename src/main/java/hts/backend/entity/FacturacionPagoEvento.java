package hts.backend.entity;

import hts.backend.entity.PacEvento;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Lenovo2 on 15/06/2017.
 */
@Entity
@Table(name = "facturacion_pago_evento")
public class FacturacionPagoEvento implements java.io.Serializable{

	private Integer pagoEventoId;
	private Date fechaRegistro;
	private String usuarioRegistra;
	private Float monto;
	private String folio;
	private Set<FacturacionEvento> facturacionEventosByPagoEventoId;
	private Set<FacturacionFormasPago> facturacionFormasPagosByPagoEventoId;
	private PacEvento pacEventoByEventoId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAGO_EVENTO_ID", nullable = false, precision = 0)
	public Integer getPagoEventoId() {
		return pagoEventoId;
	}

	public void setPagoEventoId(Integer pagoEventoId) {
		this.pagoEventoId = pagoEventoId;
	}

	@Basic @Column(name = "FECHA_REGISTRO", nullable = true)
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO", nullable = false, length = 20)
	public String getUsuarioRegistra() {
		return usuarioRegistra;
	}

	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}

	@Basic @Column(name = "MONTO", nullable = false, precision = 0)
	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	@Basic @Column(name = "FOLIO", nullable = false, length = 20)
	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}


	@OneToMany(mappedBy = "facturacionPagoEventoByPagoEventoId") public Set<FacturacionEvento> getFacturacionEventosByPagoEventoId() {
		return facturacionEventosByPagoEventoId;
	}

	public void setFacturacionEventosByPagoEventoId(Set<FacturacionEvento> facturacionEventosByPagoEventoId) {
		this.facturacionEventosByPagoEventoId = facturacionEventosByPagoEventoId;
	}

	@OneToMany(mappedBy = "facturacionPagoEventoByPagoEventoId")
	public Set<FacturacionFormasPago> getFacturacionFormasPagosByPagoEventoId() {
		return facturacionFormasPagosByPagoEventoId;
	}

	public void setFacturacionFormasPagosByPagoEventoId(Set<FacturacionFormasPago> facturacionFormasPagosByPagoEventoId) {
		this.facturacionFormasPagosByPagoEventoId = facturacionFormasPagosByPagoEventoId;
	}

	@ManyToOne
	@JoinColumn(name = "EVENTO_ID", referencedColumnName = "EVENTO_ID", nullable = false)
	public PacEvento getPacEventoByEventoId() {
		return pacEventoByEventoId;
	}

	public void setPacEventoByEventoId(PacEvento pacEventoByEventoId) {
		this.pacEventoByEventoId = pacEventoByEventoId;
	}
}
