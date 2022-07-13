package hts.backend.model.dto;

/**
 * Created by SASA Desarrollo on 25/10/2017.
 */
public class DirecctorioDTO {
	private Integer admProfGralId;
	private String nombre;
	private String materno;
	private String paterno;
	private String noEmpleado;
	private String tipoRecurso;
	private String curp;
	private Integer personalInterno;
	private String anioRecidencia;
	private String espRecidencia;

	public Integer getAdmProfGralId() {
		return admProfGralId;
	}

	public void setAdmProfGralId(Integer admProfGralId) {
		this.admProfGralId = admProfGralId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getNoEmpleado() {
		return noEmpleado;
	}

	public void setNoEmpleado(String noEmpleado) {
		this.noEmpleado = noEmpleado;
	}

	public String getTipoRecurso() {
		return tipoRecurso;
	}

	public void setTipoRecurso(String tipoRecurso) {
		this.tipoRecurso = tipoRecurso;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public Integer getPersonalInterno() {
		return personalInterno;
	}

	public void setPersonalInterno(Integer personalInterno) {
		this.personalInterno = personalInterno;
	}

	public String getAnioRecidencia() {
		return anioRecidencia;
	}

	public void setAnioRecidencia(String anioRecidencia) {
		this.anioRecidencia = anioRecidencia;
	}

	public String getEspRecidencia() {
		return espRecidencia;
	}

	public void setEspRecidencia(String espRecidencia) {
		this.espRecidencia = espRecidencia;
	}
}
