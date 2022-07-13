package hts.backend.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by SASA Desarrollo on 04/07/2017.
 */
@Entity
@Table(name = "nom_cat_motivo_anulacion_nse")
public class CatMotivoAnulacionNse implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer motivoAnulacionNseId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private CatIdiomaApp catIdiomaApp;
	private Set<TrsAnulacionNse> trsAnulacionNses =new HashSet<TrsAnulacionNse>(0);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOTIVO_ANULACION_NSE_ID") public Integer getMotivoAnulacionNseId() {
		return motivoAnulacionNseId;
	}

	public void setMotivoAnulacionNseId(Integer motivoAnulacionNseId) {
		this.motivoAnulacionNseId = motivoAnulacionNseId;
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


	@ManyToOne @JoinColumn(name = "IDIOMA_APP_ID", referencedColumnName = "IDIOMA_APP_ID", nullable = false)
	public CatIdiomaApp getCatIdiomaApp() {
		return catIdiomaApp;
	}

	public void setCatIdiomaApp(CatIdiomaApp catIdiomaApp) {
		this.catIdiomaApp = catIdiomaApp;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catMotivoAnulacionNse")
	public Set<TrsAnulacionNse> getTrsAnulacionNses() {
		return trsAnulacionNses;
	}

	public void setTrsAnulacionNses(Set<TrsAnulacionNse> trsAnulacionNses) {
		this.trsAnulacionNses = trsAnulacionNses;
	}
}
