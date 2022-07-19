package hts.backend.service.impl;

import hts.backend.service.MenuServices;
import hts.backend.dao.MenuDAO;
import hts.backend.model.dto.*;
import hts.backend.model.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service("MenuServices")
public class MenuServicesImpl implements MenuServices {

	private static final Log logger = LogFactory.getLog(MenuServicesImpl.class);

	@Resource
	private MenuDAO menudao;

	@Override
	@Transactional
	public RespuestaGenerica getPortal(Integer role_id) throws Exception {
		// Servicio para validacion de usuario y password

		List<MenuDTO> portales = menudao.getPortal(role_id);
		logger.debug("lista:: " + role_id + " portales" + portales.size() + portales.toString());
		Map<String, Object> informacion = new HashMap<String, Object>();
		informacion.put("Portales", portales);

		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", informacion);
	}

	@Override
	@Transactional
	public RespuestaGenerica getMenus(Integer portal_id, Integer role_id) throws Exception {
		// Servicio para validacion de usuario y password

		List<MenuDTO> lstmenus = menudao.getMenus(portal_id, role_id);
		List<SubmenuDTO> lstsubmenus = null;
		List<MenuDTO> lstobjects = new ArrayList<MenuDTO>();

		logger.debug("lista:: " + lstmenus.size() + lstmenus.toString());

		for (Iterator<MenuDTO> iter = lstmenus.iterator(); iter.hasNext(); ) {

			MenuDTO element = iter.next();
			Integer menu_id = element.getId();
//			    lstsubmenus = menudao.getsubMenus(element.getId());
			element.setSubmenu(lstsubmenus);
			lstobjects.add(element);

		}

		Map<String, Object> informacion = new HashMap<String, Object>();
		informacion.put("LstMenus", lstobjects);

		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", informacion);
	}


	@Override
	@Transactional
	public RespuestaGenerica getSubMenu(Integer role_id, Integer portal_id, Integer modulo_id) throws Exception {

		List<SubmenuDTO> lstsubmenus = menudao.getsubMenus(role_id, portal_id, modulo_id);

		logger.debug("lista:::" + lstsubmenus.size() + lstsubmenus.toString());

		Map<String, Object> informacion = new HashMap<String, Object>();

		informacion.put("lstsubmenus", lstsubmenus);

		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", informacion);
	}


	@Override
	@Transactional
	public RespuestaGenerica obtenPortalesDisponibles() {
		logger.info("######### invocando a DAO para OBTENER LOS PORTALES DISPONIBLES");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "portales", menudao.obtenPortalesDisponibles());
	}


	@Override
	@Transactional
	public RespuestaGenerica obtenmodulosPorPortal(MenuDTO dto) {
		logger.info("######### invocando a DAO para OBTENER LOS MODULOS PARA EL PORTAL " + dto.getId());
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "modulos", menudao.obtenmodulosPorPortal(dto));
	}


	@Override
	@Transactional
	public RespuestaGenerica obtenAccionesAsig(AccionDTO dto) {
		logger.info("######### invocando a DAO para OBTENER LOS ACCIONES ASIGNADAS");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "opcionesAsig", menudao.obtenAccionesAsig(dto));
	}


	@Override
	@Transactional
	public RespuestaGenerica obtenAccionesDisp(AccionDTO dto) {
		logger.info("######### invocando a DAO para OBTENER LAS ACCIONES DISPONIBLES");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "opcionesDisp", menudao.obtenAccionesDisp(dto));
	}
}
