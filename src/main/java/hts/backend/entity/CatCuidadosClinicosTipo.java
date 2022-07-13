package hts.backend.entity;


import hts.backend.entity.CoreCuidadosClinicos;

import hts.backend.entity.CorePerfilCuidadosDetalle;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;


@Entity
@Table(name = "cat_cuidados_clinicos_tipo")
public class CatCuidadosClinicosTipo implements java.io.Serializable  {
	private static final long serialVersionUID = 1L;
	private Integer cuidadosClinicosId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private CatIdiomaApp catIdiomaAppByIdiomaAppId;
	private Set<CorePerfilCuidadosDetalle> corePerfilCuidadosDetallesByCuidadosClinicosTipoId= new HashSet<>(0);
	private CoreCuidadosClinicos coreCuidadosClinicosByCuidadosClinicosTipoId;



	@Id
	@Column(name = "CUIDADOS_CLINICOS_TIPO_ID", nullable = false, precision = 0) public Integer getCuidadosClinicosId() {
		return cuidadosClinicosId;
	}

	public void setCuidadosClinicosId(Integer cuidadosClinicosId) {
		this.cuidadosClinicosId = cuidadosClinicosId;
	}

	@Basic @Column(name = "CVE", nullable = false, length = 50) public String getCve() {
		return cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	@Basic @Column(name = "NOMBRE", nullable = false, length = 50) public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Basic @Column(name = "DESCRIPCION", nullable = false, length = 20) public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Basic @Column(name = "VALOR_DEFAULT", nullable = false, precision = 0) public Integer getValorDefault() {
		return valorDefault;
	}

	public void setValorDefault(Integer valorDefault) {
		this.valorDefault = valorDefault;
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

	@Basic @Column(name = "USUARIO_REGISTRO", nullable = false, length = 50) public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}




	@ManyToOne @JoinColumn(name = "IDIOMA_APP_ID", referencedColumnName = "IDIOMA_APP_ID", nullable = false) public CatIdiomaApp getCatIdiomaAppByIdiomaAppId() {
		return catIdiomaAppByIdiomaAppId;
	}

	public void setCatIdiomaAppByIdiomaAppId(CatIdiomaApp catIdiomaAppByIdiomaAppId) {
		this.catIdiomaAppByIdiomaAppId = catIdiomaAppByIdiomaAppId;
	}


}
