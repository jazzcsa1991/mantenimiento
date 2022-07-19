/**
 * MenuDAO.java
 * Fecha de creación: 10/09/2015, 14:04:21
 * <p>
 * Copyright (c) 2016 SASA
 * Soluciones de Autoservicio y Servicios Asociados
 * Margaritas 426 Col. Hacienda Guadalupe Chimalistac
 * Todos los derechos reservados.
 * <p>
 * Este software es información confidencial, propiedad del
 * Soluciones de Autoservicio y Servicios Asociados
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia Institucion.
 */
package hts.backend.dao;

import hts.backend.model.dto.AccionDTO;
import hts.backend.model.dto.MenuDTO;
import hts.backend.model.dto.SubmenuDTO;

import java.util.List;


/**
 * @author SASA-Desarrollo3
 */
public interface MenuDAO {

// language=MySQL
	public static final String QRY_PORTALES_DISP = "SELECT PORTAL_ID as id  , DESCRIPCION as nombre " +
			"FROM PORTAL " +
			"WHERE STATUS =  1 " +
			"ORDER BY DESCRIPCION";
	// language=MySQL
	public static final String QRY_MODULOS_DISP = "SELECT modu.MODULO_ID as id , modu.NOMBRE as nombre " +
			"FROM MODULOS modu " +
			"WHERE modu.PORTAL_ID = :p_portalID  " +
			"AND modu.STATUS = 1 " +
			"ORDER BY modu.NOMBRE";

	// language=MySQL
	public static final String QRY_ACCIONES_ASIG = "SELECT accion.ACCION_ID  as id , accion.NOMBRE as nombre " +
			"FROM ACCION accion  " +
			"WHERE accion.accion_id  in (  " +
			"SELECT cra.ACCION_ID  " +
			"FROM  CATROLACCION cra  " +
			"WHERE accion.PORTAL_ID = cra.PORTAL_ID  " +
			"AND accion.MODULO_ID = cra.MODULO_ID  " +
			"AND accion.ACCION_ID = cra.ACCION_ID   " +
			"AND cra.ROL_ID = :p_rolID  " +
			"AND cra.PORTAL_ID = :p_portalID  " +
			"AND cra.MODULO_ID = :p_moduloID   " +
			")  " +
			"AND ACCION.PORTAL_ID = :p_portalID  " +
			"AND ACCION.MODULO_ID = :p_moduloID";
	// language=MySQL
	public static final String QRY_ACCIONES_DISP = "SELECT accion.ACCION_ID  as id , accion.NOMBRE as nombre " +
			"FROM ACCION accion  " +
			"WHERE accion.accion_id  not in (  " +
			"SELECT cra.ACCION_ID  " +
			"FROM  CATROLACCION cra  " +
			"WHERE accion.PORTAL_ID = cra.PORTAL_ID  " +
			"AND accion.MODULO_ID = cra.MODULO_ID  " +
			"AND accion.ACCION_ID = cra.ACCION_ID   " +
			"AND cra.ROL_ID = :p_rolID  " +
			"AND cra.PORTAL_ID = :p_portalID  " +
			"AND cra.MODULO_ID = :p_moduloID   " +
			")  " +
			"AND ACCION.PORTAL_ID = :p_portalID  " +
			"AND ACCION.MODULO_ID = :p_moduloID";


	public List<MenuDTO> getPortal(Integer role_id);

	public List<MenuDTO> getMenus(Integer portal_id, Integer role_id);

	public List<SubmenuDTO> getsubMenus(Integer role_id, Integer portal_id, Integer modulo_id);

	public List<MenuDTO> obtenPortalesDisponibles();

	public List<MenuDTO> obtenmodulosPorPortal(MenuDTO dto);

	public List<MenuDTO> obtenAccionesAsig(AccionDTO dto);

	public List<MenuDTO> obtenAccionesDisp(AccionDTO dto);


}
