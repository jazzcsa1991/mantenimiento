package hts.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.PacienteDTO;
import hts.backend.service.QRService;

/**
 * 
 * @author rafaelnagano
 *
 */
@RestController
@RequestMapping({"/paciente"})
@CrossOrigin(origins = "*")
public class QRController {
	
	@Autowired
	private QRService qrSerivce;
	
	@ResponseBody
	@RequestMapping(value = "/codigoQR", method = RequestMethod.GET)
	public RespuestaGenerica obtenerQRPaciente(@RequestParam("idPaciente") int idPaciente,@RequestParam("token") String token) {
		try {
			return qrSerivce.generarQRPaciente(idPaciente,token);
		} catch (Exception e) {
			return new RespuestaGenerica(0, e.getMessage());
		}
	}

	@ResponseBody
	@RequestMapping(value = "/impresionQR", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica imprimirQRPaciente(@RequestParam("idPaciente") int idPaciente) {
		try {
			return qrSerivce.imprimirQRPaciente(idPaciente);
		} catch(Exception e) {
			return new RespuestaGenerica(0, e.getMessage());
		}

	}

}
