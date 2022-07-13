package hts.backend.dao.impl;

import hts.backend.dao.base.TCE;
import hts.backend.dao.base.TCE_UCE;
import hts.backend.dao.base.TE;
import hts.backend.dao.base.TE_UE;
import hts.backend.dao.impl.BaseDAO;
import org.hibernate.Session;
import org.springframework.dao.IncorrectResultSizeDataAccessException;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public abstract class BaseDAOImpl implements BaseDAO {

	@PersistenceContext
	private EntityManager em;

	protected Session session() {
		return em.unwrap(Session.class);
	}

	@Override
	public <T> T merge(T entity) {
		return em.merge(entity);
	}

	@Override
	public void flush() {
		em.flush();
	}

	@Override
	public <T> T saveOrUpdate(T entity) {
		return em.merge(entity);
	}

	@Override
	public void save(Object entity) {
		em.persist(entity);
	}

	@Override
	public void delete(Object entity) {
		em.remove(entity);
	}

	public <T> List<T> findAll(Class<T> clazz) {
		return em.createQuery("from " + clazz.getName()).getResultList();
	}

	/**
	 * @author Rodrigo Davalos
	 */
	public Query getNamedQueryGeneral(String query, Object... params){
		Query hqlQuery;
		hqlQuery = (Query) session().getNamedQuery(query);

		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				hqlQuery.setParameter(i, params[i]);

			}
		}

		return hqlQuery;
	}

	/**
	 * @author Rodrigo Davalos
	 */
	public <T> T getNamedQueryObject(String query, Object... params) {
		try {
			return (T) getNamedQueryGeneral(query,params).getSingleResult();
		} catch (NonUniqueResultException e) {
			throw new IncorrectResultSizeDataAccessException(e.getMessage(), 1, e);
		}

	}

	/**
	 * @author Rodrigo Davalos
	 */
	public <T> List<T> getNamedQueryList(String query, Object... params) {
		return getNamedQueryGeneral(query,params).getResultList();
	}

	/**
	 * @author Rodrigo Davalos
	 */
	public String getNamedQueryString(String namedQuery) {
		return session().getNamedQuery(namedQuery).getQueryString();
	}

	/**
	 * @author Rodrigo Davalos
	 */
	public int getNamedQueryUpdate(String query, Object... params) {
		return getNamedQueryGeneral(query,params).executeUpdate();
	}

	@Override
	public <T> T get(Class<T> clazz, Serializable id) {
		return (T) session().get(clazz, id);
	}

	@Override
	public <T> T getReference(Class<T> clazz, Serializable id) {
		return em.getReference(clazz, id);
	}

	@Override
	public <T extends Serializable> int guardarEntidad(T entidad) {
		em.persist(entidad);
		em.flush();

		return 1;
	}

	@Override
	public <T extends Serializable> int actualizarEntidad(T entidad) {
		em.merge(entidad);
		em.flush();

		return 1;
	}

	@Override
	public <T extends Serializable> int guardarActualizarEntidad(T entidad) {
		session().saveOrUpdate(entidad);
		session().flush();

		return 1;
	}

	@Override
	public <T extends Serializable> int eliminarEntidad(T entidad) {
		em.remove(entidad);
		em.flush();

		return 1;
	}

	private <T> int eliminacionLogica(T entidad) {
		em.merge(entidad);
		em.flush();

		return 1;
	}

	@Override
	public <T extends TE> int eliminarEntidad(T entidad) {
		entidad.setTs_eliminacion(new Timestamp(new Date().getTime()));

		return eliminacionLogica(entidad);
	}

	@Override
	public <T extends TE_UE> int eliminarEntidad(T entidad) {
		entidad.setTs_eliminacion(new Timestamp(new Date().getTime()));

		return eliminacionLogica(entidad);
	}

	@Override
	public <T extends TCE> int eliminarEntidad(T entidad) {
		entidad.setTs_eliminacion(new Timestamp(new Date().getTime()));

		return eliminacionLogica(entidad);
	}

	@Override
	public <T extends TCE_UCE> int eliminarEntidad(T entidad) {
		entidad.setTs_eliminacion(new Timestamp(new Date().getTime()));

		return eliminacionLogica(entidad);
	}
}
