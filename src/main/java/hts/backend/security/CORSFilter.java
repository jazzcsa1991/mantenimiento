/**
 * CORSFilter.java
 * Fecha de creación: 17/09/2015, 19:11:27
 *
 * Copyright (c) 2016 SASA
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad de SASA
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia Empresa.
 */

package hts.backend.security;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Hugo A. Cruz Trujillo (hugo.cruzt@gmail.com)
 * @version 1.0 s
 */

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Hugo A. Cruz Trujillo (hugo.cruzt@gmail.com)
 * @version 1.0
 */
public class CORSFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;

        response.addHeader("X-FRAME-OPTIONS", "DENY");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers",
                "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent, X-AUTH-TOKEN");
        response.setHeader("Access-Control-Expose-Headers", "X-AUTH-TOKEN");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        chain.doFilter(req, res);
    }

    public void init(FilterConfig filterConfig) {
        //
    }

    public void destroy() {
        //
    }

}
