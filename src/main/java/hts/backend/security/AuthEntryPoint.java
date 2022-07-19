package hts.backend.security;

import hts.backend.model.RespuestaGenerica;
import org.springframework.http.MediaType;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Implementación del punto de entrada de autenticación.
 * Controla la respuesta devuelta al cliente cuando se intenta acceder sin credenciales a un recurso protegido.
 */
@Component
public class AuthEntryPoint implements AuthenticationEntryPoint {

	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException) throws IOException, ServletException {
		RespuestaGenerica respuesta = new RespuestaGenerica(0, "Se requiere autenticación", "error", authenticationException.getMessage());
		Jackson2JsonObjectMapper jackson2JsonObjectMapper = new Jackson2JsonObjectMapper();

		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setCharacterEncoding(StandardCharsets.UTF_8.toString());

		try {
			response.getWriter().write(jackson2JsonObjectMapper.toJson(respuesta));
		} catch (Exception e) {
			e.printStackTrace();
			response.getOutputStream().println("{\"ok\":false,\"msj\":\"Se requiere autenticación\",\"error\": \"" + authenticationException.getMessage() + "\" }");
		}
	}
}