package hts.backend.service;

import hts.backend.model.dto.PerfilDTO;
import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.RolDTO;
import hts.backend.model.dto.ProfesionalRolDTO;

public interface PermisosService {

	/**
	 * Metodo Encargado de obtener los roles de la Tabla CATROL
	 * @return
	 */
	public RespuestaGenerica obtenRoles(PerfilDTO dto);

	/**
	 * Metodo Encargado de obtener los roles de la Tabla CATPERFIL
	 * @return
	 */
	public RespuestaGenerica obtenPerfiles();

	/**
	 * METODO ENCARGADO DE REGISTRAR UN NUEVO ROL EN LA TABLA DE CATROL
	 * @param dto
	 * @return
	 */

	public RespuestaGenerica altaRol(RolDTO dto);

	/**
	 * METODO ENCARGADO DE ACTUALIZAR UN ROL EN LA TABLA DE CATROL
	 * @param dto
	 * @return
	 */
	public RespuestaGenerica actualizaRol(RolDTO dto);

	/**
	 * METODO ENCARGADO DE ASIGNAR UNA FUNCION AL ROL EN LA TABLA DE ADM_ROL_FUNCION
	 * @param dto
	 * @return
	 */
	public RespuestaGenerica asignaFuncionToRol(RolDTO dto);
	/**
	 * METODO ENCARGADO DE OBTENER LOS ROLES ACTIVOS ASOCIADOS A UN PERFIL
	 * @param dto
	 * @return
	 */
	public RespuestaGenerica obtenerRolesPorPerfil(RolDTO dto);

	public RespuestaGenerica obtenerRolesProfesional(ProfesionalRolDTO dto);

	RespuestaGenerica obtenerRolesByHospByPerf(RolDTO dto);
}
