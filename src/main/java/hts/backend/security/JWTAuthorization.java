package hts.backend.security;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWTClaimsSet;
import hts.backend.model.Globales;
import hts.backend.model.RespuestaGenerica;
import hts.backend.model.UsuarioAdmin;
import hts.backend.dao.UsuarioAdminDAO;
import org.springframework.http.MediaType;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.interfaces.RSAPrivateKey;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Extensión del filtro de autenticación básica.
 * Autoriza el acceso a los recursos del sistema validando la integridad del token de acceso indicado por el cliente.
 */
@Component
public class JWTAuthorization extends BasicAuthenticationFilter {
	private UsuarioAdminDAO usuarioAdminDAO;

	public JWTAuthorization(AuthenticationManager authManager, UsuarioAdminDAO usuarioAdminDAO) {
		super(authManager);
		this.usuarioAdminDAO = usuarioAdminDAO;
	}


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Obtiene el token de la cabecera de autenticación
		String token = request.getHeader(Globales.seg_Header);

		if (token == null || !token.startsWith("Bearer ")) {
			chain.doFilter(request, response);
			return;
		}

		ECEAuthenticationToken authentication;

		try {
			// Valida el token y obtiene el objeto de autenticación a partir del mismo
			authentication = validarToken(token);
		} catch (RuntimeException e) {
			RespuestaGenerica respuesta = new RespuestaGenerica(0, e.getMessage());
			Jackson2JsonObjectMapper jackson2JsonObjectMapper = new Jackson2JsonObjectMapper();

			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			response.setCharacterEncoding(StandardCharsets.UTF_8.toString());

			try {
				response.getWriter().write(jackson2JsonObjectMapper.toJson(respuesta));
			} catch (Exception ex) {
				e.printStackTrace();
				response.getOutputStream().println("{\"ok\":false,\"msj\":\"Token incorrecto\"}");
			}

			return;
		}

		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(request, response);
	}


	/**
	 * Valida que el token recibido sea correcto y se encuentre vigente
	 *
	 * @param token Cadena del token recibido
	 * @return Objeto de autenticación del sistema
	 * @throws RuntimeException Cuando se encuentra un problema con la validación del token
	 */
	private ECEAuthenticationToken validarToken(String token) throws RuntimeException {
		token = token.replace("Bearer ", "");
		KeyReader keyReader = new KeyReader();
		RSAPrivateKey privateKey = keyReader.getPrivate("/keys/gus-ece-private-pkcs8.der");

		// Crear desencriptador con la llave privada RSA
		RSADecrypter decrypter = new RSADecrypter(privateKey);

		EncryptedJWT jwt;
		JWTClaimsSet claims;

		try {
			// Procesar el token
			jwt = EncryptedJWT.parse(token);

			// Desencriptar el contenido
			jwt.decrypt(decrypter);

			// Obtener cuerpo del token
			claims = jwt.getJWTClaimsSet();

			// Validar emisor
			if (!claims.getIssuer().equals("SASA-GUS-ECE"))
				throw new RuntimeException("Token alterado. Esta incidencia ha sido reportada.");

			// Validar expiración
			if (claims.getExpirationTime().equals(new Date()) || claims.getExpirationTime().before(new Date()))
				throw new RuntimeException("Token expirado");

			String usuario = claims.getSubject();
			UsuarioAdmin usuarioAdmin = usuarioAdminDAO.obtenerEntidad(usuario);

			if (usuario != null) {
//				usuarioAdmin.setNumeroEmpleado(usuario);
				return new ECEAuthenticationToken(usuarioAdmin, null, new ArrayList<>());
			}
			return null;
		} catch (ParseException | JOSEException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
}