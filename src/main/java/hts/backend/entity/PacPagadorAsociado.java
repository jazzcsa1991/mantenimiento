package hts.backend.entity;
//Generated 5/04/2017 05:49:23 PM by Hibernate Tools 5.2.0.Beta1


import hts.backend.entity.FacAbonosAsegParticular;
import hts.backend.entity.FacBitAbonosAsegParticular;
import hts.backend.entity.FacturacionEvento;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * PacPagadorAsociado generated by hbm2java
 */
@Entity
@Table(name = "pac_pagador_asociado")
public class PacPagadorAsociado implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int pagadorAsociadoId;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String razonSocial;
	private Date fechaRegistro;
	private String usuarioRegistra;
	private Set<PacPagadorAsociadoPaciente> pacPagadorAsociadoPacientes = new HashSet<PacPagadorAsociadoPaciente>(0);
	private Set<PacDetalleFiscalPagadorAso> pacDetalleFiscalPagadorAsos = new HashSet<PacDetalleFiscalPagadorAso>(0);
	private Set<FacturacionEvento> facturacionEventosByPagadorAsociadoId;

	private Set<FacAbonosAsegParticular> facAbonosAsegParticularsByPagadorAsociadoId;
	private Set<FacBitAbonosAsegParticular> facBitAbonosAsegParticularsByPagadorAsociadoId;

	public PacPagadorAsociado() {
	}

	public PacPagadorAsociado(int pagadorAsociadoId, Date fechaRegistro, String usuarioRegistra) {
		this.pagadorAsociadoId = pagadorAsociadoId;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistra = usuarioRegistra;
	}

	public PacPagadorAsociado(int pagadorAsociadoId, String nombre, String primerApellido,
							  String segundoApellido, String razonSocial, Date fechaRegistro, String usuarioRegistra,
							  Set<PacPagadorAsociadoPaciente> pacPagadorAsociadoPacientes, Set<PacDetalleFiscalPagadorAso> pacDetalleFiscalPagadorAsos) {
		this.pagadorAsociadoId = pagadorAsociadoId;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.razonSocial = razonSocial;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistra = usuarioRegistra;
		this.pacPagadorAsociadoPacientes = pacPagadorAsociadoPacientes;
		this.pacDetalleFiscalPagadorAsos = pacDetalleFiscalPagadorAsos;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAGADOR_ASOCIADO_ID", unique = true, nullable = false, precision = 22)
	public int getPagadorAsociadoId() {
		return this.pagadorAsociadoId;
	}

	public void setPagadorAsociadoId(int pagadorAsociadoId) {
		this.pagadorAsociadoId = pagadorAsociadoId;
	}

	@Column(name = "NOMBRE", length = 100)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "PRIMER_APELLIDO", length = 50)
	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	@Column(name = "SEGUNDO_APELLIDO", length = 50)
	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	@Column(name = "RAZON_SOCIAL", length = 50)
	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", nullable = false, length = 7)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Column(name = "USUARIO_REGISTRO", nullable = false, length = 20)
	public String getUsuarioRegistra() {
		return this.usuarioRegistra;
	}

	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pacPagadorAsociado")
	public Set<PacPagadorAsociadoPaciente> getPacPagadorAsociadoPacientes() {
		return this.pacPagadorAsociadoPacientes;
	}

	public void setPacPagadorAsociadoPacientes(Set<PacPagadorAsociadoPaciente> pacPagadorAsociadoPacientes) {
		this.pacPagadorAsociadoPacientes = pacPagadorAsociadoPacientes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pacPagadorAsociado")
	public Set<PacDetalleFiscalPagadorAso> getPacDetalleFiscalPagadorAsos() {
		return this.pacDetalleFiscalPagadorAsos;
	}

	public void setPacDetalleFiscalPagadorAsos(Set<PacDetalleFiscalPagadorAso> pacDetalleFiscalPagadorAsos) {
		this.pacDetalleFiscalPagadorAsos = pacDetalleFiscalPagadorAsos;
	}

	@OneToMany(mappedBy = "pacPagadorAsociadoByPagadorAsociadoId")
	public Set<FacturacionEvento> getFacturacionEventosByPagadorAsociadoId() {
		return facturacionEventosByPagadorAsociadoId;
	}

	public void setFacturacionEventosByPagadorAsociadoId(Set<FacturacionEvento> facturacionEventosByPagadorAsociadoId) {
		this.facturacionEventosByPagadorAsociadoId = facturacionEventosByPagadorAsociadoId;
	}

	@OneToMany(mappedBy = "pacPagadorAsociado")
	public Set<FacAbonosAsegParticular> getFacAbonosAsegParticularsByPagadorAsociadoId() {
		return facAbonosAsegParticularsByPagadorAsociadoId;
	}

	public void setFacAbonosAsegParticularsByPagadorAsociadoId(Set<FacAbonosAsegParticular> facAbonosAsegParticularsByPagadorAsociadoId) {
		this.facAbonosAsegParticularsByPagadorAsociadoId = facAbonosAsegParticularsByPagadorAsociadoId;
	}

	@OneToMany(mappedBy = "pacPagadorAsociadoByPagadorAsociadoId")
	public Set<FacBitAbonosAsegParticular> getFacBitAbonosAsegParticularsByPagadorAsociadoId() {
		return facBitAbonosAsegParticularsByPagadorAsociadoId;
	}

	public void setFacBitAbonosAsegParticularsByPagadorAsociadoId(Set<FacBitAbonosAsegParticular> facBitAbonosAsegParticularsByPagadorAsociadoId) {
		this.facBitAbonosAsegParticularsByPagadorAsociadoId = facBitAbonosAsegParticularsByPagadorAsociadoId;
	}
}
