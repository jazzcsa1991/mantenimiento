package hts.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.NomCatEntidadesDTO;
import hts.backend.model.dto.NomCatEstadoCivilDTO;
import hts.backend.model.dto.NomCatMunicipioDTO;
import hts.backend.model.dto.NomCatPaisesDTO;
import hts.backend.model.dto.NomCatSinoDTO;
import hts.backend.model.dto.NomCatTipoLenguaIndigenaDTO;
import hts.backend.service.CatalogoService;

/**
 * 
 * @author rafaelnagano
 *
 */
@RestController
@RequestMapping({"/catalogo"})
public class CatalogosController {
	
private static final Logger logger = LoggerFactory.getLogger(CatalogosController.class);
	
	@Autowired
	private CatalogoService catalogosService;
	
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
	@RequestMapping(value = "/listaSexoResumen", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listaSexoResumen() {
		logger.info("######## LISTA listaSexo ###############");

		RespuestaGenerica respuesta = null;
		try {

			respuesta = catalogosService.listaSexoResumen();
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
	@RequestMapping(value = "/listaTipoBeneficiario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica listaTipoBeneficiario() {
		logger.info("######## LISTA TipoBeneficiario ###############");

		RespuestaGenerica respuesta = null;
		try {
			respuesta = catalogosService.obtenerCatalogoTipoBeneficiario();
		} catch (Exception e) {
			e.getMessage();
		}

		return respuesta;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/consulta-ubicacion-por-cp", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica consultaUbicacionPorCP(@RequestParam("codigoPostal") String codigoPostal) {
		logger.info("######## consultaUbicacionPorCP ###############");

		RespuestaGenerica respuesta = null;
		try {
			respuesta = catalogosService.obtenerUbicacionPorCodigoPostal(codigoPostal);
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
	@RequestMapping(value = "/listaFactorRh", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica consultaFactorRH() {
		logger.info("######## LISTA FactorRH ###############");

		RespuestaGenerica respuesta = null;
		try {
			respuesta = catalogosService.obtenerCatalogoFactorRH();
		} catch (Exception e) {
			e.getMessage();
		}

		return respuesta;
	}

}
