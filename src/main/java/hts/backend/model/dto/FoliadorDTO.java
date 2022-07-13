package hts.backend.model.dto;

public class FoliadorDTO {
	private Integer id;
	private String secuencia;
	private String clave;
	private String nombre;
	private Integer tipoFolio;
	private Integer ceros;
	private Integer hospitalId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(String secuencia) {
		this.secuencia = secuencia;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTipoFolio() {
		return tipoFolio;
	}

	public void setTipoFolio(Integer tipoFolio) {
		this.tipoFolio = tipoFolio;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Integer getCeros() {
		return ceros;
	}

	public void setCeros(Integer ceros) {
		this.ceros = ceros;
	}
}