package hts.backend.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hts.backend.dao.AdminAlertasPacienteDAO;
import hts.backend.model.dto.AdmAlertasDTO;


@Repository("adminAlertasPacienteDAO")
@Transactional
public class AdminAlertasPacienteDAOImpl extends GenericHibernateDAOImpl implements AdminAlertasPacienteDAO {
	
	@Override
	public List<AdmAlertasDTO> obtenerAlertasCapturadas(Integer rolId, Integer eventoId) {
		// language=MySQL
		String QRY_ALERTA =
				"SELECT " +
						"alertas.EVENTO_ALERTA_ID AS eventoAlertaId ," +
						"alertas.ALERTA_ID as alertaId, " +
						"a3.NOMBRE as nombre, " +
						"alertas.COMENTARIO as comentarioGuardado, " +
						"a3.COMENTARIO as comentario, " +
						"a3.ICONO as icono, " +
						"a3.SEXO_ID as sexoId, " +
						"alertas.FECHA_REGISTRO as fechaRegistro, " +
						"alertas.USUARIO_REGISTRO as usuarioRegistro, " +
						"a3.INTERFAZ_CAPTURA as interfazCaptura," +
						"a.CAPTURA as captura " +
						"FROM pac_evento_alertas alertas " +
						"inner join adm_alerta_rol a on alertas.ALERTA_ID = a.ALERTA_ID " +
						"inner join adm_alertas a3 on a.ALERTA_ID = a3.ALERTA_ID " +
						"where a.ROL_ID = :rolId " +
						"AND a.CONSULTA = 1 " +
						"AND alertas.EVENTO_ID = :eventoId " +
						"AND alertas.FECHA_ELIMINACION IS NULL " +
						"AND a.FECHA_ELIMINACION IS NULL " +
						"AND a3.FECHA_ELIMINACION IS NULL " +
						"group by alertas.EVENTO_ALERTA_ID, " +
						"alertas.ALERTA_ID, " +
						"a3.NOMBRE, " +
						"alertas.COMENTARIO, " +
						"a3.COMENTARIO, " +
						"a3.ICONO, " +
						"a3.SEXO_ID, " +
						"alertas.FECHA_REGISTRO, " +
						"alertas.USUARIO_REGISTRO, " +
						"a3.INTERFAZ_CAPTURA, " +
						"a.CAPTURA ";

		Session s = getCurrentSession();
		Query query = s.createSQLQuery(QRY_ALERTA)
				.addScalar("alertaId", StandardBasicTypes.INTEGER)
				.addScalar("eventoAlertaId", StandardBasicTypes.INTEGER)
				.addScalar("nombre", StandardBasicTypes.STRING)
				.addScalar("comentario", StandardBasicTypes.INTEGER)
				.addScalar("comentarioGuardado", StandardBasicTypes.STRING)
				.addScalar("icono", StandardBasicTypes.STRING)
				.addScalar("sexoId", StandardBasicTypes.INTEGER)
				.addScalar("fechaRegistro", StandardBasicTypes.TIMESTAMP)
				.addScalar("usuarioRegistro", StandardBasicTypes.STRING)
				.addScalar("interfazCaptura", StandardBasicTypes.STRING)
				.addScalar("captura", StandardBasicTypes.INTEGER)
				.setParameter("rolId", rolId)
				.setParameter("eventoId", eventoId);

		query.setResultTransformer(Transformers.aliasToBean(AdmAlertasDTO.class));

		var r = query.list();
		s.close();
		return r;
	}

}
