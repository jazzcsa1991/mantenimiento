package hts.backend.entity;

import hts.backend.entity.CatSexoCamas;
import hts.backend.entity.NomCatMotivoBloqueoCama;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "adm_cama")
public class AdmCama implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer camaId;
	private AdmCentroCosto catCentroCosto;
	private String numero;
	private String descripcion;
	private Integer status;
	private Date fechaRegistro;
	private String usuarioCve;
	private Integer censable;
	private Integer edadInicio;
	private Integer edadFin;

	private AdmHabitacion admHabitacion;
	private CatTipoCama catTipoCama;
	private CatEstatusCama catEstatusCama;
	private Integer estatusCamaId;
	private CatSexoCamas catSexoCamas;

	private Integer motivoBloqueoCamaId;
	private NomCatMotivoBloqueoCama motivoBloqueoCama;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CAMA_ID", unique = true, nullable = false, precision = 22)
	public Integer getCamaId() {
		return this.camaId;
	}

	public void setCamaId(Integer camaId) {
		this.camaId = camaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CENTRO_COSTO_ID")
	public AdmCentroCosto getCatCentroCosto() {
		return this.catCentroCosto;
	}

	public void setCatCentroCosto(AdmCentroCosto catCentroCosto) {
		this.catCentroCosto = catCentroCosto;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HABITACION_ID")
	public AdmHabitacion getAdmHabitacion() {
		return this.admHabitacion;
	}

	public void setAdmHabitacion(AdmHabitacion admHabitacion) {
		this.admHabitacion = admHabitacion;
	}


	@Column(name = "NUMERO", length = 50)
	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}


	@Column(name = "DESCRIPCION", length = 100)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Column(name = "ESTATUS", precision = 22)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", length = 7)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@Column(name = "USUARIO_REGISTRO", length = 20)
	public String getUsuarioCve() {
		return this.usuarioCve;
	}

	public void setUsuarioCve(String usuarioCve) {
		this.usuarioCve = usuarioCve;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_CAMA_ID" , referencedColumnName = "TIPO_CAMA_ID")
	public CatTipoCama getCatTipoCama() {
		return catTipoCama;
	}

	public void setCatTipoCama(CatTipoCama catTipoCama) {
		this.catTipoCama = catTipoCama;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ESTATUS_CAMA_ID", referencedColumnName = "ESTATUS_CAMA_ID", insertable = false, updatable = false)
	public CatEstatusCama getCatEstatusCama() {
		return catEstatusCama;
	}

	public void setCatEstatusCama(CatEstatusCama catEstatusCama) {
		this.catEstatusCama = catEstatusCama;
	}

	@Basic
	@Column(name = "ESTATUS_CAMA_ID", nullable = false, precision = 0)
	public Integer getEstatusCamaId() {
		return estatusCamaId;
	}

	public void setEstatusCamaId(Integer estatusCamaId) {
		this.estatusCamaId = estatusCamaId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SEXO_CAMAS_ID")
	public CatSexoCamas getCatSexoCamas() {
		return catSexoCamas;
	}

	public void setCatSexoCamas(CatSexoCamas catSexoCamas) {
		this.catSexoCamas = catSexoCamas;
	}


	@Column(name = "CENSABLE")
	public Integer getCensable() {
		return censable;
	}

	public void setCensable(Integer censable) {
		this.censable = censable;
	}


	@Column(name = "EDAD_INICIO")
	public Integer getEdadInicio() {
		return edadInicio;
	}

	public void setEdadInicio(Integer edadInicio) {
		this.edadInicio = edadInicio;
	}


	@Column(name = "EDAD_FIN")
	public Integer getEdadFin() {
		return edadFin;
	}

	public void setEdadFin(Integer edadFin) {
		this.edadFin = edadFin;
	}


	@ManyToOne @JoinColumn(name = "MOTIVO_BLOQUEO_ID", referencedColumnName = "MOTIVO_BLOQUEO_CAMA_ID", insertable = false, updatable = false)
	public NomCatMotivoBloqueoCama getMotivoBloqueoCama() {
		return motivoBloqueoCama;
	}

	public void setMotivoBloqueoCama(NomCatMotivoBloqueoCama motivoBloqueoCama) {
		this.motivoBloqueoCama = motivoBloqueoCama;
	}


	@Column(name = "MOTIVO_BLOQUEO_ID")
	public Integer getMotivoBloqueoCamaId() {
		return motivoBloqueoCamaId;
	}

	public void setMotivoBloqueoCamaId(Integer motivoBloqueoCamaId) {
		this.motivoBloqueoCamaId = motivoBloqueoCamaId;
	}
}
