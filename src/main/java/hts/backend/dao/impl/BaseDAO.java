package hts.backend.dao.impl;

import hts.backend.dao.base.TCE;
import hts.backend.dao.base.TCE_UCE;
import hts.backend.dao.base.TE;
import hts.backend.dao.base.TE_UE;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public interface BaseDAO {
	<T> T merge(T entity);

	<T> T saveOrUpdate(T entity);

	void save(Object entity);

	void flush();

	void delete(Object entity);

	<T> List<T> findAll(Class<T> clazz);

	/**
	 * Realiza consultas por medio de nameQuerys
	 * @author Rodrigo Davalos
	 * @param query
	 * @param params
	 * @return Objeto Query
	 */
	public Query getNamedQueryGeneral(String query, Object... params);

	/**
	 * Realiza consultas por medio de nameQuerys
	 * @author Rodrigo Davalos
	 * @param query
	 * @param params
	 * @return la entidad solicitada, null si no existe
	 */
	public <T> T getNamedQueryObject(String query, Object... params);

	/**
	 * Realiza consultas por medio de nameQuerys
	 * @author Rodrigo Davalos
	 * @param query
	 * @param params
	 * @return Lista de entidades
	 */
	public <T> List<T> getNamedQueryList(String query, Object... params);

	/**
	 * Devuelve el query del namequery proporcionado
	 * @author Rodrigo Davalos
	 * @param namedQuery
	 * @return Query del namedQuery
	 */
	public String getNamedQueryString(String namedQuery);
	/**
	 * Ejecuta updates, por medio del namequery
	 * @author Rodrigo Davalos
	 * @param query
	 * @param params
	 * @return Lista de entidades
	 */
	public int getNamedQueryUpdate(String query, Object... params);

	<T> T get(Class<T> clazz, Serializable id);

	<T> T getReference(Class<T> clazz, Serializable id);

	<T extends Serializable> int guardarEntidad(T entidad);

	<T extends Serializable> int actualizarEntidad(T entidad);

	<T extends Serializable> int guardarActualizarEntidad(T entidad);

	<T extends Serializable> int eliminarEntidad(T entidad);

	<T extends TE> int eliminarEntidad(T entidad);

	<T extends TE_UE> int eliminarEntidad(T entidad);

	<T extends TCE> int eliminarEntidad(T entidad);

	<T extends TCE_UCE> int eliminarEntidad(T entidad);
}
