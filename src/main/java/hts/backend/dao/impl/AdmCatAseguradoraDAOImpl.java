package hts.backend.dao.impl;

import hts.backend.dao.AliasToBeanNestedResultTransformer;
import hts.backend.dao.AdmCatAseguradoraDAO;
import hts.backend.model.dto.AdmCatAseguradoraDTO;
import hts.backend.model.dto.AgenteDireccionDTO;
import hts.backend.model.dto.DireccionDTO;
import hts.backend.entity.AdmCatAseguradora;
import hts.backend.entity.CatTipoAseguradora;
import hts.backend.entity.NomCatMonedas;
import hts.backend.entity.AgenteDireccion;
import hts.backend.entity.Direccion;
import hts.backend.utils.Constantes;
import org.springframework.beans.BeanUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;


@Repository("admCatAseguradoraDAO")
public class AdmCatAseguradoraDAOImpl extends BaseDAOImpl implements AdmCatAseguradoraDAO {

	private static final Logger logger = LoggerFactory.getLogger(AdmCatAseguradoraDAOImpl.class);


	@Override
	@Transactional
	public List<AdmCatAseguradoraDTO> listaCatAseguradora() {
		List<AdmCatAseguradoraDTO> lista;

		Criteria aseguradora = session().createCriteria(AdmCatAseguradora.class, "catAseguradora").setProjection(Projections
				.projectionList()
				.add(Projections.property("catAseguradora.aseguradoraId"), "aseguradoraId")
				.add(Projections.property("catAseguradora.cve"), "cve")
				.add(Projections.property("catAseguradora.nombre"), "nombre")
				.add(Projections.property("catAseguradora.descripcion"), "descripcion")
				.add(Projections.property("catAseguradora.telefono"), "telefono")
				.add(Projections.property("catAseguradora.fiscalId"), "fiscalId")
				.add(Projections.property("catAseguradora.deudor"), "deudor")
				.add(Projections.property("catAseguradora.cuentaAsociada"), "cuentaAsociada")
				.add(Projections.property("catAseguradora.valorDefault"), "valorDefault")
				.add(Projections.property("catAseguradora.fechaRegistra"), "fechaRegistra")
				.add(Projections.property("catAseguradora.usuarioRegistro"), "usuarioRegistro")
				.add(Projections.property("catAseguradora.estatus"), "estatus")
				.add(Projections.property("cTipoAseguradora.tipoAseguradoraId"), "tipoAseguradoraId")
				.add(Projections.property("cTipoAseguradora.nombre"), "nomTipoAseguradora")
				.add(Projections.property("cClasFiscal.clasificacionFiscalId"), "clasificacionFiscalId")
				.add(Projections.property("cClasFiscal.nombre"), "nomClasFiscal")
				.add(Projections.property("cTipoMoneda.monedasId"), "tipoMonedaId")
				.add(Projections.property("cTipoMoneda.descripcion"), "nomTipoMoneda")
		);

		aseguradora.createAlias("catAseguradora.catTipoAseguradora", "cTipoAseguradora", JoinType.LEFT_OUTER_JOIN);
		aseguradora.createAlias("catAseguradora.catClasificacionFiscal", "cClasFiscal", JoinType.LEFT_OUTER_JOIN);
		aseguradora.createAlias("catAseguradora.nomCatTipoMonedac", "cTipoMoneda", JoinType.LEFT_OUTER_JOIN);

		aseguradora.addOrder(Order.asc("catAseguradora.aseguradoraId"));

		//aseguradora.add(Restrictions.ne("catAseguradora.aseguradoraId", 0));
		aseguradora.setResultTransformer(Transformers.aliasToBean(AdmCatAseguradoraDTO.class));

		lista = aseguradora.list();

		return lista;
	}

	@Override
	@Transactional
	public AdmCatAseguradoraDTO direccionAseguradora(Integer aseguradoraId) {
		// language=MySQL
		String QRY_ASEGURADORAS_DIRECCION = "" +
				"SELECT " +
				"IFNULL(direccion.NOMBRE_ASENTAMIENTO, 'N/A') AS asentamiento, " +
				"IFNULL(asen.NOMBRE, 'N/A')                   AS tipoAsen, " +
				"IFNULL(vial.NOMBRE, 'N/A')                   AS tipoVial, " +
				"IFNULL(direccion.NOMBRE_VIALIDAD, 'N/A')     AS vialidad, " +
				"IFNULL(pais.DESCRIPCION, 'N/A')              AS pais, " +
				"IFNULL(entidades.NOMBRE, 'N/A')              AS entidad, " +
				"IFNULL(localidad.DESCRIPCION, 'N/A')         AS localidad, " +
				"IFNULL(municipio.DESCRIPCION, 'N/A')         AS municipio, " +
				"IFNULL(cp.NOMBRE, 'N/A')                     AS cp, " +
				"IFNULL(direccion.CALLE, 'N/A')               AS calle " +
				"FROM adm_cat_aseguradora aseguradora " +
				"LEFT JOIN agente_direccion agtDir ON aseguradora.ASEGURADORA_ID = agtDir.AGENTE_ID AND agtDir.TIPO_AGENTE_ID = 4 " +
				"LEFT JOIN direccion direccion ON agtDir.DIRECCION_ID = direccion.DIRECCION_ID " +
				"LEFT JOIN nom_cat_paises pais ON direccion.PAIS_ID = pais.PAIS_ID " +
				"LEFT JOIN nom_cat_entidades entidades ON direccion.ESTADO_ID = entidades.CAT_ENTIDADES_ID " +
				"LEFT JOIN nom_cat_localidad localidad ON direccion.LOCALIDAD_ID = localidad.CAT_LOCALIDAD_ID " +
				"LEFT JOIN nom_cat_municipio municipio ON direccion.MUNICIPIO_ID = municipio.CAT_MUNICIPIO_ID " +
				"LEFT JOIN nom_cat_codigo_postal cp ON direccion.CODIGO_POSTAL_ID = cp.CAT_CODIGO_POSTAL_ID " +
				"LEFT JOIN cat_vialidad vial ON direccion.VIALIDAD_ID = vial.VIALIDAD_ID " +
				"LEFT JOIN cat_tipo_asen asen ON direccion.TIPO_ASEN_ID = asen.TIPO_ASEN_ID " +
				"WHERE aseguradora.ASEGURADORA_ID = :pAseguradoraId";

		Query query = session().createSQLQuery(QRY_ASEGURADORAS_DIRECCION)
				.addScalar("asentamiento", StandardBasicTypes.STRING)
				.addScalar("tipoAsen", StandardBasicTypes.STRING)
				.addScalar("tipoVial", StandardBasicTypes.STRING)
				.addScalar("vialidad", StandardBasicTypes.STRING)
				.addScalar("pais", StandardBasicTypes.STRING)
				.addScalar("entidad", StandardBasicTypes.STRING)
				.addScalar("localidad", StandardBasicTypes.STRING)
				.addScalar("municipio", StandardBasicTypes.STRING)
				.addScalar("cp", StandardBasicTypes.STRING)
				.addScalar("calle", StandardBasicTypes.STRING);

		query.setParameter("pAseguradoraId", aseguradoraId);

		query.setResultTransformer(Transformers.aliasToBean(AdmCatAseguradoraDTO.class));

		return (AdmCatAseguradoraDTO) query.uniqueResult();

	}

	@Override
	@Transactional
	public List<AdmCatAseguradoraDTO> listaCatAseguradoraPorHospital(Integer hospitalId) {
		// language=MySQL
		String QRY_ASEGURADORAS_HOSPITAL = "" +
				"SELECT " +
				"asegHosp.ASEGURADORA_HOSPITAL_ID          AS asegHospId, " +
				"aseguradora.ASEGURADORA_ID                AS aseguradoraId, " +
				"aseguradora.CVE                           AS cve, " +
				"aseguradora.NOMBRE                        AS nombre, " +
				"aseguradora.DESCRIPCION                   AS descripcion, " +
				"aseguradora.FISCAL_ID                     AS fiscalId, " +
				"tipo.NOMBRE                               AS nomTipoAseguradora, " +
				"tipo.TIPO_ASEGURADORA_ID                  AS tipoAseguradoraId, " +
				"IFNULL(direccion.NOMBRE_ASENTAMIENTO, 'N/A') AS asentamiento, " +
				"IFNULL(asen.NOMBRE, 'N/A')                   AS tipoAsen, " +
				"IFNULL(vial.NOMBRE, 'N/A')                   AS tipoVial, " +
				"IFNULL(direccion.NOMBRE_VIALIDAD, 'N/A')     AS vialidad, " +
				"IFNULL(pais.DESCRIPCION, 'N/A')              AS pais, " +
				"IFNULL(entidades.DESCRIPCION, 'N/A')              AS entidad, " +
				"IFNULL(localidad.DESCRIPCION, 'N/A')         AS localidad, " +
				"IFNULL(municipio.DESCRIPCION, 'N/A')         AS municipio, " +
				"IFNULL(cp.NOMBRE, 'N/A')                     AS cp, " +
				"IFNULL(direccion.CALLE, 'N/A')               AS calle " +
				"FROM adm_cat_aseguradora aseguradora " +
				"LEFT JOIN cat_tipo_aseguradora tipo ON aseguradora.TIPO_ASEGURADORA_ID = tipo.TIPO_ASEGURADORA_ID " +
				"LEFT JOIN agente_direccion agtDir ON aseguradora.ASEGURADORA_ID = agtDir.AGENTE_ID AND agtDir.TIPO_AGENTE_ID = 4 " +
				"LEFT JOIN direccion direccion ON agtDir.DIRECCION_ID = direccion.DIRECCION_ID " +
				"LEFT JOIN nom_cat_paises pais ON direccion.PAIS_ID = pais.PAIS_ID " +
				"LEFT JOIN nom_cat_entidades entidades ON direccion.ESTADO_ID = entidades.CAT_ENTIDADES_ID " +
				"LEFT JOIN nom_cat_localidad localidad ON direccion.LOCALIDAD_ID = localidad.CAT_LOCALIDAD_ID " +
				"LEFT JOIN nom_cat_municipio municipio ON direccion.MUNICIPIO_ID = municipio.CAT_MUNICIPIO_ID " +
				"LEFT JOIN nom_cat_codigo_postal cp ON direccion.CODIGO_POSTAL_ID = cp.CAT_CODIGO_POSTAL_ID " +
				"LEFT JOIN cat_vialidad vial ON direccion.VIALIDAD_ID = vial.VIALIDAD_ID " +
				"LEFT JOIN cat_tipo_asen asen ON direccion.TIPO_ASEN_ID = asen.TIPO_ASEN_ID " +
				"LEFT JOIN core_aseguradora_hospital asegHosp ON aseguradora.ASEGURADORA_ID = asegHosp.ASEGURADORA_ID " +
				"WHERE aseguradora.ESTATUS = 1 AND asegHosp.ESTATUS = 1 AND asegHosp.HOSPITAL_ID = :pHospitalId";

		Query query = session().createSQLQuery(QRY_ASEGURADORAS_HOSPITAL)
				.addScalar("aseguradoraId", StandardBasicTypes.INTEGER)
				.addScalar("asegHospId", StandardBasicTypes.INTEGER)
				.addScalar("cve", StandardBasicTypes.STRING)
				.addScalar("nombre", StandardBasicTypes.STRING)
				.addScalar("descripcion", StandardBasicTypes.STRING)
				.addScalar("fiscalId", StandardBasicTypes.STRING)
				.addScalar("nomTipoAseguradora", StandardBasicTypes.STRING)
				.addScalar("asentamiento", StandardBasicTypes.STRING)
				.addScalar("tipoAsen", StandardBasicTypes.STRING)
				.addScalar("tipoVial", StandardBasicTypes.STRING)
				.addScalar("vialidad", StandardBasicTypes.STRING)
				.addScalar("pais", StandardBasicTypes.STRING)
				.addScalar("entidad", StandardBasicTypes.STRING)
				.addScalar("localidad", StandardBasicTypes.STRING)
				.addScalar("municipio", StandardBasicTypes.STRING)
				.addScalar("cp", StandardBasicTypes.STRING)
				.addScalar("calle", StandardBasicTypes.STRING)
				.addScalar("tipoAseguradoraId", StandardBasicTypes.INTEGER);

		query.setParameter("pHospitalId", hospitalId);

		query.setResultTransformer(Transformers.aliasToBean(AdmCatAseguradoraDTO.class));

		return query.list();
	}


	@Override
	@Transactional
	public int altaAseguradora(AdmCatAseguradora cAseguradora) throws IllegalAccessException, InvocationTargetException {
		int exito = 0;
		try {
			this.save(cAseguradora);
			this.flush();
			exito = cAseguradora.getAseguradoraId();
			logger.info("id----> ", exito);
		} catch (Exception e) {
			exito = 0;
			logger.info("----> ", e);
		}

		return exito;

	}


	@Override
	@Transactional
	public CatTipoAseguradora tipoAseguradoraById(Integer tipoAseguradoraId) {
		Criteria unidad = session().createCriteria(CatTipoAseguradora.class);
		unidad.add(Restrictions.eq("tipoAseguradoraId", tipoAseguradoraId));

		CatTipoAseguradora tmp = (CatTipoAseguradora) unidad.uniqueResult();
		return (CatTipoAseguradora) unidad.uniqueResult();
	}


	@Override
	@Transactional
	public NomCatMonedas tipoMonedaById(Integer tipoMonedaId) {
		Criteria unidad = session().createCriteria(NomCatMonedas.class);
		unidad.add(Restrictions.eq("monedasId", tipoMonedaId));


		NomCatMonedas tmp = (NomCatMonedas) unidad.uniqueResult();
		return (NomCatMonedas) unidad.uniqueResult();
	}


	@Override
	@Transactional
	public int modificarAseguradora(AdmCatAseguradora cAseguradora) throws IllegalAccessException, InvocationTargetException {
		int exito = 0;
		try {
			Criteria ct = session().createCriteria(AdmCatAseguradora.class);
			ct.add(Restrictions.eq("aseguradoraId", cAseguradora.getAseguradoraId()));

			AdmCatAseguradora entidad = (AdmCatAseguradora) ct.uniqueResult();
			BeanUtils.copyProperties(entidad, cAseguradora);
			this.merge(entidad);
			this.flush();
			exito = entidad.getAseguradoraId();
			logger.info("-------> se modificó aseguradora --- ", exito);

		} catch (Exception e) {
			logger.info("########### Ocurrio un error al actualizar aseguradora", e);
			exito = 0;
		}
		return exito;
	}


	@Override
	@Transactional
	public int eliminarAseguradora(AdmCatAseguradoraDTO dto) {
		int exito = 0;
		try {
			Criteria ct = session().createCriteria(AdmCatAseguradora.class);
			ct.add(Restrictions.eq("aseguradoraId", dto.getAseguradoraId()));
			AdmCatAseguradora entidad = (AdmCatAseguradora) ct.uniqueResult();
			this.delete(entidad);
			this.flush();
			exito = 1;
			logger.info("########### SE ELIMINÓ DE FORMA CORRECTA aseguradora");
		} catch (Exception e) {
			exito = 0;
			logger.info("########### Ocurrio un error al borrar aseguradora", e);
			//Logger.info('error',e);
		}
		return exito;
	}



	/*--------------------------------------------------------------------------
	 * ---------------------- DIRECCIONES --------------------------------------
	 * -------------------------------------------------------------------------*/

	@Override
	@Transactional
	public int altaDireccion(AgenteDireccionDTO dto) {
		logger.info("---------  invocando a DAO  altaDireccion -----------");
		int exito = 0;
		try {

			Direccion entidad = new Direccion();

			// Entidad
			if (dto.getDireccion().getNomCatEntidades().getCatEntidadesId() == null) {
				entidad.setNomCatEntidadesId(null);
			} else {
				entidad.setNomCatEntidadesId(dto.getDireccion().getNomCatEntidades().getCatEntidadesId());
			}

			// Municipio
			if (dto.getDireccion().getNomCatMunicipio().getCatMunicipioId() == null) {
				entidad.setNomCatMunicipioId(null);
			} else {
				entidad.setNomCatMunicipioId(dto.getDireccion().getNomCatMunicipio().getCatMunicipioId());
			}

			// Localidad
			if (dto.getDireccion().getNomCatLocalidad().getCatLocalidadId() == null) {
				entidad.setNomCatLocalidadId(null);
			} else {
				entidad.setNomCatLocalidadId(dto.getDireccion().getNomCatLocalidad().getCatLocalidadId());
			}

			// CP
			if (dto.getDireccion().getNomCatCodigoPostal().getCatCodigoPostalId() == null) {
				entidad.setNomCatCodigoPostalId(null);
			} else {
				entidad.setNomCatCodigoPostalId(dto.getDireccion().getNomCatCodigoPostal().getCatCodigoPostalId());
			}

			// País
			if (dto.getDireccion().getNomCatPaises().getPaisId() == null) {
				entidad.setNomCatPaisesId(null);
			} else {
				entidad.setNomCatPaisesId(dto.getDireccion().getNomCatPaises().getPaisId());
			}

			entidad.setCalle(dto.getDireccion().getCalle());
			entidad.setNombreAsentamiento(dto.getDireccion().getNombreAsentamiento());
			entidad.setFechaRegistro(new Date());
			entidad.setStatus(1);
			entidad.setUsuarioCve(dto.getUsuarioCve());

			logger.info("##################  invocando a DAO PersonalDAOImpl altaDireccion , Antes de Tabla Direccion ##################");

			this.save(entidad);

			AgenteDireccion atEntidad = new AgenteDireccion();
			atEntidad.setTipoAgenteId(Constantes.TIPO_AGENTE_ASEGURADORA);
			atEntidad.setDireccion(entidad);
			atEntidad.setAgenteId(dto.getAgenteId());
			atEntidad.setStatus(1);
			atEntidad.setFechaRegistro(new Date());
			atEntidad.setUsuarioCve(dto.getUsuarioCve());
			atEntidad.setCve(dto.getCve());
			atEntidad.setAgenteCve("1"); // Para esta Tabla 1=Direccion Normal, 2=Corresponde a Otro Domicilio

			this.save(atEntidad);
			this.flush();
			exito = atEntidad.getAgenteDireccionId();  // Regresa el Id de la entidad creada
		} catch (Exception e) {
			logger.info("########### Ocurrio un error al guardar altaDireccion ", e);
			logger.info("exito", exito);

			exito = 0;
		}

		return exito;

	}


	@Override
	@Transactional
	public int modificaDireccion(AgenteDireccionDTO dto) {
		logger.info("----------> invocando a DAO PersonalDAOImpl modificaDireccion <----------");

		int exito = 0;
		try {
			Criteria ct = session().createCriteria(Direccion.class);
			ct.add(Restrictions.eq("direccionId", dto.getDireccion().getDireccionId()));

			Direccion entidad = (Direccion) ct.uniqueResult();

			// Entidad
			if (dto.getDireccion().getNomCatEntidades().getCatEntidadesId() == null) {
				entidad.setNomCatEntidadesId(null);
			} else {
				entidad.setNomCatEntidadesId(dto.getDireccion().getNomCatEntidades().getCatEntidadesId());
			}

			// Municipio
			if (dto.getDireccion().getNomCatMunicipio().getCatMunicipioId() == null) {
				entidad.setNomCatMunicipioId(null);
			} else {
				entidad.setNomCatMunicipioId(dto.getDireccion().getNomCatMunicipio().getCatMunicipioId());
			}

			// Localidad
			if (dto.getDireccion().getNomCatLocalidad().getCatLocalidadId() == null) {
				entidad.setNomCatLocalidadId(null);
			} else {
				entidad.setNomCatLocalidadId(dto.getDireccion().getNomCatLocalidad().getCatLocalidadId());
			}

			// CP
			if (dto.getDireccion().getNomCatCodigoPostal().getCatCodigoPostalId() == null) {
				entidad.setNomCatCodigoPostalId(null);
			} else {
				entidad.setNomCatCodigoPostalId(dto.getDireccion().getNomCatCodigoPostal().getCatCodigoPostalId());
			}

			// País
			if (dto.getDireccion().getNomCatPaises().getPaisId() == null) {
				entidad.setNomCatPaisesId(null);
			} else {
				entidad.setNomCatPaisesId(dto.getDireccion().getNomCatPaises().getPaisId());
			}

			entidad.setCalle(dto.getDireccion().getCalle());
			entidad.setNombreAsentamiento(dto.getDireccion().getNombreAsentamiento());

			this.merge(entidad);
			this.flush();

			logger.info("########### SE ACTUALIZO DE FORMA CORRECTA EL modificaDireccion");

			exito = entidad.getDireccionId();
		} catch (Exception e) {
			logger.info("########### Ocurrio un error al guardar modificaDireccion ", e);
			exito = 0;
		}

		return exito;
	}


	@Override
	@Transactional
	public int eliminaDireccion(AgenteDireccionDTO dto) {
		logger.info("----------------------------> AdmCatAseguradoraDAO");

		int exito = 0;
		try {
			Criteria ct = session().createCriteria(Direccion.class);
			ct.add(Restrictions.eq("direccionId", dto.getDireccion().getDireccionId()));

			Direccion entidad = (Direccion) ct.uniqueResult();
			entidad.setStatus(0);

			this.merge(entidad);
			this.flush();

			logger.info("----------------------------> SE ACTUALIZO DE FORMA CORRECTA EL eliminaDireccion");

			exito = 1;
		} catch (Exception e) {
			logger.info("----------------------------> Ocurrio un error al guardar eliminaDireccion ", e);
			exito = 0;
		}

		return exito;
	}


	@Override
	@Transactional
	public List<DireccionDTO> listaDireccion(AgenteDireccionDTO dto) {
		List<DireccionDTO> lista;
		logger.info("##################  invocando a DAO listaDireccion ##################");

		try {
			Criteria unidad = session().createCriteria(Direccion.class, "direccion").setProjection(Projections
					.projectionList()
					.add(Projections.property("direccionId"), "direccionId")
					.add(Projections.property("calle"), "calle")
					.add(Projections.property("nombreAsentamiento"), "nombreAsentamiento")
					.add(Projections.property("status"), "status")
					.add(Projections.property("fechaRegistro"), "fechaRegistro")
					.add(Projections.property("usuarioCve"), "usuarioCve")
					.add(Projections.property("cve"), "cve")
					.add(Projections.property("nomCatEntidades.catEntidadesId"), "nomCatEntidades.catEntidadesId")
					.add(Projections.property("nomCatEntidades.descripcion"), "nomCatEntidades.descripcion")
					.add(Projections.property("nomCatMunicipio.catMunicipioId"), "nomCatMunicipio.catMunicipioId")
					.add(Projections.property("nomCatMunicipio.descripcion"), "nomCatMunicipio.descripcion")
					.add(Projections.property("nomCatLocalidad.catLocalidadId"), "nomCatLocalidad.catLocalidadId")
					.add(Projections.property("nomCatLocalidad.descripcion"), "nomCatLocalidad.descripcion")
					.add(Projections.property("nomCatCodigoPostal.catCodigoPostalId"), "nomCatCodigoPostal.catCodigoPostalId")
					.add(Projections.property("nomCatCodigoPostal.descripcion"), "nomCatCodigoPostal.descripcion")
					.add(Projections.property("nomCatPaises.paisId"), "nomCatPaises.paisId")
					.add(Projections.property("nomCatPaises.descripcion"), "nomCatPaises.descripcion")
			);

			unidad.createAlias("direccion.agenteDireccions", "agenteDireccions", JoinType.LEFT_OUTER_JOIN);
			unidad.createAlias("direccion.nomCatEntidades", "nomCatEntidades", JoinType.LEFT_OUTER_JOIN);
			unidad.createAlias("direccion.nomCatMunicipio", "nomCatMunicipio", JoinType.LEFT_OUTER_JOIN);
			unidad.createAlias("direccion.nomCatLocalidad", "nomCatLocalidad", JoinType.LEFT_OUTER_JOIN);
			unidad.createAlias("direccion.nomCatCodigoPostal", "nomCatCodigoPostal", JoinType.LEFT_OUTER_JOIN);
			unidad.createAlias("direccion.nomCatPaises", "nomCatPaises", JoinType.LEFT_OUTER_JOIN);
			unidad.createAlias("agenteDireccions.catTipoAgente", "catTipoAgente", JoinType.LEFT_OUTER_JOIN);

			unidad.add(Restrictions.eq("agenteDireccions.agenteId", dto.getAgenteId()));
			unidad.add(Restrictions.eq("status", 1));
			unidad.add(Restrictions.eq("catTipoAgente.tipoAgenteId", 4));

			unidad.setResultTransformer(new AliasToBeanNestedResultTransformer(DireccionDTO.class));

			lista = unidad.list();
		} catch (Exception e) {
			lista = null;
			logger.info("---------------> Ocurrio un error al recuperar listaDireccion ", e);
		}

		return lista;
	}


	@Override
	@Transactional
	public AdmCatAseguradora aseguradoraById(Integer aseguradoraId) {
		Criteria unidad = session().createCriteria(AdmCatAseguradora.class);
		unidad.add(Restrictions.eq("aseguradoraId", aseguradoraId));
		logger.info("--------------> aseguradoraId", aseguradoraId);

		AdmCatAseguradora tmp = (AdmCatAseguradora) unidad.uniqueResult();
		return (AdmCatAseguradora) unidad.uniqueResult();
	}
}
