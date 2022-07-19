package hts.backend.security;

import hts.backend.model.UsuarioAdmin;
import hts.backend.dao.UsuarioAdminDAO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Implementación del administrador de autenticación.
 * Se encarga de consultar si el usuario solicitado existe y, en su caso, validar que la contraseña suministrada sea correcta.
 *
 * Lanza las excepciones de seguridad que serán atendidas por el manejador de fallos de autenticación.
 *
 * @see AuthFailure
 */
@Component
public class AuthManager implements AuthenticationManager {

	@Resource
	private UsuarioAdminDAO usuarioAdminDAO;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsuarioAdmin usuarioAdmin;
		String usuario = authentication.getName();
		String password = authentication.getCredentials().toString();

		usuarioAdmin = usuarioAdminDAO.obtenerEntidad(usuario);

		if (usuarioAdmin == null)
			throw new UsernameNotFoundException("Usuario no existe (" + usuario + ")");

		if (!usuarioAdmin.isEnabled())
			throw new DisabledException("Usuario inhabilitado (" + usuario + ")");

		if (!encoder.matches(password, usuarioAdmin.getPassword()))
			throw new BadCredentialsException("Contraseña incorrecta (" + usuario + ")");

//		usuarioAdmin.setNumeroEmpleado(usuario.replace("*",""));
		return new ECEAuthenticationToken(usuarioAdmin, password, new ArrayList<>());
	}
}
