package hts.backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Francisco Toscano on 04/08/2017. CorePceGrupo.listarCorePceGrupo
 */
@Entity
@Table(name = "core_pce_grupo")
@NamedQueries({
					  @NamedQuery(name = "CorePceGrupo.delete.corePceGrupoNandaNull", query = "" +
							  "delete CorePceGrupo cpg  " +
							  "where cpg.hospitalId =?0 "+
							  "and cpg.corePce.corePceId=?0 "+
							  "and cpg.catNanda.nandaId is null"
					  ),
					  @NamedQuery(name = "CorePceGrupo.selectTodelete.nanda", query = "" +
							  "select cpg "+
							  "from CorePceGrupo cpg  " +
							  "where cpg.hospitalId =?0 "+
							  "and cpg.corePce.corePceId=?0 "+
							  "and cpg.catNanda.nandaId=?0 "+
							  "and cpg.estatus=  1 "
					  ),
					  @NamedQuery(name = "CorePceGrupo.delete.corePceGrupoNocNull", query = "" +
							  "delete CorePceGrupo cpg  " +
							  "where cpg.hospitalId =?0 "+
							  "and cpg.corePce.corePceId=?0 "+
							  "and cpg.catNanda.nandaId=?0 "+
							  "and cpg.catNoc.nocId is null"
					  ),
					  @NamedQuery(name = "CorePceGrupo.selectTodelete.noc", query = "" +
							  "select cpg "+
							  "from CorePceGrupo cpg  " +
							  "where cpg.hospitalId=?0 "+
							  "and cpg.corePce.corePceId=?0 "+
							  "and cpg.catNanda.nandaId=?0 "+
							  "and cpg.catNoc.nocId=?0 "+
							  "and cpg.estatus=  1 "
					  ),
					  @NamedQuery(name = "CorePceGrupo.delete.corePceGrupoNicNull", query = "" +
							  "delete CorePceGrupo cpg  " +
							  "where cpg.hospitalId =?0 "+
							  "and cpg.corePce.corePceId=?0 "+
							  "and cpg.catNanda.nandaId=?0 "+
							  "and cpg.catNoc.nocId=?0 "+
							  "and cpg.catNic.nicId is null"
					  ),
					  @NamedQuery(name = "CorePceGrupo.selectTodelete.nic", query = "" +
							  "select cpg "+
							  "from CorePceGrupo cpg  " +
							  "where cpg.hospitalId=?0 "+
							  "and cpg.corePce.corePceId=?0 "+
							  "and cpg.catNanda.nandaId=?0 "+
							  "and cpg.catNoc.nocId=?0 "+
							  "and cpg.catNic.nicId=?0 "+
							  "and cpg.estatus=  1 "
					  )
			  })
public class CorePceGrupo implements java.io.Serializable{
  private Integer corePceGrupoId;
  private Integer hospitalId;
  @JsonManagedReference(value="condCorePceGrupoToCorePce")
  private CorePce corePce;
  @JsonManagedReference(value="condCorePceGrupoToCatNanda")
  private CatNanda catNanda;
  @JsonManagedReference(value="condCorePceGrupoToCatNoc")
  private CatNoc catNoc;
  @JsonManagedReference(value="condCorePceGrupoToCatNic")
  private CatNic catNic;
  private Date fechaRegistro;
  private String usuarioRegistro;

  private Integer estatus;
  private String usuarioEliminacion;
  private Date fechaEliminacion;



	@Id@Column(name = "CORE_PCE_GRUPO_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getCorePceGrupoId() {
		return corePceGrupoId;
	}

	public void setCorePceGrupoId(Integer corePceGrupoId) {
		this.corePceGrupoId = corePceGrupoId;
	}

	@Basic @Column(name = "HOSPITAL_ID") public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
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


	@ManyToOne @JoinColumn(name = "CORE_PCE_ID") public CorePce getCorePce() {
		return corePce;
	}

	public void setCorePce(CorePce corePce) {
		this.corePce = corePce;
	}

	@ManyToOne @JoinColumn(name = "NANDA_ID", referencedColumnName = "NANDA_ID") public CatNanda getCatNanda() {
		return catNanda;
	}

	public void setCatNanda(CatNanda catNanda) {
		this.catNanda = catNanda;
	}

	@ManyToOne @JoinColumn(name = "NOC_ID", referencedColumnName = "NOC_ID") public CatNoc getCatNoc() {
		return catNoc;
	}

	public void setCatNoc(CatNoc catNoc) {
		this.catNoc = catNoc;
	}

	@ManyToOne @JoinColumn(name = "NIC_ID", referencedColumnName = "NIC_ID") public CatNic getCatNic() {
		return catNic;
	}

	public void setCatNic(CatNic catNic) {
		this.catNic = catNic;
	}


	@Basic @Column(name = "ESTATUS")
	public Integer getEstatus() {return estatus;}

	public void setEstatus(Integer estatus) {this.estatus = estatus;}

	@Basic @Column(name = "USUARIO_ELIMINACION")
	public String getUsuarioEliminacion() {return usuarioEliminacion;}

	public void setUsuarioEliminacion(String usuarioEliminacion) {this.usuarioEliminacion = usuarioEliminacion;}

	@Basic @Column(name = "FECHA_ELIMINACION")
	public Date getFechaEliminacion() {return fechaEliminacion;}

	public void setFechaEliminacion(Date fechaEliminacion) {this.fechaEliminacion = fechaEliminacion;}


	@Override public String toString() {
		return "OBJECT::"+this.hashCode()
				+" corePceGrupoId::"+this.corePceGrupoId
				+" hospitalId::"+this.hospitalId
				+" corePce::"+this.corePce
				+" catNanda::"+this.catNanda
				+" catNoc::"+this.catNoc
				+" catNic::"+this.catNic
				+" fechaRegistro::"+this.fechaRegistro
				+" usuarioRegistro::"+this.usuarioRegistro
				+" estatus::"+this.estatus
				+" usuarioEliminacion::"+this.usuarioEliminacion
				+" fechaEliminacion::"+this.fechaEliminacion;
	}





}
