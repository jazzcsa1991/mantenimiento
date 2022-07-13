package hts.backend.entity;


import hts.backend.entity.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "nom_cat_monedas")
public class NomCatMonedas implements java.io.Serializable  {




	private Integer monedasId;
	private String clave;
	private String descripcion;
	private float tipoDeCambio;
	private float monedaBase;
	private float status;
	private Date fechaRegistro;
	private Set<FacAbonosAsegComercial> facAbonosAsegComercialsByMonedasId;
	private Set<FacAbonosAsegParticular> facAbonosAsegParticularsByMonedasId;
	private Set<FacBitAbonosAsegComercial> facBitAbonosAsegComercialsByMonedasId;
	private Set<FacBitAbonosAsegParticular> facBitAbonosAsegParticularsByMonedasId;
	private Set<FacFormasPagoAsegPart> facFormasPagoAsegPartsByMonedasId;


	private Set<FacturacionFormasPago> facturacionFormasPagosByMonedasId;



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MONEDAS_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getMonedasId() {
		return monedasId;
	}

	public void setMonedasId(Integer monedasId) {
		this.monedasId = monedasId;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", length = 7)
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	@Column(name = "USUARIO_REGISTRO", length = 20)
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	private String usuarioRegistro;


	 @Column(name = "CLAVE") public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Basic @Column(name = "DESCRIPCION") public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Basic @Column(name = "TIPO_DE_CAMBIO") public float getTipoDeCambio() {
		return tipoDeCambio;
	}

	public void setTipoDeCambio(float tipoDeCambio) {
		this.tipoDeCambio = tipoDeCambio;
	}

	@Basic @Column(name = "MONEDA_BASE") public float getMonedaBase() {
		return monedaBase;
	}

	public void setMonedaBase(float monedaBase) {
		this.monedaBase = monedaBase;
	}

	@Basic @Column(name = "ESTATUS") public float getStatus() {
		return status;
	}

	public void setStatus(float status) {
		this.status = status;
	}

	@OneToMany(mappedBy = "nomCatMonedasByMonedasId")
	public Set<FacturacionFormasPago> getFacturacionFormasPagosByMonedasId() {
		return facturacionFormasPagosByMonedasId;
	}

	public void setFacturacionFormasPagosByMonedasId(Set<FacturacionFormasPago> facturacionFormasPagosByMonedasId) {
		this.facturacionFormasPagosByMonedasId = facturacionFormasPagosByMonedasId;
	}

	@OneToMany(mappedBy = "nomCatMonedas") public Set<FacAbonosAsegComercial> getFacAbonosAsegComercialsByMonedasId() {
		return facAbonosAsegComercialsByMonedasId;
	}

	public void setFacAbonosAsegComercialsByMonedasId(Set<FacAbonosAsegComercial> facAbonosAsegComercialsByMonedasId) {
		this.facAbonosAsegComercialsByMonedasId = facAbonosAsegComercialsByMonedasId;
	}

	@OneToMany(mappedBy = "nomCatMonedas") public Set<FacAbonosAsegParticular> getFacAbonosAsegParticularsByMonedasId() {
		return facAbonosAsegParticularsByMonedasId;
	}

	public void setFacAbonosAsegParticularsByMonedasId(Set<FacAbonosAsegParticular> facAbonosAsegParticularsByMonedasId) {
		this.facAbonosAsegParticularsByMonedasId = facAbonosAsegParticularsByMonedasId;
	}

	@OneToMany(mappedBy = "nomCatMonedasByMonedaId") public Set<FacBitAbonosAsegComercial> getFacBitAbonosAsegComercialsByMonedasId() {
		return facBitAbonosAsegComercialsByMonedasId;
	}

	public void setFacBitAbonosAsegComercialsByMonedasId(Set<FacBitAbonosAsegComercial> facBitAbonosAsegComercialsByMonedasId) {
		this.facBitAbonosAsegComercialsByMonedasId = facBitAbonosAsegComercialsByMonedasId;
	}

	@OneToMany(mappedBy = "nomCatMonedasByMonedaId") public Set<FacBitAbonosAsegParticular> getFacBitAbonosAsegParticularsByMonedasId() {
		return facBitAbonosAsegParticularsByMonedasId;
	}

	public void setFacBitAbonosAsegParticularsByMonedasId(Set<FacBitAbonosAsegParticular> facBitAbonosAsegParticularsByMonedasId) {
		this.facBitAbonosAsegParticularsByMonedasId = facBitAbonosAsegParticularsByMonedasId;
	}

	@OneToMany(mappedBy = "nomCatMonedas") public Set<FacFormasPagoAsegPart> getFacFormasPagoAsegPartsByMonedasId() {
		return facFormasPagoAsegPartsByMonedasId;
	}

	public void setFacFormasPagoAsegPartsByMonedasId(Set<FacFormasPagoAsegPart> facFormasPagoAsegPartsByMonedasId) {
		this.facFormasPagoAsegPartsByMonedasId = facFormasPagoAsegPartsByMonedasId;
	}


	}

