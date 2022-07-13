package hts.backend.dao;

public interface AccesoRolesDAO extends GenericHibernateDAO {
	
	/**
	 * Valida si el rol del usuario actual tiene permisos para ejecutar la función solicitada
	 *
	 * @param gusFuncionId - Identificador de la función de sistema que se desea validar
	 *
	 * @return true/false
	 */
	boolean validarFS(int gusFuncionId);

}
