package hts.backend.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * Created by SASA Desarrollo on 22/05/2017.
 */
@Entity
@Table(name = "trs_estudio_respuestas")
public class TrsEstudioRespuestas implements java.io.Serializable  {
	private static final long serialVersionUID = 1L;
	private Integer estudioRespuestasId;

	private Integer trsPreguntasId;
	@JsonBackReference(value="condRespToEstudResp")
	private TrsRespuestas trsRespuestas;

	private Integer trsGrupoPreguntasId;

	@JsonBackReference(value="condEconomToEstudioResp")
	private TrsCondicionesEconomicas trsCondicionesEconomicas;






	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ESTUDIO_RESPUESTAS_ID") public Integer getEstudioRespuestasId() {
		return estudioRespuestasId;
	}

	public void setEstudioRespuestasId(Integer estudioRespuestasId) {
		this.estudioRespuestasId = estudioRespuestasId;
	}


	@JsonIgnore
	@Basic @Column(name = "TRS_PREGUNTAS_ID") public Integer getTrsPreguntasId() {return trsPreguntasId;}
	@JsonProperty
	public void setTrsPreguntasId(Integer trsPreguntasId) {this.trsPreguntasId = trsPreguntasId;}



	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRS_RESPUESTAS_ID", nullable = false)
	public TrsRespuestas getTrsRespuestas() {
		return trsRespuestas;
	}

	public void setTrsRespuestas(TrsRespuestas trsRespuestas) {
		this.trsRespuestas = trsRespuestas;
	}


	@JsonIgnore
	@Basic @Column(name = "TRS_GRUPO_PREGUNTAS_ID") public Integer getTrsGrupoPreguntasId() {return trsGrupoPreguntasId;}
	@JsonProperty
	public void setTrsGrupoPreguntasId(Integer trsGrupoPreguntasId) {this.trsGrupoPreguntasId = trsGrupoPreguntasId;}



	/*
		@Basic @Column(name = "CONDICIONES_ECONOMICAS_ID")*/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CONDICIONES_ECONOMICAS_ID", nullable = false)
	public TrsCondicionesEconomicas getTrsCondicionesEconomicas() {
		return trsCondicionesEconomicas;
	}

	public void setTrsCondicionesEconomicas(TrsCondicionesEconomicas trsCondicionesEconomicas) {
		this.trsCondicionesEconomicas = trsCondicionesEconomicas;
	}



	@Override public String toString() {
		return "OBJECT::"+this.hashCode()
				+" estudioRespuestasId::"+this.estudioRespuestasId
				+" trsGrupoPreguntasId::"+this.trsGrupoPreguntasId
				+" trsPreguntasId::"+this.trsPreguntasId
				+" trsRespuestas::"+this.trsRespuestas;
	}

}
