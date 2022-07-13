package hts.backend.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hts.backend.dao.CoreDefuncionDAO;
import hts.backend.model.dto.CoreDefuncionDTO;


@Repository("coreDefuncionDAOImpl")
@Transactional
public class CoreDefuncionDAOImpl extends GenericHibernateDAOImpl implements CoreDefuncionDAO {

	@Override
	public CoreDefuncionDTO obtenerFichaDefuncion(CoreDefuncionDTO dto) {

		// language=MySQL
		String QRY_FICHA_DEFUNCION = "" +
			      " SELECT  \n" +
			" CDF.DEFUNCION_ID as defuncionId,  \n" +
			" CDF.FECHA_DEFUNCION as fechaDefuncion,  \n" +
			" CDF.OBSERVACIONES as observaciones,  \n" +
			" CDF.FECHA_REGISTRO as fechaRegistro,  \n" +
			" CDF.USUARIO_REGISTRO as usuarioRegistro,  \n" +
//			" CIRCUN.ESTATUS as circunstanciaDefuncionId,  \n" +
//			" CIRCUN.NOMBRE as descCircunstanciaDefuncion,  \n" +
			" CDF.EVENTO_ID as eventoId,  \n" +
			" CASE WHEN PERSONAL.ADM_PROF_SALUD_GRAL_ID IS NOT NULL THEN\n" +
			"\n" +
			"\n" +
			"     CONCAT(PERSONAL.NOMBRE ,' ' , PERSONAL.PATERNO , ' ' , PERSONAL.PATERNO)  ELSE 'N/A' END AS nombreProfesional,\n" +
			" CASE  \n" +
			"  WHEN CDF.CAMA_ID IS NULL  \n" +
			"\tTHEN CASE WHEN  CDF.CONSULTORIO_ID IS NULL THEN\n" +
//			"     CASE WHEN CDF.EAR_URG_ID IS NULL THEN\n" +
//			"         CASE WHEN CDF.EAR_BQR_ID IS NULL THEN\n" +
//			"\n" +
//			"             ' ' \n" +
//			"\n" +
//			"\n" +
//			"             ELSE earBqr.DESCRIPCION\n" +
//			"             END\n" +
			"\n" +
			"\n" +
			"         ELSE MEDICACONSULTORIOEARURG.NOMBRE\n" +
			"         END\n" +
			"\n" +
			" ELSE    MEDICACONSULTORIO.NOMBRE\n" +
			"     END\n" +
			"  ELSE  \n" +
			"\tMEDICACAMA.NOMBRE  \n" +
			" END AS descUnidadMedica,  \n" +
			" CDF.CERTIFICADO AS certificado  \n" +
			"FROM core_defuncion CDF  \n" +
//			" INNER JOIN nom_cat_circun_defuncion CIRCUN ON CDF.CIRCUNSTANCIA_DEFUNCION_ID = CIRCUN.CIRCUNSTANCIA_DEFUNCION_ID \n" +
			" INNER JOIN pac_paciente PACIENTE ON CDF.PACIENTE_ID = PACIENTE.ID_PACIENTE  \n" +
			" LEFT JOIN pac_evento EVENTO ON CDF.EVENTO_ID = EVENTO.EVENTO_ID  \n" +
			" LEFT JOIN adm_personal PERSONAL ON EVENTO.PERSONAL_ID = PERSONAL.ADM_PROF_SALUD_GRAL_ID  \n" +
//			" LEFT JOIN adm_cama CAMA ON CDF.CAMA_ID = CAMA.CAMA_ID  \n" +
//			" LEFT JOIN adm_habitacion HABITACAMA ON CAMA.HABITACION_ID = HABITACAMA.HABITACION_ID  \n" +
//			" LEFT JOIN adm_unidad_enfermeria ENFERMECAMA ON HABITACAMA.UNIDAD_ENFERMERIA_ID = ENFERMECAMA.UNIDAD_ENFERMERIA_ID  \n" +
//			" LEFT JOIN adm_unidad_medica MEDICACAMA ON ENFERMECAMA.UNIDAD_MEDICA_ID = MEDICACAMA.UNIDAD_MEDICA_ID  \n" +
//			" LEFT JOIN adm_consultorio CONSULTORIO ON CDF.CONSULTORIO_ID = CONSULTORIO.CONSULTORIO_ID  \n" +
//			" LEFT JOIN adm_ear_urg earUrg ON CDF.EAR_URG_ID = earUrg.EAR_URG_ID\n" +
//			" LEFT JOIN adm_sala SALACONSULTORIOEARURG ON earUrg.SALA_ID = SALACONSULTORIOEARURG.SALA_ID\n" +
//			" LEFT JOIN adm_unidad_tratamiento TRATACONSULTORIOEARURG ON SALACONSULTORIOEARURG.UNIDAD_TRATAMIENTO_ID = TRATACONSULTORIOEARURG.UNIDAD_TRATAMIENTO_ID\n" +
//			" LEFT JOIN adm_unidad_medica MEDICACONSULTORIOEARURG ON TRATACONSULTORIOEARURG.UNIDAD_MEDICA_ID = MEDICACONSULTORIOEARURG.UNIDAD_MEDICA_ID\n" +
//			" LEFT JOIN adm_ear_bqr earBqr ON CDF.EAR_BQR_ID = earBqr.EAR_BQR_ID\n" +
//			" LEFT JOIN adm_sala SALACONSULTORIOEARBQR ON earBqr.SALA_ID = SALACONSULTORIOEARBQR.SALA_ID\n" +
//			" LEFT JOIN adm_unidad_tratamiento TRATACONSULTORIOEARBQR ON SALACONSULTORIOEARBQR.UNIDAD_TRATAMIENTO_ID = TRATACONSULTORIOEARBQR.UNIDAD_TRATAMIENTO_ID\n" +
//			" LEFT JOIN adm_unidad_medica MEDICACONSULTORIOEARBQR ON TRATACONSULTORIOEARBQR.UNIDAD_MEDICA_ID = MEDICACONSULTORIOEARBQR.UNIDAD_MEDICA_ID\n" +
//			" LEFT JOIN adm_sala SALACONSULTORIO ON CONSULTORIO.SALA_ID = SALACONSULTORIO.SALA_ID\n" +
//			" LEFT JOIN adm_unidad_tratamiento TRATACONSULTORIO ON SALACONSULTORIO.UNIDAD_TRATAMIENTO_ID = TRATACONSULTORIO.UNIDAD_TRATAMIENTO_ID  \n" +
//			" LEFT JOIN adm_unidad_medica MEDICACONSULTORIO ON TRATACONSULTORIO.UNIDAD_MEDICA_ID = MEDICACONSULTORIO.UNIDAD_MEDICA_ID  \n" +
			"WHERE CDF.PACIENTE_ID = :paciente_id  \n" +
			"AND CDF.ESTATUS = 1 \n";

		Session s = getCurrentSession();
		Query query = s.createSQLQuery(QRY_FICHA_DEFUNCION)

				.addScalar("defuncionId", StandardBasicTypes.INTEGER)
				.addScalar("fechaDefuncion", StandardBasicTypes.TIMESTAMP)
				.addScalar("observaciones", StandardBasicTypes.STRING)
				.addScalar("fechaRegistro", StandardBasicTypes.TIMESTAMP)
				.addScalar("usuarioRegistro", StandardBasicTypes.STRING)
				.addScalar("circunstanciaDefuncionId", StandardBasicTypes.INTEGER)
				.addScalar("descCircunstanciaDefuncion", StandardBasicTypes.STRING)
				.addScalar("eventoId", StandardBasicTypes.INTEGER)
				.addScalar("nombreProfesional", StandardBasicTypes.STRING)
				.addScalar("certificado", StandardBasicTypes.STRING)
				.addScalar("descUnidadMedica", StandardBasicTypes.STRING);

		query.setParameter("paciente_id", dto.getPacienteId());
		query.setResultTransformer(Transformers.aliasToBean(CoreDefuncionDTO.class));

		var r = (CoreDefuncionDTO) query.uniqueResult();
		s.close();
		return r;
	}

}