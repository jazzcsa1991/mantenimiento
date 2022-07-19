package hts.backend.dao;

import hts.backend.model.UsuarioAdmin;
import hts.backend.dao.impl.BaseDAO;

import java.util.List;
import java.util.Map;

public interface UsuarioAdminDAO extends BaseDAO {
	List listar();

	Map consultar(Long id);

	UsuarioAdmin obtenerEntidad(int id);

	UsuarioAdmin obtenerEntidad(String usuario);

	List listarTelefonosUsuarios(Integer usuarioId);

	List listarCorreosUsuarios(Integer usuarioId);

	 List  listarUsuarios();

	List listarHistoricoPass(Integer usuarioId);

	List obtenerProfesionalCorreo(String correo);

	// language=Oracle
	String QRY_SET_NOT_GENERIC = "alter session set NLS_COMP='BINARY'";
	// language=Oracle
	String QRY_SET_NOT_GENERIC2 = "alter session set NLS_SORT='BINARY_CI'";
	// language=Oracle
	String QRY_USUARIO = "SELECT a.* FROM ADM_USUARIO a " +
			"WHERE (USERNAME) = :pUsername";
	// language=Oracle
	String QRY_RETURN_GENERIC = "alter session set NLS_COMP='LINGUISTIC'";
	// language=Oracle
	String QRY_RETURN_GENERIC2 = "alter session set NLS_SORT='GENERIC_M_AI'";
}
