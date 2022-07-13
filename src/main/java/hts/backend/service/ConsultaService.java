package hts.backend.service;

import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.PacienteDTO;
import hts.backend.model.CurpRequest;

public interface ConsultaService {
	
RespuestaGenerica ListaBusquedaPaciente(PacienteDTO dto);
	
	RespuestaGenerica consultarDatosPaciente(Integer idPaciente);
	
	RespuestaGenerica consultarDatosPacienteQR(Integer idPaciente);

	RespuestaGenerica consultarDatosPacienteCURP(Integer idPaciente, String curp);
	
	RespuestaGenerica consultarDatosPacientePorExpediente(String expediente);
	
	RespuestaGenerica validaExistenciaCurp(CurpRequest curp);

	RespuestaGenerica consultarDomiciliosPaciente(Integer idPaciente);

	RespuestaGenerica consultarDatosPacientePorBiometricos(String token);

}
