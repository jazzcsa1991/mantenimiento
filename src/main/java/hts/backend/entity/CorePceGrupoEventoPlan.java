package hts.backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import hts.backend.entity.CorePce;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

/**
 * Created by Rodrigo Davalos on 17/08/2017.
 */
@Entity
@Table(name = "core_pce_grupo_evento_plan")

public class CorePceGrupoEventoPlan implements java.io.Serializable{
	private Integer corePceGrupoEventoPlanId;
	private Integer eventoId;
	private Date fechaInicio;
	private Date fechaFin;
	private Integer estatusPceId;
	private String usuarioRegistro;
	@JsonManagedReference(value="condCorePceGrupoEventoPlanToCorePce")
	private CorePce corePce;
	@JsonManagedReference(value="condCorePceGrupoEventoPlanToCorePceGrupoEventoNanda")
	private Set<CorePceGrupoEventoNanda> corePceGrupoEventoNanda;

	private Date fechaRegistro;

	@Id @Column(name = "CORE_PCE_GRUPO_EVENTO_PLAN_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCorePceGrupoEventoPlanId() {
		return corePceGrupoEventoPlanId;
	}

	public void setCorePceGrupoEventoPlanId(Integer corePceGrupoEventoPlanId) {
		this.corePceGrupoEventoPlanId = corePceGrupoEventoPlanId;
	}

	@ManyToOne @JoinColumn(name = "CORE_PCE_ID") public CorePce getCorePce() {
		return corePce;
	}

	public void setCorePce(CorePce corePce) {
		this.corePce = corePce;
	}


	@OneToMany(cascade=CascadeType.ALL,mappedBy = "corePceGrupoEventoPlan")
	public Set<CorePceGrupoEventoNanda> getCorePceGrupoEventoNanda() {
		return corePceGrupoEventoNanda;
	}

	public void setCorePceGrupoEventoNanda(Set<CorePceGrupoEventoNanda> corePceGrupoEventoNanda) {
		this.corePceGrupoEventoNanda = corePceGrupoEventoNanda;
	}

	@Basic @Column(name = "EVENTO_ID") public Integer getEventoId() {
		return eventoId;
	}

	public void setEventoId(Integer eventoId) {
		this.eventoId = eventoId;
	}

	@Basic @Column(name = "FECHA_INICIO") public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Basic @Column(name = "FECHA_FIN") public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Basic @Column(name = "ESTATUS_PCE_ID") public Integer getEstatusPceId() {
		return estatusPceId;
	}

	public void setEstatusPceId(Integer estatusPceId) {
		this.estatusPceId = estatusPceId;
	}

	@Basic @Column(name = "USUARIO_REGISTRO") public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}


	@Basic
	@Column(name = "FECHA_REGISTRO")
	public Date getFechaRegistro() {return fechaRegistro;}

	public void setFechaRegistro(Date fechaRegistro) {this.fechaRegistro = fechaRegistro;}

	@Override public String toString() {
		return "OBJECT::"+this.hashCode()
				+" corePceGrupoEventoPlanId::"+this.corePceGrupoEventoPlanId
				+" eventoId::"+this.eventoId
				+" fechaInicio::"+this.fechaInicio
				+" fechaFin::"+this.fechaFin
				+" estatusPceId::"+this.estatusPceId
				+" usuarioRegistro::"+this.usuarioRegistro
				+" fechaRegistro::" + this.fechaRegistro;
	}

}
