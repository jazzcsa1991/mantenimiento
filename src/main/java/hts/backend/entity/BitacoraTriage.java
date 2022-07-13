package hts.backend.entity;



import hts.backend.entity.PacEvento;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "urg_bitacora_triage")
public class BitacoraTriage implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer bitacoraId;
	private Integer eventoId;
	private Integer grupoId;
	private Integer tipoCapturaId;
	private Integer nivelId;
	private UrgNivelTriage urgNivelTriage;
	private PacEvento pacEvento;
	private UrgGrupoNivel urgGrupoNivel;
	private CatTipoCaptura catTipoCaptura;

	private Date fechaRegistro;
	private String usuarioRegistro;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BITACORA_ID", nullable = false, unique = true)
	public Integer getBitacoraId() {
		return bitacoraId;
	}

	public void setBitacoraId(Integer bitacoraId) {
		this.bitacoraId = bitacoraId;
	}

	@Basic
	@Column(name = "EVENTO_ID", nullable = false)
	public Integer getEventoId() {
		return eventoId;
	}

	public void setEventoId(Integer eventoId) {
		this.eventoId = eventoId;
	}

	@Basic
	@Column(name = "GRUPO_ID", nullable = false)
	public Integer getGrupoId() {
		return grupoId;
	}

	public void setGrupoId(Integer grupoId) {
		this.grupoId = grupoId;
	}

	@Basic
	@Column(name = "TIPO_CAPTURA_ID", nullable = false)
	public Integer getTipoCapturaId() {
		return tipoCapturaId;
	}

	public void setTipoCapturaId(Integer tipoCapturaId) {
		this.tipoCapturaId = tipoCapturaId;
	}

	@ManyToOne
	@JoinColumn(name = "EVENTO_ID", referencedColumnName = "EVENTO_ID", insertable = false, updatable = false)
	public PacEvento getPacEvento() {
		return pacEvento;
	}

	public void setPacEvento(PacEvento pacEvento) {
		this.pacEvento = pacEvento;
	}

	@ManyToOne
	@JoinColumn(name = "GRUPO_ID", referencedColumnName = "GRUPO_ID", insertable = false, updatable = false)
	public UrgGrupoNivel getUrgGrupoNivel() {
		return urgGrupoNivel;
	}

	public void setUrgGrupoNivel(UrgGrupoNivel urgGrupoNivel) {
		this.urgGrupoNivel = urgGrupoNivel;
	}

	@ManyToOne
	@JoinColumn(name = "TIPO_CAPTURA_ID", referencedColumnName = "TIPO_CAPTURA_ID", insertable = false, updatable = false)
	public CatTipoCaptura getCatTipoCaptura() {
		return catTipoCaptura;
	}

	public void setCatTipoCaptura(CatTipoCaptura catTipoCaptura) {
		this.catTipoCaptura = catTipoCaptura;
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
	@Column(name = "USUARIO_REGISTRO", nullable = false)
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Basic
	@Column(name = "NIVEL_ID")
	public Integer getNivelId() {
		return nivelId;
	}

	public void setNivelId(Integer nivelId) {
		this.nivelId = nivelId;
	}

	@ManyToOne
	@JoinColumn(name = "NIVEL_ID", referencedColumnName = "NIVEL_ID", insertable = false, updatable = false)
	public UrgNivelTriage getUrgNivelTriage() {
		return urgNivelTriage;
	}

	public void setUrgNivelTriage(UrgNivelTriage urgNivelTriage) {
		this.urgNivelTriage = urgNivelTriage;
	}
}
