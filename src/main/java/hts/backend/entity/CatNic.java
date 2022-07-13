package hts.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cat_nic")
@NamedQueries({
					  @NamedQuery(name = "CatNic.listNic", query = "" +
							  "select distinct cn " +
							  "from CatNic cn join fetch cn.corePceGrupos cpg " +
							  "where cpg.hospitalId =?0 " +
							  "and cpg.corePce.corePceId=?0 " +
							  "and cpg.catNanda.nandaId =?0 " +
							  "and cpg.catNoc.nocId =?0 "+
							  "and cpg.estatus= 1 "
					  ),
					  @NamedQuery(name = "CatNic.getAll", query = "" +
							  "from CatNic "
					  ),
					  @NamedQuery(name = "CatNic.getByArrayId", query = "" +
							  "from CatNic cn " +
							  "where cn.nicId in (:nicIdArray) "
					  ),
					  @NamedQuery(name = "CatNic.getByCveRecordNotRegistered", query = "" +
							  "from CatNic cn " +
							  "where cn.nicId not in ( " +
													  "select cpg.catNic.nicId " +
													  "from CorePceGrupo cpg " +
													  "where cpg.hospitalId =?0 " +
													  "and cpg.corePce.corePceId=?0 " +
													  "and cpg.catNanda.nandaId=?0 " +
													  "and cpg.catNoc.nocId=?0 " +
													  "and cpg.catNic.nicId is not null " +
							  						  "and cpg.estatus= 1 "+
													  " ) "+
							  "and cn.cve=?0 "
					  ),
					  @NamedQuery(name = "CatNic.getByNombreRecordNotRegistered", query = "" +
							  "from CatNic cn " +
							  "where cn.nicId not in ( " +
													  "select cpg.catNic.nicId " +
													  "from CorePceGrupo cpg " +
													  "where cpg.hospitalId =?0 " +
													  "and cpg.corePce.corePceId=?0 " +
													  "and cpg.catNanda.nandaId=?0 " +
													  "and cpg.catNoc.nocId=?0 " +
													  "and cpg.catNic.nicId is not null " +
							  						  "and cpg.estatus= 1 "+
													  " ) "+
							  "and cn.nombre like '%'||?0||'%' "
					  ),
					  @NamedQuery(name = "CatNic.getByCveRecordNotRegisteredPersonalizacion", query = "" +
							  "from CatNic cn " +
							  "where cn.nicId not in ( " +
							  "	select cpgenic.catNic.nicId " +
							  "	from CorePceGrupoEventoNic cpgenic join cpgenic.corePceGrupoEventoNoc cpgenoc " +
							  "	where cpgenoc.corePceGrupoEventoNocId =?0 " +
							  "	and cpgenic.estatus = 1 "+
							  " ) " +
							  "and cn.cve=?0 "
					  ),
					  @NamedQuery(name = "CatNic.getByNombreRecordNotRegisteredPersonalizacion", query = "" +
							  "from CatNic cn " +
							  "		where cn.nicId not in ( " +
							  "		select cpgenic.catNic.nicId " +
							  "		from CorePceGrupoEventoNic cpgenic join cpgenic.corePceGrupoEventoNoc cpgenoc " +
							  "		where cpgenoc.corePceGrupoEventoNocId =?0 " +
							  "		and cpgenic.estatus = 1 "+
							  " ) " +
							  "and cn.nombre like '%'||?0||'%' "
					  )
			  })
public class CatNic implements java.io.Serializable {
	private Integer nicId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer estatus;
	private Time fechaRegistro;
	private String usuarioRegistro;
	private Integer idiomaAppId;


	@JsonBackReference(value = "condCorePceGrupoToCatNic")
	private Set<CorePceGrupo> corePceGrupos = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "catNic")
	public Set<CorePceGrupo> getCorePceGrupos() {
		return corePceGrupos;
	}


	public void setCorePceGrupos(Set<CorePceGrupo> corePceGrupos) {
		this.corePceGrupos = corePceGrupos;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NIC_ID")
	public Integer getNicId() {
		return nicId;
	}

	public void setNicId(Integer nicId) {
		this.nicId = nicId;
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
	@Column(name = "DESCRIPCION")
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Basic
	@Column(name = "VALOR_DEFAULT")
	public Integer getValorDefault() {
		return valorDefault;
	}

	public void setValorDefault(Integer valorDefault) {
		this.valorDefault = valorDefault;
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
	public Time getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Time fechaRegistro) {
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

	@Basic
	@Column(name = "IDIOMA_APP_ID")
	public Integer getIdiomaAppId() {
		return idiomaAppId;
	}

	public void setIdiomaAppId(Integer idiomaAppId) {
		this.idiomaAppId = idiomaAppId;
	}

	@Override
	public String toString() {
		return "OBJECT::" + this.hashCode()
				+ " nicId::" + this.nicId
				+ " cve::" + this.cve
				+ " nombre::" + this.nombre
				+ " descripcion::" + this.descripcion
				+ " valorDefault::" + this.valorDefault
				+ " estatus::" + this.estatus
				+ " fechaRegistro::" + this.fechaRegistro
				+ " usuarioRegistro::" + this.usuarioRegistro;
	}
}
