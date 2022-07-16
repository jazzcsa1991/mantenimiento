package hts.backend.controller;


import hts.backend.service.CatalogosService;
import hts.backend.model.dto.OpcionCatalogoComunDTO;
import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.ServicioEspecialidadDTO;
import hts.backend.model.dto.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping({"/catalogos"})
public class CatalogosController {
	private static final Log logger = LogFactory.getLog(CatalogosController.class);

	private final CatalogosService catalogosService;

	@Autowired
	public CatalogosController(CatalogosService catalogosService) {
		this.catalogosService = catalogosService;
	}


	@ResponseBody
	@RequestMapping(value = "/obtenCatIdioma", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenOpcionesCatalogoIdioma(HttpServletRequest request,
														 HttpServletResponse response) {
		logger.info("############# OBTENIENDO EL CATALOGO DE IDIOMA  #####################");
		return catalogosService.obtenerCatalogoIdioma();
	}


	@ResponseBody
	@RequestMapping(value = "/obtenCatImpedimentos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenOpcionesCatalogoImpedimentos(HttpServletRequest request,
															   HttpServletResponse response) {
		logger.info("############# OBTENIENDO EL CATALOGO DE IMPEDIMENTOS #####################");

		return catalogosService.obtenerCatalogoImpedimentos();
	}


	@ResponseBody
	@RequestMapping(value = "/obtenServicios", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenServicios() {
		logger.info("############# OBTENIENDO EL CATALOGO DE SERVICIOS #####################");

		return catalogosService.obtenerServicios();
	}


	@ResponseBody
	@RequestMapping(value = "/obtenEspecialidadServicio", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenServiciosEspecialidad(@RequestBody ServicioEspecialidadDTO dto) {
		logger.info("############# OBTENIENDO EL CATALOGO DE SERVICIOS #####################");

		return catalogosService.obtenerEspecialidad(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/obtenerMotivoAnulacionCirugia", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerMotivoAnulacionCirugia() {
		return catalogosService.obtenerMotivoAnulacionCirugia();
	}

	@ResponseBody
	@RequestMapping(value = "/obtenCatPais", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenOpcionesCatalogoPais(HttpServletRequest request,
													   HttpServletResponse response) {
		logger.info("############# OBTENIENDO EL CATALOGO DE PAIS  #####################");
		return catalogosService.obtenerCatalogoPais();
	}

	@ResponseBody
	@RequestMapping(value = "/obtenCatEstadoPais", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenOpcionesCatalogoEstadoPais(HttpServletRequest request,
															 HttpServletResponse response) {
		logger.info("############# OBTENIENDO EL CATALOGO DE ESTADOS POR PAIS SETEADO POR DEFAULT #####################");
		return catalogosService.obtenerCatalogoEstadoPais();
	}


	/**********************************************************************************************
	 ************************ CATALOGOS RELACIONADOS CON DIRECCION ********************************
	 **********************************************************************************************/

	@ResponseBody
	@RequestMapping(value = "/listaPaises", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listaPaises() {
		logger.info("######## LISTA TELEFONO ###############");

		RespuestaGenerica respuesta = null;
		try {

			respuesta = catalogosService.listaPaises();
		} catch (Exception e) {
			e.getMessage();
		}

		return respuesta;
	}


	@ResponseBody
	@RequestMapping(value = "/listaEntidadesByPaisID", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listaEntidadesByPaisID(@RequestBody NomCatPaisesDTO dto) {
		logger.info("######## LISTA listaEntidadesByPaisID ###############");

		RespuestaGenerica respuesta = null;
		try {

			respuesta = catalogosService.listaEntidadesByPaisID(dto);
		} catch (Exception e) {
			e.getMessage();
		}

		return respuesta;
	}

	@ResponseBody
	@RequestMapping(value = "/listaMunicipiosByCveEntidad", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listaEntidadesByPaisID(@RequestBody NomCatEntidadesDTO dto) {
		logger.info("######## LISTA listaMunicipiosByCveEntidad ###############");

		RespuestaGenerica respuesta = null;
		try {

			respuesta = catalogosService.listaMunicipiosByCveEntidad(dto);
		} catch (Exception e) {
			e.getMessage();
		}

		return respuesta;
	}

	@ResponseBody
	@RequestMapping(value = "/listaLocalidadesByCveEntMun", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listaLocalidadesByCveEntMun(@RequestBody NomCatMunicipioDTO dto) {
		logger.info("######## LISTA listaLocalidadesByCveEntMun ###############");

		RespuestaGenerica respuesta = null;
		try {

			respuesta = catalogosService.listaLocalidadesByCveEntMun(dto);
		} catch (Exception e) {
			e.getMessage();
		}

		return respuesta;
	}


	@ResponseBody
	@RequestMapping(value = "/listaCodPostalByCveEntMun", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listaCodPostalByCveEntMun(@RequestBody NomCatMunicipioDTO dto) {
		logger.info("######## LISTA listaCodPostalByCveEntMun ###############");

		RespuestaGenerica respuesta = null;
		try {

			respuesta = catalogosService.listaCodPostalByCveEntMun(dto);
		} catch (Exception e) {
			e.getMessage();
		}

		return respuesta;
	}

	@ResponseBody
	@RequestMapping(value = "/listaNacionalidades", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listaNacionalidades() {
		logger.info("######## LISTA listaNacionalidades ###############");

		RespuestaGenerica respuesta = null;
		try {

			respuesta = catalogosService.listaNacionalidades();
		} catch (Exception e) {
			e.getMessage();
		}

		return respuesta;
	}

	@ResponseBody
	@RequestMapping(value = "/listaTipoAsentamiento", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listaTipoAsentamiento() {
		logger.info("######## LISTA listaTipoAsentamiento ###############");

		RespuestaGenerica respuesta = null;
		try {

			respuesta = catalogosService.listaTipoAsentamiento();
		} catch (Exception e) {
			e.getMessage();
		}

		return respuesta;
	}


	@ResponseBody
	@RequestMapping(value = "/listaVialidad", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listaVialidad() {
		logger.info("######## LISTA listaVialidad ###############");

		RespuestaGenerica respuesta = null;
		try {

			respuesta = catalogosService.listaVialidad();
		} catch (Exception e) {
			e.getMessage();
		}

		return respuesta;
	}


	/**********************************************************************************************
	 ************************ CATALOGOS RELACIONADOS CON PACIENTE ********************************
	 **********************************************************************************************/

	@ResponseBody
	@RequestMapping(value = "/listaSexo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listaSexo() {
		logger.info("######## LISTA listaSexo ###############");

		RespuestaGenerica respuesta = null;
		try {

			respuesta = catalogosService.listaSexo();
		} catch (Exception e) {
			e.getMessage();
		}

		return respuesta;
	}


	@ResponseBody
	@RequestMapping(value = "/listaTipoSangre", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listaTipoSangre() {
		logger.info("######## LISTA listaTipoSangre ###############");

		RespuestaGenerica respuesta = null;
		try {

			respuesta = catalogosService.listaTipoSangre();
		} catch (Exception e) {
			e.getMessage();
		}

		return respuesta;
	}


	@ResponseBody
	@RequestMapping(value = "/listaReligion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listaReligion() {
		logger.info("######## LISTA listaReligion ###############");

		RespuestaGenerica respuesta = null;
		try {

			respuesta = catalogosService.listaReligion();
		} catch (Exception e) {
			e.getMessage();
		}

		return respuesta;
	}

	@ResponseBody
	@RequestMapping(value = "/listaEstadoCivil", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listaEstadoCivil(@RequestBody NomCatEstadoCivilDTO dto) {
		logger.info("######## LISTA listaEstadoCivil ###############");

		RespuestaGenerica respuesta = null;
		try {

			respuesta = catalogosService.listaEstadoCivil(dto);
		} catch (Exception e) {
			e.getMessage();
		}

		return respuesta;
	}

	@ResponseBody
	@RequestMapping(value = "/listaOcupacion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listaOcupacion() {
		logger.info("######## LISTA listaOcupacion ###############");

		RespuestaGenerica respuesta = null;
		try {

			respuesta = catalogosService.listaOcupacion();
		} catch (Exception e) {
			e.getMessage();
		}

		return respuesta;
	}


	@ResponseBody
	@RequestMapping(value = "/listaNivelEscolaridad", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listaNivelEscolaridad() {
		logger.info("######## LISTA listaNivelEscolaridad ###############");

		RespuestaGenerica respuesta = null;
		try {

			respuesta = catalogosService.listaNivelEscolaridad();
		} catch (Exception e) {
			e.getMessage();
		}

		return respuesta;
	}


	@ResponseBody
	@RequestMapping(value = "/listaTipoLenguaIndigena", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listaTipoLenguaIndigena(@RequestBody NomCatTipoLenguaIndigenaDTO dto) {
		logger.info("######## LISTA listaTipoLenguaIndigena ###############");

		RespuestaGenerica respuesta = null;
		try {

			respuesta = catalogosService.listaTipoLenguaIndigena(dto);
		} catch (Exception e) {
			e.getMessage();
		}

		return respuesta;
	}


	@ResponseBody
	@RequestMapping(value = "/listaProcedencia", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listaProcedencia() {
		logger.info("######## LISTA listaProcedencia ###############");

		RespuestaGenerica respuesta = null;
		try {

			respuesta = catalogosService.listaProcedencia();
		} catch (Exception e) {
			e.getMessage();
		}

		return respuesta;
	}


	@ResponseBody
	@RequestMapping(value = "/listaSiNo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listaSiNo(@RequestBody NomCatSinoDTO dto) {
		logger.info("######## LISTA listaSiNo ###############");

		RespuestaGenerica respuesta = null;
		try {

			respuesta = catalogosService.listaSiNo(dto);
		} catch (Exception e) {
			e.getMessage();
		}

		return respuesta;
	}


	@ResponseBody
	@RequestMapping(value = "/obtenCatTipoExp", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenCatTipoExp(HttpServletRequest request,
											 HttpServletResponse response) {
		logger.info("############# OBTENIENDO EL CATALOGO DE tipo de expediente  #####################");
		return catalogosService.listaTipoExpediente();
	}


	@ResponseBody
	@RequestMapping(value = "/obtenCatalogoPrestacion3", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenCatalogoPrestacion3(@RequestBody OpcionCatalogoComunDTO dto) {
		logger.info("############# OBTENIENDO EL CATALOGO#####################");
		return catalogosService.listaPrestacion3();
	}

	@ResponseBody
	@RequestMapping(value = "/obtenPrestacion3Id", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenPrestacion3Id(@RequestBody OpcionCatalogoComunDTO dto) {
		logger.info("############# OBTENIENDO EL CATALOGO  #####################");
		return catalogosService.obtenerPrestacion3Id(dto.getIdOpcion());
	}

	@ResponseBody
	@RequestMapping(value = "/obtenCatalogoMoneda", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenCatalogoMoneda(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.listaTipoMoneda();
	}

	@ResponseBody
	@RequestMapping(value = "/obtenCatMetodoPago", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenCatMetodoPago(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.obtenCatMetodoPago();
	}

	@ResponseBody
	@RequestMapping(value = "/obtenCatBanco", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenCatBanco(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.obtenCatBanco();
	}

	@ResponseBody
	@RequestMapping(value = "/catalogoTipoAseguradora", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica catalogoTipoAseguradora(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.listaTipoAseguradora();
	}

	@ResponseBody
	@RequestMapping(value = "/clasificacionFiscal", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica clasificacionFiscal(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.listaCFiscal();
	}

	@ResponseBody
	@RequestMapping(value = "/catalogoEpisodios", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica catalogoEpisodios(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.listaCatEpisodios();
	}

	@ResponseBody
	@RequestMapping(value = "/alergiasActivas", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica alergiasActivas(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.obtenerAlergiasActivas(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/contraIndActivas", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica contraIndActivas(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.obtenerContraIndActivas(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/impedimentosActivos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica impedimentosActivoss(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.obtenerImpedimentosActivos(dto);
	}


	@ResponseBody
	@RequestMapping(value = "/CatFormaFarmaceutica", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerCatFormaFarmaceutica(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.obtenerCatFormaFarmaceutica(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/CatMedicamentoPresentaciones", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerCatMedicamentoPresentaciones(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.obtenerCatMedicamentoPresentaciones(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/CatGrupoTerapeutico", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerCatGrupoTerapeutico(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.obtenerCatGrupoTerapeutico(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/CatViaAdministracion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerCatViaAdministracion(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.obtenerCatViaAdministracion(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/CatUnidadMedidaDosis", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerCatUnidadMedidaDosis(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.obtenerCatUnidadMedidaDosis(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/CatSituacionEconomica", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerCatSituacionEconomica(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.obtenerCatSituacionEconomica(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/CatDondeSeAtiende", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerCatDondeSeAtiende(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.obtenerCatDondeSeAtiende(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/CatTipoEvento", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerCatTipoEvento(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.obtenerCatTipoEvento(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/CatDestinoPrestamoExp", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerCatDestinoPrestamoExp(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.obtenerCatDestinoPrestamoExp(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/CatUbicacionExpediente", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerCatUbicacionExpediente(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.obtenerCatUbicacionExpediente(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/CatEstatusPeticion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerCatEstatusPeticion(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.obtenerCatEstatusPeticion(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/CatTipoPrescripcion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerCatTipoPrescripcion(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.obtenerCatTipoPrescripciones(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/CatTipoUnidadReferencia", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerCatTipoUnidadReferencia(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.obtenerCatTipoUnidadReferencia(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/CatTipoTrasladoReferencia", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerCatTipoTrasladoReferencia(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.obtenerCatTipoTrasladoReferencia(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/CatMotivoEnvioReferencia", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerCatMotivoEnvioReferencia(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.obtenerCatMotivoEnvioReferencia(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/CatMotivoAnulacionNse", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerCatMotivoAnulacionNse(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.obtenerCatMotivoAnulacionNse(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/CatMotivoDescuento", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerCatMotivoDescuento(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.obtenerCatMotivoDescuento(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/CatTipoArchivo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerCatTipoArchivo(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.obtenerCatTipoArchivo(dto);
	}

//	@ResponseBody
//	@RequestMapping(value = "/CatAnestesia", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//	public RespuestaGenerica obtenerCatAnestesia(@RequestBody OpcionCatalogoComunDTO dto) {
//		return catalogosService.obtenerCatAnestesia(dto);
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/CatBeneficiosAnestesia", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//	public RespuestaGenerica obtenerCatBeneficiosAnestesia(@RequestBody OpcionCatalogoComunDTO dto) {
//		return catalogosService.obtenerCatBeneficiosAnestesia(dto);
//	}

	@ResponseBody
	@RequestMapping(value = "/modulos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerGusModulos() {
		return catalogosService.obtenerGusModulos();
	}

	@ResponseBody
	@RequestMapping(value = "/motivoBloqueo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listaMotivoBloqueo() {
		return catalogosService.listaMotivoBloqueo();
	}


	@ResponseBody
	@RequestMapping(value = "/CatPreIngresoPrioridad", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerCatPreIngresoPrioridad(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.listarCatPreIngresoPrioridad(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/CatMotivoIngreso", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerCatMotivoIngresoa(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.listarCatMotivoIngreso(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/CatTipoIngresoHosp", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerCatTipoIngresoHosp(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.listarCatTipoIngresoHosp(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/CatHspProcedencia", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerCatHspProcedencia(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.listarCatHspProcedencia(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/motivoEgreso", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica motivoEgreso(@RequestBody OpcionCatalogoComunDTO dto) {
		dto.setIdOpcion(2);
		return catalogosService.obtenerOpcionesCatalogoGenerico(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/pronosticoSalida", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica pronosticoSalida(@RequestBody OpcionCatalogoComunDTO dto) {
		dto.setIdOpcion(3);
		return catalogosService.obtenerOpcionesCatalogoGenerico(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/cattransentradasalida", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica cattransentradasalida(@RequestBody OpcionCatalogoComunDTO dto) {
		dto.setIdOpcion(9);
		return catalogosService.obtenerOpcionesCatalogoGenerico(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/catdestinoegresohosp", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica catdestinoegresohosp(@RequestBody OpcionCatalogoComunDTO dto) {

		dto.setIdOpcion(10);
		return catalogosService.obtenerOpcionesCatalogoGenerico(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/catdestinoegresourg", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica catdestinoegresourg(@RequestBody OpcionCatalogoComunDTO dto) {

		dto.setIdOpcion(22);
		return catalogosService.obtenerOpcionesCatalogoGenerico(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/procedimientoNac", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerProcedimientoNac(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.listarOpcionesProNac();
	}

	@ResponseBody
	@RequestMapping(value = "/tipoProducto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerTipoProducto(@RequestBody OpcionCatalogoComunDTO dto) {
		dto.setIdOpcion(5);
		return catalogosService.obtenerOpcionesCatalogoGenerico(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/forceps", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerForceps(@RequestBody OpcionCatalogoComunDTO dto) {
		dto.setIdOpcion(6);
		return catalogosService.obtenerOpcionesCatalogoGenerico(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/atendidoParto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerAtendidoParto(@RequestBody OpcionCatalogoComunDTO dto) {
		dto.setIdOpcion(7);
		return catalogosService.obtenerOpcionesCatalogoGenerico(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/lugarNac", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerLugarNac(@RequestBody OpcionCatalogoComunDTO dto) {
		dto.setIdOpcion(8);
		return catalogosService.obtenerOpcionesCatalogoGenerico(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/motivoUrgencia", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerMotivoUrgencia(@RequestBody OpcionCatalogoComunDTO dto) {
		dto.setIdOpcion(11);
		return catalogosService.obtenerOpcionesCatalogoGenerico(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/EdasUrgencia", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerEdasUrgencia(@RequestBody OpcionCatalogoComunDTO dto) {
		dto.setIdOpcion(12);
		return catalogosService.obtenerOpcionesCatalogoGenerico(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/IrasUrgencia", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerIrasUrgencia(@RequestBody OpcionCatalogoComunDTO dto) {
		dto.setIdOpcion(13);
		return catalogosService.obtenerOpcionesCatalogoGenerico(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/procedIngresoUrgencia", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerProcedIngresoUrgencia(@RequestBody OpcionCatalogoComunDTO dto) {
		dto.setIdOpcion(14);
		return catalogosService.obtenerOpcionesCatalogoGenerico(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/tipoUrgencia", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerTipoUrgencia(@RequestBody OpcionCatalogoComunDTO dto) {
		dto.setIdOpcion(15);
		return catalogosService.obtenerOpcionesCatalogoGenerico(dto);
	}


	@ResponseBody
	@RequestMapping(value = "/estadoProc", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listarEstadoProc() {
		return catalogosService.listarEstadoProc();
	}

	@ResponseBody
	@RequestMapping(value = "/hepatitisB", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listarHepatitisB() {
		return catalogosService.listarHepatitisB();
	}

	@ResponseBody
	@RequestMapping(value = "/vitaminaK", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listarVitaminaK() {
		return catalogosService.listarVitaminaK();
	}

	@ResponseBody
	@RequestMapping(value = "/vitaminaA", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listarVitaminaA() {
		return catalogosService.listarVitaminaA();
	}

	@ResponseBody
	@RequestMapping(value = "/tamizAuditivo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listarTamizAuditivo() {
		return catalogosService.listarTamizAuditivo();
	}

	@ResponseBody
	@RequestMapping(value = "/vacunaBcg", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listarVacunaBcg() {
		return catalogosService.listarVacunaBcg();
	}

	@ResponseBody
	@RequestMapping(value = "/destinoRn", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerdestinoRn(@RequestBody OpcionCatalogoComunDTO dto) {
		dto.setIdOpcion(17);
		return catalogosService.obtenerOpcionesCatalogoGenerico(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/tipoNacAnterior", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenertipoNacAnterior(@RequestBody OpcionCatalogoComunDTO dto) {
		dto.setIdOpcion(18);
		return catalogosService.obtenerOpcionesCatalogoGenerico(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/trimesrtre", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenertrimesrtre(@RequestBody OpcionCatalogoComunDTO dto) {
		dto.setIdOpcion(19);
		return catalogosService.obtenerOpcionesCatalogoGenerico(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/cuidadosClinicosTipo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica cuidadosClinicos(@RequestBody OpcionCatalogoComunDTO dto) {
		dto.setIdOpcion(20);
		return catalogosService.obtenerOpcionesCatalogoGenerico(dto);
	}


	@ResponseBody
	@RequestMapping(value = "/atencionPrenatal", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listarNomCatAtencionPrenatal() {
		return catalogosService.listarNomCatAtencionPrenatal();
	}

	@ResponseBody
	@RequestMapping(value = "/vivelaMadre", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listarNomCatViveMadre() {
		return catalogosService.listarNomCatViveMadre();
	}

	@ResponseBody
	@RequestMapping(value = "/motivoTraslado", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenerMotivoTraslado(@RequestBody OpcionCatalogoComunDTO dto) {
		dto.setIdOpcion(21);
		return catalogosService.obtenerOpcionesCatalogoGenerico(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/prioridad", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica obtenePrioridad(@RequestBody OpcionCatalogoComunDTO dto) {
		dto.setIdOpcion(23);
		return catalogosService.obtenerOpcionesCatalogoGenerico(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/rol_eq_medico", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica rolEqMedico(@RequestBody OpcionCatalogoComunDTO dto) {
		dto.setIdOpcion(24);
		return catalogosService.obtenerOpcionesCatalogoGenerico(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/cirugia/clasificacion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica clasificacionCirugia(@RequestBody OpcionCatalogoComunDTO dto) {
		dto.setIdOpcion(25);
		return catalogosService.obtenerOpcionesCatalogoGenerico(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/quir/destino", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica destinoQuir(@RequestBody OpcionCatalogoComunDTO dto) {
		dto.setIdOpcion(26);
		return catalogosService.obtenerOpcionesCatalogoGenerico(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/listarCircunstancias", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listarCircunstancias() {
		return catalogosService.listarCircunDefun();
	}

	@ResponseBody
	@RequestMapping(value = "/tipoVisita", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listarTipoVisita(@RequestBody OpcionCatalogoComunDTO dto) {
		return catalogosService.listarTipoVisita(dto);
	}
}
