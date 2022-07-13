package hts.backend.service;

import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.NomCatEntidadesDTO;
import hts.backend.model.dto.NomCatEstadoCivilDTO;
import hts.backend.model.dto.NomCatMunicipioDTO;
import hts.backend.model.dto.NomCatPaisesDTO;
import hts.backend.model.dto.NomCatSinoDTO;
import hts.backend.model.dto.NomCatTipoLenguaIndigenaDTO;



public interface CatalogoService {

    /**********************************************************************************************
     ************************ CATALOGOS RELACIONADOS CON DIRECCION ********************************
     **********************************************************************************************/

	RespuestaGenerica listaPaises();

    RespuestaGenerica listaEntidadesByPaisID(NomCatPaisesDTO dto);

    RespuestaGenerica listaMunicipiosByCveEntidad(NomCatEntidadesDTO dto);

    RespuestaGenerica listaLocalidadesByCveEntMun(NomCatMunicipioDTO dto);

    RespuestaGenerica listaCodPostalByCveEntMun(NomCatMunicipioDTO dto);

    RespuestaGenerica listaNacionalidades();

    RespuestaGenerica listaTipoAsentamiento();

    RespuestaGenerica listaVialidad();
    
    RespuestaGenerica obtenerUbicacionPorCodigoPostal(String codigoPostal);
	
    /**********************************************************************************************
     ************************ CATALOGOS RELACIONADOS CON PACIENTE ********************************
     **********************************************************************************************/

    RespuestaGenerica listaSexo();

    RespuestaGenerica listaSexoResumen();

    RespuestaGenerica listaReligion();

    RespuestaGenerica listaEstadoCivil(NomCatEstadoCivilDTO dto);

    RespuestaGenerica listaOcupacion();

    RespuestaGenerica listaNivelEscolaridad();

    RespuestaGenerica listaTipoLenguaIndigena(NomCatTipoLenguaIndigenaDTO dto);

    RespuestaGenerica listaSiNo(NomCatSinoDTO dto);
    
    RespuestaGenerica obtenerCatalogoTipoBeneficiario();
    
    RespuestaGenerica listaProcedencia();
    
    RespuestaGenerica listaTipoSangre();

	RespuestaGenerica obtenerCatalogoFactorRH();	
	
}
