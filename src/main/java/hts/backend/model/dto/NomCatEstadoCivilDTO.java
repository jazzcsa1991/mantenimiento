package hts.backend.model.dto;

import java.util.HashSet;
import java.util.Set;

public class NomCatEstadoCivilDTO implements java.io.Serializable, EntidadDTO {
	private static final long serialVersionUID = 1L;

	private Integer estadoCivilId;
	private String cve;
	private String nombre;
	private Integer guiaId;
	private Integer idiomaAppId;
	private Set<PacPacienteDTO> pacPacientes = new HashSet<PacPacienteDTO>(0);
	private Set<ContactoDTO> contactos = new HashSet<ContactoDTO>(0);

	public Integer getEstadoCivilId() {
		return this.estadoCivilId;
	}

	public void setEstadoCivilId(Integer estadoCivilId) {
		this.estadoCivilId = estadoCivilId;
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
		return getEstadoCivilId();
	}

}