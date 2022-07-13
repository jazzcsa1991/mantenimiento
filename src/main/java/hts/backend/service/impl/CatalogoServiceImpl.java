package hts.backend.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import hts.backend.dao.CatalogosDAO;
import hts.backend.model.EstatusResponse;
import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.NomCatEntidadesDTO;
import hts.backend.model.dto.NomCatEstadoCivilDTO;
import hts.backend.model.dto.NomCatMunicipioDTO;
import hts.backend.model.dto.NomCatPaisesDTO;
import hts.backend.model.dto.NomCatSinoDTO;
import hts.backend.model.dto.NomCatTipoLenguaIndigenaDTO;
import hts.backend.service.CatalogoService;
import hts.backend.model.dto.EntidadCPDTO;
import hts.backend.model.dto.MunicipioCPDTO;
import hts.backend.model.dto.UbicacionDTO;


@Service
public class CatalogoServiceImpl implements CatalogoService {
	
	private static final Logger logger = LoggerFactory.getLogger(CatalogoServiceImpl.class);

	@Resource
	private CatalogosDAO catalogosDAO;
	
	/**********************************************************************************************
	 ************************ CATALOGOS RELACIONADOS CON PACIENTE ********************************
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
	
	@Override
	public RespuestaGenerica listaSexo() {
		logger.info("##################  invocando a DAO listaSexo ##################");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "cSexo",
				catalogosDAO.listaSexo());
	}
	
	@Override
	public RespuestaGenerica listaSexoResumen() {
		logger.info("##################  invocando a DAO listaSexo ##################");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "cSexo",
				catalogosDAO.listaSexoResumen());
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
	public RespuestaGenerica listaSiNo(NomCatSinoDTO dto) {
		logger.info("##################  invocando a DAO listaSiNo ##################");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "cSiNo",
				catalogosDAO.listaSiNo(dto));
	}
	
	@Override
	public RespuestaGenerica obtenerCatalogoTipoBeneficiario() {
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "cTipoBeneficiario",
				catalogosDAO.obtenerCatalogoTipoBeneficiario());
	}
	
	@Override
	public RespuestaGenerica obtenerUbicacionPorCodigoPostal(String codigoPostal) {
		MunicipioCPDTO municipio = catalogosDAO.obtenerMunicipioPorCodigoPostal(codigoPostal);
		EntidadCPDTO entidad = catalogosDAO.obtenerUbicacionPorCodigoPostal(codigoPostal);
		
		UbicacionDTO ubicacion = new UbicacionDTO();
		ubicacion.setEntidad(entidad);
		ubicacion.setMunicipio(municipio);
		
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "cUbicacion",
				ubicacion);
	}

	@Override
	public RespuestaGenerica listaProcedencia() {
		logger.info("##################  invocando a DAO listaProcedencia ##################");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "cProcedencia",
				catalogosDAO.listaProcedencia());
	}
	
	@Override
	public RespuestaGenerica listaTipoSangre() {
		logger.info("##################  invocando a DAO listaTipoSangre ##################");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "cSangre",
				catalogosDAO.listaTipoSangre());
	}

	@Override
	public RespuestaGenerica obtenerCatalogoFactorRH() {
		logger.info("##################  invocando a DAO listaFactorRH ##################");
		return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "cFactorRH",
				catalogosDAO.listaFactorRH());
	}

}
