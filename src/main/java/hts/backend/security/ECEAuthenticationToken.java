package hts.backend.security;


import hts.backend.model.UsuarioAdmin;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Implementación propia del sistema para autenticación abstracta mediante token.
 * Define el objeto utilizado para el objeto principal de autenticación.
 */
public class ECEAuthenticationToken extends AbstractAuthenticationToken {
    private final UsuarioAdmin principal;
    private Object credentials;

    public ECEAuthenticationToken(UsuarioAdmin principal, Object credentials) {
        super((Collection) null);
        this.principal = principal;
        this.credentials = credentials;
        this.setAuthenticated(false);
    }

    public ECEAuthenticationToken(UsuarioAdmin principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        super.setAuthenticated(true);
    }

    public Object getCredentials() {
        return this.credentials;
    }

    public UsuarioAdmin getPrincipal() {
        return this.principal;
    }

    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        } else {
            super.setAuthenticated(false);
        }
    }

    public void eraseCredentials() {
        super.eraseCredentials();
        this.credentials = null;
    }
}
