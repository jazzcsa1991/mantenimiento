package hts.backend.model.dto;

public class NomCatSinoDTO implements java.io.Serializable, EntidadDTO {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Integer sinoId;
	private String cve;
	private String nombre;
	private Integer guiaId;
	private Integer idiomaAppId;

	public NomCatSinoDTO() {
	}

	public NomCatSinoDTO(Integer sinoId, String cve, String nombre) {
		this.sinoId = sinoId;
		this.cve = cve;
		this.nombre = nombre;
	}

	public NomCatSinoDTO(Integer sinoId, String cve, String nombre, Integer guiaId, Integer idiomaAppId) {
		this.sinoId = sinoId;
		this.cve = cve;
		this.nombre = nombre;
		this.guiaId = guiaId;
		this.idiomaAppId = idiomaAppId;
	}

	public Integer getSinoId() {
		return this.sinoId;
	}

	public void setSinoId(Integer sinoId) {
		this.sinoId = sinoId;
	}

	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getGuiaId() {
		return this.guiaId;
	}

	public void setGuiaId(Integer guiaId) {
		this.guiaId = guiaId;
	}

	public Integer getIdiomaAppId() {
		return this.idiomaAppId;
	}

	public void setIdiomaAppId(Integer idiomaAppId) {
		this.idiomaAppId = idiomaAppId;
	}

	@Override
	public Integer getId() {
		return getSinoId();
	}

}