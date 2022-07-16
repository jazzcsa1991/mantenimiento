package hts.backend.dao.impl;

import hts.backend.dao.AdmRissesDAO;
import hts.backend.model.dto.DirecctorioDTO;
import hts.backend.model.dto.*;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository("admRissesDAO")
public class AdmRissesDAOImpl extends BaseDAOImpl implements AdmRissesDAO {
	private static final Logger logger = LoggerFactory.getLogger(AdmCatAseguradoraDAOImpl.class);

	@Override
	@Transactional
	public List<CoreRissesDTO> listarEstabl(CoreRissesDTO dto) {
		// language=MySQL
		String QRY_RISSES = "" +
				"SELECT " +
				"RISS_ID AS rissId, " +
				"NOMBRE AS nombre, " +
				"ID_ESTADO AS estadoId, " +
				"US_REGISTRO AS usuarioRegistro, " +
				"FECHA_REGISTRO AS fechaRegistro " +
				"FROM core_risses " +
				"WHERE ID_ESTADO = :pEstadoId ";
		Query query = session().createSQLQuery(QRY_RISSES)
				.addScalar("rissId", StandardBasicTypes.INTEGER)
				.addScalar("nombre", StandardBasicTypes.STRING)
				.addScalar("estadoId", StandardBasicTypes.INTEGER)
				.addScalar("usuarioRegistro", StandardBasicTypes.STRING)
				.addScalar("fechaRegistro", StandardBasicTypes.DATE);
		query.setParameter("pEstadoId", dto.getEstadoId());

		query.setResultTransformer(Transformers.aliasToBean(CoreRissesDTO.class));

		return query.list();
	}

	@Override public List<DirecctorioDTO> ListaBusquedaProf(DirecctorioDTO dto) {
		// language=MySQL
		String QRY_PROF = "SELECT " +
				" DISTINCT " +
				" personal.ADM_PROF_SALUD_GRAL_ID                                                                             AS admProfGralId, " +
				" CONCAT(personal.PATERNO, IF(ISNULL(personal.MATERNO) = 0, ' ', ''), IFNULL(personal.MATERNO, ''), ', ', personal.NOMBRE) AS nombre, " +
				" datos.NUMERO_EMPLEADO                                                                                       AS noEmpleado, " +
				" tipoRecurso.NOMBRE                                                                                          AS tipoRecurso, " +
				" personal.CURP                                                                                               AS curp, " +
				" datos.FLAG_PERSONAL_INTERNO                                                                                 AS personalInterno, " +
				" datos.ESTATUS, " +
				" anioRecidencia.DESCRIPCION                                                                                  AS anioRecidencia, " +
				" espRecidencia.ESPECIALIDAD                                                                                  AS espRecidencia " +
				"FROM adm_personal personal " +
				" INNER JOIN adm_personal_datos datos ON personal.ADM_PROF_SALUD_GRAL_ID = datos.ADM_PROF_SALUD_GRAL_ID " +
				" INNER JOIN nom_cat_personal_medico tipoRecurso ON datos.TIPO_RECURSO_ID = tipoRecurso.CAT_PERSONAL_MEDICO_ID " +
				" LEFT JOIN nom_cat_anio_recidencia anioRecidencia ON datos.ANIO_RESIDENCIA_ID = anioRecidencia.CAT_ANIO_RECIDENCIA_ID " +
				" LEFT JOIN nom_cat_especialidades espRecidencia ON datos.ESPECIALIDAD_RESIDENCIA_ID = espRecidencia.CAT_ESPECIALIDAD_ID";

		if (dto.getNoEmpleado() == null) {

			if(dto.getNombre() != null){
				QRY_PROF+=" WHERE ";
				QRY_PROF+=" personal.NOMBRE LIKE :nombre ";
				if (dto.getPaterno() != null) {
					QRY_PROF+=" AND personal.PATERNO LIKE :paterno ";
					if (dto.getMaterno() != null) {
						QRY_PROF+=" AND personal.MATERNO LIKE :materno ";
					}
				} else {
					if (dto.getMaterno() != null) {
						QRY_PROF+=" AND personal.MATERNO LIKE :materno ";
					}
				}
			}
			else {
				if (dto.getPaterno() == null) {
					QRY_PROF+=" WHERE ";
					QRY_PROF+=" personal.PATERNO LIKE :paterno ";
					if (dto.getMaterno() == null) {
						QRY_PROF+=" AND personal.MATERNO LIKE :materno ";
					}
				} else {
					if (dto.getMaterno() == null) {
						QRY_PROF+=" WHERE ";
						QRY_PROF+=" personal.MATERNO LIKE :materno ";
					}
				}
			}

		} else {
			QRY_PROF+=" WHERE datos.NUMERO_EMPLEADO = :noEmpleado ";
		}
		Query query = session().createSQLQuery(QRY_PROF)
				.addScalar("admProfGralId", StandardBasicTypes.INTEGER)
				.addScalar("nombre", StandardBasicTypes.STRING)
				.addScalar("noEmpleado", StandardBasicTypes.STRING)
				.addScalar("tipoRecurso", StandardBasicTypes.STRING)
				.addScalar("curp", StandardBasicTypes.STRING)
				.addScalar("personalInterno", StandardBasicTypes.INTEGER)
				.addScalar("anioRecidencia", StandardBasicTypes.STRING)
				.addScalar("espRecidencia", StandardBasicTypes.STRING);
		if (dto.getNoEmpleado() == null) {

			if(dto.getNombre() != null){
				query.setParameter("nombre", "%" + dto.getNombre() + "%");
			}
			if (dto.getPaterno() != null) {
				query.setParameter("paterno", "%" + dto.getPaterno() + "%");
			}
			if (dto.getMaterno() != null) {
				query.setParameter("materno", "%" + dto.getMaterno() + "%");
			}

		} else {
			query.setParameter("noEmpleado",dto.getNoEmpleado());
		}
		query.setResultTransformer(Transformers.aliasToBean(DirecctorioDTO.class));

		return query.list();
	}

	@Override
	public List<ResponsableEstadoDTO> listarResponsablesEstado(CoreRissesDTO dto) {
		String QRY_RISSES = "" +
				"SELECT " +
				"re.ID_ESTADO as estadoId, " +
				"re.ID_USUARIO as usuarioId, " +
				"re.RESPONSABLE_ESTADO_ID as responsableEstadoId, " +
				"CONCAT(ap.NOMBRE , ' ' , ap.PATERNO , IF(ISNULL(ap.MATERNO)=0, ' ', '') , ap.MATERNO) AS nombreCompleto, " +
				"au.USERNAME as username " +

				"from responsable_estado re " +
				"left join adm_personal ap on re.ID_USUARIO = ap.ADM_PROF_SALUD_GRAL_ID " +
				"inner join adm_usuario_profesional aup on ap.ADM_PROF_SALUD_GRAL_ID = aup.PERSONAL_ID " +
				"inner join adm_usuario au on aup.USER_ID = au.USER_ID " +
				"where re.ID_ESTADO = :pEstadoId";

		Query query = session().createSQLQuery(QRY_RISSES)
				.addScalar("estadoId", StandardBasicTypes.INTEGER)
				.addScalar("nombreCompleto", StandardBasicTypes.STRING)
				.addScalar("username", StandardBasicTypes.STRING)
				.addScalar("usuarioId", StandardBasicTypes.INTEGER)
				.addScalar("responsableEstadoId", StandardBasicTypes.INTEGER);

		query.setParameter("pEstadoId", dto.getIdListado());
		query.setResultTransformer(Transformers.aliasToBean(ResponsableEstadoDTO.class));

		return query.list();
	}

	@Override
	public List<ResponsableJurisdiccionDTO> listarResponsablesJurisdiccion(CoreRissesDTO dto) {
		String QRY_RISSES = "" +
				"SELECT " +
				"re.ID_ESTADO as estadoId, " +
				"re.ID_USUARIO as usuarioId, " +
				"re.RESPONSABLE_JURISDICCION_ID as responsableJurisdiccionId, " +
				"re.ID_RISS as rissId, " +
				"CONCAT(ap.NOMBRE , ' ' , ap.PATERNO , IF(ISNULL(ap.MATERNO)=0, ' ', '') , ap.MATERNO) AS nombreCompleto," +
				"au.USERNAME as username " +

				"from responsable_jurisdiccion re " +
				"left join adm_personal ap on re.ID_USUARIO = ap.ADM_PROF_SALUD_GRAL_ID " +
				"inner join adm_usuario_profesional aup on ap.ADM_PROF_SALUD_GRAL_ID = aup.PERSONAL_ID " +
				"inner join adm_usuario au on aup.USER_ID = au.USER_ID";
		Query query = session().createSQLQuery(QRY_RISSES)
				.addScalar("estadoId", StandardBasicTypes.INTEGER)
				.addScalar("nombreCompleto", StandardBasicTypes.STRING)
				.addScalar("username", StandardBasicTypes.STRING)
				.addScalar("usuarioId", StandardBasicTypes.INTEGER)
				.addScalar("rissId", StandardBasicTypes.INTEGER)
				.addScalar("responsableJurisdiccionId", StandardBasicTypes.INTEGER);

		query.setResultTransformer(Transformers.aliasToBean(ResponsableJurisdiccionDTO.class));

		return query.list();
	}

	@Override
	public List<ResponsableRissDTO> listarResponsablesRiss(CoreRissesDTO dto) {
		String QRY_RISSES = "" +
				"SELECT " +
				"re.ID_ESTADO as estadoId, " +
				"re.ID_USUARIO as usuarioId, " +
				"re.RESPONSABLE_RISS_ID as responsableRissId, " +
				"re.ID_RISS as rissId, " +
				"CONCAT(ap.NOMBRE , ' ' , ap.PATERNO , IF(ISNULL(ap.MATERNO)=0, ' ', '') , ap.MATERNO) AS nombreCompleto," +
				"au.USERNAME as username " +

				"from responsable_riss re " +
				"left join adm_personal ap on re.ID_USUARIO = ap.ADM_PROF_SALUD_GRAL_ID " +
				"inner join adm_usuario_profesional aup on ap.ADM_PROF_SALUD_GRAL_ID = aup.PERSONAL_ID " +
				"inner join adm_usuario au on aup.USER_ID = au.USER_ID " +
				"where re.ID_RISS = :pRissId";
		Query query = session().createSQLQuery(QRY_RISSES)
				.addScalar("estadoId", StandardBasicTypes.INTEGER)
				.addScalar("nombreCompleto", StandardBasicTypes.STRING)
				.addScalar("username", StandardBasicTypes.STRING)
				.addScalar("usuarioId", StandardBasicTypes.INTEGER)
				.addScalar("rissId", StandardBasicTypes.INTEGER)
				.addScalar("responsableRissId", StandardBasicTypes.INTEGER);

		query.setParameter("pRissId", dto.getIdListado());
		query.setResultTransformer(Transformers.aliasToBean(ResponsableRissDTO.class));

		return query.list();
	}

	@Override
	public List<ResponsableHospitalDTO> listarResponsablesHospital(CoreRissesDTO dto) {
		String QRY_RISSES = "" +
				"SELECT " +
				"re.ID_ESTADO as estadoId, " +
				"re.ID_USUARIO as usuarioId, " +
				"re.RESPONSABLE_HOSPITAL_ID as responsableHospitalId, " +
				"re.ID_RISS as rissId, " +
				"re.HOSPITAL_ID as hospitalId, " +
				"re.ID_CLUES as idClues, " +
				"re.ID_JURISDICCION as jurisdiccionId, " +
				"CONCAT(ap.NOMBRE , ' ' , ap.PATERNO , IF(ISNULL(ap.MATERNO)=0, ' ', '') , ap.MATERNO) AS nombreCompleto," +
				"au.USERNAME as username " +

				"from responsable_hospital re " +
				"left join adm_personal ap on re.ID_USUARIO = ap.ADM_PROF_SALUD_GRAL_ID " +
				"inner join adm_usuario_profesional aup on ap.ADM_PROF_SALUD_GRAL_ID = aup.PERSONAL_ID " +
				"inner join adm_usuario au on aup.USER_ID = au.USER_ID " +
				"where re.HOSPITAL_ID = :pHospitalId";

		Query query = session().createSQLQuery(QRY_RISSES)
				.addScalar("estadoId", StandardBasicTypes.INTEGER)
				.addScalar("nombreCompleto", StandardBasicTypes.STRING)
				.addScalar("username", StandardBasicTypes.STRING)
				.addScalar("usuarioId", StandardBasicTypes.INTEGER)
				.addScalar("rissId", StandardBasicTypes.INTEGER)
				.addScalar("hospitalId", StandardBasicTypes.INTEGER)
				.addScalar("idClues", StandardBasicTypes.INTEGER)
				.addScalar("jurisdiccionId", StandardBasicTypes.INTEGER)
				.addScalar("responsableHospitalId", StandardBasicTypes.INTEGER);

		query.setParameter("pHospitalId", dto.getIdListado());
		query.setResultTransformer(Transformers.aliasToBean(ResponsableHospitalDTO.class));

		return query.list();
	}

}
