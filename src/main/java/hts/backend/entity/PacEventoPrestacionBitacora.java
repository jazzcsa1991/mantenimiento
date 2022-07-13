package hts.backend.entity;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by SASA Desarrollo on 25/04/2017.
 */
@Entity
@Table(name = "pac_evento_prestacion_bitacora")
public class PacEventoPrestacionBitacora implements Serializable {

	private static final long serialVersionUID = 1L;
	private int eventoPrestacionBitacoraId;
	private Float cantidad;
	private Date fechaCarga;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private int tipoMovimiento;
	private PacEvento pacEventoByEventoId;
	private NomPrductoPrestacion nomPrductoPrestacionByProductoPrestacionId;
	private CatMotivoAnulacionPrest catMotivoAnulacionPrestByMotivoAnulacionPrestId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EVENTO_PRESTACION_BITACORA_ID") public int getEventoPrestacionBitacoraId() {
		return eventoPrestacionBitacoraId;
	}

	public void setEventoPrestacionBitacoraId(int eventoPrestacionBitacoraId) {
		this.eventoPrestacionBitacoraId = eventoPrestacionBitacoraId;
	}

	@Basic @Column(name = "CANTIDAD") public Float getCantidad() {
		return cantidad;
	}

	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}

	@Basic @Column(name = "FECHA_CARGA") public Date getFechaCarga() {
		return fechaCarga;
	}

	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	@Basic @Column(name = "FECHA_REGISTRO") public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO") public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Basic @Column(name = "TIPO_MOVIMIENTO") public int getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(int tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}


	@ManyToOne @JoinColumn(name = "EVENTO_ID", referencedColumnName = "EVENTO_ID", nullable = false) public PacEvento getPacEventoByEventoId() {
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

	@ManyToOne @JoinColumn(name = "MOTIVO_ANULACION_PREST_ID", referencedColumnName = "MOTIVO_ANULACION_PREST_ID") public CatMotivoAnulacionPrest getCatMotivoAnulacionPrestByMotivoAnulacionPrestId() {
		return catMotivoAnulacionPrestByMotivoAnulacionPrestId;
	}

	public void setCatMotivoAnulacionPrestByMotivoAnulacionPrestId(CatMotivoAnulacionPrest catMotivoAnulacionPrestByMotivoAnulacionPrestId) {
		this.catMotivoAnulacionPrestByMotivoAnulacionPrestId = catMotivoAnulacionPrestByMotivoAnulacionPrestId;
	}
}
