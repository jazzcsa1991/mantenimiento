package hts.backend.service;

import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.PacEventoAlertaDTO;
import hts.backend.model.dto.PacEventoDTO;

public interface AlertaService {
	
	RespuestaGenerica guardarEventoAlerta(PacEventoDTO pacEvento);

	RespuestaGenerica anularEventoAlerta(PacEventoAlertaDTO dto);

}
