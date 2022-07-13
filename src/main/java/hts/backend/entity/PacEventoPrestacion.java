package hts.backend.entity;


import hts.backend.entity.NomCatTipoAgenteUbicacion;
import hts.backend.entity.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by SASA Desarrollo on 18/04/2017.
 */
@Entity
@Table(name = "pac_evento_prestacion")
public class PacEventoPrestacion implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer eventoPrestacionId;
	private Integer prestacionDefault;
	private Integer origenPrestacion;
	private Float cantidad;
	private Date fechaCarga;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private NomPrductoPrestacion nomPrductoPrestacion;
	private PacEvento pacEventoByEventoId;
	private Integer actorId;
//	private Set<FacturacionEvento> facturacionEventosByEventoPrestacionId;
//	private Set<FacBitCargosAsegComercial> facBitCargosAsegComercialsByEventoPrestacionId;
//	private Set<FacBitCargosAsegParticular> facBitCargosAsegParticularsByEventoPrestacionId;
//	private Set<FacCargosAsegComercial> facCargosAsegComercialsByEventoPrestacionId;
//	private Set<FacCargosAsegParticular> facCargosAsegParticularsByEventoPrestacionId;
//	private Integer separacionCuentaFlag;
private NomCatTipoAgenteUbicacion nomCatTipoAgenteUbicacionByTipoAgenteUbicacionId;

	@ManyToOne @JoinColumn(name = "TIPO_AGENTE_UBICACION_ID", referencedColumnName = "TIPO_AGENTE_UBICACION_ID") public NomCatTipoAgenteUbicacion getNomCatTipoAgenteUbicacionByTipoAgenteUbicacionId() {
		return nomCatTipoAgenteUbicacionByTipoAgenteUbicacionId;
	}

	public void setNomCatTipoAgenteUbicacionByTipoAgenteUbicacionId(NomCatTipoAgenteUbicacion nomCatTipoAgenteUbicacionByTipoAgenteUbicacionId) {
		this.nomCatTipoAgenteUbicacionByTipoAgenteUbicacionId = nomCatTipoAgenteUbicacionByTipoAgenteUbicacionId;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EVENTO_PRESTACION_ID") public Integer getEventoPrestacionId() {
		return eventoPrestacionId;
	}

	public void setEventoPrestacionId(Integer eventoPrestacionId) {
		this.eventoPrestacionId = eventoPrestacionId;
	}

//	@Basic @Column(name = "PRODUCTO_PRESTACION_ID") public Integer getProductoPrestacionId() {
//		return productoPrestacionId;
//	}
//
//	public void setProductoPrestacionId(Integer productoPrestacionId) {
//		this.productoPrestacionId = productoPrestacionId;
//	}

	@Basic @Column(name = "ACTOR_ID")
	public Integer getActorId() {
		return actorId;
	}

	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}

	@Basic @Column(name = "PRESTACION_DEFAULT")
	public Integer getPrestacionDefault() {
		return prestacionDefault;
	}

	public void setPrestacionDefault(Integer prestacionDefault) {
		this.prestacionDefault = prestacionDefault;
	}

	@Basic @Column(name = "ORIGEN_PRESTACION")
	public Integer getOrigenPrestacion() {
		return origenPrestacion;
	}

	public void setOrigenPrestacion(Integer origenPrestacion) {
		this.origenPrestacion = origenPrestacion;
	}

	@Basic @Column(name = "CANTIDAD") public Float getCantidad() {
		return cantidad;
	}

	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}

	@Basic @Column(name = "FECHA_CARGA") public Date getFechaCarga() {
		return fechaCarga;
	}

	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
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



//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "PRODUCTO_PRESTACION_ID", referencedColumnName = "PRODUCTO_PRESTACION_ID", nullable = false)
//	public NomPrductoPrestacion getNomPrductoPrestacionByEventoPrestacionId() {
//		return nomPrductoPrestacionByEventoPrestacionId;
//	}
//
//	public void setNomPrductoPrestacionByEventoPrestacionId(NomPrductoPrestacion nomPrductoPrestacionByEventoPrestacionId) {
//		this.nomPrductoPrestacionByEventoPrestacionId = nomPrductoPrestacionByEventoPrestacionId;
//	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCTO_PRESTACION_ID" , referencedColumnName = "PRODUCTO_PRESTACION_ID", nullable = false)
	public NomPrductoPrestacion getNomPrductoPrestacion() {
		return nomPrductoPrestacion;
	}

	public void setNomPrductoPrestacion(NomPrductoPrestacion nomPrductoPrestacion) {
		this.nomPrductoPrestacion = nomPrductoPrestacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EVENTO_ID", referencedColumnName = "EVENTO_ID", nullable = false)
	public PacEvento getPacEventoByEventoId() {
		return pacEventoByEventoId;
	}

	public void setPacEventoByEventoId(PacEvento pacEventoByEventoId) {
		this.pacEventoByEventoId = pacEventoByEventoId;
	}

//	@OneToMany(mappedBy = "pacEventoPrestacionByEventoPrestacionId") public Set<FacturacionEvento> getFacturacionEventosByEventoPrestacionId() {
//		return facturacionEventosByEventoPrestacionId;
//	}
//
//	public void setFacturacionEventosByEventoPrestacionId(Set<FacturacionEvento> facturacionEventosByEventoPrestacionId) {
//		this.facturacionEventosByEventoPrestacionId = facturacionEventosByEventoPrestacionId;
//	}
//
//	@OneToMany(mappedBy = "pacEventoPrestacionByEventoPrestacionId") public Set<FacBitCargosAsegComercial> getFacBitCargosAsegComercialsByEventoPrestacionId() {
//		return facBitCargosAsegComercialsByEventoPrestacionId;
//	}
//
//	public void setFacBitCargosAsegComercialsByEventoPrestacionId(Set<FacBitCargosAsegComercial> facBitCargosAsegComercialsByEventoPrestacionId) {
//		this.facBitCargosAsegComercialsByEventoPrestacionId = facBitCargosAsegComercialsByEventoPrestacionId;
//	}
//
//	@OneToMany(mappedBy = "pacEventoPrestacionByEventoPrestacionId") public Set<FacBitCargosAsegParticular> getFacBitCargosAsegParticularsByEventoPrestacionId() {
//		return facBitCargosAsegParticularsByEventoPrestacionId;
//	}
//
//	public void setFacBitCargosAsegParticularsByEventoPrestacionId(Set<FacBitCargosAsegParticular> facBitCargosAsegParticularsByEventoPrestacionId) {
//		this.facBitCargosAsegParticularsByEventoPrestacionId = facBitCargosAsegParticularsByEventoPrestacionId;
//	}
//
//	@OneToMany(mappedBy = "pacEventoPrestacionByEventoPrestacionId") public Set<FacCargosAsegComercial> getFacCargosAsegComercialsByEventoPrestacionId() {
//		return facCargosAsegComercialsByEventoPrestacionId;
//	}
//
//	public void setFacCargosAsegComercialsByEventoPrestacionId(Set<FacCargosAsegComercial> facCargosAsegComercialsByEventoPrestacionId) {
//		this.facCargosAsegComercialsByEventoPrestacionId = facCargosAsegComercialsByEventoPrestacionId;
//	}
//
//	@OneToMany(mappedBy = "pacEventoPrestacion") public Set<FacCargosAsegParticular> getFacCargosAsegParticularsByEventoPrestacionId() {
//		return facCargosAsegParticularsByEventoPrestacionId;
//	}
//
//	public void setFacCargosAsegParticularsByEventoPrestacionId(Set<FacCargosAsegParticular> facCargosAsegParticularsByEventoPrestacionId) {
//		this.facCargosAsegParticularsByEventoPrestacionId = facCargosAsegParticularsByEventoPrestacionId;
//	}


//	@Basic @Column(name = "SEPARACION_CUENTA_FLAG")
//	public Integer getSeparacionCuentaFlag() {
//		return separacionCuentaFlag;
//	}
//
//	public void setSeparacionCuentaFlag(Integer separacionCuentaFlag) {
//		this.separacionCuentaFlag = separacionCuentaFlag;
//	}
}
