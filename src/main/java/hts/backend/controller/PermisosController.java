package hts.backend.controller;

import hts.backend.service.PermisosService;
import hts.backend.model.dto.PerfilDTO;
import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.RolDTO;
import hts.backend.model.dto.ProfesionalRolDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/permisos"})
public class PermisosController {
	private final PermisosService permisosService;

	@Autowired
	public PermisosController(PermisosService permisosService) {
		this.permisosService = permisosService;
	}


	@RequestMapping(value = "/obtenPerfiles", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	RespuestaGenerica obtenPerfiles() {
		return permisosService.obtenPerfiles();
	}


	@RequestMapping(value = "/obtenRoles", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	RespuestaGenerica obtenRoles(@RequestBody PerfilDTO dto) {
		return permisosService.obtenRoles(dto);
	}


	@RequestMapping(value = "/altaRol", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	RespuestaGenerica altaRol(@RequestBody RolDTO dto) {
		return permisosService.altaRol(dto);
	}


	@RequestMapping(value = "/actualizaRol", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	RespuestaGenerica actualizaRol(@RequestBody RolDTO dto) {
		return permisosService.actualizaRol(dto);
	}


	@RequestMapping(value = "/asignaFuncionesRol", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	RespuestaGenerica asignaFuncionesRol(@RequestBody RolDTO dto) {
		return permisosService.asignaFuncionToRol(dto);
	}


	@RequestMapping(value = "/obtenerRolesByPerfilId", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	RespuestaGenerica obtenerRolesPorPerfil(@RequestBody RolDTO dto) {
		return permisosService.obtenerRolesPorPerfil(dto);
	}


	@RequestMapping(value = "/obtenerRolesProfesional", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	RespuestaGenerica obtenerRolesProfesional(@RequestBody ProfesionalRolDTO dto) {
		return permisosService.obtenerRolesProfesional(dto);
	}


	@RequestMapping(value = "/obtenerRolesByHospByPer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	RespuestaGenerica obtenerRolesByHospByPer(@RequestBody RolDTO dto) {
		return permisosService.obtenerRolesByHospByPerf(dto);
	}
}
