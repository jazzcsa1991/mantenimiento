package hts.backend.service.impl;

import hts.backend.service.CatalogosService;
import hts.backend.dao.CatalogosDAO;
import hts.backend.model.EstatusResponse;
import hts.backend.model.dto.OpcionCatalogoComunDTO;
import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.ServicioEspecialidadDTO;
import hts.backend.model.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service("CatalogosService")
public class CatalogosServiceImpl implements CatalogosService {

	private static final Logger logger = LoggerFactory.getLogger(CatalogosServiceImpl.class);


	@Resource
	CatalogosDAO catalogosDAO;


	@Override
	@Transactional
	public RespuestaGenerica obtenerCatalogoIdioma() {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "opciones", catalogosDAO.obtenerCatalogoIdioma());
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerCatalogoImpedimentos() {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "opciones", catalogosDAO.obtenerCatalogoImpedimentos());
	}


	@Override
	@Transactional
	public RespuestaGenerica obtenerServicios() {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "servicios", catalogosDAO.obtenerServicios());
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerEspecialidad(ServicioEspecialidadDTO servicio) {

		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "serviciosEspecialidad", catalogosDAO.obtenerEspecialidad(servicio));
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerCatalogoPais() {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "opciones", catalogosDAO.obtenerCatalogoPais());
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerCatalogoEstadoPais() {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "opciones", catalogosDAO.obtenerCatalogoEstadoPais());
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerMotivoAnulacionCirugia() {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "opciones", catalogosDAO.obtenerMotivoAnulacionCirugia());
	}


	/**********************************************************************************************
	 ************************ CATALOGOS RELACIONADOS CON DIRECCION ********************************
	 **********************************************************************************************/

	@Override
	public RespuestaGenerica listaPaises() {
		logger.info("##################  invocando a DAO listaPaises ##################");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "paises",
				catalogosDAO.listaPaises());
	}

	@Override
	public RespuestaGenerica listaEntidadesByPaisID(NomCatPaisesDTO dto) {
		logger.info("##################  invocando a DAO listaEntidadesByPaisID ##################");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "entidades",
				catalogosDAO.listaEntidadesByPaisID(dto));
	}

	@Override
	public RespuestaGenerica listaMunicipiosByCveEntidad(NomCatEntidadesDTO dto) {
		logger.info("##################  invocando a DAO listaMunicipiosByCveEntidad ##################");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "municipios",
				catalogosDAO.listaMunicipiosByCveEntidad(dto));
	}


	@Override
	public RespuestaGenerica listaLocalidadesByCveEntMun(NomCatMunicipioDTO dto) {
		logger.info("##################  invocando a DAO listaLocalidadesByCveEntMun ##################");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "localidades",
				catalogosDAO.listaLocalidadesByCveEntMun(dto));
	}

	@Override
	public RespuestaGenerica listaCodPostalByCveEntMun(NomCatMunicipioDTO dto) {
		logger.info("##################  invocando a DAO listaCodPostalByCveEntMun ##################");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "cpostales",
				catalogosDAO.listaCodPostalByCveEntMun(dto));
	}

	@Override
	public RespuestaGenerica listaNacionalidades() {
		logger.info("##################  invocando a DAO listaNacionalidades ##################");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "nacionalidades",
				catalogosDAO.listaNacionalidades());
	}

	@Override
	public RespuestaGenerica listaTipoAsentamiento() {
		logger.info("##################  invocando a DAO listaTipoAsentamiento ##################");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "tasentamientos",
				catalogosDAO.listaTipoAsentamiento());
	}

	@Override
	public RespuestaGenerica listaVialidad() {
		logger.info("##################  invocando a DAO listaVialidad ##################");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "cvialidades",
				catalogosDAO.listaVialidad());
	}


	/**********************************************************************************************
	 ************************ CATALOGOS RELACIONADOS CON PACIENTE ********************************
	 **********************************************************************************************/


	@Override
	public RespuestaGenerica listaSexo() {
		logger.info("##################  invocando a DAO listaSexo ##################");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "cSexo",
				catalogosDAO.listaSexo());
	}


	@Override
	public RespuestaGenerica listaTipoSangre() {
		logger.info("##################  invocando a DAO listaTipoSangre ##################");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "cSangre",
				catalogosDAO.listaTipoSangre());
	}

	@Override
	public RespuestaGenerica listaReligion() {
		logger.info("##################  invocando a DAO listaReligion ##################");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "cReligion",
				catalogosDAO.listaReligion());
	}

	@Override
	public RespuestaGenerica listaEstadoCivil(NomCatEstadoCivilDTO dto) {
		logger.info("##################  invocando a DAO listaEstadoCivil ##################");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "cEstadoCivil",
				catalogosDAO.listaEstadoCivil(dto));
	}

	@Override
	public RespuestaGenerica listaOcupacion() {
		logger.info("##################  invocando a DAO listaOcupacion ##################");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "cOcupacion",
				catalogosDAO.listaOcupacion());
	}

	@Override
	public RespuestaGenerica listaNivelEscolaridad() {
		logger.info("##################  invocando a DAO listaNivelEscolaridad ##################");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "cEscolaridad",
				catalogosDAO.listaNivelEscolaridad());
	}

	@Override
	public RespuestaGenerica listaTipoLenguaIndigena(NomCatTipoLenguaIndigenaDTO dto) {
		logger.info("##################  invocando a DAO listaTipoLenguaIndigena ##################");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "cLenguaIndigena",
				catalogosDAO.listaTipoLenguaIndigena(dto));
	}

	@Override
	public RespuestaGenerica listaProcedencia() {
		logger.info("##################  invocando a DAO listaProcedencia ##################");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "cProcedencia",
				catalogosDAO.listaProcedencia());
	}

	@Override
	public RespuestaGenerica listaSiNo(NomCatSinoDTO dto) {
		logger.info("##################  invocando a DAO listaSiNo ##################");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "cSiNo",
				catalogosDAO.listaSiNo(dto));
	}


	@Override
	@Transactional
	public RespuestaGenerica listaTipoExpediente() {
		logger.info("##################  invocando a DAO LISTA TIPO DE EXPEDIENTE ##################");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaTEX",
				catalogosDAO.listaTipoExpediente());
	}

	@Override
	public RespuestaGenerica listaPrestacion3() {

		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaPrestaciones3",
				catalogosDAO.listaPrestacion3());
	}

	@Override
	public RespuestaGenerica obtenerPrestacion3Id(Integer tipoPrestacion3Id) {

		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "prestaciones",
				catalogosDAO.obtenerPrestacion3Id(tipoPrestacion3Id));
	}

	@Override
	public RespuestaGenerica listaTipoMoneda() {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaTipoMoneda",
				catalogosDAO.listaTipoMoneda());
	}

	@Override
	public RespuestaGenerica obtenCatMetodoPago() {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "cMetodoPago",
				catalogosDAO.obtenCatMetodoPago());
	}

	@Override
	public RespuestaGenerica obtenCatBanco() {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "cBanco",
				catalogosDAO.obtenCatBanco());
	}

	@Override
	public RespuestaGenerica listaTipoAseguradora() {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaTipoAseguradora",
				catalogosDAO.listaTipoAseguradora());
	}

	@Override
	public RespuestaGenerica listaCFiscal() {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaCFiscal",
				catalogosDAO.listaCFiscal());
	}

	@Override
	public RespuestaGenerica listaCatEpisodios() {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaCEpisodios",
				catalogosDAO.listaCatEpisodios());
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerAlergiasActivas(OpcionCatalogoComunDTO dto) {

		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaCatAlergias",
				catalogosDAO.obtenerAlergiasActivas(dto));
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerImpedimentosActivos(OpcionCatalogoComunDTO dto) {

		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaCatImp",
				catalogosDAO.obtenerImpedimentosActivos(dto));
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerContraIndActivas(OpcionCatalogoComunDTO dto) {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaCatContraInd",
				catalogosDAO.obtenerContraIndActivas(dto));
	}


	@Override
	@Transactional
	public RespuestaGenerica obtenerCatFormaFarmaceutica(OpcionCatalogoComunDTO dto) {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaCatFormaFarmaceutica",
				catalogosDAO.obtenerCatFormaFarmaceutica(dto));
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerCatMedicamentoPresentaciones(OpcionCatalogoComunDTO dto) {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaCatMedicamentoPresentaciones",
				catalogosDAO.obtenerCatMedicamentoPresentaciones(dto));
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerCatGrupoTerapeutico(OpcionCatalogoComunDTO dto) {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaCatGrupoTerapeutico",
				catalogosDAO.obtenerCatGrupoTerapeutico(dto));
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerCatViaAdministracion(OpcionCatalogoComunDTO dto) {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaCatViaAdministracion",
				catalogosDAO.obtenerCatViaAdministracion(dto));
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerCatUnidadMedidaDosis(OpcionCatalogoComunDTO dto) {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaCatUnidadMedidaDosis",
				catalogosDAO.obtenerCatUnidadMedidaDosis(dto));
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerCatSituacionEconomica(OpcionCatalogoComunDTO dto) {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaCatSituacionEconomica",
				catalogosDAO.obtenerCatSituacionEconomica(dto));
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerCatDondeSeAtiende(OpcionCatalogoComunDTO dto) {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaCatDondeSeAtiende",
				catalogosDAO.obtenerCatDondeSeAtiende(dto));
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerCatTipoEvento(OpcionCatalogoComunDTO dto) {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaCatTipoEvento",
				catalogosDAO.obtenerCatTipoEvento(dto));
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerCatDestinoPrestamoExp(OpcionCatalogoComunDTO dto) {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaCatDestinoPrestamoExp",
				catalogosDAO.obtenerCatDestinoPrestamoExp(dto));
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerCatUbicacionExpediente(OpcionCatalogoComunDTO dto) {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaCatUbicacionExpediente",
				catalogosDAO.obtenerCatUbicacionExpediente(dto));
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerCatEstatusPeticion(OpcionCatalogoComunDTO dto) {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaCatEstatusPeticion",
				catalogosDAO.obtenerCatEstatusPeticion(dto));
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerCatTipoPrescripciones(OpcionCatalogoComunDTO dto) {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaTPrescripciones",
				catalogosDAO.obtenerCatTipoPrescripciones(dto));
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerCatTipoUnidadReferencia(OpcionCatalogoComunDTO dto) {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaTipoUnidadReferencia",
				catalogosDAO.obtenerCatTipoUnidadReferencia(dto));
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerCatTipoTrasladoReferencia(OpcionCatalogoComunDTO dto) {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaTipoTrasladoReferencia",
				catalogosDAO.obtenerCatTipoTrasladoReferencia(dto));
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerCatMotivoEnvioReferencia(OpcionCatalogoComunDTO dto) {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaCatMotivoEnvioReferencia",
				catalogosDAO.obtenerCatMotivoEnvioReferencia(dto));
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerCatMotivoAnulacionNse(OpcionCatalogoComunDTO dto) {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaMotivosAnulacionNSE",
				catalogosDAO.obtenerCatMotivoAnulacionNse(dto));
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerCatMotivoDescuento(OpcionCatalogoComunDTO dto) {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaMotivosDescuento",
				catalogosDAO.obtenerCatMotivoDescuento(dto));
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerCatTipoArchivo(OpcionCatalogoComunDTO dto) {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaTipoArchivo",
				catalogosDAO.obtenerCatTipoArchivo(dto));
	}

//	@Override
//	@Transactional
//	public RespuestaGenerica obtenerCatAnestesia(OpcionCatalogoComunDTO dto) {
//		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaTecnicas",
//				catalogosDAO.obtenerCatAnestesia(dto));
//	}
//
//	@Override
//	@Transactional
//	public RespuestaGenerica obtenerCatBeneficiosAnestesia(OpcionCatalogoComunDTO dto) {
//		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaBeneficios",
//				catalogosDAO.obtenerCatBeneficiosAnestesia(dto));
//	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerGusModulos() {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaModulos",
				catalogosDAO.obtenerGusModulos());
	}

	@Override
	@Transactional
	public RespuestaGenerica listaMotivoBloqueo() {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaMotivoBloqueo",
				catalogosDAO.listaMotivoBloqueo());
	}

	@Override
	@Transactional
	public RespuestaGenerica obtenerOpcionesCatalogoGenerico(OpcionCatalogoComunDTO dto) {
		String nombreTmp = catalogosDAO.obtenerNombreCatalogoGenerico(dto);
		logger.info("*******************+ NOMBRE DEL CATALOGO GENERICO " + nombreTmp);
		dto.setNombreCatalogo(nombreTmp);

		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaOpciones",
				catalogosDAO.listarOpcionesCatalogoGenerico(dto));
	}

	@Override
	@Transactional
	public RespuestaGenerica listarOpcionesProNac() {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaOpciones", catalogosDAO.listarOpcionesProNac());
	}

	@Override
	@Transactional
	public RespuestaGenerica listarCatPreIngresoPrioridad(OpcionCatalogoComunDTO dto) {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaPreIngresoPrioridad",
				catalogosDAO.listarCatPreIngresoPrioridad(dto));
	}

	@Override
	@Transactional
	public RespuestaGenerica listarCatMotivoIngreso(OpcionCatalogoComunDTO dto) {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaMotivoIngreso",
				catalogosDAO.listarCatMotivoIngreso(dto));
	}

	@Override
	@Transactional
	public RespuestaGenerica listarCatTipoIngresoHosp(OpcionCatalogoComunDTO dto) {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaTipoIngresoHosp",
				catalogosDAO.listarCatTipoIngresoHosp(dto));
	}

	@Override
	@Transactional
	public RespuestaGenerica listarCatHspProcedencia(OpcionCatalogoComunDTO dto) {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaHspProcedencia",
				catalogosDAO.listarCatHspProcedencia(dto));
	}

	@Override
	@Transactional
	public RespuestaGenerica listarEstadoProc() {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaEstadoProc",
				catalogosDAO.listarEstadoProc());
	}

	@Override
	@Transactional
	public RespuestaGenerica listarHepatitisB() {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaHepatitisB",
				catalogosDAO.listarHepatitisB());
	}

	@Override
	@Transactional
	public RespuestaGenerica listarVitaminaK() {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaVitaminaK",
				catalogosDAO.listarVitaminaK());
	}

	@Override
	@Transactional
	public RespuestaGenerica listarVitaminaA() {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaVitaminaA",
				catalogosDAO.listarVitaminaA());
	}

	@Override
	@Transactional
	public RespuestaGenerica listarTamizAuditivo() {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaTamizAuditivo",
				catalogosDAO.listarTamizAuditivo());
	}

	@Override
	@Transactional
	public RespuestaGenerica listarVacunaBcg() {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaVacunaBcg",
				catalogosDAO.listarVacunaBcg());
	}

	@Override public RespuestaGenerica listarNomCatAtencionPrenatal() {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaAtencionPrenatal",
				catalogosDAO.listarNomCatAtencionPrenatal());
	}

	@Override public RespuestaGenerica listarNomCatViveMadre() {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaVivelaMadre",
				catalogosDAO.listarNomCatViveMadre());
	}

	@Override public RespuestaGenerica listarCircunDefun() {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(),
				"datos obtenidos correctamente", "listaCircundtancias",
				catalogosDAO.listarCircunDefun());
	}

	@Override
	public RespuestaGenerica listarTipoVisita(OpcionCatalogoComunDTO dto) {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaTipoVisita",
				catalogosDAO.listarTipoVisita(dto));
	}
}
