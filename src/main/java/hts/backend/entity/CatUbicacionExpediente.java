package hts.backend.entity;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SASA Desarrollo on 31/05/2017.
 */
@Entity
@Table(name = "cat_ubicacion_expediente")
public class CatUbicacionExpediente implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer ubicacionExpedienteId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer estatus;
	private Date fechaResgistro;
	private String usuarioRegistro;
	private CatIdiomaApp catIdiomaApp;
	private Set<PacExpediente> pacExpediente = new HashSet<PacExpediente>(0);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UBICACION_EXPEDIENTE_ID") public Integer getUbicacionExpedienteId() {
		return ubicacionExpedienteId;
	}

	public void setUbicacionExpedienteId(Integer ubicacionExpedienteId) {
		this.ubicacionExpedienteId = ubicacionExpedienteId;
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

	@Basic @Column(name = "VALOR_DEFAULT") public Integer getValorDefault() {
		return valorDefault;
	}

	public void setValorDefault(Integer valorDefault) {
		this.valorDefault = valorDefault;
	}

	@Basic @Column(name = "ESTATUS") public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@Basic @Column(name = "FECHA_REGISTRO") public Date getFechaResgistro() {
		return fechaResgistro;
	}

	public void setFechaResgistro(Date fechaResgistro) {
		this.fechaResgistro = fechaResgistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO") public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}




	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDIOMA_APP_ID")
	public CatIdiomaApp getCatIdiomaApp() {
		return catIdiomaApp;
	}

	public void setCatIdiomaApp(CatIdiomaApp catIdiomaApp) {
		this.catIdiomaApp = catIdiomaApp;
	}



	@OneToMany(mappedBy = "catUbicacionExpediente")

	public Set<PacExpediente> getPacExpediente() {
		return pacExpediente;
	}

	public void setPacExpediente(Set<PacExpediente> pacExpediente) {
		this.pacExpediente = pacExpediente;
	}
}
