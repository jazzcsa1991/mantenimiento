package hts.backend.entity;

import javax.persistence.*;

import java.util.Set;
import java.util.Date;

/**
 * Created by SASA Desarrollo on 13/11/2017.
 */
@Entity
@Table(name = "bqr_tipo_procedimiento")
public class BqrTipoProcedimiento implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer tipoProcedimientoId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private AdmHospital admHospital;
	private Integer hospitalId;
	private Set<BqrTipoProcedimientoCie9> bqrTipoProcedimientoCie9sByTipoProcedimientoId;
	private Set<BqrKitCirugia> bqrKitCirugiasByTipoProcedimientoId;

	@OneToMany(mappedBy = "bqrTipoProcedimientoByTipoProcedimientoId") public Set<BqrKitCirugia> getBqrKitCirugiasByTipoProcedimientoId() {
		return bqrKitCirugiasByTipoProcedimientoId;
	}

	public void setBqrKitCirugiasByTipoProcedimientoId(Set<BqrKitCirugia> bqrKitCirugiasByTipoProcedimientoId) {
		this.bqrKitCirugiasByTipoProcedimientoId = bqrKitCirugiasByTipoProcedimientoId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TIPO_PROCEDIMIENTO_ID") public Integer getTipoProcedimientoId() {
		return tipoProcedimientoId;
	}

	public void setTipoProcedimientoId(Integer tipoProcedimientoId) {
		this.tipoProcedimientoId = tipoProcedimientoId;
	}

	@Basic @Column(name = "CVE") public String getCve() {
		return cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	@Basic @Column(name = "NOMBRE") public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Basic @Column(name = "DESCRIPCION") public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Basic @Column(name = "ESTATUS") public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
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

	@ManyToOne
	@JoinColumn(name = "HOSPITAL_ID", referencedColumnName = "HOSPITAL_ID", updatable = false, insertable = false)

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

	@OneToMany(mappedBy = "bqrTipoProcedimientoByTipoProcedimientoId") public Set<BqrTipoProcedimientoCie9> getBqrTipoProcedimientoCie9sByTipoProcedimientoId() {
		return bqrTipoProcedimientoCie9sByTipoProcedimientoId;
	}

	public void setBqrTipoProcedimientoCie9sByTipoProcedimientoId(Set<BqrTipoProcedimientoCie9> bqrTipoProcedimientoCie9sByTipoProcedimientoId) {
		this.bqrTipoProcedimientoCie9sByTipoProcedimientoId = bqrTipoProcedimientoCie9sByTipoProcedimientoId;
	}
}
