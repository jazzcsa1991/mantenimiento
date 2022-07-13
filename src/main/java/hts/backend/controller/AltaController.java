package hts.backend.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.PacPacienteDTO;
import hts.backend.model.dto.PacienteCortoDTO;
import hts.backend.model.dto.PacienteDesconocidoDTO;
import hts.backend.model.dto.PacienteDuplicadoDatosDTO;
import hts.backend.model.dto.PacienteLargoDTO;
import hts.backend.model.dto.PacientePreRegistroDTO;
import hts.backend.service.AltaService;

/**
 * 
 * @author rafaelnagano
 *
 */
@RestController
@RequestMapping({"/paciente"})
@CrossOrigin(origins = "*")
public class AltaController {
	
	@Autowired
	private AltaService altaPacienteService;

	//Registro de pacientes de acuerdo con la NOM-SSA-024-2012
	//Edicion y actualizacion del registro de paciente

	@ResponseBody
	@RequestMapping(value = "/registrarActualizar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registrarActualizarPaciente(@RequestBody PacienteLargoDTO dto) {
		try {
			if (dto.getIdPaciente() == null) {
				return ResponseEntity.ok(altaPacienteService.registrarPaciente(dto));
			} else {
				return ResponseEntity.ok(altaPacienteService.actualizarPaciente(dto));
			}
		} catch (RuntimeException e) {
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(Map.of("message", e.getMessage()));
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/pacienteByCurp", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica pacienteByCurp(@RequestBody PacPacienteDTO dto) {
		return altaPacienteService.pacienteByCurp(dto);
	}
	
	//Registro corto de paciente.
	
	
	@ResponseBody
	@RequestMapping(value = "/registroCorto/registrar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registrarPacienteCorto(@RequestBody PacienteCortoDTO dto) {
		try {
			return ResponseEntity.ok(altaPacienteService.registrarPacienteCorto(dto));
		} catch (RuntimeException e) {
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(Map.of("message",e.getMessage())) ;
		}
	}
	
	//Registro de paciente desconocido.
	
	@ResponseBody
	@RequestMapping(value = "/registroDesconocido/registrar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registrarPacienteDesconocido(@RequestBody PacienteDesconocidoDTO dto) {
		try {
			return ResponseEntity.ok(altaPacienteService.registrarPacienteDesconocido(dto));
		} catch (RuntimeException e) {
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(Map.of("message", e.getMessage()));
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/pre-registro-paciente", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica preRegistrarPaciente(@RequestBody PacientePreRegistroDTO dto) {
		try {
			return altaPacienteService.preRegistrarPaciente(dto);
		} catch (RuntimeException e) {
			return new RespuestaGenerica(0, e.getMessage());
		}
	}

}
