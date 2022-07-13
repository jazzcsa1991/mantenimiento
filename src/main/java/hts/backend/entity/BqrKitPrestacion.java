package hts.backend.entity;

import hts.backend.entity.NomPrductoPrestacion;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by SASA Desarrollo on 14/11/2017.
 */
@Entity
@Table(name = "bqr_kit_prestacion")
public class BqrKitPrestacion implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer kitPrestacionId;
	private Integer cantidad;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private BqrKitCirugia bqrKitCirugia;
	private Integer kitCirugiaId;
	private NomPrductoPrestacion nomPrductoPrestacion;
	private Integer prductoPrestacionId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "KIT_PRESTACION_ID") public Integer getKitPrestacionId() {
		return kitPrestacionId;
	}

	public void setKitPrestacionId(Integer kitPrestacionId) {
		this.kitPrestacionId = kitPrestacionId;
	}

	@Basic @Column(name = "CANTIDAD") public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
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


	@ManyToOne @JoinColumn(name = "KIT_CIRUGIA_ID", updatable = false, insertable = false)

	public BqrKitCirugia getBqrKitCirugia() {
		return bqrKitCirugia;
	}

	public void setBqrKitCirugia(BqrKitCirugia bqrKitCirugia) {
		this.bqrKitCirugia = bqrKitCirugia;
	}

	@ManyToOne @JoinColumn(name = "PRODUCTO_PRESTACION_ID", updatable = false, insertable = false)
	public NomPrductoPrestacion getNomPrductoPrestacion() {
		return nomPrductoPrestacion;
	}

	public void setNomPrductoPrestacion(NomPrductoPrestacion nomPrductoPrestacion) {
		this.nomPrductoPrestacion = nomPrductoPrestacion;
	}


	@Column(name = "KIT_CIRUGIA_ID", nullable = false)
	public Integer getKitCirugiaId() {
		return kitCirugiaId;
	}

	public void setKitCirugiaId(Integer kitCirugiaId) {
		this.kitCirugiaId = kitCirugiaId;
	}


	@Column(name = "PRODUCTO_PRESTACION_ID", nullable = false)
	public Integer getPrductoPrestacionId() {
		return prductoPrestacionId;
	}

	public void setPrductoPrestacionId(Integer prductoPrestacionId) {
		this.prductoPrestacionId = prductoPrestacionId;
	}
}
