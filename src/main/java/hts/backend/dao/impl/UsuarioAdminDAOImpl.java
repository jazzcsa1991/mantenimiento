package hts.backend.dao.impl;

import hts.backend.model.UsuarioAdmin;
import hts.backend.dao.UsuarioAdminDAO;
import hts.backend.entity.AdmHistorico;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("usuarioAdminDAO")
@Transactional
public class UsuarioAdminDAOImpl extends BaseDAOImpl implements UsuarioAdminDAO {

	@Override
	public List listar() {
		try {
			// language=HQL
			return session().createQuery("" +
					"select new map( " +
					"	ua.usuarioAdminId as usuarioAdminId," +
					"	ua.numeroEmpleado as numeroEmpleado, " +
					"	ua.calle as calle, " +
					"	ua.nombre as nombre, " +
					"	ua.primerApellido as primerApellido, " +
					"	ua.segundoApellido as segundoApellido, " +
					"	CONCAT(ua.primerApellido, case when ua.segundoApellido is null then ', ' else concat(' ', ua.segundoApellido, ', ') end, ua.nombre) as nombreCompleto, " +
					"	es.nombre as estatus," +
					"	ua.numeroExterior as numeroExterior," +
					"	ua.numeroInterior as numeroInterior," +
					"	ua.numeroInteriorLetra as numeroInteriorLetra," +
					"	ua.numeroExteriorLetra as numeroExteriorLetra," +
					"	ua.paisId as paisId, " +
					"	ua.estadoId as estadoId, " +
					"	ua.municipioId as municipioId, " +
					"	ua.localidadId as localidadId,  " +
					"	ua.codigoPostal as codigoPostal," +
					"	CASE  WHEN ua.estatusId = 2 THEN 0 ELSE 1 END as estatusId" +
					")" +

					/*numeroExteriorLetra
					cp
					*/

					"from UsuarioAdmin ua " +
					"inner join ua.estatus as es " +
					"where ua.ts_eliminacion = null"
			)
					.list();
		} catch (NoResultException e) {
			return new ArrayList();
		}
	}

	@Override
	public Map consultar(Long id) {
		try {
			// language=HQL
			return (Map) session().createQuery("" +
					"select new map( " +
					"	ua.usuarioAdminId as id," +
					"	ua.numeroEmpleado as numeroEmpleado, " +
					"	ua.calle as correo, " +
					"	ua.nombre as nombre, " +
					"	ua.primerApellido as primerApellido, " +
					"	ua.segundoApellido as segundoApellido, " +
					"	CONCAT(ua.primerApellido, case when ua.segundoApellido is null then ', ' else concat(' ', ua.segundoApellido, ', ') end, ua.nombre) as nombreCompleto, " +
					"	ua.calle as calle, " +
					"	ua.numeroExterior as numeroExterior, " +
					"	ua.numeroInterior as numeroInterior, " +
					"	ua.paisId as paisId, " +
					"	ua.estadoId as estadoId, " +
					"	ua.municipioId as municipioId, " +
					"	ua.localidadId as localidadId, " +
					"	ua.codigoPostal as codigoPostal	, " +
					"	ua.numeroExteriorLetra as numeroExteriorLetra	, " +
					"	ua.numeroInteriorLetra as numeroInteriorLetra	, " +
					"	ua.password as password	, " +
					"  CASE  " +
					"   WHEN ua.estatusId = 2 THEN 0 " +
					"   ELSE 1 " +
					" END as estatusId,  " +
					"	es.nombre as estatus " +
					")" +
					"from UsuarioAdmin ua " +
					"inner join ua.estatus as es " +
					"where ua.usuarioAdminId = :pId"
			)
					.setParameter("pId", id)
					.uniqueResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public UsuarioAdmin obtenerEntidad(int id) {
		try {
			// language=HQL
			return (UsuarioAdmin) session().createQuery("" +
					"select ua " +
					"from UsuarioAdmin ua " +
					"where ua.usuarioAdminId = :pId"
			)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
					.setParameter("pId", id)
					.uniqueResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public UsuarioAdmin obtenerEntidad(String usuario) {
		try {

			UsuarioAdmin usuarioAdmin = (UsuarioAdmin) session().createSQLQuery(
					// language=MySQL
					"SELECT * " +
					"FROM admin_usuario ua " +
					"WHERE BINARY ua.USER_NAME = :pUsuario AND ua.USUARIO_ELIMINACION IS NULL"
			)
					.addEntity(UsuarioAdmin.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
					.setParameter("pUsuario", usuario)
					.uniqueResult();


			return usuarioAdmin;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List listarTelefonosUsuarios(Integer usuarioId) {
		try {
			// language=HQL
			return session().createQuery("" +
					" select new map( " +
					"	telefono.telefonoAdminId  as telefonoAdminId , " +
					"	telefono.tipoTelefonoId as tipoTelefono , " +
					"	telefono.telefonoAdmin as telefonoAdmin , " +
					"	tipoTelefono.nombre as tipoTelefonoNombre " +


					")" +
					" from   AdminTelefono telefono " +
					" inner join telefono.catTipoTelefonoByTipoTelefonoAdminId as tipoTelefono " +

					"where telefono.usuarioAdminId=:usuarioId  "

			).setParameter("usuarioId", usuarioId).list();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List listarCorreosUsuarios(Integer usuarioId) {
		try {
			// language=HQL
			return session().createQuery("" +
					" select new map( " +
					"	correo.correoAdmin  as correoAdmin , " +
					"	correo.correoAdminId as correoAdminId,  " +
					"	correo.usuarioAdminId as usuarioAdminId  " +


					")" +
					" from   AdminCorreo correo " +

					"where correo.usuarioAdminId=:usuarioId  "

			).setParameter("usuarioId", usuarioId).list();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List listarUsuarios() {
		try {
			// language=HQL
			return session().createQuery("" +
					" select new map( " +
					"	usuarios.numeroEmpleado  as numeroEmpleado , " +
					"	usuarios.nombre as nombre,  " +
					"	usuarios.primerApellido as primerApellido,  " +
					"	usuarios.segundoApellido as segundoApellido,  " +
					"	usuarios.usuarioAdminId as usuarioAdminId,  " +
					"	usuarios.root as root,  " +
					"	usuarios.permisos as permisos,  " +
					"	CONCAT(usuarios.primerApellido, case when usuarios.segundoApellido is null then ', ' else concat(' ', usuarios.segundoApellido, ', ') end, usuarios.nombre) as nombreCompleto " +


					")" +
					" from   UsuarioAdmin usuarios " +
					"where usuarios.usuarioEliminacion is null and usuarios.fechaEliminacion is null "


			).list();
		} catch (NoResultException e) {
			return null;
		}
	}


	@Override
	public List listarHistoricoPass(Integer usuarioId) {

		try {
			// language=HQL
			return session().createQuery("" +
					"select new map( " +
					"  historico.adminHistoricoPassId as  adminHistoricoPassId , " +
					"  historico.password as password ,  " +
					"  historico.fechaRegistro as fechaRegistro ,   " +
					"  historico.usuarioAdminId as usuarioAdminId   " +
					")" +
					"from AdminHistoricoPassword historico " +
					"where historico.usuarioAdminId =:usuarioId	order by historico.fechaRegistro desc   "
			).setParameter("usuarioId", usuarioId)
					.setMaxResults(3).list();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List obtenerProfesionalCorreo(String correo) {
		try {
			// language=HQL
			return session().createQuery("" +
					" select new map( " +
					"	UA.usuarioAdminId  as userId , " +
					"	AC.correoAdmin as correo " +

					")" +
					" from   AdminCorreo AC " +
					" inner join AC.usuarioAdmin as UA " +
					"where AC.correoAdmin = :correo  "

			).setParameter("correo", correo).list();
		} catch (NoResultException e) {
			return null;
		}
	}
}
