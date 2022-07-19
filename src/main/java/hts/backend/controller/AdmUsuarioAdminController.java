package hts.backend.controller;

import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.AdminCorreoDTO;
import hts.backend.model.dto.AdminTelefonoDTO;
import hts.backend.model.dto.AdminUsuarioDTO;
import hts.backend.service.UsuarioAdminService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping({"/usuarioadmin"})
public class AdmUsuarioAdminController {

	private final UsuarioAdminService usuarioAdminService;


	public AdmUsuarioAdminController(UsuarioAdminService usuarioAdminService) {
		this.usuarioAdminService = usuarioAdminService;
	}


	@ResponseBody
	@RequestMapping(value = "/guardarUsuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica guardarUsuario(@RequestBody AdminUsuarioDTO usuarioAdminDTO) {
		return usuarioAdminService.guardarUsuario(usuarioAdminDTO);
	}

	@ResponseBody
	@RequestMapping(value = "/editarUsuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica editarUsuario(@RequestBody AdminUsuarioDTO usuarioAdminDTO) {
		return usuarioAdminService.editarUsuario(usuarioAdminDTO);
	}

	@ResponseBody
	@RequestMapping(value = "/guardarTelefonosUsuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica guardarTelefonosUsuario(@RequestBody List<AdminTelefonoDTO> adminTelefonoDTO) {
		return usuarioAdminService.guardarTelefonosUsuario(adminTelefonoDTO);
	}

	@ResponseBody
	@RequestMapping(value = "/guardarCorreoUsuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica guardarCorreoUsuario(@RequestBody List<AdminCorreoDTO> admCorreoAdminDTO) {
		return usuarioAdminService.guardarCorreoUsuario(admCorreoAdminDTO);
	}

	@ResponseBody
	@RequestMapping(value = "/editarPassWord", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica editarPassWord(@RequestBody AdminUsuarioDTO usuarioAdminDTO) {
		return usuarioAdminService.editarPassWord(usuarioAdminDTO);
	}

	@ResponseBody
	@RequestMapping(value = "/editarCorreoUsuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica editarCorreoUsuario(@RequestBody AdminCorreoDTO admCorreoAdminDTO) {
		return usuarioAdminService.editarCorreoUsuario(admCorreoAdminDTO);
	}

	@ResponseBody
	@RequestMapping(value = "/editarTelefonoUsuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica editarTelefonoUsuario(@RequestBody AdminTelefonoDTO adminTelefonoDTO) {
		return usuarioAdminService.editarTelefonoUsuario(adminTelefonoDTO);
	}

	@ResponseBody
	@RequestMapping(value = "/obtenerTelefonosByUsuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerTelefonosByUsuario(@RequestBody AdminUsuarioDTO adminUsuarioDTO) {
		return usuarioAdminService.obtenerTelefonosByUsuario(adminUsuarioDTO);
	}

	@ResponseBody
	@RequestMapping(value = "/obtenerCorreosByUsuarios", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerCorreosByUsuarios(@RequestBody AdminUsuarioDTO adminUsuarioDTO) {
		return usuarioAdminService.obtenerCorreosByUsuarios(adminUsuarioDTO);
	}

	@ResponseBody
	@RequestMapping(value = "/listarUsuarios", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listarUsuarios() {
		return usuarioAdminService.listarUsuarios();
	}

	@ResponseBody
	@RequestMapping(value = "/eliminarTelefonoUsuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica eliminarTelefonoUsuario(@RequestBody AdminTelefonoDTO adminTelefonoDTO) {
		return usuarioAdminService.eliminarTelefonoUsuario(adminTelefonoDTO);
	}

	@ResponseBody
	@RequestMapping(value = "/eliminarCorreoUsuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica eliminarCorreoUsuario(@RequestBody AdminCorreoDTO adminCorreoDTO) {
		return usuarioAdminService.eliminarCorreoUsuario(adminCorreoDTO);
	}

	@ResponseBody
	@RequestMapping(value = "/obtenerHistoricoPassUsuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerHistoricoPassUsuario(@RequestBody AdminUsuarioDTO adminUsuarioDTO) {
		return usuarioAdminService.obtenerHistoricoPassUsuario(adminUsuarioDTO);
	}

	@ResponseBody
	@RequestMapping(value = "/eliminarUsuarioAdmin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica eliminarUsuarioAdmin(@RequestBody AdminUsuarioDTO adminUsuarioDTO) {
		return usuarioAdminService.eliminarUsuarioAdmin(adminUsuarioDTO);
	}

	@ResponseBody
	@RequestMapping(value = "password/generarClaveRecuperacion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica generarClaveRecuperacion(@RequestBody AdminUsuarioDTO adminUsuarioDTO) {
		return usuarioAdminService.generarClaveRecuperacion(adminUsuarioDTO);
	}

	@ResponseBody
	@RequestMapping(value = "password/recuperar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica recuperarPassword(@RequestBody Map<String, Object> datos) {
		try {
			return usuarioAdminService.recuperarPassword(String.valueOf(datos.get("clave")), String.valueOf(datos.get("password")));
		} catch (Exception e) {
			return new RespuestaGenerica(0, e.getMessage());
		}
	}

}
