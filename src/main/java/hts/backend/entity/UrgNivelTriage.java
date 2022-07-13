package hts.backend.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "urg_nivel_triage")
@NamedQueries({
					  @NamedQuery(name = "UrgNivelTriage.getByEventoId", query = "" +
							  "select new map( " +
							  "		urgNivelTriage.nombre as nombreTriage, " +
							  "		urgNivelTriage.color as colorTriage " +
							  ") " +
							  "from BitacoraTriage bt join bt.urgNivelTriage urgNivelTriage " +
							  "where bt.eventoId =?0 " +
							  "  and bt.fechaRegistro = ( " +
							  "		select max(btr.fechaRegistro)" +
							  "		from BitacoraTriage btr " +
							  "		where btr.eventoId =?0 " +
							  ")"
					  )
			  })
public class UrgNivelTriage implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer nivelId;
	private String nombre;
	private String color;
	private Integer tmpoEspera;
	private Integer valorDefault;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Integer orden;

	private UrgGrupoNivel grupo;
	private Integer grupoId;

	private Set<UrgPreguntaTriage> preguntasTriage;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NIVEL_ID", nullable = false)
	public Integer getNivelId() {
		return nivelId;
	}

	public void setNivelId(Integer nivelId) {
		this.nivelId = nivelId;
	}

	@Basic
	@Column(name = "NOMBRE", nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Basic
	@Column(name = "COLOR", nullable = false)
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Basic
	@Column(name = "TMPO_ESPERA", nullable = false)
	public Integer getTmpoEspera() {
		return tmpoEspera;
	}

	public void setTmpoEspera(Integer tmpoEspera) {
		this.tmpoEspera = tmpoEspera;
	}

	@Basic
	@Column(name = "VALOR_DEFAULT", nullable = false)
	public Integer getValorDefault() {
		return valorDefault;
	}

	public void setValorDefault(Integer valorDefault) {
		this.valorDefault = valorDefault;
	}

	@Basic
	@Column(name = "ESTATUS", nullable = false)
	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
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
	@Column(name = "ORDEN", nullable = false)
	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
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
	@Column(name = "GRUPO_ID", nullable = false)
	public Integer getGrupoId() {
		return grupoId;
	}

	public void setGrupoId(Integer grupoId) {
		this.grupoId = grupoId;
	}


	@ManyToOne
	@JoinColumn(name = "GRUPO_ID", referencedColumnName = "GRUPO_ID", insertable = false, updatable = false)
	public UrgGrupoNivel getGrupo() {
		return grupo;
	}

	public void setGrupo(UrgGrupoNivel urgGrupoNivelByGrupoId) {
		this.grupo = urgGrupoNivelByGrupoId;
	}


	@OneToMany(mappedBy = "nivel")
	public Set<UrgPreguntaTriage> getPreguntasTriage() {
		return preguntasTriage;
	}

	public void setPreguntasTriage(Set<UrgPreguntaTriage> urgPreguntaTriagesByNivelId) {
		this.preguntasTriage = urgPreguntaTriagesByNivelId;
	}


}
