package hts.backend.dao;


import hts.backend.model.dto.CatalogoDTO;
import hts.backend.model.dto.OpcionCatalogoComunDTO;
import hts.backend.model.dto.ServicioEspecialidadDTO;
import hts.backend.model.dto.*;
import hts.backend.entity.AdmCatTipoPrestacion3;
import hts.backend.entity.NomCatEntidades;
import hts.backend.entity.NomCatLocalidad;
import hts.backend.entity.NomCatMunicipio;

import java.util.List;

public interface CatalogosDAO {

	String QRY_CATALOGO_SEXO 			= "SELECT idSexo as id, descripcion as name, INDICADEFAULT as indicaDefault FROM catsexo WHERE estatus = 1";
	String QRY_CATALOGO_SANGRE 		= "SELECT IDSANGRE as id, descripcion as name, INDICADEFAULT as indicaDefault FROM cattiposangre WHERE estatus = 1";
	String QRY_CATALOGO_NACIONDALIDA 	= "SELECT IDNACIONALIDAD as id, descripcion as name, INDICADEFAULT as indicaDefault  FROM catnacionalidad WHERE estatus = 1";
	String QRY_CATALOGO_ESTADO 		= "SELECT IDESTADO as id, descripcion as name FROM catestado WHERE estatus = 1";
	String QRY_CATALOGO_DOCIDEN 		= "SELECT IDDOCUMENTOIDENTIFICA as id, descripcion as name, INDICADEFAULT as indicaDefault FROM catdocumentoidentifica WHERE estatus = 1";
	String QRY_CATALOGO_RELIGION 		= "SELECT IDRELIGION as id, descripcion as name, INDICADEFAULT as indicaDefault FROM catreligion WHERE estatus = 1";
	String QRY_CATALOGO_ESTADO_CIVIL 	= "SELECT IDEDOCIVIL as id, descripcion as name, INDICADEFAULT as indicaDefault FROM catedocivil WHERE estatus = 1";
	String QRY_CATALOGO_MUNICIPIO 		= "SELECT IDMUNICIPIO as id, descripcion as name FROM catmunicipio WHERE estatus = 1";
	String QRY_CATALOGO_LOCALIDAD 		= "SELECT IDLOCALIDAD as id, descripcion  as name FROM catlocalidad WHERE estatus = 1";
	String QRY_CATALOGO_COLONIA 		= "SELECT IDCOLONIA as id, descripcion as name FROM catcolonia WHERE estatus = 1";
	String QRY_CATALOGO_TIPO_BENEFICIARO = "SELECT IDTIPOBENEFICIARIO as id, descripcion as name FROM cattipobeneficiario WHERE estatus = 1";
	String QRY_CATALOGO_PARENTESCO 	= "SELECT IDPARENTESCO as id, descripcion as name, INDICADEFAULT as indicaDefault FROM catparentesco WHERE estatus = 1";
	String QRY_CATALOGO_OCUPACION 		= "SELECT IDOCUPACION as id, descripcion as name, INDICADEFAULT as indicaDefault FROM catocupacion WHERE estatus = 1";
	String QRY_CATALOGO_NVLESTUDIOS 	= "SELECT IDNIVELESTUDIOS as id, descripcion as name, INDICADEFAULT as indicaDefault  FROM catnivelestudios WHERE estatus = 1";
	String QRY_CATALOGO_IDIOMA 		= "SELECT idIdioma as id, descripcion as name, INDICADEFAULT as indicaDefault FROM catidioma WHERE estatus = 1";

	String QRY_CATALOGO_TIPOPACIENTE 	= "SELECT idTipoPaciente as id, descripcion as name FROM cattipopaciente WHERE estatus = 1";

	// language=MySQL
	String QRY_CATALOGO_MOTIVO_ANULACION_CIRUGIA	= "SELECT mot.MOTIVO_ANULACION_CIRUGIA_ID as id, mot.descripcion as name, mot.VALOR_DEFAULT as indicaDefault FROM cat_motivo_anulacion_cirugia mot WHERE mot.estatus = 1";
	String QRY_CATALOGO_ETNIA 			= "SELECT idEtnia as id, descripcion as name FROM catetnia WHERE estatus = 1";
	String QRY_CATALOGO_PROCEDENCIA 	= "SELECT idProcedencia as id, descripcion as name, INDICADEFAULT as indicaDefault  FROM catprocedencia WHERE estatus = 1";
	String QRY_CATALOGO_ALERGIAS 	    = "SELECT IDALERGIA as id , ALERGIA as name FROM catalergias WHERE ESTATUS = 1";
	String QRY_CATALOGO_IMPEDIMENTOS 	= "SELECT IDIMPEDIMENTO as id , IMPEDIMENTO as name FROM catimpedimentos WHERE ESTATUS = 1";
	String QRY_CATALOGO_CONTRAIND 		= "SELECT IDCONTRAINDICACION as id , CONTRAINDICACION as name FROM catcontraindicaciones WHERE ESTATUS = 1";
	String QRY_CATALOGO_SERVICIOS 		= "SELECT catsb.IDCENTRO as idCentro , catsb.IDAREASERVICIO  as idAreaServicio, "
			+ "catsb.IDSERVICIOBASICO as idServicioBasico, "
			+ "catsb.DESCRIPCION as descripcion "+
			"FROM catserviciosbasicos catsb " +
			"WHERE catsb.ESTATUS = 1 " +
			"ORDER BY catsb.DESCRIPCION";
	public static final String QRY_CATALOGO_SERVICIO_ESP = "SELECT catsbe.IDCENTRO as idCentro , catsbe.IDAREASERVICIO  as idAreaServicio, "
			+ "catsbe.IDSERVICIOBASICO as idServicioBasico,catsbe.IDSERVICIOESPECIALIDAD as idServicioEspecializado , "
			+ "catsbe.DESCRIPCION as descripcion " +
			"FROM catserviciosespecializados catsbe  " +
			"WHERE catsbe.ESTATUS = 1 " +
			"AND catsbe.IDCENTRO = :p_idCentro " +
			"AND catsbe.IDAREASERVICIO = :p_idServicio " +
			"AND catsbe.IDSERVICIOBASICO = :p_idServicioBasico " +
			"ORDER BY catsbe.DESCRIPCION";


	String QRY_CATALOGO_PAIS = "SELECT PAIS_ID as idCatPostal, DESCRIPCION as name, INDICA_DEFAULT as indicaDefault FROM nom_cat_pais WHERE ESTATUS = 1"
			+ "	ORDER BY DESCRIPCION ";

	String QRY_CATALOGO_ESTADO_PAIS = " SELECT EST.ESTADO_ID as idCatPostal, EST.DESCRIPCION as name, EST.VALOR_DEFAULT as indicaDefault "
			+ " FROM nom_cat_estado EST, NOM_CAT_PAIS PA WHERE EST.estatus = 1 " +
			" AND PA.PAIS_ID = EST.PAIS_ID " +
			" AND PA.VALOR_DEFAULT = 1 ";



	public static final String QRY_CAT_TIPO_EXPEDIENTE="SELECT tipo_expediente_id as id, nombre as name , VALOR_DEFAULT as indicaDefault FROM cat_tipo_expediente WHERE estatus = 1";
	public static final String QRY_CAT_MOTIVO_BLOQUEO_AGENDA="SELECT MOTIVO_BLOQUEO_AGENDA_ID as id, nombre as name , VALOR_DEFAULT as indicaDefault FROM cat_motivo_bloqueo_agenda WHERE estatus = 1";

	public static final String QRY_CATALGOS_GENERICOS ="SELECT NOMBRE AS name FROM core_catalogo WHERE CATALOGO_ID = :p_idCatalogo";










	public List<CatalogoDTO> obtenerCatalogoSexo();
	public List<CatalogoDTO> obtenerCatalogoSangre();
	public List<CatalogoDTO> obtenerCatalogoNacionalidad();
	public List<CatalogoDTO> obtenerCatalogoEstado();
	public List<CatalogoDTO> obtenerCatalogoDocIden();
	public List<CatalogoDTO> obtenerCatalogoReligion();
	public List<CatalogoDTO> obtenerCatalogoEstadoCivil();
	public List<CatalogoDTO> obtenerCatalogoMunicipio();
	public List<CatalogoDTO> obtenerCatalogoLocalidad();
	public List<CatalogoDTO> obtenerCatalogoColonia();
	public List<CatalogoDTO> obtenerCatalogoTipoBeneficiario();
	public List<CatalogoDTO> obtenerCatalogoParentesco();
	public List<CatalogoDTO> obtenerCatalogoOCupacion();
	public List<CatalogoDTO> obtenerCatalogoNvlEstudios();
	public List<CatalogoDTO> obtenerCatalogoIdioma();
	public List<CatalogoDTO> obtenerCatalogoTipoPaciente();
	public List<CatalogoDTO> obtenerCatalogoEtnia();
	public List<CatalogoDTO> obtenerCatalogoProcedencia();
	public List<CatalogoDTO> obtenerCatalogoAlergias();
	public List<CatalogoDTO> obtenerCatalogoContraIndi();
	public List<CatalogoDTO> obtenerCatalogoImpedimentos();
	public List<CatalogoDTO> listaMotivoBloqueo();

	//CATALOGOS DE SERVICIOS
	public List<ServicioEspecialidadDTO> obtenerServicios();
	public List<ServicioEspecialidadDTO> obtenerEspecialidad(ServicioEspecialidadDTO servicio);
	public List<CatalogoDTO> obtenerCatalogoPais();
	public List<CatalogoDTO> obtenerMotivoAnulacionCirugia();
	public List<CatalogoDTO> obtenerCatalogoEstadoPais();

	/**********************************************************************************************
	 ************************ CATALOGOS RELACIONADOS CON DIRECCION ********************************
	 **********************************************************************************************/

	public List<NomCatPaisesDTO> listaPaises();
	public List<NomCatEntidadesDTO> listaEntidadesByPaisID(NomCatPaisesDTO dto);
	public List<NomCatMunicipioDTO> listaMunicipiosByCveEntidad(NomCatEntidadesDTO dto);
	public List<NomCatLocalidadDTO> listaLocalidadesByCveEntMun(NomCatMunicipioDTO dto);
	public List<NomCatCodigoPostalDTO> listaCodPostalByCveEntMun(NomCatMunicipioDTO dto);
	public List<NomCatNacionalidadesDTO> listaNacionalidades();
	public List<OpcionCatalogoComunDTO> listarOpcionesProNac();
	public List<CatTipoAsenDTO> listaTipoAsentamiento();
	public List<CatVialidadDTO> listaVialidad();

	/**********************************************************************************************
	 ************************ CATALOGOS RELACIONADOS CON DIRECCION ********************************
	 **********************************************************************************************/

	public List<NomCatSexoDTO> listaSexo();
	public List<CatTipoSangreDTO> listaTipoSangre();
	public List<NomCatReligionDTO> listaReligion();
	public List<NomCatEstadoCivilDTO> listaEstadoCivil(NomCatEstadoCivilDTO dto);
	public List<NomCatOcupacionDTO> listaOcupacion();
	public List<NomCatEscolaridadDTO> listaNivelEscolaridad();
	public List<NomCatTipoLenguaIndigenaDTO> listaTipoLenguaIndigena(NomCatTipoLenguaIndigenaDTO dto);
	public List<CatProcedenciaDTO> listaProcedencia();
	public List<NomCatSinoDTO> listaSiNo(NomCatSinoDTO dto);
	public List<CatalogoDTO> listaTipoExpediente();
	public List<OpcionCatalogoComunDTO> listaPrestacion3();
	public AdmCatTipoPrestacion3 obtenerPrestacion3Id(Integer tipoPrestacion3Id);
	public List<OpcionCatalogoComunDTO> listaTipoMoneda();
	public List<OpcionCatalogoComunDTO> obtenCatMetodoPago();
	public List<OpcionCatalogoComunDTO> obtenCatBanco();
	public List<OpcionCatalogoComunDTO> listaTipoAseguradora();
	public List<OpcionCatalogoComunDTO> listaCFiscal();
	public List<OpcionCatalogoComunDTO> listaCatEpisodios();
	public NomCatEntidades obtenerEntidadByClave(String cveEntidad);
	public NomCatMunicipio obtenerMunicipopByClave(String cveMunicipio, String cveEntidad);
	public NomCatLocalidad obtenerEntidadLocalidad(String cveMunicipio, String cveEntidad);
	List<OpcionCatalogoComunDTO> obtenerAlergiasActivas(OpcionCatalogoComunDTO dto);
	List<OpcionCatalogoComunDTO> obtenerImpedimentosActivos(OpcionCatalogoComunDTO dto);
	List<OpcionCatalogoComunDTO> obtenerContraIndActivas(OpcionCatalogoComunDTO dto);
	List<OpcionCatalogoComunDTO> obtenerCatFormaFarmaceutica(OpcionCatalogoComunDTO dto);
	List<OpcionCatalogoComunDTO> obtenerCatMedicamentoPresentaciones(OpcionCatalogoComunDTO dto);
	List<OpcionCatalogoComunDTO> obtenerCatGrupoTerapeutico(OpcionCatalogoComunDTO dto);
	List<OpcionCatalogoComunDTO> obtenerCatViaAdministracion(OpcionCatalogoComunDTO dto);
	List<OpcionCatalogoComunDTO> obtenerCatUnidadMedidaDosis(OpcionCatalogoComunDTO dto);
	List<OpcionCatalogoComunDTO> obtenerCatSituacionEconomica(OpcionCatalogoComunDTO dto);
	List<OpcionCatalogoComunDTO> obtenerCatDondeSeAtiende(OpcionCatalogoComunDTO dto);
	List<OpcionCatalogoComunDTO> obtenerCatTipoEvento(OpcionCatalogoComunDTO dto);
	List<OpcionCatalogoComunDTO> obtenerCatDestinoPrestamoExp(OpcionCatalogoComunDTO dto);
	List<OpcionCatalogoComunDTO> obtenerCatUbicacionExpediente(OpcionCatalogoComunDTO dto);
	List<OpcionCatalogoComunDTO> obtenerCatEstatusPeticion(OpcionCatalogoComunDTO dto);
	List<OpcionCatalogoComunDTO> obtenerCatTipoPrescripciones(OpcionCatalogoComunDTO dto);
	List<OpcionCatalogoComunDTO> obtenerCatTipoUnidadReferencia(OpcionCatalogoComunDTO dto);
	List<OpcionCatalogoComunDTO> obtenerCatTipoTrasladoReferencia(OpcionCatalogoComunDTO dto);
	List<OpcionCatalogoComunDTO> obtenerCatMotivoEnvioReferencia(OpcionCatalogoComunDTO dto);
	List<OpcionCatalogoComunDTO> obtenerCatMotivoAnulacionNse(OpcionCatalogoComunDTO dto);
	List<OpcionCatalogoComunDTO> obtenerCatMotivoDescuento(OpcionCatalogoComunDTO dto);
	List<OpcionCatalogoComunDTO> obtenerCatTipoArchivo(OpcionCatalogoComunDTO dto);
	//	List<OpcionCatalogoComunDTO> obtenerCatAnestesia(OpcionCatalogoComunDTO dto);
//	List<OpcionCatalogoComunDTO> obtenerCatBeneficiosAnestesia(OpcionCatalogoComunDTO dto);
	List<OpcionCatalogoComunDTO> obtenerGusModulos();
	List<OpcionCatalogoComunDTO> listarOpcionesCatalogoGenerico(OpcionCatalogoComunDTO dto);
	String obtenerNombreCatalogoGenerico(OpcionCatalogoComunDTO dto);

	List<OpcionCatalogoComunDTO> listarCatPreIngresoPrioridad(OpcionCatalogoComunDTO dto);
	List<OpcionCatalogoComunDTO> listarCatMotivoIngreso(OpcionCatalogoComunDTO dto);
	List<OpcionCatalogoComunDTO> listarCatTipoIngresoHosp(OpcionCatalogoComunDTO dto);
	List<OpcionCatalogoComunDTO> listarCatHspProcedencia(OpcionCatalogoComunDTO dto);

	List<OpcionCatalogoComunDTO> listarEstadoProc();
	List<OpcionCatalogoComunDTO> listarHepatitisB();
	List<OpcionCatalogoComunDTO> listarVitaminaK();
	List<OpcionCatalogoComunDTO> listarVitaminaA();
	List<OpcionCatalogoComunDTO> listarTamizAuditivo();
	List<OpcionCatalogoComunDTO> listarVacunaBcg();

	List<OpcionCatalogoComunDTO> listarNomCatAtencionPrenatal();
	List<OpcionCatalogoComunDTO> listarNomCatViveMadre();
	List<OpcionCatalogoComunDTO> listarCircunDefun();


	List<OpcionCatalogoComunDTO> listarTipoVisita(OpcionCatalogoComunDTO dto);



}
