package hts.backend.dao.impl;

import hts.backend.dao.MenuDAO;
import hts.backend.model.dto.AccionDTO;
import hts.backend.model.dto.MenuDTO;
import hts.backend.model.dto.SubmenuDTO;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("MenuDAO")
public class MenuDAOImpl extends BaseDAOImpl implements MenuDAO {
	private static final Logger logger = LoggerFactory.getLogger(MenuDAOImpl.class);
	// language=MySQL
	private String s_portales = "SELECT P.NOMBRE, P.PORTAL_ID AS id  FROM adm_rol_accion R "
			+ " INNER JOIN adm_portal P ON R.PORTAL_ID = P.PORTAL_ID  "
			+ "WHERE R.ROL_ID = :role_id  AND P.ESTATUS = 1  GROUP BY P.NOMBRE, P.PORTAL_ID";
	// language=MySQL
	private String s_menus = "SELECT M.NOMBRE, M.MODULO_ID AS id   " +
			"FROM adm_modulo M, adm_rol_accion r   " +
			"WHERE M.MODULO_ID = r.MODULO_ID " +
			"AND r.ROL_ID = :role_id " +
			"AND M.PORTAL_ID = :portal_id " +
			"GROUP BY M.NOMBRE, M.MODULO_ID " +
			"ORDER BY M.NOMBRE ASC";
	// language=MySQL
	private String s_submenus = "SELECT DISTINCT a.NOMBRE, a.URL_VISTA AS url , a.orden  " +
			"FROM adm_accion a, adm_rol_accion r " +
			"WHERE a.ACCION_ID = r.ACCION_ID " +
			"AND r.ROL_ID = :role_id " +
			"AND a.MODULO_ID = :modulo_id " +
			"ORDER BY a.orden";

	/**
	 * @see MenuDAO#getPortal(Integer)
	 */
	@Override
	public List<MenuDTO> getPortal(Integer role_id) {
		Query query = session().createSQLQuery(s_portales)
				.addScalar("nombre", StandardBasicTypes.STRING)
				.addScalar("id", StandardBasicTypes.INTEGER);


		query.setParameter("role_id", role_id);
		query.setResultTransformer(Transformers.aliasToBean(MenuDTO.class));

		List<MenuDTO> lstmenu = query.list();

		logger.debug("Consulta lista Portales " + lstmenu.size());
		return lstmenu;
	}

	@Override
	public List<MenuDTO> getMenus(Integer portal_id, Integer role_id) {
		Query query = session().createSQLQuery(s_menus)
				.addScalar("nombre", StandardBasicTypes.STRING)
				.addScalar("id", StandardBasicTypes.INTEGER);

		query.setParameter("portal_id", portal_id);
		query.setParameter("role_id", role_id);
		query.setResultTransformer(Transformers.aliasToBean(MenuDTO.class));

		List<MenuDTO> lstmenu = query.list();

		logger.debug("Consulta lista Menus " + lstmenu.size());
		return lstmenu;
	}

	@Override
	public List<SubmenuDTO> getsubMenus(Integer role_id, Integer portal_id, Integer modulo_id) {
		Query query = session().createSQLQuery(s_submenus)
				.addScalar("nombre", StandardBasicTypes.STRING)
				.addScalar("url", StandardBasicTypes.STRING)
				.addScalar("orden", StandardBasicTypes.STRING);
		query.setParameter("modulo_id", modulo_id);
		query.setParameter("role_id", role_id);
		query.setResultTransformer(Transformers.aliasToBean(SubmenuDTO.class));
		List<SubmenuDTO> lstmenu = query.list();

		logger.debug("Consulta lista Submenus " + lstmenu.size());
		return lstmenu;
	}

	@Override
	public List<MenuDTO> obtenPortalesDisponibles() {
		Query query = session().createSQLQuery(QRY_PORTALES_DISP)
				.addScalar("nombre", StandardBasicTypes.STRING)
				.addScalar("id", StandardBasicTypes.INTEGER);
		query.setResultTransformer(Transformers.aliasToBean(MenuDTO.class));

		List<MenuDTO> lstmenu = query.list();
		return lstmenu;
	}

	@Override
	public List<MenuDTO> obtenmodulosPorPortal(MenuDTO dto) {
		Query query = session().createSQLQuery(QRY_MODULOS_DISP)
				.addScalar("nombre", StandardBasicTypes.STRING)
				.addScalar("id", StandardBasicTypes.INTEGER);
		query.setParameter("p_portalID", dto.getId());
		query.setResultTransformer(Transformers.aliasToBean(MenuDTO.class));

		List<MenuDTO> lstmenu = query.list();
		return lstmenu;
	}

	@Override
	public List<MenuDTO> obtenAccionesAsig(AccionDTO dto) {
		Query query = session().createSQLQuery(QRY_ACCIONES_ASIG)
				.addScalar("nombre", StandardBasicTypes.STRING)
				.addScalar("id", StandardBasicTypes.INTEGER);


		query.setParameter("p_moduloID", dto.getIdModulo());
		query.setParameter("p_rolID", dto.getIdRol());
		query.setResultTransformer(Transformers.aliasToBean(MenuDTO.class));
		List<MenuDTO> lstmenu = query.list();
		return lstmenu;
	}

	@Override
	public List<MenuDTO> obtenAccionesDisp(AccionDTO dto) {
		Query query = session().createSQLQuery(QRY_ACCIONES_DISP)
				.addScalar("nombre", StandardBasicTypes.STRING)
				.addScalar("id", StandardBasicTypes.INTEGER);

		query.setParameter("p_portalID", dto.getIdPortal());
		query.setParameter("p_moduloID", dto.getIdModulo());
		query.setParameter("p_rolID", dto.getIdRol());
		List<MenuDTO> lstmenu = query.list();
		return lstmenu;
	}
}