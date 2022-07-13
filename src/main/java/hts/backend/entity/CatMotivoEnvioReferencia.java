package hts.backend.entity;

import hts.backend.entity.CoreContrarreferencia;
import hts.backend.entity.CoreReferencia;
import hts.backend.entity.CoreReferenciasExternas;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SASA Desarrollo on 15/06/2017.
 */
@Entity
@Table(name = "cat_motivo_envio_referencia")
public class CatMotivoEnvioReferencia implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer motivoEnvioReferenciaId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private CatIdiomaApp catIdiomaApp;

	private Set<CoreReferencia> coreReferencias = new HashSet<CoreReferencia>(0);
	private Set<CoreReferenciasExternas> coreReferenciasExternas = new HashSet<CoreReferenciasExternas>(0);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOTIVO_ENVIO_REFERENCIA_ID") public Integer getMotivoEnvioReferenciaId() {
		return motivoEnvioReferenciaId;
	}

	public void setMotivoEnvioReferenciaId(Integer motivoEnvioReferenciaId) {
		this.motivoEnvioReferenciaId = motivoEnvioReferenciaId;
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


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDIOMA_APP_ID")

	public CatIdiomaApp getCatIdiomaApp() {
		return catIdiomaApp;
	}

	public void setCatIdiomaApp(CatIdiomaApp catIdiomaApp) {
		this.catIdiomaApp = catIdiomaApp;
	}

	@OneToMany(mappedBy = "catMotivoEnvioReferencia")

	public Set<CoreReferencia> getCoreReferencias() {
		return coreReferencias;
	}

	public void setCoreReferencias(Set<CoreReferencia> coreReferencias) {
		this.coreReferencias = coreReferencias;
	}

	@OneToMany(mappedBy = "catMotivoEnvioReferencia")
	public Set<CoreReferenciasExternas> getCoreReferenciasExternas() {
		return coreReferenciasExternas;
	}

	public void setCoreReferenciasExternas(Set<CoreReferenciasExternas> coreReferenciasExternas) {
		this.coreReferenciasExternas = coreReferenciasExternas;
	}
}
