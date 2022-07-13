package hts.backend.entity;


import hts.backend.entity.NomCatCie9;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "bqr_tipo_procedimiento_cie9")
public class BqrTipoProcedimientoCie9 implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer tipoProcedimientoCie9Id;
	private String usuarioRegistro;
	private Date fechaRegistro;
	private NomCatCie9 nomCatCie9ByCie9Id;
	private BqrTipoProcedimiento bqrTipoProcedimientoByTipoProcedimientoId;
	private Integer cie9Id;
	private Integer tipoProcedimientoId;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TIPO_PROCEDIMIENTO_CIE9_ID", nullable = false, precision = 0) public Integer getTipoProcedimientoCie9Id() {
		return tipoProcedimientoCie9Id;
	}

	public void setTipoProcedimientoCie9Id(Integer tipoProcedimientoCie9Id) {
		this.tipoProcedimientoCie9Id = tipoProcedimientoCie9Id;
	}

	@Basic @Column(name = "USUARIO_REGISTRO", nullable = false, length = 50) public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Basic @Column(name = "FECHA_REGISTRO", nullable = false)
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@ManyToOne @JoinColumn(name = "CIE_9_ID", updatable = false, insertable = false)
	public NomCatCie9 getNomCatCie9ByCie9Id() {
		return nomCatCie9ByCie9Id;
	}

	public void setNomCatCie9ByCie9Id(NomCatCie9 nomCatCie9ByCie9Id) {
		this.nomCatCie9ByCie9Id = nomCatCie9ByCie9Id;
	}

	@ManyToOne @JoinColumn(name = "TIPO_PROCEDIMIENTO_ID", updatable = false, insertable = false)
	public BqrTipoProcedimiento getBqrTipoProcedimientoByTipoProcedimientoId() {
		return bqrTipoProcedimientoByTipoProcedimientoId;
	}

	public void setBqrTipoProcedimientoByTipoProcedimientoId(BqrTipoProcedimiento bqrTipoProcedimientoByTipoProcedimientoId) {
		this.bqrTipoProcedimientoByTipoProcedimientoId = bqrTipoProcedimientoByTipoProcedimientoId;
	}

	@Column(name = "CIE_9_ID", nullable = false)
	public Integer getCie9Id() {
		return cie9Id;
	}

	public void setCie9Id(Integer cie9Id) {
		this.cie9Id = cie9Id;
	}

	@Column(name = "TIPO_PROCEDIMIENTO_ID", nullable = false)
	public Integer getTipoProcedimientoId() {
		return tipoProcedimientoId;
	}

	public void setTipoProcedimientoId(Integer tipoProcedimientoId) {
		this.tipoProcedimientoId = tipoProcedimientoId;
	}
}
