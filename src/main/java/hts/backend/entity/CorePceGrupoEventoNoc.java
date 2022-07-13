package hts.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import hts.backend.entity.CatNoc;
import hts.backend.entity.CorePceGrupoEvento;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "core_pce_grupo_evento_noc")
@NamedQueries({
					  @NamedQuery(name = "CorePceGrupoEventoNoc.getNocByIdTree", query = "" +
							  "select new map( " +
							  "		cpgenoc.corePceGrupoEventoNocId as corePceGrupoEventoNocId, " +
							  "		cpgenoc.catNoc.cve as cve, " +
							  "		cpgenoc.catNoc.nombre as nombre, " +
							  "		cpgenoc.catNoc.descripcion as diagnostico, " +
							  "		cpgenoc.estatusPceId as estatusPceId, " +
							  "		cpgenanda.corePceGrupoEventoNandaId as corePceGrupoEventoNandaId, " +
							  "		cpgenanda.estatusPceId as interrumpirStatusParent " +
							  ") " +
							  "from CorePceGrupoEventoNoc cpgenoc join cpgenoc.corePceGrupoEventoNanda cpgenanda  " +
							  "where cpgenanda.corePceGrupoEventoNandaId =?0 " +
							  "and cpgenoc.estatus = 1 "
					  )
			  })
public class CorePceGrupoEventoNoc extends CorePceGrupoEvento implements java.io.Serializable {
	private Integer corePceGrupoEventoNocId;
	private CatNoc catNoc;
	private Integer estatusPceId;
	private Integer estatus;
	private String usuarioEliminacion;
	private Date fechaEliminacion;

	private String usuarioRegistro;
	private Date fechaRegistro;

	public CorePceGrupoEventoNoc() {
		this.estatus = 1;
	}


	@JsonManagedReference(value = "condCorePceGrupoEventoNocToCorePceGrupoEventoNic")
	private Set<CorePceGrupoEventoNic> corePceGrupoEventoNic;
	@JsonBackReference(value = "condCorePceGrupoEventoNandaToCorePceGrupoEventoNoc")
	private CorePceGrupoEventoNanda corePceGrupoEventoNanda;

	@Id
	@Column(name = "CORE_PCE_GRUPO_EVENTO_NOC_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCorePceGrupoEventoNocId() {
		return corePceGrupoEventoNocId;
	}

	public void setCorePceGrupoEventoNocId(Integer corePceGrupoEventoNocId) {
		this.corePceGrupoEventoNocId = corePceGrupoEventoNocId;
		super.setId(corePceGrupoEventoNocId);
	}

	@ManyToOne
	@JoinColumn(name = "NOC_ID", referencedColumnName = "NOC_ID")
	public CatNoc getCatNoc() {
		return catNoc;
	}

	public void setCatNoc(CatNoc catNoc) {
		this.catNoc = catNoc;
	}

	@ManyToOne
	@JoinColumn(name = "CORE_PCE_GRUPO_EVENTO_NANDA_ID", referencedColumnName = "CORE_PCE_GRUPO_EVENTO_NANDA_ID")
	public CorePceGrupoEventoNanda getCorePceGrupoEventoNanda() {
		return corePceGrupoEventoNanda;
	}

	public void setCorePceGrupoEventoNanda(CorePceGrupoEventoNanda corePceGrupoEventoNanda) {
		this.corePceGrupoEventoNanda = corePceGrupoEventoNanda;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "corePceGrupoEventoNoc")
	public Set<CorePceGrupoEventoNic> getCorePceGrupoEventoNic() {
		return corePceGrupoEventoNic;
	}

	public void setCorePceGrupoEventoNic(Set<CorePceGrupoEventoNic> corePceGrupoEventoNic) {
		this.corePceGrupoEventoNic = corePceGrupoEventoNic;
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
	public String getUsuarioRegistro() {return usuarioRegistro;}

	public void setUsuarioRegistro(String usuarioRegistro) {this.usuarioRegistro = usuarioRegistro;}

	@Basic
	@Column(name = "FECHA_REGISTRO")
	public Date getFechaRegistro() {return fechaRegistro;}

	public void setFechaRegistro(Date fechaRegistro) {this.fechaRegistro = fechaRegistro;}

	@Override
	public String toString() {
		return "OBJECT::" + this.hashCode()
				+ " corePceGrupoEventoNocId::" + this.corePceGrupoEventoNocId
				+ " catNoc::" + this.catNoc
				+ " estatusPceId::" + this.estatusPceId
				+ " estatus::" + this.estatus
				+ " usuarioEliminacion::" + this.usuarioEliminacion
				+ " fechaEliminacion::" + this.fechaEliminacion
				+ " usuarioRegistro::" + this.usuarioRegistro
				+ " fechaRegistro::" + this.fechaRegistro
				;
	}
}
