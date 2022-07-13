package hts.backend.entity;


import hts.backend.entity.PacEvento;
import hts.backend.entity.AdmPersonalCedula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "core_prescripciones_recetas")
public class CorePrescripcionesRecetas implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer recetaId;
	private String noReceta;
	private Integer estatus;
	private String usuarioRegistro;
	private Date fechaRegistro;
	private PacEvento pacEvento;
	private Integer eventoId;
	private GusModulos gusModulos;
	private Integer gusModuloId;
	private AdmPersonalCedula admPersonalCedula;
	private Integer personalCedulaId;
	private String indicacionesGenerales;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RECETA_ID", nullable = false, precision = 0) public Integer getRecetaId() {
		return recetaId;
	}

	public void setRecetaId(Integer recetaId) {
		this.recetaId = recetaId;
	}

	@Basic @Column(name = "NO_RECETA", nullable = false, length = 20) public String getNoReceta() {
		return noReceta;
	}

	public void setNoReceta(String noReceta) {
		this.noReceta = noReceta;
	}

	@Basic @Column(name = "ESTATUS", nullable = false, precision = 0) public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@Basic @Column(name = "USUARIO_REGISTRO", nullable = false, length = 20) public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Basic @Column(name = "FECHA_REGISTRO", nullable = false) public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "EVENTO_ID", nullable = false, insertable = false, updatable = false)
	public PacEvento getPacEvento() {
		return pacEvento;
	}

	public void setPacEvento(PacEvento pacEvento) {
		this.pacEvento = pacEvento;
	}

	@Column(name = "EVENTO_ID")
	public Integer getEventoId() {
		return eventoId;
	}

	public void setEventoId(Integer eventoId) {
		this.eventoId = eventoId;
	}

	@ManyToOne @JoinColumn(name = "GUS_MODULO_ID", nullable = false, insertable = false, updatable = false)
	public GusModulos getGusModulos() {
		return gusModulos;
	}

	public void setGusModulos(GusModulos gusModulos) {
		this.gusModulos = gusModulos;
	}

	@Column(name = "GUS_MODULO_ID")
	public Integer getGusModuloId() {
		return gusModuloId;
	}

	public void setGusModuloId(Integer gusModuloId) {
		this.gusModuloId = gusModuloId;
	}


	@ManyToOne (fetch = FetchType.LAZY) @JoinColumn(name = "PERSONAL_CEDULA_ID", nullable = false, insertable = false, updatable = false)
	public AdmPersonalCedula getAdmPersonalCedula() {
		return admPersonalCedula;
	}

	public void setAdmPersonalCedula(AdmPersonalCedula admPersonalCedula) {
		this.admPersonalCedula = admPersonalCedula;
	}

	@Column(name = "PERSONAL_CEDULA_ID")
	public Integer getPersonalCedulaId() {
		return personalCedulaId;
	}

	public void setPersonalCedulaId(Integer personalCedulaId) {
		this.personalCedulaId = personalCedulaId;
	}

	@Column(name = "INDICACIONES_GENERALES")

	public String getIndicacionesGenerales() {
		return indicacionesGenerales;
	}

	public void setIndicacionesGenerales(String indicacionesGenerales) {
		this.indicacionesGenerales = indicacionesGenerales;
	}
}
