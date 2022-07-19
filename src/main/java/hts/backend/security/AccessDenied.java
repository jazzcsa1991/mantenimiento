package hts.backend.security;

import hts.backend.model.RespuestaGenerica;
import org.springframework.http.MediaType;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Implementación del manejador de acceso denegado a recursos.
 * Controla la respuesta devuelta al cliente cuando el usuario no cuenta con acceso al recurso solicitado.
 */
@Component
public class AccessDenied implements AccessDeniedHandler {
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
		String msj = "Acceso denegado al recurso solicitado";
		RespuestaGenerica respuesta = new RespuestaGenerica(0, msj);
		Jackson2JsonObjectMapper jackson2JsonObjectMapper = new Jackson2JsonObjectMapper();

		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
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