package hts.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "nom_cat_estatus_cama")
public class CatEstatusCama implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer estatusCamaid;
	private String clave;
	private String nombre;
	private String descripcion;
	private Integer indicadefault;
	private Integer estatus;
	private Date fecharegistro;
	private String nousuario;
	private Set<AdmCama> admCama = new HashSet<AdmCama>(0);


	public CatEstatusCama() {

	}

	public CatEstatusCama(Integer estatusCamaid) {
		this.estatusCamaid = estatusCamaid;
	}


	public CatEstatusCama(Integer estatusCamaid, String clave, String nombre, String descripcion, Integer indicadefault, Integer estatus, Date fecharegistro, String nousuario, Set<AdmCama> admCama) {
		this.estatusCamaid = estatusCamaid;
		this.clave = clave;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.indicadefault = indicadefault;
		this.estatus = estatus;
		this.fecharegistro = fecharegistro;
		this.nousuario = nousuario;
		this.admCama = admCama;
	}

	@Id

	@Column(name = "ESTATUS_CAMA_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getEstatusCamaid() {
		return estatusCamaid;
	}


	public void setEstatusCamaid(Integer estatusCamaid) {
		this.estatusCamaid = estatusCamaid;
	}

	@Column(name = "CVE")

	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}

	@Column(name = "NOMBRE")
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "DESCRIPCION")
	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "VALOR_DEFAULT")
	public Integer getIndicadefault() {
		return indicadefault;
	}


	public void setIndicadefault(Integer indicadefault) {
		this.indicadefault = indicadefault;
	}

	@Column(name = "ESTATUS")
	public Integer getEstatus() {
		return estatus;
	}


	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", length = 7)
	public Date getFecharegistro() {
		return fecharegistro;
	}


	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	@Column(name = "USUARIO_REGISTRO")
	public String getNousuario() {
		return nousuario;
	}


	public void setNousuario(String nousuario) {
		this.nousuario = nousuario;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catEstatusCama")
	public Set<AdmCama> getAdmCama() {
		return this.admCama;
	}


	public void setAdmCama(Set<AdmCama> admCama) {
		this.admCama = admCama;
	}
}