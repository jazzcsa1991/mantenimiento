package hts.backend.entity;

import java.util.Date;

import javax.persistence.*;

import hts.backend.entity.AdmCatTipoConsulta;

@Entity
@Table(name = "instruccion_visita")
public class InstruccionVisita implements java.io.Serializable {

	/**
	 *
	 */
	private static long serialVersionUID = 1L;
	private Integer instruccionVisitaId;
	private InstruccionCita instruccionCita;
	private AdmCatTipoConsulta catTipoConsulta;
	private Date fechaRegistro;
	private String usurarioRegistro;

	public InstruccionVisita() {
	}



	public InstruccionVisita(Integer instruccionVisitaId, InstruccionCita instruccionCita,
							 AdmCatTipoConsulta catTipoConsulta, Date fechaRegistro, String usurarioRegistro) {

		this.instruccionVisitaId = instruccionVisitaId;
		this.instruccionCita = instruccionCita;
		this.catTipoConsulta = catTipoConsulta;
		this.fechaRegistro = fechaRegistro;
		this.usurarioRegistro = usurarioRegistro;	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INSTRUCCION_VISITA_ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getInstruccionVisitaId() {
		return instruccionVisitaId;
	}

	public void setInstruccionVisitaId(Integer instruccionVisitaId) {
		this.instruccionVisitaId = instruccionVisitaId;
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
	public String getUsurarioRegistro() {
		return usurarioRegistro;
	}

	public void setUsurarioRegistro(String usurarioRegistro) {
		this.usurarioRegistro = usurarioRegistro;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INSTRUCCION_CITA_ID" ,  referencedColumnName = "INSTRUCION_CITA_ID")
	public InstruccionCita getInstruccionCita() {
		return instruccionCita;
	}

	public void setInstruccionCita(InstruccionCita instruccionCita) {
		this.instruccionCita = instruccionCita;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_CONSULTA_ID")
	public AdmCatTipoConsulta getCatTipoConsulta() {
		return catTipoConsulta;
	}

	public void setCatTipoConsulta(AdmCatTipoConsulta catTipoConsulta) {
		this.catTipoConsulta = catTipoConsulta;
	}

}
