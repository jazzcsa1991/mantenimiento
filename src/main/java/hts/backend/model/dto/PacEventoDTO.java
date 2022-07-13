package hts.backend.model.dto;

import java.util.List;

public class PacEventoDTO {

	public Integer eventoId;
	public Integer interfaz;
	public List<PacEventoAlertaDTO> pacEventoAlertaDTOS;


	public Integer getInterfaz() {
		return interfaz;
	}

	public void setInterfaz(Integer interfaz) {
		this.interfaz = interfaz;
	}

	public Integer getEventoId() {
		return eventoId;
	}

	public void setEventoId(Integer eventoId) {
		this.eventoId = eventoId;
	}

	public List<PacEventoAlertaDTO> getPacEventoAlertaDTOS() {
		return pacEventoAlertaDTOS;
	}

	public void setPacEventoAlertaDTOS(List<PacEventoAlertaDTO> pacEventoAlertaDTOS) {
		this.pacEventoAlertaDTOS = pacEventoAlertaDTOS;
	}
}
