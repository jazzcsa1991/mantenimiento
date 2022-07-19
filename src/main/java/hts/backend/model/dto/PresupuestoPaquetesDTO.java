package hts.backend.model.dto;

import hts.backend.model.dto.AdmPrestacionesPaquetesDTO;

import java.util.List;

public class PresupuestoPaquetesDTO {
	private Integer cantidad;
	private Integer id;
	private String nombrePaquete;
	private Double precioGlobalPaquete;
	private Double precioIndividualPaquete;
	private Double precioPaquete;
	private Double precioUnitario;
	private Double precioTotal;
	private Double iva;
	private Double montoIva;
	private Double descuento;
	private Double montoDescuento;
	private List<AdmPrestacionesPaquetesDTO> prestaciones;

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombrePaquete() {
		return nombrePaquete;
	}

	public void setNombrePaquete(String nombrePaquete) {
		this.nombrePaquete = nombrePaquete;
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

	public List<AdmPrestacionesPaquetesDTO> getPrestaciones() {
		return prestaciones;
	}

	public void setPrestaciones(List<AdmPrestacionesPaquetesDTO> prestaciones) {
		this.prestaciones = prestaciones;
	}

	public Double getPrecioPaquete() {
		return precioPaquete;
	}

	public void setPrecioPaquete(Double precioPaquete) {
		this.precioPaquete = precioPaquete;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
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
