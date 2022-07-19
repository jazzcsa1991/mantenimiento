package hts.backend.service;

import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.AdminCorreoDTO;
import hts.backend.model.dto.AdminTelefonoDTO;
import hts.backend.model.dto.AdminUsuarioDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioAdminService extends UserDetailsService {


	RespuestaGenerica listar();

	RespuestaGenerica guardarUsuario(AdminUsuarioDTO usuarioAdminDTO);

	RespuestaGenerica editarUsuario(AdminUsuarioDTO usuarioAdminDTO);

	RespuestaGenerica guardarTelefonosUsuario(List<AdminTelefonoDTO> admTelefonoAdminDTO);

	RespuestaGenerica guardarCorreoUsuario(List<AdminCorreoDTO> correoAdmin);

	RespuestaGenerica editarPassWord(AdminUsuarioDTO usuarioAdminDTO);

	RespuestaGenerica editarTelefonoUsuario(AdminTelefonoDTO admTelefonoAdminDTO);

	RespuestaGenerica editarCorreoUsuario(AdminCorreoDTO admTelefonoAdminDTO);

	RespuestaGenerica obtenerTelefonosByUsuario(AdminUsuarioDTO usuarioAdminDTO);

	RespuestaGenerica listarUsuarios();

	RespuestaGenerica obtenerCorreosByUsuarios(AdminUsuarioDTO usuarioAdminDTO);

	RespuestaGenerica eliminarTelefonoUsuario(AdminTelefonoDTO adminTelefonoDTO);

	RespuestaGenerica eliminarCorreoUsuario(AdminCorreoDTO adminCorreoDTO);

	RespuestaGenerica obtenerHistoricoPassUsuario(AdminUsuarioDTO usuarioAdminDTO);

	RespuestaGenerica eliminarUsuarioAdmin(AdminUsuarioDTO usuarioAdminDTO);

	RespuestaGenerica generarClaveRecuperacion(AdminUsuarioDTO usuarioAdminDTO);

	RespuestaGenerica recuperarPassword(String clave, String password);


}
