/**
 * mensajeDTO.java
 * Fecha de creación: 19/10/2015, 18:14:13
 * <p>
 * Copyright (c) 2016 SASA
 * Todos los derechos reservados.
 * <p>
 * Este software es información confidencial, propiedad de SASA
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia Empresa.
 */

package hts.backend.model.dto;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Luis Gerardo Dávila López (gerardo.d@hotmail.com)
 * @version 1.0
 */

public class SubmenuDTO {

	private String nombre;
	private String url;
	private String orden;


//	public MenuDTO(String nombre, String url) {
//		super();
//		this.nombre = nombre;
//		this.url = url;
//	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "SubmenuDTO [nombre=" + nombre + ", url=" + url + "]";
	}

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

}
