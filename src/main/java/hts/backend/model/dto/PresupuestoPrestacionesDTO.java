package hts.backend.model.dto;

import hts.backend.model.dto.AdmPrestacionesPaquetesDTO;

import java.util.List;

public class PresupuestoPrestacionesDTO {
	private Integer cantidad;
	private Integer cantidadTemp;
	private Double precioTotal;
	private Double precioUnitario;
	private String prestacion;
	private Integer prestacionId;
	private String tipoPrestacion;
	private Double precioGlobalPaquete;
	private Double precioIndividualPaquete;
	private Double precioPaquete;
	private Double iva;
	private Double montoIva;
	private Double descuento;
	private Double montoDescuento;

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getCantidadTemp() {
		return cantidadTemp;
	}

	public void setCantidadTemp(Integer cantidadTemp) {
		this.cantidadTemp = cantidadTemp;
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public String getPrestacion() {
		return prestacion;
	}

	public void setPrestacion(String prestacion) {
		this.prestacion = prestacion;
	}

	public Integer getPrestacionId() {
		return prestacionId;
	}

	public void setPrestacionId(Integer prestacionId) {
		this.prestacionId = prestacionId;
	}

	public String getTipoPrestacion() {
		return tipoPrestacion;
	}

	public void setTipoPrestacion(String tipoPrestacion) {
		this.tipoPrestacion = tipoPrestacion;
	}

	public Double getPrecioGlobalPaquete() {
		return precioGlobalPaquete;
	}

	public void setPrecioGlobalPaquete(Double precioGlobalPaquete) {
		this.precioGlobalPaquete = precioGlobalPaquete;
	}

	public Double getPrecioIndividualPaquete() {
		return precioIndividualPaquete;
	}

	public void setPrecioIndividualPaquete(Double precioIndividualPaquete) {
		this.precioIndividualPaquete = precioIndividualPaquete;
	}

	public Double getPrecioPaquete() {
		return precioPaquete;
	}

	public void setPrecioPaquete(Double precioPaquete) {
		this.precioPaquete = precioPaquete;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Double getMontoIva() {
		return montoIva;
	}

	public void setMontoIva(Double montoIva) {
		this.montoIva = montoIva;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public Double getMontoDescuento() {
		return montoDescuento;
	}

	public void setMontoDescuento(Double montoDescuento) {
		this.montoDescuento = montoDescuento;
	}
}
