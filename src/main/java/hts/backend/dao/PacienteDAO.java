package hts.backend.dao;

import java.util.List;

import hts.backend.entity.CatEstatusExpediente;
import hts.backend.entity.CatTipoExpediente;
import hts.backend.entity.CatUbicacionExpediente;
import hts.backend.entity.NomCatMunicipio;
import hts.backend.model.dto.AgenteContactoDTO;
import hts.backend.model.dto.CatalogosDTO;
import hts.backend.model.dto.ContactoDTO;
import hts.backend.model.dto.DomicilioDTO;
import hts.backend.model.dto.PacAseguradoraDTO;
import hts.backend.model.dto.PacPacienteDTO;
import hts.backend.model.dto.PacienteDTO;
import hts.backend.model.dto.PacienteDuplicadoDatosDTO;
import hts.backend.model.CurpRequest;

public interface PacienteDAO extends GenericHibernateDAO {
	
NomCatMunicipio obtenerMunicipioByEdo(String estadCve, String municipioCve);
	
	Integer getTipoRegistrobyDesc(String cadena);
	
	CatTipoExpediente obtenerTipoExpedienteDefault();
	
	CatEstatusExpediente obtenerCatEstatusExpediente(Integer id);

	CatUbicacionExpediente obterCatUbicacionExpediente(Integer id);
	
	PacPacienteDTO pacienteByCurp(PacPacienteDTO dto);
	
	List<CatalogosDTO> getProcedenciaByDefault();

	List<CatalogosDTO> getEntidadByDefault();

	List<CatalogosDTO> getNacionalidadByDefault();

	List<CatalogosDTO> getSexoByDefault();
	
	PacienteDuplicadoDatosDTO consultarDatosPaciente(int idPaciente);
	
	int guardaContactoPaciente(AgenteContactoDTO dto);

	int eliminaContactoPaciente(ContactoDTO dto);
	
	List<PacienteDTO> ListaBusquedaPaciente(PacienteDTO dto);
	
	List<Integer> obtenerEventoAcitivoPaciente(Integer pacienteId);
	
	PacAseguradoraDTO obtenerAseguradoraByPaciente(Integer pacienteId, Integer hospitalId);
	
	PacienteDuplicadoDatosDTO consultarDatosPacienteQR(int idPaciente);
	
	PacienteDuplicadoDatosDTO consultarDatosPacienteCURP(int idPaciente);
	
	int validaExistenciaCurp(final CurpRequest curp);
	
	Integer consultaIdPacientePorExpediente(String expediente);

	List<DomicilioDTO> consultaDomiciliosPaciente(Integer idPaciente);

	Integer consultaIdPacientePorBiometricos(String token);
}
