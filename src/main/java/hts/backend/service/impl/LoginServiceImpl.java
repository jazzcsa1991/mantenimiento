package hts.backend.service.impl;

import hts.backend.service.LoginService;
import hts.backend.dao.LoginDAO;
import hts.backend.model.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDAO loginDAO;

	@Override
	public UsuarioDTO validaUsuario(int idUsuario) {
		return loginDAO.validaUsuario(idUsuario);
	}

	@Override
	public UsuarioDTO validaLogin(String usuario, String password) {
		return loginDAO.validaLogin(usuario, password);
	}

}
