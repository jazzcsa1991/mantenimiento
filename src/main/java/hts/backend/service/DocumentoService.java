package hts.backend.service;

import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.AgenteDocumentoDTO;
import hts.backend.model.dto.DocumentoDTO;
import hts.backend.model.dto.PacNotaDTO;

public interface DocumentoService {
	
	RespuestaGenerica registrarDocumento(AgenteDocumentoDTO dto);

	RespuestaGenerica eliminarDocumento(DocumentoDTO dto);

	RespuestaGenerica registrarNota(PacNotaDTO dto);

	RespuestaGenerica eliminarNota(PacNotaDTO dto);

}
