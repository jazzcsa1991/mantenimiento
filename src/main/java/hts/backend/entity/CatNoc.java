package hts.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cat_noc")
@NamedQueries({
					  @NamedQuery(name = "CatNoc.listNoc", query = "" +
							  "select distinct cn " +
							  "from CatNoc cn join fetch cn.corePceGrupos cpg " +
							  "where cpg.hospitalId =?0 " +
							  "and cpg.corePce.corePceId=?0 " +
							  "and cpg.catNanda.nandaId =?0 "+
							  "and cpg.estatus= 1 "
					  ),
					  @NamedQuery(name = "CatNoc.getAll", query = "" +
							  "from CatNoc "
					  ),
					  @NamedQuery(name = "CatNoc.getByArrayId", query = "" +
							  "from CatNoc cn " +
							  "where cn.nocId in (:nocIdArray) "
					  ),
					  @NamedQuery(name = "CatNoc.getByCveRecordNotRegistered", query = "" +
							  "from CatNoc cn " +
							  "where cn.nocId not in ( " +
													  "select cpg.catNoc.nocId " +
													  "from CorePceGrupo cpg " +
													  "where cpg.hospitalId =?0 " +
													  "and cpg.corePce.corePceId=?0 " +
													  "and cpg.catNanda.nandaId=?0 " +
													  "and cpg.catNoc.nocId is not null " +
							  						  "and cpg.estatus= 1 "+
													  " ) "+
							  "and cn.cve=?0 "
					  ),
					  @NamedQuery(name = "CatNoc.getByNombreRecordNotRegistered", query = "" +
							  "from CatNoc cn " +
							  "where cn.nocId not in ( " +
													  "select cpg.catNoc.nocId " +
													  "from CorePceGrupo cpg " +
													  "where cpg.hospitalId =?0 " +
													  "and cpg.corePce.corePceId=?0 " +
													  "and cpg.catNanda.nandaId=?0 " +
													  "and cpg.catNoc.nocId is not null " +
							  						  "and cpg.estatus= 1 "+
													  " ) "+
							  "and cn.nombre like '%'||?0||'%' "
					  ),
					  @NamedQuery(name = "CatNoc.getByCveRecordNotRegisteredPersonalizacion", query = "" +
							  "from CatNoc cn " +
							  "where cn.nocId not in ( " +
							  "		select cpgenoc.catNoc.nocId " +
							  "		from CorePceGrupoEventoNoc cpgenoc join cpgenoc.corePceGrupoEventoNanda cpgenanda " +
							  "		where cpgenanda.corePceGrupoEventoNandaId =?0 " +
							  "		and cpgenoc.estatus = 1 "+
							  " ) " +
							  "and cn.cve=?0 "
					  ),
					  @NamedQuery(name = "CatNoc.getByNombreRecordNotRegisteredPersonalizacion", query = "" +
							  "from CatNoc cn " +
							  "where cn.nocId not in ( " +
							  "		select cpgenoc.catNoc.nocId " +
							  "		from CorePceGrupoEventoNoc cpgenoc join cpgenoc.corePceGrupoEventoNanda cpgenanda " +
							  "		where cpgenanda.corePceGrupoEventoNandaId =?0 " +
							  "		and cpgenoc.estatus = 1 "+
							  " ) " +
							  "and cn.nombre like '%'||?0||'%' "
					  )
			  })
public class CatNoc implements java.io.Serializable {
	private Integer nocId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer estatus;
	private Time fechaRegistro;
	private String usuarioRegistro;
	private Integer idiomaAppId;

	@JsonBackReference(value = "condCorePceGrupoToCatNoc")
	private Set<CorePceGrupo> corePceGrupos = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "catNoc")
	public Set<CorePceGrupo> getCorePceGrupos() {
		return corePceGrupos;
	}


	public void setCorePceGrupos(Set<CorePceGrupo> corePceGrupos) {
		this.corePceGrupos = corePceGrupos;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NOC_ID")
	public Integer getNocId() {
		return nocId;
	}

	public void setNocId(Integer nocId) {
		this.nocId = nocId;
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
				+ " nocId::" + this.nocId
				+ " cve::" + this.cve
				+ " nombre::" + this.nombre
				+ " descripcion::" + this.descripcion
				+ " valorDefault::" + this.valorDefault
				+ " estatus::" + this.estatus
				+ " fechaRegistro::" + this.fechaRegistro
				+ " usuarioRegistro::" + this.usuarioRegistro;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CatNoc catNoc = (CatNoc) o;

		if (nocId != null ? !nocId.equals(catNoc.nocId) : catNoc.nocId != null) return false;
		if (cve != null ? !cve.equals(catNoc.cve) : catNoc.cve != null) return false;
		if (nombre != null ? !nombre.equals(catNoc.nombre) : catNoc.nombre != null) return false;
		if (descripcion != null ? !descripcion.equals(catNoc.descripcion) : catNoc.descripcion != null) return false;
		if (valorDefault != null ? !valorDefault.equals(catNoc.valorDefault) : catNoc.valorDefault != null)
			return false;
		if (estatus != null ? !estatus.equals(catNoc.estatus) : catNoc.estatus != null) return false;
		if (fechaRegistro != null ? !fechaRegistro.equals(catNoc.fechaRegistro) : catNoc.fechaRegistro != null)
			return false;
		if (usuarioRegistro != null ? !usuarioRegistro.equals(catNoc.usuarioRegistro) : catNoc.usuarioRegistro != null)
			return false;
		if (idiomaAppId != null ? !idiomaAppId.equals(catNoc.idiomaAppId) : catNoc.idiomaAppId != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = nocId != null ? nocId.hashCode() : 0;
		result = 31 * result + (cve != null ? cve.hashCode() : 0);
		result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
		result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
		result = 31 * result + (valorDefault != null ? valorDefault.hashCode() : 0);
		result = 31 * result + (estatus != null ? estatus.hashCode() : 0);
		result = 31 * result + (fechaRegistro != null ? fechaRegistro.hashCode() : 0);
		result = 31 * result + (usuarioRegistro != null ? usuarioRegistro.hashCode() : 0);
		result = 31 * result + (idiomaAppId != null ? idiomaAppId.hashCode() : 0);
		return result;
	}
}
