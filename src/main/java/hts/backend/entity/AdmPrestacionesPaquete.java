package hts.backend.entity;

import hts.backend.entity.NomPrductoPrestacion;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Lenovo2 on 03/08/2017.
 */
@Entity
@Table(name = "adm_prestaciones_paquete")
public class AdmPrestacionesPaquete implements Serializable{
	private Integer prestacionPaqueteId;
	private Date fechaRegistro;
	private String usuarioRegistra;
	private Integer cantidad;
	private Integer estatus;
	private NomPrductoPrestacion nomPrductoPrestacionByProductoPrestacionIdP;
	//private NomPrductoPrestacion nomPrductoPrestacionByPrestacionGrupoId;
	private NomPrductoPrestacion nomPrductoPrestacionByProductoPrestacionId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRESTACION_PAQUETE_ID", nullable = false, precision = 0) public Integer getPrestacionPaqueteId() {
		return prestacionPaqueteId;
	}

	public void setPrestacionPaqueteId(Integer prestacionPaqueteId) {
		this.prestacionPaqueteId = prestacionPaqueteId;
	}

	@Basic @Column(name = "FECHA_REGISTRO", nullable = false) public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO", nullable = false, length = 20) public String getUsuarioRegistra() {
		return usuarioRegistra;
	}

	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}


	@Basic @Column(name = "CANTIDAD", nullable = true, precision = 0) public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Basic @Column(name = "ESTATUS", nullable = false, precision = 0) public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@Override public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		AdmPrestacionesPaquete that = (AdmPrestacionesPaquete) o;

		if (prestacionPaqueteId != null ? !prestacionPaqueteId.equals(that.prestacionPaqueteId) : that.prestacionPaqueteId != null)
			return false;
		if (fechaRegistro != null ? !fechaRegistro.equals(that.fechaRegistro) : that.fechaRegistro != null)
			return false;
		if (usuarioRegistra != null ? !usuarioRegistra.equals(that.usuarioRegistra) : that.usuarioRegistra != null)
			return false;
		if (cantidad != null ? !cantidad.equals(that.cantidad) : that.cantidad != null) return false;
		if (estatus != null ? !estatus.equals(that.estatus) : that.estatus != null) return false;

		return true;
	}

	@Override public int hashCode() {
		int result = prestacionPaqueteId != null ? prestacionPaqueteId.hashCode() : 0;
		result = 31 * result + (fechaRegistro != null ? fechaRegistro.hashCode() : 0);
		result = 31 * result + (usuarioRegistra != null ? usuarioRegistra.hashCode() : 0);
		result = 31 * result + (cantidad != null ? cantidad.hashCode() : 0);
		result = 31 * result + (estatus != null ? estatus.hashCode() : 0);
		return result;
	}

	@ManyToOne @JoinColumn(name = "PRODUCTO_PRESTACION_ID_P", referencedColumnName = "PRODUCTO_PRESTACION_ID", nullable = false) public NomPrductoPrestacion getNomPrductoPrestacionByProductoPrestacionIdP() {
		return nomPrductoPrestacionByProductoPrestacionIdP;
	}

	public void setNomPrductoPrestacionByProductoPrestacionIdP(NomPrductoPrestacion nomPrductoPrestacionByProductoPrestacionIdP) {
		this.nomPrductoPrestacionByProductoPrestacionIdP = nomPrductoPrestacionByProductoPrestacionIdP;
	}

//	@ManyToOne @JoinColumn(name = "PRESTACION_GRUPO_ID", referencedColumnName = "PRODUCTO_PRESTACION_ID") public NomPrductoPrestacion getNomPrductoPrestacionByPrestacionGrupoId() {
//		return nomPrductoPrestacionByPrestacionGrupoId;
//	}
//
//	public void setNomPrductoPrestacionByPrestacionGrupoId(NomPrductoPrestacion nomPrductoPrestacionByPrestacionGrupoId) {
//		this.nomPrductoPrestacionByPrestacionGrupoId = nomPrductoPrestacionByPrestacionGrupoId;
//	}

	@ManyToOne @JoinColumn(name = "PRODUCTO_PRESTACION_ID", referencedColumnName = "PRODUCTO_PRESTACION_ID") public NomPrductoPrestacion getNomPrductoPrestacionByProductoPrestacionId() {
		return nomPrductoPrestacionByProductoPrestacionId;
	}

	public void setNomPrductoPrestacionByProductoPrestacionId(NomPrductoPrestacion nomPrductoPrestacionByProductoPrestacionId) {
		this.nomPrductoPrestacionByProductoPrestacionId = nomPrductoPrestacionByProductoPrestacionId;
	}
}
