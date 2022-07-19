package hts.backend.service;

import hts.backend.model.dto.UsuarioDTO;

public interface LoginService {


	public UsuarioDTO validaUsuario(int idUsuario);
	public UsuarioDTO validaLogin(String usuario, String password);

}
