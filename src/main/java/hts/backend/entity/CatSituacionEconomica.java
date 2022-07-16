package hts.backend.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SASA Desarrollo on 18/05/2017.
 */
@Entity
@Table(name = "cat_situacion_economica")
public class CatSituacionEconomica implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Integer situacionEconomicaId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer estatus;
	private Time fechaRegistro;
	private String usuarioRegistro;
	private CatIdiomaApp catIdiomaApp;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SITUACION_ECONOMICA_ID") public Integer getSituacionEconomicaId() {
		return situacionEconomicaId;
	}

	public void setSituacionEconomicaId(Integer situacionEconomicaId) {
		this.situacionEconomicaId = situacionEconomicaId;
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

	@Basic @Column(name = "FECHA_REGISTRO") public Time getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Time fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO") public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}



	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDIOMA_APP_ID", referencedColumnName = "IDIOMA_APP_ID")
	public CatIdiomaApp getCatIdiomaApp() {
		return catIdiomaApp;
	}

	public void setCatIdiomaApp(CatIdiomaApp catIdiomaApp) {
		this.catIdiomaApp = catIdiomaApp;
	}
}
