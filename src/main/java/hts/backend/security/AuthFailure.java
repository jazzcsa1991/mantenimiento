package hts.backend.security;

import hts.backend.model.RespuestaGenerica;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Implementación del manejador de fallo de autenticación.
 * Controla la respuesta devuelta al cliente en intentos de autenticación con credenciales incorrectas, usuario no existente y usuario deshabilitado.
 */
@Component
public class AuthFailure implements AuthenticationFailureHandler {

	private static final Log logger = LogFactory.getLog(AuthFailure.class);

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException) throws IOException {
		String msj;

		if (authenticationException.getClass().isAssignableFrom(UsernameNotFoundException.class)) {
			msj = "Credenciales incorrectas";
		} else if (authenticationException.getClass().isAssignableFrom(BadCredentialsException.class)) {
			msj = "Credenciales incorrectas";
		} else if (authenticationException.getClass().isAssignableFrom(DisabledException.class)) {
			msj = "Usuario sin autorización para acceder al sistema";
		} else {
			msj = "Autenticación fallida";
		}

		logger.warn(msj + " :::: " + authenticationException.getMessage());

		RespuestaGenerica respuesta = new RespuestaGenerica(0, msj);
		Jackson2JsonObjectMapper jackson2JsonObjectMapper = new Jackson2JsonObjectMapper();

		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setCharacterEncoding(StandardCharsets.UTF_8.toString());

		try {
			response.getWriter().write(jackson2JsonObjectMapper.toJson(respuesta));
		} catch (Exception e) {
			e.printStackTrace();
			response.getOutputStream().println("{\"ok\":false,\"msj\":\"" + msj + "\"}");
		}
	}
}