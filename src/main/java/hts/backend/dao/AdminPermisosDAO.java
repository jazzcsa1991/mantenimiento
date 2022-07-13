package hts.backend.dao;

import hts.backend.model.UsuarioAdmin;
import hts.backend.dao.impl.BaseDAO;

import java.util.List;
import java.util.Map;

public interface AdminPermisosDAO extends BaseDAO {


	List listarPermisosByUsuario(Integer usuarioId);
	Map<String, Object> listarPermisosUsuarioHospital(Integer usuarioId, Integer hospitalId);
	Boolean validarPermiso(UsuarioAdmin usuario, Integer posicion , Integer hospitalId);


}
