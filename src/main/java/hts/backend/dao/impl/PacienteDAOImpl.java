package hts.backend.dao.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import hts.backend.dao.HospitalDAO;
import hts.backend.dao.PacienteDAO;
import hts.backend.entity.AgenteContacto;
import hts.backend.entity.AgenteCorreo;
import hts.backend.entity.AgenteDireccion;
import hts.backend.entity.AgenteDocumento;
import hts.backend.entity.AgenteTelefono;
import hts.backend.entity.CatEstatusExpediente;
import hts.backend.entity.CatProcedencia;
import hts.backend.entity.CatTipoExpediente;
import hts.backend.entity.CatTipoTelefono;
import hts.backend.entity.CatUbicacionExpediente;
import hts.backend.entity.Contacto;
import hts.backend.entity.CoreConfig;
import hts.backend.entity.Correo;
import hts.backend.entity.Direccion;
import hts.backend.entity.Documento;
import hts.backend.entity.NomCatEntidades;
import hts.backend.entity.NomCatEscolaridad;
import hts.backend.entity.NomCatEstadoCivil;
import hts.backend.entity.NomCatMunicipio;
import hts.backend.entity.NomCatNacionalidades;
import hts.backend.entity.NomCatOcupacion;
import hts.backend.entity.NomCatParentesco;
import hts.backend.entity.NomCatSexo;
import hts.backend.entity.NomCatTipoRegistro;
import hts.backend.entity.PacPaciente;
import hts.backend.entity.Telefono;
import hts.backend.model.dto.AgenteContactoDTO;
import hts.backend.model.dto.CatalogosDTO;
import hts.backend.model.dto.ContactoDTO;
import hts.backend.model.dto.DomicilioDTO;
import hts.backend.model.dto.PacAseguradoraDTO;
import hts.backend.model.dto.PacPacienteDTO;
import hts.backend.model.dto.PacienteDTO;
import hts.backend.model.dto.PacienteDuplicadoDatosDTO;
import hts.backend.utils.SecurityUtil;
import hts.backend.model.CurpRequest;
import hts.backend.entity.AdmHospital;

/**
 * 
 * @author rafaelnagano
 *
 */
@Repository("pacienteDAO")
@SuppressWarnings("unchecked")
@Transactional
public class PacienteDAOImpl extends GenericHibernateDAOImpl implements PacienteDAO {

private static final Logger logger = LoggerFactory.getLogger(PacienteDAOImpl.class);
	
    @Resource
    private HospitalDAO hospitalDAO;
    
	private String QRY_PAC_CURP = "" +
			"SELECT " +
			"	pac.ID_PACIENTE AS idPaciente, " +
			"	pac.CURP AS curp " +
			"FROM pac_paciente pac ";
    
	private String QRY_DATOS_PACIENTE_QR = "" +
			"SELECT " +
			"	pac.ID_PACIENTE AS idPaciente, " +
			"	'PAC_' || pac.ID_PACIENTE AS noPaciente, " +
			"	pac.NOMBRE AS nombre, " +
			"	pac.PRIMER_APELLIDO AS primerApellido, " +
			"	pac.SEGUNDO_APELLIDO AS segundoApellido, " +
			"	pac.FECHA_NACIMIENTO AS fechaNacimiento, " +
			"	UPPER( CONCAT( pac.NOMBRE ,' ', pac.PRIMER_APELLIDO , IF((pac.SEGUNDO_APELLIDO) = 0, ' ', '') , IFNULL(pac.SEGUNDO_APELLIDO, '') , '' )) AS paciente, " +
			"	pac.CURP AS curp, " +
			"	pac.FECHA_REGISTRO AS fechaRegistro, " +
			"	nac.PAIS AS nacionalidad, " +
			"	nac.NOM_CAT_NACIONALIDADES_ID AS nacionalidad_id, " +
			"	ent.DESCRIPCION AS entidadNacimiento, " +
			"	ent.CAT_ENTIDADES_ID AS entidadNacimiento_id, " +
			"	ent.CVE AS entidadNacimiento_cve, " +
			"	mun.DESCRIPCION AS municipioNacimiento, " +
			"	mun.CAT_MUNICIPIO_ID AS municipioNacimiento_id, " +
			"	mun.CVE_MUN AS municipioNacimiento_cve, " +
			"	pac.PESO AS peso, " +
			"	pac.TALLA AS talla, " +
			"	pac.FOTO_PACIENTE AS fotoPaciente, " +
			"	sex.DESCRIPCION AS sexo, " +
			"	sex.SEXO_ID AS sexo_id, " +
			"	rel.DESCRIPCION AS religion, " +
			"	rel.RELIGION_ID AS religion_id, " +
			"	pac.FALLECIDO AS fallecido, " +
			"	tis.DESCRIPCION AS tipoSangre, " +
			"	tis.TIPO_SANGRE_ID AS tipoSangre_id, " +
			"	prc.DESCRIPCION AS procedencia, " +
			"	prc.PROCEDENCIA_ID AS procedencia_id, " +
			"	ecv.NOMBRE AS estadoCivil, " +
			"	ecv.ESTADO_CIVIL_ID AS estadoCivil_id, " +
			"	ecl.DESCRIPCION AS escolaridad, " +
			"	ecl.ESCOLARIDAD_ID AS escolaridad_id, " +
			"	ind.NOMBRE AS indigena, " +
			"	ind.SINO_ID AS indigena_id, " +
			"	hin.NOMBRE AS hablaIndigena, " +
			"	hin.SINO_ID AS hablaIndigena_id, " +
			"	hes.NOMBRE AS hablaEspanol, " +
			"	hes.SINO_ID AS hablaEspanol_id, " +
			"	trb.NOMBRE AS trabajaActualmente, " +
			"	trb.SINO_ID AS trabajaActualmente_id, " +
			"	tli.NOMBRE AS tipoLenguaIndigena, " +
			"	tli.TIPO_LENGUA_INDIGENA_ID AS tipoLenguaIndigena_id, " +
			"	ocp.NOMBRE AS ocupacion, " +
			"	ocp.OCUPACION_ID AS ocupacion_id, " +
			"	IF(ISNULL(exp.NO_EXPEDIENTE)=0, CONCAT(exp.NO_EXPEDIENTE , IF(ISNULL(HSP.NOMBRE_CORTO)=0,CONCAT('  (' , HSP.NOMBRE_CORTO , ')'),'')), 'SIN EXPEDIENTE') AS noExpediente , " +
			"	tex.NOMBRE AS tipoExpediente, " +
			"	tex.TIPO_EXPEDIENTE_ID AS tipoExpediente_id, " +
			"	cse.NOMBRE AS servicioEspRegistro, " +
			"	cse.SERV_ESPECIALIDAD_ID AS servicioEspRegistro_id " +
			"FROM pac_paciente pac " +
			"	LEFT JOIN pac_expediente exp ON pac.ID_PACIENTE = exp.PACIENTE_ID " +
			"	LEFT JOIN nom_cat_nacionalidades nac ON pac.NACIONALIDAD_ID = nac.NOM_CAT_NACIONALIDADES_ID " +
			"	LEFT JOIN nom_cat_entidades ent ON pac.ENTIDAD_NAC_ID = ent.CVE " +
			"	LEFT JOIN nom_cat_municipio mun ON pac.MUNICIPIO_NAC_ID = mun.CVE_MUN AND pac.ENTIDAD_NAC_ID = mun.CVE_ENT " +
			"	LEFT JOIN nom_cat_sexo sex ON pac.SEXO_ID = sex.SEXO_ID " +
			"	LEFT JOIN nom_cat_religion rel ON pac.RELIGION_ID = rel.RELIGION_ID " +
			"	LEFT JOIN cat_tipo_sangre tis ON pac.TIPO_SANGRE_ID = tis.TIPO_SANGRE_ID " +
			"	LEFT JOIN cat_procedencia prc ON pac.PROCEDENCIA_ID = prc.PROCEDENCIA_ID " +
			"	LEFT JOIN nom_cat_estado_civil ecv ON pac.ESTADO_CIVIL_ID = ecv.ESTADO_CIVIL_ID " +
			"	LEFT JOIN nom_cat_escolaridad ecl ON pac.ESCOLARIDAD_ID = ecl.ESCOLARIDAD_ID " +
			"	LEFT JOIN nom_cat_sino ind ON pac.INDIGENA_ID = ind.SINO_ID " +
			"	LEFT JOIN nom_cat_sino hin ON pac.HABLA_INDIGENA_ID = hin.SINO_ID " +
			"	LEFT JOIN nom_cat_sino hes ON pac.HABLA_ESPANOL_ID = hes.SINO_ID " +
			"	LEFT JOIN nom_cat_sino trb ON pac.TRABAJA_ACTUALMENTE_ID = trb.SINO_ID " +
			"	LEFT JOIN nom_cat_tipo_lengua_indigena tli ON pac.TIPO_LENGUA_INDIGENA_ID = tli.TIPO_LENGUA_INDIGENA_ID " +
			"	LEFT JOIN nom_cat_ocupacion ocp ON pac.OCUPACION_ID = ocp.OCUPACION_ID " +
			"	LEFT JOIN cat_tipo_expediente tex ON exp.TIPO_EXPEDIENTE_ID = tex.TIPO_EXPEDIENTE_ID " +
			"	LEFT JOIN adm_cat_serv_especialidad cse ON exp.SERVICIO_ESP_REGISTRO = cse.SERV_ESPECIALIDAD_ID " +
			"	LEFT JOIN adm_hospital HSP ON HSP.HOSPITAL_ID = exp.HOSPITAL_ID ";
	
	// language=MySQL
	private String QRY_DATOS_PACIENTE_DUP = "" +
			"SELECT " +
			"	pac.ID_PACIENTE AS idPaciente, " +
			"	CONCAT('PAC_',pac.ID_PACIENTE) AS noPaciente, " +
			"	pac.NOMBRE AS nombre, " +
			"	pac.PRIMER_APELLIDO AS primerApellido, " +
			"	pac.SEGUNDO_APELLIDO AS segundoApellido, " +
			"	pac.FECHA_NACIMIENTO AS fechaNacimiento, " +
			"	pac.FECHA_ESTIMADA AS fechaEstimada, " +
			"	UPPER( CONCAT( pac.NOMBRE ,' ', pac.PRIMER_APELLIDO , IF((pac.SEGUNDO_APELLIDO) = 0, ' ', '') , IFNULL(pac.SEGUNDO_APELLIDO, '') , '' )) AS paciente, " +
			"	pac.CURP AS curp, " +
			"	pac.DESCONOCE_CURP AS desconoceCurp, " +
			"	pac.FECHA_REGISTRO AS fechaRegistro, " +
			"	nac.PAIS AS nacionalidad, " +
			"	nac.NOM_CAT_NACIONALIDADES_ID AS nacionalidad_id, " +
			"	ent.DESCRIPCION AS entidadNacimiento, " +
			"	ent.CAT_ENTIDADES_ID AS entidadNacimiento_id, " +
			"	ent.CVE AS entidadNacimiento_cve, " +
			"	mun.DESCRIPCION AS municipioNacimiento, " +
			"	mun.CAT_MUNICIPIO_ID AS municipioNacimiento_id, " +
			"	mun.CVE_MUN AS municipioNacimiento_cve, " +
			"	pac.PESO AS peso, " +
			"	pac.TALLA AS talla, " +
			"	sex.DESCRIPCION AS sexo, " +
			"	sex.SEXO_ID AS sexo_id, " +
			"	rel.DESCRIPCION AS religion, " +
			"	rel.RELIGION_ID AS religion_id, " +
			"	pac.FALLECIDO AS fallecido, " +
			"	tis.DESCRIPCION AS tipoSangre, " +
			"	tis.TIPO_SANGRE_ID AS tipoSangre_id, " +
			"	prc.DESCRIPCION AS procedencia, " +
			"	prc.PROCEDENCIA_ID AS procedencia_id, " +
			"	ecv.NOMBRE AS estadoCivil, " +
			"	ecv.ESTADO_CIVIL_ID AS estadoCivil_id, " +
			"	ecl.DESCRIPCION AS escolaridad, " +
			"	ecl.ESCOLARIDAD_ID AS escolaridad_id, " +
			"	ind.NOMBRE AS indigena, " +
			"	ind.SINO_ID AS indigena_id, " +
			"	hin.NOMBRE AS hablaIndigena, " +
			"	hin.SINO_ID AS hablaIndigena_id, " +
			"	hes.NOMBRE AS hablaEspanol, " +
			"	hes.SINO_ID AS hablaEspanol_id, " +
			"	trb.NOMBRE AS trabajaActualmente, " +
			"	trb.SINO_ID AS trabajaActualmente_id, " +
			"	tli.NOMBRE AS tipoLenguaIndigena, " +
			"	tli.TIPO_LENGUA_INDIGENA_ID AS tipoLenguaIndigena_id, " +
			"	ocp.NOMBRE AS ocupacion, " +
			"	ocp.OCUPACION_ID AS ocupacion_id, " +
			"	IF(ISNULL(exp.NO_EXPEDIENTE)=0, CONCAT(exp.NO_EXPEDIENTE , IF(ISNULL(HSP.NOMBRE_CORTO)=0,CONCAT('  (' , HSP.NOMBRE_CORTO , ')'),'')), 'SIN EXPEDIENTE') AS noExpediente , " +
			"	tex.NOMBRE AS tipoExpediente, " +
			"	tex.TIPO_EXPEDIENTE_ID AS tipoExpediente_id, " +
			"	cse.NOMBRE AS servicioEspRegistro, " +
			"	cse.SERV_ESPECIALIDAD_ID AS servicioEspRegistro_id, " +
			"	pac.PAC_MIGRANTE AS migrante, " +
			"	pac.PAC_FACTOR_RH AS factorRH, " +
			"	pac.FOTO_PACIENTE AS fotoPaciente, " +
			"	pac.PAC_FECHA_ID_TIPO_SANGRE AS fechaIdTipoSangre, " +
			"	COUNT(pde.CONFIRMAR_DIAGNOSTICO) AS confirmarCronico " +
			"FROM pac_paciente pac " +
			"	LEFT JOIN pac_expediente exp ON pac.ID_PACIENTE = exp.PACIENTE_ID AND exp.HOSPITAL_ID = :pHospitalId " +
			"	LEFT JOIN nom_cat_nacionalidades nac ON pac.NACIONALIDAD_ID = nac.CODIGO_PAIS " +
			"	LEFT JOIN nom_cat_entidades ent ON pac.ENTIDAD_NAC_ID = ent.CAT_ENTIDADES_ID " +
			"	LEFT JOIN nom_cat_municipio mun ON pac.MUNICIPIO_NAC_ID = mun.CAT_MUNICIPIO_ID  " +
			"	LEFT JOIN nom_cat_sexo sex ON pac.SEXO_ID = sex.SEXO_ID " +
			"	LEFT JOIN nom_cat_religion rel ON pac.RELIGION_ID = rel.RELIGION_ID " +
			"	LEFT JOIN cat_tipo_sangre tis ON pac.TIPO_SANGRE_ID = tis.TIPO_SANGRE_ID " +
			"	LEFT JOIN cat_procedencia prc ON pac.PROCEDENCIA_ID = prc.PROCEDENCIA_ID " +
			"	LEFT JOIN nom_cat_estado_civil ecv ON pac.ESTADO_CIVIL_ID = ecv.ESTADO_CIVIL_ID " +
			"	LEFT JOIN nom_cat_escolaridad ecl ON pac.ESCOLARIDAD_ID = ecl.ESCOLARIDAD_ID " +
			"	LEFT JOIN nom_cat_sino ind ON pac.INDIGENA_ID = ind.SINO_ID " +
			"	LEFT JOIN nom_cat_sino hin ON pac.HABLA_INDIGENA_ID = hin.SINO_ID " +
			"	LEFT JOIN nom_cat_sino hes ON pac.HABLA_ESPANOL_ID = hes.SINO_ID " +
			"	LEFT JOIN nom_cat_sino trb ON pac.TRABAJA_ACTUALMENTE_ID = trb.SINO_ID " +
			"	LEFT JOIN nom_cat_tipo_lengua_indigena tli ON pac.TIPO_LENGUA_INDIGENA_ID = tli.TIPO_LENGUA_INDIGENA_ID " +
			"	LEFT JOIN nom_cat_ocupacion ocp ON pac.OCUPACION_ID = ocp.OCUPACION_ID " +
			"	LEFT JOIN cat_tipo_expediente tex ON exp.TIPO_EXPEDIENTE_ID = tex.TIPO_EXPEDIENTE_ID " +
			"	LEFT JOIN adm_cat_serv_especialidad cse ON exp.SERVICIO_ESP_REGISTRO = cse.SERV_ESPECIALIDAD_ID " +
			"	LEFT JOIN adm_hospital HSP ON HSP.HOSPITAL_ID = exp.HOSPITAL_ID " +
			"	LEFT JOIN pac_evento pe on pac.ID_PACIENTE = pe.ID_PACIENTE " +
			"	LEFT JOIN pac_diagnostico_evento pde on pe.EVENTO_ID = pde.EVENTO_ID AND pde.CONFIRMAR_DIAGNOSTICO = 1";
	
	@Override
	public NomCatMunicipio obtenerMunicipioByEdo(String estadoCve, String municipioCve) {
// language=MySQL
		String qry_municipio_id = "" +
				" select " +
				" ncm.CAT_MUNICIPIO_ID as catMunicipioId " +
				" from nom_cat_municipio ncm " +
				" where ncm.CVE_ENT like :pCveEnt and ncm.CVE_MUN like :pCveMun ";

		Session s = getCurrentSession();
		Query query = s.createSQLQuery(qry_municipio_id)
				.addScalar("catMunicipioId", StandardBasicTypes.INTEGER);

		query.setParameter("pCveEnt", estadoCve);
		query.setParameter("pCveMun", municipioCve);

		query.setResultTransformer(Transformers.aliasToBean(NomCatMunicipio.class));
		
		var r = (NomCatMunicipio) query.uniqueResult();
		s.close();
		return r;
	}
	
	@Override
	public Integer getTipoRegistrobyDesc(String cadena) {
		Integer valor;

		try {
			Session s = getCurrentSession();
			Criteria entidad = s.createCriteria(NomCatTipoRegistro.class, "entidad").setProjection(Projections
					.projectionList()
					.add(Projections.property("tipoRegistroId"), "id")

			);
			entidad.add(Restrictions.ilike("descripcion", cadena));

			valor = entidad.uniqueResult() != null ? (Integer) entidad.uniqueResult() : null;
			s.close();
			logger.info("##################  invocando a DAO  PacienteDAOImpl getTipoRegistrobyDesc ##################");
		} catch (Exception e) {
			valor = 0;
			logger.info("########### Ocurrio un error al obtener getTipoRegistrobyDesc", e);
		}

		return valor;
	}
	
	
	@Override
	public CatTipoExpediente obtenerTipoExpedienteDefault() {
		// language=MySQL
		String QRY_TIPO_EXP = "" +
				"SELECT " + "config.CONFIG_ID AS configId " +
				"FROM core_config config " +
				"WHERE config.HOSPITAL_ID  IN (    " +
				"      SELECT rol.HOSPITAL_ID    " +
				"      FROM adm_cat_rol rol    " +
				"      WHERE rol.ROL_ID = :pIdRol    " +
				"      GROUP BY rol.HOSPITAL_ID    " +
				"     ) " +
				"AND config.FECHA_REGISTRO = (SELECT max(config.FECHA_REGISTRO) FROM core_config config" +
				" WHERE config.HOSPITAL_ID  IN ( " +
				"								SELECT rol.HOSPITAL_ID    " +
				"   							FROM adm_cat_rol rol    " +
				"   							WHERE rol.ROL_ID = :pIdRol     " +
				"     							GROUP BY rol.HOSPITAL_ID     ) " +
				")";

		Session s = getCurrentSession();
		Query query = s.createSQLQuery(QRY_TIPO_EXP)
				.addScalar("configId", StandardBasicTypes.INTEGER);

		int idRol = Integer.valueOf(new SecurityUtil().getRole(SecurityContextHolder.getContext().getAuthentication().getName()));

		query.setParameter("pIdRol", idRol);

		Integer configId = (Integer) query.uniqueResult();
		logger.info("	ConfigId: ", configId);
		
		s.close();

		if (configId == null)
			return null;

		CoreConfig entidad = get(CoreConfig.class, configId);
		String json = entidad.getConfiguracion();
		ObjectMapper mapper = new ObjectMapper();
		try {
			Map<String, String> obj = mapper.readValue(json, new TypeReference<Map<String, String>>() {
			});

			return get(CatTipoExpediente.class, Integer.parseInt((String) obj.get("tipoExpedienteId")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public CatEstatusExpediente obtenerCatEstatusExpediente(Integer id) {
		Session s = getCurrentSession();
		Criteria catEstatusExpediente = s.createCriteria(CatEstatusExpediente.class, "catEstatusExpediente");
		catEstatusExpediente.add(Restrictions.eq("catEstatusExpediente.estatusExpedienteId", id));
		var r = (CatEstatusExpediente) catEstatusExpediente.uniqueResult();
		s.close();
		return r;
	}

	@Override
	public CatUbicacionExpediente obterCatUbicacionExpediente(Integer id) {
		Session s = getCurrentSession();
		Criteria catUbicacionExpediente = s.createCriteria(CatUbicacionExpediente.class, "catUbicacionExpediente");
		catUbicacionExpediente.add(Restrictions.eq("catUbicacionExpediente.ubicacionExpedienteId", id));
		var r = (CatUbicacionExpediente) catUbicacionExpediente.uniqueResult();
		s.close();
		return r;
	}
	
	@Override
	public PacPacienteDTO pacienteByCurp(PacPacienteDTO dto) {

		PacPacienteDTO pacienteCurp;
		try {

			Session s = getCurrentSession();
			Criteria resultado = s.createCriteria(PacPaciente.class, "pacienteCurp")
					.setProjection(Projections.projectionList()
							.add(Projections.property("pacienteCurp.idPaciente"), "idPaciente")
							.add(Projections.property("pacienteCurp.curp"), "curp")
							.add(Projections.property("pacienteCurp.nombre"), "nombre")
							.add(Projections.property("pacienteCurp.primerApellido"), "primerApellido")
							.add(Projections.property("pacienteCurp.segundoApellido"), "segundoApellido")
					);

			resultado.add(Restrictions.eq("pacienteCurp.curp", dto.getCurp()));


			resultado.setResultTransformer(Transformers.aliasToBean(PacPacienteDTO.class));

			pacienteCurp = (PacPacienteDTO) resultado.uniqueResult();
			s.close();
		} catch (Exception e) {
			pacienteCurp = null;
			logger.info("########### Ocurrio un error al recuperar obtenPacienteByID ", e);
		}


		return pacienteCurp;
	}

	@Override
	public List<CatalogosDTO> getProcedenciaByDefault() {
		List<CatalogosDTO> lista;

		try {
			Session s = getCurrentSession();
			Criteria entidad = s.createCriteria(CatProcedencia.class, "entidad").setProjection(Projections
					.projectionList()
					.add(Projections.property("procedenciaId"), "id")
					.add(Projections.property("valorDefault"), "indicadefault")
					.add(Projections.property("descripcion"), "descripcion")
			);

			entidad.add(Restrictions.eq("valorDefault", 1));
			
			entidad.setResultTransformer(Transformers.aliasToBean(CatalogosDTO.class));
			lista = entidad.list();
			
			s.close();

			logger.info("##################  invocando a DAO  PacienteDAOImpl getProcedenciaByDefault =" + lista.size() + " ##################");
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al obtener getProcedenciaByDefault", e);
		}

		return lista;
	}

	@Override
	public List<CatalogosDTO> getEntidadByDefault() {
		List<CatalogosDTO> lista;

		try {
			Session s = getCurrentSession();
			Criteria entidad = s.createCriteria(NomCatEntidades.class, "entidad").setProjection(Projections
					.projectionList()
					.add(Projections.property("catEntidadesId"), "id")
					.add(Projections.property("indicaDefault"), "indicadefault")
					.add(Projections.property("cve"), "descripcion")
			);

			entidad.add(Restrictions.eq("indicaDefault", 1));
			
			entidad.setResultTransformer(Transformers.aliasToBean(CatalogosDTO.class));
			lista = entidad.list();

			s.close();
			logger.info("##################  invocando a DAO  PacienteDAOImpl getEntidadByDefault =" + lista.size() + " ##################");
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al obtener getEntidadByDefault", e);
		}

		return lista;
	}

	@Override
	public List<CatalogosDTO> getNacionalidadByDefault() {
		
		List<CatalogosDTO> lista;
		try {
			Session s = getCurrentSession();
			Criteria entidad = s.createCriteria(NomCatNacionalidades.class, "entidad").setProjection(Projections
					.projectionList()
					.add(Projections.property("nomCatNacionalidadesId"), "id")
					.add(Projections.property("indicaDefault"), "indicadefault")
					.add(Projections.property("pais"), "descripcion")
			);

			entidad.add(Restrictions.eq("indicaDefault", 1));
			
			entidad.setResultTransformer(Transformers.aliasToBean(CatalogosDTO.class));
			lista = entidad.list();
			
			s.close();
			logger.info("##################  invocando a DAO  PacienteDAOImpl getNacionalidadByDefault =" + lista.size() + " ##################");
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al obtener getNacionalidadByDefault", e);
		}

		return lista;
	}


	@Override
	public List<CatalogosDTO> getSexoByDefault() {
		List<CatalogosDTO> lista;

		try {
			Session s = getCurrentSession();
			
			@SuppressWarnings("deprecation")
			Criteria entidad = s.createCriteria(NomCatSexo.class, "entidad").setProjection(Projections
					.projectionList()
					.add(Projections.property("sexoId"), "id")
					.add(Projections.property("indicaDefault"), "indicadefault")
					.add(Projections.property("descripcion"), "descripcion")
			);

			entidad.add(Restrictions.eq("indicaDefault", 1));

			entidad.setResultTransformer(Transformers.aliasToBean(CatalogosDTO.class));
			lista = entidad.list();
			
			s.close();

			logger.info("##################  invocando a DAO  PacienteDAOImpl getSexoByDefault =" + lista.size() + " ##################");
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al obtener getSexoByDefault", e);
		}

		return lista;
	}

	@Override
	public PacienteDuplicadoDatosDTO consultarDatosPaciente(int idPaciente) {
		Integer idRol = Integer.valueOf(new SecurityUtil().getRole(SecurityContextHolder.getContext().getAuthentication().getName()));
		AdmHospital hospital = hospitalDAO.obtenerIdHospital(idRol);

		String QRY_DATOS_PACIENTE = QRY_DATOS_PACIENTE_DUP + " WHERE pac.ID_PACIENTE = :pIdPaciente ";

		Session s = getCurrentSession();
		Query query = s.createSQLQuery(QRY_DATOS_PACIENTE)
				.addScalar("idPaciente", StandardBasicTypes.INTEGER)
				.addScalar("noPaciente", StandardBasicTypes.STRING)
				.addScalar("nombre", StandardBasicTypes.STRING)
				.addScalar("primerApellido", StandardBasicTypes.STRING)
				.addScalar("segundoApellido", StandardBasicTypes.STRING)
				.addScalar("fechaNacimiento", StandardBasicTypes.TIMESTAMP)
				.addScalar("fechaIdTipoSangre", StandardBasicTypes.TIMESTAMP)
				.addScalar("fechaEstimada", StandardBasicTypes.INTEGER)
				.addScalar("desconoceCurp", StandardBasicTypes.INTEGER)
				.addScalar("curp", StandardBasicTypes.STRING)
				.addScalar("fechaRegistro", StandardBasicTypes.TIMESTAMP)
				.addScalar("nacionalidad", StandardBasicTypes.STRING)
				.addScalar("nacionalidad_id", StandardBasicTypes.INTEGER)
				.addScalar("entidadNacimiento", StandardBasicTypes.STRING)
				.addScalar("entidadNacimiento_id", StandardBasicTypes.INTEGER)
				.addScalar("entidadNacimiento_cve", StandardBasicTypes.STRING)
				.addScalar("municipioNacimiento", StandardBasicTypes.STRING)
				.addScalar("municipioNacimiento_id", StandardBasicTypes.INTEGER)
				.addScalar("municipioNacimiento_cve", StandardBasicTypes.STRING)
				.addScalar("peso", StandardBasicTypes.FLOAT)
				.addScalar("talla", StandardBasicTypes.FLOAT)
				.addScalar("sexo", StandardBasicTypes.STRING)
				.addScalar("sexo_id", StandardBasicTypes.INTEGER)
				.addScalar("religion", StandardBasicTypes.STRING)
				.addScalar("religion_id", StandardBasicTypes.STRING)
				.addScalar("fallecido", StandardBasicTypes.INTEGER)
				.addScalar("tipoSangre", StandardBasicTypes.STRING)
				.addScalar("tipoSangre_id", StandardBasicTypes.INTEGER)
				.addScalar("procedencia", StandardBasicTypes.STRING)
				.addScalar("procedencia_id", StandardBasicTypes.INTEGER)
				.addScalar("estadoCivil", StandardBasicTypes.STRING)
				.addScalar("estadoCivil_id", StandardBasicTypes.INTEGER)
				.addScalar("escolaridad", StandardBasicTypes.STRING)
				.addScalar("escolaridad_id", StandardBasicTypes.INTEGER)
				.addScalar("indigena", StandardBasicTypes.STRING)
				.addScalar("indigena_id", StandardBasicTypes.INTEGER)
				.addScalar("hablaIndigena", StandardBasicTypes.STRING)
				.addScalar("hablaIndigena_id", StandardBasicTypes.INTEGER)
				.addScalar("hablaEspanol", StandardBasicTypes.STRING)
				.addScalar("hablaEspanol_id", StandardBasicTypes.INTEGER)
				.addScalar("trabajaActualmente", StandardBasicTypes.STRING)
				.addScalar("trabajaActualmente_id", StandardBasicTypes.INTEGER)
				.addScalar("tipoLenguaIndigena", StandardBasicTypes.STRING)
				.addScalar("tipoLenguaIndigena_id", StandardBasicTypes.INTEGER)
				.addScalar("ocupacion", StandardBasicTypes.STRING)
				.addScalar("ocupacion_id", StandardBasicTypes.INTEGER)
				.addScalar("noExpediente", StandardBasicTypes.STRING)
				.addScalar("tipoExpediente", StandardBasicTypes.STRING)
				.addScalar("tipoExpediente_id", StandardBasicTypes.INTEGER)
				.addScalar("servicioEspRegistro", StandardBasicTypes.STRING)
				.addScalar("paciente", StandardBasicTypes.STRING)
				.addScalar("servicioEspRegistro_id", StandardBasicTypes.INTEGER)
				.addScalar("migrante", StandardBasicTypes.INTEGER)
				.addScalar("confirmarCronico", StandardBasicTypes.INTEGER)
				.addScalar("factorRH", StandardBasicTypes.INTEGER)
				.addScalar("fotoPaciente", StandardBasicTypes.STRING);

		query.setParameter("pIdPaciente", idPaciente);
		query.setParameter("pHospitalId", hospital.getHospitalId());
		query.setResultTransformer(Transformers.aliasToBean(PacienteDuplicadoDatosDTO.class));

		var r = (PacienteDuplicadoDatosDTO) query.uniqueResult();
		s.close(); 
		return r;
	}

	@Override
	public int guardaContactoPaciente(AgenteContactoDTO dto) {
		logger.info("##################  invocando a DAO PacienteDAOImpl guardaContactoPaciente ##################");

		int exito;
		Date fecHoy = new Date();

		try {
			if (dto.getContacto().getContactoId() == null || dto.getContacto().getContactoId() <= 0) {  //Es una Alta
				Contacto contact = new Contacto();

				contact.setNombre(dto.getContacto().getNombre());
				contact.setPrimerApellido(dto.getContacto().getPrimerApellido());
				contact.setSegundoApellido(dto.getContacto().getSegundoApellido());

				contact.setFechaNacimiento(dto.getContacto().getFechaNacimiento());
				contact.setRespLegal((dto.getContacto().getRespLegal() == null) ? 0 : dto.getContacto().getRespLegal());
				contact.setCurp(dto.getContacto().getCurp());
				contact.setStatus(1);

				if (dto.getContacto().getNomCatSexo() != null && dto.getContacto().getNomCatSexo().getSexoId() != null) {
					contact.setNomCatSexo(new NomCatSexo(dto.getContacto().getNomCatSexo().getSexoId()));
				}

				if (dto.getContacto().getNomCatParentesco() != null && dto.getContacto().getNomCatParentesco().getParentescoId() != null) {
					contact.setNomCatParentesco(new NomCatParentesco(dto.getContacto().getNomCatParentesco().getParentescoId()));
				}

				if (dto.getContacto().getNomCatEstadoCivil() != null && dto.getContacto().getNomCatEstadoCivil().getEstadoCivilId() != null) {
					contact.setNomCatEstadoCivil(new NomCatEstadoCivil(dto.getContacto().getNomCatEstadoCivil().getEstadoCivilId()));
				}

				if (dto.getContacto().getNomCatEscolaridad() != null && dto.getContacto().getNomCatEscolaridad().getEscolaridadId() != null) {
					contact.setNomCatEscolaridad(new NomCatEscolaridad(dto.getContacto().getNomCatEscolaridad().getEscolaridadId()));
				}

				if (dto.getContacto().getNomCatOcupacion() != null && dto.getContacto().getNomCatOcupacion().getOcupacionId() != null) {
					contact.setNomCatOcupacion(new NomCatOcupacion(dto.getContacto().getNomCatOcupacion().getOcupacionId()));
				}


				logger.info("######## Guardando contacto en BD...");				
				if (guardarEntidad(contact) == 0) {
					logger.info("NOTA 1: Revisar validacion de almacenamiento CONTACTO!!");	
					//return 0;
				}
				/*Es posible recuperar el idContacto almacenado en base de datos sin recuperarlo antes?? */
				logger.info("######## ...Contacto guardado en BD: "+contact.getContactoId());
				/*SI. Whaoooo :O */
				

				dto.getContacto().setContactoId(contact.getContactoId());
				logger.info("##################  invocando a DAO PacienteDAOImpl alta Contacto " + contact.getContactoId() + " ##################");

				AgenteContacto actEntidad = AgenteContacto.ContactoPaciente(contact, dto.getAgenteId());

				if (guardarEntidad(actEntidad) == 0) {
					logger.info("NOTA 2: Revisar validacion de almacenamiento ACTENTIDAD!!");	
					//return 0;
				}

				exito = actEntidad.getAgenteContactoId();
				
			} else {
				Criteria ct = construyeCriteria(Contacto.class);
				ct.add(Restrictions.eq("contactoId", dto.getContacto().getContactoId()));

				Contacto contact = (Contacto) ct.uniqueResult();

				contact.setNombre(dto.getContacto().getNombre());
				contact.setPrimerApellido(dto.getContacto().getPrimerApellido());
				contact.setSegundoApellido(dto.getContacto().getSegundoApellido());
				contact.setFechaNacimiento(dto.getContacto().getFechaNacimiento());
				contact.setRespLegal(dto.getContacto().getRespLegal());
				contact.setCurp(dto.getContacto().getCurp());

				if (dto.getContacto().getNomCatSexo() != null && dto.getContacto().getNomCatSexo().getSexoId() != null) {
					contact.setNomCatSexo(new NomCatSexo(dto.getContacto().getNomCatSexo().getSexoId()));
				}

				if (dto.getContacto().getNomCatParentesco() != null && dto.getContacto().getNomCatParentesco().getParentescoId() != null) {
					contact.setNomCatParentesco(new NomCatParentesco(dto.getContacto().getNomCatParentesco().getParentescoId()));
				}

				if (dto.getContacto().getNomCatEstadoCivil() != null && dto.getContacto().getNomCatEstadoCivil().getEstadoCivilId() != null) {
					contact.setNomCatEstadoCivil(new NomCatEstadoCivil(dto.getContacto().getNomCatEstadoCivil().getEstadoCivilId()));
				}

				if (dto.getContacto().getNomCatEscolaridad() != null && dto.getContacto().getNomCatEscolaridad().getEscolaridadId() != null) {
					contact.setNomCatEscolaridad(new NomCatEscolaridad(dto.getContacto().getNomCatEscolaridad().getEscolaridadId()));
				}

				if (dto.getContacto().getNomCatOcupacion() != null && dto.getContacto().getNomCatOcupacion().getOcupacionId() != null) {
					contact.setNomCatOcupacion(new NomCatOcupacion(dto.getContacto().getNomCatOcupacion().getOcupacionId()));
				}

				if (actualizarEntidad(contact) == 0) {
					return 0;
				}

				exito = contact.getContactoId();

				logger.info("##################  invocando a DAO PacienteDAOImpl modifica Contacto " + contact.getContactoId() + " ##################");
			}

			/* **********************************CORREO******************************************* */
			if (dto.getContacto().getCorreo() != null && !Objects.equals(dto.getContacto().getCorreo().getCorreo(), "")) {
				if (dto.getContacto().getCorreo().getCorreoId() == null || dto.getContacto().getCorreo().getCorreoId() <= 0) {  //Alta Correo
					logger.info("##################  invocando a DAO PacienteDAOImpl alta Correo ##################");

					Correo mail = new Correo();

					mail.setCorreo(dto.getContacto().getCorreo().getCorreo());
					mail.setStatus(1);
					mail.setUsuarioCve(SecurityContextHolder.getContext().getAuthentication().getName());
					mail.setFechaRegistro(fecHoy);

					if (guardarEntidad(mail) == 0) {
						logger.info("NOTA 3: Revisar validacion de almacenamiento!!");	
						//return 0;
					}

					logger.info("ID CORREO REGISTRADO"+mail.getCorreoId());

					AgenteCorreo acEntidad = AgenteCorreo.CorreoContactoPaciente(mail.getCorreoId(), dto.getContacto().getContactoId());

					if (guardarEntidad(acEntidad) == 0) {
						logger.info("NOTA 4: Revisar validacion de almacenamiento!!");	
						//return 0;
					}

					exito = acEntidad.getAgenteCorreoId();
				} else {
					logger.info("##################  invocando a DAO PacienteDAOImpl modifica Correo ##################");

					Correo mail = get(Correo.class, dto.getContacto().getCorreo().getCorreoId());

					mail.setCorreo(dto.getContacto().getCorreo().getCorreo());

					if (actualizarEntidad(mail) == 0) {
						logger.info("NOTA 5: Revisar validacion de almacenamiento!!");	
						//return 0;
					}

					exito = mail.getCorreoId();

					logger.info("##################  invocando a DAO PacienteDAOImpl modifica Correo " + mail.getCorreoId() + " ##################");
				}
			}

			/* **********************************TELEFONO******************************************* */
			if (dto.getContacto().getTelefono() != null && !Objects.equals(dto.getContacto().getTelefono().getTelefono(), "")) {
				if (dto.getContacto().getTelefono().getTelefonoId() == null || dto.getContacto().getTelefono().getTelefonoId() <= 0) {  //Alta Telefono
					logger.info("##################  invocando a DAO PacienteDAOImpl alta Telefono ##################");

					Telefono phone = new Telefono();

					phone.setTipoTelefonoId(dto.getContacto().getTelefono().getCatTipoTelefono().getTipoTelefonoId());
					phone.setTelefono(dto.getContacto().getTelefono().getTelefono());
					phone.setStatus(1);
					phone.setUsuarioCve(SecurityContextHolder.getContext().getAuthentication().getName());
					phone.setFechaRegistro(fecHoy);

					if (guardarEntidad(phone) == 0) {
						logger.info("NOTA 6: Revisar validacion de almacenamiento!!");
						//return 0;
					}

					logger.info("##################  invocando a DAO PacienteDAOImpl alta Telefono " + phone.getTelefonoId() + " ##################");

					AgenteTelefono atEntidad = AgenteTelefono.TelefonoContactoPaciente(phone, dto.getContacto().getContactoId());

					if (guardarEntidad(atEntidad) == 0) {
						logger.info("NOTA 7: Revisar validacion de almacenamiento!!");
						//return 0;
					}

					exito = atEntidad.getAgenteTelefonoId();
					logger.info("##################  invocando a DAO PacienteDAOImpl alta Agente Telefono " + atEntidad.getAgenteTelefonoId() + " ##################");
				} else {
					logger.info("##################  invocando a DAO PacienteDAOImpl modifica Telefono ##################");

					Telefono phone = get(Telefono.class, dto.getContacto().getTelefono().getTelefonoId());

					phone.setCatTipoTelefono(new CatTipoTelefono(dto.getContacto().getTelefono().getCatTipoTelefono().getTipoTelefonoId()));
					phone.setTelefono(dto.getContacto().getTelefono().getTelefono());
					phone.setCve(dto.getContacto().getTelefono().getCve());

					if (actualizarEntidad(phone) == 0) {
						return 0;
					}

					exito = phone.getTelefonoId();
					logger.info("##################  invocando a DAO PacienteDAOImpl modifica Correo " + phone.getTelefonoId() + " ##################");
				}
			}

			/* **********************************DOCUMENTO******************************************* */

			if (dto.getContacto().getDocumento() != null && !Objects.equals(dto.getContacto().getDocumento().getNumero(), "")) {
				if (dto.getContacto().getDocumento().getDocumentoId() == null || dto.getContacto().getDocumento().getDocumentoId() <= 0) {  //Alta Documento
					logger.info("##################  invocando a DAO PacienteDAOImpl alta Documento ##################");

					Documento docto = new Documento();

					docto.setDocumentoIdentificacionId(dto.getContacto().getDocumento().getCatDocumentoIdentificacion().getDocumentoIdentificacionId());

					docto.setNumero(dto.getContacto().getDocumento().getNumero());
					docto.setCve(dto.getContacto().getDocumento().getCve());
					docto.setStatus(1);
					docto.setFechaRegistro(fecHoy);
					docto.setUsuarioRegistra(SecurityContextHolder.getContext().getAuthentication().getName());

					if (guardarEntidad(docto) == 0) {
						return 0;
					}

					logger.info("##################  invocando a DAO PacienteDAOImpl alta Documento " + docto.getDocumentoId() + " ##################");

					AgenteDocumento adEntidad = AgenteDocumento.DocumentoContactoPaciente(docto, dto.getContacto().getContactoId());

					if (guardarEntidad(adEntidad) == 0) {
						return 0;
					}

					exito = adEntidad.getAgenteDocumentoId();

					logger.info("##################  invocando a DAO PacienteDAOImpl alta Agente Documento " + adEntidad.getAgenteDocumentoId() + " ##################");
				} else {
					logger.info("##################  invocando a DAO PacienteDAOImpl modifica Documento ##################");

					Documento docto = get(Documento.class, dto.getContacto().getDocumento().getDocumentoId());

					docto.setDocumentoIdentificacionId(dto.getContacto().getDocumento().getCatDocumentoIdentificacion().getDocumentoIdentificacionId());
					docto.setNumero(dto.getContacto().getDocumento().getNumero());
					docto.setCve(dto.getContacto().getTelefono().getCve());

					if (actualizarEntidad(docto) == 0) {
						return 0;
					}

					exito = docto.getDocumentoId();

					logger.info("##################  invocando a DAO PacienteDAOImpl modifica Documento " + docto.getDocumentoId() + " ##################");
				}
			}

			/* **********************************DIRECCION******************************************* */
			if (dto.getContacto().getDireccion() != null) {
				if (dto.getContacto().getDireccion().getDireccionId() == null || dto.getContacto().getDireccion().getDireccionId() <= 0) {  //Alta Direccion
					logger.info("##################  invocando a DAO PacienteDAOImpl alta Direccion ##################");

					Direccion direcc = new Direccion();

					if (dto.getContacto().getDireccion().getNomCatEntidades() != null && dto.getContacto().getDireccion().getNomCatEntidades().getCatEntidadesId() != null) {
						direcc.setNomCatEntidadesId(dto.getContacto().getDireccion().getNomCatEntidades().getCatEntidadesId());
					}

					if (dto.getContacto().getDireccion().getNomCatMunicipio() != null && dto.getContacto().getDireccion().getNomCatMunicipio().getCatMunicipioId() != null) {
						direcc.setNomCatMunicipioId(dto.getContacto().getDireccion().getNomCatMunicipio().getCatMunicipioId());
					}

					if (dto.getContacto().getDireccion().getNomCatLocalidad() != null && dto.getContacto().getDireccion().getNomCatLocalidad().getCatLocalidadId() != null) {
						direcc.setNomCatLocalidadId(dto.getContacto().getDireccion().getNomCatLocalidad().getCatLocalidadId());
					}

					if (dto.getContacto().getDireccion().getNomCatCodigoPostal() != null && dto.getContacto().getDireccion().getNomCatCodigoPostal().getCatCodigoPostalId() != null) {
						direcc.setNomCatCodigoPostalId(dto.getContacto().getDireccion().getNomCatCodigoPostal().getCatCodigoPostalId());
					}

					if (dto.getContacto().getDireccion().getCatTipoAsen() != null && dto.getContacto().getDireccion().getCatTipoAsen().getTipoAsenId() != null) {
						direcc.setCatTipoAsenId(dto.getContacto().getDireccion().getCatTipoAsen().getTipoAsenId());
					}

					if (dto.getContacto().getDireccion().getNomCatPaises() != null && dto.getContacto().getDireccion().getNomCatPaises().getPaisId() != null) {
						direcc.setNomCatPaisesId(dto.getContacto().getDireccion().getNomCatPaises().getPaisId());
					}

					if (dto.getContacto().getDireccion().getCatVialidad() != null && dto.getContacto().getDireccion().getCatVialidad().getVialidadId() != null) {
						direcc.setCatVialidadId(dto.getContacto().getDireccion().getCatVialidad().getVialidadId());
					}

					direcc.setCalle(dto.getContacto().getDireccion().getCalle());
					direcc.setNoExt(dto.getContacto().getDireccion().getNoExt());
					direcc.setNoExtLetra(dto.getContacto().getDireccion().getNoExtLetra());
					direcc.setNoInt(dto.getContacto().getDireccion().getNoInt());
					direcc.setNoIntLetra(dto.getContacto().getDireccion().getNoIntLetra());
					direcc.setNombreVialidad(dto.getContacto().getDireccion().getNombreVialidad());
					direcc.setNombreAsentamiento(dto.getContacto().getDireccion().getNombreAsentamiento());

					direcc.setFechaRegistro(fecHoy);
					direcc.setStatus(1);
					direcc.setCve(dto.getContacto().getDireccion().getCve());
					direcc.setUsuarioCve(SecurityContextHolder.getContext().getAuthentication().getName());

					if (guardarEntidad(direcc) == 0) {
						return 0;
					}

					logger.info("##################  invocando a DAO PacienteDAOImpl alta Direccion " + direcc.getDireccionId() + " ##################");

					AgenteDireccion adiEntidad = AgenteDireccion.DireccionContactoPaciente(direcc, dto.getContacto().getContactoId());

					if (guardarEntidad(adiEntidad) == 0) {
						return 0;
					}

					exito = adiEntidad.getAgenteDireccionId();

					logger.info("##################  invocando a DAO PacienteDAOImpl alta Agente Direccion " + adiEntidad.getAgenteDireccionId() + " ##################");
				} else {
					logger.info("##################  invocando a DAO PacienteDAOImpl modifica Direccion ##################");

					Direccion direcc = get(Direccion.class, dto.getContacto().getDireccion().getDireccionId());

					if (dto.getContacto().getDireccion().getNomCatEntidades() != null && dto.getContacto().getDireccion().getNomCatEntidades().getCatEntidadesId() != null) {
						direcc.setNomCatEntidadesId(dto.getContacto().getDireccion().getNomCatEntidades().getCatEntidadesId());
					}

					if (dto.getContacto().getDireccion().getNomCatMunicipio() != null && dto.getContacto().getDireccion().getNomCatMunicipio().getCatMunicipioId() != null) {
						direcc.setNomCatMunicipioId(dto.getContacto().getDireccion().getNomCatMunicipio().getCatMunicipioId());
					}

					if (dto.getContacto().getDireccion().getNomCatLocalidad() != null && dto.getContacto().getDireccion().getNomCatLocalidad().getCatLocalidadId() != null) {
						direcc.setNomCatLocalidadId(dto.getContacto().getDireccion().getNomCatLocalidad().getCatLocalidadId());
					}

					if (dto.getContacto().getDireccion().getNomCatCodigoPostal() != null && dto.getContacto().getDireccion().getNomCatCodigoPostal().getCatCodigoPostalId() != null) {
						direcc.setNomCatCodigoPostalId(dto.getContacto().getDireccion().getNomCatCodigoPostal().getCatCodigoPostalId());
					}

					if (dto.getContacto().getDireccion().getCatTipoAsen() != null && dto.getContacto().getDireccion().getCatTipoAsen().getTipoAsenId() != null) {
						direcc.setCatTipoAsenId(dto.getContacto().getDireccion().getCatTipoAsen().getTipoAsenId());
					}

					if (dto.getContacto().getDireccion().getNomCatPaises() != null && dto.getContacto().getDireccion().getNomCatPaises().getPaisId() != null) {
						direcc.setNomCatPaisesId(dto.getContacto().getDireccion().getNomCatPaises().getPaisId());
					}

					if (dto.getContacto().getDireccion().getCatVialidad() != null && dto.getContacto().getDireccion().getCatVialidad().getVialidadId() != null) {
						direcc.setCatVialidadId(dto.getContacto().getDireccion().getCatVialidad().getVialidadId());
					}

					direcc.setCalle(dto.getContacto().getDireccion().getCalle());
					direcc.setNoExt(dto.getContacto().getDireccion().getNoExt());
					direcc.setNoExtLetra(dto.getContacto().getDireccion().getNoExtLetra());
					direcc.setNoInt(dto.getContacto().getDireccion().getNoInt());
					direcc.setNoIntLetra(dto.getContacto().getDireccion().getNoIntLetra());
					direcc.setNombreVialidad(dto.getContacto().getDireccion().getNombreVialidad());
					direcc.setNombreAsentamiento(dto.getContacto().getDireccion().getNombreAsentamiento());

					if (actualizarEntidad(direcc) == 0) {
						return 0;
					}

					exito = direcc.getDireccionId();

					logger.info("##################  invocando a DAO PacienteDAOImpl modifica Direccion " + direcc.getDireccionId() + " ##################");
				}
			}

			return exito;
		} catch (Exception e) {
			logger.info("########### Ocurrio un error al guardar los datos del Contacto ", e);

			exito = 0;
			return exito;
		}
	}

	@Override
	public int eliminaContactoPaciente(ContactoDTO dto) {
		int exito;
		try {
			logger.info("##################  invocando a DAO PacienteDAOImpl eliminaContactoPaciente Contacto ##################");

			Contacto contact = get(Contacto.class, dto.getContactoId());

			contact.setStatus(0);

			//this.merge(contact);
			//this.flush();
			actualizarEntidad(contact);

			exito = contact.getContactoId();
			logger.info("##################  invocando a DAO PacienteDAOImpl eliminaContactoPaciente Contacto " + exito + " ##################");
		} catch (Exception e) {
			logger.info("########### Ocurrio un error al eliminar al Contacto ", e);

			exito = 0;
			return exito;
		}
		return exito;
	}
	
	@Override
	public List<PacienteDTO> ListaBusquedaPaciente(PacienteDTO dto) {
		List<PacienteDTO> lista;
		Integer idRol = Integer.valueOf(new SecurityUtil().getRole(SecurityContextHolder.getContext().getAuthentication().getName()));
		AdmHospital hospital = hospitalDAO.obtenerIdHospital(idRol);

		try {
			Integer bandera = 0;
			// language=MySQL
			String QRY_ACCESO_PACIENTE = "" +
					"SELECT " +
					"	paciente.ID_PACIENTE AS idPaciente, " +
					"	expediente.EXPEDIENTE_ID AS expedienteId, " +
					"	CONCAT('PAC_' , paciente.ID_PACIENTE) AS noPaciente, " +
					"	IFNULL(expediente.NO_EXPEDIENTE, 'SIN EXPEDIENTE') AS noExpediente, " +
					"	paciente.NOMBRE AS nombre, " +
					"	paciente.PRIMER_APELLIDO AS primerApellido, " +
					"	paciente.SEGUNDO_APELLIDO AS segundoApellido, " +
					"	paciente.FECHA_NACIMIENTO AS fechaNacimiento, " +
					"	paciente.FECHA_ESTIMADA AS fechaEstimada, " +
					"	paciente.CURP AS curp, " +
					"	paciente.SEXO_ID AS sexoId, " +
					"	paciente.FALLECIDO AS fallecido, " +
					"	paciente.FOTO_PACIENTE AS fotoPaciente, " +
					"	expediente.TIPO_EXPEDIENTE_ID AS tipoExpedienteId, " +
					"	tipoExp.NOMBRE AS tipoExpediente, " +
					"	duplicado.ID_DUPLICADO AS Duplicado,  " +
					"	HSP.HOSPITAL_ID AS hospitalId, " +
					"   HSP.NOMBRE AS hospital " +
					"FROM pac_paciente paciente " +
					"	LEFT JOIN pac_expediente expediente ON paciente.ID_PACIENTE = expediente.PACIENTE_ID AND expediente.HOSPITAL_ID = :pHospitalId " +
					"	LEFT JOIN pac_paciente_duplicado duplicado ON paciente.ID_PACIENTE = duplicado.ID_PACIENTE AND duplicado.FUSION_ID_PACIENTE IS NULL " +
					"	LEFT JOIN cat_tipo_expediente tipoExp ON tipoExp.TIPO_EXPEDIENTE_ID = expediente.TIPO_EXPEDIENTE_ID " +
					"	LEFT JOIN adm_hospital HSP ON expediente.HOSPITAL_ID = HSP.HOSPITAL_ID " +
					"WHERE paciente.ESTATUS = 1 AND ";

			if (dto.getNombre() != null && !"".equals(dto.getNombre())) {
				QRY_ACCESO_PACIENTE = QRY_ACCESO_PACIENTE + " UPPER(paciente.NOMBRE) LIKE :pNombre ";
				bandera = 1;
			}

			if (dto.getPrimerApellido() != null && !"".equals(dto.getPrimerApellido())) {
				if (bandera == 0) {
					QRY_ACCESO_PACIENTE = QRY_ACCESO_PACIENTE + " UPPER(paciente.PRIMER_APELLIDO) LIKE :pPAp ";
					bandera = 1;
				} else {
					QRY_ACCESO_PACIENTE = QRY_ACCESO_PACIENTE + " AND UPPER(paciente.PRIMER_APELLIDO) LIKE :pPAp ";
				}
			}

			if (dto.getSegundoApellido() != null && !"".equals(dto.getSegundoApellido())) {
				if (bandera == 0) {
					QRY_ACCESO_PACIENTE = QRY_ACCESO_PACIENTE + " UPPER(paciente.SEGUNDO_APELLIDO) LIKE :pPAm ";
				} else {
					QRY_ACCESO_PACIENTE = QRY_ACCESO_PACIENTE + " AND UPPER(paciente.SEGUNDO_APELLIDO) LIKE :pPAm ";
				}
			}

			if (dto.getNoExpediente() != null && !"".equals(dto.getNoExpediente())) {
				QRY_ACCESO_PACIENTE = QRY_ACCESO_PACIENTE + " UPPER (expediente.NO_EXPEDIENTE) LIKE :pEXp ";
			}

			if (dto.getCurp() != null && !"".equals(dto.getCurp())) {
				QRY_ACCESO_PACIENTE = QRY_ACCESO_PACIENTE + " UPPER(paciente.CURP) LIKE :pCURPp ";
			}

			QRY_ACCESO_PACIENTE = QRY_ACCESO_PACIENTE + " ORDER BY paciente.NOMBRE ";

			Session s = getCurrentSession();
			Query query = s.createSQLQuery(QRY_ACCESO_PACIENTE)
					.addScalar("idPaciente", StandardBasicTypes.INTEGER)
					.addScalar("noPaciente", StandardBasicTypes.STRING)
					.addScalar("noExpediente", StandardBasicTypes.STRING)
					.addScalar("nombre", StandardBasicTypes.STRING)
					.addScalar("primerApellido", StandardBasicTypes.STRING)
					.addScalar("segundoApellido", StandardBasicTypes.STRING)
					.addScalar("fechaNacimiento", StandardBasicTypes.TIMESTAMP)
					.addScalar("fechaEstimada", StandardBasicTypes.INTEGER)
					.addScalar("curp", StandardBasicTypes.STRING)
					.addScalar("sexoId", StandardBasicTypes.INTEGER)
					.addScalar("fallecido", StandardBasicTypes.INTEGER)
					.addScalar("tipoExpedienteId", StandardBasicTypes.INTEGER)
					.addScalar("tipoExpediente", StandardBasicTypes.STRING)
					.addScalar("Duplicado", StandardBasicTypes.INTEGER)
					.addScalar("hospitalId", StandardBasicTypes.INTEGER)
					.addScalar("hospital", StandardBasicTypes.STRING)
					.addScalar("fotoPaciente", StandardBasicTypes.STRING)
					.addScalar("expedienteId", StandardBasicTypes.INTEGER);

			if (dto.getNombre() != null && !"".equals(dto.getNombre())) {
				query.setParameter("pNombre", "%" + dto.getNombre().toUpperCase() + "%");
			}

			if (dto.getPrimerApellido() != null && !"".equals(dto.getPrimerApellido())) {
				query.setParameter("pPAp", "%" + dto.getPrimerApellido().toUpperCase() + "%");
			}

			if (dto.getSegundoApellido() != null && !"".equals(dto.getSegundoApellido())) {
				query.setParameter("pPAm", "%" + dto.getSegundoApellido().toUpperCase() + "%");
			}

			if (dto.getNoExpediente() != null && !"".equals(dto.getNoExpediente())) {
				query.setParameter("pEXp", "%" + dto.getNoExpediente().toUpperCase() + "%");
			}

			if (dto.getCurp() != null && !"".equals(dto.getCurp())) {
				query.setParameter("pCURPp", "%" + dto.getCurp().toUpperCase() + "%");
			}

			query.setParameter("pHospitalId", hospital.getHospitalId());
			query.setResultTransformer(Transformers.aliasToBean(PacienteDTO.class));
			
			lista = query.list();
			s.close();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al guardar listaProfesionalSalud ", e);
		}

		return lista;
	}
	
	@Override
	public List<Integer> obtenerEventoAcitivoPaciente(Integer pacienteId) {
		Session s = getCurrentSession();
		Query query = s.createSQLQuery("" +
				"SELECT  evento.EVENTO_ID from pac_evento evento " +
				" WHERE evento.FECHA_CIERRE IS NULL  " +
				" AND evento.ID_PACIENTE = :pacienteId " +
				" ORDER BY evento.FECHA_APERTURA DESC"
		).setParameter("pacienteId", pacienteId);
		var r = query.list();
		s.close(); 
		return r;
	}
	
	@Override
	@Transactional
	public PacAseguradoraDTO obtenerAseguradoraByPaciente(Integer pacienteId, Integer hospitalId) {
		Session s = getCurrentSession();
		Query query = s.createSQLQuery("" +

				"SELECT " +
				"aseguradora.PAC_ASEGURADORA_ID                 AS pacAseguradoraId, " +
				"pacConvenioAseguradora.CONVENIO_ASEGURADORA_ID AS convenioAseguradoraId, " +
				"aseguradora.PRIORIDAD                          AS prioridad, " +
				"aseguradora.FECHA_INICIA                       AS fechaInicia, " +
				"aseguradora.FECHA_FIN                          AS fechaFin, " +
				"admCatAseguradora.NOMBRE                       AS catAseguradoraNombre, " +
				"admCatAseguradora.CVE                          AS catAseguradoraCve, " +
				"pacConvenioAseguradora.NOMBRE                  AS convenioAseguradoraNombre " +
				"FROM pac_aseguradora aseguradora " +
				"INNER JOIN pac_paciente pacPaciente ON aseguradora.ID_PACIENTE = pacPaciente.ID_PACIENTE " +
				"INNER JOIN pac_convenio_aseguradora pacConvenioAseguradora ON aseguradora.CONVENIO_ASEGURADORA_ID = pacConvenioAseguradora.CONVENIO_ASEGURADORA_ID " +
				//"INNER JOIN core_aseguradora_hospital coreAseguradoraHospital ON pacConvenioAseguradora.ASEGURADORA_HOSPITAL_ID = coreAseguradoraHospital.ASEGURADORA_HOSPITAL_ID " +
				//"INNER JOIN adm_cat_aseguradora admCatAseguradora ON aseguradora.ASEGURADORA_ID = admCatAseguradora.ASEGURADORA_ID AND coreAseguradoraHospital.ASEGURADORA_ID = admCatAseguradora.ASEGURADORA_ID " +
				"WHERE pacPaciente.ID_PACIENTE = :pPacienteId" +
				"ORDER BY aseguradora.PRIORIDAD ASC " +
				"LIMIT 1"
		)

				.addScalar("pacAseguradoraId", StandardBasicTypes.INTEGER)
				.addScalar("convenioAseguradoraId", StandardBasicTypes.INTEGER)
				.addScalar("prioridad", StandardBasicTypes.INTEGER)
				.addScalar("fechaInicia", StandardBasicTypes.TIMESTAMP)
				.addScalar("fechaFin", StandardBasicTypes.TIMESTAMP)
				.addScalar("catAseguradoraNombre", StandardBasicTypes.STRING)
				.addScalar("catAseguradoraCve", StandardBasicTypes.STRING)
				.addScalar("convenioAseguradoraNombre", StandardBasicTypes.STRING)

				.setParameter("pPacienteId", pacienteId)
//				.setParameter("pHospitalId", hospitalId)

				.setResultTransformer(Transformers.aliasToBean(PacAseguradoraDTO.class));

		var r = (PacAseguradoraDTO) query.uniqueResult();
		s.close(); 
		return r;
	}
	
	@Override
	public PacienteDuplicadoDatosDTO consultarDatosPacienteQR(int idPaciente) {
		//Integer idRol = Integer.valueOf(new SecurityUtil().getRole(SecurityContextHolder.getContext().getAuthentication().getName()));
		//AdmHospital hospital = hospitalDAO.obtenerIdHospital(idRol);

		String QRY_DATOS_PACIENTE = QRY_DATOS_PACIENTE_QR + " WHERE pac.ID_PACIENTE = :pIdPaciente ";

		Session s = getCurrentSession();
		Query query = s.createSQLQuery(QRY_DATOS_PACIENTE)
				.addScalar("idPaciente", StandardBasicTypes.INTEGER)
				.addScalar("noPaciente", StandardBasicTypes.STRING)
				.addScalar("nombre", StandardBasicTypes.STRING)
				.addScalar("primerApellido", StandardBasicTypes.STRING)
				.addScalar("segundoApellido", StandardBasicTypes.STRING)
				.addScalar("fechaNacimiento", StandardBasicTypes.TIMESTAMP)
				.addScalar("curp", StandardBasicTypes.STRING)
				.addScalar("fechaRegistro", StandardBasicTypes.TIMESTAMP)
				.addScalar("nacionalidad", StandardBasicTypes.STRING)
				.addScalar("nacionalidad_id", StandardBasicTypes.INTEGER)
				.addScalar("entidadNacimiento", StandardBasicTypes.STRING)
				.addScalar("entidadNacimiento_id", StandardBasicTypes.INTEGER)
				.addScalar("entidadNacimiento_cve", StandardBasicTypes.STRING)
				.addScalar("municipioNacimiento", StandardBasicTypes.STRING)
				.addScalar("municipioNacimiento_id", StandardBasicTypes.INTEGER)
				.addScalar("municipioNacimiento_cve", StandardBasicTypes.STRING)
				.addScalar("peso", StandardBasicTypes.FLOAT)
				.addScalar("talla", StandardBasicTypes.FLOAT)
				.addScalar("sexo", StandardBasicTypes.STRING)
				.addScalar("sexo_id", StandardBasicTypes.INTEGER)
				.addScalar("religion", StandardBasicTypes.STRING)
				.addScalar("religion_id", StandardBasicTypes.STRING)
				.addScalar("fallecido", StandardBasicTypes.INTEGER)
				.addScalar("tipoSangre", StandardBasicTypes.STRING)
				.addScalar("tipoSangre_id", StandardBasicTypes.INTEGER)
				.addScalar("procedencia", StandardBasicTypes.STRING)
				.addScalar("procedencia_id", StandardBasicTypes.INTEGER)
				.addScalar("estadoCivil", StandardBasicTypes.STRING)
				.addScalar("estadoCivil_id", StandardBasicTypes.INTEGER)
				.addScalar("escolaridad", StandardBasicTypes.STRING)
				.addScalar("escolaridad_id", StandardBasicTypes.INTEGER)
				.addScalar("indigena", StandardBasicTypes.STRING)
				.addScalar("indigena_id", StandardBasicTypes.INTEGER)
				.addScalar("hablaIndigena", StandardBasicTypes.STRING)
				.addScalar("hablaIndigena_id", StandardBasicTypes.INTEGER)
				.addScalar("hablaEspanol", StandardBasicTypes.STRING)
				.addScalar("hablaEspanol_id", StandardBasicTypes.INTEGER)
				.addScalar("trabajaActualmente", StandardBasicTypes.STRING)
				.addScalar("trabajaActualmente_id", StandardBasicTypes.INTEGER)
				.addScalar("tipoLenguaIndigena", StandardBasicTypes.STRING)
				.addScalar("tipoLenguaIndigena_id", StandardBasicTypes.INTEGER)
				.addScalar("ocupacion", StandardBasicTypes.STRING)
				.addScalar("ocupacion_id", StandardBasicTypes.INTEGER)
				.addScalar("noExpediente", StandardBasicTypes.STRING)
				.addScalar("tipoExpediente", StandardBasicTypes.STRING)
				.addScalar("tipoExpediente_id", StandardBasicTypes.INTEGER)
				.addScalar("servicioEspRegistro", StandardBasicTypes.STRING)
				.addScalar("paciente", StandardBasicTypes.STRING)
				.addScalar("fotoPaciente", StandardBasicTypes.STRING)
				.addScalar("servicioEspRegistro_id", StandardBasicTypes.INTEGER);

		query.setParameter("pIdPaciente", idPaciente);
		//query.setParameter("pHospitalId", hospital.getHospitalId());
		query.setResultTransformer(Transformers.aliasToBean(PacienteDuplicadoDatosDTO.class));

		var r =(PacienteDuplicadoDatosDTO) query.uniqueResult();
		s.close();
		return r;
	}
	
	@Override
	public PacienteDuplicadoDatosDTO consultarDatosPacienteCURP(int idPaciente) {
		//Integer idRol = Integer.valueOf(new SecurityUtil().getRole(SecurityContextHolder.getContext().getAuthentication().getName()));
		//AdmHospital hospital = hospitalDAO.obtenerIdHospital(idRol);

		String QRY_DATOS_PACIENTE = QRY_PAC_CURP + " WHERE pac.ID_PACIENTE = :pIdPaciente ";

		Session s = getCurrentSession();
		Query query = s.createSQLQuery(QRY_DATOS_PACIENTE)
				.addScalar("idPaciente", StandardBasicTypes.INTEGER)
				.addScalar("curp", StandardBasicTypes.STRING);


		query.setParameter("pIdPaciente", idPaciente);
		query.setResultTransformer(Transformers.aliasToBean(PacienteDuplicadoDatosDTO.class));

		var r=(PacienteDuplicadoDatosDTO) query.uniqueResult();
		s.close();
		return r;
	}
	
	@Override
	public int validaExistenciaCurp(final CurpRequest curp) {

		int existe = 0;
		logger.info("########### invocando a DAO PacienteDAOImpl Ocurrio un validaExistenciaCurp ");

		logger.info("		Buscando curp:"+curp.getCurp());
		
		try {

			if (curp == null || "".compareTo(curp.getCurp())==0) {
				return existe;
			}

			Session s = getCurrentSession();
			for (PacPaciente paciente : (List<PacPaciente>) s.createCriteria(PacPaciente.class).list()) {
								
				if(paciente.getCurp() != null ) {
					//logger.info("************* "+paciente.getCurp());
					if (paciente.getCurp().compareTo(curp.getCurp())==0) {						
						existe = 1;
						logger.info("*************EXISTE= 1 ");
						break;
					}
				}
			}
			s.close();
		} catch (Exception e) {
			logger.info("########### Ocurrio un error al validar la existencia del Curp del Contacto ", e);

			existe = 0;
			return existe;
		}
		logger.info("*************EXISTE= "+existe);
		return existe;
	}

	@Override
	public Integer consultaIdPacientePorExpediente(String expediente) {
		try {
			String QRY_CONSULTA_ID_PACIENTE_POR_EXPEDIENTE = "SELECT PACIENTE_ID FROM pac_expediente "
					+ "WHERE NO_EXPEDIENTE = :expediente";

			Session s = getCurrentSession();
			Query query = s.createSQLQuery(QRY_CONSULTA_ID_PACIENTE_POR_EXPEDIENTE);
			query.setParameter("expediente", expediente);

			var r = (Integer) query.getSingleResult();

			s.close();
			return r;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<DomicilioDTO> consultaDomiciliosPaciente(Integer idPaciente) {

		Session s = getCurrentSession();
		
		Query query = s.createSQLQuery("" +
				"SELECT D.DIRECCION_ID AS direccionId, D.CALLE as calle, D.NO_EXT as noExt, D.NO_EXT_LETRA as noExtLetra, D.NO_INT as noInt, D.NO_INT_LETRA as noIntLetra, \r\n"
				+ "D.NOMBRE_VIALIDAD as nombreVialidad, D.NOMBRE_ASENTAMIENTO as nombreAsentamiento,\r\n"
				+ "D.ESTADO_ID as entidadId, D.MUNICIPIO_ID as municipioId, D.LOCALIDAD_ID as localidadId, D.CODIGO_POSTAL_ID as codigoPostalId, D.VIALIDAD_ID as vialidadId, D.TIPO_ASEN_ID as tipoAsenId, \r\n"
				+ "D.ESTATUS as status,D.FECHA_REGISTRO as fechaRegistro, D.CVE as cve, D.BAN_DOMICILIO_ALTERNATIVO as isDomicilioAlternativo, \r\n"
				+ "EN.CVE as entidadCve, MN.CVE_ENT as cveEnt, MN.CVE_MUN as cveMun "
				+ "FROM direccion D INNER JOIN agente_direccion AD ON D.DIRECCION_ID=AD.DIRECCION_ID \r\n"
				+ "INNER JOIN nom_cat_entidades EN ON EN.CAT_ENTIDADES_ID=D.ESTADO_ID "
				+ "INNER JOIN nom_cat_municipio MN ON MN.CAT_MUNICIPIO_ID=D.MUNICIPIO_ID "
				+ "WHERE AD.AGENTE_ID=:pacienteId ; "
		).setParameter("pacienteId", idPaciente);
		
		query.setResultTransformer(Transformers.aliasToBean(DomicilioDTO.class));
		var r = query.list();
		s.close(); 
		return r;
	}

	@Override
	public Integer consultaIdPacientePorBiometricos(String token) {
		String QRY_CONSULTA_ID_PACIENTE_POR_EXPEDIENTE 
			= "SELECT ID_PACIENTE FROM pac_biometricos_paciente "
			+ "WHERE TOKEN_BIOMETRICO = :tokenBiometrico";
	
	Session s = getCurrentSession();
	Query query = s.createSQLQuery(QRY_CONSULTA_ID_PACIENTE_POR_EXPEDIENTE);
	query.setParameter("tokenBiometrico", token);
	
	var r = (Integer) query.getSingleResult();
	s.close();
	return r;
	}
	
}
