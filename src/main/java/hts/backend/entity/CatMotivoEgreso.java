package hts.backend.entity;



//import mx.com.sasa.gus.his.mdb.modelo.entidad.CatIdiomaApp;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cat_motivo_egreso")
public class CatMotivoEgreso implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer motivoEgresoId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Integer valorDefault;
	private CatIdiomaApp catIdiomaAppByIdiomaAppId;
	private Set<HspAltaMedica> hspAltaMedicasByMotivoEgresoId= new HashSet<>(0);

	@OneToMany(mappedBy = "catMotivoEgresoByMotivoEgresoId") public Set<HspAltaMedica> getHspAltaMedicasByMotivoEgresoId() {
		return hspAltaMedicasByMotivoEgresoId;
	}

	public void setHspAltaMedicasByMotivoEgresoId(Set<HspAltaMedica> hspAltaMedicasByMotivoEgresoId) {
		this.hspAltaMedicasByMotivoEgresoId = hspAltaMedicasByMotivoEgresoId;
	}





	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOTIVO_EGRESO_ID", nullable = false, precision = 0) public Integer getMotivoEgresoId() {
		return motivoEgresoId;
	}

	public void setMotivoEgresoId(Integer motivoEgresoId) {
		this.motivoEgresoId = motivoEgresoId;
	}

	@Basic @Column(name = "CVE", nullable = false) public String getCve() {
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

	@Basic @Column(name = "DESCRIPCION", nullable = false, length = 50) public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Basic @Column(name = "ESTATUS", nullable = false) public Integer getEstatus() {
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

	@Basic @Column(name = "VALOR_DEFAULT", nullable = true, precision = 0) public Integer getValorDefault() {
		return valorDefault;
	}

	public void setValorDefault(Integer valorDefault) {
		this.valorDefault = valorDefault;
	}


	@ManyToOne @JoinColumn(name = "IDIOMA_APP_ID", referencedColumnName = "IDIOMA_APP_ID", nullable = false) public CatIdiomaApp getCatIdiomaAppByIdiomaAppId() {
		return catIdiomaAppByIdiomaAppId;
	}

	public void setCatIdiomaAppByIdiomaAppId(CatIdiomaApp catIdiomaAppByIdiomaAppId) {
		this.catIdiomaAppByIdiomaAppId = catIdiomaAppByIdiomaAppId;
	}
}
