package hts.backend.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "nom_cat_estado_civil")
public class NomCatEstadoCivil implements java.io.Serializable {
	private Integer estadoCivilId;
	private String cve;
	private String nombre;
	private Integer guiaId;
	private Integer idiomaAppId;

//	private Set<PacPaciente> pacPacientes = new HashSet<PacPaciente>(0);
//	private Set<Contacto> contactos = new HashSet<Contacto>(0);

	public NomCatEstadoCivil() {
	}

	public NomCatEstadoCivil(Integer estadoCivilId) {
		this.estadoCivilId = estadoCivilId;
	}


	@Id
	@Column(name = "ESTADO_CIVIL_ID", unique = true, nullable = false, precision = 22)
	public Integer getEstadoCivilId() {
		return this.estadoCivilId;
	}

	public void setEstadoCivilId(Integer estadoCivilId) {
		this.estadoCivilId = estadoCivilId;
	}


	@Column(name = "CVE", nullable = false, length = 20)
	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}


	@Column(name = "NOMBRE", nullable = false, length = 20)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Column(name = "GUIA_ID", precision = 22)
	public Integer getGuiaId() {
		return this.guiaId;
	}

	public void setGuiaId(Integer guiaId) {
		this.guiaId = guiaId;
	}


	@Column(name = "IDIOMA_APP_ID", precision = 22)
	public Integer getIdiomaAppId() {
		return this.idiomaAppId;
	}

	public void setIdiomaAppId(Integer idiomaAppId) {
		this.idiomaAppId = idiomaAppId;
	}


	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "nomCatEstadoCivil")
	public Set<PacPaciente> getPacPacientes() {
		return this.pacPacientes;
	}

	public void setPacPacientes(Set<PacPaciente> pacPacientes) {
		this.pacPacientes = pacPacientes;
	}*/


	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "nomCatEstadoCivil")
	public Set<Contacto> getContactos() {
		return this.contactos;
	}

	public void setContactos(Set<Contacto> contactos) {
		this.contactos = contactos;
	}*/
}
