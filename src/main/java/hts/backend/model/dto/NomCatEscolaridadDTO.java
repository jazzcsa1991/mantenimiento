package hts.backend.model.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class NomCatEscolaridadDTO implements java.io.Serializable, EntidadDTO {

	private static final long serialVersionUID = 1L;

	private Integer escolaridadId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistra;
	private Integer idiomaAppId;
//	private Set<PacPaciente> pacPacientes = new HashSet<PacPaciente>(0);
	private Set<ContactoDTO> contactos = new HashSet<ContactoDTO>(0);

	public NomCatEscolaridadDTO() {
	}

	public NomCatEscolaridadDTO(Integer escolaridadId, String cve, String nombre, String descripcion,
			Integer valorDefault, Integer estatus, Date fechaRegistro, String usuarioRegistra) {
		this.escolaridadId = escolaridadId;
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valorDefault = valorDefault;
		this.estatus = estatus;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistra = usuarioRegistra;
	}

	public NomCatEscolaridadDTO(Integer escolaridadId, String cve, String nombre, String descripcion,
			Integer valorDefault, Integer estatus, Date fechaRegistro, String usuarioRegistra,
			Integer idiomaAppId) {
		this.escolaridadId = escolaridadId;
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valorDefault = valorDefault;
		this.estatus = estatus;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistra = usuarioRegistra;
		this.idiomaAppId = idiomaAppId;
//		this.pacPacientes = pacPacientes;
	}

	public NomCatEscolaridadDTO(Integer escolaridadId, String cve, String nombre, String descripcion,
			Integer valorDefault, Integer estatus, Date fechaRegistro, String usuarioRegistra,
			Integer idiomaAppId, Set<ContactoDTO> contactos) {
		this.escolaridadId = escolaridadId;
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valorDefault = valorDefault;
		this.estatus = estatus;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistra = usuarioRegistra;
		this.idiomaAppId = idiomaAppId;
//		this.pacPacientes = pacPacientes;
		this.contactos=contactos;
	}

	public Integer getEscolaridadId() {
		return this.escolaridadId;
	}

	public void setEscolaridadId(Integer escolaridadId) {
		this.escolaridadId = escolaridadId;
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

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getValorDefault() {
		return this.valorDefault;
	}

	public void setValorDefault(Integer valorDefault) {
		this.valorDefault = valorDefault;
	}

	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUsuarioRegistra() {
		return this.usuarioRegistra;
	}

	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}

	public Integer getIdiomaAppId() {
		return this.idiomaAppId;
	}

	public void setIdiomaAppId(Integer idiomaAppId) {
		this.idiomaAppId = idiomaAppId;
	}

	public Set<ContactoDTO> getContactos() {
		return this.contactos;
	}

	public void setContactos(Set<ContactoDTO> contactos) {
		this.contactos = contactos;
	}

	@Override
	public Integer getId() {
		return getEscolaridadId();
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nomCatEscolaridad")
//	public Set<PacPaciente> getPacPacientes() {
//		return this.pacPacientes;
//	}
//
//	public void setPacPacientes(Set<PacPaciente> pacPacientes) {
//		this.pacPacientes = pacPacientes;
//	}

}

