package hts.backend.model.dto;

import java.util.Date;

/**
 * Created by Lenovo2 on 04/08/2017.
 */
public class AdmPrestacionesPaquetesDTO {
	private Integer prestacionPaqueteId;   // idEntidad
	private Integer prestacionGrupoId;   // idEntidad
	private Integer productoPrestacionIdP; // id de paquete
	private Integer productoPrestacionId;  // prestacion (unitaria o grupo)
	private Integer cantidad;
	private Integer cantidadTotal;
	private Integer estatus;
	private Double precio;
	private Date fechaRegistro;
	private String usuarioRegistra;
	private String nombrePaquete;
	private String nombre;
	private String nombreP1;
	private String cve;
	private Integer grupoPrestacion;
	private String prestacion;
	private String nombreP2;
	private String nombreUnidadMedida;
	private Double precioPaq;

	public Double getPrecioPaq() {
		return precioPaq;
	}

	public void setPrecioPaq(Double precioPaq) {
		this.precioPaq = precioPaq;
	}

	public Integer getPrestacionPaqueteId() {
		return prestacionPaqueteId;
	}

	public void setPrestacionPaqueteId(Integer prestacionPaqueteId) {
		this.prestacionPaqueteId = prestacionPaqueteId;
	}

	public Integer getProductoPrestacionIdP() {
		return productoPrestacionIdP;
	}

	public void setProductoPrestacionIdP(Integer productoPrestacionIdP) {
		this.productoPrestacionIdP = productoPrestacionIdP;
	}

	public Integer getProductoPrestacionId() {
		return productoPrestacionId;
	}

	public void setProductoPrestacionId(Integer productoPrestacionId) {
		this.productoPrestacionId = productoPrestacionId;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUsuarioRegistra() {
		return usuarioRegistra;
	}

	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreP1() {
		return nombreP1;
	}

	public void setNombreP1(String nombreP1) {
		this.nombreP1 = nombreP1;
	}

	public String getCve() {
		return cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	public Integer getGrupoPrestacion() {
		return grupoPrestacion;
	}

	public void setGrupoPrestacion(Integer grupoPrestacion) {
		this.grupoPrestacion = grupoPrestacion;
	}


	public String getPrestacion() {
		return prestacion;
	}

	public void setPrestacion(String prestacion) {
		this.prestacion = prestacion;
	}

	public String getNombrePaquete() {
		return nombrePaquete;
	}

	public void setNombrePaquete(String nombrePaquete) {
		this.nombrePaquete = nombrePaquete;
	}

	public String getNombreP2() {
		return nombreP2;
	}

	public void setNombreP2(String nombreP2) {
		this.nombreP2 = nombreP2;
	}

	public String getNombreUnidadMedida() {
		return nombreUnidadMedida;
	}

	public void setNombreUnidadMedida(String nombreUnidadMedida) {
		this.nombreUnidadMedida = nombreUnidadMedida;
	}

	public Integer getPrestacionGrupoId() {
		return prestacionGrupoId;
	}

	public void setPrestacionGrupoId(Integer prestacionGrupoId) {
		this.prestacionGrupoId = prestacionGrupoId;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidadTotal() {
		return cantidadTotal;
	}

	public void setCantidadTotal(Integer cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}
}
