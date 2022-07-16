package hts.backend.entity;

import hts.backend.entity.*;
import hts.backend.entity.AdmPersonal;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by SASA Desarrollo on 18/08/2017.
 */
@Entity
@Table(name = "hsp_datos_parto")
public class HspDatosParto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer datosPartoId;
	private Integer periodoGestacion;
	private Integer numeroProducto;
	private Integer prematuro;
	private Integer aTermino;
	private String especifiqueForceps;
	private String especifiquePersonal;
	private Date fechaRegistro;
	private String usuarioRegistro;


	private NomCatProcedimientoNac nomCatProcedimientoNac;
	private Integer procedimientoNacId;
	private NomCatTipoProducto nomCatTipoProducto;
	private Integer tipoProductoId;
	private AdmPersonal admPersonal;
	private Integer admProfSaludGralId;
	private NomCatForceps nomCatForceps;
	private Integer forcepsId;
	private NomCatAtendidoParto nomCatAtendidoParto;
	private Integer atendidoPartoId;
	private NomCatLugarNac nomCatLugarNac;
	private Integer lugarNacId;
	private PacEvento pacEvento;
	private Integer eventoId;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DATOS_PARTO_ID")
	public Integer getDatosPartoId() {
		return datosPartoId;
	}

	public void setDatosPartoId(Integer datosPartoId) {
		this.datosPartoId = datosPartoId;
	}

	@Basic @Column(name = "PERIODO_GESTACION") public Integer getPeriodoGestacion() {
		return periodoGestacion;
	}

	public void setPeriodoGestacion(Integer periodoGestacion) {
		this.periodoGestacion = periodoGestacion;
	}

	@Basic @Column(name = "NUMERO_PRODUCTO") public Integer getNumeroProducto() {
		return numeroProducto;
	}

	public void setNumeroProducto(Integer numeroProducto) {
		this.numeroProducto = numeroProducto;
	}

	@Basic @Column(name = "PREMATURO") public Integer getPrematuro() {
		return prematuro;
	}

	public void setPrematuro(Integer prematuro) {
		this.prematuro = prematuro;
	}

	@Basic @Column(name = "A_TERMINO") public Integer getaTermino() {
		return aTermino;
	}

	public void setaTermino(Integer aTermino) {
		this.aTermino = aTermino;
	}

	@Basic @Column(name = "ESPECIFIQUE_FORCEPS") public String getEspecifiqueForceps() {
		return especifiqueForceps;
	}

	public void setEspecifiqueForceps(String especifiqueForceps) {
		this.especifiqueForceps = especifiqueForceps;
	}

	@Basic @Column(name = "ESPECIFIQUE_PERSONAL") public String getEspecifiquePersonal() {
		return especifiquePersonal;
	}

	public void setEspecifiquePersonal(String especifiquePersonal) {
		this.especifiquePersonal = especifiquePersonal;
	}

	@Basic @Column(name = "FECHA_REGISTRO") public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO") public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}


	@ManyToOne @JoinColumn(name = "PROCEDIMIENTO_NAC_ID", nullable = false, insertable = false, updatable = false)
	public NomCatProcedimientoNac getNomCatProcedimientoNac() {
		return nomCatProcedimientoNac;
	}

	public void setNomCatProcedimientoNac(NomCatProcedimientoNac nomCatProcedimientoNac) {
		this.nomCatProcedimientoNac = nomCatProcedimientoNac;
	}

	@ManyToOne @JoinColumn(name = "TIPO_PRODUCTO_ID", nullable = false, insertable = false, updatable = false)
	public NomCatTipoProducto getNomCatTipoProducto() {
		return nomCatTipoProducto;
	}

	public void setNomCatTipoProducto(NomCatTipoProducto nomCatTipoProducto) {
		this.nomCatTipoProducto = nomCatTipoProducto;
	}

	@ManyToOne @JoinColumn(name = "ADM_PROF_SALUD_GRAL_ID", nullable = false, insertable = false, updatable = false)
	public AdmPersonal getAdmPersonal() {
		return admPersonal;
	}

	public void setAdmPersonal(AdmPersonal admPersonal) {
		this.admPersonal = admPersonal;
	}

	@ManyToOne @JoinColumn(name = "FORCEPS_ID", nullable = false, insertable = false, updatable = false)
	public NomCatForceps getNomCatForceps() {
		return nomCatForceps;
	}

	public void setNomCatForceps(NomCatForceps nomCatForceps) {
		this.nomCatForceps = nomCatForceps;
	}

	@ManyToOne @JoinColumn(name = "ATENDIDO_PARTO_ID", nullable = false, insertable = false, updatable = false)
	public NomCatAtendidoParto getNomCatAtendidoParto() {
		return nomCatAtendidoParto;
	}

	public void setNomCatAtendidoParto(NomCatAtendidoParto nomCatAtendidoParto) {
		this.nomCatAtendidoParto = nomCatAtendidoParto;
	}

	@ManyToOne @JoinColumn(name = "LUGAR_NAC_ID", nullable = false, insertable = false, updatable = false)
	public NomCatLugarNac getNomCatLugarNac() {
		return nomCatLugarNac;
	}

	public void setNomCatLugarNac(NomCatLugarNac nomCatLugarNac) {
		this.nomCatLugarNac = nomCatLugarNac;
	}

	@Column(name = "PROCEDIMIENTO_NAC_ID")
	public Integer getProcedimientoNacId() {
		return procedimientoNacId;
	}

	public void setProcedimientoNacId(Integer procedimientoNacId) {
		this.procedimientoNacId = procedimientoNacId;
	}

	@Column(name = "TIPO_PRODUCTO_ID")
	public Integer getTipoProductoId() {
		return tipoProductoId;
	}

	public void setTipoProductoId(Integer tipoProductoId) {
		this.tipoProductoId = tipoProductoId;
	}

	@Column(name = "ADM_PROF_SALUD_GRAL_ID")
	public Integer getAdmProfSaludGralId() {
		return admProfSaludGralId;
	}

	public void setAdmProfSaludGralId(Integer admProfSaludGralId) {
		this.admProfSaludGralId = admProfSaludGralId;
	}

	@Column(name = "FORCEPS_ID")
	public Integer getForcepsId() {
		return forcepsId;
	}

	public void setForcepsId(Integer forcepsId) {
		this.forcepsId = forcepsId;
	}

	@Column(name = "ATENDIDO_PARTO_ID")
	public Integer getAtendidoPartoId() {
		return atendidoPartoId;
	}

	public void setAtendidoPartoId(Integer atendidoPartoId) {
		this.atendidoPartoId = atendidoPartoId;
	}

	@Column(name = "LUGAR_NAC_ID")
	public Integer getLugarNacId() {
		return lugarNacId;
	}

	public void setLugarNacId(Integer lugarNacId) {
		this.lugarNacId = lugarNacId;
	}


	@ManyToOne @JoinColumn(name = "EVENTO_ID", nullable = false, insertable = false, updatable = false)

	public PacEvento getPacEvento() {
		return pacEvento;
	}

	public void setPacEvento(PacEvento pacEvento) {
		this.pacEvento = pacEvento;
	}

	@Column(name = "EVENTO_ID")
	public Integer getEventoId() {
		return eventoId;
	}

	public void setEventoId(Integer eventoId) {
		this.eventoId = eventoId;
	}
}
