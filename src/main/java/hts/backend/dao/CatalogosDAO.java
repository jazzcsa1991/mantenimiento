package hts.backend.dao;

import java.util.List;

import hts.backend.model.dto.CatTipoAsenDTO;
import hts.backend.model.dto.CatVialidadDTO;
import hts.backend.model.dto.CatalogoDTO;
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
import hts.backend.model.dto.EntidadCPDTO;
import hts.backend.model.dto.FactorRHDTO;
import hts.backend.model.dto.MunicipioCPDTO;



public interface CatalogosDAO extends GenericHibernateDAO {
	
	List<NomCatPaisesDTO> listaPaises();
	
	List<NomCatEntidadesDTO> listaEntidadesByPaisID(NomCatPaisesDTO dto);
	
	List<NomCatMunicipioDTO> listaMunicipiosByCveEntidad(NomCatEntidadesDTO dto);
	
	List<NomCatLocalidadDTO> listaLocalidadesByCveEntMun(NomCatMunicipioDTO dto);
	
	List<NomCatCodigoPostalDTO> listaCodPostalByCveEntMun(NomCatMunicipioDTO dto);
	
	List<NomCatNacionalidadesDTO> listaNacionalidades();
	
	List<CatTipoAsenDTO> listaTipoAsentamiento();
	
	List<CatVialidadDTO> listaVialidad();
	
	List<NomCatSexoDTO> listaSexo();
	
	List<NomCatSexoDTO> listaSexoResumen();
	
	List<NomCatReligionDTO> listaReligion();
	
	List<NomCatEstadoCivilDTO> listaEstadoCivil(NomCatEstadoCivilDTO dto);
	
	List<NomCatOcupacionDTO> listaOcupacion();
	
	List<NomCatEscolaridadDTO> listaNivelEscolaridad();
	
	List<NomCatTipoLenguaIndigenaDTO> listaTipoLenguaIndigena(NomCatTipoLenguaIndigenaDTO dto);
	
	List<NomCatSinoDTO> listaSiNo(NomCatSinoDTO dto);

	List<CatalogoDTO> obtenerCatalogoTipoBeneficiario();
	
	MunicipioCPDTO obtenerMunicipioPorCodigoPostal(String codigoPostal);
	
	EntidadCPDTO obtenerUbicacionPorCodigoPostal(String codigoPostal);

	List<FactorRHDTO> listaFactorRH();

	Object listaProcedencia();

	Object listaTipoSangre();
}
