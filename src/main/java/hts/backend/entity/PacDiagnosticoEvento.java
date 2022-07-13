package hts.backend.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pac_diagnostico_evento")
public class PacDiagnosticoEvento implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer diagnosticoEvento;
	private CatTipoDiagnostico catTipoDiagnostico;
	private NomCatCie10 nomCatCie10;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private PacEvento pacEventoByEventoId;
	private AdmCatDiagnosticoVisita admCatDiagnosticoVisita;
	private Integer admCatDiagnosticoVisitaId;
	private Integer confirmarDiagnostico;
	//Columna nueva en tabla pac_diagnostico_evento:OBSERVACIONES
	private String observaciones;

	private Set<PacEpisodio> pacEpisodio = new HashSet<>(0);


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DIAGNOSTICO_EVENTO") public Integer getDiagnosticoEvento() {
		return diagnosticoEvento;
	}

	public void setDiagnosticoEvento(Integer diagnosticoEvento) {
		this.diagnosticoEvento = diagnosticoEvento;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_DIAGNOSTICO_ID", nullable = false)
	public CatTipoDiagnostico getCatTipoDiagnostico() {
		return this.catTipoDiagnostico;
	}

	public void setCatTipoDiagnostico(CatTipoDiagnostico catTipoDiagnostico) {
		this.catTipoDiagnostico = catTipoDiagnostico;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CIE_10_ID", nullable = false)
	public NomCatCie10 getNomCatCie10() {
		return this.nomCatCie10;
	}

	public void setNomCatCie10(NomCatCie10 nomCatCie10) {
		this.nomCatCie10 = nomCatCie10;
	}


	@Basic @Column(name = "FECHA_REGISTRO")
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@Basic @Column(name = "USUARIO_REGISTRO")
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EVENTO_ID", referencedColumnName = "EVENTO_ID", nullable = false)
	public PacEvento getPacEventoByEventoId() {
		return pacEventoByEventoId;
	}

	public void setPacEventoByEventoId(PacEvento pacEventoByEventoId) {
		this.pacEventoByEventoId = pacEventoByEventoId;
	}


	@OneToMany(mappedBy = "pacDiagnosticoEvento")
	public Set<PacEpisodio> getPacEpisodio() {
		return pacEpisodio;
	}

	public void setPacEpisodio(Set<PacEpisodio> pacEpisodio) {
		this.pacEpisodio = pacEpisodio;
	}

	@Column(name = "DIAGNOSTICO_VISITA_ID")
	public Integer getAdmCatDiagnosticoVisitaId() {
		return admCatDiagnosticoVisitaId;
	}

	public void setAdmCatDiagnosticoVisitaId(Integer admCatDiagnosticoVisitaId) {
		this.admCatDiagnosticoVisitaId = admCatDiagnosticoVisitaId;
	}

	@ManyToOne
	@JoinColumn(name = "DIAGNOSTICO_VISITA_ID", updatable = false, insertable = false)
	public AdmCatDiagnosticoVisita getAdmCatDiagnosticoVisita() {
		return admCatDiagnosticoVisita;
	}

	public void setAdmCatDiagnosticoVisita(AdmCatDiagnosticoVisita admCatDiagnosticoVisita) {
		this.admCatDiagnosticoVisita = admCatDiagnosticoVisita;
	}

	//Columna nueva en tabla pac_diagnostico_evento:DIAGNOSTICO
	@Basic @Column(name = "OBSERVACIONES")
	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Basic @Column(name = "CONFIRMAR_DIAGNOSTICO")
	public Integer getConfirmarDiagnostico() {
		return confirmarDiagnostico;
	}

	public void setConfirmarDiagnostico(Integer confirmarDiagnostico) {
		this.confirmarDiagnostico = confirmarDiagnostico;
	}
}
