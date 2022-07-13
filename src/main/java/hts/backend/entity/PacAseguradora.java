package hts.backend.entity;

import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pac_aseguradora")
@NamedQuery(name="PacAseguradora.findByIdPaciente", query="select pacAseguradoraEntity "
														+"from PacAseguradora as pacAseguradoraEntity "
														+"inner join pacAseguradoraEntity.pacPaciente as pacPacienteEntity "
														+"inner join pacAseguradoraEntity.admCatAseguradora as admCatAseguradoraEntity "
														+"where pacPacienteEntity.idPaciente = ?0 "
														//+"and admCatAseguradoraEntity.aseguradoraId = ?"

)
public class PacAseguradora implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer pacAseguradoraId;
	private PacPaciente pacPaciente;
	private CatCoaseguro catCoaseguro;
	private AdmCatAseguradora admCatAseguradora;
	private CatMotivoAsignacion catMotivoAsignacion;
	private Integer motivoAsignacionId;
	private Integer prioridad;
	private String noPoliza;
	private Integer deducible;
	private Integer limiteSeguro;
	private Date fechaInicia;
	private Date fechaFin;
	private Date fechaRegistro;
	private String usuarioRegistra;
	private PacConvenioAseguradora pacConvenioAseguradora;

	private String folioAsignacion;


	/*@OneToOne
	@JoinColumn(name = "FOLIO_ASIGNACION")//Original*/

/*	@OneToOne(fetch = FetchType.LAZY, mappedBy = "pacAseguradora" )//original
	public TrsCondicionesEconomicas getTrsCondicionesEconomicas() {return trsCondicionesEconomicas;}

	public void setTrsCondicionesEconomicas(TrsCondicionesEconomicas trsCondicionesEconomicas) {this.trsCondicionesEconomicas = trsCondicionesEconomicas;}*/


	@Basic @Column(name = "FOLIO_ASIGNACION",length = 20)
	public String getFolioAsignacion() {return folioAsignacion;}

	public void setFolioAsignacion(String folioAsignacion) {this.folioAsignacion = folioAsignacion;}


	public PacAseguradora() {
	}

	public PacAseguradora(Integer pacAseguradoraId, Integer prioridad, Date fechaInicia, Date fechaFin, Date fechaRegistro, String usuarioRegistra) {
		this.pacAseguradoraId = pacAseguradoraId;
		this.prioridad = prioridad;
		this.fechaInicia = fechaInicia;
		this.fechaFin = fechaFin;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistra = usuarioRegistra;
	}

	public PacAseguradora(Integer pacAseguradoraId, PacPaciente pacPaciente, CatCoaseguro catCoaseguro, AdmCatAseguradora admCatAseguradora, CatMotivoAsignacion catMotivoAsignacion, Integer prioridad, String noPoliza, Integer deducible, Integer limiteSeguro, Date fechaInicia, Date fechaFin, Date fechaRegistro, String usuarioRegistra) {
		this.pacAseguradoraId = pacAseguradoraId;
		this.pacPaciente = pacPaciente;
		this.catCoaseguro = catCoaseguro;
		this.admCatAseguradora = admCatAseguradora;
		this.catMotivoAsignacion = catMotivoAsignacion;
		this.prioridad = prioridad;
		this.noPoliza = noPoliza;
		this.deducible = deducible;
		this.limiteSeguro = limiteSeguro;
		this.fechaInicia = fechaInicia;
		this.fechaFin = fechaFin;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistra = usuarioRegistra;
	}

	public static PacAseguradora AseguradoraParticular(PacPaciente pacPaciente, CatCoaseguro catCoaseguro, AdmCatAseguradora admCatAseguradora, PacConvenioAseguradora pacConvenioAseguradora) {
		PacAseguradora obj = new PacAseguradora();

		obj.setPacPaciente(pacPaciente);
		obj.setCatCoaseguro(catCoaseguro);
		obj.setAdmCatAseguradora(admCatAseguradora);
		obj.setMotivoAsignacionId(1);
		obj.setPrioridad(99);
		obj.setPacConvenioAseguradora(pacConvenioAseguradora);

		obj.setFechaInicia(new Date());
		obj.setFechaRegistro(new Date());
		obj.setFechaFin(null);
		obj.setUsuarioRegistra(SecurityContextHolder.getContext().getAuthentication().getName());
		obj.setDeducible(null);
		obj.setNoPoliza(null);
		obj.setLimiteSeguro(null);

		return obj;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAC_ASEGURADORA_ID", unique = true, nullable = false, length = 18)
	public Integer getPacAseguradoraId() {
		return this.pacAseguradoraId;
	}

	public void setPacAseguradoraId(Integer pacAseguradoraId) {
		this.pacAseguradoraId = pacAseguradoraId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CONVENIO_ASEGURADORA_ID")
	public PacConvenioAseguradora getPacConvenioAseguradora() {
		return this.pacConvenioAseguradora;
	}

	public void setPacConvenioAseguradora(PacConvenioAseguradora pacConvenioAseguradora) {
		this.pacConvenioAseguradora = pacConvenioAseguradora;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PACIENTE")
	public PacPaciente getPacPaciente() {
		return this.pacPaciente;
	}

	public void setPacPaciente(PacPaciente pacPaciente) {
		this.pacPaciente = pacPaciente;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COASEGURO_ID")
	public CatCoaseguro getCatCoaseguro() {
		return this.catCoaseguro;
	}

	public void setCatCoaseguro(CatCoaseguro catCoaseguro) {
		this.catCoaseguro = catCoaseguro;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ASEGURADORA_ID")
	public AdmCatAseguradora getAdmCatAseguradora() {
		return this.admCatAseguradora;
	}

	public void setAdmCatAseguradora(AdmCatAseguradora admCatAseguradora) {
		this.admCatAseguradora = admCatAseguradora;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MOTIVO_ASIGNACION_ID", updatable = false, insertable = false)
	public CatMotivoAsignacion getCatMotivoAsignacion() {
		return this.catMotivoAsignacion;
	}

	public void setCatMotivoAsignacion(CatMotivoAsignacion catMotivoAsignacion) {
		this.catMotivoAsignacion = catMotivoAsignacion;
	}


	@Column(name = "PRIORIDAD", nullable = false, precision = 22, scale = 0)
	public Integer getPrioridad() {
		return this.prioridad;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}


	@Column(name = "NO_POLIZA", length = 20)
	public String getNoPoliza() {
		return this.noPoliza;
	}

	public void setNoPoliza(String noPoliza) {
		this.noPoliza = noPoliza;
	}


	@Column(name = "DEDUCIBLE", precision = 22, scale = 0)
	public Integer getDeducible() {
		return this.deducible;
	}

	public void setDeducible(Integer deducible) {
		this.deducible = deducible;
	}


	@Column(name = "LIMITE_SEGURO", precision = 22, scale = 0)
	public Integer getLimiteSeguro() {
		return this.limiteSeguro;
	}

	public void setLimiteSeguro(Integer limiteSeguro) {
		this.limiteSeguro = limiteSeguro;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_INICIA", nullable = false, length = 7)
	public Date getFechaInicia() {
		return this.fechaInicia;
	}

	public void setFechaInicia(Date fechaInicia) {
		this.fechaInicia = fechaInicia;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_FIN", nullable = false, length = 7)
	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
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


	@Column(name = "MOTIVO_ASIGNACION_ID")
	public Integer getMotivoAsignacionId() {
		return motivoAsignacionId;
	}

	public void setMotivoAsignacionId(Integer motivoAsignacionId) {
		this.motivoAsignacionId = motivoAsignacionId;
	}

	@Override public String toString() {
		return "OBJECT::"+this.hashCode()
				+" pacAseguradoraId::"+this.pacAseguradoraId
				+" prioridad::"+this.prioridad
				+" noPoliza::"+this.noPoliza
				+" deducible::"+this.deducible
				+" limiteSeguro::"+this.limiteSeguro
				+" fechaInicia::"+this.fechaInicia
				+" fechaFin::"+this.fechaFin
				+" fechaRegistro::"+this.fechaRegistro
				+" usuarioRegistra::"+this.usuarioRegistra
				+" folioAsignacion"+this.folioAsignacion;
	}

}
