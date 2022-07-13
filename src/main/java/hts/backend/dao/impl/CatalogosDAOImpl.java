package hts.backend.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hts.backend.dao.CatalogosDAO;
import hts.backend.entity.CatProcedencia;
import hts.backend.entity.CatTipoSangre;
import hts.backend.entity.CatVialidad;
import hts.backend.entity.NomCatCodigoPostal;
import hts.backend.entity.NomCatEntidades;
import hts.backend.entity.NomCatEscolaridad;
import hts.backend.entity.NomCatEstadoCivil;
import hts.backend.entity.NomCatLocalidad;
import hts.backend.entity.NomCatMunicipio;
import hts.backend.entity.NomCatNacionalidades;
import hts.backend.entity.NomCatOcupacion;
import hts.backend.entity.NomCatPaises;
import hts.backend.entity.NomCatReligion;
import hts.backend.entity.NomCatSino;
import hts.backend.entity.NomCatTipoLenguaIndigena;
import hts.backend.model.dto.CatProcedenciaDTO;
import hts.backend.model.dto.CatTipoAsenDTO;
import hts.backend.model.dto.CatTipoSangreDTO;
import hts.backend.model.dto.CatVialidadDTO;
import hts.backend.model.dto.CatalogoDTO;
import hts.backend.model.dto.EntidadCPDTO;
import hts.backend.model.dto.FactorRHDTO;
import hts.backend.model.dto.MunicipioCPDTO;
import hts.backend.model.dto.NomCatCodigoPostalDTO;
import hts.backend.model.dto.NomCatEntidadesDTO;
import hts.backend.model.dto.NomCatEscolaridadDTO;
import hts.backend.model.dto.NomCatEstadoCivilDTO;
import hts.backend.model.dto.NomCatLocalidadDTO;
import hts.backend.model.dto.NomCatMunicipioDTO;
import hts.backend.model.dto.NomCatNacionalidadesDTO;
import hts.backend.model.dto.NomCatOcupacionDTO;
import hts.backend.model.dto.NomCatPaisesDTO;
import hts.backend.model.dto.NomCatReligionDTO;
import hts.backend.model.dto.NomCatSexoDTO;
import hts.backend.model.dto.NomCatSinoDTO;
import hts.backend.model.dto.NomCatTipoLenguaIndigenaDTO;


@Repository("catalogosDAO")
@Transactional
public class CatalogosDAOImpl extends GenericHibernateDAOImpl implements CatalogosDAO {
	
private static final Logger logger = LoggerFactory.getLogger(CatalogosDAOImpl.class);
	
	String QRY_CATALOGO_TIPO_BENEFICIARO = "SELECT TIPO_BENEFICIARIO_ID as id, descripcion as name FROM cat_tipo_beneficiario WHERE estatus = 1";
	
	/**
	 * Metodo para ejecutar la consulta a un catalogo y obtener una respuesta generica idOpcion , descripcion para llenar los caombos en el front
	 *
	 * @param queryCatalogo
	 *
	 * @return
	 */
	public List<CatalogoDTO> ejecutaQueryGenericoCatalogos(String queryCatalogo) {
		Session s = getCurrentSession();
		Query query =
				s.createSQLQuery(queryCatalogo)
						.addScalar("id", StandardBasicTypes.INTEGER)
						.addScalar("name", StandardBasicTypes.STRING);
		query.setResultTransformer(Transformers.aliasToBean(CatalogoDTO.class));

		var r = query.list();
		s.close();
		return r;
	}

	
	/**
	 * Metodo para ejecutar la consulta a un catalogo y obtener una respuesta generica id , name
	 * para llenar los combos en el front e indicar un valor seleccionado por default
	 *
	 * @param queryCatalogo
	 *
	 * @return
	 */
	public List<CatalogoDTO> ejecutaQueryGenericoCatalogosDefault(String queryCatalogo) {
		Session s = getCurrentSession();
		Query query = s.createSQLQuery(queryCatalogo)
				.addScalar("id", StandardBasicTypes.INTEGER)
				.addScalar("name", StandardBasicTypes.STRING)
				.addScalar("indicaDefault", StandardBasicTypes.INTEGER);
		query.setResultTransformer(Transformers.aliasToBean(CatalogoDTO.class));

		var r = query.list();
		s.close();
		return r;
	}

	@Override
	public List<NomCatPaisesDTO> listaPaises() {
		List<NomCatPaisesDTO> lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl listaPaises ##################");

		try {
			Session s = getCurrentSession();
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
			Session s = getCurrentSession();
			Criteria unidad = s.createCriteria(NomCatEntidades.class, "entidades").setProjection(Projections
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

			unidad.setResultTransformer(Transformers.aliasToBean(NomCatEntidadesDTO.class));
			lista = unidad.list();
			s.close();
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
			Session s = getCurrentSession();
			Criteria unidad = s.createCriteria(NomCatMunicipio.class, "municipio").setProjection(Projections
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
			s.close();
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
			Session s = getCurrentSession();
			Criteria unidad = s.createCriteria(NomCatLocalidad.class, "localidad").setProjection(Projections
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
			s.close();
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
			Session s = getCurrentSession();
			Criteria unidad = s.createCriteria(NomCatCodigoPostal.class, "cpostal").setProjection(Projections
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
			s.close();
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
			Session s = getCurrentSession();
			Criteria unidad = s.createCriteria(NomCatNacionalidades.class, "nacion").setProjection(Projections
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
			s.close();
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

		Session s = getCurrentSession();
		Query query = s.createSQLQuery(QRY_TIPO_ASEN)
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
		
		var r = query.list();
		s.close();
		return r;
	}

	@Override
	public List<CatVialidadDTO> listaVialidad() {
		List<CatVialidadDTO> lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl listaVialidad ##################");

		try {
			Session s = getCurrentSession();
			Criteria unidad = s.createCriteria(CatVialidad.class, "asenta").setProjection(Projections
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
			s.close();
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
			// language=HQL
			String SQL_SEXOS =
					"SELECT sex.sexoId AS sexoId, " +
							"sex.descripcion AS descripcion, " +
							"CASE WHEN sex.sexoId = 1 THEN 'MUJER' WHEN sex.sexoId = 2 THEN 'HOMBRE' END AS sexo, " +
							"sex.fechaRegistro AS fechaRegistro, " +
							"sex.indicaDefault AS indicaDefault, " +
							"sex.estatus AS estatus, " +
							"sex.noUsuario AS noUsuario " +
							"FROM NomCatSexo sex " +
							"WHERE sex.estatus = 1 " +
							"ORDER BY indicaDefault DESC, descripcion ASC ";
			
			Session s = getCurrentSession();
			Query query = s.createQuery(SQL_SEXOS)
					.setResultTransformer(Transformers.aliasToBean(NomCatSexoDTO.class));

			lista = query.list();
			s.close();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al recuperar listaSexo ", e);
		}

		return lista;
	}


	@Override
	public List<NomCatSexoDTO> listaSexoResumen() {
		List<NomCatSexoDTO> lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl listaSexo ##################");

		try {
			// language=HQL
			String SQL_SEXOS =
					"SELECT sex.sexoId AS sexoId, " +
							"sex.descripcion AS descripcion, " +
							"sex.sexNombre AS sexo, " +
							"sex.fechaRegistro AS fechaRegistro, " +
							"sex.indicaDefault AS indicaDefault, " +
							"sex.estatus AS estatus, " +
							"sex.noUsuario AS noUsuario " +
							"FROM NomCatSexo sex " +
							"WHERE sex.estatus = 1 " +
							"ORDER BY indicaDefault DESC, descripcion ASC ";
			
			Session s = getCurrentSession();
			Query query = s.createQuery(SQL_SEXOS)
					.setResultTransformer(Transformers.aliasToBean(NomCatSexoDTO.class));

			lista = query.list();
			s.close();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al recuperar listaSexo ", e);
		}

		return lista;
	}


	@Override
	public List<NomCatReligionDTO> listaReligion() {
		List<NomCatReligionDTO> lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl listaReligion ##################");

		try {
			Session s = getCurrentSession();
			Criteria unidad = s.createCriteria(NomCatReligion.class, "creligion").setProjection(Projections
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
			s.close();
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
			Session s = getCurrentSession();
			Criteria unidad = s.createCriteria(NomCatEstadoCivil.class, "cEstadoCivil").setProjection(Projections
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
			s.close();
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
			Session s = getCurrentSession();
			Criteria unidad = s.createCriteria(NomCatOcupacion.class, "cOcupacion").setProjection(Projections
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
			s.close();
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
			Session s = getCurrentSession();
			Criteria unidad = s.createCriteria(NomCatEscolaridad.class, "cEscolaridad").setProjection(Projections
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
			s.close();
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
			Session s = getCurrentSession();
			Criteria unidad = s.createCriteria(NomCatTipoLenguaIndigena.class, "cLenguaIndigena").setProjection(Projections
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
			s.close();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al recuperar listaTipoLenguaIndigena ", e);
		}

		return lista;
	}


	@Override
	public List<NomCatSinoDTO> listaSiNo(NomCatSinoDTO dto) {
		List<NomCatSinoDTO> lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl listaTrabajaActualmente ##################");

		try {
			Session s = getCurrentSession();
			Criteria unidad = s.createCriteria(NomCatSino.class, "cProcedencia").setProjection(Projections
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
			s.close();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al recuperar listaTrabajaActualmente ", e);
		}

		return lista;
	}


	@Override
	public List<CatalogoDTO> obtenerCatalogoTipoBeneficiario() {
		return ejecutaQueryGenericoCatalogos(QRY_CATALOGO_TIPO_BENEFICIARO);
	}


	@Override
	public MunicipioCPDTO obtenerMunicipioPorCodigoPostal(String codigoPostal) {
		MunicipioCPDTO lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl obtenerMunicipioPorCodigoPostal ##################");

		try {
			String SQL_MUNICIPIO =
					"SELECT catMunicipioId AS idMunicipio, descripcion AS nombre "
					+ "FROM NomCatMunicipio WHERE "
					+ "cveEnt = (SELECT CEstado FROM NomCatCodigoPostal WHERE "
					+ "nombre = :cp) AND cveMun = (SELECT CMunicipio FROM NomCatCodigoPostal "
					+ "WHERE nombre = :cp)";
			
			Session s = getCurrentSession();
			Query query = s.createQuery(SQL_MUNICIPIO);
			query.setParameter("cp", codigoPostal);
			query.setResultTransformer(Transformers.aliasToBean(MunicipioCPDTO.class));

			lista = (MunicipioCPDTO) query.uniqueResult();
			s.close();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al recuperar obtenerMunicipioPorCodigoPostal", e);
		}

		return lista;
	}


	@Override
	public EntidadCPDTO obtenerUbicacionPorCodigoPostal(String codigoPostal) {
		EntidadCPDTO lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl ubicacion ##################");

		try {
			String SQL_UBICACION =
					"SELECT catEntidadesId AS idEntidad, descripcion AS entidad "
					+ "FROM NomCatEntidades "
					+ "WHERE cve = (SELECT CEstado FROM NomCatCodigoPostal "
					+ "WHERE nombre = :cp)";
			
			Session s = getCurrentSession();
			Query query = s.createQuery(SQL_UBICACION);
			query.setParameter("cp", codigoPostal);
			query.setResultTransformer(Transformers.aliasToBean(EntidadCPDTO.class));

			lista = (EntidadCPDTO) query.uniqueResult();
			s.close();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al recuperar ubicacion ", e);
		}

		return lista;
	}
	
	@Override
	public List<CatProcedenciaDTO> listaProcedencia() {
		List<CatProcedenciaDTO> lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl listaProcedencia ##################");

		try {
			Session s = getCurrentSession();
			Criteria unidad = s.createCriteria(CatProcedencia.class, "cProcedencia").setProjection(Projections
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
			s.close();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al recuperar listaProcedencia ", e);
		}

		return lista;
	}
	
	
	@Override
	public List<CatTipoSangreDTO> listaTipoSangre() {
		List<CatTipoSangreDTO> lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl listaTipoSangre ##################");

		try {
			Session s = getCurrentSession();
			Criteria unidad = s.createCriteria(CatTipoSangre.class, "csangre").setProjection(Projections
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
			s.close();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al recuperar listaTipoSangre ", e);
		}

		return lista;
	}



	@Override
	public List<FactorRHDTO> listaFactorRH() {
		List<FactorRHDTO> lista;
		logger.info("##################  invocando a DAO CatalogosDAOImpl listaFactorRH ##################");

		try {
			String SQL_FACTORRH =
					"SELECT idFactorRH as idFactorRH, cveFactorRH as cveFactorRH, descripcion as descripcion  FROM CatFactorRH";
			
			Session s = getCurrentSession();
			Query query = s.createQuery(SQL_FACTORRH);
			query.setResultTransformer(Transformers.aliasToBean(FactorRHDTO.class));

			lista = query.list();
			s.close();
		} catch (Exception e) {
			lista = null;
			logger.info("########### Ocurrio un error al recuperar listaFactorRH", e);
		}

		return lista;
	}
}
