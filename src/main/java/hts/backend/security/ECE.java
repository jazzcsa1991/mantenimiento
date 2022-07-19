package hts.backend.security;

import hts.backend.model.UsuarioAdmin;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Wrapper para la obtención de la entidad del usuario autenticado en el contexto de seguridad.
 */
public abstract class ECE {
	public static UsuarioAdmin usuarioAutenticado() {


		return (UsuarioAdmin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}
