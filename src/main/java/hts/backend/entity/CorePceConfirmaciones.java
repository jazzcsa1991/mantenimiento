package hts.backend.entity;

import hts.backend.entity.AdmTurnos;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "core_pce_confirmaciones")
public class CorePceConfirmaciones implements java.io.Serializable {
	private Integer pceConfirmacionId;
	private Integer estatus;
	private String usuarioRegistro;
	private Date fechaRegistro;
	private String usuarioAnulacion;
	private Date fechaAnulacion;

	private CorePceGrupoEventoNic corePceGrupoEventoNic;
	private Integer pceGrupoEventoNicId;

	private AdmTurnos admTurnos;
	private Integer turnoId;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PCE_CONFIRMACION_ID", nullable = false, unique = true)
	public Integer getPceConfirmacionId() {
		return pceConfirmacionId;
	}

	public void setPceConfirmacionId(Integer pceConfirmacionId) {
		this.pceConfirmacionId = pceConfirmacionId;
	}


	@Basic
	@Column(name = "PCE_GRUPO_EVENTO_NIC_ID", nullable = false)
	public Integer getPceGrupoEventoNicId() {
		return pceGrupoEventoNicId;
	}

	public void setPceGrupoEventoNicId(Integer pceGrupoEventoNicId) {
		this.pceGrupoEventoNicId = pceGrupoEventoNicId;
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
	@Column(name = "TURNO_ID", nullable = false)
	public Integer getTurnoId() {
		return turnoId;
	}

	public void setTurnoId(Integer turnoId) {
		this.turnoId = turnoId;
	}


	@Basic
	@Column(name = "USUARIO_ANULACION", nullable = false)
	public String getUsuarioAnulacion() {
		return usuarioAnulacion;
	}

	public void setUsuarioAnulacion(String usuarioAnulacion) {
		this.usuarioAnulacion = usuarioAnulacion;
	}


	@Basic
	@Column(name = "FECHA_ANULACION", nullable = false)
	public Date getFechaAnulacion() {
		return fechaAnulacion;
	}

	public void setFechaAnulacion(Date fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
	}


	@ManyToOne
	@JoinColumn(name = "PCE_GRUPO_EVENTO_NIC_ID", referencedColumnName = "CORE_PCE_GRUPO_EVENTO_NIC_ID", insertable = false, updatable = false)
	public CorePceGrupoEventoNic getCorePceGrupoEventoNic() {
		return corePceGrupoEventoNic;
	}

	public void setCorePceGrupoEventoNic(CorePceGrupoEventoNic corePceGrupoEventoNic) {
		this.corePceGrupoEventoNic = corePceGrupoEventoNic;
	}


	@ManyToOne
	@JoinColumn(name = "TURNO_ID", referencedColumnName = "TURNOS_ID", insertable = false, updatable = false)
	public AdmTurnos getAdmTurnos() {
		return admTurnos;
	}

	public void setAdmTurnos(AdmTurnos admTurnos) {
		this.admTurnos = admTurnos;
	}
}
