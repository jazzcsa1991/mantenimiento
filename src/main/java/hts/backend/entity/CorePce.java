package hts.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hts.backend.entity.CorePceGrupoEventoPlan;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Francisco Toscano on 04/08/2017.  select distinct cp from CorePce cp join fetch cp.corePceGrupos cpg where cpg.hospitalId=1
 */
@Entity
@Table(name = "core_pce")
@NamedQueries({
					  @NamedQuery(name = "CorePce.listarCorePceGrupo", query = "" +
							  "select distinct cp " +
							  "from CorePce cp join fetch cp.corePceGrupos cpg " +
							  "where cpg.hospitalId=?0 "+
							  "and cp.estatus=  1 "
					  ),
					  @NamedQuery(name = "CorePce.CorePceGrupoEventoPlan", query = "" +
							  "select new map( " +
							  "		cpgep.corePceGrupoEventoPlanId as corePceGrupoEventoPlanId, " +
							  "		cp.cve as cve, " +
							  "		cp.nombre as nombre, " +
							  "		cpgep.fechaInicio as fechaInicio," +
							  "		cpgep.fechaFin as fechaFin, " +
							  "		cpgep.usuarioRegistro as usuarioRegistro, " +
							  "		cpgep.estatusPceId as estatusPceId " +
							  ")" +
							  "from CorePce cp join cp.corePceGrupoEventoPlanes cpgep " +
							  "where cpgep.eventoId=?0"
					  )
			  })

public class CorePce implements java.io.Serializable {
	private Integer corePceId;
	private String cve;
	private String nombre;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private String usuarioEliminacion;
	private Date fechaEliminacion;



	@JsonBackReference(value = "condCorePceGrupoToCorePce")
	private Set<CorePceGrupo> corePceGrupos = new HashSet<>();
	@JsonBackReference(value = "condCorePceGrupoEventoPlanToCorePce")
	private Set<CorePceGrupoEventoPlan> corePceGrupoEventoPlanes = new HashSet<>();

	@Id
	@Column(name = "CORE_PCE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCorePceId() {
		return corePceId;
	}

	public void setCorePceId(Integer corePceId) {
		this.corePceId = corePceId;
	}

	@OneToMany(mappedBy = "corePce")
	public Set<CorePceGrupoEventoPlan> getCorePceGrupoEventoPlanes() {
		return corePceGrupoEventoPlanes;
	}

	public void setCorePceGrupoEventoPlanes(Set<CorePceGrupoEventoPlan> corePceGrupoEventoPlanes) {
		this.corePceGrupoEventoPlanes = corePceGrupoEventoPlanes;
	}

	@Basic
	@Column(name = "CVE")
	public String getCve() {
		return cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	@Basic
	@Column(name = "NOMBRE")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	@Column(name = "FECHA_REGISTRO")
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic
	@Column(name = "USUARIO_REGISTRO")
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "corePce")
	public Set<CorePceGrupo> getCorePceGrupos() {
		return corePceGrupos;
	}

	public void setCorePceGrupos(Set<CorePceGrupo> corePceGrupos) {
		this.corePceGrupos = corePceGrupos;
	}

	public void setBidirecctionalCorePceGrupos(Set<CorePceGrupo> corePceGrupos) {
		this.addCorePceGrupo(corePceGrupos);
		this.corePceGrupos = corePceGrupos;
	}

	public void addCorePceGrupo(Set<CorePceGrupo> setCorePceGrupos) {

		for (CorePceGrupo corePceGrupoIter : setCorePceGrupos) {
			corePceGrupoIter.setCorePce(this);
		}
	}


	@Basic
	@Column(name = "USUARIO_ELIMINACION")
	public String getUsuarioEliminacion() {return usuarioEliminacion;}

	public void setUsuarioEliminacion(String usuarioEliminacion) {this.usuarioEliminacion = usuarioEliminacion;}

	@Basic
	@Column(name = "FECHA_ELIMINACION")
	public Date getFechaEliminacion() {return fechaEliminacion;}

	public void setFechaEliminacion(Date fechaEliminacion) {this.fechaEliminacion = fechaEliminacion;}

	@Override
	public String toString() {
		return "OBJECT::" + this.hashCode()
				+ " corePceId::" + this.corePceId
				+ " cve::" + this.cve
				+ " nombre::" + this.nombre
				+ " estatus::" + this.estatus
				+ " fechaRegistro::" + this.fechaRegistro
				+ " usuarioRegistro::" + this.usuarioRegistro
				+ " usuarioEliminacion::" + this.usuarioEliminacion
				+ " fechaEliminacion::" + this.fechaEliminacion;
	}
}
