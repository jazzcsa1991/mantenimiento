package hts.backend.model.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class NomCatNacionalidadesDTO implements java.io.Serializable , EntidadDTO{
	private static final long serialVersionUID = 1L;
	private Integer nomCatNacionalidadesId;
	private String codigoPais;
	private String pais;
	private String cveNacionalidad;
	private Integer indicaDefault;
	private Integer status;
	private String usuarioCve;
	private Date fechaRegistro;
	private Set<AdmPersonalDTO> admProfSaludGrals = new HashSet<AdmPersonalDTO>(0);

	public NomCatNacionalidadesDTO() {
	}

	public NomCatNacionalidadesDTO(Integer nomCatNacionalidadesId, String codigoPais, String pais,
			String cveNacionalidad, Integer indicaDefault, Integer status, String usuarioCve,
			Date fechaRegistro) {
		this.nomCatNacionalidadesId = nomCatNacionalidadesId;
		this.codigoPais = codigoPais;
		this.pais = pais;
		this.cveNacionalidad = cveNacionalidad;
		this.indicaDefault = indicaDefault;
		this.status = status;
		this.usuarioCve = usuarioCve;
		this.fechaRegistro = fechaRegistro;
	}

	public NomCatNacionalidadesDTO(Integer nomCatNacionalidadesId, String codigoPais, String pais,
			String cveNacionalidad, Integer indicaDefault, Integer status, String usuarioCve, Date fechaRegistro,
			Set<AdmPersonalDTO> admProfSaludGrals) {
		this.nomCatNacionalidadesId = nomCatNacionalidadesId;
		this.codigoPais = codigoPais;
		this.pais = pais;
		this.cveNacionalidad = cveNacionalidad;
		this.indicaDefault = indicaDefault;
		this.status = status;
		this.usuarioCve = usuarioCve;
		this.fechaRegistro = fechaRegistro;
		this.admProfSaludGrals = admProfSaludGrals;
	}

	public Integer getNomCatNacionalidadesId() {
		return this.nomCatNacionalidadesId;
	}

	public void setNomCatNacionalidadesId(Integer nomCatNacionalidadesId) {
		this.nomCatNacionalidadesId = nomCatNacionalidadesId;
	}

	public String getCodigoPais() {
		return this.codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCveNacionalidad() {
		return this.cveNacionalidad;
	}

	public void setCveNacionalidad(String cveNacionalidad) {
		this.cveNacionalidad = cveNacionalidad;
	}

	public Integer getIndicaDefault() {
		return this.indicaDefault;
	}

	public void setIndicaDefault(Integer indicaDefault) {
		this.indicaDefault = indicaDefault;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUsuarioCve() {
		return this.usuarioCve;
	}

	public void setUsuarioCve(String usuarioCve) {
		this.usuarioCve = usuarioCve;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Set<AdmPersonalDTO> getAdmProfSaludGrals() {
		return this.admProfSaludGrals;
	}

	public void setAdmProfSaludGrals(Set<AdmPersonalDTO> admProfSaludGrals) {
		this.admProfSaludGrals = admProfSaludGrals;
	}

	@Override
	public Integer getId() {
		return getNomCatNacionalidadesId();
	}

}
