package hts.backend.dao.impl;

import hts.backend.dao.LoginDAO;
import hts.backend.model.dto.UsuarioDTO;
import org.springframework.stereotype.Repository;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {

	@Override
	public UsuarioDTO validaUsuario(int idUsuario) {

		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setNombre("Pruebas");
		usuario.setIdUsuario(1);

		return usuario;
	}

	@Override
	public UsuarioDTO validaLogin(String usuario, String password) {
		UsuarioDTO usuario1 = new UsuarioDTO();
		usuario1.setNombre("Pruebas");
		usuario1.setIdUsuario(1);
		return usuario1;
	}

}
