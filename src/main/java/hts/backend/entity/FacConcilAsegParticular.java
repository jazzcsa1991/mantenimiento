package hts.backend.entity;

import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "fac_concil_aseg_particular")
public class FacConcilAsegParticular implements java.io.Serializable {
	private Integer concilAsegParticularId;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Integer abonoAsegParticularId;
	private Integer cargoAsegParticularId;
	private FacAbonosAsegParticular abonoAsegParticular;
	private FacCargosAsegParticular cargoAsegParticular;
//	private FacCargosAsegParticular facConcilAsegParticularsByCargoAsegParticularId;
//	private FacAbonosAsegParticular facConcilAsegParticularsByAbonoAsegParticularId;
	private BigDecimal importe;

	// Constructor estático para conciliación de particulares
	public static FacConcilAsegParticular Conciliacion(int abonoAsegParticularId, int cargoAsegParticularId, BigDecimal importe) {
		FacConcilAsegParticular obj = new FacConcilAsegParticular();

		obj.setAbonoAsegParticularId(abonoAsegParticularId);
		obj.setCargoAsegParticularId(cargoAsegParticularId);
		obj.setImporte(importe);
		obj.setFechaRegistro(new Date());
		obj.setUsuarioRegistro(SecurityContextHolder.getContext().getAuthentication().getName());

		return obj;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONCIL_ASEG_PARTICULAR_ID", nullable = false)
	public Integer getConcilAsegParticularId() {
		return concilAsegParticularId;
	}

	public void setConcilAsegParticularId(Integer concilAsegParticularId) {
		this.concilAsegParticularId = concilAsegParticularId;
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


//	@ManyToOne
//	@JoinColumn(name = "CARGO_ASEG_PARTICULAR_ID", referencedColumnName = "CARGO_ASEG_PARTICULAR_ID", nullable = false)
//	public FacCargosAsegParticular getFacCargosAsegParticularByCargoAsegParticularId() {
//		return facConcilAsegParticularsByCargoAsegParticularId;
//	}
//
//	public void setFacCargosAsegParticularByCargoAsegParticularId(FacCargosAsegParticular facCargosAsegParticularByCargoAsegParticularId) {
//		this.facConcilAsegParticularsByCargoAsegParticularId = facCargosAsegParticularByCargoAsegParticularId;
//	}

	@Basic
	@Column(name = "IMPORTE", nullable = false)
	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}


	@ManyToOne
	@JoinColumn(name = "ABONO_ASEG_PARTICULAR_ID", referencedColumnName = "ABONO_ASEG_PARTICULAR_ID", updatable = false, insertable = false)
	public FacAbonosAsegParticular getAbonoAsegParticular() {
		return abonoAsegParticular;
	}

	public void setAbonoAsegParticular(FacAbonosAsegParticular facAbonosAsegParticularByAbonoAsegParticularId) {
		this.abonoAsegParticular = facAbonosAsegParticularByAbonoAsegParticularId;
	}


	@ManyToOne
	@JoinColumn(name = "CARGO_ASEG_PARTICULAR_ID", referencedColumnName = "CARGO_ASEG_PARTICULAR_ID", updatable = false, insertable = false)
	public FacCargosAsegParticular getCargoAsegParticular() {
		return cargoAsegParticular;
	}

	public void setCargoAsegParticular(FacCargosAsegParticular facCargosAsegParticularByCargoAsegParticularId) {
		this.cargoAsegParticular = facCargosAsegParticularByCargoAsegParticularId;
	}


	@Column(name = "ABONO_ASEG_PARTICULAR_ID", nullable = false)
	public Integer getAbonoAsegParticularId() {
		return abonoAsegParticularId;
	}

	public void setAbonoAsegParticularId(Integer abonoAsegParticularId) {
		this.abonoAsegParticularId = abonoAsegParticularId;
	}


	@Column(name = "CARGO_ASEG_PARTICULAR_ID", nullable = false)
	public Integer getCargoAsegParticularId() {
		return cargoAsegParticularId;
	}

	public void setCargoAsegParticularId(Integer cargoAsegParticularId) {
		this.cargoAsegParticularId = cargoAsegParticularId;
	}
}
