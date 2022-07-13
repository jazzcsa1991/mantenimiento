package hts.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "trs_respuestas")
@NamedQueries({
					  @NamedQuery(name="TrsRespuestas.getPuntajeMasAltoPorPregunta",
								  query= "select max(trsRespuestas.puntaje) "
										  +"from TrsRespuestas as trsRespuestas "
										  +"where trsRespuestas.trsPreguntasId.trsPreguntasId = ?0"
					  )

			  })
public class TrsRespuestas implements java.io.Serializable {

	private static final long serialVersionUID = 1L;



	@JsonIgnore
	private String claveRespuesta;
	private String descripcionRespuesta;
	private long puntaje;
	private long defaultRespuestas;
	@JsonIgnore
	private long estatus;
	@JsonIgnore
	private Date fechaRegistro;
	@JsonIgnore
	private String usuarioRegistro;
	private Integer trsRespuestasId;
	@JsonBackReference(value="condPregToResp")
	private TrsPreguntas trsPreguntasId;
	@JsonManagedReference(value="condRespToEstudResp")
	private Set<TrsEstudioRespuestas> trsEstudioRespuestas = new HashSet<TrsEstudioRespuestas>(0);

	private boolean seleccionado=true;
	private Integer estudioRespuestasIdAsociado;



	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRS_PREGUNTAS_ID")
	public TrsPreguntas getTrsPreguntasId() {
		return trsPreguntasId;
	}

	public void setTrsPreguntasId(TrsPreguntas trsPreguntasId) {
		this.trsPreguntasId = trsPreguntasId;
	}


	@Basic @Column(name = "CLAVE_RESPUESTA", nullable = false, length = 50) public String getClaveRespuesta() {
		return claveRespuesta;
	}

	public void setClaveRespuesta(String claveRespuesta) {
		this.claveRespuesta = claveRespuesta;
	}

	@Basic @Column(name = "DESCRIPCION_RESPUESTA", nullable = false, length = 150) public String getDescripcionRespuesta() {
		return descripcionRespuesta;
	}

	public void setDescripcionRespuesta(String descripcionRespuesta) {
		this.descripcionRespuesta = descripcionRespuesta;
	}

	@Basic @Column(name = "PUNTAJE", nullable = false, precision = 0) public long getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(long puntaje) {
		this.puntaje = puntaje;
	}

	@Basic @Column(name = "DEFAULT_RESPUESTAS", nullable = false, precision = 0) public long getDefaultRespuestas() {
		return defaultRespuestas;
	}

	public void setDefaultRespuestas(long defaultRespuestas) {
		this.defaultRespuestas = defaultRespuestas;
	}

	@Basic @Column(name = "ESTATUS", nullable = false, precision = 0) public long getEstatus() {
		return estatus;
	}

	public void setEstatus(long estatus) {
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
	@Column(name = "TRS_RESPUESTAS_ID", nullable = false)
	public Integer getTrsRespuestasId() {
		return trsRespuestasId;
	}

	public void setTrsRespuestasId(Integer trsRespuestasId) {
		this.trsRespuestasId = trsRespuestasId;
	}


	@OneToMany(mappedBy = "trsRespuestas")

	public Set<TrsEstudioRespuestas> getTrsEstudioRespuestas() {
		return trsEstudioRespuestas;
	}

	public void setTrsEstudioRespuestas(Set<TrsEstudioRespuestas> trsEstudioRespuestas) {
		this.trsEstudioRespuestas = trsEstudioRespuestas;
	}

	//Transient
	@Transient
	public boolean isSeleccionado() {
		return seleccionado;
	}
	@Transient
	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}
	@Transient
	public Integer getEstudioRespuestasIdAsociado() {
		return estudioRespuestasIdAsociado;
	}
	@Transient
	public void setEstudioRespuestasIdAsociado(Integer estudioRespuestasIdAsociado) {
		this.estudioRespuestasIdAsociado = estudioRespuestasIdAsociado;
	}

	//Transient
	public String toString(){
		return "OBJECT::"+this.hashCode()
				+" trsRespuestasId::"+this.trsRespuestasId
				+" claveRespuesta::"+this.claveRespuesta
				+" descripcionRespuesta::"+this.descripcionRespuesta
				+" puntaje::"+this.puntaje
				+" defaultRespuestas::"+this.defaultRespuestas
				+" estatus::"+this.estatus
				+" fechaRegistro::"+this.fechaRegistro
				+" usuarioRegistro::"+this.usuarioRegistro
				+" trsPreguntasId::"+this.trsPreguntasId;


	}
}
