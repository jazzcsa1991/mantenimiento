package hts.backend.model.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hts.backend.model.dto.AdmFuncionDTO;
import hts.backend.entity.NomCatPerfil;
import hts.backend.entity.AdmHospital;

public class RolDTO {

	private int id;
	private int perfilId;
	private String perfilNombre;
	private String nombre;
	private String descripcion;
	private int  estatus;
	private Date fechaRegistro;
	private String usuario;
	@JsonIgnore private NomCatPerfil perfil;
	@JsonIgnore private AdmHospital hospital;
	private int hospitalId;
	@JsonIgnore private Set<AdmFuncionDTO> admFuncions = new HashSet<AdmFuncionDTO>(0);

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPerfilId() {
		return perfilId;
	}
	public void setPerfilId(int perfilId) {
		this.perfilId = perfilId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getEstatus() {
		return estatus;
	}
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public NomCatPerfil getPerfil() {
		return perfil;
	}
	public void setPerfil(NomCatPerfil perfil) {
		this.perfil = perfil;
	}
	public String getPerfilNombre() {
		return perfilNombre;
	}
	public void setPerfilNombre(String perfilNombre) {
		this.perfilNombre = perfilNombre;
	}
	public AdmHospital getHospital() {
		return hospital;
	}
	public void setHospital(AdmHospital hospital) {
		this.hospital = hospital;
	}
	public int getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Set<AdmFuncionDTO> getAdmFuncions() {
		return admFuncions;
	}
	public void setAdmFuncions(Set<AdmFuncionDTO> admFuncions) {
		this.admFuncions = admFuncions;
	}
}
