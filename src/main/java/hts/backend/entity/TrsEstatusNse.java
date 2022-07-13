package hts.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Francisco Toscano on 04/07/2017.
 */
@Entity
@Table(name = "trs_estatus_nse")
public class TrsEstatusNse {
//	@JsonBackReference(value="condTrsCondicionesEconomicasToCatEstatusNse")
	@JsonManagedReference(value="condTrsCondicionesEconomicasToCatEstatusNse")
	private Set<TrsCondicionesEconomicas> trsCondicionesEconomicas = new HashSet<TrsCondicionesEconomicas>(0);
	private Integer estatusNseId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;
	@JsonIgnore
	private CatIdiomaApp catIdiomaApp;
	@JsonIgnore
	private Set<TrsNseUnicaOcasion> trsNseUnicaOcasion = new HashSet<TrsNseUnicaOcasion>(0);




	@OneToMany(mappedBy = "estatusAsignacion")
	public Set<TrsCondicionesEconomicas> getTrsCondicionesEconomicas() {
		return trsCondicionesEconomicas;
	}

	public void setTrsCondicionesEconomicas(Set<TrsCondicionesEconomicas> trsCondicionesEconomicas) {
		this.trsCondicionesEconomicas = trsCondicionesEconomicas;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ESTATUS_NSE_ID") public Integer getEstatusNseId() {
		return estatusNseId;
	}

	public void setEstatusNseId(Integer estatusNseId) {
		this.estatusNseId = estatusNseId;
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

	@Basic @Column(name = "USUARIO_REGISTRO") public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@ManyToOne @JoinColumn(name = "IDIOMA_APP_ID")
	public CatIdiomaApp getCatIdiomaApp() {
		return catIdiomaApp;
	}

	public void setCatIdiomaApp(CatIdiomaApp catIdiomaApp) {
		this.catIdiomaApp = catIdiomaApp;
	}


	@OneToMany(mappedBy = "estatusAsignacion")
	public Set<TrsNseUnicaOcasion> getTrsNseUnicaOcasion() {
		return trsNseUnicaOcasion;
	}

	public void setTrsNseUnicaOcasion(Set<TrsNseUnicaOcasion> trsNseUnicaOcasion) {
		this.trsNseUnicaOcasion = trsNseUnicaOcasion;
	}


	@Override public String toString() {

		return "OBJECT::"+this.hashCode()
				+" estatusNseId::"+this.estatusNseId
				+" cve::"+this.cve
				+" nombre::"+this.nombre
				+" descripcion::"+this.descripcion
				+" valorDefault::"+this.valorDefault
				+" estatus::"+this.estatus
				+" fechaRegistro::"+this.fechaRegistro
				+" usuarioRegistro::"+this.usuarioRegistro;
	}


}
