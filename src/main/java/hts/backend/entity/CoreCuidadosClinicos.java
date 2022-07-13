package hts.backend.entity;

import hts.backend.entity.CatCuidadosClinicosTipo;
import hts.backend.entity.AdmHospital;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "core_cuidados_clinicos")
public class CoreCuidadosClinicos implements Serializable{
	private Integer cuidadoClinicoId;
	private String nombre;
	private String cve;
	private String descripcion;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Integer estatus;
	private Integer valorDefault;
	private CatCuidadosClinicosTipo catCuidadosClinicosTipoByCuidadoClinicoId;
	private Set<CorePerfilCuidadosDetalle> corePerfilCuidadosDetallesByCuidadosClinicosTipoId= new HashSet<>(0);
	private AdmHospital admHospitalByHospitalId;

	@ManyToOne @JoinColumn(name = "HOSPITAL_ID", referencedColumnName = "HOSPITAL_ID") public AdmHospital getAdmHospitalByHospitalId() {
		return admHospitalByHospitalId;
	}

	public void setAdmHospitalByHospitalId(AdmHospital admHospitalByHospitalId) {
		this.admHospitalByHospitalId = admHospitalByHospitalId;
	}

	@OneToMany(mappedBy = "cuidadoClinicoId") public Set<CorePerfilCuidadosDetalle> getCorePerfilCuidadosDetallesByCuidadosClinicosTipoId() {
		return corePerfilCuidadosDetallesByCuidadosClinicosTipoId;
	}

	public void setCorePerfilCuidadosDetallesByCuidadosClinicosTipoId(Set<CorePerfilCuidadosDetalle> corePerfilCuidadosDetallesByCuidadosClinicosTipoId) {
		this.corePerfilCuidadosDetallesByCuidadosClinicosTipoId = corePerfilCuidadosDetallesByCuidadosClinicosTipoId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUIDADO_CLINICO_ID", nullable = false, precision = 0) public Integer getCuidadoClinicoId() {
		return cuidadoClinicoId;
	}

	public void setCuidadoClinicoId(Integer cuidadoClinicoId) {
		this.cuidadoClinicoId = cuidadoClinicoId;
	}

	@Basic @Column(name = "NOMBRE", nullable = false, length = 50) public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Basic @Column(name = "CVE", nullable = false, length = 20) public String getCve() {
		return cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	@Basic @Column(name = "DESCRIPCION", nullable = true, length = 50) public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	@Basic @Column(name = "ESTATUS", nullable = false, precision = 0) public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@Basic @Column(name = "VALOR_DEFAULT", nullable = false, precision = 0) public Integer getValorDefault() {
		return valorDefault;
	}

	public void setValorDefault(Integer valorDefault) {
		this.valorDefault = valorDefault;
	}

	@ManyToOne @JoinColumn(name = "CUIDADO_CLINICO_TIPO_ID", referencedColumnName = "CUIDADOS_CLINICOS_TIPO_ID", nullable = false) public CatCuidadosClinicosTipo getCatCuidadosClinicosTipoByCuidadoClinicoId() {
		return catCuidadosClinicosTipoByCuidadoClinicoId;
	}

	public void setCatCuidadosClinicosTipoByCuidadoClinicoId(CatCuidadosClinicosTipo catCuidadosClinicosTipoByCuidadoClinicoId) {
		this.catCuidadosClinicosTipoByCuidadoClinicoId = catCuidadosClinicosTipoByCuidadoClinicoId;
	}
}
