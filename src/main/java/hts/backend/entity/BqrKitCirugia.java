package hts.backend.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "bqr_kit_cirugia")
public class BqrKitCirugia implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer kitCirugiaId;
	private String nombreKitCirugia;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Integer estatus;
	private Integer tipoProcedimientoId;
	private BqrTipoProcedimiento bqrTipoProcedimientoByTipoProcedimientoId;
	private AdmHospital admHospital;
	private Integer hospitalId;
	private Set<BqrKitPrestacion> bqrKitPrestacion;



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "KIT_CIRUGIA_ID", nullable = false, precision = 0)
	public Integer getKitCirugiaId() {
		return kitCirugiaId;
	}

	public void setKitCirugiaId(Integer kitCirugiaId) {
		this.kitCirugiaId = kitCirugiaId;
	}






	@Basic @Column(name = "NOMBRE_KIT_CIRUGIA", nullable = false, length = 50)
	public String getNombreKitCirugia() {
		return nombreKitCirugia;
	}

	public void setNombreKitCirugia(String nombreKitCirugia) {
		this.nombreKitCirugia = nombreKitCirugia;
	}




	@Basic @Column(name = "FECHA_REGISTRO", nullable = false) public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO", nullable = false, length = 50) public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Basic @Column(name = "ESTATUS", nullable = false, precision = 0) public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}


	@ManyToOne @JoinColumn(name = "TIPO_PROCEDIMIENTO_ID", updatable = false, insertable = false) public BqrTipoProcedimiento getBqrTipoProcedimientoByTipoProcedimientoId() {
		return bqrTipoProcedimientoByTipoProcedimientoId;
	}

	public void setBqrTipoProcedimientoByTipoProcedimientoId(BqrTipoProcedimiento bqrTipoProcedimientoByTipoProcedimientoId) {
		this.bqrTipoProcedimientoByTipoProcedimientoId = bqrTipoProcedimientoByTipoProcedimientoId;
	}

	@Column(name = "TIPO_PROCEDIMIENTO_ID", nullable = false)
	public Integer getTipoProcedimientoId() {
		return tipoProcedimientoId;
	}

	public void setTipoProcedimientoId(Integer tipoProcedimientoId) {
		this.tipoProcedimientoId = tipoProcedimientoId;
	}

	@ManyToOne @JoinColumn(name = "HOSPITAL_ID", updatable = false, insertable = false)
	public AdmHospital getAdmHospital() {
		return admHospital;
	}

	public void setAdmHospital(AdmHospital admHospital) {
		this.admHospital = admHospital;
	}
	@Column(name = "HOSPITAL_ID", nullable = false)
	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	@OneToMany(mappedBy = "bqrKitCirugia")
	public Set<BqrKitPrestacion> getBqrKitPrestacion() {
		return bqrKitPrestacion;
	}

	public void setBqrKitPrestacion(Set<BqrKitPrestacion> bqrKitPrestacion) {
		this.bqrKitPrestacion = bqrKitPrestacion;
	}

}
