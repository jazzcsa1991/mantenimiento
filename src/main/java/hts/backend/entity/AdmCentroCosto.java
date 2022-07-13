package hts.backend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "adm_centro_costo")
public class AdmCentroCosto implements java.io.Serializable {
	private Integer centroCostoId;
	private AdmHospital admHospital;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CENTRO_COSTO_ID", nullable = false, precision = 0) public Integer getCentroCostoId() {
		return centroCostoId;
	}

	public AdmCentroCosto (Integer centroCostoId){
		this.centroCostoId = centroCostoId;
	}

	public AdmCentroCosto (){

	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HOSPITAL_ID")
	public AdmHospital getAdmHospital() {
		return this.admHospital;
	}

	public void setAdmHospital(AdmHospital admHospital) {
		this.admHospital = admHospital;
	}


	public void setCentroCostoId(Integer centroCostoId) {
		this.centroCostoId = centroCostoId;
	}

	@Basic @Column(name = "CVE", nullable = false, precision = 0) public String getCve() {
		return cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	@Basic @Column(name = "NOMBRE", nullable = false, length = 100) public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Basic @Column(name = "DESCRIPCION", nullable = false, length = 150) public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Basic @Column(name = "ESTATUS", nullable = false, precision = 0) public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@Basic @Column(name = "FECHA_REGISTRO", nullable = false) public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO", nullable = false, length = 20) public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

}
