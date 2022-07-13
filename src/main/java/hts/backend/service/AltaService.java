package hts.backend.service;

import hts.backend.entity.PacPaciente;
import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.PacPacienteDTO;
import hts.backend.model.dto.PacienteCortoDTO;
import hts.backend.model.dto.PacienteDesconocidoDTO;
import hts.backend.model.dto.PacienteDuplicadoDatosDTO;
import hts.backend.model.dto.PacienteLargoDTO;
import hts.backend.model.dto.PacientePreRegistroDTO;

public interface AltaService {
	
	RespuestaGenerica registrarPaciente(PacienteLargoDTO dto);

	RespuestaGenerica actualizarPaciente(PacienteLargoDTO dto);

	RespuestaGenerica pacienteByCurp(PacPacienteDTO dto);

	RespuestaGenerica registrarPacienteCorto(PacienteCortoDTO dto);

	RespuestaGenerica registrarPacienteDesconocido(PacienteDesconocidoDTO dto);

	RespuestaGenerica preRegistrarPaciente(PacientePreRegistroDTO dto);

}
