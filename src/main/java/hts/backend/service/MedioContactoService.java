package hts.backend.service;

import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.AgenteContactoDTO;
import hts.backend.model.dto.AgenteCorreoDTO;
import hts.backend.model.dto.AgenteDireccionDTO;
import hts.backend.model.dto.AgenteTelefonoDTO;
import hts.backend.model.dto.ContactoDTO;
import hts.backend.model.dto.CorreoDTO;
import hts.backend.model.dto.DireccionDTO;
import hts.backend.model.dto.TelefonoDTO;

public interface MedioContactoService {
	
	RespuestaGenerica registrarTelefono(AgenteTelefonoDTO dto);

	RespuestaGenerica eliminarTelefono(TelefonoDTO dto);

	RespuestaGenerica registrarCorreo(AgenteCorreoDTO dto);

	RespuestaGenerica eliminarCorreo(CorreoDTO dto);
	
	RespuestaGenerica registrarDireccionPaciente(AgenteDireccionDTO dto, String clave);

	RespuestaGenerica actualizarDireccionPaciente(DireccionDTO dto,Integer agenteDireccionId, String clave);
	
	RespuestaGenerica guardaContactoPaciente(AgenteContactoDTO dto);

	RespuestaGenerica eliminaContactoPaciente(ContactoDTO dto);
}
