package hts.backend.entity;


import hts.backend.entity.AdmHospital;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;


@Entity
@Table(name = "core_perfiles_cuidados")
public class CorePerfilesCuidados implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer perfilId;
	private String perfilNombre;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Date fechaModificacion;
	private String usuarioModificacion;
	private AdmHospital admHospitalByHospitalId;
	private Set<CorePerfilCuidadosDetalle> corePerfilCuidadosDetallesByPerfilId = new HashSet<>(0);


	@OneToMany(mappedBy = "corePerfilesCuidadosByPerfilId") public Set<CorePerfilCuidadosDetalle> getCorePerfilCuidadosDetallesByPerfilId() {
		return corePerfilCuidadosDetallesByPerfilId;
	}

	public void setCorePerfilCuidadosDetallesByPerfilId(Set<CorePerfilCuidadosDetalle> corePerfilCuidadosDetallesByPerfilId) {
		this.corePerfilCuidadosDetallesByPerfilId = corePerfilCuidadosDetallesByPerfilId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PERFIL_ID", nullable = false, precision = 0) public Integer getPerfilId() {
		return perfilId;
	}

	public void setPerfilId(Integer perfilId) {
		this.perfilId = perfilId;
	}

	@Basic @Column(name = "PERFIL_NOMBRE", nullable = false, length = 50) public String getPerfilNombre() {
		return perfilNombre;
	}

	public void setPerfilNombre(String perfilNombre) {
		this.perfilNombre = perfilNombre;
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

	@Basic @Column(name = "FECHA_MODIFICACION", nullable = false) public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	@Basic @Column(name = "USUARIO_MODIFICACION", nullable = false, length = 50) public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}




	@ManyToOne @JoinColumn(name = "HOSPITAL_ID", referencedColumnName = "HOSPITAL_ID") public AdmHospital getAdmHospitalByHospitalId() {
		return admHospitalByHospitalId;
	}

	public void setAdmHospitalByHospitalId(AdmHospital admHospitalByHospitalId) {
		this.admHospitalByHospitalId = admHospitalByHospitalId;
	}
}
