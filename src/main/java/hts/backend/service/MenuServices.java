package hts.backend.service;


import hts.backend.model.dto.AccionDTO;
import hts.backend.model.dto.MenuDTO;
import hts.backend.model.RespuestaGenerica;

public interface MenuServices {

	public RespuestaGenerica getPortal(Integer role_id) throws Exception;

	public RespuestaGenerica getMenus(Integer portal_id, Integer role_id) throws Exception;

	public RespuestaGenerica getSubMenu(Integer role_id, Integer portal_id, Integer modulo_id) throws Exception;

	/**
	 * Metodo encargado de obtener los portales activos
	 *
	 * @return
	 */
	public RespuestaGenerica obtenPortalesDisponibles();

	/**
	 * Metodo encargado de obetener los modulos filtrados por portal.
	 *
	 * @param dto
	 * @return
	 */
	public RespuestaGenerica obtenmodulosPorPortal(MenuDTO dto);

	/**
	 * Metodo encargado de obtener las acciones asignadas por SERVICIO , ESPECIALIDAD
	 *
	 * @param dto
	 * @return
	 */
	public RespuestaGenerica obtenAccionesAsig(AccionDTO dto);

	/**
	 * Metodo encargado de obtener las acciones disponibles por SERVICIO , ESPECIALIDAD
	 *
	 * @param dto
	 * @return
	 */
	public RespuestaGenerica obtenAccionesDisp(AccionDTO dto);

}
