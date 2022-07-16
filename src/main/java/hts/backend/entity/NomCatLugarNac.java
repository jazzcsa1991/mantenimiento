package hts.backend.entity;

import hts.backend.entity.HspDatosParto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by SASA Desarrollo on 18/08/2017.
 */
@Entity
@Table(name = "nom_cat_lugar_nac")
public class NomCatLugarNac implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer lugarNacId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private CatIdiomaApp catIdiomaApp;
	private Collection<HspDatosParto> hspDatosPartosByLugarNacId;

	@Id @Column(name = "LUGAR_NAC_ID") public Integer getLugarNacId() {
		return lugarNacId;
	}

	public void setLugarNacId(Integer lugarNacId) {
		this.lugarNacId = lugarNacId;
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

	@OneToMany(mappedBy = "nomCatLugarNac") public Collection<HspDatosParto> getHspDatosPartosByLugarNacId() {
		return hspDatosPartosByLugarNacId;
	}

	public void setHspDatosPartosByLugarNacId(Collection<HspDatosParto> hspDatosPartosByLugarNacId) {
		this.hspDatosPartosByLugarNacId = hspDatosPartosByLugarNacId;
	}
}
