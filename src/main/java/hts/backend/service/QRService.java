package hts.backend.service;

import java.net.MalformedURLException;

import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.PacienteDTO;


public interface QRService {
	
	RespuestaGenerica generarQRPaciente(int idPaciente,String token) throws RuntimeException, MalformedURLException;

	RespuestaGenerica imprimirQRPaciente(int idPaciente);

}
