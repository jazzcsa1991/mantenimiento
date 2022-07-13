package hts.backend.entity;

import hts.backend.entity.CoreTipoCamaPrestacion;
import hts.backend.entity.NomPrductoPrestacion;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "cat_tipo_cama")
public class CatTipoCama implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer tipoCamaId;
	private String nombre;
	private String descripcion;
	private Integer indicadefault;
	private Integer estatus;
	private Date fecharegistro;
	private String nousuario;
	private String clave;
	private Set<AdmCama> admCama = new HashSet<AdmCama>(0);

	public CatTipoCama() {


	}

	public CatTipoCama(Integer tipoCamaId) {
		this.tipoCamaId = tipoCamaId;
	}


	public CatTipoCama(Integer tipoCamaId, String nombre, String descripcion, Integer indicadefault, Integer estatus, Date fecharegistro, String nousuario, String clave, Set<AdmCama> admCama) {

		this.tipoCamaId = tipoCamaId;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.indicadefault = indicadefault;
		this.estatus = estatus;
		this.fecharegistro = fecharegistro;
		this.nousuario = nousuario;
		this.clave = clave;
		this.admCama = admCama;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TIPO_CAMA_ID", unique = true, nullable = false)
	public Integer getTipoCamaId() {
		return this.tipoCamaId;
	}


	public void setTipoCamaId(Integer tipoCamaId) {
		this.tipoCamaId = tipoCamaId;
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

	@Column(name = "CVE")

	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catTipoCama")
	public Set<AdmCama> getAdmCama() {
		return admCama;
	}


	public void setAdmCama(Set<AdmCama> admCama) {
		this.admCama = admCama;
	}

}
