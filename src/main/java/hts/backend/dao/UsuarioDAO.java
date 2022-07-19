package hts.backend.dao;

import hts.backend.entity.Roles;
import hts.backend.entity.AdmPersonal;
import hts.backend.entity.AdmUsuario;
import hts.backend.entity.AdmUsuarioProfesional;

import java.util.List;

public interface UsuarioDAO {

/*	 UserProfileDTO getEstatusDTO(String username);

	 List<UserProfileDTO> getUserListDTO();*/

	List<Roles> getRoles() throws Exception;

	int altaUsuario(AdmUsuario entidadUsuario);

	AdmUsuario obtenerUsuarioId(Integer userId);

	AdmPersonal obtenerProfecionalId(Integer admProfSaludGralId);

	int altaUsuarioProfecional(AdmUsuarioProfesional userProfesionalId);

	/* Usuario altaUsers(Usuario userent) throws Exception;

	 Integer getIdUser(String username) throws Exception;

	Roles obtieneRole(Integer roleId)throws Exception;

	Integer updateUsers(Usuario userent) throws Exception;

	Integer deleteUsers(Usuario userent) throws Exception;

	Integer deleteRole(Roles entrole) throws Exception;

	Integer altaRole(Roles entrole) throws Exception;

	Integer updateRole(Roles entrole) throws Exception;

	Integer altaServicioUsuario(UsuariosServicios servicios) throws Exception;

	List<ServicioEspecialidadDTO> obtenServicios(UserProfileDTO user) throws Exception;

	Usuario getUser(String name);

	List<CedulaDTO> obtenerCedulas(Integer profSaludGralId);*/
}
