package hts.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import hts.backend.entity.AdmHospital;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trs_grupo_preguntas")
@NamedQueries({
					  @NamedQuery(name = "TrsGrupoPreguntas.getGroupoPreguntasSeleccionadasTree", query = "" +
							  "select distinct trsGrupoPreguntas " +
							  "from TrsGrupoPreguntas as trsGrupoPreguntas " +
							  "join fetch  trsGrupoPreguntas.trsPreguntas as preguntas " +
							  "join fetch preguntas.trsRespuestas as respuestas " +
							  "join fetch respuestas.trsEstudioRespuestas as estudioRespuesta " +
							  "join fetch estudioRespuesta.trsCondicionesEconomicas as trsCondicionesEconomicas " +
							  "where trsGrupoPreguntas.estatus = 1 " +
							  "and preguntas.estatus = 1 " +
							  "and respuestas.estatus = 1 " +
							  "and trsCondicionesEconomicas.condicionesEconomicasId = ?0 "
					  ),
					  @NamedQuery(name = "TrsGrupoPreguntas.getGroupoPreguntasTree", query = "" +
							  "select distinct trsGrupoPreguntas " +
							  "from TrsGrupoPreguntas as trsGrupoPreguntas " +
							  "left join fetch  trsGrupoPreguntas.trsPreguntas as preguntas " +
							  "left join fetch  trsGrupoPreguntas.admHospitalByHospitalId as hospital " +
							  "left join fetch preguntas.trsRespuestas as respuestas " +
							  "where trsGrupoPreguntas.estatus = 1 " +
							  "and preguntas.estatus = 1 " +
							  "and respuestas.estatus = 1 " +
							  "and hospital.hospitalId = ?0  " +
							  "order by trsGrupoPreguntas.descGrupo asc"
					  )
			  })


public class TrsGrupoPreguntas implements java.io.Serializable {

	private static final long serialVersionUID = 3099407188269548480L;

	private Integer trsGrupoPreguntasId;
	@JsonIgnore
	private AdmHospital admHospitalByHospitalId;
	private String claveGrupo;
	private String descGrupo;
	private long ponderacion;
	@JsonIgnore
	private long defaultGrupo;
	@JsonIgnore
	private Integer estatus;
	@JsonIgnore
	private Date fechaRegistro;
/*	private Set<TrsEstudioRespuestas> trsEstudioRespuestas = new HashSet<TrsEstudioRespuestas>(0);*/


	/*JACKSON NO TOME ESTE MAPEO AL PASAR A JSON*/
	@JsonIgnore
	private String usuarioRegistro;


	/*QUITA EL ERROR StackOverflowError, SE USA JUNTO @JsonManagedReference EN TrsPreguntas*/
	@JsonManagedReference(value = "condGrupoPregToPreg")
	private Set<TrsPreguntas> trsPreguntas = new HashSet<TrsPreguntas>(0);


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trsGrupoPreguntasId")
	@OrderBy("descPregunta ASC")
	public Set<TrsPreguntas> getTrsPreguntas() {
		return trsPreguntas;
	}

	public void setTrsPreguntas(Set<TrsPreguntas> trsPreguntas) {
		this.trsPreguntas = trsPreguntas;
	}


	@Basic @Column(name = "CLAVE_GRUPO", nullable = false, length = 50, updatable = true) public String getClaveGrupo() {
		return claveGrupo;
	}

	public void setClaveGrupo(String claveGrupo) {
		this.claveGrupo = claveGrupo;
	}

	@Basic @Column(name = "DESC_GRUPO", nullable = false, length = 150) public String getDescGrupo() {
		return descGrupo;
	}

	public void setDescGrupo(String descGrupo) {
		this.descGrupo = descGrupo;
	}

	@Basic @Column(name = "PONDERACION", nullable = false, precision = 0) public long getPonderacion() {
		return ponderacion;
	}

	public void setPonderacion(long ponderacion) {
		this.ponderacion = ponderacion;
	}

	@Basic @Column(name = "DEFAULT_GRUPO", nullable = false, precision = 0) public long getDefaultGrupo() {
		return defaultGrupo;
	}

	public void setDefaultGrupo(long defaultGrupo) {
		this.defaultGrupo = defaultGrupo;
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

	@ManyToOne @JoinColumn(name = "HOSPITAL_ID", referencedColumnName = "HOSPITAL_ID") public hts.backend.entity.AdmHospital getAdmHospitalByHospitalId() {
		return admHospitalByHospitalId;
	}

	public void setAdmHospitalByHospitalId(hts.backend.entity.AdmHospital admHospitalByHospitalId) {
		this.admHospitalByHospitalId = admHospitalByHospitalId;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

/*	@OneToMany(mappedBy = "trsGrupoPreguntas")
	public Set<TrsEstudioRespuestas> getTrsEstudioRespuestas() {
		return trsEstudioRespuestas;
	}

	public void setTrsEstudioRespuestas(Set<TrsEstudioRespuestas> trsEstudioRespuestas) {
		this.trsEstudioRespuestas = trsEstudioRespuestas;
	}*/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRS_GRUPO_PREGUNTAS_ID", nullable = false, precision = 150) public Integer getTrsGrupoPreguntasId() {
		return trsGrupoPreguntasId;
	}

	public void setTrsGrupoPreguntasId(Integer trsGrupoPreguntasId) {
		this.trsGrupoPreguntasId = trsGrupoPreguntasId;
	}


	public String toString() {
		return "OBJECT::" + this.hashCode()
				+ " claveGrupo::" + this.claveGrupo
				+ " descGrupo::" + this.descGrupo
				+ " ponderacion::" + this.ponderacion
				+ " defaultGrupo::" + this.defaultGrupo
				+ " estatus::" + this.estatus
				+ " fechaRegistro::" + this.fechaRegistro
				+ " usuarioRegistro::" + this.usuarioRegistro
				+ " trsGrupoPreguntasId::" + this.trsGrupoPreguntasId;
	}

}
