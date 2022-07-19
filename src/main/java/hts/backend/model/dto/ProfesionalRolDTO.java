package hts.backend.model.dto;



import com.fasterxml.jackson.annotation.JsonIgnore;
import hts.backend.entity.NomCatPerfil;
import hts.backend.entity.CatRol;
import hts.backend.entity.AdmHospital;
import hts.backend.entity.AdmPersonal;

import java.util.Date;

public class ProfesionalRolDTO {

	private Integer idProfesionalRol;
	private Integer idProfesional;
	private Integer idHospital;
	private Integer idPerfil;
	private Integer idRol;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private String nombreRol;
	private String  nombrePerfil;
	private String  nombreHospital;

	@JsonIgnore
	private AdmPersonal admPersonal;
	@JsonIgnore
	private AdmHospital admHospital;
	@JsonIgnore
	private NomCatPerfil nomCatPerfil;
	@JsonIgnore
	private CatRol catRol;


	public Integer getIdProfesionalRol() {
		return idProfesionalRol;
	}
	public void setIdProfesionalRol(Integer idProfesionalRol) {
		this.idProfesionalRol = idProfesionalRol;
	}
	public Integer getIdProfesional() {
		return idProfesional;
	}
	public void setIdProfesional(Integer idProfesional) {
		this.idProfesional = idProfesional;
	}
	public Integer getIdHospital() {
		return idHospital;
	}
	public void setIdHospital(Integer idHospital) {
		this.idHospital = idHospital;
	}
	public Integer getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}
	public Integer getIdRol() {
		return idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}
	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	public String getNombrePerfil() {
		return nombrePerfil;
	}
	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
	}
	public String getNombreHospital() {
		return nombreHospital;
	}
	public void setNombreHospital(String nombreHospital) {
		this.nombreHospital = nombreHospital;
	}
	public AdmPersonal getAdmPersonal() {
		return admPersonal;
	}
	public void setAdmPersonal(AdmPersonal admPersonal) {
		this.admPersonal = admPersonal;
	}
	public AdmHospital getAdmHospital() {
		return admHospital;
	}
	public void setAdmHospital(AdmHospital admHospital) {
		this.admHospital = admHospital;
	}
	public NomCatPerfil getNomCatPerfil() {
		return nomCatPerfil;
	}
	public void setNomCatPerfil(NomCatPerfil nomCatPerfil) {
		this.nomCatPerfil = nomCatPerfil;
	}
	public CatRol getCatRol() {
		return catRol;
	}
	public void setCatRol(CatRol catRol) {
		this.catRol = catRol;
	}

}
