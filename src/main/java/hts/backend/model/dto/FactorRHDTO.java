package hts.backend.model.dto;

public class FactorRHDTO {
	private int idFactorRH;
	private String cveFactorRH;
	private String descripcion;
		
	public FactorRHDTO(){}
	
	public FactorRHDTO(int idFactorRH, String cveFactorRH, String descripcion) {
		super();
		this.idFactorRH = idFactorRH;
		this.cveFactorRH = cveFactorRH;
		this.descripcion = descripcion;
	}
	public int getIdFactorRH() {
		return idFactorRH;
	}
	public void setIdFactorRH(int idFactorRH) {
		this.idFactorRH = idFactorRH;
	}
	public String getCveFactorRH() {
		return cveFactorRH;
	}
	public void setCveFactorRH(String cveFactorRH) {
		this.cveFactorRH = cveFactorRH;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
