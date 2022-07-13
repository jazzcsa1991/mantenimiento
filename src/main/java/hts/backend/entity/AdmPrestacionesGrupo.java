package hts.backend.entity;

import hts.backend.entity.NomPrductoPrestacion;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Lenovo2 on 03/08/2017.
 */
@Entity
@Table(name = "adm_prestaciones_grupo")
public class AdmPrestacionesGrupo implements Serializable{
	private Integer prestacionGrupoId;
	private Date fechaRegistro;
	private String usuarioRegistra;
	private Integer cantidad;
	private Integer estatus;
	private NomPrductoPrestacion nomPrductoPrestacionByProductoPrestacionIdG;
	private NomPrductoPrestacion nomPrductoPrestacionByProductoPrestacionId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRESTACION_GRUPO_ID", nullable = false, precision = 0) public Integer getPrestacionGrupoId() {
		return prestacionGrupoId;
	}

	public void setPrestacionGrupoId(Integer prestacionGrupoId) {
		this.prestacionGrupoId = prestacionGrupoId;
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


	@ManyToOne @JoinColumn(name = "PRODUCTO_PRESTACION_ID_G", referencedColumnName = "PRODUCTO_PRESTACION_ID", nullable = false) public NomPrductoPrestacion getNomPrductoPrestacionByProductoPrestacionIdG() {
		return nomPrductoPrestacionByProductoPrestacionIdG;
	}

	public void setNomPrductoPrestacionByProductoPrestacionIdG(NomPrductoPrestacion nomPrductoPrestacionByProductoPrestacionIdG) {
		this.nomPrductoPrestacionByProductoPrestacionIdG = nomPrductoPrestacionByProductoPrestacionIdG;
	}

	@ManyToOne @JoinColumn(name = "PRODUCTO_PRESTACION_ID", referencedColumnName = "PRODUCTO_PRESTACION_ID", nullable = false) public NomPrductoPrestacion getNomPrductoPrestacionByProductoPrestacionId() {
		return nomPrductoPrestacionByProductoPrestacionId;
	}

	public void setNomPrductoPrestacionByProductoPrestacionId(NomPrductoPrestacion nomPrductoPrestacionByProductoPrestacionId) {
		this.nomPrductoPrestacionByProductoPrestacionId = nomPrductoPrestacionByProductoPrestacionId;
	}
}
