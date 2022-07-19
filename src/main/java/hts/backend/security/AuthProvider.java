package hts.backend.security;

import hts.backend.model.UsuarioAdmin;
import hts.backend.dao.UsuarioAdminDAO;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Implementación del proveedor de autenticación.
 * Obtiene los datos del usuario solicitado y valida sus credenciales.
 */
@Component
public class AuthProvider implements AuthenticationProvider {

	@Resource
	private UsuarioAdminDAO usuarioAdminDAO;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String usuario = authentication.getName();
		String password = authentication.getCredentials().toString();
		UsuarioAdmin usuarioAdmin;

		try {
			usuarioAdmin = usuarioAdminDAO.obtenerEntidad(usuario);
		} catch (EmptyResultDataAccessException e) {
			throw new UsernameNotFoundException(usuario);
		}

		if (encoder.matches(password, usuarioAdmin.getPassword())) {
			usuarioAdmin.setNumeroEmpleado(usuario);
			return new ECEAuthenticationToken(usuarioAdmin, password, new ArrayList<>());
		}

		throw new UsernameNotFoundException(usuario);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(ECEAuthenticationToken.class);
	}
}
