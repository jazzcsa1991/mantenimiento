package hts.backend.controller;


import hts.backend.model.RespuestaGenerica;
import hts.backend.model.UsuarioAdmin;
import hts.backend.model.dto.AdminPermisosDTO;
import hts.backend.service.AdminPermisosService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.annotation.Bean;

import java.util.Map;

@RestController
@RequestMapping({"/admpermisos"})
public class AdminPermisosController {

	private final AdminPermisosService admPermisosService;
	private static final Log logger = LogFactory.getLog(CatalogosController.class);


	public AdminPermisosController(AdminPermisosService admPermisosService) {
		this.admPermisosService = admPermisosService;
	}


	@ResponseBody
	@RequestMapping(value = "/guardarPermisos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica guardarPermisos(@RequestBody Map<String, Object> mapa) {
		return admPermisosService.guardarPermisos(mapa);
	}

	@ResponseBody
	@RequestMapping(value = "/editarPermisos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica editarPermisos(@RequestBody AdminPermisosDTO adminPermisosDTO) {
		return admPermisosService.editarPermisos(adminPermisosDTO);
	}

	@ResponseBody
	@RequestMapping(value = "/eliminarPermisos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica eliminarPermisos(@RequestBody AdminPermisosDTO adminPermisosDTO) {
		return admPermisosService.eliminarPermisos(adminPermisosDTO);
	}

	@ResponseBody
	@RequestMapping(value = "/consultarPermisosUsuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica consultarPermisosUsuario(@RequestBody AdminPermisosDTO adminPermisosDTO) {
		return admPermisosService.consultarPermisos(adminPermisosDTO.getUsuarioAdminId());
	}
	@ResponseBody
	@RequestMapping(value = "/consultarPermisos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica consultarPermisos() {
		logger.info("############# OBTENIENDO PERMISOS  #####################");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info("############# OBTENIENDO PERMISOS 2  #####################");
		logger.info(auth);
		logger.info(auth.getPrincipal());
		var r = "SISTEMAS";
		logger.info(r.getClass().getName());
		logger.info(auth.getPrincipal().getClass().getName());

		UsuarioAdmin usuario = (UsuarioAdmin) auth.getPrincipal();
		logger.info("############# OBTENIENDO PERMISOS 3  #####################");
		logger.info(usuario);
		return admPermisosService.consultarPermisos(usuario.getUsuarioAdminId());
	}


}
