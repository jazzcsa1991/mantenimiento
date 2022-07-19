package hts.backend.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hts.backend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.UsuarioDTO;


@Controller
@RequestMapping({"/loginUsuario"})
public class LoginController {
	@Autowired
	LoginService loginService;


	@RequestMapping(value="/generaPortal", method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody RespuestaGenerica obtenPortal(HttpServletRequest request,
	HttpServletResponse response) {

		UsuarioDTO usu = loginService.validaUsuario(1);
		RespuestaGenerica resp = new RespuestaGenerica();
		resp.setEstatus(1);
		resp.setMensaje("OK");
		Map<String, Object> test = new HashMap<String, Object>();
		test.put("usuario", usu);
		resp.setInformacion(test);

		return resp;
	}
}
