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
import hts.backend.model.dto.AgenteContactoDTO;
import hts.backend.model.dto.AgenteCorreoDTO;
import hts.backend.model.dto.AgenteDireccionDTO;
import hts.backend.model.dto.AgenteTelefonoDTO;
import hts.backend.model.dto.ContactoDTO;
import hts.backend.model.dto.CorreoDTO;
import hts.backend.model.dto.TelefonoDTO;
import hts.backend.service.MedioContactoService;


/**
 * 
 * @author rafaelnagano
 *
 */
@RestController
@RequestMapping({"/paciente"})
@CrossOrigin(origins = "*")
public class MedioContactoController {
	
	@Autowired
	private MedioContactoService medioContactoService;
	
	//TELEFONOS

	@ResponseBody
	@RequestMapping(value = "/telefonos/registrar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica registrarTelefono(@RequestBody AgenteTelefonoDTO dto) {
		return medioContactoService.registrarTelefono(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/telefonos/eliminar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica eliminarTelefono(@RequestBody TelefonoDTO dto) {
		return medioContactoService.eliminarTelefono(dto);
	}


	// CORREOS ---------------------------------------------------------

	@ResponseBody
	@RequestMapping(value = "/correos/registrar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica registrarCorreo(@RequestBody AgenteCorreoDTO dto) {
		return medioContactoService.registrarCorreo(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/correos/eliminar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica eliminarCorreo(@RequestBody CorreoDTO dto) {
		return medioContactoService.eliminarCorreo(dto);
	}
	
	// DIRECCIONES -----------------------------------------------------
	

	@ResponseBody
	@RequestMapping(value = "/direcciones/actual/registrarActualizar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica registrarDireccionActual(@RequestBody AgenteDireccionDTO dto) {

		if (dto.getDireccion().getDireccionId() == null) {
			return medioContactoService.registrarDireccionPaciente(dto, "Normal");
		} else {
			return medioContactoService.actualizarDireccionPaciente(dto.getDireccion(),dto.getAgenteId(), "Normal");
		}
	}

	@ResponseBody
	@RequestMapping(value = "/direcciones/alternativa/registrarActualizar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica registrarDireccionAlternativa(@RequestBody AgenteDireccionDTO dto) {
		if (dto.getDireccion().getDireccionId() == null) {
			return medioContactoService.registrarDireccionPaciente(dto, "Otra");
		} else {
			return medioContactoService.actualizarDireccionPaciente(dto.getDireccion(),dto.getAgenteId(), "Otra");
		}
	}
	
	// CONTACTOS ------------------------------------------------------
	
	@ResponseBody
	@RequestMapping(value = "/contactos/registrarActualizar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica registrarActualizarContactoPaciente(@RequestBody AgenteContactoDTO dto) {
		return medioContactoService.guardaContactoPaciente(dto);
	}

	@ResponseBody
	@RequestMapping(value = "/contactos/eliminar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica eliminarContactoPaciente(@RequestBody ContactoDTO dto) {
		return medioContactoService.eliminaContactoPaciente(dto);
	}


}
