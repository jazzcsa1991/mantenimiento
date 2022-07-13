package hts.backend.entity;

import hts.backend.entity.PacPaciente;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lenovo3 on 18/07/2017.
 */
@Entity
@Table(name = "pac_paciente_archivo")
public class PacPacienteArchivo implements java.io.Serializable{
		private static final long serialVersionUID = 1L;
	private CatTipoArchivo tipoArchivoId;
	private Integer pacienteArchivoId;
	private String alfrescoId;
	private Integer estatus;
	private String usuarioRegistro;
	private Date fechaRegistro;
	private PacPaciente idPaciente;
	private Set<TrsNseUnicaOcasion> trsNseUnicaOcasion = new HashSet<TrsNseUnicaOcasion>(0);

	@ManyToOne @JoinColumn(name = "TIPO_ARCHIVO_ID", referencedColumnName = "TIPO_ARCHIVO_ID", nullable = false)
	public CatTipoArchivo getTipoArchivoId() {
		return tipoArchivoId;
	}

	public void setTipoArchivoId(CatTipoArchivo tipoArchivoId) {
		this.tipoArchivoId = tipoArchivoId;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PACIENTE_ARCHIVO_ID", nullable = false, precision = 0) public Integer getPacienteArchivoId() {
		return pacienteArchivoId;
	}

	public void setPacienteArchivoId(Integer pacienteArchivoId) {
		this.pacienteArchivoId = pacienteArchivoId;
	}


	@Basic @Column(name = "ALFRESCO_ID", nullable = false, length = 250) public String getAlfrescoId() {
		return alfrescoId;
	}

	public void setAlfrescoId(String alfrescoId) {
		this.alfrescoId = alfrescoId;
	}

	@Basic @Column(name = "ESTATUS", nullable = false, precision = 0) public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@Basic @Column(name = "USUARIO_REGISTRO", nullable = false, length = 20) public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Basic @Column(name = "FECHA_REGISTRO", nullable = false) public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@ManyToOne @JoinColumn(name = "ID_PACIENTE", referencedColumnName = "ID_PACIENTE")

	public PacPaciente getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(PacPaciente idPaciente) {
		this.idPaciente = idPaciente;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pacPacienteArchivo")
	public Set<TrsNseUnicaOcasion> getTrsNseUnicaOcasion() {
		return trsNseUnicaOcasion;
	}

	public void setTrsNseUnicaOcasion(Set<TrsNseUnicaOcasion> trsNseUnicaOcasion) {
		this.trsNseUnicaOcasion = trsNseUnicaOcasion;
	}
}
