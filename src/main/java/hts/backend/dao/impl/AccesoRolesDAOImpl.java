package hts.backend.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hts.backend.dao.AccesoRolesDAO;
import hts.backend.utils.SecurityUtil;



/**
 * Clase estática para validarFS el acceso de un rol a una acción y sus funciones asignadas
 *
 * @author Juan Castañeda
 */
@SuppressWarnings("unchecked")
@Repository("accesoRoles")
@Transactional
public class AccesoRolesDAOImpl extends GenericHibernateDAOImpl implements AccesoRolesDAO {

	@Override
	public boolean validarFS(int gusFuncionId) {
		String usuario = SecurityContextHolder.getContext().getAuthentication().getName();
		int idRol = Integer.valueOf(new SecurityUtil().getRole(usuario));
// language=MySQL
		String QRY_ACCESO_ROLES = "" +
				"SELECT " +
				"	COUNT(fr.FUNCION_ROL_ID) AS permisos " +
				"FROM adm_funciones_rol fr " +
				"LEFT JOIN gus_funciones fs ON fr.GUS_FUNCION_ID = fs.GUS_FUNCION_ID " +
				"WHERE fr.ROL_ID = :pRolId AND fr.GUS_FUNCION_ID = :pGusFuncionId AND fs.ESTATUS = 1";

		Session s = getCurrentSession();
		Query query = s.createSQLQuery(QRY_ACCESO_ROLES)
				.addScalar("permisos", StandardBasicTypes.INTEGER);

		query.setParameter("pRolId", idRol);
		query.setParameter("pGusFuncionId", gusFuncionId);

		Integer permisos = (Integer) query.uniqueResult();

		s.close();
		return (permisos > 0);
	}

}
