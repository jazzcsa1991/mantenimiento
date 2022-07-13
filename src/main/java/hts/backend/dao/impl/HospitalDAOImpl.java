package hts.backend.dao.impl;

import org.hibernate.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hts.backend.dao.HospitalDAO;
import hts.backend.entity.AdmHospital;


import hts.backend.dao.HospitalDAO;
import hts.backend.model.dto.DirecctorioDTO;
import hts.backend.model.dto.CatalogoDTO;
import hts.backend.model.dto.OpcionCatalogoComunDTO;
import hts.backend.model.dto.CatalogosDTO;
import hts.backend.model.dto.HospitalCluesDTO;
import hts.backend.model.dto.HospitalDTO;
import hts.backend.entity.HospitalPerfil;
import hts.backend.entity.HospitalPerfilId;
import hts.backend.entity.*;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository("hospitalDAO")
@SuppressWarnings("unchecked")
public class HospitalDAOImpl extends BaseDAOImpl implements HospitalDAO {

	private static final Logger logger = LoggerFactory.getLogger(HospitalDAOImpl.class);

	@Override
	public List<HospitalCluesDTO> buscaHospital(HospitalCluesDTO nombreInstitucionSalud) {
		logger.debug("Consulta AdmHospital buscaHospital ");
		// language=MySQL
		String QRY_CATALOGO_CLUES =
				"SELECT NOMBRE_UNIDAD               AS nombreUnidad, " +
						" NOMBRE_INSTITUCION_SALUD    AS nombreInstitucionSalud, " +
						" ID_CLUES                    AS idClues, " +
						" CLUES                       AS clues, " +
						" CVE_INSTITUCION_SALUD       AS cveInstitucionSalud, " +
						" NUMERO_INTERIOR             AS numeroInterior, " +
						" NUMERO_EXTERIOR             AS numeroExterior, " +
						" CVE_ENTIDAD                 AS cveEntidad, " +
						" CVE_MUNICIPIO               AS cveMunicipio, " +
						" ASENTAMIENTO                     AS colonia, " +
						" CVE_LOCALIDAD               AS cveLocalidad, " +
						" CODIGO_POSTAL               AS codigoPostal, " +
						" CVE_JURISDICCION            AS cveJurisdiccion, " +
						" NOMBRE_JURISDICCION         AS nombreJurisdiccion, " +
						" VIALIDAD                   AS domicilio, " +
						" NOMBRE_TIPO_ESTABLECIMIENTO AS nombreTipoEstablecimiento, " +

						" ESTATUS_OPERACION              AS estatusUnidad, " +
						" NIVEL_ATENCION              AS nivelAtencion, " +
						" NOMBRE_TIPO_ESTABLECIMIENTO AS nombreTipoEstablecimiento, " +
						" NOMBRE_LOCALIDAD            AS nombreLocalidad, " +
						" NOMBRE_MUNICIPIO            AS nombreMunicipio, " +
						" NOMBRE_ENTIDAD              AS nombreEntidad " +
						"FROM nom_cat_clues " +
						"WHERE NOMBRE_UNIDAD LIKE '%p_nombreHospital%' ";

		String tmp = QRY_CATALOGO_CLUES.replace("p_nombreHospital", nombreInstitucionSalud.getNombreInstitucionSalud());


		Query query =
				session().createSQLQuery(tmp)
						.addScalar("nombreUnidad", StandardBasicTypes.STRING)
						.addScalar("nombreInstitucionSalud", StandardBasicTypes.STRING)
						.addScalar("cveInstitucionSalud", StandardBasicTypes.STRING)
						.addScalar("idClues", StandardBasicTypes.STRING)
						.addScalar("clues", StandardBasicTypes.STRING)
						.addScalar("numeroInterior", StandardBasicTypes.STRING)
						.addScalar("numeroExterior", StandardBasicTypes.STRING)
						.addScalar("cveEntidad", StandardBasicTypes.STRING)
						.addScalar("cveMunicipio", StandardBasicTypes.STRING)
						.addScalar("colonia", StandardBasicTypes.STRING)
						.addScalar("cveLocalidad", StandardBasicTypes.STRING)
						.addScalar("codigoPostal", StandardBasicTypes.STRING)
						.addScalar("cveJurisdiccion", StandardBasicTypes.STRING)
						.addScalar("nombreJurisdiccion", StandardBasicTypes.STRING)
						.addScalar("domicilio", StandardBasicTypes.STRING)
						.addScalar("estatusUnidad", StandardBasicTypes.STRING)
						.addScalar("nivelAtencion", StandardBasicTypes.STRING)
						.addScalar("nombreTipoEstablecimiento", StandardBasicTypes.STRING)
						.addScalar("nombreLocalidad", StandardBasicTypes.STRING)
						.addScalar("nombreMunicipio", StandardBasicTypes.STRING)
						.addScalar("nombreEntidad", StandardBasicTypes.STRING)
						.addScalar("nombreTipoEstablecimiento", StandardBasicTypes.STRING);

		query.setResultTransformer(Transformers.aliasToBean(HospitalCluesDTO.class));

		return query.list();
	}

	@Override
	public int guardarHospital(HospitalDTO hospitaldto) {
		int exito = 0;
		try {

			AdmHospital hospital = this.obtenerCatHospital(hospitaldto);
			List<OpcionCatalogoComunDTO> lista = obtenerCatPerfil();
			this.save(hospital);
			this.flush();
			for (OpcionCatalogoComunDTO item : lista) {

				HospitalPerfil entidad = new HospitalPerfil();
				HospitalPerfilId entidadID = new HospitalPerfilId();
				entidadID.setHospitalId(hospital.getHospitalId());
				entidadID.setPerfilId(item.getIdOpcion());
				entidad.setId(entidadID);
				this.save(entidad);
				this.flush();
				logger.info("perfil--->" + item.getIdOpcion() + " idhospita--->" + hospital.getHospitalId());
			}
			exito = hospital.getHospitalId();
		} catch (Exception e) {
			logger.info("########### Ocurrio un error al guardar ", e);
			exito = 0;
		}

		return exito;
	}


	@Override
	public int editaCatHospital(HospitalDTO hospitaldto) {
		int exito = 0;
		try {
			Criteria ct = session().createCriteria(AdmHospital.class);
			ct.add(Restrictions.eq("hospitalId", hospitaldto.getHospitalId()));

			AdmHospital hospital = (AdmHospital) ct.uniqueResult();

			hospital.setCveCtaInstSalud(hospitaldto.getCveCtaInstSalud());
			hospital.setNombre(hospitaldto.getNombre());
			hospital.setClueId(hospitaldto.getClueId());
			hospital.setCveInstSalud(hospitaldto.getCveInstSalud());
			hospital.setCalle(hospitaldto.getCalle());
			hospital.setNoInt(hospitaldto.getNoInt());
			hospital.setNoExt(hospitaldto.getNoExt());
			hospital.setNoIntLetra(hospitaldto.getNoIntLetra());
			hospital.setNoExtLetra(hospitaldto.getNoExtLetra());
			hospital.setEstadoCve(hospitaldto.getEstadoCve());
			hospital.setMunicipioCve(hospitaldto.getMunicipioCve());
			hospital.setColoniaCve(hospitaldto.getColoniaCve());
			hospital.setLocalidadCve(hospitaldto.getLocalidadCve());
			hospital.setCpCve(hospitaldto.getCpCve());
			hospital.setLada(hospitaldto.getLada());
			hospital.setTelefono(hospitaldto.getTelefono());
			hospital.setCorreo(hospitaldto.getCorreo());
			hospital.setFechaRegistro(new Date());
			hospital.setUsuarioCve(hospitaldto.getUsuarioCve());
			hospital.setEstatus(hospitaldto.getEstatus());
			hospital.setClaveDependencia(hospitaldto.getClaveDependencia());
			hospital.setNombreVialidad(hospitaldto.getNombreVialidad());
			hospital.setTipoAsen(hospitaldto.getTipoAsen());
			hospital.setClaveOid(hospitaldto.getClaveOid());
			hospital.setLicenciaSanitaria(hospitaldto.getLicenciaSanitaria());
			hospital.setNombreAsentamiento(hospitaldto.getNombreAsentamiento());
			hospital.setPais(hospitaldto.getPais());
			hospital.setCatTipoEstablecimiento(hospitaldto.getCatTipoEstablecimiento());
			hospital.setCatEstadoJurisdiccion(hospitaldto.getCatEstadoJurisdiccion());
			hospital.setCatTipoServ(hospitaldto.getCatTipoServ());
			hospital.setCatVialidad(hospitaldto.getCatVialidad());
			hospital.setCatJurisdiccion(hospitaldto.getCatJurisdiccion());
			hospital.setNombreCorto(hospitaldto.getNombreCorto());

			hospital.setSerHospContinuoId(hospitaldto.getSerHospContinuoId());
			hospital.setSerHospParcialId(hospitaldto.getSerHospParcialId());
			hospital.setIdTipoUnidadPsiq(hospitaldto.getIdTipoUnidadPsiq());
			this.merge(hospital);
			this.flush();
			exito = 1;
			logger.info("########### SE ACTUALIZO DE FORMA CORRECTA");
		} catch (Exception e) {
			logger.info("########### Ocurrio un error al guardar ", e);
			exito = 0;
		}
		return exito;
	}


	/**
	 * Cambio de estatus de hospitales
	 *
	 * @param dto     DTO del hospital que será alterado
	 * @param estatus 1 para activar, 0 para desactivar
	 *
	 * @return exito
	 */
	@Override
	public int estatusHospital(HospitalDTO dto, Integer estatus) {
		int exito;
		logger.debug("Cambio de estatus de hospitales ");

		try {
			Criteria ct = session().createCriteria(AdmHospital.class);
			ct.add(Restrictions.eq("hospitalId", dto.getHospitalId()));
			AdmHospital hospitalTmp = (AdmHospital) ct.uniqueResult();
			hospitalTmp.setEstatus(estatus);
			super.merge(hospitalTmp);
			super.flush();
			exito = 1;
		} catch (Exception e) {
			e.getMessage();
			exito = 0;
		}

		return exito;
	}


	@Override
	public List<CatalogosDTO> obtenerCatTipoAsen() {
		Query query =
				session().createSQLQuery(QRY_CATALOGO_TIPO_ASEN)
						.addScalar("id", StandardBasicTypes.INTEGER)
						.addScalar("descripcion", StandardBasicTypes.STRING)
						.addScalar("indicadefault", StandardBasicTypes.INTEGER);
		query.setResultTransformer(Transformers.aliasToBean(CatalogosDTO.class));

		List<CatalogosDTO> lista = query.list();

		return lista;
	}


	@Override
	public List<CatalogosDTO> obtenerCatHospitalContinuo() {
		Query query =
				session().createSQLQuery(QRY_CATALOGO_HOSPITAL_CONTINUO)
						.addScalar("id", StandardBasicTypes.INTEGER)
						.addScalar("descripcion", StandardBasicTypes.STRING)
						.addScalar("indicadefault", StandardBasicTypes.INTEGER);
		query.setResultTransformer(Transformers.aliasToBean(CatalogosDTO.class));

		List<CatalogosDTO> lista = query.list();

		return lista;
	}

	@Override
	public List<OpcionCatalogoComunDTO> obtenerCatPerfil() {
		Query query =
				session().createSQLQuery(QRY_ID_PERFIL)
						.addScalar("idOpcion", StandardBasicTypes.INTEGER);
		query.setResultTransformer(Transformers.aliasToBean(OpcionCatalogoComunDTO.class));
		List<OpcionCatalogoComunDTO> lista = query.list();

		return lista;
	}


	@Override
	public List<CatalogosDTO> obtenerCatHospitalParcial() {
		Query query =
				session().createSQLQuery(QRY_CATALOGO_HOSPITAL_PARCIAL)
						.addScalar("id", StandardBasicTypes.INTEGER)
						.addScalar("descripcion", StandardBasicTypes.STRING)
						.addScalar("indicadefault", StandardBasicTypes.INTEGER);
		query.setResultTransformer(Transformers.aliasToBean(CatalogosDTO.class));

		List<CatalogosDTO> lista = query.list();

		return lista;
	}


	@Override
	public List<CatalogosDTO> obtenerCatTipoServ() {
		Query query =
				session().createSQLQuery(QRY_CATALOGO_TIPO_SERVICIOS)
						.addScalar("id", StandardBasicTypes.INTEGER)
						.addScalar("descripcion", StandardBasicTypes.STRING)
						.addScalar("indicadefault", StandardBasicTypes.INTEGER);
		query.setResultTransformer(Transformers.aliasToBean(CatalogosDTO.class));

		List<CatalogosDTO> lista = query.list();

		return lista;
	}


	@Override
	public List<CatalogosDTO> obtenerCatTipoUnidadPsiq() {
		Query query =
				session().createSQLQuery(QRY_CATALOGO_TIPO_UNIDAD_PSIQ)
						.addScalar("id", StandardBasicTypes.INTEGER)
						.addScalar("descripcion", StandardBasicTypes.STRING)
						.addScalar("indicadefault", StandardBasicTypes.INTEGER);
		query.setResultTransformer(Transformers.aliasToBean(CatalogosDTO.class));

		List<CatalogosDTO> lista = query.list();

		return lista;
	}


	@Override
	public List<CatalogosDTO> obtenerCatVialidad() {
		Query query =
				session().createSQLQuery(QRY_CATALOGO_VIALIDAD)
						.addScalar("id", StandardBasicTypes.INTEGER)
						.addScalar("descripcion", StandardBasicTypes.STRING)
						.addScalar("indicaDefault", StandardBasicTypes.INTEGER);
		query.setResultTransformer(Transformers.aliasToBean(CatalogoDTO.class));

		List<CatalogosDTO> lista = query.list();

		return lista;
	}

	@Override
	public List<CatalogosDTO> obtenerCatMunicipio(HospitalDTO hospitaldto) {
		StringBuilder QRY_CATALOGO_MUNICIPIO = new StringBuilder();

		QRY_CATALOGO_MUNICIPIO.append(" SELECT MUN.MUNICIPIO_ID as idCatPostal, MUN.DESCRIPCION as name,  MUN.INDICA_DEFAULT  as indicaDefault")
				.append(" FROM nom_cat_municipio MUN ")
				.append("  WHERE MUN.ESTATUS = 1   AND MUN.ESTADO_ID = '")
				.append(hospitaldto.getEstadoCve()).append("' ORDER BY DESCRIPCION");

		Query query =
				session().createSQLQuery(QRY_CATALOGO_MUNICIPIO.toString())
						.addScalar("idCatPostal", StandardBasicTypes.STRING)
						.addScalar("name", StandardBasicTypes.STRING)
						.addScalar("indicaDefault", StandardBasicTypes.INTEGER);


		query.setResultTransformer(Transformers.aliasToBean(CatalogoDTO.class));

		List<CatalogosDTO> lista = query.list();

		return lista;
	}


	@Override
	public List<CatalogosDTO> obtenerCatLocalidad(HospitalDTO hospitaldto) {
		StringBuilder QRY_CATALOGO_LOCALIDAD = new StringBuilder();

		QRY_CATALOGO_LOCALIDAD.append(" SELECT LOCALIDAD_ID as idCatPostal, DESCRIPCION as name FROM nom_cat_localidad  ")
				.append(" WHERE ESTATUS = 1 ")
				.append(" AND ESTADO_ID  = '")
				.append(hospitaldto.getEstadoCve())
				.append("' AND MUNICIPIO_ID = '")
				.append(hospitaldto.getMunicipioCve())
				.append("' ORDER BY DESCRIPCION ");

		Query query =
				session().createSQLQuery(QRY_CATALOGO_LOCALIDAD.toString())
						.addScalar("idCatPostal", StandardBasicTypes.STRING)
						.addScalar("name", StandardBasicTypes.STRING);

		query.setResultTransformer(Transformers.aliasToBean(CatalogoDTO.class));

		List<CatalogosDTO> lista = query.list();

		return lista;
	}


	@Override
	public List<CatalogosDTO> obtenerCatCodigoPostal(HospitalDTO hospitaldto) {
		Query query =
				session().createSQLQuery(QRY_CATALOGO_CODIGOPOSTAL)
						.addScalar("idCatPostal", StandardBasicTypes.STRING)
						.addScalar("name", StandardBasicTypes.STRING)
						.addScalar("indicaDefault", StandardBasicTypes.INTEGER);

		query.setParameter("p_idMunicipio", hospitaldto.getMunicipioCve());
		query.setParameter("p_idEstado", hospitaldto.getEstadoCve());
		query.setResultTransformer(Transformers.aliasToBean(CatalogoDTO.class));

		List<CatalogosDTO> lista = query.list();

		return lista;
	}


	@Override
	public List<CatalogosDTO> obtenerCatColonia(HospitalDTO hospitaldto) {
		Query query =
				session().createSQLQuery(QRY_CATALOGO_COLONIA)
						.addScalar("id", StandardBasicTypes.INTEGER)
						.addScalar("name", StandardBasicTypes.STRING)
						.addScalar("indicaDefault", StandardBasicTypes.INTEGER);

		query.setParameter("p_idMunicipio", hospitaldto.getMunicipioCve());
		query.setParameter("p_idEstado", hospitaldto.getEstadoCve());
		query.setParameter("p_idCodigo", hospitaldto.getCpCve());
		query.setResultTransformer(Transformers.aliasToBean(CatalogoDTO.class));

		List<CatalogosDTO> lista = query.list();

		return lista;
	}


	@Override
	public List<CatalogosDTO> obtenerCatEstadosXPais(HospitalDTO hospitaldto) {
		Query query =
				session().createSQLQuery(QRY_CATALOGO_ESTADOPAIS)
						.addScalar("idCatPostal", StandardBasicTypes.STRING)
						.addScalar("descripcion", StandardBasicTypes.STRING)
						.addScalar("indicaDefault", StandardBasicTypes.INTEGER);

		query.setParameter("p_idPais", hospitaldto.getPais());
		query.setResultTransformer(Transformers.aliasToBean(CatalogoDTO.class));

		List<CatalogosDTO> lista = query.list();

		return lista;
	}


	@Override
	public List<CatalogosDTO> obtenerCatPais() {
		Query query =
				session().createSQLQuery(QRY_CATALOGO_PAIS)
						.addScalar("id", StandardBasicTypes.INTEGER)
						.addScalar("descripcion", StandardBasicTypes.STRING)
						.addScalar("indicaDefault", StandardBasicTypes.INTEGER);
		query.setResultTransformer(Transformers.aliasToBean(CatalogoDTO.class));

		List<CatalogosDTO> lista = query.list();

		return lista;
	}


	@Override
	public List<CatalogosDTO> obtenerCatTipoEstablecimiento() {
		Query query =
				session().createSQLQuery(QRY_CATALOGO_TIPO_ESTABLECIMIENTO)
						.addScalar("id", StandardBasicTypes.INTEGER)
						.addScalar("name", StandardBasicTypes.STRING)
						.addScalar("indicaDefault", StandardBasicTypes.INTEGER);

		query.setResultTransformer(Transformers.aliasToBean(CatalogoDTO.class));

		List<CatalogosDTO> lista = query.list();

		return lista;
	}


	@Override
	public List<CatalogosDTO> obtenerCatEstadosJurisdiccion() {
		Query query =
				session().createSQLQuery(QRY_CATALOGO_ESTADO_JURISDICCION)
						.addScalar("id", StandardBasicTypes.INTEGER)
						.addScalar("name", StandardBasicTypes.STRING)
						.addScalar("indicaDefault", StandardBasicTypes.INTEGER);

		query.setResultTransformer(Transformers.aliasToBean(CatalogoDTO.class));

		List<CatalogosDTO> lista = query.list();

		return lista;
	}


	@Override
	public List<CatalogosDTO> obtenerCatJurisdiccion(HospitalDTO hospitalDTO) {
		Query query =
				session().createSQLQuery(QRY_CATALOGO_JURISDICCION)
						.addScalar("id", StandardBasicTypes.INTEGER)
						.addScalar("name", StandardBasicTypes.STRING)
						.addScalar("jur", StandardBasicTypes.STRING);

		query.setParameter("p_idEstado", hospitalDTO.getIdEstadoJurisdiccion());

		query.setResultTransformer(Transformers.aliasToBean(CatalogoDTO.class));

		List<CatalogosDTO> lista = query.list();

		return lista;
	}


	public AdmHospital obtenerCatHospital(HospitalDTO hospitaldto) {
		AdmHospital hospital = new AdmHospital();
		hospital.setCveCtaInstSalud(hospitaldto.getCveCtaInstSalud());
		hospital.setNombre(hospitaldto.getNombre());
		hospital.setClueId(hospitaldto.getClueId());
		hospital.setCveInstSalud(hospitaldto.getCveInstSalud());
		hospital.setCalle(hospitaldto.getCalle());
		hospital.setNoInt(hospitaldto.getNoInt());
		hospital.setNoIntLetra(hospitaldto.getNoIntLetra());
		hospital.setNoExt(hospitaldto.getNoExt());
		hospital.setNoExtLetra(hospitaldto.getNoExtLetra());
		hospital.setEstadoCve(hospitaldto.getEstadoCve());
		hospital.setMunicipioCve(hospitaldto.getMunicipioCve());
		hospital.setColoniaCve(hospitaldto.getColoniaCve());
		hospital.setLocalidadCve(hospitaldto.getLocalidadCve());
		hospital.setCpCve(hospitaldto.getCpCve());
		hospital.setLada(hospitaldto.getLada());
		hospital.setTelefono(hospitaldto.getTelefono());
		hospital.setCorreo(hospitaldto.getCorreo());
		hospital.setFechaRegistro(new Date());
		hospital.setUsuarioCve(hospitaldto.getUsuarioCve());
		hospital.setEstatus(hospitaldto.getEstatus());
		hospital.setClaveDependencia(hospitaldto.getClaveDependencia());
		hospital.setNombreVialidad(hospitaldto.getNombreVialidad());
		hospital.setTipoAsen(hospitaldto.getTipoAsen());
		hospital.setClaveOid(hospitaldto.getClaveOid());
		hospital.setLicenciaSanitaria(hospitaldto.getLicenciaSanitaria());
		hospital.setNombreAsentamiento(hospitaldto.getNombreAsentamiento());
		hospital.setPais(hospitaldto.getPais());
		hospital.setIdTipoUnidadPsiq(hospitaldto.getIdTipoUnidadPsiq());
		hospital.setSerHospContinuoId(hospitaldto.getSerHospContinuoId());
		hospital.setSerHospParcialId(hospitaldto.getSerHospParcialId());
		hospital.setCatTipoEstablecimiento(hospitaldto.getCatTipoEstablecimiento());
		hospital.setCatEstadoJurisdiccion(hospitaldto.getCatEstadoJurisdiccion());
		hospital.setCatTipoServ(hospitaldto.getCatTipoServ());
		hospital.setCatVialidad(hospitaldto.getCatVialidad());
		hospital.setCatJurisdiccion(hospitaldto.getCatJurisdiccion());
		hospital.setNombreCorto(hospitaldto.getNombreCorto());
		hospital.setTipoHospitalId(hospitaldto.getIdTipoHospsital());
		hospital.setRissId(hospitaldto.getRissId());
		hospital.setIdClues(hospitaldto.getIdClues());


		return hospital;
	}


	@Override
	public List<HospitalDTO> obtenerCataHospitalActivos() {
		List<HospitalDTO> resultado = new ArrayList<>();
		Criteria ct = session().createCriteria(AdmHospital.class);
		ct.add(Restrictions.eq("estatus", 1));
		List<AdmHospital> lstTmp = ct.list();

		if (null != lstTmp && !lstTmp.isEmpty()) {
			for (AdmHospital hospital : lstTmp) {
				HospitalDTO item = new HospitalDTO();

				item.setHospitalId(hospital.getHospitalId());
				item.setNombre(hospital.getNombre());
				item.setNombreCorto(hospital.getNombreCorto());
				item.setClueId(hospital.getClueId());
				item.setEstatus(hospital.getEstatus());

				if (hospital.getCatTipoServ() != null) {
					item.setTiposervicio(hospital.getCatTipoServ().getIdtiposerv());
					item.setTiposervicioNombre(hospital.getCatTipoServ().getNombre());
				}

				resultado.add(item);
			}
		}

		return resultado;
	}


	@Override
	public AdmHospital obtenerEntidadHospital(int id) {
		Criteria ct = session().createCriteria(AdmHospital.class);
		ct.add(Restrictions.eq("hospitalId", id));

		return (AdmHospital) ct.uniqueResult();
	}

	@Override
	public CatTipoEstablecimiento obtenerCatTipoEstablecimientoPorID(int id) {
		Criteria ct = session().createCriteria(CatTipoEstablecimiento.class);
		ct.add(Restrictions.eq("idTipoEstablecimiento", id));

		return (CatTipoEstablecimiento) ct.uniqueResult();
	}


	@Override
	public List<HospitalDTO> obtenerCataHospital() {
		// language=MySQL
		String SQL_Qry =
				"SELECT " +
						" hospital.HOSPITAL_ID AS hospitalId, " +
						" hospital.NOMBRE AS nombre, " +
						" hospital.ESTATUS AS estatus, " +
						" hospital.NOMBRE_CORTO  AS nombreCorto, " +
						" hospital.CLUE_ID AS clueId, " +
						" hospital.TIPO_HOSPITAL_ID AS idTipoHospsital, " +
						" hospital.ID_TIPO_VIALIDAD AS tipoAsen, " +
						" serv.TIPO_SERV_ID AS tiposervicio, " +
						" serv.NOMBRE  AS tiposervicioNombre, " +
						" (SELECT COUNT(*) " +
						"  FROM core_config configuracion " +
						"  where configuracion.HOSPITAL_ID = hospital.HOSPITAL_ID) AS configuraciones " +
						"FROM adm_hospital hospital " +
						" LEFT JOIN cat_tipo_serv serv ON hospital.TIPO_SERVICIO = serv.TIPO_SERV_ID ";

		Query query =
				session().createSQLQuery(SQL_Qry)
						.addScalar("hospitalId", StandardBasicTypes.INTEGER)
						.addScalar("nombre", StandardBasicTypes.STRING)
						.addScalar("estatus", StandardBasicTypes.INTEGER)
						.addScalar("nombreCorto", StandardBasicTypes.STRING)
						.addScalar("clueId", StandardBasicTypes.STRING)
						.addScalar("idTipoHospsital", StandardBasicTypes.INTEGER)
						.addScalar("tiposervicio", StandardBasicTypes.INTEGER)
						.addScalar("tipoAsen", StandardBasicTypes.INTEGER)
						.addScalar("tiposervicioNombre", StandardBasicTypes.STRING)
						.addScalar("configuraciones", StandardBasicTypes.INTEGER);

		query.setResultTransformer(Transformers.aliasToBean(HospitalDTO.class));
		return query.list();
	}

	@Override
	public List<HospitalDTO> obtenerCatHospitalRiss(HospitalDTO hospitaldto) {
		// language=MySQL
		String SQL_Qry =
				"SELECT " +
						" hospital.HOSPITAL_ID AS hospitalId, " +
						" hospital.NOMBRE AS nombre, " +
						" hospital.ESTATUS AS estatus, " +
						" hospital.NOMBRE_CORTO  AS nombreCorto, " +
						" hospital.CLUE_ID AS clueId, " +
						" hospital.TIPO_HOSPITAL_ID AS idTipoHospsital, " +
						" hospital.ID_TIPO_VIALIDAD AS tipoAsen, " +
						" ncc.CVE_JURISDICCION AS cveJurisdiccion, " +
						" ncc.NOMBRE_JURISDICCION AS jurisdiccion, " +
						" serv.TIPO_SERV_ID AS tiposervicio, " +
						" serv.NOMBRE  AS tiposervicioNombre " +
						" FROM adm_hospital hospital " +
						" LEFT JOIN cat_tipo_serv serv ON hospital.TIPO_SERVICIO = serv.TIPO_SERV_ID " +
						" LEFT JOIN nom_cat_clues ncc ON hospital.ID_CLUES = ncc.ID_CLUES ";


		Query query =
				session().createSQLQuery(SQL_Qry)
						.addScalar("hospitalId", StandardBasicTypes.INTEGER)
						.addScalar("nombre", StandardBasicTypes.STRING)
						.addScalar("estatus", StandardBasicTypes.INTEGER)
						.addScalar("nombreCorto", StandardBasicTypes.STRING)
						.addScalar("clueId", StandardBasicTypes.STRING)
						.addScalar("idTipoHospsital", StandardBasicTypes.INTEGER)
						.addScalar("tiposervicio", StandardBasicTypes.INTEGER)
						.addScalar("tipoAsen", StandardBasicTypes.INTEGER)
						.addScalar("tiposervicioNombre", StandardBasicTypes.STRING)
						.addScalar("cveJurisdiccion", StandardBasicTypes.STRING)
						.addScalar("jurisdiccion", StandardBasicTypes.STRING);

		query.setResultTransformer(Transformers.aliasToBean(HospitalDTO.class));
		return query.list();
	}

	@Override
	public List<HospitalDTO> obtenerCatHospitalRisses(HospitalDTO hospitaldto) {
		String SQL_Qry =
				"SELECT " +
						" hospital.HOSPITAL_ID AS hospitalId, " +
						" hospital.NOMBRE AS nombre, " +
						" hospital.ESTATUS AS estatus, " +
						" hospital.NOMBRE_CORTO  AS nombreCorto, " +
						" hospital.CLUE_ID AS clueId, " +
						" hospital.TIPO_HOSPITAL_ID AS idTipoHospsital, " +
						" hospital.ID_TIPO_VIALIDAD AS tipoAsen, " +
						" ncc.CVE_JURISDICCION AS cveJurisdiccion, " +
						" ncc.NOMBRE_JURISDICCION AS jurisdiccion, " +
						" serv.TIPO_SERV_ID AS tiposervicio, " +
						" serv.NOMBRE  AS tiposervicioNombre, " +
						" (SELECT COUNT(*) " +
						"  FROM core_config configuracion " +
						"  where configuracion.HOSPITAL_ID = hospital.HOSPITAL_ID) AS configuraciones " +
						"FROM adm_hospital hospital " +
						" LEFT JOIN cat_tipo_serv serv ON hospital.TIPO_SERVICIO = serv.TIPO_SERV_ID " +
						" LEFT JOIN nom_cat_clues ncc ON hospital.ID_CLUES = ncc.ID_CLUES " +
						"where hospital.RISS_ID = :pRissId";


		Query query =
				session().createSQLQuery(SQL_Qry)
						.addScalar("hospitalId", StandardBasicTypes.INTEGER)
						.addScalar("nombre", StandardBasicTypes.STRING)
						.addScalar("estatus", StandardBasicTypes.INTEGER)
						.addScalar("nombreCorto", StandardBasicTypes.STRING)
						.addScalar("clueId", StandardBasicTypes.STRING)
						.addScalar("idTipoHospsital", StandardBasicTypes.INTEGER)
						.addScalar("tiposervicio", StandardBasicTypes.INTEGER)
						.addScalar("tipoAsen", StandardBasicTypes.INTEGER)
						.addScalar("tiposervicioNombre", StandardBasicTypes.STRING)
						.addScalar("cveJurisdiccion", StandardBasicTypes.STRING)
						.addScalar("jurisdiccion", StandardBasicTypes.STRING)
						.addScalar("configuraciones", StandardBasicTypes.INTEGER);

		query.setParameter("pRissId", hospitaldto.getRissId());

		query.setResultTransformer(Transformers.aliasToBean(HospitalDTO.class));
		return query.list();
	}

	@Override
	public CatEstadoJurisdiccion CatEstadoJurisdiccionPorID(int id) {
		Criteria ct = session().createCriteria(CatEstadoJurisdiccion.class);
		ct.add(Restrictions.eq("idEstadoJurisdiccion", id));

		return (CatEstadoJurisdiccion) ct.uniqueResult();
	}


	@Override
	public CatTipoServ obtenerCatTipoServPorID(int id) {
		Criteria ct = session().createCriteria(CatTipoServ.class);
		ct.add(Restrictions.eq("idtiposerv", id));

		return (CatTipoServ) ct.uniqueResult();
	}

	@Override
	public CatVialidad obtenerCatVialidadPorID(int id) {
		Criteria ct = session().createCriteria(CatVialidad.class);
		ct.add(Restrictions.eq("vialidadId", id));

		return (CatVialidad) ct.uniqueResult();
	}


	@Override
	public CatJurisdiccion obtenerCatJurisdiccionPorID(int id) {
		Criteria ct = session().createCriteria(CatJurisdiccion.class);
		ct.add(Restrictions.eq("catJurisdiccionId", id));

		return (CatJurisdiccion) ct.uniqueResult();
	}

	@Override
	public AdmHospital obtenerHospitalId(Integer hospitalId) {
		Criteria hospital = session().createCriteria(AdmHospital.class, "hospital");
		hospital.add(Restrictions.eq("hospital.hospitalId", hospitalId));

		return hospital.uniqueResult() != null ? (AdmHospital) hospital.uniqueResult() : null;
	}

	@Override
	public boolean obtenerClaves(Integer hospitalId, String cve) {
//
//		session().createSQLQuery(QRY_SET_NOT_GENERIC).executeUpdate();
//		session().createSQLQuery(QRY_SET_NOT_GENERIC2).executeUpdate();


		Query query =
				session().createSQLQuery(QRY_CLAVES)
						.addScalar("count(cve)", StandardBasicTypes.INTEGER);

		query.setParameter("pHospitalId", hospitalId);
		query.setParameter("pCve", cve);

		Integer cuenta = (Integer) query.uniqueResult();
//
//		session().createSQLQuery(QRY_RETURN_GENERIC).executeUpdate();
//		session().createSQLQuery(QRY_RETURN_GENERIC2).executeUpdate();

		return (cuenta > 0);
	}

	@Override
	public AdmHospital obtenerIdHospital(Integer rolId) {
		Query query = session().createQuery("" +
				"select rol.admHospital " +
				"from CatRol rol " +
				"where rol.rolId = :pRolId"
		).setParameter("pRolId", rolId);

		return (AdmHospital) query.uniqueResult();
	}


	@Override
	public boolean existeExpediente(int hospitalId, int pacienteId) {

		BigDecimal numExpedientes = (BigDecimal) session().createSQLQuery(
						"SELECT COUNT(*) " +
								"FROM pac_expediente exp" +
								" WHERE exp.HOSPITAL_ID = :pHospitalId AND exp.PACIENTE_ID = :pPacienteId"
				)
				.setParameter("pHospitalId", hospitalId)
				.setParameter("pPacienteId", pacienteId)
				.uniqueResult();

		return (numExpedientes.compareTo(BigDecimal.ZERO) > 0);
	}


}
