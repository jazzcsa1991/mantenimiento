package hts.backend.dao.impl;


import hts.backend.dao.AliasToBeanNestedResultTransformer;
import hts.backend.dao.impl.GenericHibernateDAOImpl;
import hts.backend.dao.CatalogosDAO;
import hts.backend.model.dto.CatalogoDTO;
import hts.backend.model.dto.OpcionCatalogoComunDTO;
import hts.backend.model.dto.ServicioEspecialidadDTO;
import hts.backend.model.dto.*;
import hts.backend.entity.*;
import hts.backend.entity.CexPrincipiosActivos;
import hts.backend.entity.CatAlergia;
import hts.backend.entity.CatImpedimento;
import hts.backend.entity.GusModulos;
import hts.backend.entity.NomCatCircunDefuncion;
import hts.backend.entity.CatHspProcedencia;
import hts.backend.entity.CatMotivoIngreso;
import hts.backend.entity.CatPreIngresoPrioridad;
import hts.backend.entity.CatTipoIngresoHosp;
import hts.backend.entity.*;
import hts.backend.entity.CatTipoVisita;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SuppressWarnings("unchecked")
@Repository("catalogosDAO")
@Transactional

public class CatalogosDAOImpl extends GenericHibernateDAOImpl implements CatalogosDAO {
	private static final Logger logger = LoggerFactory.getLogger(CatalogosDAOImpl.class);


	@Override
	public List<CatalogoDTO> obtenerCatalogoSexo() {
		return ejecutaQueryGenericoCatalogosDefault(QRY_CATALOGO_SEXO);
	}


	@Override
	public List<CatalogoDTO> obtenerCatalogoSangre() {
		return ejecutaQueryGenericoCatalogosDefault(QRY_CATALOGO_SANGRE);
	}


	@Override
	public List<CatalogoDTO> obtenerCatalogoOCupacion() {
		return ejecutaQueryGenericoCatalogosDefault(QRY_CATALOGO_OCUPACION);
	}


	@Override
	public List<CatalogoDTO> obtenerCatalogoNvlEstudios() {
		return ejecutaQueryGenericoCatalogosDefault(QRY_CATALOGO_NVLESTUDIOS);
	}


	@Override
	public List<CatalogoDTO> obtenerCatalogoIdioma() {
		return ejecutaQueryGenericoCatalogosDefault(QRY_CATALOGO_IDIOMA);
	}


	@Override
	public List<CatalogoDTO> obtenerCatalogoNacionalidad() {
		return ejecutaQueryGenericoCatalogosDefault(QRY_CATALOGO_NACIONDALIDA);
	}


	@Override
	public List<CatalogoDTO> obtenerCatalogoEstado() {
		return ejecutaQueryGenericoCatalogos(QRY_CATALOGO_ESTADO);
	}


	@Override
	public List<CatalogoDTO> obtenerCatalogoDocIden() {
		return ejecutaQueryGenericoCatalogosDefault(QRY_CATALOGO_DOCIDEN);
	}


	@Override
	public List<CatalogoDTO> obtenerCatalogoReligion() {
		return ejecutaQueryGenericoCatalogosDefault(QRY_CATALOGO_RELIGION);
	}

	@Override
	public List<CatalogoDTO> obtenerMotivoAnulacionCirugia() {
		return ejecutaQueryGenericoCatalogosDefault(QRY_CATALOGO_MOTIVO_ANULACION_CIRUGIA);
	}


	@Override
	public List<CatalogoDTO> obtenerCatalogoEstadoCivil() {
		return ejecutaQueryGenericoCatalogosDefault(QRY_CATALOGO_ESTADO_CIVIL);
	}


	@Override
	public List<CatalogoDTO> obtenerCatalogoMunicipio() {
		return ejecutaQueryGenericoCatalogos(QRY_CATALOGO_MUNICIPIO);
	}


	@Override
	public List<CatalogoDTO> obtenerCatalogoLocalidad() {
		return ejecutaQueryGenericoCatalogos(QRY_CATALOGO_LOCALIDAD);
	}


	@Override
	public List<CatalogoDTO> obtenerCatalogoColonia() {
		return ejecutaQueryGenericoCatalogos(QRY_CATALOGO_COLONIA);
	}


	@Override
	public List<CatalogoDTO> obtenerCatalogoTipoBeneficiario() {
		return ejecutaQueryGenericoCatalogos(QRY_CATALOGO_TIPO_BENEFICIARO);
	}


	@Override
	public List<CatalogoDTO> obtenerCatalogoParentesco() {
		return ejecutaQueryGenericoCatalogosDefault(QRY_CATALOGO_PARENTESCO);
	}


	@Override
	public List<CatalogoDTO> obtenerCatalogoTipoPaciente() {
		return ejecutaQueryGenericoCatalogos(QRY_CATALOGO_TIPOPACIENTE);
	}


	@Override
	public List<CatalogoDTO> obtenerCatalogoEtnia() {
		return ejecutaQueryGenericoCatalogos(QRY_CATALOGO_ETNIA);
	}


	@Override
	public List<CatalogoDTO> obtenerCatalogoProcedencia() {
		return ejecutaQueryGenericoCatalogosDefault(QRY_CATALOGO_PROCEDENCIA);
	}


	@Override
	public List<CatalogoDTO> obtenerCatalogoAlergias() {
		return ejecutaQueryGenericoCatalogos(QRY_CATALOGO_ALERGIAS);
	}


	@Override
	public List<CatalogoDTO> obtenerCatalogoContraIndi() {
		return ejecutaQueryGenericoCatalogos(QRY_CATALOGO_CONTRAIND);
	}


	@Override
	public List<CatalogoDTO> obtenerCatalogoImpedimentos() {
		return ejecutaQueryGenericoCatalogos(QRY_CATALOGO_IMPEDIMENTOS);
	}


	/**
	 * Metodo para ejecutar la consulta a un catalogo y obtener una respuesta generica idOpcion , descripcion para llenar los caombos en el front
	 *
	 *
	 * @return
	 */
	public List<CatalogoDTO> ejecutaQueryGenericoCatalogos(String queryCatalogo) {
		Query query =
				getCurrentSession().createSQLQuery(queryCatalogo)
						.addScalar("id", StandardBasicTypes.INTEGER)
						.addScalar("name", StandardBasicTypes.STRING);
		query.setResultTransformer(Transformers.aliasToBean(CatalogoDTO.class));

		return query.list();
	}


	/**
	 * Metodo para ejecutar la consulta a un catalogo y obtener una respuesta generica id , name
	 * para llenar los combos en el front e indicar un valor seleccionado por default
	 *
	 * @param queryCatalogo
	 * @return
	 */
	public List<CatalogoDTO> ejecutaQueryGenericoCatalogosDefault(String queryCatalogo) {
		Query query = getCurrentSession().createSQLQuery(queryCatalogo)
				.addScalar("id", StandardBasicTypes.INTEGER)
				.addScalar("name", StandardBasicTypes.STRING)
				.addScalar("indicaDefault", StandardBasicTypes.INTEGER);
		query.setResultTransformer(Transformers.aliasToBean(CatalogoDTO.class));

		return query.list();
	}


	@Override
	public List<ServicioEspecialidadDTO> obtenerServicios() {
		Query query = getCurrentSession().createSQLQuery(QRY_CATALOGO_SERVICIOS)
				.addScalar("idCentro", StandardBasicTypes.INTEGER)
				.addScalar("idAreaServicio", StandardBasicTypes.INTEGER)
				.addScalar("idServicioBasico", StandardBasicTypes.INTEGER)
				.addScalar("descripcion", StandardBasicTypes.STRING);
		query.setResultTransformer(Transformers.aliasToBean(ServicioEspecialidadDTO.class));
		List<ServicioEspecialidadDTO> lista = query.list();

		return lista;
	}


	@Override
	public List<ServicioEspecialidadDTO> obtenerEspecialidad(ServicioEspecialidadDTO servicio) {
		Query query = getCurrentSession().createSQLQuery(QRY_CATALOGO_SERVICIO_ESP)
				.addScalar("idCentro", StandardBasicTypes.INTEGER)
				.addScalar("idAreaServicio", StandardBasicTypes.INTEGER)
				.addScalar("idServicioBasico", StandardBasicTypes.INTEGER)
				.addScalar("idServicioEspecializado", StandardBasicTypes.INTEGER)
				.addScalar("descripcion", StandardBasicTypes.STRING);
		query.setParameter("p_idCentro", servicio.getIdCentro());
		query.setParameter("p_idServicio", servicio.getIdAreaServicio());
		query.setParameter("p_idServicioBasico", servicio.getIdServicioBasico());
		query.setResultTransformer(Transformers.aliasToBean(ServicioEspecialidadDTO.class));
		List<ServicioEspecialidadDTO> lista = query.list();

		return lista;
	}


	@Override
	public List<CatalogoDTO> obtenerCatalogoPais() {
		Query query = getCurrentSession().createSQLQuery(QRY_CATALOGO_PAIS)
				.addScalar("idCatPostal", StandardBasicTypes.STRING)
				.addScalar("name", StandardBasicTypes.STRING)
				.addScalar("indicaDefault", StandardBasicTypes.INTEGER);
		query.setResultTransformer(Transformers.aliasToBean(CatalogoDTO.class));

		return query.list();
	}


	@Override
	public List<CatalogoDTO> obtenerCatalogoEstadoPais() {
		Query query = getCurrentSession().createSQLQuery(QRY_CATALOGO_ESTADO_PAIS)
				.addScalar("idCatPostal", StandardBasicTypes.STRING)
				.addScalar("name", StandardBasicTypes.STRING)
				.addScalar("indicaDefault", StandardBasicTypes.INTEGER);
		query.setResultTransformer(Transformers.aliasToBean(CatalogoDTO.class));

		return query.list();
	}


	/**********************************************************************************************
	 ************************ CATALOGOS RELACIONADOS CON DIRECCION ********************************
	 **********************************************************************************************/

	@Override
	public List<NomCatPaisesDTO> listaPaises() {
		List<NomCatPaisesDTO> lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl listaPaises ##################");

		try {
			Session s = getCurrentSession();
			logger.info("########### Oasdasdasdas ", s);

			Criteria unidad = s.createCriteria(NomCatPaises.class, "pais").setProjection(Projections
					.projectionList()
					.add(Projections.property("paisId"), "paisId")
					.add(Projections.property("cve"), "cve")
					.add(Projections.property("descripcion"), "descripcion")
					.add(Projections.property("codOficial"), "codOficial")
					.add(Projections.property("indicaDefault"), "indicaDefault")
					.add(Projections.property("status"), "status")
					.add(Projections.property("usuarioCve"), "usuarioCve")
					.add(Projections.property("fechaRegistro"), "fechaRegistro"));

			unidad.add(Restrictions.eq("status", 1));

			unidad.addOrder(Order.desc("indicaDefault"))
					.addOrder(Order.asc("descripcion"));

			unidad.setResultTransformer(Transformers.aliasToBean(NomCatPaisesDTO.class));
			lista = unidad.list();
			s.close();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al recuperar listaPaises ", e);
		}

		return lista;
	}


	@Override
	public List<NomCatEntidadesDTO> listaEntidadesByPaisID(NomCatPaisesDTO dto) {
		List<NomCatEntidadesDTO> lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl listaEntidadesByPaisID ##################");

		try {
			Criteria unidad = getCurrentSession().createCriteria(NomCatEntidades.class, "entidades").setProjection(Projections
					.projectionList()
					.add(Projections.property("catEntidadesId"), "catEntidadesId")
					.add(Projections.property("cve"), "cve")
					.add(Projections.property("descripcion"), "descripcion")
					.add(Projections.property("nombre"), "nombre")
					.add(Projections.property("indicaDefault"), "indicaDefault")
					.add(Projections.property("status"), "status")
					.add(Projections.property("usuarioCve"), "usuarioCve")
					.add(Projections.property("fechaRegistro"), "fechaRegistro"));

			unidad.createAlias("entidades.nomCatPaises", "nomCatPaises");

			unidad.add(Restrictions.eq("status", 1))
					.add(Restrictions.eq("nomCatPaises.paisId", dto.getPaisId()));

			unidad.addOrder(Order.desc("indicaDefault"))
					.addOrder(Order.asc("descripcion"));

			unidad.setResultTransformer(new AliasToBeanNestedResultTransformer(NomCatEntidadesDTO.class));
			lista = unidad.list();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al recuperar listaEntidadesByPaisID ", e);
		}

		return lista;
	}


	@Override
	public List<NomCatMunicipioDTO> listaMunicipiosByCveEntidad(NomCatEntidadesDTO dto) {
		List<NomCatMunicipioDTO> lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl listaMunicipiosByCveEntidad ##################");

		try {

			Criteria unidad = getCurrentSession().createCriteria(NomCatMunicipio.class, "municipio").setProjection(Projections
					.projectionList()
					.add(Projections.property("catMunicipioId"), "catMunicipioId")
					.add(Projections.property("cveEnt"), "cveEnt")
					.add(Projections.property("cveMun"), "cveMun")
					.add(Projections.property("descripcion"), "descripcion")
					.add(Projections.property("indicaDefault"), "indicaDefault")
					.add(Projections.property("status"), "status")
					.add(Projections.property("usuarioCve"), "usuarioCve")
					.add(Projections.property("fechaRegistro"), "fechaRegistro"));

			unidad.add(Restrictions.eq("status", 1))
					.add(Restrictions.eq("cveEnt", dto.getCve())
					);

			unidad.addOrder(Order.desc("indicaDefault"))
					.addOrder(Order.asc("descripcion"));

			unidad.setResultTransformer(Transformers.aliasToBean(NomCatMunicipioDTO.class));

			lista = unidad.list();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al recuperar listaMunicipiosByCveEntidad ", e);
		}

		return lista;
	}


	@Override
	public List<NomCatLocalidadDTO> listaLocalidadesByCveEntMun(NomCatMunicipioDTO dto) {
		List<NomCatLocalidadDTO> lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl listaLocalidadesByCveEntMun ##################");

		try {
			Criteria unidad = getCurrentSession().createCriteria(NomCatLocalidad.class, "localidad").setProjection(Projections
					.projectionList()
					.add(Projections.property("catLocalidadId"), "catLocalidadId")
					.add(Projections.property("cveEnt"), "cveEnt")
					.add(Projections.property("cveMun"), "cveMun")
					.add(Projections.property("cveLoc"), "cveLoc")
					.add(Projections.property("descripcion"), "descripcion")
					.add(Projections.property("indicaDefault"), "indicaDefault")
					.add(Projections.property("status"), "status")
					.add(Projections.property("usuarioCve"), "usuarioCve")
					.add(Projections.property("fechaRegistro"), "fechaRegistro"));

			unidad.add(Restrictions.eq("status", 1))
					.add(Restrictions.eq("cveEnt", dto.getCveEnt()))
					.add(Restrictions.eq("cveMun", dto.getCveMun()))
			;

			unidad.addOrder(Order.desc("indicaDefault"))
					.addOrder(Order.asc("descripcion"))
			;

			unidad.setResultTransformer(Transformers.aliasToBean(NomCatLocalidadDTO.class));

			lista = unidad.list();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al recuperar listaLocalidadesByCveEntMun ", e);
		}

		return lista;
	}


	@Override
	public List<NomCatCodigoPostalDTO> listaCodPostalByCveEntMun(NomCatMunicipioDTO dto) {
		List<NomCatCodigoPostalDTO> lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl listaCodPostalByCveEntMun ##################");

		try {
			Criteria unidad = getCurrentSession().createCriteria(NomCatCodigoPostal.class, "cpostal").setProjection(Projections
					.projectionList()
					.add(Projections.property("catCodigoPostalId"), "catCodigoPostalId")
					.add(Projections.property("nombre"), "nombre")
					.add(Projections.property("descripcion"), "descripcion")
					.add(Projections.property("CEstado"), "CEstado")
					.add(Projections.property("CMunicipio"), "CMunicipio")
					.add(Projections.property("cve"), "cve")
					.add(Projections.property("indicaDefault"), "indicaDefault")
					.add(Projections.property("status"), "status")
					.add(Projections.property("usuarioCve"), "usuarioCve")
					.add(Projections.property("fechaRegistro"), "fechaRegistro"));

			unidad.add(Restrictions.eq("status", 1))
					.add(Restrictions.eq("CEstado", dto.getCveEnt()))
					.add(Restrictions.eq("CMunicipio", dto.getCveMun()))
			;

			unidad.addOrder(Order.desc("indicaDefault"))
					.addOrder(Order.asc("descripcion"))
			;

			unidad.setResultTransformer(Transformers.aliasToBean(NomCatCodigoPostalDTO.class));
			lista = unidad.list();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al recuperar listaCodPostalByCveEntMun ", e);
		}

		return lista;
	}


	@Override
	public List<NomCatNacionalidadesDTO> listaNacionalidades() {
		List<NomCatNacionalidadesDTO> lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl listaNacionalidades ##################");

		try {
			Criteria unidad = getCurrentSession().createCriteria(NomCatNacionalidades.class, "nacion").setProjection(Projections
					.projectionList()
					.add(Projections.property("nomCatNacionalidadesId"), "nomCatNacionalidadesId")
					.add(Projections.property("codigoPais"), "codigoPais")
					.add(Projections.property("pais"), "pais")
					.add(Projections.property("cveNacionalidad"), "cveNacionalidad")
					.add(Projections.property("indicaDefault"), "indicaDefault")
					.add(Projections.property("status"), "status")
					.add(Projections.property("usuarioCve"), "usuarioCve")
					.add(Projections.property("fechaRegistro"), "fechaRegistro"));

			unidad.add(Restrictions.eq("status", 1));

			unidad.addOrder(Order.desc("indicaDefault"))
					.addOrder(Order.asc("pais"))
			;

			unidad.setResultTransformer(Transformers.aliasToBean(NomCatNacionalidadesDTO.class));

			lista = unidad.list();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al recuperar listaNacionalidades ", e);
		}

		return lista;
	}


	@Override
	public List<CatTipoAsenDTO> listaTipoAsentamiento() {
		String QRY_TIPO_ASEN = "" +
				"SELECT " +
				"	asen.TIPO_ASEN_ID AS tipoAsenId," +
				"	asen.CVE AS clave, " +
				"	asen.NOMBRE AS nombre, " +
				"	asen.DESCRIPCION AS descripcion, " +
				"	asen.VALOR_DEFAULT AS indicaDefault, " +
				"	asen.ESTATUS AS status, " +
				"	asen.USUARIO_REGISTRO AS noUsuario, " +
				"	asen.FECHA_REGISTRO AS fechaRegistro " +
				"FROM cat_tipo_asen asen " +
				"WHERE asen.ESTATUS = 1 " +
				"ORDER BY asen.VALOR_DEFAULT DESC, asen.NOMBRE ASC";

		Query query = getCurrentSession().createSQLQuery(QRY_TIPO_ASEN)
				.addScalar("tipoAsenId", StandardBasicTypes.INTEGER)
				.addScalar("clave", StandardBasicTypes.STRING)
				.addScalar("nombre", StandardBasicTypes.STRING)
				.addScalar("descripcion", StandardBasicTypes.STRING)
				.addScalar("indicaDefault", StandardBasicTypes.INTEGER)
				.addScalar("status", StandardBasicTypes.INTEGER)
				.addScalar("noUsuario", StandardBasicTypes.STRING)
				.addScalar("fechaRegistro", StandardBasicTypes.DATE);

		query.setResultTransformer(Transformers.aliasToBean(CatTipoAsenDTO.class));

		List<CatTipoAsenDTO> test = query.list();

		CatTipoAsenDTO test2 = test.get(0);
		return query.list();
	}


	@Override
	public List<CatVialidadDTO> listaVialidad() {
		List<CatVialidadDTO> lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl listaVialidad ##################");

		try {
			Criteria unidad = getCurrentSession().createCriteria(CatVialidad.class, "asenta").setProjection(Projections
					.projectionList()
					.add(Projections.property("vialidadId"), "vialidadId")
					.add(Projections.property("clave"), "clave")
					.add(Projections.property("nombre"), "nombre")
					.add(Projections.property("descripcion"), "descripcion")
					.add(Projections.property("indicaDefault"), "indicaDefault")
					.add(Projections.property("estatus"), "estatus")
					.add(Projections.property("noUsuario"), "noUsuario")
					.add(Projections.property("fechaRegistro"), "fechaRegistro"));

			unidad.add(Restrictions.eq("estatus", 1));

			unidad.addOrder(Order.desc("indicaDefault"))
					.addOrder(Order.asc("descripcion"))
			;

			unidad.setResultTransformer(Transformers.aliasToBean(CatVialidadDTO.class));

			lista = unidad.list();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al recuperar listaVialidad ", e);
		}

		return lista;
	}


	@Override
	public List<NomCatSexoDTO> listaSexo() {
		List<NomCatSexoDTO> lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl listaSexo ##################");

		try {
			Criteria unidad = getCurrentSession().createCriteria(NomCatSexo.class, "csexo").setProjection(Projections
					.projectionList()
					.add(Projections.property("sexoId"), "sexoId")
					.add(Projections.property("descripcion"), "descripcion")
					.add(Projections.property("fechaRegistro"), "fechaRegistro")
					.add(Projections.property("indicaDefault"), "indicaDefault")
					.add(Projections.property("estatus"), "estatus")
					.add(Projections.property("noUsuario"), "noUsuario")
			);

			unidad.add(Restrictions.eq("estatus", 1));

			unidad.addOrder(Order.desc("indicaDefault"))
					.addOrder(Order.asc("descripcion"))
			;

			unidad.setResultTransformer(Transformers.aliasToBean(NomCatSexoDTO.class));

			lista = unidad.list();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al recuperar listaSexo ", e);
		}

		return lista;
	}


	@Override
	public List<CatTipoSangreDTO> listaTipoSangre() {
		List<CatTipoSangreDTO> lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl listaTipoSangre ##################");

		try {
			Criteria unidad = getCurrentSession().createCriteria(CatTipoSangre.class, "csangre").setProjection(Projections
					.projectionList()
					.add(Projections.property("tipoSangreId"), "tipoSangreId")
					.add(Projections.property("cve"), "cve")
					.add(Projections.property("nombre"), "nombre")
					.add(Projections.property("descripcion"), "descripcion")
					.add(Projections.property("valorDefault"), "valorDefault")
					.add(Projections.property("estatus"), "estatus")
					.add(Projections.property("fechaRegistro"), "fechaRegistro")
					.add(Projections.property("usuarioRegistra"), "usuarioRegistra")
					.add(Projections.property("idiomaAppId"), "idiomaAppId")
			);

			unidad.add(Restrictions.eq("estatus", 1));

			unidad.addOrder(Order.desc("valorDefault"))
					.addOrder(Order.asc("descripcion"))
			;

			unidad.setResultTransformer(Transformers.aliasToBean(CatTipoSangreDTO.class));

			lista = unidad.list();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al recuperar listaTipoSangre ", e);
		}

		return lista;
	}


	@Override
	public List<NomCatReligionDTO> listaReligion() {
		List<NomCatReligionDTO> lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl listaReligion ##################");

		try {
			Criteria unidad = getCurrentSession().createCriteria(NomCatReligion.class, "creligion").setProjection(Projections
					.projectionList()
					.add(Projections.property("religionid"), "religionid")
					.add(Projections.property("descripcion"), "descripcion")
					.add(Projections.property("fecharegistro"), "fecharegistro")
					.add(Projections.property("indicadefault"), "indicadefault")
					.add(Projections.property("estatus"), "estatus")
					.add(Projections.property("nousuario"), "nousuario")

			);

			unidad.add(Restrictions.eq("estatus", 1));

			unidad.addOrder(Order.desc("indicadefault"))
					.addOrder(Order.asc("descripcion"))
			;

			unidad.setResultTransformer(Transformers.aliasToBean(NomCatReligionDTO.class));

			lista = unidad.list();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al recuperar listaReligion ", e);
		}

		return lista;
	}


	@Override
	public List<NomCatEstadoCivilDTO> listaEstadoCivil(NomCatEstadoCivilDTO dto) {
		List<NomCatEstadoCivilDTO> lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl listaEstadoCivil ##################");

		try {
			Criteria unidad = getCurrentSession().createCriteria(NomCatEstadoCivil.class, "cEstadoCivil").setProjection(Projections
					.projectionList()
					.add(Projections.property("estadoCivilId"), "estadoCivilId")
					.add(Projections.property("cve"), "cve")
					.add(Projections.property("nombre"), "nombre")
					.add(Projections.property("guiaId"), "guiaId")
					.add(Projections.property("idiomaAppId"), "idiomaAppId")
			);

			unidad.add(Restrictions.eq("guiaId", 2))
					.add(Restrictions.eq("idiomaAppId", dto.getIdiomaAppId()))
			;

			unidad    //.addOrder(Order.desc("indicadefault"))
					.addOrder(Order.asc("nombre"))
			;

			unidad.setResultTransformer(Transformers.aliasToBean(NomCatEstadoCivilDTO.class));

			lista = unidad.list();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al recuperar listaEstadoCivil ", e);
		}

		return lista;
	}


	@Override
	public List<NomCatOcupacionDTO> listaOcupacion() {
		List<NomCatOcupacionDTO> lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl listaOcupacion ##################");

		try {
			Criteria unidad = getCurrentSession().createCriteria(NomCatOcupacion.class, "cOcupacion").setProjection(Projections
					.projectionList()
					.add(Projections.property("ocupacionId"), "ocupacionId")
					.add(Projections.property("cve"), "cve")
					.add(Projections.property("nombre"), "nombre")
					.add(Projections.property("descripcion"), "descripcion")
					.add(Projections.property("valorDefualt"), "valorDefualt")
					.add(Projections.property("estatus"), "estatus")
					.add(Projections.property("fechaRegistro"), "fechaRegistro")
					.add(Projections.property("usuarioRegistra"), "usuarioRegistra")
					.add(Projections.property("idiomaAppId"), "idiomaAppId")
			);

			unidad.add(Restrictions.eq("estatus", 1));

			unidad.addOrder(Order.desc("valorDefualt"))
					.addOrder(Order.asc("nombre"))
			;

			unidad.setResultTransformer(Transformers.aliasToBean(NomCatOcupacionDTO.class));

			lista = unidad.list();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al recuperar listaOcupacion ", e);
		}

		return lista;
	}


	@Override
	public List<NomCatEscolaridadDTO> listaNivelEscolaridad() {
		List<NomCatEscolaridadDTO> lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl listaNivelEscolaridad ##################");

		try {
			Criteria unidad = getCurrentSession().createCriteria(NomCatEscolaridad.class, "cEscolaridad").setProjection(Projections
					.projectionList()
					.add(Projections.property("escolaridadId"), "escolaridadId")
					.add(Projections.property("cve"), "cve")
					.add(Projections.property("nombre"), "nombre")
					.add(Projections.property("descripcion"), "descripcion")
					.add(Projections.property("valorDefault"), "valorDefault")
					.add(Projections.property("estatus"), "estatus")
					.add(Projections.property("fechaRegistro"), "fechaRegistro")
					.add(Projections.property("usuarioRegistra"), "usuarioRegistra")
					.add(Projections.property("idiomaAppId"), "idiomaAppId")
			);

			unidad.add(Restrictions.eq("estatus", 1));

			unidad.addOrder(Order.desc("valorDefault"))
					.addOrder(Order.asc("nombre"))
			;

			unidad.setResultTransformer(Transformers.aliasToBean(NomCatEscolaridadDTO.class));

			lista = unidad.list();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al recuperar listaNivelEscolaridad ", e);
		}

		return lista;
	}


	@Override
	public List<NomCatTipoLenguaIndigenaDTO> listaTipoLenguaIndigena(NomCatTipoLenguaIndigenaDTO dto) {
		List<NomCatTipoLenguaIndigenaDTO> lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl listaTipoLenguaIndigena ##################");

		try {
			Criteria unidad = getCurrentSession().createCriteria(NomCatTipoLenguaIndigena.class, "cLenguaIndigena").setProjection(Projections
					.projectionList()
					.add(Projections.property("tipoLenguaIndigenaId"), "tipoLenguaIndigenaId")
					.add(Projections.property("cve"), "cve")
					.add(Projections.property("nombre"), "nombre")
					.add(Projections.property("guiaId"), "guiaId")
					.add(Projections.property("idiomaAppId"), "idiomaAppId")
			);

			unidad.add(Restrictions.eq("guiaId", 2))
					.add(Restrictions.eq("idiomaAppId", dto.getIdiomaAppId()));

			unidad.addOrder(Order.asc("nombre"));

			unidad.setResultTransformer(Transformers.aliasToBean(NomCatTipoLenguaIndigenaDTO.class));

			lista = unidad.list();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al recuperar listaTipoLenguaIndigena ", e);
		}

		return lista;
	}


	@Override
	public List<CatProcedenciaDTO> listaProcedencia() {
		List<CatProcedenciaDTO> lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl listaProcedencia ##################");

		try {
			Criteria unidad = getCurrentSession().createCriteria(CatProcedencia.class, "cProcedencia").setProjection(Projections
					.projectionList()
					.add(Projections.property("procedenciaId"), "procedenciaId")
					.add(Projections.property("cve"), "cve")
					.add(Projections.property("nombre"), "nombre")
					.add(Projections.property("descripcion"), "descripcion")
					.add(Projections.property("valorDefault"), "valorDefault")
					.add(Projections.property("estatus"), "estatus")
					.add(Projections.property("fechaRegistro"), "fechaRegistro")
					.add(Projections.property("usuarioRegistra"), "usuarioRegistra")
					.add(Projections.property("idiomaAppId"), "idiomaAppId")
			);

			unidad.add(Restrictions.eq("estatus", 1))
//					.add(Restrictions.eq("idiomaAppId", dto.getIdiomaAppId()))
			;

			unidad.addOrder(Order.asc("nombre"));

			unidad.setResultTransformer(Transformers.aliasToBean(CatProcedenciaDTO.class));

			lista = unidad.list();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al recuperar listaProcedencia ", e);
		}

		return lista;
	}


	@Override
	public List<NomCatSinoDTO> listaSiNo(NomCatSinoDTO dto) {
		List<NomCatSinoDTO> lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl listaTrabajaActualmente ##################");

		try {
			Criteria unidad = getCurrentSession().createCriteria(NomCatSino.class, "cProcedencia").setProjection(Projections
					.projectionList()
					.add(Projections.property("sinoId"), "sinoId")
					.add(Projections.property("cve"), "cve")
					.add(Projections.property("nombre"), "nombre")
					.add(Projections.property("guiaId"), "guiaId")
					.add(Projections.property("idiomaAppId"), "idiomaAppId")
			);

			unidad.add(Restrictions.eq("guiaId", 2))
					.add(Restrictions.eq("idiomaAppId", dto.getIdiomaAppId()))
			;

			unidad.addOrder(Order.asc("nombre"));

			unidad.setResultTransformer(Transformers.aliasToBean(NomCatSinoDTO.class));

			lista = unidad.list();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al recuperar listaTrabajaActualmente ", e);
		}

		return lista;
	}


	@Override
	public List<CatalogoDTO> listaTipoExpediente() {
		return ejecutaQueryGenericoCatalogosDefault(QRY_CAT_TIPO_EXPEDIENTE);
	}

	@Override
	public List<CatalogoDTO> listaMotivoBloqueo() {
		return ejecutaQueryGenericoCatalogosDefault(QRY_CAT_MOTIVO_BLOQUEO_AGENDA);
	}


	@Override
	public List<OpcionCatalogoComunDTO> listaPrestacion3() {
		List<OpcionCatalogoComunDTO> lista;

		Criteria unidad = getCurrentSession().createCriteria(AdmCatTipoPrestacion3.class, "cTipoPrestacion3").setProjection(Projections
				.projectionList()
				.add(Projections.property("cTipoPrestacion3.tipoPrestacion3Id"), "idOpcion")
				.add(Projections.property("cTipoPrestacion3.cve"), "cveOpcion")
				.add(Projections.property("cTipoPrestacion3.nombre"), "nombreOpcion")
				.add(Projections.property("cTipoPrestacion3.descripcion"), "descripcionOpcion")
				.add(Projections.property("cTipoPrestacion3.valorDefault"), "valorDefault")
				.add(Projections.property("cTipoPrestacion3.estatus"), "statusOpcion")
				.add(Projections.property("cTipoPrestacion3.fechaRegistro"), "fechaRegistro")
				.add(Projections.property("cTipoPrestacion3.usuarioRegistra"), "usuarioRegistro")
		);


		unidad.createAlias("cTipoPrestacion3.catIdiomaApp", "idioma");
		unidad.add(Restrictions.eq("idioma.valorDefault", 1));
		unidad.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = unidad.list();

		return lista;
	}


	@Override
	public AdmCatTipoPrestacion3 obtenerPrestacion3Id(Integer tipoPrestacion3Id) {
		Criteria unidad = getCurrentSession().createCriteria(AdmCatTipoPrestacion3.class);
		unidad.add(Restrictions.eq("tipoPrestacion3Id", tipoPrestacion3Id));

		AdmCatTipoPrestacion3 tmp = (AdmCatTipoPrestacion3) unidad.uniqueResult();
		return (AdmCatTipoPrestacion3) unidad.uniqueResult();
	}


	@Override
	public List<OpcionCatalogoComunDTO> listaTipoMoneda() {
		List<OpcionCatalogoComunDTO> lista;

		Criteria unidad = getCurrentSession().createCriteria(NomCatMonedas.class, "cTipoMoneda").setProjection(Projections
				.projectionList()
				.add(Projections.property("cTipoMoneda.monedasId"), "idOpcion")
				.add(Projections.property("cTipoMoneda.clave"), "cveOpcion")
				.add(Projections.property("cTipoMoneda.descripcion"), "nombreOpcion")
				.add(Projections.property("cTipoMoneda.descripcion"), "descripcionOpcion")
				.add(Projections.property("cTipoMoneda.monedaBase"), "valorDefaultFloat")
				.add(Projections.property("cTipoMoneda.status"), "statusOpcionFloat")
				.add(Projections.property("cTipoMoneda.fechaRegistro"), "fechaRegistro")
				.add(Projections.property("cTipoMoneda.tipoDeCambio"), "comodinFloat")
		);

		unidad.addOrder(Order.desc("valorDefaultFloat"));
		unidad.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = unidad.list();

		return lista;
	}


	@Override
	public List<OpcionCatalogoComunDTO> obtenCatMetodoPago() {
		List<OpcionCatalogoComunDTO> lista;

		Criteria unidad = getCurrentSession().createCriteria(NomCatMetodoPago.class, "cMetPago").setProjection(Projections
				.projectionList()
				.add(Projections.property("cMetPago.metodoPagoId"), "idOpcion")
				.add(Projections.property("cMetPago.cve"), "cveOpcion")
				.add(Projections.property("cMetPago.nombre"), "nombreOpcion")
				.add(Projections.property("cMetPago.descripcion"), "descripcionOpcion")
				.add(Projections.property("cMetPago.valorDefault"), "valorDefault")
				.add(Projections.property("cMetPago.estatus"), "statusOpcion")
				.add(Projections.property("cMetPago.fechaRegistro"), "fechaRegistro")
				.add(Projections.property("cMetPago.usuarioRegistra"), "usuarioRegistro")
		);

		unidad.addOrder(Order.desc("valorDefault"));
		unidad.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = unidad.list();

		return lista;
	}


	@Override
	public List<OpcionCatalogoComunDTO> obtenCatBanco() {
		List<OpcionCatalogoComunDTO> lista;

		Criteria unidad = getCurrentSession().createCriteria(NomCatBanco.class, "cBanco").setProjection(Projections
				.projectionList()
				.add(Projections.property("cBanco.bancoId"), "idOpcion")
				.add(Projections.property("cBanco.cve"), "cveOpcion")
				.add(Projections.property("cBanco.nombre"), "nombreOpcion")
				.add(Projections.property("cBanco.descripcion"), "descripcionOpcion")
				.add(Projections.property("cBanco.valorDefault"), "valorDefault")
				.add(Projections.property("cBanco.estatus"), "statusOpcion")
				.add(Projections.property("cBanco.fechaRegistro"), "fechaRegistro")
				.add(Projections.property("cBanco.usuarioRegistra"), "usuarioRegistro")
		);

		unidad.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = unidad.list();

		return lista;
	}


	@Override
	public List<OpcionCatalogoComunDTO> listaTipoAseguradora() {
		List<OpcionCatalogoComunDTO> lista;

		Criteria unidad = getCurrentSession().createCriteria(CatTipoAseguradora.class, "cTipoAseguradora").setProjection(Projections
				.projectionList()
				.add(Projections.property("cTipoAseguradora.tipoAseguradoraId"), "idOpcion")
				.add(Projections.property("cTipoAseguradora.cve"), "cveOpcion")
				.add(Projections.property("cTipoAseguradora.nombre"), "nombreOpcion")
				.add(Projections.property("cTipoAseguradora.descripcion"), "descripcionOpcion")
				.add(Projections.property("cTipoAseguradora.valorDefault"), "valorDefault")
				.add(Projections.property("cTipoAseguradora.estatus"), "statusOpcion")
				.add(Projections.property("cTipoAseguradora.fechaRegistro"), "fechaRegistro")
				.add(Projections.property("cTipoAseguradora.usuarioRegistra"), "usuarioRegistro")
		);

		unidad.createAlias("cTipoAseguradora.catIdiomaApp", "idioma");
		unidad.add(Restrictions.eq("idioma.valorDefault", 1));
		unidad.add(Restrictions.ne("cTipoAseguradora.tipoAseguradoraId", 0));
		unidad.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = unidad.list();

		return lista;
	}


	@Override
	public List<OpcionCatalogoComunDTO> listaCFiscal() {
		List<OpcionCatalogoComunDTO> lista;

		Criteria unidad = getCurrentSession().createCriteria(CatClasificacionFiscal.class, "cClasiFiscal").setProjection(Projections
				.projectionList()
				.add(Projections.property("cClasiFiscal.clasificacionFiscalId"), "idOpcion")
				.add(Projections.property("cClasiFiscal.cve"), "cveOpcion")
				.add(Projections.property("cClasiFiscal.nombre"), "nombreOpcion")
				.add(Projections.property("cClasiFiscal.descripcion"), "descripcionOpcion")
				.add(Projections.property("cClasiFiscal.valorDefault"), "valorDefault")
				.add(Projections.property("cClasiFiscal.estatus"), "statusOpcion")
				.add(Projections.property("cClasiFiscal.fechaRegistro"), "fechaRegistro")
				.add(Projections.property("cClasiFiscal.usuarioRegistra"), "usuarioRegistro")
		);

		unidad.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = unidad.list();

		return lista;
	}


	@Override
	public List<OpcionCatalogoComunDTO> listaCatEpisodios() {
		List<OpcionCatalogoComunDTO> lista;

		Criteria unidad = getCurrentSession().createCriteria(CatTipoEpisodio.class, "cTipoEpisodio").setProjection(Projections
				.projectionList()
				.add(Projections.property("cTipoEpisodio.tipoEpisodioId"), "idOpcion")
				.add(Projections.property("cTipoEpisodio.cve"), "cveOpcion")
				.add(Projections.property("cTipoEpisodio.nombre"), "nombreOpcion")
				.add(Projections.property("cTipoEpisodio.descripcion"), "descripcionOpcion")
				.add(Projections.property("cTipoEpisodio.valorDefault"), "valorDefault")
				.add(Projections.property("cTipoEpisodio.estatus"), "statusOpcion")
				.add(Projections.property("cTipoEpisodio.fechaRegistro"), "fechaRegistro")
				.add(Projections.property("cTipoEpisodio.usuarioRegistro"), "usuarioRegistro")
		);

		unidad.createAlias("cTipoEpisodio.catIdiomaApp", "idioma");
		unidad.add(Restrictions.eq("idioma.valorDefault", 1));
		unidad.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = unidad.list();

		return lista;
	}


	public NomCatEntidades obtenerEntidadByClave(String cveEntidad) {
		Criteria entidad = getCurrentSession().createCriteria(NomCatEntidades.class, "entidad");

		entidad.add(Restrictions.eq("entidad.cve", cveEntidad));

		return (NomCatEntidades) entidad.uniqueResult();
	}


	public NomCatMunicipio obtenerMunicipopByClave(String cveMunicipio, String cveEntidad) {
		Criteria municipio = getCurrentSession().createCriteria(NomCatMunicipio.class, "municipio");


		municipio.add(Restrictions.eq("municipio.cveEnt", cveEntidad));
		municipio.add(Restrictions.eq("municipio.cveMun", cveMunicipio));

		return (NomCatMunicipio) municipio.setMaxResults(1).uniqueResult();
	}


	public NomCatLocalidad obtenerEntidadLocalidad(String cveMunicipio, String cveEntidad) {
		Criteria localidad = getCurrentSession().createCriteria(NomCatLocalidad.class, "localidad");

		localidad.add(Restrictions.eq("status", 1))
				.add(Restrictions.eq("cveEnt", cveEntidad))
				.add(Restrictions.eq("cveMun", cveMunicipio));

		return (NomCatLocalidad) localidad.setMaxResults(1).uniqueResult();
	}


	@Override
	public List<OpcionCatalogoComunDTO> obtenerAlergiasActivas(OpcionCatalogoComunDTO dto) {
		List<OpcionCatalogoComunDTO> lista;

		Criteria alergia = getCurrentSession().createCriteria(CatAlergia.class, "alergia").setProjection(Projections
				.projectionList()
				.add(Projections.property("alergia.alergiaId"), "idOpcion")
				.add(Projections.property("alergia.nombre"), "nombreOpcion"));

		alergia.add(Restrictions.eq("alergia.estatus", new Integer(1)));
		alergia.add(Restrictions.eq("catIdiomaApp.idiomaAppId", dto.getIdIdioma()));

		alergia.createAlias("alergia.catIdiomaApp", "catIdiomaApp");
		alergia.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = alergia.list();

		return lista;
	}


	@Override
	public List<OpcionCatalogoComunDTO> obtenerImpedimentosActivos(OpcionCatalogoComunDTO dto) {
		List<OpcionCatalogoComunDTO> lista;

		Criteria imp = getCurrentSession().createCriteria(CatImpedimento.class, "imp").setProjection(Projections
				.projectionList()
				.add(Projections.property("imp.impedimentoId"), "idOpcion")
				.add(Projections.property("imp.nombre"), "nombreOpcion"));

		imp.add(Restrictions.eq("imp.estatus", new Integer(1)));
		imp.add(Restrictions.eq("catIdiomaApp.idiomaAppId", dto.getIdIdioma()));

		imp.createAlias("imp.catIdiomaApp", "catIdiomaApp");
		imp.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = imp.list();

		return lista;
	}


	@Override
	public List<OpcionCatalogoComunDTO> obtenerContraIndActivas(OpcionCatalogoComunDTO dto) {
		List<OpcionCatalogoComunDTO> lista;

		Criteria contraInd = getCurrentSession().createCriteria(CexPrincipiosActivos.class, "contraInd").setProjection(Projections
				.projectionList()
				.add(Projections.property("contraInd.principioActivoId"), "idOpcion")
				.add(Projections.property("contraInd.nombre"), "nombreOpcion"));

		contraInd.add(Restrictions.eq("contraInd.estatus", new Integer(1)));
		contraInd.add(Restrictions.eq("catIdiomaApp.idiomaAppId", dto.getIdIdioma()));

		contraInd.createAlias("contraInd.catIdiomaAppByIdiomaAppId", "catIdiomaApp");
		contraInd.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = contraInd.list();

		return lista;
	}


	@Override
	public List<OpcionCatalogoComunDTO> obtenerCatFormaFarmaceutica(OpcionCatalogoComunDTO dto) {

		List<OpcionCatalogoComunDTO> lista;

		Criteria formaFarmaceutica = getCurrentSession().createCriteria(CatFormaFarmaceutica.class, "catFormaFarmaceutica").setProjection(Projections
				.projectionList()
				.add(Projections.property("catFormaFarmaceutica.formaFarmaceuticaId"), "idOpcion")
				.add(Projections.property("catFormaFarmaceutica.nombre"), "nombreOpcion"));

		formaFarmaceutica.createAlias("catFormaFarmaceutica.catIdiomaApp", "catIdiomaApp");

		formaFarmaceutica.add(Restrictions.eq("catFormaFarmaceutica.estatus", new Integer(1)));
		formaFarmaceutica.add(Restrictions.eq("catIdiomaApp.idiomaAppId", dto.getIdIdioma()));


		formaFarmaceutica.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = formaFarmaceutica.list();

		return lista;
	}


	@Override
	public List<OpcionCatalogoComunDTO> obtenerCatMedicamentoPresentaciones(OpcionCatalogoComunDTO dto) {
		List<OpcionCatalogoComunDTO> lista;

		Criteria medicamentoPresentaciones = getCurrentSession().createCriteria(CatMedicamentoPresentaciones.class, "catMedicamentoPresentaciones").setProjection(Projections
				.projectionList()
				.add(Projections.property("catMedicamentoPresentaciones.presentacionesId"), "idOpcion")
				.add(Projections.property("catMedicamentoPresentaciones.nombre"), "nombreOpcion"));

		medicamentoPresentaciones.createAlias("catMedicamentoPresentaciones.catIdiomaApp", "catIdiomaApp");

		medicamentoPresentaciones.add(Restrictions.eq("catMedicamentoPresentaciones.estatus", new Integer(1)));
		medicamentoPresentaciones.add(Restrictions.eq("catIdiomaApp.idiomaAppId", dto.getIdIdioma()));


		medicamentoPresentaciones.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = medicamentoPresentaciones.list();

		return lista;
	}


	@Override
	public List<OpcionCatalogoComunDTO> obtenerCatGrupoTerapeutico(OpcionCatalogoComunDTO dto) {
		List<OpcionCatalogoComunDTO> lista;

		Criteria grupoTerapeutico = getCurrentSession().createCriteria(CatGrupoTerapeutico.class, "catGrupoTerapeutico").setProjection(Projections
				.projectionList()
				.add(Projections.property("catGrupoTerapeutico.grupoTerapeuticoId"), "idOpcion")
				.add(Projections.property("catGrupoTerapeutico.nombre"), "nombreOpcion"));

		grupoTerapeutico.createAlias("catGrupoTerapeutico.catIdiomaApp", "catIdiomaApp");

		grupoTerapeutico.add(Restrictions.eq("catGrupoTerapeutico.estatus", new Integer(1)));
		grupoTerapeutico.add(Restrictions.eq("catIdiomaApp.idiomaAppId", dto.getIdIdioma()));


		grupoTerapeutico.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = grupoTerapeutico.list();

		return lista;
	}


	@Override
	public List<OpcionCatalogoComunDTO> obtenerCatViaAdministracion(OpcionCatalogoComunDTO dto) {
		List<OpcionCatalogoComunDTO> lista;

		Criteria viaAdministracion = getCurrentSession().createCriteria(CatViaAdministracion.class, "catViaAdministracion").setProjection(Projections
				.projectionList()
				.add(Projections.property("catViaAdministracion.viaAdministracionId"), "idOpcion")
				.add(Projections.property("catViaAdministracion.nombre"), "nombreOpcion"));

		viaAdministracion.createAlias("catViaAdministracion.catIdiomaApp", "catIdiomaApp");

		viaAdministracion.add(Restrictions.eq("catViaAdministracion.estatus", new Integer(1)));
		viaAdministracion.add(Restrictions.eq("catIdiomaApp.idiomaAppId", dto.getIdIdioma()));


		viaAdministracion.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = viaAdministracion.list();

		return lista;
	}


	@Override
	public List<OpcionCatalogoComunDTO> obtenerCatUnidadMedidaDosis(OpcionCatalogoComunDTO dto) {
		List<OpcionCatalogoComunDTO> lista;

		Criteria UnidadMedidaDosis = getCurrentSession().createCriteria(CatUnidadMedidaDosis.class, "catUnidadMedidaDosis")
				.setProjection(Projections.projectionList()
						.add(Projections.property("catUnidadMedidaDosis.unidadMedidaDosisId"), "idOpcion")
						.add(Projections.property("catUnidadMedidaDosis.nombre"), "nombreOpcion"));

		UnidadMedidaDosis.createAlias("catUnidadMedidaDosis.catIdiomaApp", "catIdiomaApp");

		UnidadMedidaDosis.add(Restrictions.eq("catUnidadMedidaDosis.estatus",1));
		UnidadMedidaDosis.add(Restrictions.eq("catIdiomaApp.idiomaAppId", dto.getIdIdioma()));
		UnidadMedidaDosis.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));
		lista = UnidadMedidaDosis.list();
		return lista;
	}


	@Override
	public List<OpcionCatalogoComunDTO> obtenerCatSituacionEconomica(OpcionCatalogoComunDTO dto) {
		List<OpcionCatalogoComunDTO> lista;

		Criteria catSituacionEconomica = getCurrentSession().createCriteria(CatSituacionEconomica.class, "catSituacionEconomica").setProjection(Projections
				.projectionList()
				.add(Projections.property("catSituacionEconomica.situacionEconomicaId"), "idOpcion")
				.add(Projections.property("catSituacionEconomica.nombre"), "nombreOpcion"));

		catSituacionEconomica.createAlias("catSituacionEconomica.catIdiomaApp", "catIdiomaApp");

		catSituacionEconomica.add(Restrictions.eq("catSituacionEconomica.estatus", new Integer(1)));
		catSituacionEconomica.add(Restrictions.eq("catIdiomaApp.idiomaAppId", dto.getIdIdioma()));


		catSituacionEconomica.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = catSituacionEconomica.list();

		return lista;
	}


	@Override
	public List<OpcionCatalogoComunDTO> obtenerCatDondeSeAtiende(OpcionCatalogoComunDTO dto) {
		List<OpcionCatalogoComunDTO> lista;

		Criteria catDondeSeAtiende = getCurrentSession().createCriteria(CatDondeSeAtiende.class, "catDondeSeAtiende").setProjection(Projections
				.projectionList()
				.add(Projections.property("catDondeSeAtiende.dondeSeAtiendeId"), "idOpcion")
				.add(Projections.property("catDondeSeAtiende.nombre"), "nombreOpcion"));

		catDondeSeAtiende.createAlias("catDondeSeAtiende.catIdiomaApp", "catIdiomaApp");

		catDondeSeAtiende.add(Restrictions.eq("catDondeSeAtiende.estatus", new Integer(1)));
		catDondeSeAtiende.add(Restrictions.eq("catIdiomaApp.idiomaAppId", dto.getIdIdioma()));


		catDondeSeAtiende.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = catDondeSeAtiende.list();

		return lista;
	}


	@Override
	public List<OpcionCatalogoComunDTO> obtenerCatTipoEvento(OpcionCatalogoComunDTO dto) {
		List<OpcionCatalogoComunDTO> lista;

		Criteria catTipoEvento = getCurrentSession().createCriteria(CatTipoEvento.class, "catTipoEvento").setProjection(Projections
				.projectionList()
				.add(Projections.property("catTipoEvento.tipoEventoId"), "idOpcion")
				.add(Projections.property("catTipoEvento.nombre"), "nombreOpcion"));


		catTipoEvento.add(Restrictions.eq("catTipoEvento.status", new Integer(1)));


		catTipoEvento.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = catTipoEvento.list();

		return lista;
	}


	@Override
	public List<OpcionCatalogoComunDTO> obtenerCatDestinoPrestamoExp(OpcionCatalogoComunDTO dto) {
		List<OpcionCatalogoComunDTO> lista;

		Criteria catDestinoPrestamoExp = getCurrentSession().createCriteria(CatDestinoPrestamoExp.class, "catDestinoPrestamoExp").setProjection(Projections
				.projectionList()
				.add(Projections.property("catDestinoPrestamoExp.destinoPrestamoId"), "idOpcion")
				.add(Projections.property("catDestinoPrestamoExp.nombre"), "nombreOpcion"));


		catDestinoPrestamoExp.add(Restrictions.eq("catDestinoPrestamoExp.estatus", new Integer(1)));
		catDestinoPrestamoExp.add(Restrictions.eq("catDestinoPrestamoExp.idiomaAppId", dto.getIdIdioma()));


		catDestinoPrestamoExp.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = catDestinoPrestamoExp.list();

		return lista;
	}


	@Override
	public List<OpcionCatalogoComunDTO> obtenerCatTipoPrescripciones(OpcionCatalogoComunDTO dto) {
		List<OpcionCatalogoComunDTO> lista;

		Criteria tipoPrescripcion = getCurrentSession().createCriteria(CatTipoPrescripcion.class, "tPrescripciones").setProjection(
				Projections.projectionList()
						.add(Projections.property("tPrescripciones.tipoPrescripcionId"), "idOpcion")
						.add(Projections.property("tPrescripciones.nombre"), "nombreOpcion")
						.add(Projections.property("tPrescripciones.cve"), "cveOpcion")
						.add(Projections.property("tPrescripciones.descripcion"), "descripcionOpcion")
						.add(Projections.property("tPrescripciones.defaults"), "valorDefault")
						.add(Projections.property("tPrescripciones.estatus"), "statusOpcion")
						.add(Projections.property("idioma.idiomaAppId"), "idIdioma")
		);
		tipoPrescripcion.createAlias("tPrescripciones.catIdiomaAppByIdiomaAppId", "idioma");

		tipoPrescripcion.add(Restrictions.eq("tPrescripciones.estatus", new Integer(1)));
		tipoPrescripcion.add(Restrictions.eq("idioma.idiomaAppId", 1));

		tipoPrescripcion.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = tipoPrescripcion.list();
		return lista;
	}


	@Override
	public List<OpcionCatalogoComunDTO> obtenerCatUbicacionExpediente(OpcionCatalogoComunDTO dto) {
		List<OpcionCatalogoComunDTO> lista;

		Criteria catUbicacionExpediente = getCurrentSession().createCriteria(CatUbicacionExpediente.class, "catUbicacionExpediente").setProjection(Projections
				.projectionList()
				.add(Projections.property("catUbicacionExpediente.ubicacionExpedienteId"), "idOpcion")
				.add(Projections.property("catUbicacionExpediente.nombre"), "nombreOpcion"));

		catUbicacionExpediente.add(Restrictions.eq("catUbicacionExpediente.estatus", new Integer(1)));
		catUbicacionExpediente.add(Restrictions.eq("catIdiomaApp.idiomaAppId", dto.getIdIdioma()));
		catUbicacionExpediente.createAlias("catUbicacionExpediente.catIdiomaApp", "catIdiomaApp");

		catUbicacionExpediente.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = catUbicacionExpediente.list();

		return lista;
	}

	@Override
	public List<OpcionCatalogoComunDTO> obtenerCatEstatusPeticion(OpcionCatalogoComunDTO dto) {
		List<OpcionCatalogoComunDTO> lista;

		Criteria catEstatusPeticion = getCurrentSession().createCriteria(CatEstatusPeticion.class, "catEstatusPeticion").setProjection(Projections
				.projectionList()
				.add(Projections.property("catEstatusPeticion.estatusPeticionId"), "idOpcion")
				.add(Projections.property("catEstatusPeticion.nombre"), "nombreOpcion"));

		catEstatusPeticion.add(Restrictions.eq("catEstatusPeticion.estatus", new Integer(1)));
		catEstatusPeticion.add(Restrictions.eq("catEstatusPeticion.idiomaAppId", dto.getIdIdioma()));


		catEstatusPeticion.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = catEstatusPeticion.list();

		return lista;
	}


	@Override
	public List<OpcionCatalogoComunDTO> obtenerCatTipoUnidadReferencia(OpcionCatalogoComunDTO dto) {
		List<OpcionCatalogoComunDTO> lista;

		Criteria catTipoUnidadReferencia = getCurrentSession().createCriteria(CatTipoUnidadReferencia.class, "catTipoUnidadReferencia").setProjection(Projections
				.projectionList()
				.add(Projections.property("catTipoUnidadReferencia.tipoUnidadRefId"), "idOpcion")
				.add(Projections.property("catTipoUnidadReferencia.nombre"), "nombreOpcion"));

		catTipoUnidadReferencia.add(Restrictions.eq("catTipoUnidadReferencia.estatus", new Integer(1)));
		catTipoUnidadReferencia.add(Restrictions.eq("catIdiomaApp.idiomaAppId", dto.getIdIdioma()));
		catTipoUnidadReferencia.createAlias("catTipoUnidadReferencia.catIdiomaApp", "catIdiomaApp");

		catTipoUnidadReferencia.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = catTipoUnidadReferencia.list();

		return lista;
	}


	@Override
	public List<OpcionCatalogoComunDTO> obtenerCatTipoTrasladoReferencia(OpcionCatalogoComunDTO dto) {
		List<OpcionCatalogoComunDTO> lista;

		Criteria catTipoTrasladoReferencia = getCurrentSession().createCriteria(CatTipoTrasladoReferencia.class, "catTipoTrasladoReferencia").setProjection(Projections
				.projectionList()
				.add(Projections.property("catTipoTrasladoReferencia.tipoTrasladoReferenciaId"), "idOpcion")
				.add(Projections.property("catTipoTrasladoReferencia.nombre"), "nombreOpcion"));

		catTipoTrasladoReferencia.add(Restrictions.eq("catTipoTrasladoReferencia.estatus", new Integer(1)));
		catTipoTrasladoReferencia.add(Restrictions.eq("catIdiomaApp.idiomaAppId", dto.getIdIdioma()));
		catTipoTrasladoReferencia.createAlias("catTipoTrasladoReferencia.catIdiomaApp", "catIdiomaApp");

		catTipoTrasladoReferencia.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = catTipoTrasladoReferencia.list();

		return lista;
	}


	@Override
	public List<OpcionCatalogoComunDTO> obtenerCatMotivoEnvioReferencia(OpcionCatalogoComunDTO dto) {
		List<OpcionCatalogoComunDTO> lista;

		Criteria catMotivoEnvioReferencia = getCurrentSession().createCriteria(CatMotivoEnvioReferencia.class, "catMotivoEnvioReferencia").setProjection(Projections
				.projectionList()
				.add(Projections.property("catMotivoEnvioReferencia.motivoEnvioReferenciaId"), "idOpcion")
				.add(Projections.property("catMotivoEnvioReferencia.nombre"), "nombreOpcion"));

		catMotivoEnvioReferencia.add(Restrictions.eq("catMotivoEnvioReferencia.estatus", new Integer(1)));
		catMotivoEnvioReferencia.add(Restrictions.eq("catIdiomaApp.idiomaAppId", dto.getIdIdioma()));
		catMotivoEnvioReferencia.createAlias("catMotivoEnvioReferencia.catIdiomaApp", "catIdiomaApp");

		catMotivoEnvioReferencia.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = catMotivoEnvioReferencia.list();

		return lista;
	}

	@Override
	public List<OpcionCatalogoComunDTO> obtenerCatMotivoAnulacionNse(OpcionCatalogoComunDTO dto) {
		List<OpcionCatalogoComunDTO> lista;

		Criteria catMotivoEnvioReferencia = getCurrentSession().createCriteria(CatMotivoAnulacionNse.class, "catMotivoAnulacionNse").setProjection(Projections
				.projectionList()
				.add(Projections.property("catMotivoAnulacionNse.motivoAnulacionNseId"), "idOpcion")
				.add(Projections.property("catMotivoAnulacionNse.nombre"), "nombreOpcion"));

		catMotivoEnvioReferencia.add(Restrictions.eq("catMotivoAnulacionNse.estatus", new Integer(1)));
		catMotivoEnvioReferencia.add(Restrictions.eq("catIdiomaApp.idiomaAppId", dto.getIdIdioma()));
		catMotivoEnvioReferencia.createAlias("catMotivoAnulacionNse.catIdiomaApp", "catIdiomaApp");

		catMotivoEnvioReferencia.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = catMotivoEnvioReferencia.list();

		return lista;
	}

	@Override public List<OpcionCatalogoComunDTO> obtenerCatMotivoDescuento(OpcionCatalogoComunDTO dto) {
		List<OpcionCatalogoComunDTO> lista;

		Criteria motCancelacion = getCurrentSession().createCriteria(CatMotivoDescuento.class, "descuento").setProjection(
				Projections.projectionList()
						.add(Projections.property("descuento.motivoDescuentoId"), "idOpcion")
						.add(Projections.property("descuento.nombre"), "nombreOpcion")
						.add(Projections.property("descuento.cve"), "cveOpcion")
						.add(Projections.property("descuento.descripcion"), "descripcionOpcion")
						.add(Projections.property("descuento.valorDefault"), "valorDefault")
						.add(Projections.property("descuento.estatus"), "statusOpcion")
						.add(Projections.property("idioma.idiomaAppId"), "idIdioma")
		);
		motCancelacion.createAlias("descuento.catIdiomaAppByIdiomaAppId", "idioma");

		motCancelacion.add(Restrictions.eq("descuento.estatus", new Integer(1)));
		motCancelacion.add(Restrictions.eq("idioma.idiomaAppId", 1));

		motCancelacion.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = motCancelacion.list();
		return lista;
	}

	@Override public List<OpcionCatalogoComunDTO> obtenerCatTipoArchivo(OpcionCatalogoComunDTO dto) {
		List<OpcionCatalogoComunDTO> lista;

		Criteria catMotivoEnvioReferencia = getCurrentSession().createCriteria(CatTipoArchivo.class, "catTipoArchivo").setProjection(Projections
				.projectionList()
				.add(Projections.property("catTipoArchivo.tipoArchivoId"), "idOpcion")
				.add(Projections.property("catTipoArchivo.nombre"), "nombreOpcion")
				.add(Projections.property("catTipoArchivo.cve"), "cveOpcion"));

		catMotivoEnvioReferencia.add(Restrictions.eq("catTipoArchivo.estatus", new Integer(1)));
		catMotivoEnvioReferencia.add(Restrictions.eq("catIdiomaApp.idiomaAppId", dto.getIdIdioma()));
		catMotivoEnvioReferencia.createAlias("catTipoArchivo.catIdiomaAppByIdiomaAppId", "catIdiomaApp");

		catMotivoEnvioReferencia.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = catMotivoEnvioReferencia.list();

		return lista;
	}

//	@Override public List<OpcionCatalogoComunDTO> obtenerCatAnestesia(OpcionCatalogoComunDTO dto) {
//		List<OpcionCatalogoComunDTO> lista;
//
//		Criteria catAnestesia = getCurrentSession().createCriteria(.class, "catAnestesia").setProjection(Projections
//				.projectionList()
//				.add(Projections.property("catAnestesia.anestesiaId"), "idOpcion")
//				.add(Projections.property("catAnestesia.nombre"), "nombreOpcion"));
//
//		catAnestesia.add(Restrictions.eq("catAnestesia.estatus", new Integer(1)));
//		catAnestesia.add(Restrictions.eq("catIdiomaApp.idiomaAppId", dto.getIdIdioma()));
//		catAnestesia.createAlias("catAnestesia.catIdiomaApp", "catIdiomaApp");
//
//		catAnestesia.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));
//
//		lista = catAnestesia.list();
//
//		return lista;
//	}
//
//	@Override public List<OpcionCatalogoComunDTO> obtenerCatBeneficiosAnestesia(OpcionCatalogoComunDTO dto) {
//		List<OpcionCatalogoComunDTO> lista;
//
//		Criteria catBeneficiosAnestesia = getCurrentSession().createCriteria(CatBeneficiosAnestesia.class, "catBeneficiosAnestesia").setProjection(Projections
//				.projectionList()
//				.add(Projections.property("catBeneficiosAnestesia.beneficiosAnestesiaId"), "idOpcion")
//				.add(Projections.property("catBeneficiosAnestesia.nombre"), "nombreOpcion"));
//
//		catBeneficiosAnestesia.add(Restrictions.eq("catBeneficiosAnestesia.estatus", new Integer(1)));
//		catBeneficiosAnestesia.add(Restrictions.eq("catIdiomaApp.idiomaAppId", dto.getIdIdioma()));
//		catBeneficiosAnestesia.createAlias("catBeneficiosAnestesia.catIdiomaApp", "catIdiomaApp");
//
//		catBeneficiosAnestesia.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));
//
//		lista = catBeneficiosAnestesia.list();
//
//		return lista;
//	}

	@Override public List<OpcionCatalogoComunDTO> obtenerGusModulos() {
		List<OpcionCatalogoComunDTO> lista;

		Criteria gusModulos = getCurrentSession().createCriteria(GusModulos.class, "gusModulos").setProjection(Projections
				.projectionList()
				.add(Projections.property("gusModulos.gusModuloId"), "idOpcion")
				.add(Projections.property("gusModulos.nombre"), "nombreOpcion"));

		gusModulos.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));
		gusModulos.add(Restrictions.gt("gusModulos.gusModuloId", new Integer(1)));
		lista = gusModulos.list();

		return lista;
	}

	@Override
	public List<OpcionCatalogoComunDTO> listarOpcionesCatalogoGenerico(OpcionCatalogoComunDTO dto) {
		Query query = getCurrentSession().createSQLQuery("" +
						"SELECT " +
						"	" + this.obtenNombreIdCatalogoGenerico(dto.getNombreCatalogo()) + " as idOpcion, " +
						"	NOMBRE as nombreOpcion " +
						"FROM " + dto.getNombreCatalogo().toLowerCase() + " " +
						"WHERE ESTATUS = 1 " +
						"  AND IDIOMA_APP_ID = :p_idIdioma"
				)
				.addScalar("idOpcion", StandardBasicTypes.INTEGER)
				.addScalar("nombreOpcion", StandardBasicTypes.STRING)

				.setParameter("p_idIdioma", dto.getIdIdioma())
				.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		return query.list();
	}
	@Override
	public List<OpcionCatalogoComunDTO> listarOpcionesProNac() {
		Criteria query = getCurrentSession().createCriteria(NomCatProcedimientoNac.class, "procNac").setProjection(Projections.projectionList()
				.add(Projections.property("procedimientoNacId"), "idOpcion")
				.add(Projections.property("cve"), "cveOpcion")
				.add(Projections.property("nombre"), "nombreOpcion")
				.add(Projections.property("descripcion"), "descripcionOpcion")
				.add(Projections.property("estatus"), "valorDefault")
		);

		query.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		return query.list();
	}

	@Override
	public String obtenerNombreCatalogoGenerico(OpcionCatalogoComunDTO dto) {

		Query query =
				getCurrentSession().createSQLQuery(QRY_CATALGOS_GENERICOS)
						.addScalar("name", StandardBasicTypes.STRING);
		query.setParameter("p_idCatalogo" , dto.getIdOpcion());


		query.setResultTransformer(Transformers.aliasToBean(CatalogoDTO.class));
		CatalogoDTO tmp = (CatalogoDTO) query.uniqueResult();
		return (null != tmp)?tmp.getName():"";
	}

	@Override public List<OpcionCatalogoComunDTO> listarCatPreIngresoPrioridad(OpcionCatalogoComunDTO dto) {
		List<OpcionCatalogoComunDTO> lista;

		Criteria catPreIngresoPrioridad = getCurrentSession().createCriteria(CatPreIngresoPrioridad.class, "catPreIngresoPrioridad").setProjection(Projections
				.projectionList()
				.add(Projections.property("catPreIngresoPrioridad.preIngresoPrioridadId"), "idOpcion")
				.add(Projections.property("catPreIngresoPrioridad.nombre"), "nombreOpcion"));

		catPreIngresoPrioridad.add(Restrictions.eq("catPreIngresoPrioridad.estatus", new Integer(1)));
		catPreIngresoPrioridad.add(Restrictions.eq("catIdiomaApp.idiomaAppId", dto.getIdIdioma()));
		catPreIngresoPrioridad.createAlias("catPreIngresoPrioridad.catIdiomaApp", "catIdiomaApp");

		catPreIngresoPrioridad.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = catPreIngresoPrioridad.list();

		return lista;
	}

	@Override public List<OpcionCatalogoComunDTO> listarCatMotivoIngreso(OpcionCatalogoComunDTO dto) {
		List<OpcionCatalogoComunDTO> lista;

		Criteria catMotivoIngreso = getCurrentSession().createCriteria(CatMotivoIngreso.class, "catMotivoIngreso").setProjection(Projections
				.projectionList()
				.add(Projections.property("catMotivoIngreso.motivoIngresoId"), "idOpcion")
				.add(Projections.property("catMotivoIngreso.nombre"), "nombreOpcion"));

		catMotivoIngreso.add(Restrictions.eq("catMotivoIngreso.estatus", new Integer(1)));
		catMotivoIngreso.add(Restrictions.eq("catIdiomaApp.idiomaAppId", dto.getIdIdioma()));
		catMotivoIngreso.createAlias("catMotivoIngreso.catIdiomaApp", "catIdiomaApp");

		catMotivoIngreso.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = catMotivoIngreso.list();

		return lista;
	}

	@Override public List<OpcionCatalogoComunDTO> listarCatTipoIngresoHosp(OpcionCatalogoComunDTO dto) {
		List<OpcionCatalogoComunDTO> lista;

		Criteria catTipoIngresoHosp = getCurrentSession().createCriteria(CatTipoIngresoHosp.class, "catTipoIngresoHosp").setProjection(Projections
				.projectionList()
				.add(Projections.property("catTipoIngresoHosp.tipoIngresoHospId"), "idOpcion")
				.add(Projections.property("catTipoIngresoHosp.nombre"), "nombreOpcion"));

		catTipoIngresoHosp.add(Restrictions.eq("catTipoIngresoHosp.estatus", new Integer(1)));
		catTipoIngresoHosp.add(Restrictions.eq("catIdiomaApp.idiomaAppId", dto.getIdIdioma()));
		catTipoIngresoHosp.createAlias("catTipoIngresoHosp.catIdiomaApp", "catIdiomaApp");

		catTipoIngresoHosp.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = catTipoIngresoHosp.list();

		return lista;
	}

	@Override public List<OpcionCatalogoComunDTO> listarCatHspProcedencia(OpcionCatalogoComunDTO dto) {
		List<OpcionCatalogoComunDTO> lista;

		Criteria catHspProcedencia = getCurrentSession().createCriteria(CatHspProcedencia.class, "catHspProcedencia").setProjection(Projections
				.projectionList()
				.add(Projections.property("catHspProcedencia.hspProcedenciaId"), "idOpcion")
				.add(Projections.property("catHspProcedencia.nombre"), "nombreOpcion"));

		catHspProcedencia.add(Restrictions.eq("catHspProcedencia.estatus", new Integer(1)));
		catHspProcedencia.add(Restrictions.eq("catIdiomaApp.idiomaAppId", dto.getIdIdioma()));
		catHspProcedencia.createAlias("catHspProcedencia.catIdiomaApp", "catIdiomaApp");

		catHspProcedencia.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = catHspProcedencia.list();

		return lista;
	}

	@Override public List<OpcionCatalogoComunDTO> listarEstadoProc() {
		List<OpcionCatalogoComunDTO> lista;

		Criteria estadoProc = getCurrentSession().createCriteria(NomCatEstadoProc.class, "estadoProc").setProjection(Projections
				.projectionList()
				.add(Projections.property("estadoProcId"), "idOpcion")
				.add(Projections.property("nombre"), "nombreOpcion"));

		estadoProc.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = estadoProc.list();

		return lista;
	}

	@Override public List<OpcionCatalogoComunDTO> listarHepatitisB() {
		List<OpcionCatalogoComunDTO> lista;

		Criteria hepatitisB = getCurrentSession().createCriteria(NomCatHepatitisB.class, "hepatitisB").setProjection(Projections
				.projectionList()
				.add(Projections.property("hepatitisBId"), "idOpcion")
				.add(Projections.property("descripcion"), "nombreOpcion"));

		hepatitisB.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = hepatitisB.list();

		return lista;
	}

	@Override public List<OpcionCatalogoComunDTO> listarVitaminaK() {
		List<OpcionCatalogoComunDTO> lista;

		Criteria vitaminaK = getCurrentSession().createCriteria(NomCatVitaminaK.class, "vitaminaK").setProjection(Projections
				.projectionList()
				.add(Projections.property("vitaminaKId"), "idOpcion")
				.add(Projections.property("descripcion"), "nombreOpcion"));

		vitaminaK.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = vitaminaK.list();

		return lista;
	}

	@Override public List<OpcionCatalogoComunDTO> listarVitaminaA() {
		List<OpcionCatalogoComunDTO> lista;

		Criteria vitaminaA = getCurrentSession().createCriteria(NomCatVitaminaA.class, "vitaminaA").setProjection(Projections
				.projectionList()
				.add(Projections.property("vitaminaAId"), "idOpcion")
				.add(Projections.property("descripcion"), "nombreOpcion"));

		vitaminaA.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = vitaminaA.list();

		return lista;
	}

	@Override public List<OpcionCatalogoComunDTO> listarTamizAuditivo() {
		List<OpcionCatalogoComunDTO> lista;

		Criteria tamizAuditivo = getCurrentSession().createCriteria(NomCatTamizAuditivo.class, "tamizAuditivo").setProjection(Projections
				.projectionList()
				.add(Projections.property("tamizAuditivoId"), "idOpcion")
				.add(Projections.property("descripcion"), "nombreOpcion"));

		tamizAuditivo.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = tamizAuditivo.list();

		return lista;
	}

	@Override public List<OpcionCatalogoComunDTO> listarVacunaBcg() {
		List<OpcionCatalogoComunDTO> lista;

		Criteria vacunaBcg = getCurrentSession().createCriteria(NomCatVacunaBcg.class, "vacunaBcg").setProjection(Projections
				.projectionList()
				.add(Projections.property("vacunaBcgId"), "idOpcion")
				.add(Projections.property("descripcion"), "nombreOpcion"));

		vacunaBcg.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = vacunaBcg.list();

		return lista;
	}

	@Override public List<OpcionCatalogoComunDTO> listarNomCatAtencionPrenatal() {
		List<OpcionCatalogoComunDTO> lista;

		Criteria nomCatAtencionPrenatal = getCurrentSession().createCriteria(NomCatAtencionPrenatal.class, "nomCatAtencionPrenatal").setProjection(Projections
				.projectionList()
				.add(Projections.property("atencionPrenatalId"), "idOpcion")
				.add(Projections.property("descripcion"), "nombreOpcion"));

		nomCatAtencionPrenatal.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = nomCatAtencionPrenatal.list();

		return lista;
	}

	@Override public List<OpcionCatalogoComunDTO> listarNomCatViveMadre() {
		List<OpcionCatalogoComunDTO> lista;

		Criteria nomCatViveMadre = getCurrentSession().createCriteria(NomCatViveMadre.class, "nomCatViveMadre").setProjection(Projections
				.projectionList()
				.add(Projections.property("viveMadreId"), "idOpcion")
				.add(Projections.property("descripcion"), "nombreOpcion"));

		nomCatViveMadre.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = nomCatViveMadre.list();

		return lista;
	}

	@Override public List<OpcionCatalogoComunDTO> listarCircunDefun() {

		Criteria circun = getCurrentSession().createCriteria(NomCatCircunDefuncion.class, "circun").setProjection(Projections
				.projectionList()
				.add(Projections.property("circun.circunstaciaDefuncionId"), "idOpcion")
				.add(Projections.property("circun.nombre"), "nombreOpcion"));
		circun.add(Restrictions.eq("circun.estatus", new Integer(1)));
		circun.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		return circun.list();

	}

	@Override
	public List<OpcionCatalogoComunDTO> listarTipoVisita(OpcionCatalogoComunDTO dto) {
		List<OpcionCatalogoComunDTO> lista;

		Criteria catTipoVisita = getCurrentSession().createCriteria(CatTipoVisita.class, "catTipoVisita").setProjection(Projections
				.projectionList()
				.add(Projections.property("catTipoVisita.tipoVisitaId"), "idOpcion")
				.add(Projections.property("catTipoVisita.nombre"), "nombreOpcion"));

		catTipoVisita.add(Restrictions.eq("catTipoVisita.estatus", new Integer(1)));
		catTipoVisita.add(Restrictions.eq("catIdiomaApp.idiomaAppId", dto.getIdIdioma()));
		catTipoVisita.createAlias("catTipoVisita.catIdiomaApp", "catIdiomaApp");

		catTipoVisita.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));

		lista = catTipoVisita.list();

		return lista;
	}

	public String obtenNombreIdCatalogoGenerico(String nombreCatalogo){

		String strIdCatalogo = "";
		strIdCatalogo = nombreCatalogo.replaceAll("CAT_", "");
		strIdCatalogo = strIdCatalogo.replaceAll("NOM_", "");
		strIdCatalogo = strIdCatalogo + "_ID";

		return strIdCatalogo;
	}




}
