package hts.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "fac_concil_aseg_comercial")
public class FacConcilAsegComercial implements Serializable {
	private Integer concilAsegComercialId;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Integer abonoAsegComercialId;
	private Integer cargoAsegComercialId;
	private FacAbonosAsegComercial abonoAsegComercial;
	private FacCargosAsegComercial cargoAsegComercial;
	private BigDecimal importe;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONCIL_ASEG_COMERCIAL_ID", nullable = false) public Integer getConcilAsegComercialId() {
		return concilAsegComercialId;
	}

	public void setConcilAsegComercialId(Integer concilAsegComercialId) {
		this.concilAsegComercialId = concilAsegComercialId;
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
	@JoinColumn(name = "ABONO_ASEG_COMERCIAL_ID", referencedColumnName = "ABONO_ASEG_COMERCIAL_ID", insertable = false, updatable = false)
	public FacAbonosAsegComercial getAbonoAsegComercial() {
		return abonoAsegComercial;
	}

	public void setAbonoAsegComercial(FacAbonosAsegComercial facAbonosAsegComercialByAbonoAsegComercialId) {
		this.abonoAsegComercial = facAbonosAsegComercialByAbonoAsegComercialId;
	}


	@ManyToOne
	@JoinColumn(name = "CARGO_ASEG_COMERCIAL_ID", referencedColumnName = "CARGO_ASEG_COMERCIAL_ID", insertable = false, updatable = false)
	public FacCargosAsegComercial getCargoAsegComercial() {
		return cargoAsegComercial;
	}

	public void setCargoAsegComercial(FacCargosAsegComercial facCargosAsegComercialByCargoAsegComercialId) {
		this.cargoAsegComercial = facCargosAsegComercialByCargoAsegComercialId;
	}


	@Basic
	@Column(name = "IMPORTE", nullable = false)
	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}


	@Column(name = "ABONO_ASEG_COMERCIAL_ID", nullable = false)
	public Integer getAbonoAsegComercialId() {
		return abonoAsegComercialId;
	}

	public void setAbonoAsegComercialId(Integer abonoAsegComercialId) {
		this.abonoAsegComercialId = abonoAsegComercialId;
	}


	@Column(name = "CARGO_ASEG_COMERCIAL_ID", nullable = false)
	public Integer getCargoAsegComercialId() {
		return cargoAsegComercialId;
	}

	public void setCargoAsegComercialId(Integer cargoAsegComercialId) {
		this.cargoAsegComercialId = cargoAsegComercialId;
	}
}
