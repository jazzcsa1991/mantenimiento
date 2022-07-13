package hts.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by Lenovo2 on 21/07/2017.
 */
@Entity
@Table(name = "fac_cat_tipo_cargo")
public class FacCatTipoCargo implements Serializable{
	private Integer catTipoCargoId;
	private String nombre;
	private String descripcion;
	private Boolean estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Set<FacCargosAsegParticular> facCargosAsegParticularsByCatTipoCargoId;

	@Id @Column(name = "CAT_TIPO_CARGO_ID", nullable = false, precision = 0) public Integer getCatTipoCargoId() {
		return catTipoCargoId;
	}

	public void setCatTipoCargoId(Integer catTipoCargoId) {
		this.catTipoCargoId = catTipoCargoId;
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

	@Basic @Column(name = "ESTATUS", nullable = false, precision = 0) public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
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

		FacCatTipoCargo that = (FacCatTipoCargo) o;

		if (catTipoCargoId != null ? !catTipoCargoId.equals(that.catTipoCargoId) : that.catTipoCargoId != null)
			return false;
		if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
		if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
		if (estatus != null ? !estatus.equals(that.estatus) : that.estatus != null) return false;
		if (fechaRegistro != null ? !fechaRegistro.equals(that.fechaRegistro) : that.fechaRegistro != null)
			return false;
		if (usuarioRegistro != null ? !usuarioRegistro.equals(that.usuarioRegistro) : that.usuarioRegistro != null)
			return false;

		return true;
	}

	@Override public int hashCode() {
		int result = catTipoCargoId != null ? catTipoCargoId.hashCode() : 0;
		result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
		result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
		result = 31 * result + (estatus != null ? estatus.hashCode() : 0);
		result = 31 * result + (fechaRegistro != null ? fechaRegistro.hashCode() : 0);
		result = 31 * result + (usuarioRegistro != null ? usuarioRegistro.hashCode() : 0);
		return result;
	}

	@OneToMany(mappedBy = "facCatTipoCargo") public Set<FacCargosAsegParticular> getFacCargosAsegParticularsByCatTipoCargoId() {
		return facCargosAsegParticularsByCatTipoCargoId;
	}

	public void setFacCargosAsegParticularsByCatTipoCargoId(Set<FacCargosAsegParticular> facCargosAsegParticularsByCatTipoCargoId) {
		this.facCargosAsegParticularsByCatTipoCargoId = facCargosAsegParticularsByCatTipoCargoId;
	}
}
