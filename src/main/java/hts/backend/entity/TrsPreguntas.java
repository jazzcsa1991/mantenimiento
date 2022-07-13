package hts.backend.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lenovo3 on 17/05/2017.
 */
@Entity
@Table(name = "trs_preguntas")
public class TrsPreguntas implements java.io.Serializable {
	@JsonIgnore
	private String clavePreguntas;
	private String descPregunta;
	@JsonIgnore
	private long orden;
	@JsonIgnore
	private long defaultPregunta;
	@JsonIgnore
	private Integer estatus;
	@JsonIgnore
	private Date fechaRegistro;
	@JsonIgnore
	private String usuarioRegistro;
	private Integer trsPreguntasId;
	/*private Set<TrsEstudioRespuestas> trsEstudioRespuestas = new HashSet<TrsEstudioRespuestas>(0);*/

	@JsonBackReference(value="condGrupoPregToPreg")
	private TrsGrupoPreguntas trsGrupoPreguntasId;

/*	private Set<TrsEstudioRespuestas> trsEstudioRespuestas = new HashSet<TrsEstudioRespuestas>(0);
	*/
	@JsonManagedReference(value="condPregToResp")
	private Set<TrsRespuestas> trsRespuestas = new HashSet<TrsRespuestas>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trsPreguntasId")
	@OrderBy("descripcionRespuesta ASC")
	public Set<TrsRespuestas> getTrsRespuestas() {
		return trsRespuestas;
	}

	public void setTrsRespuestas(Set<TrsRespuestas> trsRespuestas) {
		this.trsRespuestas = trsRespuestas;
	}


/*	@OneToMany(mappedBy = "trsGrupoPreguntas")
	public Set<TrsEstudioRespuestas> getTrsEstudioRespuestas() {
		return trsEstudioRespuestas;
	}

	public void setTrsEstudioRespuestas(Set<TrsEstudioRespuestas> trsEstudioRespuestas) {
		this.trsEstudioRespuestas = trsEstudioRespuestas;
	}*/

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRS_GRUPO_PREGUNTAS_ID")
	public TrsGrupoPreguntas getTrsGrupoPreguntasId() {
		return trsGrupoPreguntasId;
	}

	public void setTrsGrupoPreguntasId(TrsGrupoPreguntas trsGrupoPreguntasId) {
		this.trsGrupoPreguntasId = trsGrupoPreguntasId;
	}





	@Basic @Column(name = "CLAVE_PREGUNTAS", nullable = false, length = 50) public String getClavePreguntas() {
		return clavePreguntas;
	}

	public void setClavePreguntas(String clavePreguntas) {
		this.clavePreguntas = clavePreguntas;
	}

	@Basic @Column(name = "DESC_PREGUNTA", nullable = false, length = 150) public String getDescPregunta() {
		return descPregunta;
	}

	public void setDescPregunta(String descPregunta) {
		this.descPregunta = descPregunta;
	}

	@Basic @Column(name = "ORDEN", nullable = false, precision = 0) public long getOrden() {
		return orden;
	}

	public void setOrden(long orden) {
		this.orden = orden;
	}

	@Basic @Column(name = "DEFAULT_PREGUNTA", nullable = false, precision = 0) public long getDefaultPregunta() {
		return defaultPregunta;
	}

	public void setDefaultPregunta(long defaultPregunta) {
		this.defaultPregunta = defaultPregunta;
	}

	@Basic @Column(name = "ESTATUS", nullable = false, precision = 0) public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRS_PREGUNTAS_ID", nullable = false)

	public Integer getTrsPreguntasId() {
		return trsPreguntasId;
	}

	public void setTrsPreguntasId(Integer trsPreguntasId)
	{
		this.trsPreguntasId = trsPreguntasId;
	}

/*	@OneToMany(mappedBy = "trsPreguntas")
	@JsonIgnore
	public Set<TrsEstudioRespuestas> getTrsEstudioRespuestas() {
		return trsEstudioRespuestas;
	}

	public void setTrsEstudioRespuestas(Set<TrsEstudioRespuestas> trsEstudioRespuestas) {
		this.trsEstudioRespuestas = trsEstudioRespuestas;
	}*/

	public String toString(){
		return "OBJECT::"+this.hashCode()
				+" clavePreguntas::"+this.clavePreguntas
				+" descPregunta::"+this.descPregunta
				+" orden::"+this.orden
				+" defaultPregunta::"+this.defaultPregunta
				+" estatus::"+this.estatus
				+" fechaRegistro::"+this.fechaRegistro
				+" usuarioRegistro::"+this.usuarioRegistro
				+" trsPreguntasId::"+this.trsPreguntasId;
	}
}
