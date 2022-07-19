package hts.backend.model;

import hts.backend.controller.CatalogosController;
import hts.backend.security.JWTAuthentication;
import hts.backend.security.JWTAuthorization;
import hts.backend.service.UsuarioAdminService;
import hts.backend.dao.UsuarioAdminDAO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter {
	private final AuthenticationManager customAuthenticationManager;
	private final AuthenticationProvider customAuthenticationProvider;
	private final AuthenticationEntryPoint authenticationEntryPoint;
	private final AuthenticationFailureHandler authenticationFailureHandler;
	private final AccessDeniedHandler accessDeniedHandler;
	private final UsuarioAdminService usuarioAdminService;
	private final UsuarioAdminDAO usuarioAdminDAO;
	private static final Log logger = LogFactory.getLog(CatalogosController.class);


	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


	@Autowired
	public AppSecurity(AuthenticationManager customAuthenticationManager, AuthenticationProvider customAuthenticationProvider, AuthenticationEntryPoint authenticationEntryPoint, AuthenticationFailureHandler authenticationFailureHandler, AccessDeniedHandler accessDeniedHandler, UsuarioAdminService usuarioAdminService, UsuarioAdminDAO usuarioAdminDAO) {
		logger.info("############# seguridad 1  #####################");

		this.customAuthenticationManager = customAuthenticationManager;
		this.customAuthenticationProvider = customAuthenticationProvider;
		this.authenticationEntryPoint = authenticationEntryPoint;
		this.authenticationFailureHandler = authenticationFailureHandler;
		this.accessDeniedHandler = accessDeniedHandler;
		this.usuarioAdminService = usuarioAdminService;
		this.usuarioAdminDAO = usuarioAdminDAO;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("############# seguridad 2  #####################");

		// Agregar filtro para reglas de CORS
		http.addFilterBefore(corsFilter(), ChannelProcessingFilter.class);

		// Deshabilitar validación de CORS y CRSF
		http.cors().disable();
		http.csrf().disable();
		logger.info("############# seguridad 2.1  #####################");

		// Permitir el acceso libre al inicio de sesións
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/login").permitAll();
		//http.authorizeRequests().antMatchers(HttpMethod.POST, "/gus-admin/usuarioadmin/password/generarClaveRecuperacion").permitAll();
		//http.authorizeRequests().antMatchers(HttpMethod.POST, "/gus-admin/usuarioadmin/password/recuperar").permitAll();

		// Permitir el acceso a las peticiones pre-flight
		http.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll();

		// Autenticar todas las peticiones restantes
		http.authorizeRequests().anyRequest().authenticated();
		logger.info("############# seguridad 2.2 #####################");

		// Proveedores de autenticación y autorización
		http.addFilter(new JWTAuthentication(customAuthenticationManager));
		http.addFilter(new JWTAuthorization(customAuthenticationManager, usuarioAdminDAO));

		// Deshabilidar la creación de sesiones en Spring Security
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		logger.info("############# seguridad 2.3  #####################");

		// Manejo de excepciones
		http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
		http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);

		// Manejador de errores de autenticación
		http.formLogin().failureHandler(authenticationFailureHandler);
		logger.info("############# seguridad 2.4 #####################");

		//super.configure(http);
		logger.info("############# seguridad 2.5  #####################");

	}

	@Bean
	public CorsFilter corsFilter() {
		logger.info("############# seguridad 3  #####################");

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();

		config.addAllowedOrigin("*");
		config.addExposedHeader(Globales.seg_Header);

		config.addAllowedMethod(HttpMethod.POST);
		config.addAllowedMethod(HttpMethod.GET);
		config.addAllowedMethod(HttpMethod.PATCH);
		config.addAllowedMethod(HttpMethod.DELETE);
		config.addAllowedMethod(HttpMethod.OPTIONS);

		config.addAllowedHeader("Authorization");
		config.addAllowedHeader("Content-Type");
		config.addAllowedHeader("Accept");
		config.addAllowedHeader("Origin");
		config.addAllowedHeader("X-Requested-With");
		config.addAllowedHeader("Referer");
		config.addAllowedHeader("User-Agent");

		config.setAllowCredentials(true);

		source.registerCorsConfiguration("/**", config);

		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);

		return new CorsFilter(source);
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customAuthenticationProvider).userDetailsService(usuarioAdminService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected AuthenticationManager authenticationManager() {
		return customAuthenticationManager;
	}
}
