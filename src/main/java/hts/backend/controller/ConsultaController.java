package hts.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.PacienteDTO;
import hts.backend.service.ConsultaService;
import hts.backend.model.CurpRequest;


/**
 * 
 * @author rafaelnagano
 *
 */
@RestController
@RequestMapping({"/paciente"})
@CrossOrigin(origins = "*")
public class ConsultaController {
	
	@Autowired
	private ConsultaService consultaService;
	
	@ResponseBody
	@RequestMapping(value = "/validaExistenciaCurp", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica validaExistenciaCurp(@RequestBody CurpRequest curp) {
		return consultaService.validaExistenciaCurp(curp);
	}
	
	@ResponseBody
	@RequestMapping(value = "/consultarCURP", method = RequestMethod.GET)
	public RespuestaGenerica consultarDatosPacienteCURP(@RequestParam("idPaciente") int idPaciente,@RequestParam("curp") String curp) {
		try {
			return consultaService.consultarDatosPacienteCURP(idPaciente,curp);
		} catch (Exception e) {
			return new RespuestaGenerica(0, e.getMessage());
		}
	}
	
	@RequestMapping(value = "/consultar-por-id/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica consultarDatosPaciente(@PathVariable("id") Integer idPaciente) {
		return consultaService.consultarDatosPaciente(idPaciente);
	}
	
	@ResponseBody
	@RequestMapping(value = "/ListaBusquedaPaciente", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica ListaBusquedaPaciente(@RequestBody PacienteDTO dto) {
		try {
			return consultaService.ListaBusquedaPaciente(dto);
		} catch (Exception e) {
			return new RespuestaGenerica(0, e.getMessage());
		}
	}
	
	@RequestMapping(value = "/consultar-por-expediente/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica consultarDatosPaciente(@PathVariable("id") String expediente) {
		return consultaService.consultarDatosPacientePorExpediente(expediente);
	}
	
	@ResponseBody
	@RequestMapping(value = "/consulta-domicilios/{idPaciente}", method = RequestMethod.GET)
	public RespuestaGenerica consultarDatosPacienteCURP(@PathVariable("idPaciente") Integer idPaciente) {
		try {
			return consultaService.consultarDomiciliosPaciente(idPaciente);
		} catch (Exception e) {
			return new RespuestaGenerica(0, e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/consultaPacientePorBiometrico", method = RequestMethod.GET)
	public RespuestaGenerica consultaPacientePorBiometrico(@RequestParam("token") String token) {
		try {
			return consultaService.consultarDatosPacientePorBiometricos(token);
		} catch (Exception e) {
			return new RespuestaGenerica(0, e.getMessage());
		}
	}
	
}
