package hts.backend.entity;

import hts.backend.entity.*;
import hts.backend.entity.CexMedicamentosMateriales;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "core_prescripciones_soluciones")
public class CorePrescripcionesSoluciones implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer prescripcionSolucionId;
	private Float cantidad;
	private Float cantidadMedicamento;
	private String indicaciones;
	private String indicacionesMedicamento;
	private Integer dias;
	private Integer pautaManual;
	private Integer horaPautaManual;
	private Date fechaInicio;
	private Date fechaFin;
	private Float totalMedicamento;
	private Date fechaInterrupcion;
	private String usuarioInterrupcion;
	private String usuarioRegistro;
	private Date fechaRegistro;
	private Float total;
	private Integer CatViaAdministracionIdMed;
	private Integer CatViaAdministracionId;


	private CexMedicamentosMateriales cexMedicamentosMateriales;
	private Integer SolucionId;
	private CexMedicamentosMateriales cexMedicamentosMateriales2;
	private Integer MedicamentoId;
	private PacEvento pacEvento;
	private Integer EventoId;
	private CorePauta corePauta;
	private Integer PautaId;
	private CatEstadoPrescripcion catEstadoPrescripcion;
	private Integer EstadoPrescripcionId;
	private CatMotInterrupcionPresc catMotInterrupcionPresc;
	private Integer MotivoInterrupcionId;
	private CatViaAdministracion catViaAdministracionByViaAdministracionId;
	private CatViaAdministracion catViaAdministracionByViaAdministracionIdMed;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRESCRIPCION_SOLUCION_ID") public Integer getPrescripcionSolucionId() {
		return prescripcionSolucionId;
	}

	public void setPrescripcionSolucionId(Integer prescripcionSolucionId) {
		this.prescripcionSolucionId = prescripcionSolucionId;
	}

	@Basic @Column(name = "CANTIDAD")
	public Float getCantidad() {
		return cantidad;
	}

	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}

	@Basic @Column(name = "CANTIDAD_MEDICAMENTO")
	public Float getCantidadMedicamento() {
		return cantidadMedicamento;
	}

	public void setCantidadMedicamento(Float cantidadMedicamento) {
		this.cantidadMedicamento = cantidadMedicamento;
	}


	@Basic @Column(name = "INDICACIONES") public String getIndicaciones() {
		return indicaciones;
	}

	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}

	@Basic @Column(name = "INDICACIONES_MEDICAMENTO") public String getIndicacionesMedicamento() {
		return indicacionesMedicamento;
	}

	public void setIndicacionesMedicamento(String indicacionesMedicamento) {
		this.indicacionesMedicamento = indicacionesMedicamento;
	}

	@Basic @Column(name = "DIAS") public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	@Basic @Column(name = "PAUTA_MANUAL") public Integer getPautaManual() {
		return pautaManual;
	}

	public void setPautaManual(Integer pautaManual) {
		this.pautaManual = pautaManual;
	}

	@Basic @Column(name = "HORA_PAUTA_MANUAL") public Integer getHoraPautaManual() {
		return horaPautaManual;
	}

	public void setHoraPautaManual(Integer horaPautaManual) {
		this.horaPautaManual = horaPautaManual;
	}

	@Basic @Column(name = "FECHA_INICIO") public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Basic @Column(name = "FECHA_FIN") public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}


	@Basic @Column(name = "TOTAL_MEDICAMENTO")
	public Float getTotalMedicamento() {
		return totalMedicamento;
	}

	public void setTotalMedicamento(Float totalMedicamento) {
		this.totalMedicamento = totalMedicamento;
	}


	@Basic @Column(name = "FECHA_INTERRUPCION") public Date getFechaInterrupcion() {
		return fechaInterrupcion;
	}

	public void setFechaInterrupcion(Date fechaInterrupcion) {
		this.fechaInterrupcion = fechaInterrupcion;
	}

	@Basic @Column(name = "USUARIO_INTERRUPCION") public String getUsuarioInterrupcion() {
		return usuarioInterrupcion;
	}

	public void setUsuarioInterrupcion(String usuarioInterrupcion) {
		this.usuarioInterrupcion = usuarioInterrupcion;
	}

	@Basic @Column(name = "USUARIO_REGISTRO") public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Basic @Column(name = "FECHA_REGISTRO") public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@ManyToOne @JoinColumn(name = "SOLUCION_ID", insertable = false, updatable = false)
	public CexMedicamentosMateriales getCexMedicamentosMateriales() {
		return cexMedicamentosMateriales;
	}

	public void setCexMedicamentosMateriales(CexMedicamentosMateriales cexMedicamentosMateriales) {
		this.cexMedicamentosMateriales = cexMedicamentosMateriales;
	}

	@Column(name = "SOLUCION_ID")
	public Integer getSolucionId() {
		return SolucionId;
	}

	public void setSolucionId(Integer solucionId) {
		SolucionId = solucionId;
	}

	@ManyToOne @JoinColumn(name = "MEDICAMENTO_ID", insertable = false, updatable = false)
	public CexMedicamentosMateriales getCexMedicamentosMateriales2() {
		return cexMedicamentosMateriales2;
	}

	public void setCexMedicamentosMateriales2(CexMedicamentosMateriales cexMedicamentosMateriales2) {
		this.cexMedicamentosMateriales2 = cexMedicamentosMateriales2;
	}

	@Column(name = "MEDICAMENTO_ID")
	public Integer getMedicamentoId() {
		return MedicamentoId;
	}

	public void setMedicamentoId(Integer medicamentoId) {
		MedicamentoId = medicamentoId;
	}

	@ManyToOne @JoinColumn(name = "EVENTO_ID", insertable = false, updatable = false, nullable = false)
	public PacEvento getPacEvento() {
		return pacEvento;
	}

	public void setPacEvento(PacEvento pacEvento) {
		this.pacEvento = pacEvento;
	}

	@Column(name = "EVENTO_ID")
	public Integer getEventoId() {
		return EventoId;
	}

	public void setEventoId(Integer eventoId) {
		EventoId = eventoId;
	}

	@ManyToOne @JoinColumn(name = "PAUTA_ID", insertable = false, updatable = false)
	public CorePauta getCorePauta() {
		return corePauta;
	}

	public void setCorePauta(CorePauta corePauta) {
		this.corePauta = corePauta;
	}

	@Column(name = "PAUTA_ID")
	public Integer getPautaId() {
		return PautaId;
	}

	public void setPautaId(Integer pautaId) {
		PautaId = pautaId;
	}

	@ManyToOne @JoinColumn(name = "ESTADO_PRESCRIPCION_ID", insertable = false, updatable = false, nullable = false)
	public CatEstadoPrescripcion getCatEstadoPrescripcion() {
		return catEstadoPrescripcion;
	}

	public void setCatEstadoPrescripcion(CatEstadoPrescripcion catEstadoPrescripcion) {
		this.catEstadoPrescripcion = catEstadoPrescripcion;
	}

	@Column(name = "ESTADO_PRESCRIPCION_ID")
	public Integer getEstadoPrescripcionId() {
		return EstadoPrescripcionId;
	}

	public void setEstadoPrescripcionId(Integer estadoPrescripcionId) {
		EstadoPrescripcionId = estadoPrescripcionId;
	}

	@ManyToOne @JoinColumn(name = "MOTIVO_INTERRUPCION_ID", insertable = false, updatable = false)
	public CatMotInterrupcionPresc getCatMotInterrupcionPresc() {
		return catMotInterrupcionPresc;
	}

	public void setCatMotInterrupcionPresc(CatMotInterrupcionPresc catMotInterrupcionPresc) {
		this.catMotInterrupcionPresc = catMotInterrupcionPresc;
	}

	@Column(name = "MOTIVO_INTERRUPCION_ID")
	public Integer getMotivoInterrupcionId() {
		return MotivoInterrupcionId;
	}

	public void setMotivoInterrupcionId(Integer motivoInterrupcionId) {
		MotivoInterrupcionId = motivoInterrupcionId;
	}


	@Basic @Column(name = "TOTAL")
	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}


	@ManyToOne @JoinColumn(name = "VIA_ADMINISTRACION_ID", referencedColumnName = "VIA_ADMINISTRACION_ID", insertable = false, updatable = false) public CatViaAdministracion getCatViaAdministracionByViaAdministracionId() {
		return catViaAdministracionByViaAdministracionId;
	}

	public void setCatViaAdministracionByViaAdministracionId(CatViaAdministracion catViaAdministracionByViaAdministracionId) {
		this.catViaAdministracionByViaAdministracionId = catViaAdministracionByViaAdministracionId;
	}

	@ManyToOne @JoinColumn(name = "VIA_ADMINISTRACION_ID_MED", referencedColumnName = "VIA_ADMINISTRACION_ID", insertable = false, updatable = false) public CatViaAdministracion getCatViaAdministracionByViaAdministracionIdMed() {
		return catViaAdministracionByViaAdministracionIdMed;
	}

	public void setCatViaAdministracionByViaAdministracionIdMed(CatViaAdministracion catViaAdministracionByViaAdministracionIdMed) {
		this.catViaAdministracionByViaAdministracionIdMed = catViaAdministracionByViaAdministracionIdMed;
	}

	@Column(name = "VIA_ADMINISTRACION_ID")
	public Integer getCatViaAdministracionId() {
		return CatViaAdministracionId;
	}

	public void setCatViaAdministracionId(Integer catViaAdministracionId) {
		CatViaAdministracionId = catViaAdministracionId;
	}

	@Column(name = "VIA_ADMINISTRACION_ID_MED")
	public Integer getCatViaAdministracionIdMed() {
		return CatViaAdministracionIdMed;
	}

	public void setCatViaAdministracionIdMed(Integer catViaAdministracionIdMed) {
		CatViaAdministracionIdMed = catViaAdministracionIdMed;
	}
}
