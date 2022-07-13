package hts.backend.entity;


import hts.backend.entity.CatMotivoAnulacionPrest;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Lenovo2 on 03/07/2017.
 */
@Entity
@Table(name = "fac_bit_concil_aseg_comercial")
public class FacBitConcilAsegComercial implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Integer bitConcilAsegComercialId;
	private Date fechaCancela;
	private Integer concilAsegComercialId;
	private Date fechaRegistro;
	private Float importe;
	private String usuarioCancela;
	private String usuarioRegistro;
	private FacCatMotivoAnulacionAbono catMotivoAnulacionPrestByMotivoCancelacionConcilId;
	private FacAbonosAsegComercial facAbonosAsegComercialByAbonoAsegComercialId;
	private FacCargosAsegComercial facCargosAsegComercialByCargoAsegComercialId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BIT_CONCIL_ASEG_COMERCIAL_ID", nullable = false, precision = 0) public Integer getBitConcilAsegComercialId() {
		return bitConcilAsegComercialId;
	}

	public void setBitConcilAsegComercialId(Integer bitConcilAsegComercialId) {
		this.bitConcilAsegComercialId = bitConcilAsegComercialId;
	}

	@Basic @Column(name = "FECHA_CANCELA", nullable = false) public Date getFechaCancela() {
		return fechaCancela;
	}

	public void setFechaCancela(Date fechaCancela) {
		this.fechaCancela = fechaCancela;
	}

	@Basic @Column(name = "CONCIL_ASEG_COMERCIAL_ID", nullable = false, precision = 0) public Integer getConcilAsegComercialId() {
		return concilAsegComercialId;
	}

	public void setConcilAsegComercialId(Integer concilAsegComercialId) {
		this.concilAsegComercialId = concilAsegComercialId;
	}

	@Basic @Column(name = "FECHA_REGISTRO", nullable = false) public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "IMPORTE", nullable = false, precision = 0) public Float getImporte() {
		return importe;
	}

	public void setImporte(Float importe) {
		this.importe = importe;
	}


	@ManyToOne @JoinColumn(name = "MOTIVO_CANCELACION_CONCIL_ID", referencedColumnName = "MOTIVO_ANULACION_ABONO_ID", nullable = false) public FacCatMotivoAnulacionAbono getCatMotivoAnulacionPrestByMotivoCancelacionConcilId() {
		return catMotivoAnulacionPrestByMotivoCancelacionConcilId;
	}

	public void setCatMotivoAnulacionPrestByMotivoCancelacionConcilId(FacCatMotivoAnulacionAbono catMotivoAnulacionPrestByMotivoCancelacionConcilId) {
		this.catMotivoAnulacionPrestByMotivoCancelacionConcilId = catMotivoAnulacionPrestByMotivoCancelacionConcilId;
	}

	@ManyToOne @JoinColumn(name = "ABONO_ASEG_COMERCIAL_ID", referencedColumnName = "ABONO_ASEG_COMERCIAL_ID", nullable = false) public FacAbonosAsegComercial getFacAbonosAsegComercialByAbonoAsegComercialId() {
		return facAbonosAsegComercialByAbonoAsegComercialId;
	}

	public void setFacAbonosAsegComercialByAbonoAsegComercialId(FacAbonosAsegComercial facAbonosAsegComercialByAbonoAsegComercialId) {
		this.facAbonosAsegComercialByAbonoAsegComercialId = facAbonosAsegComercialByAbonoAsegComercialId;
	}

	@ManyToOne @JoinColumn(name = "CARGO_ASEG_COMERCIAL_ID", referencedColumnName = "CARGO_ASEG_COMERCIAL_ID", nullable = false) public FacCargosAsegComercial getFacCargosAsegComercialByCargoAsegComercialId() {
		return facCargosAsegComercialByCargoAsegComercialId;
	}

	public void setFacCargosAsegComercialByCargoAsegComercialId(FacCargosAsegComercial facCargosAsegComercialByCargoAsegComercialId) {
		this.facCargosAsegComercialByCargoAsegComercialId = facCargosAsegComercialByCargoAsegComercialId;
	}

	@Basic @Column(name = "USUARIO_CANCELA", nullable = false, length = 20)
	public String getUsuarioCancela() {
		return usuarioCancela;
	}

	public void setUsuarioCancela(String usuarioCancela) {
		this.usuarioCancela = usuarioCancela;
	}

	@Basic @Column(name = "USUARIO_REGISTRO", nullable = false, length = 20)
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}
}
