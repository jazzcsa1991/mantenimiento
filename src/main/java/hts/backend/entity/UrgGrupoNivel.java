package hts.backend.entity;



import hts.backend.entity.AdmHospital;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "urg_grupo_nivel")
public class UrgGrupoNivel implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer grupoId;
	private String nombre;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;

	private AdmHospital hospital;
	private Integer hospitalId;

	private Set<BitacoraTriage> bitacoraTriages;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GRUPO_ID", nullable = false, unique = true)
	public Integer getGrupoId() {
		return grupoId;
	}

	public void setGrupoId(Integer grupoId) {
		this.grupoId = grupoId;
	}


	@Basic
	@Column(name = "NOMBRE", nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Basic
	@Column(name = "ESTATUS", nullable = false)
	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
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
	@Column(name = "USUARIO_REGISTRO", nullable = false)
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}


	@Basic
	@Column(name = "HOSPITAL_ID", nullable = false)
	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}


	@ManyToOne
	@JoinColumn(name = "HOSPITAL_ID", referencedColumnName = "HOSPITAL_ID", insertable = false, updatable = false)
	public AdmHospital getHospital() {
		return hospital;
	}

	public void setHospital(AdmHospital admHospitalByHospitalId) {
		this.hospital = admHospitalByHospitalId;
	}

	@OneToMany(mappedBy = "urgGrupoNivel")
	public Set<BitacoraTriage> getBitacoraTriages() {
		return bitacoraTriages;
	}

	public void setBitacoraTriages(Set<BitacoraTriage> bitacoraTriages) {
		this.bitacoraTriages = bitacoraTriages;
	}
}
