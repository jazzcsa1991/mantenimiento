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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




/**
 * Clase base implementada para el acceso a base de datos con Hibernate 4
 * @author Maricela Barrera Bautista (maricela.barrera@ife.org.mx, alhezy@gmail.com)
 * @author Jorge Rodríguez Campos,actualizacion de código: 06/12/2012
 * @version 1.0
 * @since SIIRFE 5.1
 */
@SuppressWarnings("unchecked")
public abstract class GenericHibernateDAOImpl implements GenericHibernateDAO {
	private static final Logger logger = LoggerFactory.getLogger(GenericHibernateDAOImpl.class);


	@Resource
	private SessionFactory sessionFactory;

	public <T> T get(Class<T> clazz, Serializable id) {
		Session s = getCurrentSession();
		var r = s.get(clazz, id);
		s.close();
		return r;
	}



	public <T> T get(Class<T> clazz, String query, Object... params) {
		Query hqlQuery;
		Session s = getCurrentSession();
		hqlQuery = s.createQuery(query);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				hqlQuery.setParameter(i, params[i]);
			}
		}

		try {
			var r = (T) hqlQuery.uniqueResult();
			s.close();
			return r;
		} catch (NonUniqueResultException e) {
			s.close();
			throw new IncorrectResultSizeDataAccessException(e.getMessage(), 1, e);
		}

	}



	/**
	 * @author Rodrigo Davalos
	 */
	public Query getNamedQueryGeneral(String query,Session s, Object... params){
		Query hqlQuery;

		hqlQuery = s.getNamedQuery(query);
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

		Session s = getCurrentSession();
		try {
			var r = (T) getNamedQueryGeneral(query,s,params).uniqueResult();
			s.close();
			return r;
		} catch (NonUniqueResultException e) {
			s.close();
			throw new IncorrectResultSizeDataAccessException(e.getMessage(), 1, e);
		}

	}

	/**
	 * @author Rodrigo Davalos
	 */
	public <T> List<T> getNamedQueryList(String query, Object... params) {
		Session s = getCurrentSession();
		var r = getNamedQueryGeneral(query,s,params).list();
		s.close();
		return r;
	}

	/**
	 * @author Rodrigo Davalos
	 */
	public String getNamedQueryString(String namedQuery) {
		Session s = getCurrentSession();
		var r= s.getNamedQuery(namedQuery).getQueryString();
		s.close();
		return r;
	}

	/**
	 * @author Rodrigo Davalos
	 */
	public int getNamedQueryUpdate(String query, Object... params) {
		Session s = getCurrentSession();
		var r = getNamedQueryGeneral(query,s,params).executeUpdate();
		s.close();
		return r;
	}

	public <T> T load(Class<T> clazz, Serializable id) {
		Session s = getCurrentSession();
		var r = (T) s.load(clazz, id);
		s.close();
		return r;
	}


	public <T> List<T> find(String query, Object... params) {
		Session s = getCurrentSession();
		Query hQuery = s.createQuery(query);

		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				hQuery.setParameter(i, params[i]);
			}

		}
		var r = hQuery.list();
		s.close();
		return r;
	}


	public <T> List<T> findPaginado(String query, int paginaActual, int numFilas, Object... params) {
		SQLQuery sql;
		Session s = getCurrentSession();
		sql = s.createSQLQuery(query.toString());

		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				sql.setParameter(i, params[i]);
			}
		}

		sql.setFirstResult(numFilas * (paginaActual - 1));
		sql.setMaxResults(numFilas);
		var r = sql.list();
		s.close();
		return r;
	}


	public <T> T queryForEntity(String query, Object... params) {
		Session s = getCurrentSession();
		Query hQuery = s.createQuery(query);

		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				hQuery.setParameter(i, params[i]);
			}
		}
		var r = (T) DataAccessUtils.requiredSingleResult(hQuery.list());
		s.close();
		return r;
	}


	public <T> T queryForEntity(T entityExample) {

		return DataAccessUtils.requiredSingleResult(queryByExample(entityExample));
	}


	public <T> T queryForEntity(Example example, Class<T> clazz) {

		return DataAccessUtils.requiredSingleResult(queryByExample(example, clazz));
	}


	public <T> List<T> findAll(Class<T> clazz) {
		Session s = getCurrentSession();
		var r = s.createQuery("from " + clazz.getName()).list();
		s.close();
		return r;
	}


	public void save(Serializable entity) {
		Session s = getCurrentSession();
		s.save(entity);
		s.close();
	}


	public void saveOrUpdate(Serializable entity) {

		Session s = getCurrentSession();
		s.saveOrUpdate(entity);
		s.close();
	}


	public <T> T merge(final T entity) {
		Session s = getCurrentSession();
		var r =(T) s.merge(entity);
		s.close();
		return r;
	}


	public <T> void update(T entity) {
		Session s = getCurrentSession();
		s.update(entity);
		s.close();
	}


	public <T> void delete(final T entity) {
		Session s = getCurrentSession();
		s.delete(entity);
		s.close();
	}


	public int update(String query, Object... params) {
		Session s = getCurrentSession();
		Query hqlQuery = s.createQuery(query);

		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				hqlQuery.setParameter(i, params[i]);
			}
		}
		var r = hqlQuery.executeUpdate();
		s.close();
		return r;
	}


	public void refresh(Serializable entity) {
		Session s = getCurrentSession();
		s.refresh(entity);
		s.close();
	}


	public <T> List<T> queryByExample(T entityExample) {
		Example example = Example.create(entityExample);
		return (List<T>) queryByExample(example, entityExample.getClass());
	}


	public <T> List<T> queryByExample(Example example, Class<T> clazz) {
		Session s = getCurrentSession();
		var r = s.createCriteria(clazz).add(example).list();
		s.close();
		return r;

	}


	public Criteria construyeCriteria(Class<?> clazz) {
		Session s = getCurrentSession();
		var r = s.createCriteria(clazz);
		return r;
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
		logger.info("##################  invocando currentsession listaPaises ##################");

		return sessionFactory.openSession();
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
