package hts.backend.model.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class NomCatOcupacionDTO implements java.io.Serializable, EntidadDTO {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Integer ocupacionId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefualt;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistra;
	private Integer idiomaAppId;
	private Set<PacPacienteDTO> pacPacientes = new HashSet<PacPacienteDTO>(0);
	private Set<ContactoDTO> contactos = new HashSet<ContactoDTO>(0);

	public NomCatOcupacionDTO() {
	}

	public NomCatOcupacionDTO(Integer ocupacionId, String cve, String nombre, String descripcion,
			Integer valorDefualt, Integer estatus, Date fechaRegistro, String usuarioRegistra) {
		this.ocupacionId = ocupacionId;
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valorDefualt = valorDefualt;
		this.estatus = estatus;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistra = usuarioRegistra;
	}

	public NomCatOcupacionDTO(Integer ocupacionId, String cve, String nombre, String descripcion,
			Integer valorDefualt, Integer estatus, Date fechaRegistro, String usuarioRegistra,
			Integer idiomaAppId, Set<PacPacienteDTO> pacPacientes,Set<ContactoDTO> contactos) {
		this.ocupacionId = ocupacionId;
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valorDefualt = valorDefualt;
		this.estatus = estatus;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistra = usuarioRegistra;
		this.idiomaAppId = idiomaAppId;
		this.pacPacientes = pacPacientes;
		this.contactos=contactos;
	}


	public NomCatOcupacionDTO(Integer ocupacionId, String cve, String nombre, String descripcion,
			Integer valorDefualt, Integer estatus, Date fechaRegistro, String usuarioRegistra,
			Integer idiomaAppId, Set<PacPacienteDTO> pacPacientes) {
		this.ocupacionId = ocupacionId;
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valorDefualt = valorDefualt;
		this.estatus = estatus;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistra = usuarioRegistra;
		this.idiomaAppId = idiomaAppId;
		this.pacPacientes = pacPacientes;
	}

	public Integer getOcupacionId() {
		return this.ocupacionId;
	}

	public void setOcupacionId(Integer ocupacionId) {
		this.ocupacionId = ocupacionId;
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

	public Integer getValorDefualt() {
		return this.valorDefualt;
	}

	public void setValorDefualt(Integer valorDefualt) {
		this.valorDefualt = valorDefualt;
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

	public Set<PacPacienteDTO> getPacPacientes() {
		return this.pacPacientes;
	}

	public void setPacPacientes(Set<PacPacienteDTO> pacPacientes) {
		this.pacPacientes = pacPacientes;
	}

	public Set<ContactoDTO> getContactos() {
		return this.contactos;
	}

	public void setContactos(Set<ContactoDTO> contactos) {
		this.contactos = contactos;
	}


	@Override
	public Integer getId() {

		return getOcupacionId();
	}

}
