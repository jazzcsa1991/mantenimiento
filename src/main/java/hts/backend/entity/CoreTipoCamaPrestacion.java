package hts.backend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "core_tipo_cama_prestacion")
public class CoreTipoCamaPrestacion implements java.io.Serializable  {
	private static final long serialVersionUID = 1L;
	private Integer tipoCamaPrestacionId;
	private Integer tipoCamaId;
	private Integer productoPrestacionId;
	private String usuarioRegistro;
	private Date fechaRegistro;
	private Integer hospitalId;
	private AdmHospital admHospitalByHospitalId;
	private CatTipoCama catTipoCamaByTipoCamaId;
	private NomPrductoPrestacion nomPrductoPrestacionByProductoPrestacionId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TIPO_CAMA_PRESTACION_ID", nullable = false, precision = 0) public Integer getTipoCamaPrestacionId() {
		return tipoCamaPrestacionId;
	}

	public void setTipoCamaPrestacionId(Integer tipoCamaPrestacionId) {
		this.tipoCamaPrestacionId = tipoCamaPrestacionId;
	}

	@Basic @Column(name = "TIPO_CAMA_ID", nullable = true, precision = 0) public Integer getTipoCamaId() {
		return tipoCamaId;
	}

	public void setTipoCamaId(Integer tipoCamaId) {
		this.tipoCamaId = tipoCamaId;
	}

	@Basic @Column(name = "PRODUCTO_PRESTACION_ID", nullable = false, precision = 0) public Integer getProductoPrestacionId() {
		return productoPrestacionId;
	}

	public void setProductoPrestacionId(Integer productoPrestacionId) {
		this.productoPrestacionId = productoPrestacionId;
	}

	@Basic @Column(name = "USUARIO_REGISTRO", nullable = true, length = 20) public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Basic @Column(name = "FECHA_REGISTRO", nullable = false) public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "HOSPITAL_ID", nullable = true, precision = 0) public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}


	@ManyToOne @JoinColumn(name = "TIPO_CAMA_ID", referencedColumnName = "TIPO_CAMA_ID",insertable = false, updatable = false,nullable = false) public CatTipoCama getCatTipoCamaByTipoCamaId() {
		return catTipoCamaByTipoCamaId;
	}

	public void setCatTipoCamaByTipoCamaId(CatTipoCama catTipoCamaByTipoCamaId) {
		this.catTipoCamaByTipoCamaId = catTipoCamaByTipoCamaId;
	}

	@ManyToOne @JoinColumn(name = "PRODUCTO_PRESTACION_ID", referencedColumnName = "PRODUCTO_PRESTACION_ID", nullable = false,insertable = false, updatable = false) public NomPrductoPrestacion getNomPrductoPrestacionByProductoPrestacionId() {
		return nomPrductoPrestacionByProductoPrestacionId;
	}

	public void setNomPrductoPrestacionByProductoPrestacionId(NomPrductoPrestacion nomPrductoPrestacionByProductoPrestacionId) {
		this.nomPrductoPrestacionByProductoPrestacionId = nomPrductoPrestacionByProductoPrestacionId;
	}

	@ManyToOne @JoinColumn(name = "HOSPITAL_ID", referencedColumnName = "HOSPITAL_ID",nullable = false,insertable = false, updatable = false) public AdmHospital getAdmHospitalByHospitalId() {
		return admHospitalByHospitalId;
	}

	public void setAdmHospitalByHospitalId(AdmHospital admHospitalByHospitalId) {
		this.admHospitalByHospitalId = admHospitalByHospitalId;
	}
}
