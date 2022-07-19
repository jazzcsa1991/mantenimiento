package hts.backend.service;

import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.AdminPermisosDTO;

import java.util.Map;

public interface AdminPermisosService {


	RespuestaGenerica guardarPermisos(Map<String, Object> mapa);

	RespuestaGenerica editarPermisos(AdminPermisosDTO adminPermisosDTO);

	RespuestaGenerica eliminarPermisos(AdminPermisosDTO adminPermisosDTO);

	RespuestaGenerica consultarPermisos(Integer usuarioId);


}
