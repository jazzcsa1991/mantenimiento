package hts.backend.entity;



import hts.backend.entity.AdmPersonal;
import hts.backend.entity.CatServEspecialidad;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hsp_alta_medica")
public class HspAltaMedica  implements java.io.Serializable{
	private static final long serialVersionUID = 3099407188269548480L;

	private Integer altaMedicaId;
	private Date fechaAltaMedica;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private AdmPersonal admPersonalByAdmProfSaludGralId;
	private CatServEspecialidad admCatServEspecialidadByServEspecialidadId;
	private NomCatCie10 nomCatCie10ByCie10Id;
	private CatMotivoEgreso catMotivoEgresoByMotivoEgresoId;
	private CatPronosticoSalida catPronosticoSalidaByPronosticoSalidaId;
	private PacEvento pacEventoByEventoId;
	private Integer estatus;
	private String usuarioAnulacion;
	private Date fechaAnulacion;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ALTA_MEDICA_ID", nullable = false, precision = 0) public Integer getAltaMedicaId() {
		return altaMedicaId;
	}

	public void setAltaMedicaId(Integer altaMedicaId) {
		this.altaMedicaId = altaMedicaId;
	}

	@Basic @Column(name = "FECHA_ALTA_MEDICA", nullable = false)
	public Date getFechaAltaMedica() {
		return fechaAltaMedica;
	}

	public void setFechaAltaMedica(Date fechaAltaMedica) {
		this.fechaAltaMedica = fechaAltaMedica;
	}

	@Basic @Column(name = "FECHA_REGISTRO", nullable = false) public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO", nullable = false, length = 50) public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}


	@ManyToOne @JoinColumn(name = "ADM_PROF_SALUD_GRAL_ID", referencedColumnName = "ADM_PROF_SALUD_GRAL_ID", nullable = false) public AdmPersonal getAdmPersonalByAdmProfSaludGralId() {
		return admPersonalByAdmProfSaludGralId;
	}

	public void setAdmPersonalByAdmProfSaludGralId(AdmPersonal admPersonalByAdmProfSaludGralId) {
		this.admPersonalByAdmProfSaludGralId = admPersonalByAdmProfSaludGralId;
	}

	@ManyToOne @JoinColumn(name = "SERV_ESPECIALIDAD_ID", referencedColumnName = "SERV_ESPECIALIDAD_ID", nullable = false) public CatServEspecialidad getAdmCatServEspecialidadByServEspecialidadId() {
		return admCatServEspecialidadByServEspecialidadId;
	}

	public void setAdmCatServEspecialidadByServEspecialidadId(CatServEspecialidad admCatServEspecialidadByServEspecialidadId) {
		this.admCatServEspecialidadByServEspecialidadId = admCatServEspecialidadByServEspecialidadId;
	}

	@ManyToOne @JoinColumn(name = "CIE_10_ID", referencedColumnName = "CIE_10_ID", nullable = false) public NomCatCie10 getNomCatCie10ByCie10Id() {
		return nomCatCie10ByCie10Id;
	}

	public void setNomCatCie10ByCie10Id(NomCatCie10 nomCatCie10ByCie10Id) {
		this.nomCatCie10ByCie10Id = nomCatCie10ByCie10Id;
	}

	@ManyToOne @JoinColumn(name = "MOTIVO_EGRESO_ID", referencedColumnName = "MOTIVO_EGRESO_ID", nullable = false)
	public CatMotivoEgreso getCatMotivoEgresoByMotivoEgresoId() {
		return catMotivoEgresoByMotivoEgresoId;
	}

	public void setCatMotivoEgresoByMotivoEgresoId(CatMotivoEgreso catMotivoEgresoByMotivoEgresoId) {
		this.catMotivoEgresoByMotivoEgresoId = catMotivoEgresoByMotivoEgresoId;
	}

	@ManyToOne @JoinColumn(name = "PRONOSTICO_SALIDA_ID", referencedColumnName = "PRONOSTICO_SALIDA_ID", nullable = false) public CatPronosticoSalida getCatPronosticoSalidaByPronosticoSalidaId() {
		return catPronosticoSalidaByPronosticoSalidaId;
	}

	public void setCatPronosticoSalidaByPronosticoSalidaId(CatPronosticoSalida catPronosticoSalidaByPronosticoSalidaId) {
		this.catPronosticoSalidaByPronosticoSalidaId = catPronosticoSalidaByPronosticoSalidaId;
	}

	@ManyToOne @JoinColumn(name = "EVENTO_ID", referencedColumnName = "EVENTO_ID") public PacEvento getPacEventoByEventoId() {
		return pacEventoByEventoId;
	}

	public void setPacEventoByEventoId(PacEvento pacEventoByEventoId) {
		this.pacEventoByEventoId = pacEventoByEventoId;
	}

	@Basic @Column(name = "ESTATUS", nullable = false)
	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@Basic @Column(name = "USUARIO_ANULACION", nullable = true, length = 50)
	public String getUsuarioAnulacion() {
		return usuarioAnulacion;
	}

	public void setUsuarioAnulacion(String usuarioAnulacion) {
		this.usuarioAnulacion = usuarioAnulacion;
	}

	@Basic @Column(name = "FECHA_ANULACION", nullable = true)
	public Date getFechaAnulacion() {
		return fechaAnulacion;
	}

	public void setFechaAnulacion(Date fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
	}
}
