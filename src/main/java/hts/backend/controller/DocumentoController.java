package hts.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.AgenteDocumentoDTO;
import hts.backend.model.dto.DocumentoDTO;
import hts.backend.model.dto.PacNotaDTO;
import hts.backend.service.DocumentoService;

/**
 * 
 * @author rafaelnagano
 *
 */
@RestController
@RequestMapping({"/paciente"})
@CrossOrigin(origins = "*")
public class DocumentoController {
	
	@Autowired
	private DocumentoService documentoService;
	
	@ResponseBody
	@RequestMapping(value = "/documentos/registrar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica registrarDocumento(@RequestBody AgenteDocumentoDTO dto) {
		return documentoService.registrarDocumento(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/documentos/eliminar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica eliminarDocumento(@RequestBody DocumentoDTO dto) {
		return documentoService.eliminarDocumento(dto);
	}
	
	@ResponseBody
	@RequestMapping(value = "/notas/registrar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica registrarNota(@RequestBody PacNotaDTO dto) {
		return documentoService.registrarNota(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/notas/eliminar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica eliminarNota(@RequestBody PacNotaDTO dto) {
		return documentoService.eliminarNota(dto);
	}

}
