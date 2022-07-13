package hts.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import hts.backend.entity.CatNanda;
import hts.backend.entity.CorePceGrupoEvento;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "core_pce_grupo_evento_nanda")
@NamedQueries({
					  @NamedQuery(name = "CorePceGrupoEventoNanda.getNandaByIdTree", query = "" +
							  "select new map( " +
							  "		cpgen.corePceGrupoEventoNandaId as corePceGrupoEventoNandaId, " +
							  "		cpgen.catNanda.cve as cve, " +
							  "		cpgen.catNanda.nombre as nombre, " +
							  "		cpgen.catNanda.descripcion as diagnostico, " +
							  "		cpgen.estatusPceId as estatusPceId, " +
							  "		cpgep.corePceGrupoEventoPlanId as corePceGrupoEventoPlanId, " +
							  "		cpgep.estatusPceId as interrumpirStatusParent " +
							  ") " +
							  "from CorePceGrupoEventoNanda cpgen join cpgen.corePceGrupoEventoPlan cpgep " +
							  "where cpgep.corePceGrupoEventoPlanId =?0 " +
							  "and cpgen.estatus =  1"
					  )
			  })
public class CorePceGrupoEventoNanda extends CorePceGrupoEvento implements java.io.Serializable {
	private Integer corePceGrupoEventoNandaId;
	private CatNanda catNanda;
	private Integer estatusPceId;
	private Integer estatus;
	private String usuarioEliminacion;
	private Date fechaEliminacion;

	private String usuarioRegistro;
	private Date fechaRegistro;


	public CorePceGrupoEventoNanda() {
		this.estatus = 1;
	}


	@JsonBackReference(value = "condCorePceGrupoEventoPlanToCorePceGrupoEventoNanda")
	private CorePceGrupoEventoPlan corePceGrupoEventoPlan;
	@JsonManagedReference(value = "condCorePceGrupoEventoNandaToCorePceGrupoEventoNoc")
	private Set<CorePceGrupoEventoNoc> corePceGrupoEventoNoc;

	@Id
	@Column(name = "CORE_PCE_GRUPO_EVENTO_NANDA_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCorePceGrupoEventoNandaId() {
		return corePceGrupoEventoNandaId;
	}

	public void setCorePceGrupoEventoNandaId(Integer corePceGrupoEventoNandaId) {
		this.corePceGrupoEventoNandaId = corePceGrupoEventoNandaId;
		super.setId(corePceGrupoEventoNandaId);
	}

	@ManyToOne
	@JoinColumn(name = "NANDA_ID", referencedColumnName = "NANDA_ID")
	public CatNanda getCatNanda() {
		return catNanda;
	}

	public void setCatNanda(CatNanda catNanda) {
		this.catNanda = catNanda;
	}

	@ManyToOne
	@JoinColumn(name = "CORE_PCE_GRUPO_EVENTO_PLAN_ID", referencedColumnName = "CORE_PCE_GRUPO_EVENTO_PLAN_ID")
	public CorePceGrupoEventoPlan getCorePceGrupoEventoPlan() {
		return corePceGrupoEventoPlan;
	}

	public void setCorePceGrupoEventoPlan(CorePceGrupoEventoPlan corePceGrupoEventoPlan) {
		this.corePceGrupoEventoPlan = corePceGrupoEventoPlan;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "corePceGrupoEventoNanda")
	public Set<CorePceGrupoEventoNoc> getCorePceGrupoEventoNoc() {
		return corePceGrupoEventoNoc;
	}

	public void setCorePceGrupoEventoNoc(Set<CorePceGrupoEventoNoc> corePceGrupoEventoNoc) {
		this.corePceGrupoEventoNoc = corePceGrupoEventoNoc;
	}


	@Basic
	@Column(name = "ESTATUS_PCE_ID")
	public Integer getEstatusPceId() {
		return estatusPceId;
	}

	public void setEstatusPceId(Integer estatusPceId) {
		this.estatusPceId = estatusPceId;
	}


	@Basic
	@Column(name = "ESTATUS")
	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}


	@Basic
	@Column(name = "USUARIO_ELIMINACION")
	public String getUsuarioEliminacion() {
		return usuarioEliminacion;
	}

	public void setUsuarioEliminacion(String usuarioEliminacion) {
		this.usuarioEliminacion = usuarioEliminacion;
	}


	@Basic
	@Column(name = "FECHA_ELIMINACION")
	public Date getFechaEliminacion() {
		return fechaEliminacion;
	}

	public void setFechaEliminacion(Date fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}


	@Basic
	@Column(name = "USUARIO_REGISTRO")
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Basic
	@Column(name = "FECHA_REGISTRO")
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Override
	public String toString() {
		return "OBJECT::" + this.hashCode()
				+ " corePceGrupoEventoNandaId::" + this.corePceGrupoEventoNandaId
				+ " catNanda::" + this.catNanda
				+ " estatusPceId::" + this.estatusPceId
				+ " estatus::" + this.estatus
				+ " usuarioEliminacion::" + this.usuarioEliminacion
				+ " fechaEliminacion::" + this.fechaEliminacion
				+ " usuarioRegistro::" + this.usuarioRegistro
				+ " fechaRegistro::" + this.fechaRegistro
				;
	}
}
