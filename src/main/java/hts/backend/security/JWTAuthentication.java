package hts.backend.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWTClaimsSet;
import hts.backend.model.Globales;
import hts.backend.model.RespuestaGenerica;
import hts.backend.model.UsuarioAdmin;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.Date;

/**
 * Extensión del filtro de autenticación de usuarios mediante usuario y contraseña.
 * Se encarga de autenticar usuarios en el sistema y emitir los tokens para autorizar futuros accesos a recursos.
 */
public class JWTAuthentication extends UsernamePasswordAuthenticationFilter {
	private static final Log logger = LogFactory.getLog(JWTAuthentication.class);
	private AuthenticationManager authenticationManager;

	public JWTAuthentication(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;

		// Definir manejador de error de autenticación
		setAuthenticationFailureHandler(new AuthFailure());
	}

	/**
	 * Método que inicia el proceso de autenticación de un usuario.
	 * Recibe los datos de la petición e invoca el método de autenticación del administrador de autenticación.
	 *
	 * @param req Petición de autenticación recibida
	 * @param res Respuesta del servicio
	 *
	 * @return Objeto de atenticación del sistema
	 *
	 * @throws AuthenticationException Excepción general de autenticación
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
		UsuarioAdmin usuarioAdmin;

		try {
			// Recibir parámetros - usuario, password
			usuarioAdmin = new ObjectMapper().readValue(req.getInputStream(), UsuarioAdmin.class);
			usuarioAdmin.setNumeroEmpleado("*"+usuarioAdmin.getNumeroEmpleado());
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return authenticationManager.authenticate(
				new ECEAuthenticationToken(
						usuarioAdmin,
						usuarioAdmin.getPassword(),
						new ArrayList<>()
				));
	}

	/**
	 * Método que maneja el flujo de autenticación exitosa de un usuario.
	 * Controla la respuesta devuelta al cliente en un inicio de sesión, generando y anexando el token de acceso a la respuesta.
	 *
	 * @param request  Petición de autenticación recibida
	 * @param response Respuesta del servicio
	 * @param chain    Cadena de filtros de la aplicación
	 * @param auth     Contexto principal de autenticación de la aplicación
	 */
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth) {
		Jackson2JsonObjectMapper jackson2JsonObjectMapper = new Jackson2JsonObjectMapper();
		KeyReader keyReader = new KeyReader();
		RSAPublicKey publicKey = keyReader.getPublic("/keys/gus-ece-public.der");

		// Usuario autenticado
		UsuarioAdmin usuarioAutenticado = (UsuarioAdmin) auth.getPrincipal();

		// Definir la fecha de expiración del token
		Date fechaExpiracion = new Date(System.currentTimeMillis() + Globales.seg_MilisegundosExpiracionSesion);

		// Construir token que se enviará al cliente
		JWTClaimsSet claims = new JWTClaimsSet.Builder()
				.issuer("SASA-GUS-ECE")
				.subject(usuarioAutenticado.getNumeroEmpleado())
				.claim("uid", usuarioAutenticado.getUsuarioAdminId())
				.expirationTime(fechaExpiracion)
				.notBeforeTime(new Date())
				.issueTime(new Date())
				.build();

		// Preparar cabecera para cifrado con RSA-OAEP-256 - 128-bit AES/GCM
		JWEHeader header = new JWEHeader(JWEAlgorithm.RSA_OAEP_256, EncryptionMethod.A128GCM);

		// Crear el token encriptado
		EncryptedJWT jwt = new EncryptedJWT(header, claims);

		// Crear objeto encriptador con la llave pública RSA
		RSAEncrypter encrypter = new RSAEncrypter(publicKey);

		try {
			// Encriptar el token
			jwt.encrypt(encrypter);

			// Serializar el token a la forma compacta
			String token = jwt.serialize();

			// Agregar la cabecera con el token a la respuesta
			response.addHeader(Globales.seg_Header, "Bearer " + token);
		} catch (JOSEException e) {
			e.printStackTrace();
		}

		// Respuesta del servicio web
		RespuestaGenerica respuesta = new RespuestaGenerica(1, Globales.msjOK, "usuario", usuarioAutenticado);

		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setCharacterEncoding(StandardCharsets.UTF_8.toString());

		try {
			response.getWriter().write(jackson2JsonObjectMapper.toJson(respuesta));
		} catch (Exception e) {
			e.printStackTrace();

			try {
				response.getOutputStream().println("{\"ok\":true,\"msj\":\"OK\"}");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}