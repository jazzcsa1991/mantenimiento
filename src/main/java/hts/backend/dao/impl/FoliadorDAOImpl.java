package hts.backend.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hts.backend.dao.FoliadorDAO;
import hts.backend.model.dto.FoliadorDTO;


@Repository("foliadorDAO")
public class FoliadorDAOImpl extends GenericHibernateDAOImpl implements FoliadorDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(FoliadorDAOImpl.class);

	@Override
	@Transactional
	public FoliadorDTO obtenSecuencia(Integer tipoFolio, Integer hospitalId) {
		String QRY_SOLICITADOS = "" +
				"SELECT " +
				"fol.FOLIADOR_ID AS id, " +
				"fol.SECUENCIA AS secuencia, " +
				"fol.CEROS AS ceros, " +
				"fol.HOSPITAL_ID AS hospitalId, " +
				"fol.CVE as clave, " +
				"tipo.TIPO_FOLIADOR_ID as tipoFolio, " +
				"tipo.NOMBRE as nombre " +
				"FROM foliador fol " +
				"LEFT JOIN nom_cat_tipo_foliador tipo ON fol.TIPO_FOLIADOR_ID = tipo.TIPO_FOLIADOR_ID " +
				"WHERE fol.HOSPITAL_ID = :pHopsitalId AND tipo.TIPO_FOLIADOR_ID = :pTipo";

		Session s = getCurrentSession();
		Query query = s.createSQLQuery(QRY_SOLICITADOS)
				.addScalar("secuencia", StandardBasicTypes.STRING)
				.addScalar("clave", StandardBasicTypes.STRING)
				.addScalar("nombre", StandardBasicTypes.STRING)
				.addScalar("ceros", StandardBasicTypes.INTEGER)
				.addScalar("id", StandardBasicTypes.INTEGER)
				.addScalar("tipoFolio", StandardBasicTypes.INTEGER)
				.addScalar("hospitalId", StandardBasicTypes.INTEGER);

		query.setParameter("pHopsitalId", hospitalId);
		query.setParameter("pTipo", tipoFolio);

		query.setResultTransformer(Transformers.aliasToBean(FoliadorDTO.class));
		
		var r = (FoliadorDTO) query.uniqueResult();
		s.close();
		return r;
	}

}
