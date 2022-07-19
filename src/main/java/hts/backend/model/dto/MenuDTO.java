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

import java.util.List;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Luis Gerardo Dávila López (gerardo.d@hotmail.com)
 * @version 1.0
 */

public class MenuDTO {

	private String nombre;
	private Integer id;
	private String url;
	private List<SubmenuDTO> submenu;


//	public MenuDTO(String nombre, String url) {
//		super();
//		this.nombre = nombre;
//		this.url = url;
//	}


	public String getNombre() {
		return nombre;
	}

	public List<SubmenuDTO> getSubmenu() {
		return submenu;
	}

	public void setSubmenu(List<SubmenuDTO> submenu) {
		this.submenu = submenu;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "MenuDTO [nombre=" + nombre + ", id=" + id + ", url=" + url + ", submenu=" + submenu + "]";
	}


}
