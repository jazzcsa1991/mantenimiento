package hts.backend.dao.impl;

import hts.backend.dao.impl.GenericHibernateDAOImpl;
import hts.backend.dao.UsuarioDAO;
import hts.backend.entity.Roles;
import hts.backend.entity.AdmPersonal;
import hts.backend.entity.AdmUsuario;
import hts.backend.entity.AdmUsuarioProfesional;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("UsuarioDAO")
public class UsuarioDAOImpl extends GenericHibernateDAOImpl implements UsuarioDAO {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioDAOImpl.class);


/*
	public String SQLVALIDAUSR = "SELECT USER_ID AS userId, username AS username , password AS userpass "
			+ ", nombre, a_paterno, a_materno "
			+ " FROM adm_usuario WHERE username = :p_username";

	public String SQLLSITUSR = "SELECT U.USER_ID AS userId, U.USERNAME AS username ,  "
			+ " R.DESCRIPCION AS strole, R.ROLE_ID AS userole, nombre, a_paterno, a_materno, mail, telefono, extension "
			+ " FROM adm_usuario U INNER JOIN roles R ON U.ROLE_ID = R.ROLE_ID "
			+ "WHERE u.activo = 1";

	public String QRYCONSSERVICIOESPE = "SELECT catse.IDCENTRO AS idCentro  , catse.IDAREASERVICIO AS  idAreaServicio, catse.IDSERVICIOBASICO  AS idServicioBasico, " +
			"catse.IDSERVICIOESPECIALIDAD AS idServicioEspecializado,  " +
			"cats.SERVICIOBASICO || '/' || catse.DESCRIPCION AS descripcion   " +
			"FROM usuarios_servicios usus ,  CATSERVICIOSBASICOS cats ,   " +
			"CATSERVICIOSESPECIALIZADOS catse  , USUARIO usu  " +
			"WHERE usu.USERNAME = :p_userName   " +
			"AND usus.USER_ID = usu.USER_ID  " +
			"AND usus.IDCENTRO = catse.IDCENTRO  " +
			"AND usus.IDAREASERVICIO = catse.IDAREASERVICIO  " +
			"AND usus.IDSERVICIOBASICO = catse.IDSERVICIOBASICO  " +
			"AND usus.IDSERVICIOESPECIALIDAD = catse.IDSERVICIOESPECIALIDAD  " +
			"AND cats.IDCENTRO = catse.IDCENTRO  " +
			"AND cats.IDAREASERVICIO = catse.IDAREASERVICIO  " +
			"AND cats.IDSERVICIOBASICO = catse.IDSERVICIOBASICO";


	*/
	/* (non-Javadoc)
	 * @see mx.com.sasa.atm.dao.UsuarioDAO#getEstatusDTO(java.lang.String)
	 *//*

	@Override
	public UserProfileDTO getEstatusDTO(String username) {

		Query query =
				getCurrentSession().createSQLQuery(SQLVALIDAUSR)
						.addScalar("userId", StandardBasicTypes.INTEGER)
						.addScalar("username", StandardBasicTypes.STRING)
						.addScalar("userpass", StandardBasicTypes.STRING)
						.addScalar("nombre", StandardBasicTypes.STRING)
						.addScalar("a_paterno", StandardBasicTypes.STRING)
						.addScalar("a_materno", StandardBasicTypes.STRING);

		query.setParameter("p_username", username);
		query.setResultTransformer(Transformers.aliasToBean(UserProfileDTO.class));

		List<UserProfileDTO> lista = query.list();

		return lista.get(0);
	}


	*/
	/* (non-Javadoc)
	 * @see mx.com.sasa.atm.dao.UsuarioDAO#getEstatusDTO(java.lang.String)
	 *//*

	@Override
	public List<UserProfileDTO> getUserListDTO() {

		Query query =
				getCurrentSession().createSQLQuery(SQLLSITUSR)
						.addScalar("userId", StandardBasicTypes.INTEGER)
						.addScalar("username", StandardBasicTypes.STRING)
						.addScalar("strole", StandardBasicTypes.STRING)
						.addScalar("userole", StandardBasicTypes.INTEGER)
						.addScalar("nombre", StandardBasicTypes.STRING)
						.addScalar("a_paterno", StandardBasicTypes.STRING)
						.addScalar("a_materno", StandardBasicTypes.STRING)
						.addScalar("mail", StandardBasicTypes.STRING)
						.addScalar("telefono", StandardBasicTypes.STRING)
						.addScalar("extension", StandardBasicTypes.INTEGER);

		query.setResultTransformer(Transformers.aliasToBean(UserProfileDTO.class));

		List<UserProfileDTO> lista = query.list();

		return lista;
	}

	@Override
	@Transactional
	public List<ServicioEspecialidadDTO> obtenServicios(UserProfileDTO user) throws Exception {

		Query query =
				getCurrentSession().createSQLQuery(QRYCONSSERVICIOESPE)
						.addScalar("idCentro", StandardBasicTypes.INTEGER)
						.addScalar("idAreaServicio", StandardBasicTypes.INTEGER)
						.addScalar("idServicioBasico", StandardBasicTypes.INTEGER)
						.addScalar("idServicioEspecializado", StandardBasicTypes.INTEGER)
						.addScalar("descripcion", StandardBasicTypes.STRING);

		query.setParameter("p_userName", user.getUsername());

		query.setResultTransformer(Transformers.aliasToBean(ServicioEspecialidadDTO.class));
		List<ServicioEspecialidadDTO> lista = query.list();

		return lista;
	}
*/


	@Override
	@Transactional(readOnly = true)
	public List<Roles> getRoles() {

		logger.debug("Consulta de Roles ");
		return findAll(Roles.class);
	}

	@Override
	public int altaUsuario(AdmUsuario entidadUsuario) {
		//AdmUsuario entidad = new AdmUsuario();
		int exito;
		try{
			this.save(entidadUsuario);
			this.flush();
			exito = entidadUsuario.getUserId();
		}catch (Exception e) {
			logger.info("########### Ocurrio un error al guardar el usuario " , e);
			exito = 0;
		}

		return exito;
	}

	@Override
	public AdmUsuario obtenerUsuarioId(Integer userId) {
		Criteria usuario = getCurrentSession().createCriteria(AdmUsuario.class, "usuario");
		usuario.add(Restrictions.eq("userId", userId));


		return (AdmUsuario) usuario.uniqueResult();
	}

	@Override
	public AdmPersonal obtenerProfecionalId(Integer admProfSaludGralId) {
		Criteria profecional = getCurrentSession().createCriteria(AdmPersonal.class, "profecional");
		profecional.add(Restrictions.eq("admProfSaludGralId", admProfSaludGralId));


		return (AdmPersonal) profecional.uniqueResult();
	}

	@Override
	public int altaUsuarioProfecional(AdmUsuarioProfesional userProfesionalId) {
		int exito;
		try{
			this.save(userProfesionalId);
			this.flush();
			exito = 1;
		}catch (Exception e) {
			logger.info("########### Ocurrio un error al guardar el usuario " , e);
			exito = 0;
		}

		return exito;
	}

/*	@Override
	@Transactional
	public Usuario altaUsers(Usuario userent) throws Exception {

		logger.debug("Alta de usuario ");
		Usuario userTmp;
		userTmp = merge(userent);
		flush();
		return userTmp;
	}


	@Override
	@Transactional(readOnly = true)
	public Roles obtieneRole(Integer roleId) throws Exception {
		logger.debug("Consulta Role");
		return get(Roles.class, roleId);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer getIdUser(String username) throws Exception {
		Integer data = 0;
		Object params[] = {username};
		try {
			data =
					queryForEntity(
							"SELECT userId FROM usuario s where s.username = ?",
							params);
		} catch (EmptyResultDataAccessException erdae) {
			logger.error(erdae.getMessage());
			data = 0;
		}
		return data;
	}


	@Override
	@Transactional
	public Integer updateUsers(Usuario userent) throws Exception {

		logger.debug("Actualizacion de usuario ");
		saveOrUpdate(userent);
		flush();
		return 1;
	}

	@Override
	@Transactional
	public Integer deleteUsers(Usuario userent) throws Exception {

		logger.debug("Borrado LOGICO de usuario ");
		userent.setActivo(0);
		super.update(userent);
		flush();
		return 1;
	}

	@Override
	@Transactional
	public Integer deleteRole(Roles entrole) throws Exception {

		logger.debug("Borrado de roles ");
		delete(entrole);
		flush();
		return 1;
	}


	@Override
	@Transactional
	public Integer altaRole(Roles entrole) throws Exception {

		logger.debug("Alta de roles ");
		save(entrole);
		flush();
		return 1;
	}


	@Override
	@Transactional
	public Integer updateRole(Roles entrole) throws Exception {

		logger.debug("Actualiza de roles ");
		saveOrUpdate(entrole);
		flush();
		return 1;
	}

	@Override
	@Transactional
	public Integer altaServicioUsuario(UsuariosServicios servicios) throws Exception {

		logger.debug("Actualiza de roles ");
		saveOrUpdate(servicios);
		flush();
		return 1;
	}


	@Override
	public Usuario getUser(String name) {

		Criteria crit = getCurrentSession().createCriteria(Usuario.class);
		crit.add(Restrictions.eq("username", name));

		return crit.uniqueResult() != null ? (Usuario) crit.uniqueResult() : null;
	}

	@Override
	public List<CedulaDTO> obtenerCedulas(Integer profSaludGralId) {

		Criteria entidad = getCurrentSession().createCriteria(AdmPersonalCedula.class, "cedula")
				.setProjection(Projections.projectionList().add(Projections.distinct(Projections.property("cedulaProf")), "cedulaProf")
		);

		entidad.createAlias("cedula.admPersonalDatos", "admPersonalDatos");
		entidad.createAlias("admPersonalDatos.admPersonal", "admPersonal");
		entidad.add(Restrictions.eq("admPersonal.admProfSaludGralId", profSaludGralId));
		return entidad.list();

	}*/
}
