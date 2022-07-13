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
import hts.backend.model.dto.PacEventoAlertaDTO;
import hts.backend.model.dto.PacEventoDTO;
import hts.backend.service.AlertaService;


/**
 * 
 * @author rafaelnagano
 *
 */
@RestController
@RequestMapping({"/alertas"})
@CrossOrigin(origins = "*")
public class AlertaController {
	
	@Autowired
	private AlertaService alertaService;
	
	/**
	 * Guarda las alertas del sistema
	 */
	@ResponseBody
	@RequestMapping(value = "/guardar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica guardarAlerta(@RequestBody PacEventoDTO dto) {
		return alertaService.guardarEventoAlerta(dto);
	}

	/**
	 * Anula las alertas del sistema
	 */
	@ResponseBody
	@RequestMapping(value = "/anular", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGenerica anularEventoAlerta(@RequestBody PacEventoAlertaDTO dto) {
		return alertaService.anularEventoAlerta(dto);
	}

}
