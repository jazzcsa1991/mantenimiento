package hts.backend.service.impl;

import hts.backend.model.Globales;
import hts.backend.model.RespuestaGenerica;
import hts.backend.model.*;
import hts.backend.model.dto.AdminCorreoDTO;
import hts.backend.model.dto.AdminTelefonoDTO;
import hts.backend.model.dto.AdminUsuarioDTO;
import hts.backend.security.ECE;
import hts.backend.service.EmailService;
import hts.backend.service.UsuarioAdminService;
import hts.backend.dao.UsuarioAdminDAO;
import hts.backend.service.impl.MenuServicesImpl;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.*;

@Service
public class UsuarioAdminServiceImpl implements UsuarioAdminService {

	private static final Log logger = LogFactory.getLog(MenuServicesImpl.class);
	@Resource
	private UsuarioAdminDAO usuarioAdminDAO;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


	@Resource
	private EmailService emailService;

	@Override
	public RespuestaGenerica listar() {
		UsuarioAdmin usuario = ECE.usuarioAutenticado();
		return new RespuestaGenerica(1, Globales.msjOK, "lista", usuarioAdminDAO.listar());
	}

	@Override
	@Transactional
	public RespuestaGenerica guardarUsuario(AdminUsuarioDTO usuarioAdminDTO) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioAdmin usuarioRegistra = (UsuarioAdmin) auth.getPrincipal();
		if (Integer.parseInt(String.valueOf(usuarioRegistra.getPermisos().charAt(3))) != 1 && usuarioRegistra.getRoot() != 1) {
			return new RespuestaGenerica(0, "No cuenta con los permisos para realizar esta acción");
		}
		UsuarioAdmin usuario = (UsuarioAdmin) auth.getPrincipal();
		if (Integer.parseInt(String.valueOf(usuario.getPermisos().charAt(9))) != 1 && usuario.getRoot() != 1) {
			return new RespuestaGenerica(0, "No cuenta con los permisos para realizar esta acción");
		}


		UsuarioAdmin userExiste = new UsuarioAdmin();
		userExiste = usuarioAdminDAO.obtenerEntidad("*" + usuarioAdminDTO.getNumeroEmpleadoAdmin());
		String pass;
		if (userExiste == null) {
			String name = auth.getName();
			UsuarioAdmin usuarioAdmin = new UsuarioAdmin();


			int randomStrLength = 8;
			char[] possibleCharacters = (new String("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?")).toCharArray();
			String randomStr = RandomStringUtils.random(randomStrLength, 0, possibleCharacters.length - 1, false, false, possibleCharacters, new SecureRandom());
			System.out.println(randomStr);
			pass = randomStr;


			usuarioAdminDTO.setPasswordAdmin(encoder.encode(randomStr));

			if (!usuarioAdminDTO.validarDatosRequeridos())
				throw new RuntimeException(Globales.err_ParametrosInsuficientes);

			// Datos obligatorios
			usuarioAdmin.setNumeroEmpleado("*" + usuarioAdminDTO.getNumeroEmpleadoAdmin());
			usuarioAdmin.setNombre(usuarioAdminDTO.getNombreAdmin());
			usuarioAdmin.setPrimerApellido(usuarioAdminDTO.getPrimerApellidoAdmin());
			usuarioAdmin.setPassword(usuarioAdminDTO.getPasswordAdmin());
			usuarioAdmin.setRoot(usuarioAdminDTO.getRoot());
			usuarioAdmin.setFechaPassword(new Date());
			usuarioAdmin.setUsuarioRegistro(name);
			usuarioAdmin.setFechaRegistro(new Date());
			usuarioAdmin.setUsuarioNuevo(1);
			usuarioAdmin.setPermisos("0000000000");


			// Datos opcionales
			if (usuarioAdminDTO.getSegundoApellidoAdmin() != null)
				usuarioAdmin.setSegundoApellido(usuarioAdminDTO.getSegundoApellidoAdmin());


			usuarioAdminDAO.guardarEntidad(usuarioAdmin);
			usuarioAdminDTO.setUsuarioAdminId(usuarioAdmin.getUsuarioAdminId());
			usuarioAdminDTO.setPasswordAdmin(pass);
		} else {

			return new RespuestaGenerica(0, "El ususario ya existe");
		}


		return new RespuestaGenerica(1, Globales.msjOK, "usuarioAdmin", usuarioAdminDTO);
	}

	@Override
	@Transactional
	public RespuestaGenerica editarUsuario(AdminUsuarioDTO usuarioAdminDTO) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioAdmin usuarioRegistra = (UsuarioAdmin) auth.getPrincipal();
		if (Integer.parseInt(String.valueOf(usuarioRegistra.getPermisos().charAt(3))) != 1 && usuarioRegistra.getRoot() != 1) {
			return new RespuestaGenerica(0, "No cuenta con los permisos para realizar esta acción");
		}
		UsuarioAdmin usuario = usuarioAdminDAO.get(UsuarioAdmin.class, usuarioAdminDTO.getUsuarioAdminId());
		if (usuario != null) {

			if (usuario.getUsuarioAdminId() != 1) {
				usuario.setSegundoApellido(usuarioAdminDTO.getSegundoApellidoAdmin());
				usuario.setPrimerApellido(usuarioAdminDTO.getPrimerApellidoAdmin());
				usuario.setNombre(usuarioAdminDTO.getNombreAdmin());
				usuario.setRoot(usuarioAdminDTO.getRoot());

				if (usuarioAdminDAO.actualizarEntidad(usuario) != 1)
					return new RespuestaGenerica(0, "Error al actualizar usuario");
			} else {
				return new RespuestaGenerica(0, "El usuario root principal no puede ser editado");
			}
		} else {
			return new RespuestaGenerica(0, "No existe el usuario");
		}
		return new RespuestaGenerica(1, Globales.msjOK);
	}


	@Override
	@Transactional
	public RespuestaGenerica guardarTelefonosUsuario(List<AdminTelefonoDTO> AdminTelefonoDTO) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioAdmin usuarioRegistra = (UsuarioAdmin) auth.getPrincipal();
		if (Integer.parseInt(String.valueOf(usuarioRegistra.getPermisos().charAt(3))) != 1 && usuarioRegistra.getRoot() != 1) {
			return new RespuestaGenerica(0, "No cuenta con los permisos para realizar esta acción");
		}

		String name = auth.getName();


		for (AdminTelefonoDTO telefonoDTO : AdminTelefonoDTO) {

			UsuarioAdmin usuario = usuarioAdminDAO.get(UsuarioAdmin.class, telefonoDTO.getUsuarioAdminId());
			if (usuario != null) {

				AdminTelefono telefono = new AdminTelefono();

				telefono.setUsuarioAdminId(usuario.getUsuarioAdminId());
				telefono.setTelefonoAdmin(telefonoDTO.getTelefonoAdmin());
				telefono.setTipoTelefonoId(telefonoDTO.getTipoTelefonoId());
				telefono.setFechaRegistro(new Date());
				telefono.setUsuarioRegistro(name);


				usuarioAdminDAO.guardarEntidad(telefono);
			} else {

				return new RespuestaGenerica(0, "El ususario no existe");
			}
		}

		return new RespuestaGenerica(1, Globales.msjOK);
	}

	@Override
	@Transactional
	public RespuestaGenerica guardarCorreoUsuario(List<AdminCorreoDTO> correoAdmin) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioAdmin usuarioRegistra = (UsuarioAdmin) auth.getPrincipal();
		if (Integer.parseInt(String.valueOf(usuarioRegistra.getPermisos().charAt(3))) != 1 && usuarioRegistra.getRoot() != 1) {
			return new RespuestaGenerica(0, "No cuenta con los permisos para realizar esta acción");
		}

		String name = auth.getName();


		for (AdminCorreoDTO correoDTO : correoAdmin) {
			UsuarioAdmin usuario = usuarioAdminDAO.get(UsuarioAdmin.class, correoDTO.getUsuarioAdminId());
			if (usuario != null) {

				AdminCorreo correo = new AdminCorreo();
				correo.setCorreoAdmin(correoDTO.getCorreoAdmin());
				correo.setUsuarioAdminId(usuario.getUsuarioAdminId());
				correo.setFechaRegistro(new Date());
				correo.setUsuarioRegistro(name);

				usuarioAdminDAO.guardarEntidad(correo);
			} else {
				return new RespuestaGenerica(0, "El ususario no existe");
			}
		}

		return new RespuestaGenerica(1, Globales.msjOK);
	}

	@Override
	@Transactional
	public RespuestaGenerica editarPassWord(AdminUsuarioDTO usuarioAdminDTO) {


		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioAdmin usuarioAdmin = (UsuarioAdmin) auth.getPrincipal();

		if (usuarioAdmin != null) {
			if (validarPasswordHistorico(usuarioAdmin.getUsuarioAdminId(), usuarioAdminDTO.getPasswordAdmin())) {
				String pass = encoder.encode(usuarioAdminDTO.getPasswordAdmin());

				usuarioAdmin.setPassword(pass);

				usuarioAdmin.setFechaPassword(new Date());
				usuarioAdmin.setUsuarioNuevo(0);

				usuarioAdminDAO.actualizarEntidad(usuarioAdmin);

				AdminHistoricoPassword historicoPassword = new AdminHistoricoPassword();

				historicoPassword.setUsuarioAdminId(usuarioAdmin.getUsuarioAdminId());
				historicoPassword.setPassword(pass);
				historicoPassword.setUsuarioRegistro(usuarioAdmin.getNumeroEmpleado());
				historicoPassword.setFechaRegistro(new Date());
				usuarioAdminDAO.guardarEntidad(historicoPassword);
			} else {
				return new RespuestaGenerica(0, "La contraseña no puede ser igual a las 3 anteriores.");
			}
		} else {
			return new RespuestaGenerica(0, "El ususario no existe");
		}
		return new RespuestaGenerica(1, Globales.msjOK, "exito", 1);
	}

	@Override
	@Transactional
	public RespuestaGenerica editarTelefonoUsuario(AdminTelefonoDTO admTelefonoAdminDTO) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioAdmin usuarioRegistra = (UsuarioAdmin) auth.getPrincipal();
		if (Integer.parseInt(String.valueOf(usuarioRegistra.getPermisos().charAt(3))) != 1 && usuarioRegistra.getRoot() != 1) {
			return new RespuestaGenerica(0, "No cuenta con los permisos para realizar esta acción");
		}
		AdminTelefono telefono = usuarioAdminDAO.get(AdminTelefono.class, admTelefonoAdminDTO.getTelefonoAdminId());
		if (telefono != null) {


			telefono.setTelefonoAdmin(admTelefonoAdminDTO.getTelefonoAdmin());
			telefono.setTipoTelefonoId(admTelefonoAdminDTO.getTipoTelefonoId());


			usuarioAdminDAO.actualizarEntidad(telefono);
		} else {
			return new RespuestaGenerica(0, "El telefono no existe");
		}
		return new RespuestaGenerica(1, Globales.msjOK);
	}

	@Override
	@Transactional
	public RespuestaGenerica editarCorreoUsuario(AdminCorreoDTO admTelefonoAdminDTO) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioAdmin usuarioRegistra = (UsuarioAdmin) auth.getPrincipal();
		if (Integer.parseInt(String.valueOf(usuarioRegistra.getPermisos().charAt(3))) != 1 && usuarioRegistra.getRoot() != 1) {
			return new RespuestaGenerica(0, "No cuenta con los permisos para realizar esta acción");
		}
		AdminCorreo correo = usuarioAdminDAO.get(AdminCorreo.class, admTelefonoAdminDTO.getCorreoAdminId());

		if (correo != null) {
			correo.setCorreoAdmin(admTelefonoAdminDTO.getCorreoAdmin());
			usuarioAdminDAO.actualizarEntidad(correo);
		} else {
			return new RespuestaGenerica(0, "El correo no existe");
		}

		return new RespuestaGenerica(1, Globales.msjOK);
	}

	@Override
	public RespuestaGenerica obtenerTelefonosByUsuario(AdminUsuarioDTO usuarioAdminDTO) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioAdmin usuarioRegistra = (UsuarioAdmin) auth.getPrincipal();
		if (Integer.parseInt(String.valueOf(usuarioRegistra.getPermisos().charAt(3))) != 1 && usuarioRegistra.getRoot() != 1) {
			return new RespuestaGenerica(0, "No cuenta con los permisos para realizar esta acción");
		}
		return new RespuestaGenerica(1, Globales.msjOK, "listaTelefonos", usuarioAdminDAO.listarTelefonosUsuarios(usuarioAdminDTO.getUsuarioAdminId()));
	}

	@Override
	public RespuestaGenerica listarUsuarios() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioAdmin usuarioRegistra = (UsuarioAdmin) auth.getPrincipal();
		if (Integer.parseInt(String.valueOf(usuarioRegistra.getPermisos().charAt(3))) != 1 && usuarioRegistra.getRoot() != 1) {
			return new RespuestaGenerica(0, "No cuenta con los permisos para realizar esta acción");
		}
		return new RespuestaGenerica(1, Globales.msjOK, "listaUsuarios", usuarioAdminDAO.listarUsuarios());
	}

	@Override
	public RespuestaGenerica obtenerCorreosByUsuarios(AdminUsuarioDTO usuarioAdminDTO) {
		return new RespuestaGenerica(1, Globales.msjOK, "listaCorreos", usuarioAdminDAO.listarCorreosUsuarios(usuarioAdminDTO.getUsuarioAdminId()));
	}

	@Override
	@Transactional
	public RespuestaGenerica eliminarTelefonoUsuario(AdminTelefonoDTO adminTelefonoDTO) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioAdmin usuarioRegistra = (UsuarioAdmin) auth.getPrincipal();
		if (Integer.parseInt(String.valueOf(usuarioRegistra.getPermisos().charAt(3))) != 1 && usuarioRegistra.getRoot() != 1) {
			return new RespuestaGenerica(0, "No cuenta con los permisos para realizar esta acción");
		}
		AdminTelefono telefono = usuarioAdminDAO.get(AdminTelefono.class, adminTelefonoDTO.getTelefonoAdminId());
		if (telefono != null) {
			usuarioAdminDAO.eliminarEntidad(telefono);
		} else {
			return new RespuestaGenerica(0, "El telefono no existe");
		}
		return new RespuestaGenerica(1, Globales.msjOK);
	}

	@Override
	@Transactional
	public RespuestaGenerica eliminarCorreoUsuario(AdminCorreoDTO adminCorreoDTO) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioAdmin usuarioRegistra = (UsuarioAdmin) auth.getPrincipal();
		if (Integer.parseInt(String.valueOf(usuarioRegistra.getPermisos().charAt(3))) != 1 && usuarioRegistra.getRoot() != 1) {
			return new RespuestaGenerica(0, "No cuenta con los permisos para realizar esta acción");
		}
		AdminCorreo correo = usuarioAdminDAO.get(AdminCorreo.class, adminCorreoDTO.getCorreoAdminId());
		if (correo != null) {
			usuarioAdminDAO.eliminarEntidad(correo);
		} else {
			return new RespuestaGenerica(0, "El correo no existe");
		}
		return new RespuestaGenerica(1, Globales.msjOK);
	}

	@Override
	public RespuestaGenerica obtenerHistoricoPassUsuario(AdminUsuarioDTO usuarioAdminDTO) {
		return new RespuestaGenerica(1, Globales.msjOK, "listaPassUsuario", usuarioAdminDAO.listarHistoricoPass(usuarioAdminDTO.getUsuarioAdminId()));
	}

	@Override
	@Transactional
	public RespuestaGenerica eliminarUsuarioAdmin(AdminUsuarioDTO usuarioAdminDTO) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioAdmin usuarioRegistra = (UsuarioAdmin) auth.getPrincipal();
		if (Integer.parseInt(String.valueOf(usuarioRegistra.getPermisos().charAt(3))) != 1 && usuarioRegistra.getRoot() != 1) {
			return new RespuestaGenerica(0, "No cuenta con los permisos para realizar esta acción");
		}

		if (usuarioRegistra.getRoot() == 1 && usuarioRegistra.getUsuarioAdminId() == 1) {


			UsuarioAdmin usuario = usuarioAdminDAO.get(UsuarioAdmin.class, usuarioAdminDTO.getUsuarioAdminId());
			if (!usuario.getUsuarioAdminId().equals(usuarioRegistra.getUsuarioAdminId())) {

				usuario.setFechaEliminacion(new Timestamp(new Date().getTime()));
				usuario.setUsuarioEliminacion(auth.getName());

				if (usuarioAdminDAO.actualizarEntidad(usuario) != 1)
					return new RespuestaGenerica(0, "Error al eliminar Usuario");
			} else {

				return new RespuestaGenerica(0, "El usuario Root principal no puede ser eliminado");
			}
		} else {

			return new RespuestaGenerica(0, "No cuenta con los Permisos para  eliminar Usuarios");
		}


		return new RespuestaGenerica(1, Globales.msjOK);
	}


	@Override
	@Transactional
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		UsuarioAdmin usuarioAdmin;
		try {
			usuarioAdmin = usuarioAdminDAO.obtenerEntidad(usuario);
		} catch (Exception e) {
			throw new UsernameNotFoundException(usuario);
		}

		if (usuarioAdmin == null)
			throw new UsernameNotFoundException(usuario);

		return usuarioAdmin;
	}


	@Override
	@Transactional
	public RespuestaGenerica generarClaveRecuperacion(AdminUsuarioDTO usuarioAdminDTO) {
		List<Map> listaCorreos = usuarioAdminDAO.obtenerProfesionalCorreo(usuarioAdminDTO.getCorreo());

		if (listaCorreos.size() == 0) {
			logger.warn("## Recuperación de contraseña --> Usuario no localizado mediante correo \"" + usuarioAdminDTO.getCorreo() + "\".");
			return new RespuestaGenerica(1, "Solicitud recibida correctamente. Verifique su correo electrónico para continuar.");
		} else if (listaCorreos.size() > 1) {
			logger.warn("## Recuperación de contraseña --> Múltiples usuarios localizados mediante correo \"" + usuarioAdminDTO.getCorreo() + "\".");
			return new RespuestaGenerica(0, "La solicitud no se pudo procesar. Contacte al administrador del sistema para mayor información.");
		} else {
			Map registro = listaCorreos.get(0);
			AdminUsuarioRecuperacion recuperacion = new AdminUsuarioRecuperacion();

			recuperacion.setUserId((Integer) registro.get("userId"));
			recuperacion.setCorreo(String.valueOf(registro.get("correo")));
			recuperacion.setFechaRegistro(new Date());
			recuperacion.setUuid(String.valueOf(UUID.randomUUID()));

			if (usuarioAdminDAO.guardarEntidad(recuperacion) == 1) {
				// Enviar correo
				if (emailService.sendPasswordRecovery(String.valueOf(registro.get("correo")), recuperacion.getUuid(), String.valueOf(registro.get("nombre")))) {
					logger.info("## Recuperación de contraseña --> Solicitud registrada.");
					logger.info(recuperacion);
					logger.info(registro);
					return new RespuestaGenerica(1, "Solicitud recibida correctamente. Verifique su correo electrónico para continuar.");
				} else {
					logger.warn("## Recuperación de contraseña --> No se pudo enviar el correo electrónico al usuario. (" + usuarioAdminDTO.getCorreo() + " - " + registro + ")");
					throw new RuntimeException("Ocurrió un error al registrar la solicitud. Si el problema persiste contacte al administrador del sistema.");
				}
			} else {
				logger.warn("## Recuperación de contraseña --> Error al guardar entidad AdmUsuarioRecuperacion");
				logger.warn(recuperacion);
				return new RespuestaGenerica(0, "Ocurrió un error al registrar la solicitud. Si el problema persiste contacte al administrador del sistema.");
			}
		}
	}

	@Override
	@Transactional
	public RespuestaGenerica recuperarPassword(String clave, String password) throws RuntimeException {
		AdminUsuarioRecuperacion registro = usuarioAdminDAO.get(AdminUsuarioRecuperacion.class, clave);
		UsuarioAdmin usuario = registro.getAdmUsuario();
		String nuevoPassword;

		try {
			nuevoPassword = encoder.encode(password);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Ocurrió un error al procesar la nueva contraseña.");
		}

		if (registro == null) {
			logger.warn("## Recuperación de contraseña --> Registro de recuperación no localizado mediante clave \"" + clave + "\".");
			return new RespuestaGenerica(0, "Solicitud de recuperación no encontrado.");
		} else if (registro.getFechaUtilizado() == null) {
			// Validar 1 hora desde creación de solicitud de recuperación
			if (new Date().getTime() - registro.getFechaRegistro().getTime() <= 3600000) {
				if (!validarPasswordHistorico(usuario.getUsuarioAdminId(), password))
					throw new RuntimeException("La contraseña indicada ya ha sido utilizada previamente en su cuenta. Debe elegir una diferente.");

				registro.setFechaUtilizado(new Date());

				if (usuarioAdminDAO.guardarEntidad(registro) == 1) {
					usuario.setPassword(nuevoPassword);
					usuario.setFechaPassword(new Date());
					usuario.setUsuarioNuevo(0);

					// Actualizar contraseña del usuario
					if (usuarioAdminDAO.guardarEntidad(usuario) != 1)
						throw new RuntimeException("Ocurrió un error al actualizar la contraseña.");

					AdminHistoricoPassword admHistorico = new AdminHistoricoPassword();

					admHistorico.setUsuarioAdminId(usuario.getUsuarioAdminId());
					admHistorico.setPassword(usuario.getPassword());
					admHistorico.setFechaRegistro(new Date());

					// Registrar contraseña anterior en el histórico
					if (usuarioAdminDAO.guardarEntidad(admHistorico) != 1)
						throw new RuntimeException("Ocurrió un error al registrar el histórico de contraseñas.");

					// Enviar correo
					if (emailService.sendPasswordRecoveryConfirm(registro.getCorreo(), registro.getFechaUtilizado())) {
						logger.info("## Restablecimiento de contraseña --> Exitoso " + registro.getFechaUtilizado());
						logger.info(usuario);
					} else {
						logger.warn("## Restablecimiento de contraseña --> No se pudo enviar el correo electrónico de confirmación al usuario. (" + registro + ")");
					}

					return new RespuestaGenerica(1, "Contraseña actualizada");
				} else {
					throw new RuntimeException("Ocurrió un error al utilizar la clave de recuperación.");
				}
			} else {
				return new RespuestaGenerica(0, "La clave de recuperación ha expirado. Si así lo requiere, repita la solicitud de recuperación de contraseña.");
			}
		} else {
			return new RespuestaGenerica(0, "La clave de recuperación ya fue utilizada. Si así lo requiere, repita la solicitud de recuperación de contraseña.");
		}
	}

	private boolean validarPasswordHistorico(int userId, String password) {
		List<HashMap> listaHistorico = usuarioAdminDAO.listarHistoricoPass(userId);
		for (HashMap elem : listaHistorico) {
			if (encoder.matches(password, elem.get("password").toString())) {
				return false;
			}
		}
		return true;
	}
}
