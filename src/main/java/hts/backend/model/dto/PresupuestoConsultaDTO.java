package hts.backend.model.dto;

import java.util.List;

public class PresupuestoConsultaDTO {

	private List<PresupuestoPaquetesDTO> paquetes;
	private List<PresupuestoPrestacionesDTO> prestaciones;

	public List<PresupuestoPaquetesDTO> getPaquetes() {
		return paquetes;
	}

	public void setPaquetes(List<PresupuestoPaquetesDTO> paquetes) {
		this.paquetes = paquetes;
	}

	public List<PresupuestoPrestacionesDTO> getPrestaciones() {
		return prestaciones;
	}

	public void setPrestaciones(List<PresupuestoPrestacionesDTO> prestaciones) {
		this.prestaciones = prestaciones;
	}
}
