package hts.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hts.backend.entity.CatNic;
import hts.backend.entity.CorePceGrupoEvento;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "core_pce_grupo_evento_nic")
@NamedQueries({
					  @NamedQuery(name = "CorePceGrupoEventoNic.getNicByIdTree", query = "" +
							  "select new map( " +
							  "		cpgenic.corePceGrupoEventoNicId as corePceGrupoEventoNicId, " +
							  "		cpgenic.catNic.cve as cve, " +
							  "		cpgenic.catNic.nombre as nombre, " +
							  "		cpgenic.catNic.descripcion as diagnostico, " +
							  "		cpgenic.estatusPceId as estatusPceId, " +
							  "		cpgenoc.corePceGrupoEventoNocId as corePceGrupoEventoNocId, " +
							  "		cpgenoc.estatusPceId as interrumpirStatusParent " +
							  ") " +
							  "from CorePceGrupoEventoNic cpgenic join cpgenic.corePceGrupoEventoNoc cpgenoc " +
							  "where cpgenoc.corePceGrupoEventoNocId =?0 " +
							  "and cpgenic.estatus =1 "
					  )
			  })
public class CorePceGrupoEventoNic extends CorePceGrupoEvento implements java.io.Serializable {
	private Integer corePceGrupoEventoNicId;
	private CatNic catNic;
	private Integer estatusPceId;
	private Integer estatus;
	private String usuarioEliminacion;
	private Date fechaEliminacion;

	private String usuarioRegistro;
	private Date fechaRegistro;

	public CorePceGrupoEventoNic() {
		this.estatus = 1;
	}


	@JsonBackReference(value = "condCorePceGrupoEventoNocToCorePceGrupoEventoNic")
	private CorePceGrupoEventoNoc corePceGrupoEventoNoc;
	private Set<CorePceConfirmaciones> corePceConfirmaciones;

	@Id
	@Column(name = "CORE_PCE_GRUPO_EVENTO_NIC_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCorePceGrupoEventoNicId() {
		return corePceGrupoEventoNicId;
	}

	public void setCorePceGrupoEventoNicId(Integer corePceGrupoEventoNicId) {
		this.corePceGrupoEventoNicId = corePceGrupoEventoNicId;
		super.setId(corePceGrupoEventoNicId);
	}

	@ManyToOne
	@JoinColumn(name = "NIC_ID", referencedColumnName = "NIC_ID")
	public CatNic getCatNic() {
		return catNic;
	}

	public void setCatNic(CatNic catNic) {
		this.catNic = catNic;
	}

	@ManyToOne
	@JoinColumn(name = "CORE_PCE_GRUPO_EVENTO_NOC_ID", referencedColumnName = "CORE_PCE_GRUPO_EVENTO_NOC_ID")
	public CorePceGrupoEventoNoc getCorePceGrupoEventoNoc() {
		return corePceGrupoEventoNoc;
	}

	public void setCorePceGrupoEventoNoc(CorePceGrupoEventoNoc corePceGrupoEventoNoc) {
		this.corePceGrupoEventoNoc = corePceGrupoEventoNoc;
	}

	@OneToMany(mappedBy = "corePceGrupoEventoNic")
	public Set<CorePceConfirmaciones> getCorePceConfirmaciones() {
		return corePceConfirmaciones;
	}

	public void setCorePceConfirmaciones(Set<CorePceConfirmaciones> corePceConfirmaciones) {
		this.corePceConfirmaciones = corePceConfirmaciones;
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
				+ " corePceGrupoEventoNicId::" + this.corePceGrupoEventoNicId
				+ " catNic::" + this.catNic
				+ " estatusPceId::" + this.estatusPceId
				+ " estatus::" + this.estatus
				+ " usuarioEliminacion::" + this.usuarioEliminacion
				+ " fechaEliminacion::" + this.fechaEliminacion
				+ " usuarioRegistro::" + this.usuarioRegistro
				+ " fechaRegistro::" + this.fechaRegistro
				;
	}
}
