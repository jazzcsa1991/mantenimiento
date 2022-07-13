package hts.backend.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "urg_pregunta_triage")
public class UrgPreguntaTriage implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer preguntaNivelId;

	private CatTriagePregunta catTriagePregunta;
	private Integer preguntaId;

	private UrgNivelTriage nivel;
	private Integer nivelId;

	private String usuarioRegistro;
	private Date fechaRegistro;
	private Integer estatus;






	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PREGUNTA_NIVEL_ID", nullable = false, unique = true)
	public Integer getPreguntaNivelId() {
		return preguntaNivelId;
	}

	public void setPreguntaNivelId(Integer preguntaNivelId) {
		this.preguntaNivelId = preguntaNivelId;
	}


	@Basic
	@Column(name = "PREGUNTA_ID", nullable = false)
	public Integer getPreguntaId() {
		return preguntaId;
	}

	public void setPreguntaId(Integer preguntaId) {
		this.preguntaId = preguntaId;
	}


	@ManyToOne
	@JoinColumn(name = "PREGUNTA_ID", referencedColumnName = "TRIAGE_PREGUNTA_ID", updatable = false, insertable = false)
	public CatTriagePregunta getCatTriagePregunta() {
		return catTriagePregunta;
	}

	public void setCatTriagePregunta(CatTriagePregunta catTriagePregunta) {
		this.catTriagePregunta = catTriagePregunta;
	}


	@Basic
	@Column(name = "NIVEL_ID", nullable = false)
	public Integer getNivelId() {
		return nivelId;
	}

	public void setNivelId(Integer nivelId) {
		this.nivelId = nivelId;
	}


	@ManyToOne
	@JoinColumn(name = "NIVEL_ID", referencedColumnName = "NIVEL_ID", updatable = false, insertable = false)
	public UrgNivelTriage getNivel() {
		return nivel;
	}

	public void setNivel(UrgNivelTriage urgNivelTriageByNivelId) {
		this.nivel = urgNivelTriageByNivelId;
	}


	@Basic
	@Column(name = "USUARIO_REGISTRO", nullable = false)
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}


	@Basic
	@Column(name = "FECHA_REGISTRO", nullable = false)
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic
	@Column(name = "ESTATUS", nullable = false)
	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}







}
