package hts.backend.entity;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SASA Desarrollo on 31/05/2017.
 */
@Entity
@Table(name = "nom_cat_estatus_expediente")
public class CatEstatusExpediente implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer estatusExpedienteId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioResgistro;
	private CatIdiomaApp catIdiomaAppByIdiomaAppId;
	private Set<PacExpediente> pacExpediente = new HashSet<PacExpediente>(0);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ESTATUS_EXPEDIENTE_ID") public Integer getEstatusExpedienteId() {
		return estatusExpedienteId;
	}

	public void setEstatusExpedienteId(Integer estatusExpedienteId) {
		this.estatusExpedienteId = estatusExpedienteId;
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

	@Basic @Column(name = "FECHA_REGISTRO") public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO") public String getUsuarioResgistro() {
		return usuarioResgistro;
	}

	public void setUsuarioResgistro(String usuarioResgistro) {
		this.usuarioResgistro = usuarioResgistro;
	}



	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDIOMA_APP_ID")
	public CatIdiomaApp getCatIdiomaAppByIdiomaAppId() {
		return catIdiomaAppByIdiomaAppId;
	}

	public void setCatIdiomaAppByIdiomaAppId(CatIdiomaApp catIdiomaAppByIdiomaAppId) {
		this.catIdiomaAppByIdiomaAppId = catIdiomaAppByIdiomaAppId;
	}

	@OneToMany(mappedBy = "catEstatusExpediente")

	public Set<PacExpediente> getPacExpediente() {
		return pacExpediente;
	}

	public void setPacExpediente(Set<PacExpediente> pacExpediente) {
		this.pacExpediente = pacExpediente;
	}
}
