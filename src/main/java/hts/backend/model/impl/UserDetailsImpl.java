/**
 * Usuario.java
 * Fecha de creación: 17/12/2012, 14:21:59
 * <p>
 * Copyright (c 2012 Instituto Federal Electoral. Dirección
 * Ejecutiva del Registro Federal de Electores.
 * Periférico Sur 239, México, D.F., C.P. 01010.
 * Todos los derechos reservados.
 * <p>
 * Este software es información confidencial, propiedad del
 * Instituto Federal Electoral. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine el propio Instituto.
 */
package hts.backend.model.impl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * Detalles del usuario logueado al sistema
 * @author Hugo A. Cruz Trujillo (hcruzt@sasa-mexico.com)
 * @version 1.0
 * @since ATMOSPHERE 1.0
 */
public class UserDetailsImpl extends User {

	private static final long serialVersionUID = 4867414212324557480L;

	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Integer id;
	private String ip;

	public UserDetailsImpl(String username, String password, boolean enabled,
						   boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
						   Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
	}

	/**
	 * @return el atributo nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre parametro nombre a actualizar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return el atributo apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno parametro apellidoPaterno a actualizar
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return el atributo apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno parametro apellidoMaterno a actualizar
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return el atributo ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip parametro ip a actualizar
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/*
	 * La documentación de este método se encuentra en la clase o interface que lo declara
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("UserDetailsImpl [nombre=");
		builder.append(nombre);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", ip=");
		builder.append(ip);
		builder.append("]");
		return builder.toString();
	}


}
