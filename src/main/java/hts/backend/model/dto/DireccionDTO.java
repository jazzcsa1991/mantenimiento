package hts.backend.model.dto;

import java.util.Date;
import java.util.Objects;

public class DireccionDTO {
	private Integer direccionId;
	private NomCatEntidadesDTO nomCatEntidades;
	private NomCatMunicipioDTO nomCatMunicipio;
	private NomCatLocalidadDTO nomCatLocalidad;
	private NomCatCodigoPostalDTO nomCatCodigoPostal;
	private CatTipoAsenDTO catTipoAsen;
	private NomCatPaisesDTO nomCatPaises;
	private CatVialidadDTO catVialidad;
	private String calle;
	private String noExt;
	private String noExtLetra;
	private String noInt;
	private String noIntLetra;
	private String nombreVialidad;
	private String nombreAsentamiento;
	private Integer status;
	private Date fechaRegistro;
	private String usuarioCve;
	private String cve;

	private String vialidad;
	private String asentamiento;
	private String entidad;

	public DireccionDTO() {
	}

	public String getVialidad() {
		return vialidad;
	}

	public void setVialidad(String vialidad) {
		this.vialidad = vialidad;
	}

	public String getAsentamiento() {
		return asentamiento;
	}

	public void setAsentamiento(String asentamiento) {
		this.asentamiento = asentamiento;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public Integer getDireccionId() {
		return this.direccionId;
	}

	public void setDireccionId(Integer direccionId) {
		this.direccionId = direccionId;
	}

	public NomCatEntidadesDTO getNomCatEntidades() {
		return this.nomCatEntidades;
	}

	public void setNomCatEntidades(NomCatEntidadesDTO nomCatEntidades) {
		this.nomCatEntidades = nomCatEntidades;
	}

	public NomCatMunicipioDTO getNomCatMunicipio() {
		return this.nomCatMunicipio;
	}

	public void setNomCatMunicipio(NomCatMunicipioDTO nomCatMunicipio) {
		this.nomCatMunicipio = nomCatMunicipio;
	}

	public NomCatLocalidadDTO getNomCatLocalidad() {
		return this.nomCatLocalidad;
	}

	public void setNomCatLocalidad(NomCatLocalidadDTO nomCatLocalidad) {
		this.nomCatLocalidad = nomCatLocalidad;
	}

	public NomCatCodigoPostalDTO getNomCatCodigoPostal() {
		return this.nomCatCodigoPostal;
	}

	public void setNomCatCodigoPostal(NomCatCodigoPostalDTO nomCatCodigoPostal) {
		this.nomCatCodigoPostal = nomCatCodigoPostal;
	}

	public CatTipoAsenDTO getCatTipoAsen() {
		return this.catTipoAsen;
	}

	public void setCatTipoAsen(CatTipoAsenDTO catTipoAsen) {
		this.catTipoAsen = catTipoAsen;
	}

	public NomCatPaisesDTO getNomCatPaises() {
		return this.nomCatPaises;
	}

	public void setNomCatPaises(NomCatPaisesDTO nomCatPaises) {
		this.nomCatPaises = nomCatPaises;
	}

	public CatVialidadDTO getCatVialidad() {
		return this.catVialidad;
	}

	public void setCatVialidad(CatVialidadDTO catVialidad) {
		this.catVialidad = catVialidad;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNoExt() {
		return this.noExt;
	}

	public void setNoExt(String noExt) {
		this.noExt = noExt;
	}

	public String getNoExtLetra() {
		return this.noExtLetra;
	}

	public void setNoExtLetra(String noExtLetra) {
		this.noExtLetra = noExtLetra;
	}

	public String getNoInt() {
		return this.noInt;
	}

	public void setNoInt(String noInt) {
		this.noInt = noInt;
	}

	public String getNoIntLetra() {
		return this.noIntLetra;
	}

	public void setNoIntLetra(String noIntLetra) {
		this.noIntLetra = noIntLetra;
	}

	public String getNombreVialidad() {
		return this.nombreVialidad;
	}

	public void setNombreVialidad(String nombreVialidad) {
		this.nombreVialidad = nombreVialidad;
	}

	public String getNombreAsentamiento() {
		return this.nombreAsentamiento;
	}

	public void setNombreAsentamiento(String nombreAsentamiento) {
		this.nombreAsentamiento = nombreAsentamiento;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUsuarioCve() {
		return this.usuarioCve;
	}

	public void setUsuarioCve(String usuarioCve) {
		this.usuarioCve = usuarioCve;
	}

	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	/**
	 * Valida si todas las propiedades son nulas
	 *
	 * @return true/false
	 */
	public boolean isNull() {
		return (
				this.direccionId == null &&
						this.nomCatEntidades.isNull() &&
						this.nomCatMunicipio.isNull() &&
						this.nomCatLocalidad.isNull() &&
						this.nomCatCodigoPostal.isNull() &&
						this.catTipoAsen.isNull() &&
						this.nomCatPaises.isNull() &&
						this.catVialidad.isNull() &&
						Objects.equals(this.calle, "") &&
						this.noExt == null &&
						Objects.equals(this.noExtLetra, "") &&
						this.noInt == null &&
						Objects.equals(this.noIntLetra, "") &&
						Objects.equals(this.nombreVialidad, "") &&
						Objects.equals(this.nombreAsentamiento, "") &&
						this.status == null &&
						this.fechaRegistro == null &&
						this.usuarioCve == null &&
						this.cve == null
		);
	}
}
