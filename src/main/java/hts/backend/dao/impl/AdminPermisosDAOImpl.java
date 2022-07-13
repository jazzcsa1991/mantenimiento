package hts.backend.dao.impl;

import hts.backend.model.UsuarioAdmin;
import hts.backend.dao.AdminPermisosDAO;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Map;

@Repository("AdminPermisosDAO")
@Transactional
public class AdminPermisosDAOImpl extends BaseDAOImpl implements AdminPermisosDAO {


	@Override
	public List listarPermisosByUsuario(Integer usuarioId) {

		try {
			return session().createQuery("" +
					"select new map( " +
					"  permisos.adminPermisosAdminId as  adminPermisosAdminId , " +
					"  permisos.permisos as permisos ,  " +
					"  permisos.hospitalId as hospitalId ,   " +
					"  permisos.usuarioAdminId as usuarioAdminId ,   " +
					"  hospital.nombre as nombreHospital,   " +
					"  concat(usuario.primerApellido,' ',usuario.segundoApellido,' ',usuario.nombre)  as nombreCompletoUsuario  " +
					")" +
					"from AdminPermisos permisos " +
					" inner join permisos.admHospitalByHospitalId as hospital " +
					" inner join permisos.usuarioAdmin as usuario " +
					"where permisos.usuarioAdminId =:usuarioId "

			).setParameter("usuarioId", usuarioId).list();

		} catch (NoResultException e) {
			return null;
		}

	}

	@Override
	public Map<String, Object> listarPermisosUsuarioHospital(Integer usuarioId, Integer hospitalId) {

		try {
			return (Map<String, Object>) session().createQuery("" +
					"select new map( " +
					"  permisos.adminPermisosAdminId as  adminPermisosAdminId , " +
					"  permisos.permisos as permiso ,  " +
					"  permisos.hospitalId as hospitalId ,   " +
					"  permisos.usuarioAdminId as usuarioAdminId ,   " +
					"  hospital.nombre as nombreHospital,   " +
					"  concat(usuario.primerApellido,' ',usuario.segundoApellido,' ',usuario.nombre)  as nombreCompletoUsuario  " +
					")" +
					"from AdminPermisos permisos " +
					" inner join permisos.admHospitalByHospitalId as hospital " +
					" inner join permisos.usuarioAdmin as usuario " +
					"where permisos.usuarioAdminId =:usuarioId and permisos.hospitalId =:hospitalId"

			).setParameter("usuarioId", usuarioId).setParameter("hospitalId", hospitalId).uniqueResult();

		} catch (NoResultException e) {
			return null;
		}

	}

	public Boolean validarPermiso(UsuarioAdmin usuario, Integer posicion, Integer hospitalId) {
		try {
			if (usuario.getRoot() == 1) {
				return true;
			} else {
				// language=MySQL
				String QRY_VALIDA_PERMISO = "SELECT " +
						"SUBSTR(adminPermisos.PERMISOS, :pPosicion, 1) " +
						"FROM " +
						"admin_permisos adminPermisos " +
						"WHERE adminPermisos.USUARIO_ADMIN_ID = :pUsuarioId AND " +
						"adminPermisos.HOSPITAL_ID = :pHospitalId";

				Query query = session().createSQLQuery(QRY_VALIDA_PERMISO);
				query.setParameter("pUsuarioId", usuario.getUsuarioAdminId())
						.setParameter("pHospitalId", hospitalId)
						.setParameter("pPosicion", posicion + 1);
				return (Integer.parseInt(query.uniqueResult().toString()) == 1);
			}
		} catch (NoResultException e) {
			return null;
		}
	}
}
