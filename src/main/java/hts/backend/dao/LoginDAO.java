package hts.backend.dao;

import hts.backend.model.dto.UsuarioDTO;

public interface LoginDAO {

	public UsuarioDTO validaUsuario(int idUsuario);

	public UsuarioDTO validaLogin(String usuario, String password);

}
