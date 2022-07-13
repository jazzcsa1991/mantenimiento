package hts.backend.model.dto;


public class NomCatTipoLenguaIndigenaDTO implements java.io.Serializable, EntidadDTO {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Integer tipoLenguaIndigenaId;
	private String cve;
	private String nombre;
	private Integer guiaId;
	private Integer idiomaAppId;

	public NomCatTipoLenguaIndigenaDTO() {
	}

	public NomCatTipoLenguaIndigenaDTO(Integer tipoLenguaIndigenaId, String cve, String nombre) {
		this.tipoLenguaIndigenaId = tipoLenguaIndigenaId;
		this.cve = cve;
		this.nombre = nombre;
	}

	public NomCatTipoLenguaIndigenaDTO(Integer tipoLenguaIndigenaId, String cve, String nombre, Integer guiaId,
			Integer idiomaAppId) {
		this.tipoLenguaIndigenaId = tipoLenguaIndigenaId;
		this.cve = cve;
		this.nombre = nombre;
		this.guiaId = guiaId;
		this.idiomaAppId = idiomaAppId;
	}

	public Integer getTipoLenguaIndigenaId() {
		return this.tipoLenguaIndigenaId;
	}

	public void setTipoLenguaIndigenaId(Integer tipoLenguaIndigenaId) {
		this.tipoLenguaIndigenaId = tipoLenguaIndigenaId;
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
		return getTipoLenguaIndigenaId();
	}

}
