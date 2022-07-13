package hts.backend.entity;

import hts.backend.entity.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by SASA Desarrollo on 24/04/2017.
 */
@Entity
@Table(name = "nom_cat_motivo_anulacion_prest")
public class CatMotivoAnulacionPrest implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer motivoAnulacionPrestId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer defaults;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuario;
	private CatIdiomaApp catIdiomaAppByIdiomaAppId;
//	private Set<FacBitAbonosAsegComercial> facBitAbonosAsegComercialsByMotivoAnulacionPrestId;
//	private Set<FacBitAbonosAsegParticular> facBitAbonosAsegParticularsByMotivoAnulacionPrestId;
	private Set<FacBitCargosAsegComercial> facBitCargosAsegComercialsByMotivoAnulacionPrestId;
	private Set<FacBitCargosAsegParticular> facBitCargosAsegParticularsByMotivoAnulacionPrestId;
//	private Set<FacBitConcilAsegComercial> facBitConcilAsegComercialsByMotivoAnulacionPrestId;
//	private Set<FacBitConcilAsegParticular> facBitConcilAsegParticularsByMotivoAnulacionPrestId;

	private Set<PacEventoPrestacionBitacora> pacEventoPrestacionBitacorasByMotivoAnulacionPrestId = new HashSet<PacEventoPrestacionBitacora>(0);


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOTIVO_ANULACION_PREST_ID") public Integer getMotivoAnulacionPrestId() {
		return motivoAnulacionPrestId;
	}

	public void setMotivoAnulacionPrestId(Integer motivoAnulacionPrestId) {
		this.motivoAnulacionPrestId = motivoAnulacionPrestId;
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

	@Basic @Column(name = "VALOR_DEFAULT") public Integer getDefaults() {
		return defaults;
	}

	public void setDefaults(Integer defaults) {
		this.defaults = defaults;
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

	@Basic @Column(name = "USUARIO_REGISTRO") public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	@ManyToOne @JoinColumn(name = "IDIOMA_APP_ID", referencedColumnName = "IDIOMA_APP_ID", nullable = false) public CatIdiomaApp getCatIdiomaAppByIdiomaAppId() {
		return catIdiomaAppByIdiomaAppId;
	}

	public void setCatIdiomaAppByIdiomaAppId(CatIdiomaApp catIdiomaAppByIdiomaAppId) {
		this.catIdiomaAppByIdiomaAppId = catIdiomaAppByIdiomaAppId;
	}

//	@OneToMany(mappedBy = "catMotivoAnulacionPrestByMotivoCancelacionAbonoId")
//	public Set<FacBitAbonosAsegComercial> getFacBitAbonosAsegComercialsByMotivoAnulacionPrestId() {
//		return facBitAbonosAsegComercialsByMotivoAnulacionPrestId;
//	}
//
//	public void setFacBitAbonosAsegComercialsByMotivoAnulacionPrestId(Set<FacBitAbonosAsegComercial> facBitAbonosAsegComercialsByMotivoAnulacionPrestId) {
//		this.facBitAbonosAsegComercialsByMotivoAnulacionPrestId = facBitAbonosAsegComercialsByMotivoAnulacionPrestId;
//	}

//	@OneToMany(mappedBy = "catMotivoAnulacionPrestByMotivoCancelacionAbonoId")
//	public Set<FacBitAbonosAsegParticular> getFacBitAbonosAsegParticularsByMotivoAnulacionPrestId() {
//		return facBitAbonosAsegParticularsByMotivoAnulacionPrestId;
//	}
//
//	public void setFacBitAbonosAsegParticularsByMotivoAnulacionPrestId(Set<FacBitAbonosAsegParticular> facBitAbonosAsegParticularsByMotivoAnulacionPrestId) {
//		this.facBitAbonosAsegParticularsByMotivoAnulacionPrestId = facBitAbonosAsegParticularsByMotivoAnulacionPrestId;
//	}

	@OneToMany(mappedBy = "catMotivoAnulacionPrestByMotivoCancelacionCargoId")
	public Set<FacBitCargosAsegComercial> getFacBitCargosAsegComercialsByMotivoAnulacionPrestId() {
		return facBitCargosAsegComercialsByMotivoAnulacionPrestId;
	}

	public void setFacBitCargosAsegComercialsByMotivoAnulacionPrestId(Set<FacBitCargosAsegComercial> facBitCargosAsegComercialsByMotivoAnulacionPrestId) {
		this.facBitCargosAsegComercialsByMotivoAnulacionPrestId = facBitCargosAsegComercialsByMotivoAnulacionPrestId;
	}

	@OneToMany(mappedBy = "catMotivoAnulacionPrestByMotivoCancelacionCargoId")
	public Set<FacBitCargosAsegParticular> getFacBitCargosAsegParticularsByMotivoAnulacionPrestId() {
		return facBitCargosAsegParticularsByMotivoAnulacionPrestId;
	}

	public void setFacBitCargosAsegParticularsByMotivoAnulacionPrestId(Set<FacBitCargosAsegParticular> facBitCargosAsegParticularsByMotivoAnulacionPrestId) {
		this.facBitCargosAsegParticularsByMotivoAnulacionPrestId = facBitCargosAsegParticularsByMotivoAnulacionPrestId;
	}


	@OneToMany(mappedBy = "catMotivoAnulacionPrestByMotivoAnulacionPrestId")
	public Set<PacEventoPrestacionBitacora> getPacEventoPrestacionBitacorasByMotivoAnulacionPrestId() {
		return pacEventoPrestacionBitacorasByMotivoAnulacionPrestId;
	}

	public void setPacEventoPrestacionBitacorasByMotivoAnulacionPrestId(Set<PacEventoPrestacionBitacora> pacEventoPrestacionBitacorasByMotivoAnulacionPrestId) {
		this.pacEventoPrestacionBitacorasByMotivoAnulacionPrestId = pacEventoPrestacionBitacorasByMotivoAnulacionPrestId;
	}

//	@OneToMany(mappedBy = "catMotivoAnulacionPrestByMotivoCancelacionConcilId") public Set<FacBitConcilAsegComercial> getFacBitConcilAsegComercialsByMotivoAnulacionPrestId() {
//		return facBitConcilAsegComercialsByMotivoAnulacionPrestId;
//	}
//
//	public void setFacBitConcilAsegComercialsByMotivoAnulacionPrestId(Set<FacBitConcilAsegComercial> facBitConcilAsegComercialsByMotivoAnulacionPrestId) {
//		this.facBitConcilAsegComercialsByMotivoAnulacionPrestId = facBitConcilAsegComercialsByMotivoAnulacionPrestId;
//	}
//
//	@OneToMany(mappedBy = "catMotivoAnulacionPrestByMotivoCancelacionConcilId") public Set<FacBitConcilAsegParticular> getFacBitConcilAsegParticularsByMotivoAnulacionPrestId() {
//		return facBitConcilAsegParticularsByMotivoAnulacionPrestId;
//	}
//
//	public void setFacBitConcilAsegParticularsByMotivoAnulacionPrestId(Set<FacBitConcilAsegParticular> facBitConcilAsegParticularsByMotivoAnulacionPrestId) {
//		this.facBitConcilAsegParticularsByMotivoAnulacionPrestId = facBitConcilAsegParticularsByMotivoAnulacionPrestId;
//	}
}
