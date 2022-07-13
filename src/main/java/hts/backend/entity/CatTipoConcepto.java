package hts.backend.entity;

import hts.backend.entity.FacturacionEvento;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;

/**
 * Created by Lenovo2 on 20/06/2017.
 */
@Entity
@Table(name = "cat_tipo_concepto")
public class CatTipoConcepto {


	private Integer tipoConceptoId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Long valorDefault;
	private Long estatus;
	private Time fechaRegistro;
	private String usuarioRegistro;
	private Long idiomaAppId;
	private Set<FacturacionEvento> facturacionEventosByTipoConceptoId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TIPO_CONCEPTO_ID", nullable = false, precision = 0)
	public Integer getTipoConceptoId() {
		return tipoConceptoId;
	}

	public void setTipoConceptoId(Integer tipoConceptoId) {
		this.tipoConceptoId = tipoConceptoId;
	}

	@Basic @Column(name = "CVE", nullable = false, length = 50) public String getCve() {
		return cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	@Basic @Column(name = "NOMBRE", nullable = false, length = 50) public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Basic @Column(name = "DESCRIPCION", nullable = false, length = 50) public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Basic @Column(name = "VALOR_DEFAULT", nullable = false, precision = 0) public Long getValorDefault() {
		return valorDefault;
	}

	public void setValorDefault(Long valorDefault) {
		this.valorDefault = valorDefault;
	}

	@Basic @Column(name = "ESTATUS", nullable = false, precision = 0) public Long getEstatus() {
		return estatus;
	}

	public void setEstatus(Long estatus) {
		this.estatus = estatus;
	}

	@Basic @Column(name = "FECHA_REGISTRO", nullable = false) public Time getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Time fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO", nullable = false, length = 20) public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Basic @Column(name = "IDIOMA_APP_ID", nullable = true, precision = 0) public Long getIdiomaAppId() {
		return idiomaAppId;
	}

	public void setIdiomaAppId(Long idiomaAppId) {
		this.idiomaAppId = idiomaAppId;
	}

	@Override public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CatTipoConcepto that = (CatTipoConcepto) o;

		if (cve != null ? !cve.equals(that.cve) : that.cve != null) return false;
		if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
		if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
		if (valorDefault != null ? !valorDefault.equals(that.valorDefault) : that.valorDefault != null) return false;
		if (estatus != null ? !estatus.equals(that.estatus) : that.estatus != null) return false;
		if (fechaRegistro != null ? !fechaRegistro.equals(that.fechaRegistro) : that.fechaRegistro != null)
			return false;
		if (usuarioRegistro != null ? !usuarioRegistro.equals(that.usuarioRegistro) : that.usuarioRegistro != null)
			return false;
		if (idiomaAppId != null ? !idiomaAppId.equals(that.idiomaAppId) : that.idiomaAppId != null) return false;

		return true;
	}

	@Override public int hashCode() {
		int result = cve != null ? cve.hashCode() : 0;
		result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
		result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
		result = 31 * result + (valorDefault != null ? valorDefault.hashCode() : 0);
		result = 31 * result + (estatus != null ? estatus.hashCode() : 0);
		result = 31 * result + (fechaRegistro != null ? fechaRegistro.hashCode() : 0);
		result = 31 * result + (usuarioRegistro != null ? usuarioRegistro.hashCode() : 0);
		result = 31 * result + (idiomaAppId != null ? idiomaAppId.hashCode() : 0);
		return result;
	}

	@OneToMany(mappedBy = "catTipoConceptoByTipoConceptoId") public Set<FacturacionEvento> getFacturacionEventosByTipoConceptoId() {
		return facturacionEventosByTipoConceptoId;
	}

	public void setFacturacionEventosByTipoConceptoId(Set<FacturacionEvento> facturacionEventosByTipoConceptoId) {
		this.facturacionEventosByTipoConceptoId = facturacionEventosByTipoConceptoId;
	}
}
