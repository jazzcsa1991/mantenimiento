package hts.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cat_nanda")
@NamedQueries({
					  @NamedQuery(name = "CatNanda.listNanda", query = "" +
							  "select distinct cn " +
							  "from CatNanda  cn join fetch cn.corePceGrupos cpg " +
							  "where cpg.hospitalId=?0 " +
							  "and cpg.corePce.corePceId=?0 " +
							  "and cpg.estatus= 1 "
					  ),
					  @NamedQuery(name = "CatNanda.getAll", query = "" +
							  "from CatNanda "
					  ),
					  @NamedQuery(name = "CatNanda.getByArrarId", query = "" +
							  "from CatNanda cn " +
							  "where cn.nandaId in (:nandaIdArray) "
					  ),
					  @NamedQuery(name = "CatNanda.getByCveRecordNotRegistered", query = "" +
							  "from CatNanda cn " +
							  "where cn.nandaId not in ( " +
							  "select cpg.catNanda.nandaId " +
							  "from CorePceGrupo cpg " +
							  "where cpg.hospitalId =?0 " +
							  "and cpg.corePce.corePceId=?0 " +
							  "and cpg.catNanda.nandaId is not null " +
							  "and cpg.estatus= 1 " +
							  " ) " +
							  "and cn.cve=?0 "
					  ),
					  @NamedQuery(name = "CatNanda.getByNombreRecordNotRegistered", query = "" +
							  "from CatNanda cn " +
							  "where cn.nandaId not in ( " +
							  "select cpg.catNanda.nandaId " +
							  "from CorePceGrupo cpg " +
							  "where cpg.hospitalId =?0 " +
							  "and cpg.corePce.corePceId=?0 " +
							  "and cpg.catNanda.nandaId is not null " +
							  "and cpg.estatus= 1 " +
							  " ) " +
							  "and cn.nombre like '%'||?0||'%' "
					  ),
					  @NamedQuery(name = "CatNanda.getByCveRecordNotRegisteredPersonalizacion", query = "" +
							  "from CatNanda cn " +
							  "where cn.nandaId not in ( " +
							  "		select cpgen.catNanda.nandaId " +
							  "		from CorePceGrupoEventoNanda cpgen join cpgen.corePceGrupoEventoPlan cpgep " +
							  "		where cpgep.corePceGrupoEventoPlanId =?0 " +
							  "		and cpgen.estatus = 1 " +
							  " ) " +
							  "and cn.cve=?0 "
					  ),
					  @NamedQuery(name = "CatNanda.getByNombreRecordNotRegisteredPersonalizacion", query = "" +
							  "from CatNanda cn " +
							  "where cn.nandaId not in ( " +
							  "		select cpgen.catNanda.nandaId " +
							  "		from CorePceGrupoEventoNanda cpgen join cpgen.corePceGrupoEventoPlan cpgep " +
							  "		where cpgep.corePceGrupoEventoPlanId =?0 " +
							  "		and cpgen.estatus = 1 " +
							  " ) " +
							  "and cn.nombre like '%'||?0||'%' "
					  )
			  })
public class CatNanda implements java.io.Serializable {
	private Integer nandaId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Integer idiomaAppId;

	@JsonBackReference(value = "condCorePceGrupoToCatNanda")
	private Set<CorePceGrupo> corePceGrupos = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "catNanda")
	public Set<CorePceGrupo> getCorePceGrupos() {
		return corePceGrupos;
	}

	public void setCorePceGrupos(Set<CorePceGrupo> corePceGrupos) {
		this.corePceGrupos = corePceGrupos;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NANDA_ID")
	public Integer getNandaId() {
		return nandaId;
	}

	public void setNandaId(Integer nandaId) {
		this.nandaId = nandaId;
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
				+ " nandaId::" + this.nandaId
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

		CatNanda catNanda = (CatNanda) o;

		if (nandaId != null ? !nandaId.equals(catNanda.nandaId) : catNanda.nandaId != null) return false;
		if (cve != null ? !cve.equals(catNanda.cve) : catNanda.cve != null) return false;
		if (nombre != null ? !nombre.equals(catNanda.nombre) : catNanda.nombre != null) return false;
		if (descripcion != null ? !descripcion.equals(catNanda.descripcion) : catNanda.descripcion != null)
			return false;
		if (valorDefault != null ? !valorDefault.equals(catNanda.valorDefault) : catNanda.valorDefault != null)
			return false;
		if (estatus != null ? !estatus.equals(catNanda.estatus) : catNanda.estatus != null) return false;
		if (fechaRegistro != null ? !fechaRegistro.equals(catNanda.fechaRegistro) : catNanda.fechaRegistro != null)
			return false;
		if (usuarioRegistro != null ? !usuarioRegistro.equals(catNanda.usuarioRegistro) : catNanda.usuarioRegistro != null)
			return false;
		if (idiomaAppId != null ? !idiomaAppId.equals(catNanda.idiomaAppId) : catNanda.idiomaAppId != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = nandaId != null ? nandaId.hashCode() : 0;
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
