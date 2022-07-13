package hts.backend.entity;

import hts.backend.entity.FacCargosAsegComercial;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * Created by Lenovo2 on 05/07/2017.
 */
@Entity
@Table(name = "cat_motivo_descuento")
public class CatMotivoDescuento {
	private Integer motivoDescuentoId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private CatIdiomaApp catIdiomaAppByIdiomaAppId;
	//private Set<FacCargosAsegComercial> facCargosAsegComercialsByMotivoDescuentoId;




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOTIVO_DESCUENTO_ID", nullable = false, precision = 0) public Integer getMotivoDescuentoId() {
		return motivoDescuentoId;
	}

	public void setMotivoDescuentoId(Integer motivoDescuentoId) {
		this.motivoDescuentoId = motivoDescuentoId;
	}

	@Basic @Column(name = "CVE", nullable = false, length = 20) public String getCve() {
		return cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	@Basic @Column(name = "NOMBRE", nullable = false, length = 100) public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Basic @Column(name = "DESCRIPCION", nullable = false, length = 150) public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Basic @Column(name = "VALOR_DEFAULT", nullable = false, precision = 0) public Integer getValorDefault() {
		return valorDefault;
	}

	public void setValorDefault(Integer valorDefault) {
		this.valorDefault = valorDefault;
	}

	@Basic @Column(name = "ESTATUS", nullable = false, precision = 0) public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@Basic @Column(name = "FECHA_REGISTRO", nullable = false) public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO", nullable = false, length = 20) public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Override public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CatMotivoDescuento that = (CatMotivoDescuento) o;

		if (motivoDescuentoId != null ? !motivoDescuentoId.equals(that.motivoDescuentoId) : that.motivoDescuentoId != null)
			return false;
		if (cve != null ? !cve.equals(that.cve) : that.cve != null) return false;
		if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
		if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
		if (valorDefault != null ? !valorDefault.equals(that.valorDefault) : that.valorDefault != null) return false;
		if (estatus != null ? !estatus.equals(that.estatus) : that.estatus != null) return false;
		if (fechaRegistro != null ? !fechaRegistro.equals(that.fechaRegistro) : that.fechaRegistro != null)
			return false;
		if (usuarioRegistro != null ? !usuarioRegistro.equals(that.usuarioRegistro) : that.usuarioRegistro != null)
			return false;

		return true;
	}

	@Override public int hashCode() {
		int result = motivoDescuentoId != null ? motivoDescuentoId.hashCode() : 0;
		result = 31 * result + (cve != null ? cve.hashCode() : 0);
		result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
		result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
		result = 31 * result + (valorDefault != null ? valorDefault.hashCode() : 0);
		result = 31 * result + (estatus != null ? estatus.hashCode() : 0);
		result = 31 * result + (fechaRegistro != null ? fechaRegistro.hashCode() : 0);
		result = 31 * result + (usuarioRegistro != null ? usuarioRegistro.hashCode() : 0);
		return result;
	}

	@ManyToOne @JoinColumn(name = "IDIOMA_APP_ID", referencedColumnName = "IDIOMA_APP_ID", nullable = false) public CatIdiomaApp getCatIdiomaAppByIdiomaAppId() {
		return catIdiomaAppByIdiomaAppId;
	}

	public void setCatIdiomaAppByIdiomaAppId(CatIdiomaApp catIdiomaAppByIdiomaAppId) {
		this.catIdiomaAppByIdiomaAppId = catIdiomaAppByIdiomaAppId;
	}

//	@OneToMany(mappedBy = "catMotivoDescuentoByMotivoDescuentoId") public Set<FacCargosAsegComercial> getFacCargosAsegComercialsByMotivoDescuentoId() {
//		return facCargosAsegComercialsByMotivoDescuentoId;
//	}
//
//	public void setFacCargosAsegComercialsByMotivoDescuentoId(Set<FacCargosAsegComercial> facCargosAsegComercialsByMotivoDescuentoId) {
//		this.facCargosAsegComercialsByMotivoDescuentoId = facCargosAsegComercialsByMotivoDescuentoId;
//	}
}
