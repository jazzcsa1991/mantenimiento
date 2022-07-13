package hts.backend.model.dto;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Hugo A. Cruz Trujillo (hugo.cruzt@gmail.com)
 * @version 1.0
 */
public class CatalogoDTO {

	private int id;
	private String name;
	private Integer idOpcion;
	private String NombreOpcion;
	private String descripcion;
	private int estatusOpcion;
	private int normativa;
	private Integer indicaDefault;


	private String idCatPostal;
	private String jur;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Integer getIdOpcion() {
		return idOpcion;
	}

	public void setIdOpcion(Integer idOpcion) {
		this.idOpcion = idOpcion;
	}

	public String getNombreOpcion() {
		return NombreOpcion;
	}

	public void setNombreOpcion(String nombreOpcion) {
		NombreOpcion = nombreOpcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstatusOpcion() {
		return estatusOpcion;
	}

	public void setEstatusOpcion(int estatusOpcion) {
		this.estatusOpcion = estatusOpcion;
	}

	public int getNormativa() {
		return normativa;
	}

	public void setNormativa(int normativa) {
		this.normativa = normativa;
	}

	public Integer getIndicaDefault() {
		return indicaDefault;
	}

	public void setIndicaDefault(Integer indicaDefault) {
		this.indicaDefault = indicaDefault;
	}

	public String getIdCatPostal() {
		return idCatPostal;
	}

	public void setIdCatPostal(String idCatPostal) {
		this.idCatPostal = idCatPostal;
	}

	public String getJur() {
		return jur;
	}

	public void setJur(String jur) {
		this.jur = jur;
	}


}
