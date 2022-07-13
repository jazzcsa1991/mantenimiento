package hts.backend.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.context.spi.CurrentSessionContext;
import org.hibernate.criterion.Example;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.dao.support.DataAccessUtils;

import hts.backend.dao.GenericHibernateDAO;




/**
 * Clase base implementada para el acceso a base de datos con Hibernate 4
 * @author Maricela Barrera Bautista (maricela.barrera@ife.org.mx, alhezy@gmail.com)
 * @author Jorge Rodríguez Campos,actualizacion de código: 06/12/2012
 * @version 1.0
 * @since SIIRFE 5.1
 */
@SuppressWarnings("unchecked")
public abstract class GenericHibernateDAOImpl implements GenericHibernateDAO {

	@Resource
	private SessionFactory sessionFactory;

	public <T> T get(Class<T> clazz, Serializable id) {
		return (T) getCurrentSession().get(clazz, id);
	}



	public <T> T get(Class<T> clazz, String query, Object... params) {
		Query hqlQuery;
		hqlQuery = getCurrentSession().createQuery(query);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				hqlQuery.setParameter(i, params[i]);
			}
		}

		try {
			return (T) hqlQuery.uniqueResult();
		} catch (NonUniqueResultException e) {
			throw new IncorrectResultSizeDataAccessException(e.getMessage(), 1, e);
		}

	}



	/**
	 * @author Rodrigo Davalos
	 */
	public Query getNamedQueryGeneral(String query, Object... params){
		Query hqlQuery;
		hqlQuery = getCurrentSession().getNamedQuery(query);
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
			return (T) getNamedQueryGeneral(query,params).uniqueResult();
		} catch (NonUniqueResultException e) {
			throw new IncorrectResultSizeDataAccessException(e.getMessage(), 1, e);
		}

	}

	/**
	 * @author Rodrigo Davalos
	 */
	public <T> List<T> getNamedQueryList(String query, Object... params) {
		return getNamedQueryGeneral(query,params).list();
	}

	/**
	 * @author Rodrigo Davalos
	 */
	public String getNamedQueryString(String namedQuery) {
		return getCurrentSession().getNamedQuery(namedQuery)
				.getQueryString();
	}

	/**
	 * @author Rodrigo Davalos
	 */
	public int getNamedQueryUpdate(String query, Object... params) {
		return getNamedQueryGeneral(query,params).executeUpdate();
	}

	public <T> T load(Class<T> clazz, Serializable id) {
		return (T) getCurrentSession().load(clazz, id);
	}


	public <T> List<T> find(String query, Object... params) {
		Query hQuery = getCurrentSession().createQuery(query);

		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				hQuery.setParameter(i, params[i]);
			}

		}
		return hQuery.list();
	}


	public <T> List<T> findPaginado(String query, int paginaActual, int numFilas, Object... params) {
		SQLQuery sql;

		sql = getCurrentSession().createSQLQuery(query.toString());

		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				sql.setParameter(i, params[i]);
			}
		}

		sql.setFirstResult(numFilas * (paginaActual - 1));
		sql.setMaxResults(numFilas);

		return sql.list();
	}


	public <T> T queryForEntity(String query, Object... params) {
		Query hQuery = getCurrentSession().createQuery(query);

		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				hQuery.setParameter(i, params[i]);
			}
		}

		return (T) DataAccessUtils.requiredSingleResult(hQuery.list());
	}


	public <T> T queryForEntity(T entityExample) {

		return DataAccessUtils.requiredSingleResult(queryByExample(entityExample));
	}


	public <T> T queryForEntity(Example example, Class<T> clazz) {

		return DataAccessUtils.requiredSingleResult(queryByExample(example, clazz));
	}


	public <T> List<T> findAll(Class<T> clazz) {
		return getCurrentSession().createQuery("from " + clazz.getName()).list();
	}


	public void save(Serializable entity) {
		getCurrentSession().save(entity);
	}


	public void saveOrUpdate(Serializable entity) {
		getCurrentSession().saveOrUpdate(entity);
	}


	public <T> T merge(final T entity) {
		return (T) getCurrentSession().merge(entity);
	}


	public <T> void update(T entity) {
		getCurrentSession().update(entity);
	}


	public <T> void delete(final T entity) {
		getCurrentSession().delete(entity);
	}


	public int update(String query, Object... params) {
		Query hqlQuery = getCurrentSession().createQuery(query);

		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				hqlQuery.setParameter(i, params[i]);
			}
		}

		return hqlQuery.executeUpdate();
	}


	public void refresh(Serializable entity) {
		getCurrentSession().refresh(entity);
	}


	public <T> List<T> queryByExample(T entityExample) {
		Example example = Example.create(entityExample);
		return (List<T>) queryByExample(example, entityExample.getClass());
	}


	public <T> List<T> queryByExample(Example example, Class<T> clazz) {
		return getCurrentSession().createCriteria(clazz).add(example).list();

	}


	public Criteria construyeCriteria(Class<?> clazz) {
		return getCurrentSession().createCriteria(clazz);
	}


	public void flush() {
		sessionFactory.getCurrentSession().flush();

	}

	/**
	 * Obtiene la sesion actual, es decir, la mahejada por {@link CurrentSessionContext}
	 * @author Maricela Barrera Bautista (maricela.barrera@ife.org.mx, alhezy@gmail.com)
	 * @return la sesion actual
	 */
	public final Session getCurrentSession() {

		return sessionFactory.getCurrentSession();
	}
	protected final Connection getCurrentConnection() {

		SessionImplementor sim = (SessionImplementor) sessionFactory.getCurrentSession();
		return sim.connection();
	}



	public <T> int actualizarEntidad(T entidad) {
		try {
			this.merge(entidad);
			this.flush();
			return 1;
		} catch (Exception e) {
			e.getMessage();
			return 0;
		}
	}


	public <T extends Serializable> int guardarEntidad(T entidad) {
		try {
			this.save(entidad);
			this.flush();
			return 1;
		} catch (Exception e) {
			e.getMessage();
			return 0;
		}
	}



	public <T extends Serializable> int guardarActualizarEntidad(T entidad) {
		try {
			this.saveOrUpdate(entidad);
			this.flush();
			return 1;
		} catch (Exception e) {
			e.getMessage();
			return 0;
		}
	}


	public <T> int eliminarEntidad(T entidad) {
		try {
			this.delete(entidad);
			this.flush();
			return 1;
		} catch (Exception e) {
			e.getMessage();
			return 0;
		}
	}
}
