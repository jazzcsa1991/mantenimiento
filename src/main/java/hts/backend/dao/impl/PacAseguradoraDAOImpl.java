package hts.backend.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hts.backend.dao.PacAseguradoraDAO;
import hts.backend.entity.CatCoaseguro;
import hts.backend.entity.PacConvenioAseguradora;
import hts.backend.model.dto.PacAseguradoraDTO;


@Repository("pacAseguradoraDAO")
@Transactional
public class PacAseguradoraDAOImpl extends GenericHibernateDAOImpl implements PacAseguradoraDAO {

	@Override
	public List<PacConvenioAseguradora> obtenerConvenioDefaultAseguradoraParticularWOF(int idHospital) {

		Session s = getCurrentSession();
		Criteria convenioAseguradora = s.createCriteria(PacConvenioAseguradora.class, "convenio");
		convenioAseguradora.add(Restrictions.eq("convenio.valorDefault", 1));
//		convenioAseguradora.add(Restrictions.eq("admCatAseguradora.aseguradoraId", 0));
//		convenioAseguradora.add(Restrictions.eq("coreAseguradoraHospital.hospitalId", idHospital));

//		convenioAseguradora.createAlias("convenio.coreAseguradoraHospital", "coreAseguradoraHospital");
//		convenioAseguradora.createAlias("coreAseguradoraHospital.admCatAseguradora", "admCatAseguradora");

		var r = (List<PacConvenioAseguradora>) convenioAseguradora.list();
		s.close();
		return r;
	}

	@Override
	public CatCoaseguro obtenerCatCoaseguroDefault() {
		Session s = getCurrentSession();
		Query query = s.createSQLQuery("SELECT coaseguro.* FROM cat_coaseguro coaseguro WHERE coaseguro.VALOR_DEFAULT = 1")
				.addEntity("coaseguro", CatCoaseguro.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		List<CatCoaseguro> res = query.list();
		s.close();

		if (res.size() == 0)
			throw new RuntimeException("No existe un coaseguro predeterminado para el convenio particular.");
		else
			return res.get(0);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<PacAseguradoraDTO> obtenerAseguradoraXPaciente(Integer pacienteId, Integer hospitalId) {

		Session s = getCurrentSession();
		var r = s.createSQLQuery("" +
				"SELECT " +
				"pacPaciente.ID_PACIENTE                        AS pacienteId, " +
				"aseguradora.PAC_ASEGURADORA_ID                 AS pacAseguradoraId, " +
				"catCoaseguro.COASEGURO_ID                      AS catCoaseguroId, " +
				"admCatAseguradora.ASEGURADORA_ID               AS catAseguradoraId, " +
				"pacConvenioAseguradora.CONVENIO_ASEGURADORA_ID AS convenioAseguradoraId, " +
				"catMotivoAsignacion.MOTIVO_ASIGNACION_ID       AS catMotivoAsignacionId, " +
				"aseguradora.PRIORIDAD                          AS prioridad, " +
				"aseguradora.NO_POLIZA                          AS noPoliza, " +
				"aseguradora.DEDUCIBLE                          AS deducible, " +
				"aseguradora.LIMITE_SEGURO                      AS limiteSeguro, " +
				"aseguradora.FECHA_INICIA                       AS fechaInicia, " +
				"aseguradora.FECHA_FIN                          AS fechaFin, " +
				"aseguradora.FECHA_REGISTRO                     AS fechaRegistro, " +
				"aseguradora.USUARIO_REGISTRO                   AS usuarioRegistra, " +
				"pacPaciente.NOMBRE                             AS pacienteNombre, " +
				"catCoaseguro.NOMBRE                            AS catCoaseguroNombre, " +
				"admCatAseguradora.NOMBRE                       AS catAseguradoraNombre, " +
				"admCatAseguradora.CVE                          AS catAseguradoraCve, " +
				"pacConvenioAseguradora.NOMBRE                  AS convenioAseguradoraNombre, " +
				"catMotivoAsignacion.NOMBRE                     AS catMotivoAsignacionNombre " +
				"FROM pac_aseguradora aseguradora " +
				"INNER JOIN pac_paciente pacPaciente ON aseguradora.ID_PACIENTE = pacPaciente.ID_PACIENTE " +
				"LEFT JOIN cat_coaseguro catCoaseguro ON aseguradora.COASEGURO_ID = catCoaseguro.COASEGURO_ID " +
				"LEFT JOIN nom_cat_motivo_asignacion catMotivoAsignacion ON aseguradora.MOTIVO_ASIGNACION_ID = catMotivoAsignacion.MOTIVO_ASIGNACION_ID " +
				"INNER JOIN pac_convenio_aseguradora pacConvenioAseguradora ON aseguradora.CONVENIO_ASEGURADORA_ID = pacConvenioAseguradora.CONVENIO_ASEGURADORA_ID " +
				"INNER JOIN core_aseguradora_hospital coreAseguradoraHospital ON pacConvenioAseguradora.ASEGURADORA_HOSPITAL_ID = coreAseguradoraHospital.ASEGURADORA_HOSPITAL_ID " +
				"INNER JOIN adm_cat_aseguradora admCatAseguradora ON aseguradora.ASEGURADORA_ID = admCatAseguradora.ASEGURADORA_ID AND coreAseguradoraHospital.ASEGURADORA_ID = admCatAseguradora.ASEGURADORA_ID " +
				"WHERE pacPaciente.ID_PACIENTE = :pPacienteId AND coreAseguradoraHospital.HOSPITAL_ID = :pHospitalId " +
				"ORDER BY aseguradora.PRIORIDAD ASC"
		)
				.addScalar("pacienteId", StandardBasicTypes.INTEGER)
				.addScalar("pacAseguradoraId", StandardBasicTypes.INTEGER)
				.addScalar("catCoaseguroId", StandardBasicTypes.INTEGER)
				.addScalar("catAseguradoraId", StandardBasicTypes.INTEGER)
				.addScalar("convenioAseguradoraId", StandardBasicTypes.INTEGER)
				.addScalar("catMotivoAsignacionId", StandardBasicTypes.INTEGER)
				.addScalar("prioridad", StandardBasicTypes.INTEGER)
				.addScalar("noPoliza", StandardBasicTypes.STRING)
				.addScalar("deducible", StandardBasicTypes.INTEGER)
				.addScalar("limiteSeguro", StandardBasicTypes.INTEGER)
				.addScalar("fechaInicia", StandardBasicTypes.TIMESTAMP)
				.addScalar("fechaFin", StandardBasicTypes.TIMESTAMP)
				.addScalar("fechaRegistro", StandardBasicTypes.TIMESTAMP)
				.addScalar("usuarioRegistra", StandardBasicTypes.STRING)
				.addScalar("pacienteNombre", StandardBasicTypes.STRING)
				.addScalar("catCoaseguroNombre", StandardBasicTypes.STRING)
				.addScalar("catAseguradoraNombre", StandardBasicTypes.STRING)
				.addScalar("catAseguradoraCve", StandardBasicTypes.STRING)
				.addScalar("convenioAseguradoraNombre", StandardBasicTypes.STRING)
				.addScalar("catMotivoAsignacionNombre", StandardBasicTypes.STRING)

				.setParameter("pPacienteId", pacienteId)
				.setParameter("pHospitalId", hospitalId)

				.setResultTransformer(Transformers.aliasToBean(PacAseguradoraDTO.class))

				.list();
		s.close();
		return r;
	}
	
}
