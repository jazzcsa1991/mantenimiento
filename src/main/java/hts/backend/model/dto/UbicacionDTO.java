package hts.backend.model.dto;


public class UbicacionDTO {
	
	private EntidadCPDTO entidad;
	
	private MunicipioCPDTO municipio;

	public EntidadCPDTO getEntidad() {
		return entidad;
	}

	public void setEntidad(EntidadCPDTO entidad) {
		this.entidad = entidad;
	}

	public MunicipioCPDTO getMunicipio() {
		return municipio;
	}

	public void setMunicipio(MunicipioCPDTO municipio) {
		this.municipio = municipio;
	}

}